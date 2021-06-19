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
import zoz.bidproject.service.ManagerService;


@RestController("adminManagerController")
@RequestMapping("/admin/manager")
public class ManagerController {

	@Autowired
	private ManagerService managerService;

	@GetMapping
	@RequestMapping("/")
	public List<Manager> getManagers() {
		return managerService.getAllManagers();
	}

	@PostMapping
	@RequestMapping("/new")
	public Manager newManager(@RequestBody Manager manager) {

		return managerService.newManager(manager);
	}

	@PutMapping
	@RequestMapping("/edit")
	public Manager editManager(@RequestBody Manager manager) {
		return managerService.newManager(manager);
	}

	@DeleteMapping
	@RequestMapping("/{id}/manager/delete")
	public void deleteManager(@PathVariable Long id) {
		Manager manager = managerService.getManager(id);
		managerService.deleteManger(manager);
	}
}
