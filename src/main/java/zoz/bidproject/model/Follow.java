package zoz.bidproject.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Follow {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Date followedAt;
	@ManyToOne
	private Buyer buyer;
	@ManyToOne
	private Seller seller;
	
	public Follow(Long id, Date followedAt, Buyer buyer, Seller seller) {
		this.id = id;
		this.followedAt = followedAt;
		this.buyer = buyer;
		this.seller = seller;
	}
	
	public Follow() {
		super();
		// TODO Auto-generated constructor stub
	}

	
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
