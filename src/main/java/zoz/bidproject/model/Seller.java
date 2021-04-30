package zoz.bidproject.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Proxy;
import org.springframework.context.annotation.Lazy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeName;

@Entity
@Proxy(lazy = false)
public class Seller extends Buyer {
	@OneToMany(mappedBy = "seller")
	@JsonIgnore
	private List<Follow> follows;
	@OneToMany(mappedBy = "seller",cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Offer> offres;
	@OneToMany(mappedBy = "seller",cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Ordre> ordres;
	@OneToOne(mappedBy = "seller", cascade = CascadeType.ALL)
	@JsonIgnore
	private Subscription subscription;
	public Seller() {
	     offres= new ArrayList<Offer>();
	}
	public Seller(Buyer buyer) {
		super(buyer.getId(), buyer.getUserName(), buyer.getFirstName(), buyer.getLastName(), buyer.getDateBirth(), buyer.getEmail(), buyer.getPhoneNumber(), buyer.getPassword(), buyer.isEnabled(), buyer.isActive(), buyer.getAccountId(),
				buyer.getBalance(), buyer.isVerified());
	}

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
		if (this == obj)
			return true;
		if (obj instanceof Seller) {
			return ((Seller) obj).getId() == this.getId();
		}
		return false;
	}

}
