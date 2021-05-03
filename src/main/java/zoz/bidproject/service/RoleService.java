package zoz.bidproject.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zoz.bidproject.model.Buyer;
import zoz.bidproject.model.Manager;
import zoz.bidproject.model.Role;
import zoz.bidproject.model.Seller;
import zoz.bidproject.repositories.jpa.RoleRepository;

@Service
public class RoleService {

	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private BuyerService buyerService;
	
	public List<Role> getAllRoles() {
		return roleRepository.findAll();
	}
	public List<Role> getRolesByManager(Manager manager) {
		return manager.getRoles();
	}
	
	public Role getRoleByid(Integer id) {
		return roleRepository.getOne(id);
	}
	public Role newRole(Role role) {
		return roleRepository.save(role);
	}
	public void deleteRole(Role role) {
		roleRepository.delete(role);
	}
	
	public Role getRoleByName(String name) {
		return roleRepository.findByName(name);
	}
	public List<Role> getRolesByBuyer(Buyer buyer) {
		
		return buyer.getRoles();
	}
	
	
}
