package zoz.bidproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import zoz.bidproject.dto.SubscriptionDto;
import zoz.bidproject.model.Buyer;
import zoz.bidproject.model.Pack;
import zoz.bidproject.model.Seller;
import zoz.bidproject.model.Subscription;
import zoz.bidproject.service.BuyerService;
import zoz.bidproject.service.PackService;
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
	private PackService packService;
	@Autowired
	private SellerService sellerService;
	
	@GetMapping
	@RequestMapping("/")
	public Subscription getSubscription() {
		String username=SecurityContextHolder.getContext().getAuthentication().getName();
		Seller seller = sellerService.getSellerByUserName(username);
		try {
			return subscriptionService.getSubscription(seller);
		} catch (Exception e) {
			
			return null;
		}
	}
	@PostMapping
	@RequestMapping("/new")
	@PreAuthorize("hasAnyAuthority('SELLER', 'BUYER')")
	public Subscription newSubscription(@RequestBody SubscriptionDto subscriptionDto) {
		String username=SecurityContextHolder.getContext().getAuthentication().getName();
		Buyer buyer = buyerService.getBuyerByUserName(username);
		Pack pack = packService.getPack(subscriptionDto.getPackId());
		return subscriptionService.newSubscription(pack, buyer);
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
