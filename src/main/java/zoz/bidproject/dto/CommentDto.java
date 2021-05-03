package zoz.bidproject.dto;

import java.util.Date;

public class CommentDto {
	private Long idCmt;
	private String commentCmt;
	private Date createdAtCmt;
	private Date updatedAtCmt;
	private Boolean actifCmt;

	public Long getIdCmt() {
		return idCmt;
	}

	public void setIdCmt(Long idCmt) {
		this.idCmt = idCmt;
	}

	public String getCommentCmt() {
		return commentCmt;
	}

	public void setCommentCmt(String commentCmt) {
		this.commentCmt = commentCmt;
	}

	public Date getCreatedAtCmt() {
		return createdAtCmt;
	}

	public void setCreatedAtCmt(Date createdAtCmt) {
		this.createdAtCmt = createdAtCmt;
	}

	public Date getUpdatedAtCmt() {
		return updatedAtCmt;
	}

	public void setUpdatedAtCmt(Date updatedAtCmt) {
		this.updatedAtCmt = updatedAtCmt;
	}

	public Boolean getActifCmt() {
		return actifCmt;
	}

	public void setActifCmt(Boolean actifCmt) {
		this.actifCmt = actifCmt;
	}

}
