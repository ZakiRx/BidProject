package zoz.bidproject.converter;

import java.util.List;
import java.util.stream.Collectors;
import zoz.bidproject.dto.OfferDto;
import zoz.bidproject.model.Offer;

public class OfferConvert {
	public OfferDto entityToDto(Offer offer) {
		OfferDto offerDto = new OfferDto();

		return offerDto;
	}

	public List<OfferDto> entityToDto(List<Offer> Offers) {

		return Offers.stream().map(b -> entityToDto(b)).collect(Collectors.toList());
	}

	public Offer dtoToEntity(OfferDto offerDto) {
		Offer offer = new Offer();
		return offer;
	}

	public List<Offer> dtoToEntity(List<OfferDto> OffersDto) {

		return OffersDto.stream().map(b -> dtoToEntity(b)).collect(Collectors.toList());
	}

}
