package zoz.bidproject.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pusher.rest.Pusher;

import zoz.bidproject.converter.BidConvert;
import zoz.bidproject.dto.BidDto;
import zoz.bidproject.model.Bid;
import zoz.bidproject.model.Buyer;
import zoz.bidproject.model.Offer;
import zoz.bidproject.repositories.jpa.BidRepository;
import zoz.bidproject.repositories.jpa.BuyerRepository;

@Service
public class BidService {

	@Autowired
	private BidRepository bidRepository;
	@Autowired
	private OfferService offerService;
	@Autowired
	private BuyerRepository buyerRepository;

	public List<Bid> getBidsByOffer(Offer offer) {
		return offer.getBids();
	}

	public List<Bid> getBidsByBuyer(Buyer buyer) {
		return buyer.getBids();
	}

	public Bid newBid(Bid bid) throws Exception {
		List<Bid> bids;
		Offer offer = bid.getOffer();
		if (offer.getBids() == null) {
			bids = new ArrayList<Bid>();
			bids.add(bid);
		} else {
			if(!bid.getOffer().getSeller().equals(bid.getBuyer())) {
				if (bid.getPrice() <= bid.getBuyer().getBalance()) {
					
					if (offer.getCurrentPrice() < bid.getPrice()) {
						bids = offer.getBids();
						Buyer currentBuyer =bid.getBuyer();
						Buyer lastBuyerBid = bids.get((bids.size() - 1)).getBuyer();
						double priceLastBid=bids.get((bids.size() - 1)).getPrice();
						if(lastBuyerBid!=null) {
							returnMoney(lastBuyerBid,priceLastBid);
						}
						currentBuyer.setBalance(currentBuyer.getBalance()-bid.getPrice());
						buyerRepository.save(lastBuyerBid);
						buyerRepository.save(currentBuyer);
						bids.add(bid);
					} else {
						throw new Exception("Price must be over than  " + offer.getCurrentPrice());
					}
				} else {
					throw new Exception("Your balance Not allowed  " + bid.getPrice());
				}
			}else {
				throw new Exception("Operation Not possible  Seller equals Buyer");
			}
		

		}
		offer.setBids(bids);
		Bid newBid = bidRepository.save(bid);
		BidConvert bidConvert = new BidConvert();

		// Test Pusher
		Pusher pusher = new Pusher("1194761", "f856f46602ee2819adc2", "846108e333cd4a552490");
		pusher.setCluster("eu");
		pusher.setEncrypted(true);
		BidDto bidDto = bidConvert.entityToDto(bid);
		String event = "newBid";
		pusher.trigger("add-Bid-Offer-"+bid.getOffer().getId(), event, Collections.singletonMap("Bid", bidDto));
		// update current Price
		offer.setCurrentPrice(bid.getPrice());
		offerService.saveOffre(offer);
		
		return newBid;
	}

	private void returnMoney(Buyer buyer,double price) {
		buyer.setBalance(buyer.getBalance()+price);
	}
}
