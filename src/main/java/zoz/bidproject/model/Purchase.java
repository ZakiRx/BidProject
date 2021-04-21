package zoz.bidproject.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Purchase {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date createdAt;
	private Date updatedAt;
	private Boolean state; // must be state enum
	private String error;
	@ManyToOne()
	private Buyer buyer;
	@OneToOne
	private Offer offer;
	@OneToOne(mappedBy = "purchase")
	private ShippingDetails shippingDetails;
	@OneToOne
	private Ordre ordre;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public Buyer getBuyer() {
		return buyer;
	}

	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}

	public Boolean getState() {
		return state;
	}

	public void setState(Boolean state) {
		this.state = state;
	}

	public ShippingDetails getShippingDetails() {
		return shippingDetails;
	}

	public void setShippingDetails(ShippingDetails shippingDetails) {
		this.shippingDetails = shippingDetails;
	}

	public Offer getOffre() {
		return offer;
	}

	public void setOffre(Offer offre) {
		this.offer = offre;
	}
	
	public Ordre getOrdre() {
		return ordre;
	}
	
	public void setOrdre(Ordre ordre) {
		this.ordre = ordre;
	}
	

}
