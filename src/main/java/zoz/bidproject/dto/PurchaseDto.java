package zoz.bidproject.dto;

import java.util.Date;

public class PurchaseDto {
	private Long id;
	private Date createdAt;
	private Date updatedAt;
	private Boolean state;
	private String error; // Not sure
	private Long idBuyer;
	private String nomBuyer;
	private Long idOffer;
	private String nomOffer;
	
	public PurchaseDto() {
		// TODO Auto-generated constructor stub
	}
	public PurchaseDto(Long id, Date createdAt, Date updatedAt, Boolean state, String error, Long idBuyer,
			String nomBuyer, Long idOffer, String nomOffer) {
		
		this.id = id;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.state = state;
		this.error = error;
		this.idBuyer = idBuyer;
		this.nomBuyer = nomBuyer;
		this.idOffer = idOffer;
		this.nomOffer = nomOffer;
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
	public Boolean getState() {
		return state;
	}
	public void setState(Boolean state) {
		this.state = state;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public Long getIdBuyer() {
		return idBuyer;
	}
	public void setIdBuyer(Long idBuyer) {
		this.idBuyer = idBuyer;
	}
	public String getNomBuyer() {
		return nomBuyer;
	}
	public void setNomBuyer(String nomBuyer) {
		this.nomBuyer = nomBuyer;
	}
	public Long getIdOffer() {
		return idOffer;
	}
	public void setIdOffer(Long idOffer) {
		this.idOffer = idOffer;
	}
	public String getNomOffer() {
		return nomOffer;
	}
	public void setNomOffer(String nomOffer) {
		this.nomOffer = nomOffer;
	}
	
	
	

	

}
