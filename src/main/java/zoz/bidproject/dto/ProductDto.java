package zoz.bidproject.dto;

import java.util.Date;

public class ProductDto {
	private Long idProduct;
	private String nameProduct;
	private String descriptionProduct;
	private String imageProduct;
	private String imagesProduct;
	private Date createdAtProduct;
	private Date updatedAtProduct;
	private Boolean virifiedProduct;
	private String tagsProduct;

	public Long getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(Long idProduct) {
		this.idProduct = idProduct;
	}

	public String getNameProduct() {
		return nameProduct;
	}

	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}

	public String getDescriptionProduct() {
		return descriptionProduct;
	}

	public void setDescriptionProduct(String descriptionProduct) {
		this.descriptionProduct = descriptionProduct;
	}

	public String getImageProduct() {
		return imageProduct;
	}

	public void setImageProduct(String imageProduct) {
		this.imageProduct = imageProduct;
	}

	public String getImagesProduct() {
		return imagesProduct;
	}

	public void setImagesProduct(String imagesProduct) {
		this.imagesProduct = imagesProduct;
	}

	public Date getCreatedAtProduct() {
		return createdAtProduct;
	}

	public void setCreatedAtProduct(Date createdAtProduct) {
		this.createdAtProduct = createdAtProduct;
	}

	public Date getUpdatedAtProduct() {
		return updatedAtProduct;
	}

	public void setUpdatedAtProduct(Date updatedAtProduct) {
		this.updatedAtProduct = updatedAtProduct;
	}

	public Boolean getVirifiedProduct() {
		return virifiedProduct;
	}

	public void setVirifiedProduct(Boolean virifiedProduct) {
		this.virifiedProduct = virifiedProduct;
	}

	public String getTagsProduct() {
		return tagsProduct;
	}

	public void setTagsProduct(String tagsProduct) {
		this.tagsProduct = tagsProduct;
	}

}
