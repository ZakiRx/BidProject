package zoz.bidproject.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Pack {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private Integer nbrDays;
	private String details;
	private String planId;
	private Long price;
	@OneToMany(mappedBy = "pack")
	@JsonIgnore
	private List<Subscription> subcriptions;

	public Pack() {

	}

	public Pack(Long id, String name, Integer nbrDays, String details) {

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

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public List<Subscription> getSubcriptions() {
		return subcriptions;
	}

	public void setSubcriptions(List<Subscription> subcriptions) {
		this.subcriptions = subcriptions;
	}

	public Integer getNbrDays() {
		return nbrDays;
	}

	public void setNbrDays(Integer nbrDays) {
		this.nbrDays = nbrDays;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public String getPlanId() {
		return planId;
	}

	public void setPlanId(String planId) {
		this.planId = planId;
	}
	
	

	
}
