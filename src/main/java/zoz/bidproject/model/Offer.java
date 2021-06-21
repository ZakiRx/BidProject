package zoz.bidproject.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.transaction.Transactional;

import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

@Entity
@Proxy(lazy = false)
@Transactional
public class Offer {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	 @Column(columnDefinition = "text")
	 @NotNull
	private String description;
	private Double startPrice;
	private Double currentPrice;
	private Double augmentationPrice;
	private Date startedAt;
	private Date endAt;
	private Boolean verified;
	private Boolean enabled;
	@ManyToOne
	private Seller seller;
	@OneToOne(mappedBy = "offer")
	@JsonIgnore
	private Purchase purchase;
	@OneToMany(mappedBy = "offer")
	private List<FollowOffre> followesOffre;
	@OneToMany(mappedBy = "offer")
	private List<Comment> comment;
	@OneToMany(mappedBy = "offer",cascade = CascadeType.REMOVE)
	private List<Product> products;
	@OneToMany(mappedBy = "offer",cascade = CascadeType.REMOVE)
	private List<Bid> bids;
	public Offer() {
	}

	public Offer(Long id, String name, String description, Double startPrice, Double augmentationPrice, Date startedAt,
			Date endAt, Boolean verified, Boolean enabled, Seller seller) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.startPrice = startPrice;
		this.augmentationPrice = augmentationPrice;
		this.startedAt = startedAt;
		this.endAt = endAt;
		this.verified = verified;
		this.enabled = enabled;
		this.seller = seller;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Boolean getVerified() {
		return verified;
	}

	public void setVerified(Boolean verified) {
		this.verified = verified;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
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

	public List<FollowOffre> getFollowesOffre() {
		return followesOffre;
	}

	public void setFollowesOffre(List<FollowOffre> followesOffre) {
		this.followesOffre = followesOffre;
	}

	public List<Comment> getComment() {
		return comment;
	}

	public void setComment(List<Comment> comment) {
		this.comment = comment;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Double getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(Double currentPrice) {
		this.currentPrice = currentPrice;
	}
	public List<Bid> getBids() {
		return bids;
	}
	
	public void setBids(List<Bid> bids) {
		this.bids = bids;
	}

}
