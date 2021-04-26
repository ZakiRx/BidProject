package zoz.bidproject.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.DiscriminatorFormula;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeName;

@Entity
@Proxy(lazy = false)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue(value = "Buyer")

public class Buyer extends User {

	private Long accountId;
	private double balance;
	private boolean verified;
	@Column(name = "type",insertable = false,updatable = false)
	private String type;
	
	@OneToMany(mappedBy = "buyer")
	@JsonIgnore
	private List<Follow> follows;
	@OneToMany(mappedBy = "buyer")
	@JsonIgnore
	private List<FollowOffre> followOffres;
	@OneToMany(mappedBy = "buyer")
	@JsonIgnore
	private List<Purchase> purchases;
	@OneToMany(mappedBy = "buyer")
	@JsonIgnore
	private List<Comment> comments;


	@OneToMany(mappedBy = "buyer", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Bid> bids;

	public Buyer() {

	}

	public Buyer(Long id, String userName, String firstName, String lastName, Date dateBirth, String email,
			String phoneNumber, String password, Boolean enabled, Boolean actif, Long accountId, double balance,
			boolean verified) {
		super(id, userName, firstName, lastName, dateBirth, email, phoneNumber, password, enabled, actif);
		this.accountId = accountId;
		this.balance = balance;
		this.verified = verified;
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public boolean isVerified() {
		return verified;
	}

	public void setVerified(boolean verified) {
		this.verified = verified;
	}

	public List<FollowOffre> getFollowOffres() {
		return followOffres;
	}

	public void setFollowOffres(List<FollowOffre> followOffres) {
		this.followOffres = followOffres;
	}

	public List<Purchase> getPurchases() {
		return purchases;
	}

	public void setPurchases(List<Purchase> purchases) {
		this.purchases = purchases;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public List<Follow> getFollows() {
		return follows;
	}

	public void setFollows(List<Follow> follows) {
		this.follows = follows;
	}



	public List<Bid> getBids() {
		return bids;
	}

	public void setBids(List<Bid> bids) {
		this.bids = bids;
	}


	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}


	
	

}
