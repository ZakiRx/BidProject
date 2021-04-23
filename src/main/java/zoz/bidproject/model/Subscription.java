package zoz.bidproject.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Subscription {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date createdAt;
	private Date endAt;
	private Boolean enabled;
	@OneToOne
	private Buyer buyer;
	@ManyToOne
	private Pack pack;
	
	public Subscription() {
		
	}
	public Subscription(Long id, Date createdAt, Date endAt, Boolean enabled,Buyer buyer,Pack pack) {
		this.id = id;
		this.createdAt = createdAt;
		this.endAt = endAt;
		this.enabled = enabled;
		this.buyer=buyer;
		this.pack=pack;
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

	public Buyer getBuyer() {
		return buyer;
	}

	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}


	public Pack getPack() {
		return pack;
	}


	public void setPack(Pack pack) {
		this.pack = pack;
	}
	
	

}
