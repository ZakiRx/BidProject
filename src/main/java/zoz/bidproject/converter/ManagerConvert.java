package zoz.bidproject.converter;

import java.util.List;
import java.util.stream.Collectors;
import zoz.bidproject.dto.ManagerDto;
import zoz.bidproject.model.Manager;

public class ManagerConvert {
	public ManagerDto entityToDto(Manager manager) {
		ManagerDto managerDto = new ManagerDto();

		return managerDto;
	}

	public List<ManagerDto> entityToDto(List<Manager> managers) {

		return managers.stream().map(b -> entityToDto(b)).collect(Collectors.toList());
	}

	public Manager dtoToEntity(ManagerDto managerDto) {
		Manager manager = new Manager();
		return manager;
	}

	public List<Manager> dtoToEntity(List<ManagerDto> ManagersDto) {

		return ManagersDto.stream().map(b -> dtoToEntity(b)).collect(Collectors.toList());
	}

}
