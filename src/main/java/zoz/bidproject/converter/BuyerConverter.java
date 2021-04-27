package zoz.bidproject.converter;

import java.util.List;

import java.util.stream.Collectors;

import zoz.bidproject.dto.BuyerDto;
import zoz.bidproject.model.Buyer;

public class BuyerConverter {

	public BuyerDto entityToDto(Buyer buyer) {
		BuyerDto buyerDto= new BuyerDto();
		
		return buyerDto;
	}
	public List<BuyerDto> entityToDto(List<Buyer> buyers) {
	
		
		return buyers.stream().map(b->entityToDto(b)).collect(Collectors.toList());
	}
	public Buyer dtoToEntity(BuyerDto buyerDto) {
		Buyer buyer = new Buyer();
		return buyer;
	}
	public List<Buyer> dtoToEntity(List<BuyerDto> buyersDto) {
		
		return buyersDto.stream().map(b->dtoToEntity(b)).collect(Collectors.toList());
	}
}
