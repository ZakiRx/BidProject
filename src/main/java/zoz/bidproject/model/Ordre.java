package zoz.bidproject.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Ordre {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date createdAt;
	private Date updatedAt;
	@OneToOne(mappedBy = "ordre")
	private ShippingProof shippingProof;
	@ManyToOne
	private Seller seller;
	@OneToOne(mappedBy = "ordre")
	private Purchase purchase;
	
	public Ordre() {
		
	}
	public Ordre(Long id, Date createdAt, Date updatedAt,Seller seller,Purchase purchase) {
		this.id = id;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.seller=seller;
		this.purchase=purchase;
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
	public Seller getSeller() {
		return seller;
	}
	public void setSeller(Seller seller) {
		this.seller = seller;
	}
	public Purchase getPurchase() {
		return purchase;
	}
	public void setPurchase(Purchase purchase) {
		this.purchase = purchase;
	}
	
	
	
	
}
