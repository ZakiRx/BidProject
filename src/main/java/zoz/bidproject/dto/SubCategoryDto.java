package zoz.bidproject.dto;

public class SubCategoryDto {
	private Long idCategory;
	private long idSubCategory;
	private String nameSubcategory;
	private String slugCategory;
	private String nameCategory;
	public Long getIdCategory() {
		return idCategory;
	}
	public void setIdCategory(Long idCategory) {
		this.idCategory = idCategory;
	}
	public long getIdSubCategory() {
		return idSubCategory;
	}
	public void setIdSubCategory(long idSubCategory) {
		this.idSubCategory = idSubCategory;
	}
	public String getNameSubcategory() {
		return nameSubcategory;
	}
	public void setNameSubcategory(String nameSubcategory) {
		this.nameSubcategory = nameSubcategory;
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
