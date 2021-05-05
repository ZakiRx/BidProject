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

import org.hibernate.annotations.DiscriminatorFormula;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


@MappedSuperclass
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)

public abstract class User {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 25)
	private String userName;
	@Column(length = 25)
	private String firstName;
	@Column(length = 25)
	private String LastName;
	private LocalDate dateBirth;
	private String email;
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
