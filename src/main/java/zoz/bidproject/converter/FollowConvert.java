package zoz.bidproject.converter;

import java.util.List;
import java.util.stream.Collectors;
import zoz.bidproject.dto.FollowDto;
import zoz.bidproject.model.Follow;

public class FollowConvert {
	public FollowDto entityToDto(Follow follow) {
		FollowDto followDto = new FollowDto(follow.getId(),follow.getFollowedAt(),follow.getBuyer().getId(),follow.getBuyer().getUserName());

		return followDto;
	}

	public List<FollowDto> entityToDto(List<Follow> follows) {

		return follows.stream().map(f -> entityToDto(f)).collect(Collectors.toList());
	}

	public Follow dtoToEntity(FollowDto followDto) {
		Follow follow = new Follow();
		return follow;
	}

	public List<Follow> dtoToEntity(List<FollowDto> FollowsDto) {

		return FollowsDto.stream().map(b -> dtoToEntity(b)).collect(Collectors.toList());
	}
}
