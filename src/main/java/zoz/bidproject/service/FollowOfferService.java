package zoz.bidproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zoz.bidproject.model.Buyer;
import zoz.bidproject.model.FollowOffer;
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
	public List<FollowOffer> getAllFollowedOfferByBuyer(Buyer buyer){
		return buyer.getFollowOffres();
	}
	
	
	/**
	 * 
	 * @param followOffer
	 * @return followOffer
	 */
	public FollowOffer saveFollowOffer(FollowOffer followOffer) {
		
		return  followOfferRepository.save(followOffer);
	}
		
}
