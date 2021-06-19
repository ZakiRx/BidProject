package zoz.bidproject.dto;

import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

public class RoleDto {
	private Integer id;
	@NotBlank
	@NotNull
	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
