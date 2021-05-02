package zoz.bidproject.security;

import java.util.Base64;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import ch.qos.logback.classic.Logger;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import zoz.bidproject.model.Role;
import zoz.bidproject.service.BuyerDetailsService;

@Component
public class JwtProvider {

	@Autowired
	private BuyerDetailsService buyerDetailsService;
	private String secretKey = "BidProject51";
	private int days = 7;
	private Long durationTime = (long) (days * 86400000);

	@PostConstruct
	public void init() {
		secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
	}

	public String createToken(String username, List<Role> roles) {
		Claims claims = Jwts.claims().setSubject(username);
		claims.put("auth", roles);
		Date dateNow = new Date();
		Date dateExp = new Date(dateNow.getTime() + durationTime);
		return Jwts.builder().setClaims(claims).setIssuedAt(dateNow).setExpiration(dateExp)
				.signWith(SignatureAlgorithm.HS256, secretKey).compact();
	}

	//check is valid or no expired 
	public Claims getClaimsFromToken(String token) {
		try {
			Claims claims=Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
			return claims;
		} catch (JwtException ex) {
			System.out.println(ex.getMessage());
			return null;
		}

	}
	public Authentication getAuthentication(String username) {
		try {
		    UserDetails user=buyerDetailsService.loadUserByUsername(username);
		    return new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword(),user.getAuthorities());
		} catch (JwtException ex) {
			return null;
		}

	}
}
