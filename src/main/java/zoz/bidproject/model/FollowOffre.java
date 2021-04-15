package zoz.bidproject.model;

import java.util.Date;

public class FollowOffre {
	private Long id;
	private Date followOffreAt;
	private Buyer buyer;

	public FollowOffre() {

	}

	public FollowOffre(Long id, Date followOffreAt, Buyer buyer) {
		super();
		this.id = id;
		this.followOffreAt = followOffreAt;
		this.buyer = buyer;
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

}
