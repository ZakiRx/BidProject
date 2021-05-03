package zoz.bidproject.dto;

public class PackDto {
	private Long id;
	private String name;
	private Integer nbrDays;
	private String details;

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

}
