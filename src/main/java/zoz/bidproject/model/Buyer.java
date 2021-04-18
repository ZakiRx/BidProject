package zoz.bidproject.model;

import java.util.List;

public class Buyer extends User {
	private Long accountId;
	private double balance;
	private boolean verified;
	private List<Follow> follows;
	private List<FollowOffer> followOffres;
	private List<Purchase> purchases;
	private List<Comment> comments;

	public List<Follow> getFollows() {
		return follows;
	}

	public void setFollows(List<Follow> follows) {
		this.follows = follows;
	}

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

	public List<FollowOffer> getFollowOffres() {
		return followOffres;
	}

	public void setFollowOffres(List<FollowOffer> followOffres) {
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
	

}
