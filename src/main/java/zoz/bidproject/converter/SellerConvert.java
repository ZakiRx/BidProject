package zoz.bidproject.converter;

import java.util.List;
import java.util.stream.Collectors;

import zoz.bidproject.dto.RoleDto;
import zoz.bidproject.dto.SellerDto;
import zoz.bidproject.model.Role;
import zoz.bidproject.model.Seller;

public class SellerConvert {
	public SellerDto entityToDto(Seller seller) {
		SellerDto sellerDto = new SellerDto();

		return sellerDto;
	}

	public List<SellerDto> entityToDto(List<Seller> sellers) {

		return sellers.stream().map(b -> entityToDto(b)).collect(Collectors.toList());
	}
	public Seller dtoToEntity(SellerDto sellerDto) {
		Seller seller = new Seller();
		return seller;
	}

	public List<Seller> dtoToEntity(List<SellerDto> sellersDto) {

		return sellersDto.stream().map(b -> dtoToEntity(b)).collect(Collectors.toList());
	}
}
