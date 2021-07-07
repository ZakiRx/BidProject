package zoz.bidproject.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import zoz.bidproject.security.JwtConfigurer;

import zoz.bidproject.security.JwtProvider;


@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)  
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private JwtProvider jwtProvider;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable();
		http.authorizeRequests()
		.antMatchers("/login","/signup","/offer/**","/charge","/subscription/new","/pack/**").permitAll()
		.antMatchers("/user").authenticated()
		.antMatchers("/buyer/**").hasAnyAuthority("BUYER","SELLER")
		.antMatchers("/seller/**").hasAuthority("SELLER")
		.antMatchers("/bid/**").hasAuthority("BUYER")
		.anyRequest().authenticated();
		http.apply(new JwtConfigurer(jwtProvider));
		
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		// TODO Auto-generated method stub
		return super.authenticationManagerBean();
	}

	
}
