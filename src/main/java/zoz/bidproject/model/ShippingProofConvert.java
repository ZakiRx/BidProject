package zoz.bidproject.model;

import java.util.List;
import java.util.stream.Collectors;
import zoz.bidproject.dto.ShipingProofDto;

public class ShippingProofConvert {
	public ShipingProofDto entityToDto(ShippingProof shipingProof) {
		ShipingProofDto shipingProofDto = new ShipingProofDto();

		return shipingProofDto;
	}

	public List<ShipingProofDto> entityToDto(List<ShippingProof> shippingProofs) {

		return shippingProofs.stream().map(b -> entityToDto(b)).collect(Collectors.toList());
	}

	public ShippingProof dtoToEntity(ShipingProofDto shipingProofDto) {
		ShippingProof shippingProof = new ShippingProof();
		return shippingProof;
	}

	public List<ShippingProof> dtoToEntity(List<ShipingProofDto> ShippingProofsDto) {

		return ShippingProofsDto.stream().map(b -> dtoToEntity(b)).collect(Collectors.toList());
	}
}
