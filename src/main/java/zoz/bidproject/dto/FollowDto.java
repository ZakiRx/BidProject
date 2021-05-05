package zoz.bidproject.dto;

import java.util.Date;

public class FollowDto {
	private Long id;
	private Date followed;
	private Long idBuyer;
	private Long idSeller;

	
	public FollowDto() {
		
	}
	public FollowDto(Long id, Date followed, Long idBuyer, Long idSeller) {
		this.id = id;
		this.followed = followed;
		this.idBuyer = idBuyer;
		this.idSeller = idSeller;
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

	public Long getIdSeller() {
		return idSeller;
	}

	public void setIdSeller(Long idSeller) {
		this.idSeller = idSeller;
	}

}
