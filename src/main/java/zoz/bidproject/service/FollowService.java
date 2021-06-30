package zoz.bidproject.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import zoz.bidproject.model.Buyer;
import zoz.bidproject.model.Follow;
import zoz.bidproject.model.Seller;
import zoz.bidproject.repositories.jpa.FollowRepository;

/**
 * 
 * @author othmane
 *
 */
@Service
public class FollowService {
	
	@Autowired
	private FollowRepository followRepository;
	
	/**
	 * 
	 * @param follow
	 * @return follow
	 */
	public Follow newFollow(Follow follow) {
		follow.setFollowedAt(new Date());
		return followRepository.save(follow);
	}
	public Follow getFollow(Long id){
		return followRepository.getOne(id);
	}
	public List<Follow> getFollowersBySeller(Seller seller){
		return seller.getFollows();
	}
	
	public List<Follow> getFollowingByBuyer(Buyer buyer){
		return buyer.getFollows();
	}
	@PreAuthorize("(hasAuthority('BUYER') && #follow.buyer.userName==authentication.name) ||(hasAuthority('SELLER') && #follow.seller.userName==authentication.name)   ")
	public void deleteFollow(Follow follow) {
		followRepository.delete(follow);
	}

}
