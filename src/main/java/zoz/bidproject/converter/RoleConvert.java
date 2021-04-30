package zoz.bidproject.converter;

import java.util.List;
import java.util.stream.Collectors;
import zoz.bidproject.dto.RoleDto;
import zoz.bidproject.model.Role;

public class RoleConvert {
	public RoleDto entityToDto(Role role) {
		RoleDto roleDto = new RoleDto();

		return roleDto;
	}

	public List<RoleDto> entityToDto(List<Role> roles) {

		return roles.stream().map(b -> entityToDto(b)).collect(Collectors.toList());
	}

	public Role dtoToEntity(RoleDto roleDto) {
		Role role = new Role();
		return role;
	}

	public List<Role> dtoToEntity(List<RoleDto> rolesDto) {

		return rolesDto.stream().map(b -> dtoToEntity(b)).collect(Collectors.toList());
	}
}
