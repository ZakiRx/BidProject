package zoz.bidproject.dto;

import java.time.LocalDate;
import java.util.Date;

public class BuyerDto {

	private Long id;
	
	private String userName;

	private String firstName;

	private String LastName;
	private LocalDate dateBirth;


	public BuyerDto() {

	}

	public BuyerDto(Long id, String userName, String firstName, String lastName, LocalDate dateBirth) {
		this.id = id;
		this.userName = userName;
		this.firstName = firstName;
		LastName = lastName;
		this.dateBirth = dateBirth;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public LocalDate getDateBirth() {
		return dateBirth;
	}

	public void setDateBirth(LocalDate dateBirth) {
		this.dateBirth = dateBirth;
	}



}
