package zoz.bidproject.security;

import java.io.IOException;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;

public class JwtFilter extends OncePerRequestFilter {

	private JwtProvider jwtProvider;

	public JwtFilter(JwtProvider jwtProvider) {
		this.jwtProvider = jwtProvider;
	}

	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String token = null;
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			if("auth".equals(cookie.getName())) {
				token=cookie.getValue();
			}
		
		}
		
		if(token!=null) {
			Claims claims = jwtProvider.getClaimsFromToken(token);
			if(claims!= null && !claims.getExpiration().before(new Date())) {
				Authentication authentication = jwtProvider.getAuthentication(claims.getSubject());
				if(authentication.isAuthenticated()) {
					SecurityContextHolder.getContext().setAuthentication(authentication);
				}
				else {
					response.reset();
					response.getWriter().write("not connected. "+HttpServletResponse.SC_UNAUTHORIZED);
				}
				
			}else {
				SecurityContextHolder.clearContext();
				response.reset();
				response.setContentType("application/json");
				response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				response.getWriter().write("token  invalid or expired . "+HttpServletResponse.SC_UNAUTHORIZED);
			}
					
		}else {
			SecurityContextHolder.clearContext();
			response.reset();
			response.setContentType("application/json");
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		     //response.getWriter().write("token not found"+HttpServletResponse.SC_UNAUTHORIZED);
		}
		System.out.println("Create Token  When Send request from /login | check Autorize in header Http when send other request  ");
		filterChain.doFilter(request, response);
		
	}

}
