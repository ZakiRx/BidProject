package zoz.bidproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zoz.bidproject.model.Ordre;
import zoz.bidproject.model.Seller;
import zoz.bidproject.repositories.jpa.OrderRepository;

@Service
public class OrdreService {
	@Autowired
	private OrderRepository ordreRepository;
	
	@Autowired
	private SellerService sellerService;
	
	public List<Ordre> getOrdersBySeller(Long idSeller){
		Seller seller = sellerService.getSeller(idSeller);
		return seller.getOrdres();
	}
	
}
