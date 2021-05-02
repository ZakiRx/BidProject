package zoz.bidproject.dto;

public class CategoryDto {
	private Long idCategory;
	private String slugCategory;
	private String nameCategory;

	public Long getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(Long idCategory) {
		this.idCategory = idCategory;
	}

	public String getSlugCategory() {
		return slugCategory;
	}

	public void setSlugCategory(String slugCategory) {
		this.slugCategory = slugCategory;
	}

	public String getNameCategory() {
		return nameCategory;
	}

	public void setNameCategory(String nameCategory) {
		this.nameCategory = nameCategory;
	}

}
