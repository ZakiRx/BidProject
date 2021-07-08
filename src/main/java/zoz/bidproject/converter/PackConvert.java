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
		packDto.setName(pack.getName());
		packDto.setNbrDays(pack.getNbrDays());
		packDto.setDetails(pack.getDetails());
		packDto.setId(pack.getId());
		packDto.setPrice(pack.getPrice());
		return packDto;
	}

	public List<PackDto> entityToDto(List<Pack> packs) {

		return packs.stream().map(b -> entityToDto(b)).collect(Collectors.toList());
	}

	public Pack dtoToEntity(PackDto packDto) {
		Pack pack = new Pack(packDto.getId(), packDto.getName(), packDto.getNbrDays(), packDto.getDetails());
		pack.setPrice(packDto.getPrice());
		return pack;
	}

	public List<Pack> dtoToEntity(List<PackDto> PacksDto) {

		return PacksDto.stream().map(b -> dtoToEntity(b)).collect(Collectors.toList());
	}
}
