package zoz.bidproject.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


import zoz.bidproject.service.BuyerDetailsService;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private BuyerDetailsService buyerDetailsService;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(buyerDetailsService);

	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/").permitAll()
		.antMatchers("/user").authenticated()
		.antMatchers("/buyer/**").hasAnyAuthority("BUYER","SELLER")
		.antMatchers("/seller/**").hasAuthority("SELLER")
		.and().formLogin();
	}

	
}
