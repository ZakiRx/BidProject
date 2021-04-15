package zoz.bidproject.model;

import java.util.Date;

public class Ordre {
	private Long id;
	private Date createdAt;
	private Date updatedAt;
	private ShippingProof shippingProof;
	
	public Ordre() {
		
	}
	public Ordre(Long id, Date createdAt, Date updatedAt) {
		this.id = id;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
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
	public ShippingProof getShippingProof() {
		return shippingProof;
	}
	public void setShippingProof(ShippingProof shippingProof) {
		this.shippingProof = shippingProof;
	}
	
}
