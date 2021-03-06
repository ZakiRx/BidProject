package zoz.bidproject.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.transaction.Transactional;

import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Product {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;
	private String image;
	private String images; // must be Class
	private Date createdAt;
	private Date updatedAt;
	private Boolean virified;
	private String tags;
	
	@ManyToOne
	@JsonIgnore
	private Offer offer;
	@ManyToOne
	private SubCategory subCategory;
	
	public Product() {
		
	}
	public Product(Long id, String name, String description, String image, String images, Date createdAt,
			Date updatedAt, Boolean virified, String tags, Offer offre,SubCategory subCategory) {

		this.id = id;
		this.name = name;
		this.description = description;
		this.image = image;
		this.images = images;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.virified = virified;
		this.tags = tags;
		this.offer = offre;
		this.subCategory=subCategory;
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
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

	public Boolean getVirified() {
		return virified;
	}

	public void setVirified(Boolean virified) {
		this.virified = virified;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}
	@JsonIgnore
	public Offer getOffer() {
		return offer;
	}

	public void setOffre(Offer offre) {
		this.offer = offre;
	}
	public SubCategory getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(SubCategory subCategory) {
		this.subCategory = subCategory;
	}


}
