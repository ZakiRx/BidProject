package zoz.bidproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import zoz.bidproject.model.Buyer;
import zoz.bidproject.model.Seller;
import zoz.bidproject.model.Subscription;
import zoz.bidproject.service.BuyerService;
import zoz.bidproject.service.SellerService;
import zoz.bidproject.service.SubscriptionService;

@RestController
@RequestMapping("/subscription")
public class SubscriptionController {
	@Autowired
	private SubscriptionService subscriptionService;
	@Autowired
	private BuyerService buyerService;
	@Autowired
	private SellerService sellerService;
	@PostMapping
	@RequestMapping("/new")
	public Subscription newSubscription(@RequestBody Subscription subscription) {
		Buyer buyer = buyerService.getBuyer(1L);//get in session
		return subscriptionService.newSubscription(subscription.getPack(), buyer);
	}
	@PostMapping
	@RequestMapping("/disable")
	public Subscription disableSubscription() {
		Seller seller = sellerService.getSeller(1L); //get in session
		Subscription subscription;
		try {
			subscription = subscriptionService.getSubscription(seller);
			return subscriptionService.disabelSubscription(subscription);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
}
