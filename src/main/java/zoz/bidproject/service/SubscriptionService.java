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

	public Subscription newSubscription(Pack pack, Seller seller) {
		Subscription subscription = new Subscription(null, new Date(), new Date(), true, seller, pack);
		subscriptionRepository.save(subscription);
		return subscription;
	}

	public List<Subscription> getAllSubscriptions() {

		return subscriptionRepository.findAll();
	}

	public Boolean checkSubscription(Seller seller) {
		if (seller.getSubscription() != null) {
			return true;
		}
		return false;
	}
	public Subscription getSubscriptionBySeller(Seller seller) {
		if (seller.getSubscription() != null) {
			return seller.getSubscription();
		}
		return null;
	}
	public Subscription getSubscriptionById(Long id) {
		if (subscriptionRepository.getOne(id) != null) {
			return subscriptionRepository.getOne(id);
		}
		return null;
	}

}
