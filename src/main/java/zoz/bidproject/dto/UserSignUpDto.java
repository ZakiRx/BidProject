package zoz.bidproject.dto;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.sun.istack.NotNull;

public class UserSignUpDto {
	
	@Column(length = 25)
	@NotBlank(message = "UserName Not Should be blank ")
	@NotNull
	@Size(min = 6,max = 20,message = "Username must be between 6 and 20 charachter")
	private String userName;
	@NotNull
	@Size(min = 6,max = 20,message = "Username must be between 6 and 20 charachter")
	private String firstName;
	@NotNull
	@Size(min = 6,max = 20,message = "Username must be between 6 and 20 charachter")
	private String LastName;
	@DateTimeFormat
	private LocalDate dateBirth;
	@Email
	private String email;
	@NotBlank
	private String phoneNumber;
	@NotBlank
	@NotNull
	private String password;
	@NotBlank
	@NotNull
	private String confirmePassword;
	
	
	public UserSignUpDto() {
		// TODO Auto-generated constructor stub
	}
	public UserSignUpDto(String userName, String firstName, String lastName, LocalDate dateBirth, String email,
			String phoneNumber, String password, String confirmePassword) {
		this.userName = userName;
		this.firstName = firstName;
		LastName = lastName;
		this.dateBirth = dateBirth;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.confirmePassword = confirmePassword;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmePassword() {
		return confirmePassword;
	}
	public void setConfirmePassword(String confirmePassword) {
		this.confirmePassword = confirmePassword;
	}
	
	
	
}
