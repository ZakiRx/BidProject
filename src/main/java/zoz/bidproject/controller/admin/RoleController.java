package zoz.bidproject.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	private RoleService roleService;

	@GetMapping
	@RequestMapping("/")
	public List<Role> getRoles() {
		return roleService.getAllRoles();
	}

	@PostMapping
	@RequestMapping("/new")
	public Role newRole(@RequestBody Role role) {
		return roleService.newRole(role);
	}
	@PutMapping
	@RequestMapping("/edit")
	public Role editRole(@RequestBody Role role) {
		return roleService.newRole(role);
	}
	
	@DeleteMapping
	@RequestMapping("{id}/delete")
	public void deleteRole(@PathVariable Integer id) {
		Role role = roleService.getRoleByid(id);
		roleService.deleteRole(role);
	}
}
