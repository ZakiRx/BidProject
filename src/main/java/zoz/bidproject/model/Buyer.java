package zoz.bidproject.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class Buyer extends User {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

	

	public Buyer() {

	}

	public Buyer(Long accountId, double balance, boolean verified) {

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
	

}
