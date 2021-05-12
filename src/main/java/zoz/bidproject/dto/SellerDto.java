package zoz.bidproject.dto;

import java.time.LocalDate;
import java.util.Date;

import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

import com.sun.istack.NotNull;

public class SellerDto {
	private Long id;
	@NotBlank
	@NotNull
	private String userName;
	@NotBlank
	@NotNull
	private String firstName;
	@NotBlank
	@NotNull
	private String LastName;
	private String type;
	 @DateTimeFormat
	private LocalDate dateBirth;

	public SellerDto() {
		// TODO Auto-generated constructor stub
	}

	public SellerDto(Long id, String userName, String firstName, String lastName,String type, LocalDate dateBirth) {
		this.id = id;
		this.userName = userName;
		this.firstName = firstName;
		LastName = lastName;
		this.dateBirth = dateBirth;
		this.type=type;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	

}
