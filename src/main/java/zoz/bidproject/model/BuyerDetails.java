package zoz.bidproject.model;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Column;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class BuyerDetails implements UserDetails {
	
	private static final long serialVersionUID = 1L;
	private String userName;
	private String firstName;
	private String LastName;
	private LocalDate dateBirth;
	private String email;
	private String phoneNumber;
	private String password;
	private Boolean enabled;
	private Boolean active;
	private String accountId;
	private double balance;
	private boolean verified;
	private List<Role> roles;
	private List<GrantedAuthority> authorities;
	
	
	public BuyerDetails(Buyer buyer) {
		this.userName=buyer.getUserName();
		this.firstName=buyer.getFirstName();
		this.LastName=buyer.getLastName();
		this.dateBirth=buyer.getDateBirth();
		this.email=buyer.getEmail();
		this.password=buyer.getPassword();
		this.enabled=buyer.isEnabled();
		this.active=buyer.isActive();
		this.accountId=buyer.getAccountId();
		this.balance=buyer.getBalance();
		this.verified=buyer.isVerified();
		this.authorities=buyer.getRoles().stream().map(r->new SimpleGrantedAuthority(r.getNameRole())).collect(Collectors.toList());
		
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return this.authorities;
	}
	@Override
	public String getPassword() {
	
		return password;
	}
	@Override
	public String getUsername() {
		
		return userName;
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
}
