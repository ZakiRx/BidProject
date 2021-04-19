package zoz.bidproject.model;

import javax.persistence.Entity;

@Entity
public class Company extends Seller {
	private String name;

	
	public Company(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
