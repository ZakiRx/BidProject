package zoz.bidproject.model;

import java.util.Date;

public class Follow {
	private Long id;
	private Date followedAt;
	private Buyer buyer;
	private Seller seller;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFollowedAt() {
		return followedAt;
	}

	public void setFollowedAt(Date followedAt) {
		this.followedAt = followedAt;
	}

	public Buyer getBuyer() {
		return buyer;
	}

	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}

	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}
	

}
