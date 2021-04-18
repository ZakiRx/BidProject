package zoz.bidproject.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zoz.bidproject.model.Pack;
import zoz.bidproject.model.Seller;
import zoz.bidproject.model.Subscription;
import zoz.bidproject.repositories.jpa.PackRepository;
import zoz.bidproject.repositories.jpa.SellerRepository;
import zoz.bidproject.repositories.jpa.SubscriptionRepository;

@Service
public class SubscriptionService {
	@Autowired
	private SubscriptionRepository subscriptionRepository;
	@Autowired
	private PackRepository packRepository;
	@Autowired
	private SellerService sellerService;
	
	public Subscription newSubscription(Pack pack,Long id) {
		Seller seller =sellerService.getSeller(id);                 
		Subscription subscription = new Subscription(null, new Date(), new Date(), true, seller, pack);
	 	subscriptionRepository.save(subscription);
		return subscription;
	}
	
	public List<Subscription> getAllSubscriptions(){
		
		return subscriptionRepository.findAll();
	}
	
	
	
}
