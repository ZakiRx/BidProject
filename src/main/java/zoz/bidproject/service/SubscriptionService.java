package zoz.bidproject.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zoz.bidproject.model.Buyer;
import zoz.bidproject.model.Pack;
import zoz.bidproject.model.Seller;
import zoz.bidproject.model.Subscription;
import zoz.bidproject.repositories.jpa.PackRepository;
import zoz.bidproject.repositories.jpa.SellerRepository;
import zoz.bidproject.repositories.jpa.SubscriptionRepository;

/**
 * @author Zaki_Guemi
 *
 */
@Service
public class SubscriptionService {
	@Autowired
	private SubscriptionRepository subscriptionRepository;
	@Autowired
	private PackRepository packRepository;
	@Autowired
	private SellerService sellerService;

	public Subscription newSubscription(Pack pack, Buyer buyer) {
		Subscription subscription = new Subscription(null, new Date(), new Date(), true, buyer, pack);
		subscriptionRepository.save(subscription);
		Seller seller = new Seller(null, buyer.getUserName(), buyer.getFirstName(), buyer.getLastName(),
				buyer.getDateBirth(), buyer.getEmail(), buyer.getPhoneNumber(), buyer.getPassword(), buyer.isEnabled(),
				buyer.isActif(), buyer.getAccountId(), buyer.getBalance(), buyer.isVerified());
		sellerService.newSeller(seller);
		buyer.setSubscription(subscription);
		return subscription;
	}

	public List<Subscription> getAllSubscriptions() {

		return subscriptionRepository.findAll();
	}

	public Boolean checkSubscription(Seller seller) {
		if (seller.getSubscription() != null) {
			if(seller.getSubscription().isEnabled()) {
			return true;
			}
			return false;
		}
		return false;
	}

	public Subscription getSubscription(Seller seller) throws Exception {
		if (seller.getSubscription() != null ) {
			if(seller.getSubscription().isEnabled()) {
				return seller.getSubscription();
			}else {
				throw new Exception("Your Subscripe is Expired");
			}
			
		}
		return null;
	}

	public Subscription getSubscriptionById(Long id) {
		if (subscriptionRepository.getOne(id) != null) {
			return subscriptionRepository.getOne(id);
		}
		return null;
	}
	
	public void deleteSubscription(Buyer buyer) {
		
		subscriptionRepository.delete(buyer.getSubscription());
	}
	
	

}
