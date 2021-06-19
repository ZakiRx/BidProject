package zoz.bidproject.dto;

import java.util.Date;

public class OrderDto {
	private Long id;
	private Long shippingProofId;
	private Long purchaseId;
	private Date createdAt;
	private Date updatedAt;

	public OrderDto() {

	}

	public OrderDto(Long id, Date createdAt, Date updatedAt, Long shippingProofId, Long purchaseId) {
		this.id = id;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.shippingProofId = shippingProofId;
		this.purchaseId = purchaseId;
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

	public Long getShippingProofId() {
		return shippingProofId;
	}

	public void setShippingProofId(Long shippingProofId) {
		this.shippingProofId = shippingProofId;
	}

	public Long getPurchaseId() {
		return purchaseId;
	}

	public void setPurchaseId(Long purchaseId) {
		this.purchaseId = purchaseId;
	}
	

}
