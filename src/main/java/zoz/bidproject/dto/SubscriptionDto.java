package zoz.bidproject.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class SubscriptionDto {
	private Long id;
	private Long packId; 
	@DateTimeFormat
	private Date createdAt;
	@DateTimeFormat
	private Date endAt;
	private Boolean enabled;
	
	public SubscriptionDto() {
		// TODO Auto-generated constructor stub
	}
	public SubscriptionDto(Long id, Date createdAt, Date endAt, Boolean enabled,long packId) {
		
		this.id = id;
		this.createdAt = createdAt;
		this.endAt = endAt;
		this.enabled = enabled;
		this.packId=packId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getEndAt() {
		return endAt;
	}

	public void setEndAt(Date endAt) {
		this.endAt = endAt;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	public Long getPackId() {
		return packId;
	}
	public void setPackId(Long packId) {
		this.packId = packId;
	}
	

}
