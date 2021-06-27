package zoz.bidproject.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zoz.bidproject.model.Buyer;
import zoz.bidproject.model.Ordre;
import zoz.bidproject.model.Purchase;
import zoz.bidproject.repositories.jpa.PurchaseRepository;

@Service
public class PurchaseService {

	@Autowired
	private PurchaseRepository purchaseRepository;
	@Autowired
	private OrderService orderService;
	
	public Purchase getPurchasesById(long id){
		 return purchaseRepository.getOne(id);
	}
	public List<Purchase> getPurchasesByBuyer(Buyer buyer){
		return buyer.getPurchases();
	}
	public Purchase getPurchasesByOrder(Ordre order){
		 return order.getPurchase();
	}
	
	public Purchase newPurchase(Purchase purchase) {
		return purchaseRepository.save(purchase);
	}
}
