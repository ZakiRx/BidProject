package zoz.bidproject.dto;

import java.util.Date;

public class FollowOffreDto {
	private Long idFollow;
	private Date followOffreAt;
	private Long idBuyer;
	private Long idOffer;

	public FollowOffreDto() {
		
	}

	public FollowOffreDto(Long idFollow, Date followOffreAt, Long idBuyer, Long idOffer) {

		this.idFollow = idFollow;
		this.followOffreAt = followOffreAt;
		this.idBuyer = idBuyer;
		this.idOffer = idOffer;
	}

	public Long getIdFollow() {
		return idFollow;
	}

	public void setIdFollow(Long idFollow) {
		this.idFollow = idFollow;
	}

	public Date getFollowOffreAt() {
		return followOffreAt;
	}

	public void setFollowOffreAt(Date followOffreAt) {
		this.followOffreAt = followOffreAt;
	}

	public Long getIdBuyer() {
		return idBuyer;
	}

	public void setIdBuyer(Long idBuyer) {
		this.idBuyer = idBuyer;
	}

	public Long getIdOffer() {
		return idOffer;
	}

	public void setIdOffer(Long idOffer) {
		this.idOffer = idOffer;
	}

}
