package zoz.bidproject.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import zoz.bidproject.model.Buyer;
import zoz.bidproject.model.Manager;
import zoz.bidproject.model.Role;
import zoz.bidproject.model.Seller;
import zoz.bidproject.model.User;
import zoz.bidproject.service.RoleService;

@RestController("adminRoleController")
@RequestMapping("/admin/role")
public class RoleController {

	@Autowired
	private RoleService  roleService;
	@GetMapping
	@RequestMapping("/")
	public List<Role> getRoles(){
		return roleService.getAllRoles();
	}
	@GetMapping
	@RequestMapping("/{id}/buyer")
	public List<Buyer> getbuyers(@PathVariable Integer id){
		Role role = roleService.getRoleByid(id);
		return roleService.getBuyersInRole(role);
	}
	@GetMapping
	@RequestMapping("/{id}/seller")
	public List<Seller> getSellers(@PathVariable Integer id){
		Role role = roleService.getRoleByid(id);
		return null;
		
	}
	@GetMapping
	@RequestMapping("/{id}/manager")
	public List<Manager> getManagers(@PathVariable Integer id){
		Role role = roleService.getRoleByid(id);
		return roleService.getManagersInRole(role);
	}
}
