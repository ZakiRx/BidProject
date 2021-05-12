package zoz.bidproject.dto;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.aspectj.lang.annotation.After;

import com.sun.istack.NotNull;

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
	
	@NotNull
	@Size(min=4,max = 40,message = "Name must be btween {min} and {max}")
	private String name;
	@NotBlank(message="Description must be not blank")
	@NotNull
	private String description;
	@Min(value = 0,message = "Start price must be greater  than {value}")
	private Double startPrice;
	@Min(value = 0,message = "Start price must be greater  than {value}")
	private Double augmentationPrice;
	private Double currentPrice;
	@FutureOrPresent(message = "Date not valid")
	private Date startedAt;
	@Future
	private Date endAt;
	@NotNull
	private Long idSeller;
	private String nameSeller;
	private List<CommentDto> comments;
	private List<Product> products;
	private List<BidDto> bids;
	public OfferDto(Long id, String name, String description, Double startPrice, Double augmentationPrice,
			Double currentPrice, Date startedAt, Date endAt, Long idSeller, String nameSeller, List<CommentDto> comments,
			List<Product> products, List<BidDto> bids) {
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

	public List<CommentDto> getComments() {
		return comments;
	}

	public void setComments(List<CommentDto> comments) {
		this.comments = comments;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public List<BidDto> getBids() {
		return bids;
	}

	public void setBids(List<BidDto> bids) {
		this.bids = bids;
	}
	

}
