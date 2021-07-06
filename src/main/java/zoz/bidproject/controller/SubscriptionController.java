package zoz.bidproject.controller;

import java.util.HashMap;
import java.util.Map;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stripe.exception.StripeException;
import com.stripe.model.Customer;
import com.stripe.model.Plan;

import zoz.bidproject.dto.SubscriptionDto;
import zoz.bidproject.model.Buyer;
import zoz.bidproject.model.Pack;
import zoz.bidproject.model.Seller;
import zoz.bidproject.model.StripeRequestInfo;
import zoz.bidproject.model.Subscription;
import zoz.bidproject.service.BuyerService;
import zoz.bidproject.service.PackService;
import zoz.bidproject.service.SellerService;
import zoz.bidproject.service.StripeService;
import zoz.bidproject.service.SubscriptionService;

@RestController
@RequestMapping("/subscription")
public class SubscriptionController {
	
	
	@Value("${STRIPE_PUBLIC_KEY}")
	private String STRIPE_PUBLIC_KEY;
	@Autowired
	private SubscriptionService subscriptionService;
	@Autowired
	private BuyerService buyerService;
	@Autowired
	private PackService packService;
	@Autowired
	private SellerService sellerService;
	@Autowired
	private StripeService stripeService;
	@Value("${STRIPE_PUBLIC_KEY}")
	private String stripePublicKey;
	
	@GetMapping
	@RequestMapping("/keyStripe")
	@PreAuthorize("hasAuthority('BUYER')")
	public ResponseEntity<Object> getPublicKeyStripe() throws JSONException {
		JSONObject json = new JSONObject();
		json.put("publicKey",stripePublicKey);
		return new ResponseEntity<Object>(json.toString(),HttpStatus.ACCEPTED);
	}
	
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
	@PreAuthorize("hasAnyAuthority('SELLER','BUYER')")
	public ResponseEntity<Object> newSubscription(@RequestBody SubscriptionDto subscriptionDto) throws JSONException {
		String username=SecurityContextHolder.getContext().getAuthentication().getName();
		Buyer buyer = buyerService.getBuyerByUserName("med");
		Pack pack = packService.getPack(subscriptionDto.getPackId());
		
		subscriptionService.newSubscription(pack, buyer);
		String customer = stripeService.createCustomer(subscriptionDto.getToken());
		if(customer==null || customer.equals("") ) {
			return new ResponseEntity<Object>((new JSONObject().put("message", "error occurred while trying to create a customer.")).toString(),HttpStatus.NOT_ACCEPTABLE);
		}
		
		String subscriptionId = stripeService.createSubscription(customer, pack.getPlanId());
		if(subscriptionId==null) {
			
			return new ResponseEntity<Object>((new JSONObject().put("message", "An error occurred while trying to create a subscription.")).toString(),HttpStatus.NOT_ACCEPTABLE);

		}
		return new ResponseEntity<Object>((new JSONObject().put("message", "Success! Your subscription id is" + subscriptionId+"")).toString(),HttpStatus.OK);
	}
	
	@PreAuthorize("hasAuthority('SELLER') && #subscriptionDto.enabled==false && #subscriptionDto.nameSeller==authentication.name")
	public ResponseEntity<Object> updateSubscription(@RequestBody SubscriptionDto subscriptionDto) throws JSONException, StripeException {
		String username=SecurityContextHolder.getContext().getAuthentication().getName();
		Seller seller = sellerService.getSellerByUserName("med");
		Pack pack = packService.getPack(subscriptionDto.getPackId());
		Subscription subscription = seller.getSubscription();
		subscriptionService.updateSubscription(subscription, pack); //in db admin
		com.stripe.model.Subscription subscriptionStripe = com.stripe.model.Subscription.retrieve("125");
		 Map<String, Object> item = new HashMap<>();
         item.put("plan", pack.getPlanId());
         Map<String, Object> items = new HashMap<>();
         items.put("0", item);

         Map<String, Object> params = new HashMap<>();
         params.put("items", items);
		
		
		
		String subscriptionId = subscriptionStripe.update(params).getId();
		if(subscriptionId==null) {
			
			return new ResponseEntity<Object>((new JSONObject().put("message", "An error occurred while trying to create a subscription.")).toString(),HttpStatus.NOT_ACCEPTABLE);

		}
		return new ResponseEntity<Object>((new JSONObject().put("message", "Success! Your subscription  is updated")).toString(),HttpStatus.OK);
	}
	@PostMapping
	@RequestMapping("/disable")
	@PreAuthorize("hasAuthority('ADMIN')")
	public Subscription disableSubscription() {
		String username=SecurityContextHolder.getContext().getAuthentication().getName();
		Seller seller = sellerService.getSellerByUserName(username);
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
