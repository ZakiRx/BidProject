package zoz.bidproject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import zoz.bidproject.model.Offer;
import zoz.bidproject.model.Seller;
import zoz.bidproject.repositories.jpa.OfferRepository;
/**
 * 
 * @author othmane
 *
 */
@Service
public class OfferService {

	private OfferRepository offerRepository;
	
	
	/**
	 * 
	 * @param id
	 * @return offer
	 */
	public Offer getOfferById(Long id) {
		return offerRepository.getOne(id);
	}
	
	
	/**
	 * 
	 * @return list of offers
	 */
	public List<Offer> getAllOffers(){
		return offerRepository.findAll();
	}
	
	/**
	 * 
	 * @param seller
	 * @return list of offers by seller
	 */
	public List<Offer> getAllOffresBySeller(Seller seller){
		return seller.getOffres();
	}
	
	
	/**
	 * 
	 * @param offer
	 * @return offer
	 */
	public  Offer saveOffre(Offer offer) {
		return offerRepository.save(offer);
	}
	
	
	
}
