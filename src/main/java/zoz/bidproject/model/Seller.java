package zoz.bidproject.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Proxy;
import org.springframework.context.annotation.Lazy;

@Entity
@Proxy(lazy = false)
public class Seller extends Buyer {
	@OneToMany(mappedBy = "seller")
	private List<Follow> follows;
	@OneToMany(mappedBy = "seller",cascade = CascadeType.ALL)
	private List<Offer> offres;
	@OneToMany(mappedBy = "seller",cascade = CascadeType.ALL)
	private List<Ordre> ordres;
	

	public Seller() {
	     offres= new ArrayList<Offer>();
	}
	public Seller(Long id, String userName, String firstName, String lastName, Date dateBirth, String email,
			String phoneNumber, String password, Boolean enabled, Boolean actif, Long accountId, double balance,
			boolean verified) {
		super(id, userName, firstName, lastName, dateBirth, email, phoneNumber, password, enabled, actif, accountId,
				balance, verified);
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
