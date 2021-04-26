package zoz.bidproject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Bid {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Double price;
	@ManyToOne
	private Buyer buyer;
	@ManyToOne
	@JsonIgnore
	private Offer offer;

	
	public Bid() {

	}

	public Bid(Long id, Double price, Buyer buyer, Offer offer) {
		this.id = id;
		this.price = price;
		this.buyer = buyer;
		this.offer = offer;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Buyer getBuyer() {
		return buyer;
	}

	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}

	public Offer getOffer() {
		return offer;
	}

	public void setOffer(Offer offer) {
		this.offer = offer;
	}

}
