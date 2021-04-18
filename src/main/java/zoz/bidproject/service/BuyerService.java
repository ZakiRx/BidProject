package zoz.bidproject.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zoz.bidproject.model.Buyer;
import zoz.bidproject.model.Comment;
import zoz.bidproject.model.Follow;
import zoz.bidproject.model.FollowOffre;
import zoz.bidproject.model.Offer;
import zoz.bidproject.model.Seller;
import zoz.bidproject.repositories.jpa.BuyerRepository;

/**
 * 
 * @author othmane
 *
 */
@Service
public class BuyerService {
	
	@Autowired
	private BuyerRepository buyerRepository;
	
	@Autowired
	private FollowService followService;
	
	@Autowired
	private SellerService sellerService; 
	
	@Autowired
	private OfferService offerService;
	
	@Autowired
	private FollowOfferService followOfferService;
	
	@Autowired
	private CommentService commentService;
	
	
	/**
	 * 
	 * @param id buyer
	 * @return buyer
	 */
	public Buyer getBuyer(Long id) {
		return buyerRepository.getOne(id);
	}
	
	
	/**
	 * get list of Offers
	 * @param id buyer 
	 * @return list of followedOffer
	 */
	public List<FollowOffre> getFollowedOffers(Long id){
		Buyer buyer = getBuyer(id);
		return followOfferService.getAllFollowedOfferByBuyer(buyer);
	}
	
	
	/**
	 * Follow An Offer
	 * @param idBuyer
	 * @param idOffer
	 * @return FollowedOffer
	 */
	public FollowOffre followAnOffer(long idBuyer , Long idOffer) {
		Buyer buyer = getBuyer(idBuyer);
		Offer offer = offerService.getOfferById(idOffer);
		return followOfferService.saveFollowOffer(new FollowOffre(null,new Date(),buyer,offer));
	}
	
	
	/**-
	 * Make a Comment 
	 * @param idBuyer
	 * @param idOffer
	 * @param commentText
	 * @return Comment
	 */
	public Comment makeComment(Long idBuyer,long idOffer ,String commentText) {
		Buyer buyer = getBuyer(idBuyer);
		Offer offer = offerService.getOfferById(idOffer);
		return commentService.saveComment(new Comment(null,commentText,new Date(),new Date(),false,buyer,offer));
	}

	/**
	 * 
	 * @param idBuyer
	 * @param idSeller
	 * @return Follow
	 */
	public Follow followSeller(Long idBuyer,Long idSeller) {
		Buyer buyer = getBuyer(idBuyer);
		Seller seller = sellerService.getSeller(idSeller); // should to communicate with the service
		return followService.saveFollow(new Follow(null,new Date(),buyer,seller));
	}
	
	/**
	 * @author Zaki_Guemi
	 * @param idBuyer
	 * @return
	 */
	public List<Follow> getFollowing(Long idBuyer){
		Buyer buyer = getBuyer(idBuyer);
		return followService.getFollowingByBuyer(buyer);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
