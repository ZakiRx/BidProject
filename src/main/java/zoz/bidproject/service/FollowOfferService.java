package zoz.bidproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zoz.bidproject.model.Buyer;
import zoz.bidproject.model.FollowOffre;
import zoz.bidproject.model.Seller;
import zoz.bidproject.repositories.jpa.FollowOfferRepository;


/**
 * 
 * @author othmane
 *
 */
@Service
public class FollowOfferService {
	
	
	@Autowired
	private FollowOfferRepository followOfferRepository;
	
	/**
	 * 
	 * @param buyer
	 * @return List of FollowdOffers
	 */
	public List<FollowOffre> getAllFollowedOfferByBuyer(Buyer buyer){
		return buyer.getFollowOffres();
	}
	
	/**
	 * @author Zaki_Guemi
	 * @param buyer
	 * @return
	 */
	public List<FollowOffre> getAllFolowersOffreBySeller(Seller seller){
		return seller.getFollowOffres();
	}
	
	/**
	 * 
	 * @param followOffer
	 * @return followOffer
	 */
	public FollowOffre saveFollowOffer(FollowOffre followOffer) {
		
		return  followOfferRepository.save(followOffer);
	}
		
}
