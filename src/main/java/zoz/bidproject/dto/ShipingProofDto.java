package zoz.bidproject.dto;

import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

public class ShipingProofDto {
	private Long id;
	@NotBlank
	@NotNull
	private String image;
	@NotBlank
	@NotNull
	private String trackNumber;
	@NotBlank
	@NotNull
	private String numPackage;
	private Boolean verified;

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

}
