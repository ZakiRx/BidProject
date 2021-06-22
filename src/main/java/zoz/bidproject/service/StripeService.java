package zoz.bidproject.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;

import zoz.bidproject.model.StripeRequestInfo;

@Service("Stripe")
public class StripeService implements PaymentService {

	@Value("${STRIPE_SECRET_KEY}")
	private String secretKey;

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

		return Charge.create(chargeParams);

	}

}
