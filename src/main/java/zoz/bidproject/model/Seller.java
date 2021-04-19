package zoz.bidproject.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Seller extends Buyer {
	@OneToMany(mappedBy = "seller")
	private List<Follow> follows;
	@OneToMany(mappedBy = "seller")
	private List<Offer> offres;
	@OneToMany(mappedBy = "seller")
	private List<Ordre> ordres;
	@OneToOne(mappedBy = "seller")
	private Subscription subscription;
	
	public List<Follow> getFollows() {
		return follows;
	}

	public void setFollows(List<Follow> follows) {
		this.follows = follows;
	}

	public List<Offer> getOffres() {
		return offres;
	}

	public void setOffres(List<Offer> offres) {
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
