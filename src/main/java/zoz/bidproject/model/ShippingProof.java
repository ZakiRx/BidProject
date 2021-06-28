package zoz.bidproject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class ShippingProof {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String image;
	private String trackNumber;
	private String numPackage;
	private Boolean verified;
	
	
	public ShippingProof() {
		
	}
	@OneToOne
	private Ordre ordre;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getTrackNumber() {
		return trackNumber;
	}
	public void setTrackNumber(String trackNumber) {
		this.trackNumber = trackNumber;
	}
	public String getNumPackage() {
		return numPackage;
	}
	public void setNumPackage(String numPackage) {
		this.numPackage = numPackage;
	}
	public Boolean getVerified() {
		return verified;
	}
	public void setVerified(Boolean verified) {
		this.verified = verified;
	}
	public Ordre getOrdre() {
		return ordre;
	}
	public void setOrdre(Ordre ordre) {
		this.ordre = ordre;
	}
	
	
	
}
