package zoz.bidproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zoz.bidproject.model.ShippingDetails;
import zoz.bidproject.repositories.jpa.ShippingDetailsRepository;

@Service
public class ShippingDetailsService {

	@Autowired
	private ShippingDetailsRepository detailsRepository;
	
	
	public ShippingDetails newShippingDetails(ShippingDetails shippingDetails) {
		return detailsRepository.save(shippingDetails);
	}
	public ShippingDetails getShippingDetails(Long id) {
		return detailsRepository.getOne(id);
	}
	
	
}
