package zoz.bidproject.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import zoz.bidproject.model.Buyer;
import zoz.bidproject.model.Pack;
import zoz.bidproject.model.Role;
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
	private RoleService roleService;
	@Autowired
	private SellerService sellerService;
	@Autowired
	private BuyerService buyerService;
	
	public Subscription newSubscription(Pack pack, Buyer buyer) {
		Seller seller = new Seller(buyer);
		//End Subscripe By Pack

		Date today = new Date();
		Calendar c = Calendar.getInstance(); 
		c.setTime(today); 
		c.add(Calendar.DATE, pack.getNbrDays());
		today = c.getTime();
		Subscription subscription = new Subscription(null, new Date(), today, true, seller, pack);
		seller.setSubscription(subscription);
		
		Role role = roleService.getRoleByName("SELLER");
		if(role==null) {
			 role  = new Role(null,"SELLER");
			 roleService.newRole(role);
		}
		buyerService.addBuyerToRole(buyer, role);
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
	
	@PreAuthorize("hasAuthority('SELLER') && #subscription.seller.userName==authentication.name")
	public void updateSubscription(Subscription subscription,Pack pack) {

		subscription.setEnabled(true);
		subscription.setUpdatedAt(new Date());
		Date today = new Date();
		Calendar c = Calendar.getInstance(); 
		c.setTime(today); 
		c.add(Calendar.DATE, pack.getNbrDays());
		today = c.getTime();
		subscription.setEndAt(today);
		subscriptionRepository.save(subscription);
	}
	

}
