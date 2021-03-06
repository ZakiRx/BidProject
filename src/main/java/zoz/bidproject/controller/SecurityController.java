package zoz.bidproject.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;

import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import zoz.bidproject.converter.UserSignUpDtoConverter;
import zoz.bidproject.dto.UserAuthenticationDto;
import zoz.bidproject.dto.UserSignUpDto;
import zoz.bidproject.model.Buyer;
import zoz.bidproject.model.Role;
import zoz.bidproject.security.JwtProvider;
import zoz.bidproject.service.BuyerService;

@RestController
@RequestMapping("/")
public class SecurityController {

	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtProvider jwtProvider;
	@Autowired
	private BuyerService buyerService;
	private UserSignUpDtoConverter userSignUpDtoConverter;

	
	
	@PostMapping
	@RequestMapping("login")
	public ResponseEntity<String> login(@Valid @RequestBody UserAuthenticationDto user, HttpServletResponse response) {
		JSONObject json = new JSONObject();
		try {
			Authentication authentication = authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

			if (authentication.isAuthenticated()) {

				String username = user.getUsername();
				List<Role> roles = (List<Role>) buyerService.getBuyerByUserName(username).getRoles();
				String token = jwtProvider.createToken(username, roles);
				json.put("token", token);
				final Cookie cookie = new Cookie("auth", token);
				cookie.setHttpOnly(true);
				cookie.setMaxAge(Integer.MAX_VALUE);
				cookie.setPath("/");

				response.addCookie(cookie);

				return new ResponseEntity<String>(json.toString(), null, HttpStatus.OK);
			}
		} catch (JSONException e) {
			try {
				json.put("exception", e.getMessage());
				return new ResponseEntity<String>(json.toString(), null, HttpStatus.UNAUTHORIZED);
			} catch (JSONException e1) {
				e1.printStackTrace();

				return null;
			}
		}
		return null;

	}

	@PostMapping
	@RequestMapping("signup")
	public ResponseEntity<Buyer> signUp(HttpServletResponse response, @Valid @RequestBody UserSignUpDto user)
			throws IOException {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		if (authentication != null && authentication.isAuthenticated()
				&& !(authentication instanceof AnonymousAuthenticationToken)) {
			response.sendRedirect("/buyer/");
			return null;
		}
		userSignUpDtoConverter = new UserSignUpDtoConverter();
		Buyer buyer = userSignUpDtoConverter.dtoToEntity(user);
		if (buyer != null) {
			buyerService.newBuyer(buyer);
			return new ResponseEntity<Buyer>(buyer, HttpStatus.OK);
		} else {
			return new ResponseEntity<Buyer>(buyer, HttpStatus.BAD_REQUEST);
		}

	}
	@PostMapping
	@RequestMapping(path="logoff",method = RequestMethod.POST)
	public ResponseEntity<Object> logOut(HttpServletRequest request, HttpServletResponse response)
			throws JSONException {
		System.out.println("test");
		Cookie[] cookies = request.getCookies();
		
		JSONObject json = null;
		for (Cookie cookie : cookies) {
			if ("auth".equals(cookie.getName())) {
				System.out.println("test");
				cookie.setValue("");
				cookie.setPath("/");
				cookie.setMaxAge(0);
				response.addCookie(cookie);
				json = new JSONObject().put("message", "logout succeded");
				return new ResponseEntity<Object>(json.toString(), null, HttpStatus.OK);

			}
		}
		System.out.println("test");
		json = new JSONObject().put("message", "logout not succeded");
		return new ResponseEntity<Object>(json.toString(), null, HttpStatus.BAD_GATEWAY);

	}
	
	

}
