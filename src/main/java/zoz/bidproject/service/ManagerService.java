package zoz.bidproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zoz.bidproject.model.Manager;
import zoz.bidproject.model.Role;
import zoz.bidproject.repositories.jpa.ManagerRepository;

@Service
public class ManagerService {

	@Autowired
	private ManagerRepository managerRepository;
	public List<Manager> getAllManagers(){
		return  managerRepository.findAll();
	}
	public List<Manager> getManagersByRole(Role role){
	  return role.getManagers();
	}
	
	public Manager newManager(Manager manager) {
		return managerRepository.save(manager);
	}
	public void deleteManger(Manager manager) {
		managerRepository.delete(manager);
	}
}
