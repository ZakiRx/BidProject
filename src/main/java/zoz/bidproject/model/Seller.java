package zoz.bidproject.model;

import java.util.List;

public class Seller extends Buyer {
	private List<Follow> follows;
	private List<Offre> offres;
	
	
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
	
	
}
