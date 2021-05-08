package zoz.bidproject.dto;

import java.util.Date;

public class CommentDto {
	private Long id;
	private String comment;
	private Long idBuyer;
	private String nameBuyer;
	private Date createdAt;
	private Date updatedAt;
	
	

	public CommentDto() {
		// TODO Auto-generated constructor stub
	}
	public CommentDto(Long id, String comment, Date createdAt, Date updatedAt,Long idBuyer,String nameBuyer) {
		
		this.id = id;
		this.comment = comment;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.idBuyer=idBuyer;
		this.nameBuyer=nameBuyer;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
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
