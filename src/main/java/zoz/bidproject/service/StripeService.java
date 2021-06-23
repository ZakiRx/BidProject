package zoz.bidproject.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.model.Customer;
import com.stripe.model.Plan;
import com.stripe.model.Price;
import com.stripe.model.Product;
import com.stripe.model.Subscription;
import com.stripe.param.PriceCreateParams;
import com.stripe.param.ProductCreateParams;

import antlr.collections.List;
import zoz.bidproject.model.Buyer;
import zoz.bidproject.model.Pack;
import zoz.bidproject.model.StripeRequestInfo;

@Service("Stripe")
public class StripeService implements PaymentService {

	@Value("${STRIPE_SECRET_KEY}")
	private String secretKey;
	@Autowired
	private BuyerService buyerService;

	@PostConstruct
	public void init() {
		Stripe.apiKey = secretKey;
	}

	@Override
	public Charge payment(StripeRequestInfo info) throws StripeException {

		Map<String, Object> chargeParams = new HashMap<>();
		chargeParams.put("amount", info.getAmount()*100);
		chargeParams.put("currency", info.getCurrency());
		chargeParams.put("description", info.getDescription());
		chargeParams.put("source", info.getStripeToken());
		chargeParams.put("metadata", info.getMetadata());
		return Charge.create(chargeParams);

	}
	
	public Plan createPlan(Pack pack) throws StripeException {
		ProductCreateParams params =
				  ProductCreateParams.builder()
				    .setName(pack.getName())
				    .build();
				Product product = Product.create(params);
				
		Map<String, Object> paramsPlan = new HashMap<>();
		paramsPlan.put("amount", pack.getPrice()*100);
		paramsPlan.put("currency", "usd");
		paramsPlan.put("interval", "month");
		paramsPlan.put("product", product.getId());

		Plan plan = Plan.create(paramsPlan);
		return plan;
	}
	 public String createSubscription(String customerId, String plan) {
	        String id = null;
	        try {
	            
	            Map<String, Object> item = new HashMap<>();
	            item.put("plan", plan);

	            Map<String, Object> items = new HashMap<>();
	            items.put("0", item);

	            Map<String, Object> params = new HashMap<>();
	            params.put("customer", customerId);
	            params.put("items", items);
	            Subscription sub = Subscription.create(params);
	        
	            id = sub.getId();
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	        return id;
	  }
	 public String createCustomer(String token) {
	        String id = null;
	        try {
	            String username = SecurityContextHolder.getContext().getAuthentication().getName();
	            Buyer buyer = buyerService.getBuyerByUserName("med");
	            Map<String, Object> customerParams = new HashMap<>();
	            // add customer unique id here to track them in your web application
	            customerParams.put("description", "Customer for " + buyer.getEmail());
	            customerParams.put("email", buyer.getEmail());
	            customerParams.put("source", token); // ^ obtained with Stripe.js
	            //create a new customer
	            Customer customer = Customer.create(customerParams);
	           
	            id = customer.getId();
	            System.out.println("id customer:"+id);
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	        return id;
	    }

}
