package zoz.bidproject.service;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	@Autowired
	private BuyerService buyerService;
	
	public Subscription newSubscription(Pack pack, Buyer buyer) {
		Seller seller = new Seller(buyer);
		Subscription subscription = new Subscription(null, new Date(), new Date(), true, seller, pack);
		seller.setSubscription(subscription);
		buyerService.editTypeAccount("Seller", buyer);
		subscriptionRepository.save(subscription);
		
		return subscription;
	}

	public List<Subscription> getAllSubscriptions() {

		return subscriptionRepository.findAll();
	}

	public Boolean checkSubscription(Seller seller) {
		System.out.println("check in:"+seller.getSubscription());
		if (seller.getSubscription() != null) {
			if (seller.getSubscription().isEnabled()) {
				return true;
			}
			return false;
		}
		return false;
	}

	public Subscription getSubscription(Seller seller) throws Exception {
		if (seller.getSubscription() != null) {
			if (seller.getSubscription().isEnabled()) {
				return seller.getSubscription();
			} else {
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

	public void deleteSubscription(Seller seller) {

		subscriptionRepository.delete(seller.getSubscription());
	}
	public Subscription disabelSubscription(Subscription subscription) {

		subscription.setEnabled(false);
		return subscriptionRepository.save(subscription);
	}

}
