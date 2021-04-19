package zoz.bidproject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class ShippingDetails {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String billingEmail;
	private String billingName;
	private String country;
	private String billingAdress;
	private String billingCity;
	private String billingPostalCode;
	private String billingPhone;
	private Boolean shipped;
	@OneToOne
	private Purchase purchase;

	public ShippingDetails(Long id, String billingEmail, String billingName, String country, String billingAdress,
			String billingCity, String billingPostalCode, String billingPhone, Boolean shipped, Purchase purchase) {
		super();
		this.id = id;
		this.billingEmail = billingEmail;
		this.billingName = billingName;
		this.country = country;
		this.billingAdress = billingAdress;
		this.billingCity = billingCity;
		this.billingPostalCode = billingPostalCode;
		this.billingPhone = billingPhone;
		this.shipped = shipped;
		this.purchase = purchase;
	}

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

	public Purchase getPurchase() {
		return purchase;
	}

	public void setPurchase(Purchase purchase) {
		this.purchase = purchase;
	}

}
