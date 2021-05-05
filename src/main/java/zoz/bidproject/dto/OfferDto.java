package zoz.bidproject.dto;
/**
 * 
 * @author Zaki_Guemi
 *
 */
public class OfferDto {
	private Long id;
	private String name;
	private String description;
	private Double startPrice;
	private Double augmentationPrice;

	public OfferDto(String name, String description, Double startPrice, Double augmentationPrice) {
		this.name = name;
		this.description = description;
		this.startPrice = startPrice;
		this.augmentationPrice = augmentationPrice;
	}

	public OfferDto() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getStartPrice() {
		return startPrice;
	}

	public void setStartPrice(Double startPrice) {
		this.startPrice = startPrice;
	}

	public Double getAugmentationPrice() {
		return augmentationPrice;
	}

	public void setAugmentationPrice(Double augmentationPrice) {
		this.augmentationPrice = augmentationPrice;
	}

}
