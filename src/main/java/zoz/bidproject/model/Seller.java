package zoz.bidproject.model;

import java.util.List;

public class Seller extends Buyer {
	private List<Follow> follows;
	private List<Offre> offres;
	private List<Ordre> ordres;
	private Subscription subscription ;
	
	public List<Follow> getFollows() {
		return follows;
	}

	public void setFollows(List<Follow> follows) {
		this.follows = follows;
	}

	public List<Offre> getOffres() {
		return offres;
	}

	public void setOffres(List<Offre> offres) {
		this.offres = offres;
	}

	public List<Ordre> getOrdres() {
		return ordres;
	}

	public void setOrdres(List<Ordre> ordres) {
		this.ordres = ordres;
	}

	public Subscription getSubscription() {
		return subscription;
	}

	public void setSubscription(Subscription subscription) {
		this.subscription = subscription;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this==obj) return true;
		if(obj instanceof Seller) {
		  return ((Seller)obj).getId()==this.getId();
		}
		return false;
	}
	
	
	
}
