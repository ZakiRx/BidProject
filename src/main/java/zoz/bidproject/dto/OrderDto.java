package zoz.bidproject.dto;

import java.util.Date;

public class OrderDto {
	private Long idOrder;
	private Date createdAtOrder;
	private Date updatedAtOrder;

	public Long getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(Long idOrder) {
		this.idOrder = idOrder;
	}

	public Date getCreatedAtOrder() {
		return createdAtOrder;
	}

	public void setCreatedAtOrder(Date createdAtOrder) {
		this.createdAtOrder = createdAtOrder;
	}

	public Date getUpdatedAtOrder() {
		return updatedAtOrder;
	}

	public void setUpdatedAtOrder(Date updatedAtOrder) {
		this.updatedAtOrder = updatedAtOrder;
	}

}
