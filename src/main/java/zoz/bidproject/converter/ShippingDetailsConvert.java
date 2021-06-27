package zoz.bidproject.converter;

import java.util.List;
import java.util.stream.Collectors;
import zoz.bidproject.dto.ShippingDetailsDto;
import zoz.bidproject.model.ShippingDetails;

public class ShippingDetailsConvert {
	public ShippingDetailsDto entityToDto(ShippingDetails shippingDetails) {
		ShippingDetailsDto shippingDetailsDto = new ShippingDetailsDto();

		return shippingDetailsDto;
	}

	public List<ShippingDetailsDto> entityToDto(List<ShippingDetails> shippingDetailss) {

		return shippingDetailss.stream().map(b -> entityToDto(b)).collect(Collectors.toList());
	}

	public ShippingDetails dtoToEntity(ShippingDetailsDto shippingDetailsDto) {
		ShippingDetails shippingDetails = new ShippingDetails();
		shippingDetails.setBillingAdress(shippingDetailsDto.getBillingAdress());
		shippingDetails.setBillingCity(shippingDetailsDto.getBillingCity());
		shippingDetails.setBillingEmail(shippingDetailsDto.getBillingEmail());
		shippingDetails.setBillingName(shippingDetailsDto.getBillingName());
		shippingDetails.setBillingPhone(shippingDetailsDto.getBillingPhone());
		shippingDetails.setBillingPostalCode(shippingDetailsDto.getBillingPostalCode());
		shippingDetails.setCountry(shippingDetailsDto.getCountry());
		shippingDetails.setShipped(false);
		return shippingDetails;
	}

	public List<ShippingDetails> dtoToEntity(List<ShippingDetailsDto> ShippingDetailssDto) {

		return ShippingDetailssDto.stream().map(b -> dtoToEntity(b)).collect(Collectors.toList());
	}
}
