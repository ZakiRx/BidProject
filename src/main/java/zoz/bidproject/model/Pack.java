package zoz.bidproject.model;

import java.util.List;

public class Pack {
	private Long id;
	private String name;
	private String details;
	private List<Subscription> subcriptions;
	
	public  Pack() {
		
	}
	public Pack(Long id, String name, String details) {
		
		this.id = id;
		this.name = name;
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
	
}
