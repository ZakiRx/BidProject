package zoz.bidproject.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Buyer extends User {

	@Column(unique = true)
	private Long accountId;
	private double balance;
	private boolean verified;
	@OneToMany(mappedBy = "buyer")
	private List<Follow> follows;
	@OneToMany(mappedBy = "buyer")
	private List<FollowOffre> followOffres;
	@OneToMany(mappedBy = "buyer")
	private List<Purchase> purchases;
	@OneToMany(mappedBy = "buyer")
	private List<Comment> comments;
	@OneToOne(mappedBy = "buyer",cascade = CascadeType.ALL)
	private Subscription subscription;
	@OneToMany(mappedBy = "buyer",cascade = CascadeType.ALL)
	private List<Bid> bids;
	public Buyer() {

	}

	public Buyer(Long id, String userName, String firstName, String lastName, Date dateBirth, String email,
			String phoneNumber, String password, Boolean enabled, Boolean actif, Long accountId, double balance, boolean verified) {
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

	public Subscription getSubscription() {
		
		return subscription;
	}
	public void setSubscription(Subscription subscription) {
		this.subscription = subscription;
	}
	
	public List<Bid> getBids() {
		return bids;
	}
	public void setBids(List<Bid> bids) {
		this.bids = bids;
	}

}
