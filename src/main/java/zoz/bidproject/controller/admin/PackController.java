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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import zoz.bidproject.model.Pack;
import zoz.bidproject.service.PackService;

@RestController("adminPackController")
@RequestMapping("admin/pack")
public class PackController {

	@Autowired
	private PackService packService;

	@GetMapping
	@RequestMapping("/")
	public List<Pack> getPacks() {
		return packService.getPacks();
	}

	@GetMapping
	@RequestMapping("/{id}")
	public Pack getPack(@PathVariable Long id) {
		return packService.getPack(id);
	}

	@PostMapping
	@RequestMapping("/new")
	public Pack addPack(@RequestBody Pack pack) {
		return packService.newPack(pack);
	}

	@PutMapping
	@RequestMapping("/edit")
	public Pack editPack(@RequestBody Pack pack) {
		return packService.newPack(pack);
	}

	
}
