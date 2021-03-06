package zoz.bidproject.converter;

import java.util.List;
import java.util.stream.Collectors;


import zoz.bidproject.dto.BidDto;
import zoz.bidproject.model.Bid;
import zoz.bidproject.model.Buyer;
import zoz.bidproject.model.Offer;


public class BidConvert {

	public BidDto entityToDto(Bid bid) {
		BidDto bidDto = new BidDto(bid.getId(), bid.getPrice(), bid.getBuyer().getId(), bid.getBuyer().getUserName(),
				bid.getOffer().getId(), bid.getOffer().getName());

		return bidDto;
	}

	public List<BidDto> entityToDto(List<Bid> bids) {

		return bids.stream().map(b -> entityToDto(b)).collect(Collectors.toList());
	}

	public Bid dtoToEntity(BidDto bidDto) {
		Offer offer = new Offer();
				offer.setId(bidDto.getIdOffer());
		Bid bid = new Bid(bidDto.getId(), bidDto.getPrice(),null,offer);
		return bid;
	}

	public List<Bid> dtoToEntity(List<BidDto> bidsDto) {

		return bidsDto.stream().map(b -> dtoToEntity(b)).collect(Collectors.toList());
	}
}
