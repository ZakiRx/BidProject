package zoz.bidproject.model;

import java.util.Date;

public class Product {
	private Long id;
	private String name;
	private String description;
	private String image;
	private String images; // must be Class
	private Date createdAt;
	private Date updatedAt;
	private Boolean virified;
	private String tags;
	private Offre offre;
	private SubCategory subCategory;
	
	public Product(Long id, String name, String description, String image, String images, Date createdAt,
			Date updatedAt, Boolean virified, String tags, Offre offre) {

		this.id = id;
		this.name = name;
		this.description = description;
		this.image = image;
		this.images = images;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.virified = virified;
		this.tags = tags;
		this.offre = offre;
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

	public Offre getOffre() {
		return offre;
	}

	public void setOffre(Offre offre) {
		this.offre = offre;
	}
	public SubCategory getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(SubCategory subCategory) {
		this.subCategory = subCategory;
	}


}
