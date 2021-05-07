package zoz.bidproject.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import zoz.bidproject.dto.OfferDto;
import zoz.bidproject.model.Offer;
import zoz.bidproject.model.Seller;
import zoz.bidproject.service.SellerService;

public class OfferConvert {
	@Autowired
	private SellerService sellerService;
	public OfferDto entityToDto(Offer offer) {
		OfferDto offerDto = new OfferDto(offer.getId(),offer.getName(),offer.getDescription(),offer.getStartPrice(),offer.getAugmentationPrice(),offer.getCurrentPrice(),offer.getStartedAt(),offer.getEndAt(),offer.getSeller().getId(),offer.getSeller().getUserName(),offer.getComment(),offer.getProducts(),offer.getBids());
		
		return offerDto;
	}

	public List<OfferDto> entityToDto(List<Offer> Offers) {

		return Offers.stream().map(b -> entityToDto(b)).collect(Collectors.toList());
	}

	public Offer dtoToEntity(OfferDto offerDto) {
		Seller seller = sellerService.getSeller(offerDto.getId());
		Offer offer = new Offer(null,offerDto.getName(),offerDto.getDescription(),offerDto.getStartPrice(),offerDto.getAugmentationPrice(),offerDto.getStartedAt(),offerDto.getEndAt(),false,false,seller);
		return offer;
	}

	public List<Offer> dtoToEntity(List<OfferDto> OffersDto) {

		return OffersDto.stream().map(b -> dtoToEntity(b)).collect(Collectors.toList());
	}

}
