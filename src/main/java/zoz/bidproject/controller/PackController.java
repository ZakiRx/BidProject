package zoz.bidproject.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import zoz.bidproject.converter.PackConvert;
import zoz.bidproject.dto.PackDto;
import zoz.bidproject.model.Pack;
import zoz.bidproject.service.PackService;

@RestController
@RequestMapping("/pack")
public class PackController {

	
	@Autowired
	private PackService packService;
	private PackConvert PackConvert;

	@PostConstruct
	public void init() {
		
	}
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
	
	/*@PostMapping
	@RequestMapping(path="/new",method = RequestMethod.POST)
	public Pack newPack(PackDto  packDto) {
		
	}*/
	
	

	
}
