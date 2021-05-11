package zoz.bidproject.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import zoz.bidproject.converter.UserSignUpDtoConverter;
import zoz.bidproject.dto.UserAuthenticationDto;
import zoz.bidproject.dto.UserSignUpDto;
import zoz.bidproject.model.Buyer;
import zoz.bidproject.model.Role;
import zoz.bidproject.repositories.jpa.BuyerRepository;
import zoz.bidproject.security.JwtProvider;
import zoz.bidproject.service.BuyerService;
import zoz.bidproject.service.RoleService;

@RestController
@Validated
public class SecurityController {

	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtProvider jwtProvider;

	@Autowired
	private BuyerService buyerService;
	
	private UserSignUpDtoConverter userSignUpDtoConverter;

	@PostMapping
	@RequestMapping("/login")
	public ResponseEntity<String> login(@Valid @RequestBody UserAuthenticationDto user) {
		JSONObject json = new JSONObject();
		try {
			Authentication authentication = authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

			if (authentication.isAuthenticated()) {

				String username = user.getUsername();
				List<Role> roles = (List<Role>) buyerService.getBuyerByUserName(username).get().getRoles();
				json.put("token", jwtProvider.createToken(username, roles));
				return new ResponseEntity<String>(json.toString(), null, HttpStatus.OK);
			}
		} catch (JSONException e ) {
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
	@RequestMapping("/signup")
	public HttpStatus signUp(HttpServletResponse response, @Valid @RequestBody UserSignUpDto user) throws IOException {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if (authentication != null && authentication.isAuthenticated() && !(authentication instanceof AnonymousAuthenticationToken)) {
			response.sendRedirect("/buyer/profile/");
			return null;
		}
		userSignUpDtoConverter = new UserSignUpDtoConverter();
		Buyer buyer=userSignUpDtoConverter.dtoToEntity(user);
		if(buyer!=null) {
			buyerService.newBuyer(buyer);
			return HttpStatus.OK;
		}else {
			return HttpStatus.BAD_REQUEST;
		}
		
	}

}
