package zoz.bidproject.model;

import java.util.Date;

public class FollowOffer {
	private Long id;
	private Date followOffreAt;
	private Buyer buyer;
	private Offer offre;
	public FollowOffer() {

	}

	public FollowOffer(Long id, Date followOffreAt, Buyer buyer,Offer offre) {
		this.id = id;
		this.followOffreAt = followOffreAt;
		this.buyer = buyer;
		this.offre=offre;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFollowOffreAt() {
		return followOffreAt;
	}

	public void setFollowOffreAt(Date followOffreAt) {
		this.followOffreAt = followOffreAt;
	}

	public Buyer getBuyer() {
		return buyer;
	}

	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}

	public Offer getOffre() {
		return offre;
	}

	public void setOffre(Offer offre) {
		this.offre = offre;
	}
	

}
