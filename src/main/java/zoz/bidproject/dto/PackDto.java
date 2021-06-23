package zoz.bidproject.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

public class PackDto {
	private Long id;
	@NotNull
	@NotBlank(message = "name package must be not blank")
	private String name;
	@Min(value = 0)
	private Integer nbrDays;
	@NotBlank
	@NotNull
	private String details;

	@NotNull
	@Min(value = 1)
	private Long price;

	public PackDto() {
		// TODO Auto-generated constructor stub
	}

	public PackDto(Long id, String name, Integer nbrDays, String details) {
		super();
		this.id = id;
		this.name = name;
		this.nbrDays = nbrDays;
		this.details = details;
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

	public Integer getNbrDays() {
		return nbrDays;
	}

	public void setNbrDays(Integer nbrDays) {
		this.nbrDays = nbrDays;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	
}
