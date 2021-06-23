package zoz.bidproject.controller;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.protocol.HTTP;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stripe.exception.StripeException;
import com.stripe.model.Charge;

import zoz.bidproject.model.Buyer;
import zoz.bidproject.model.StripeRequestInfo;
import zoz.bidproject.service.BuyerService;
import zoz.bidproject.service.PaymentService;

@RestController
public class CheckoutController {

	@Value("${STRIPE_PUBLIC_KEY}")
	private String stripePublicKey;
	
	@Autowired
	@Qualifier("Stripe")
	private PaymentService paymentService;
	
	@Autowired
	private BuyerService buyerService;

	@RequestMapping("/checkout/{amount}")
	@PostMapping
	@PreAuthorize("hasAuthority('BUYER')")
	public ResponseEntity<Object> checkout(@PathVariable("amount") Float amount) throws JSONException {
		
		JSONObject json = new JSONObject();
		json.put("info",("{publicKey:"+stripePublicKey+", currency :"+StripeRequestInfo.Currency.USD+",amount:"+amount*100+"}"));
		return new ResponseEntity<Object>(json.toString(),HttpStatus.ACCEPTED);
	}
	@RequestMapping("/charge")
	@PostMapping
	
	public ResponseEntity<Object> charge(@RequestBody StripeRequestInfo info) throws JSONException, StripeException, IllegalArgumentException, IllegalAccessException {
		
		String username =SecurityContextHolder.getContext().getAuthentication().getName();
		Buyer buyer =buyerService.getBuyerByUserName("med");
		info.setDescription("Debosit Client "+buyer.getEmail());
		info.setStripeEmail(buyer.getEmail());
        info.setCurrency(StripeRequestInfo.Currency.EUR);
        Map<String,String> metadata = new HashMap<String, String>();
		metadata.put("username",buyer.getUserName());
		metadata.put("First Name",buyer.getFirstName());
		metadata.put("Last Name",buyer.getLastName());
		metadata.put("Phone",buyer.getPhoneNumber());
		metadata.put("Date Birth",buyer.getDateBirth().toString());
		info.setMetadata(metadata);
        Charge charge = (Charge) paymentService.payment(info);
		JSONObject json = new JSONObject();
		json.put("info",charge.getStatus().toString());
		if("succeeded".equals(charge.getStatus())) {
			
			buyerService.debositToAccount(charge.getAmount()/100, buyer);
			
				
			
			return new ResponseEntity<Object>(json.toString(),HttpStatus.ACCEPTED);
		}else {
			return new ResponseEntity<Object>(json.toString(),HttpStatus.NOT_ACCEPTABLE);
		}
		
	}
	@ExceptionHandler(StripeException.class)
    public ResponseEntity<Object> handleError(StripeException ex) {
		JSONObject json = new JSONObject();
		try {
			json.put("info",ex.getMessage());
			return new ResponseEntity<Object>(json.toString(),HttpStatus.ACCEPTED);
		} catch (JSONException e) {
			return new ResponseEntity<Object>(json.toString(),HttpStatus.ACCEPTED);
		}
		
    }
}
