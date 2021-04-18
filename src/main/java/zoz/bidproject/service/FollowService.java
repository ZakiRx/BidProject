package zoz.bidproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zoz.bidproject.model.Follow;
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
	public Follow saveFollow(Follow follow) {
		return followRepository.save(follow);
	}

}
