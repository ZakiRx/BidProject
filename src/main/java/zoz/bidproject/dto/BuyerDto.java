package zoz.bidproject.dto;

public class BuyerDto {
	private Long accountIdBuyer;
	private double balanceBuyer;
	private boolean verifiedBuyer;

	public Long getAccountIdBuyer() {
		return accountIdBuyer;
	}

	public void setAccountIdBuyer(Long accountIdBuyer) {
		this.accountIdBuyer = accountIdBuyer;
	}

	public double getBalanceBuyer() {
		return balanceBuyer;
	}

	public void setBalanceBuyer(double balanceBuyer) {
		this.balanceBuyer = balanceBuyer;
	}

	public boolean isVerifiedBuyer() {
		return verifiedBuyer;
	}

	public void setVerifiedBuyer(boolean verifiedBuyer) {
		this.verifiedBuyer = verifiedBuyer;
	}

}
