package zoz.bidproject.converter;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import zoz.bidproject.dto.UserSignUpDto;
import zoz.bidproject.model.Buyer;

public class UserSignUpDtoConverter {

	public Buyer dtoToEntity(UserSignUpDto userDto) {
		String accountId = UUID.randomUUID().toString();
		if(userDto.getPassword()!=null && userDto.getPassword().equals(userDto.getConfirmePassword())) {
			Buyer buyer = new Buyer(null, userDto.getUserName(), userDto.getFirstName(), userDto.getLastName(),
					userDto.getDateBirth(), userDto.getEmail(), userDto.getPhoneNumber(), userDto.getPassword(), false,
					true, accountId, 0, false);
			return buyer;
		}
		return null;
	}

	public List<Buyer> dtoToEntity(List<UserSignUpDto> usersDto) {

		return usersDto.stream().map(b -> dtoToEntity(b)).collect(Collectors.toList());
	}
}
