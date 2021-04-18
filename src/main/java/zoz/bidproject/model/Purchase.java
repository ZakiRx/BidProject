package zoz.bidproject.model;

import java.util.Date;

public class Purchase {
	private Long id;
	private Date createdAt;
	private Date updatedAt;
	private Boolean state; // must be state enum
	private String error;
	private Buyer buyer;
	private Offer offre;
	private ShippingDetails shippingDetails;
	

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
		return offre;
	}

	public void setOffre(Offer offre) {
		this.offre = offre;
	}
	

}
