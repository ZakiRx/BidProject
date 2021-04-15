package zoz.bidproject.model;

import java.util.Date;

public class Subscription {
	private Long id;
	private String name;
	private Date createdAt;
	private Date endAt;
	private Boolean enabled;
	private Seller seller;
	private Pack pack;
	public Subscription(Long id, String name, Date createdAt, Date endAt, Boolean enabled,Seller seller,Pack pack) {
		this.id = id;
		this.name = name;
		this.createdAt = createdAt;
		this.endAt = endAt;
		this.enabled = enabled;
		this.seller=seller;
		this.pack=pack;
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

	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}


	public Pack getPack() {
		return pack;
	}


	public void setPack(Pack pack) {
		this.pack = pack;
	}
	
	

}
