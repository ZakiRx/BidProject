package zoz.bidproject.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import zoz.bidproject.dto.BidDto;
import zoz.bidproject.dto.CommentDto;
import zoz.bidproject.dto.OfferDto;
import zoz.bidproject.model.Offer;
import zoz.bidproject.model.Seller;
import zoz.bidproject.service.SellerService;

public class OfferConvert {

	private SellerService sellerService;
	private BidConvert bidConvert;
	private CommentConvert commentConvert;

	public OfferConvert() {
		bidConvert = new BidConvert();
		commentConvert = new CommentConvert();
		sellerService = new SellerService();
	}

	public OfferDto entityToDto(Offer offer) {
		List<BidDto> bids = bidConvert.entityToDto(offer.getBids());
		List<CommentDto> comments = commentConvert.entityToDto(offer.getComment());
		OfferDto offerDto = new OfferDto(offer.getId(), offer.getName(), offer.getDescription(), offer.getStartPrice(),
				offer.getAugmentationPrice(), offer.getCurrentPrice(), offer.getStartedAt(), offer.getEndAt(),
				offer.getSeller().getId(), offer.getSeller().getUserName(), comments, offer.getProducts(), bids);

		return offerDto;
	}

	public List<OfferDto> entityToDto(List<Offer> Offers) {

		return Offers.stream().map(b -> entityToDto(b)).collect(Collectors.toList());
	}

	public Offer dtoToEntity(OfferDto offerDto) {
		Offer offer = new Offer(offerDto.getId(), offerDto.getName(), offerDto.getDescription(),
				offerDto.getStartPrice(), offerDto.getAugmentationPrice(), offerDto.getStartedAt(), offerDto.getEndAt(),
				false, false, null);
		offer.setCurrentPrice(offerDto.getCurrentPrice() == null ? 0 : offerDto.getCurrentPrice());
		return offer;
	}

	public List<Offer> dtoToEntity(List<OfferDto> OffersDto) {

		return OffersDto.stream().map(b -> dtoToEntity(b)).collect(Collectors.toList());
	}

}
