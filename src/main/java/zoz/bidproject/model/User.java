package zoz.bidproject.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DiscriminatorFormula;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.sun.istack.NotNull;


@MappedSuperclass
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)


public abstract class User {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 25)
	@NotBlank(message = "UserName Not Should be blank ")
	@NotNull
	@Size(min = 3,max = 20,message = "Username must be between 6 and 20 charachter")
	private String userName;
	
	@Column(length = 25)
	@NotBlank(message = "FirstName Not Should be blank ")
	@NotNull
	@Size(min = 3,max = 25,message = "firstName must be between 6 and 20 charachter")
	private String firstName;
	@Column(length = 25)
	@NotBlank(message = "LastName Not Should be blank ")
	@NotNull
	@Size(min = 3,max = 25,message = "lastName must be between 6 and 20 charachter")
	private String LastName;
	//@DateTimeFormat(pattern = "mm-dd-yyyy")
	private LocalDate dateBirth;
	@Email(message = "Email non valid")
	private String email;
	@NotBlank(message = "Password Not Should be blank ")
	@NotNull
	private String phoneNumber;

	private String password;
	private Boolean enabled;
	private Boolean active;
	

	public User() {

	}
	  @JsonCreator
	public User(Long id, String userName, String firstName, String lastName, LocalDate dateBirth, String email,
			String phoneNumber, String password, Boolean enabled, Boolean actif) {
		this.id = id;
		this.userName = userName;
		this.firstName = firstName;
		LastName = lastName;
		this.dateBirth = dateBirth;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.enabled = enabled;
		this.active = actif;
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

	public Boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Boolean isActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

}
