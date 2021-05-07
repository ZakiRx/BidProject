package zoz.bidproject.dto;

import java.util.Date;
import java.util.List;

import zoz.bidproject.model.Bid;
import zoz.bidproject.model.Comment;
import zoz.bidproject.model.Product;

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
	private Double currentPrice;
	private Date startedAt;
	private Date endAt;
	private Long idSeller;
	private String nameSeller;
	private List<Comment> comments;
	private List<Product> products;
	private List<Bid> bids;
	public OfferDto(Long id, String name, String description, Double startPrice, Double augmentationPrice,
			Double currentPrice, Date startedAt, Date endAt, Long idSeller, String nameSeller, List<Comment> comments,
			List<Product> products, List<Bid> bids) {
		this(name,description,startPrice,augmentationPrice);
		this.id = id;
		this.currentPrice = currentPrice;
		this.startedAt = startedAt;
		this.endAt = endAt;
		this.idSeller = idSeller;
		this.nameSeller = nameSeller;
		this.comments = comments;
		this.products = products;
		this.bids = bids;
	}
	
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(Double currentPrice) {
		this.currentPrice = currentPrice;
	}

	public Date getStartedAt() {
		return startedAt;
	}

	public void setStartedAt(Date startedAt) {
		this.startedAt = startedAt;
	}

	public Date getEndAt() {
		return endAt;
	}

	public void setEndAt(Date endAt) {
		this.endAt = endAt;
	}

	public Long getIdSeller() {
		return idSeller;
	}

	public void setIdSeller(Long idSeller) {
		this.idSeller = idSeller;
	}

	public String getNameSeller() {
		return nameSeller;
	}

	public void setNameSeller(String nameSeller) {
		this.nameSeller = nameSeller;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public List<Bid> getBids() {
		return bids;
	}

	public void setBids(List<Bid> bids) {
		this.bids = bids;
	}
	

}
