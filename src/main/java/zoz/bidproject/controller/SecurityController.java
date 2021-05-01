package zoz.bidproject.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import zoz.bidproject.dto.UserAuthenticationDto;
import zoz.bidproject.model.Role;
import zoz.bidproject.repositories.jpa.BuyerRepository;
import zoz.bidproject.security.JwtProvider;
import zoz.bidproject.service.BuyerService;
import zoz.bidproject.service.RoleService;

@RestController
public class SecurityController {

	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtProvider jwtProvider;

	@Autowired
	private BuyerService buyerService;

	@PostMapping
	@RequestMapping("/login")
	public ResponseEntity<String> login(@RequestBody UserAuthenticationDto user) {
		JSONObject json = new JSONObject();
		try {
			Authentication authentication = authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
		
			if (authentication.isAuthenticated()) {
				
				String username = user.getUsername();
				List<Role> roles = buyerService.getBuyerByUserName(username).get().getRoles();
				json.put("token", jwtProvider.createToken(username, roles));
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

}