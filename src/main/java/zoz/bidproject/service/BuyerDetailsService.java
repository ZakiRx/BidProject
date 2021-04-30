package zoz.bidproject.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import zoz.bidproject.model.Buyer;
import zoz.bidproject.model.BuyerDetails;
import zoz.bidproject.repositories.jpa.BuyerRepository;

@Service
public class BuyerDetailsService implements UserDetailsService {

	@Autowired 
	private BuyerRepository buyerRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Buyer> buyer = buyerRepository.findOneByUsername(username);
		buyer.orElseThrow(()->new UsernameNotFoundException("User Not Found: "+username));
	
		return buyer.map(BuyerDetails::new).get();
	}
	
	
}
