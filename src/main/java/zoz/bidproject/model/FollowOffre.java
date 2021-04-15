package zoz.bidproject.model;

import java.util.Date;

public class FollowOffre {
	private Long id;
	private Date followOffreAt;
	private Buyer buyer;
	private Offre offre;
	public FollowOffre() {

	}

	public FollowOffre(Long id, Date followOffreAt, Buyer buyer,Offre offre) {
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

	public Offre getOffre() {
		return offre;
	}

	public void setOffre(Offre offre) {
		this.offre = offre;
	}
	

}
