package zoz.bidproject.converter;

import java.util.List;
import java.util.stream.Collectors;
import zoz.bidproject.dto.FollowOffreDto;
import zoz.bidproject.model.FollowOffre;

public class FollowOffreConvert {
	public FollowOffreDto entityToDto(FollowOffre followOffre) {
		FollowOffreDto followOffreDto = new FollowOffreDto();

		return followOffreDto;
	}

	public List<FollowOffreDto> entityToDto(List<FollowOffre> followOffres) {

		return followOffres.stream().map(b -> entityToDto(b)).collect(Collectors.toList());
	}

	public FollowOffre dtoToEntity(FollowOffreDto followOffreDto) {
		FollowOffre followOffre = new FollowOffre();
		return followOffre;
	}

	public List<FollowOffre> dtoToEntity(List<FollowOffreDto> FollowOffresDto) {

		return FollowOffresDto.stream().map(b -> dtoToEntity(b)).collect(Collectors.toList());
	}

}
