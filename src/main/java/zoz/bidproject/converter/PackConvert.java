package zoz.bidproject.converter;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.criteria.Order;

import zoz.bidproject.dto.OrderDto;
import zoz.bidproject.dto.PackDto;
import zoz.bidproject.model.Pack;

public class PackConvert {
	public PackDto entityToDto(Pack pack) {
		PackDto packDto = new PackDto();

		return packDto;
	}

	public List<PackDto> entityToDto(List<Pack> packs) {

		return packs.stream().map(b -> entityToDto(b)).collect(Collectors.toList());
	}

	public Pack dtoToEntity(PackDto packDto) {
		Pack pack = new Pack();
		return pack;
	}

	public List<Pack> dtoToEntity(List<PackDto> PacksDto) {

		return PacksDto.stream().map(b -> dtoToEntity(b)).collect(Collectors.toList());
	}
}
