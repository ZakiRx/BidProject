package zoz.bidproject.dto;

import java.util.Date;

public class FollowDto {
	private Long idFollow;
	private Date followedAtFollow;

	public Long getIdFollow() {
		return idFollow;
	}

	public void setIdFollow(Long idFollow) {
		this.idFollow = idFollow;
	}

	public Date getFollowedAtFollow() {
		return followedAtFollow;
	}

	public void setFollowedAtFollow(Date followedAtFollow) {
		this.followedAtFollow = followedAtFollow;
	}

}
