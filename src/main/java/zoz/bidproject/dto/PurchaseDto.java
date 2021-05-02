package zoz.bidproject.dto;

import java.util.Date;

public class PurchaseDto {
	private Long idPurchase;
	private Date createdAtPurchase;
	private Date updatedAtPurchase;
	private Boolean statePurchase;
	private String errorPurchase; // Not sure

	public Long getIdPurchase() {
		return idPurchase;
	}

	public void setIdPurchase(Long idPurchase) {
		this.idPurchase = idPurchase;
	}

	public Date getCreatedAtPurchase() {
		return createdAtPurchase;
	}

	public void setCreatedAtPurchase(Date createdAtPurchase) {
		this.createdAtPurchase = createdAtPurchase;
	}

	public Date getUpdatedAtPurchase() {
		return updatedAtPurchase;
	}

	public void setUpdatedAtPurchase(Date updatedAtPurchase) {
		this.updatedAtPurchase = updatedAtPurchase;
	}

	public Boolean getStatePurchase() {
		return statePurchase;
	}

	public void setStatePurchase(Boolean statePurchase) {
		this.statePurchase = statePurchase;
	}

	public String getErrorPurchase() {
		return errorPurchase;
	}

	public void setErrorPurchase(String errorPurchase) {
		this.errorPurchase = errorPurchase;
	}

}
