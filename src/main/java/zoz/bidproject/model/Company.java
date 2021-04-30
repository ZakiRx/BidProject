package zoz.bidproject.model;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Company extends Seller {

	private String name;

	public Company(Long id, String userName, String firstName, String lastName, Date dateBirth, String email,
			String phoneNumber, String password, Boolean enabled, Boolean actif, Long accountId, double balance,
			String name, boolean verified) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
