package zoz.bidproject.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class FollowOffre {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Date followOffreAt;
	@ManyToOne
	private Buyer buyer;
	@ManyToOne
	private Offer offer;

	public FollowOffre() {

	}

	public FollowOffre(Long id, Date followOffreAt, Buyer buyer, Offer offre) {
		this.id = id;
		this.followOffreAt = followOffreAt;
		this.buyer = buyer;
		this.offer = offre;
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
		return offer;
	}

	public void setOffre(Offer offre) {
		this.offer = offre;
	}

}
