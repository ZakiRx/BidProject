package zoz.bidproject.model;

import java.util.Date;

public class Comment {
	private Long id;
	private String comment;
	private Date createdAt;
	private Date updatedAt;
	private Boolean actif;
	private Buyer buyer;
	private Offer offer;
	
	public Comment(Long id, String comment, Date createdAt, Date updatedAt, Boolean actif, Buyer buyer,Offer offer) {
		this.id = id;
		this.comment = comment;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.actif = actif;
		this.buyer = buyer;
		this.offer = offer;
	}

	public Comment() {
		
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}



	public void setComment(String comment) {
		this.comment = comment;
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

	public Boolean getActif() {
		return actif;
	}

	public void setActif(Boolean actif) {
		this.actif = actif;
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
