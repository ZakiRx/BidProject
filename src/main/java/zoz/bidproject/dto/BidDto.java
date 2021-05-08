package zoz.bidproject.dto;

public class BidDto {
	private Long id;
	private Double price;
	private Long idBuyer;
	private String nameBuyer;
	private Long idOffer;
	private String nameOffer;

	
	public BidDto() {
		// TODO Auto-generated constructor stub
	}
	public BidDto(Long id, Double price, Long idBuyer, String nameBuyer, Long idOffer, String nameOffer) {
		super();
		this.id = id;
		this.price = price;
		this.idBuyer = idBuyer;
		this.nameBuyer = nameBuyer;
		this.idOffer = idOffer;
		this.nameOffer = nameOffer;
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
