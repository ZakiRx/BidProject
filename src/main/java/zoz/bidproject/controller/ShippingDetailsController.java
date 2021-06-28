package zoz.bidproject.controller;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pusher.rest.Pusher;

import zoz.bidproject.converter.ShippingDetailsConvert;
import zoz.bidproject.dto.ShippingDetailsDto;
import zoz.bidproject.model.Buyer;
import zoz.bidproject.model.Ordre;
import zoz.bidproject.model.Purchase;
import zoz.bidproject.model.ShippingDetails;
import zoz.bidproject.service.BuyerService;
import zoz.bidproject.service.OrderService;
import zoz.bidproject.service.PurchaseService;
import zoz.bidproject.service.ShippingDetailsService;

@RestController
@RequestMapping("/shippingDetails")
public class ShippingDetailsController {

	@Autowired 
	private ShippingDetailsService shippingDetailsService;
	@Autowired 
	private PurchaseService purchaseService;
	@Autowired 
	private BuyerService buyerService;
	@Autowired 
	private OrderService orderService;
	@Autowired
	private Pusher pusher;
	private ShippingDetailsConvert shippingDetailsConvert;
	
	@PostConstruct
	private void init() {
		shippingDetailsConvert =new ShippingDetailsConvert();
	}
	@GetMapping
	@RequestMapping(path="/{id}",method = RequestMethod.GET)
	public ShippingDetails getShppingDetails(@PathVariable Long id) {
		ShippingDetails shippingDetails = shippingDetailsService.getShippingDetails(id);
		
		return shippingDetails;
	}
	@PostMapping
	@RequestMapping(path="/new",method = RequestMethod.POST)
	@PreAuthorize("hasAuthority('BUYER')")
	public ResponseEntity<Object> newShppingDetails(@RequestBody ShippingDetailsDto shippingDetailsDto) throws JSONException {
		
		String username =SecurityContextHolder.getContext().getAuthentication().getName();
		Buyer buyer =buyerService.getBuyerByUserName(username);
		
		
		List<Purchase> purchases =buyer.getPurchases().stream().filter(p->p.getShippingDetails()==null).collect(Collectors.toList());
		ShippingDetails shippingDetails =shippingDetailsConvert.dtoToEntity(shippingDetailsDto);
		JSONObject jsonObject = new JSONObject();
		for(Purchase purchase : purchases) {
			if(purchase.getId()==shippingDetailsDto.getIdPurchase()) {
				shippingDetails.setPurchase(purchase);
				ShippingDetails details = shippingDetailsService.newShippingDetails(shippingDetails);
				purchase.setShippingDetails(details);
				purchaseService.newPurchase(purchase);
				jsonObject.put("success", "Your shipping details has been added");
				Ordre order = new Ordre(null, new Date(), new Date(), purchase.getOffre().getSeller(), purchase);
				orderService.newOrder(order);
				String event = "order-added";
				pusher.trigger("seller-"+order.getSeller().getId(), event, Collections.singletonMap("message", "One Order has been added check your  orders and complete shipping proof"));
				return new ResponseEntity<Object>(jsonObject.toString(),HttpStatus.CREATED);
			}
		}
		
		jsonObject.put("error", "faild to find your purchase");
		 return new ResponseEntity<Object>(jsonObject.toString(),HttpStatus.NOT_FOUND);
	}
	
}
