package zoz.bidproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zoz.bidproject.model.Purchase;
import zoz.bidproject.model.Seller;
import zoz.bidproject.model.Buyer;
import zoz.bidproject.model.Offer;
import zoz.bidproject.model.Ordre;
import zoz.bidproject.repositories.jpa.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	public Ordre getOrderByPurchase(Purchase purchase) {
		return purchase.getOrdre();
	}

	public Ordre getOrderByOffer(Offer offer) {
		return offer.getPurchase().getOrdre();
	}
	public List<Ordre> getOrdersBySeller(Seller seller) {
		return seller.getOrdres();
	}
}
