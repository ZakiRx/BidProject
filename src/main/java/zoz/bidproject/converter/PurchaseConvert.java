package zoz.bidproject.converter;

import java.util.List;
import java.util.stream.Collectors;
import zoz.bidproject.dto.PurchaseDto;
import zoz.bidproject.model.Purchase;

public class PurchaseConvert {
	public PurchaseDto entityToDto(Purchase purchase) {
		PurchaseDto purchaseDto = new PurchaseDto();

		return purchaseDto;
	}

	public List<PurchaseDto> entityToDto(List<Purchase> purchases) {

		return purchases.stream().map(b -> entityToDto(b)).collect(Collectors.toList());
	}

	public Purchase dtoToEntity(PurchaseDto purchaseDto) {
		Purchase purchase = new Purchase();
		return purchase;
	}

	public List<Purchase> dtoToEntity(List<PurchaseDto> purchasesDto) {

		return purchasesDto.stream().map(b -> dtoToEntity(b)).collect(Collectors.toList());
	}
}
