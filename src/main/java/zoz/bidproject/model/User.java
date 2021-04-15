package zoz.bidproject.model;

import java.util.Date;

public abstract class User {

	private Long id;
	private String userName;
	private String firstName;
	private String LastName;
	private Date dateBirth;
	private String email;
	private String phoneNumber;
	private String password;
	private Boolean enabled;
	private Boolean actif;

	public User() {

	}

	public User(Long id, String userName, String firstName, String lastName, Date dateBirth, String email,
			String phoneNumber, String password, Boolean enabled, Boolean actif) {
		super();
		this.id = id;
		this.userName = userName;
		this.firstName = firstName;
		LastName = lastName;
		this.dateBirth = dateBirth;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.enabled = enabled;
		this.actif = actif;
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

	public Date getDateBirth() {
		return dateBirth;
	}

	public void setDateBirth(Date dateBirth) {
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

	public Boolean isActif() {
		return actif;
	}

	public void setActif(Boolean actif) {
		this.actif = actif;
	}

}
