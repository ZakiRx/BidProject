package zoz.bidproject.service;

import com.stripe.exception.StripeException;

import zoz.bidproject.model.StripeRequestInfo;

public interface PaymentService {

	Object payment(StripeRequestInfo info) throws StripeException ;
	
}
