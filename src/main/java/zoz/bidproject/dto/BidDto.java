package zoz.bidproject.dto;

public class BidDto {
	private Long id;
	private Double price;
	private Long idBuyer;
	private String nameBuyer;
	private Long idOffer;
	private String nameOffer;

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

	public Long getIdBuyer() {
		return idBuyer;
	}

	public void setIdBuyer(Long idBuyer) {
		this.idBuyer = idBuyer;
	}

	public String getNameBuyer() {
		return nameBuyer;
	}

	public void setNameBuyer(String nameBuyer) {
		this.nameBuyer = nameBuyer;
	}

	public Long getIdOffer() {
		return idOffer;
	}

	public void setIdOffer(Long idOffer) {
		this.idOffer = idOffer;
	}

	public String getNameOffer() {
		return nameOffer;
	}

	public void setNameOffer(String nameOffer) {
		this.nameOffer = nameOffer;
	}

}
