package zoz.bidproject.dto;

import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

public class SubCategoryDto {
	private Long id;
	@NotBlank
	@NotNull
	private Long idCategory;
	@NotBlank
	@NotNull
	private String name;
	
	
	public SubCategoryDto() {
		// TODO Auto-generated constructor stub
	}
	
	public SubCategoryDto(Long id, Long idCategory, String name) {
		this.id = id;
		this.idCategory = idCategory;
		this.name = name;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getIdCategory() {
		return idCategory;
	}
	public void setIdCategory(Long idCategory) {
		this.idCategory = idCategory;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	

}
