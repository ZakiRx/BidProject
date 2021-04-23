package zoz.bidproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zoz.bidproject.model.Manager;
import zoz.bidproject.model.Role;
import zoz.bidproject.repositories.jpa.RoleRepository;

@Service
public class RoleService {

	@Autowired
	private RoleRepository roleRepository;
	
	public List<Role> getAllRoles() {
		return roleRepository.findAll();
	}
	public List<Role> getRolesByManager(Manager manager) {
		return manager.getRoles();
	}
	public Role newRole(Role role) {
		return roleRepository.save(role);
	}
	public void deleteRole(Role role) {
		roleRepository.delete(role);
	}
	
}
