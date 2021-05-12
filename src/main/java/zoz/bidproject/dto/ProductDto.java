package zoz.bidproject.dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.sun.istack.NotNull;

public class ProductDto {
	private Long id;
	@NotBlank
	@NotNull
	@Size(min = 0,max = 30)
	private String name;
	@NotBlank
	@NotNull
	private String description;
	private String image;
	private String images;
	@DateTimeFormat
	private Date createdAt;
	@DateTimeFormat
	private Date updatedAt;
	private Boolean virified;
	private String tags;
	private Long idSeller;
	private String nameSeller;
	public ProductDto() {
		// TODO Auto-generated constructor stub
	}
	public ProductDto(Long id, String name, String description, String image, String images, Date createdAt,
			Date updatedAt, Boolean virified, String tags, Long idSeller,String nameSeller) {

		this.id = id;
		this.name = name;
		this.description = description;
		this.image = image;
		this.images = images;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.virified = virified;
		this.tags = tags;
		this.idSeller = idSeller;
		this.nameSeller=nameSeller;
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
	

	

}
