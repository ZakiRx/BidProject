package zoz.bidproject.dto;

import java.util.Date;

public class FollowDto {
	private Long id;
	private Date followed;
	private Long idBuyer;
	private String nameBuyer;
	

	
	public FollowDto() {
		
	}
	public FollowDto(Long id, Date followed, Long idBuyer, String nameBuyer) {
		this.id = id;
		this.followed = followed;
		this.idBuyer = idBuyer;
		this.nameBuyer = nameBuyer;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFollowed() {
		return followed;
	}

	public void setFollowed(Date followed) {
		this.followed = followed;
	}

	public Long getIdBuyer() {
		return idBuyer;
	}

	public void setIdBuyer(Long idBuyer) {
		this.idBuyer = idBuyer;
	}
	public String getNameBuyer() {
		return nameBuyer;
	}
	public void setNameBuyer(String nameBuyer) {
		this.nameBuyer = nameBuyer;
	}

	

}
