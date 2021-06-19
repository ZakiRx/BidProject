package zoz.bidproject.dto;

import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

public class ShippingDetailsDto {

	private Long id;
	@NotBlank
	@NotNull
	private String billingEmail;
	@NotBlank
	@NotNull
	private String billingName;
	@NotBlank
	@NotNull
	private String country;
	@NotBlank
	@NotNull
	private String billingAdress;
	@NotBlank
	@NotNull
	private String billingCity;
	@NotBlank
	@NotNull
	private String billingPostalCode;
	@NotBlank
	@NotNull
	private String billingPhone;
	private Boolean shipped;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBillingEmail() {
		return billingEmail;
	}

	public void setBillingEmail(String billingEmail) {
		this.billingEmail = billingEmail;
	}

	public String getBillingName() {
		return billingName;
	}

	public void setBillingName(String billingName) {
		this.billingName = billingName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getBillingAdress() {
		return billingAdress;
	}

	public void setBillingAdress(String billingAdress) {
		this.billingAdress = billingAdress;
	}

	public String getBillingCity() {
		return billingCity;
	}

	public void setBillingCity(String billingCity) {
		this.billingCity = billingCity;
	}

	public String getBillingPostalCode() {
		return billingPostalCode;
	}

	public void setBillingPostalCode(String billingPostalCode) {
		this.billingPostalCode = billingPostalCode;
	}

	public String getBillingPhone() {
		return billingPhone;
	}

	public void setBillingPhone(String billingPhone) {
		this.billingPhone = billingPhone;
	}

	public Boolean getShipped() {
		return shipped;
	}

	public void setShipped(Boolean shipped) {
		this.shipped = shipped;
	}

}
