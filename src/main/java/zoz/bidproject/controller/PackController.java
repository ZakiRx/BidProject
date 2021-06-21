package zoz.bidproject.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@PostMapping
	@RequestMapping(path="/new",method = RequestMethod.POST)
	@PreAuthorize("hasAuthority('ADMIN')")
	public Pack newPack(PackDto  packDto) {
			Pack pack = PackConvert.dtoToEntity(packDto);
			packService.newPack(pack);
			return pack;		
	}

	@PutMapping
	@RequestMapping(path="/{id}/edit",method = RequestMethod.PUT)
	@PreAuthorize("hasAuthority('ADMIN')")
	public Pack editPack(PackDto  packDto,@PathVariable("id") Long id) {
			Pack pack = packService.getPack(id);
			pack.setDetails(packDto.getDetails());
			pack.setName(packDto.getName());
			pack.setNbrDays(packDto.getNbrDays());
			packService.newPack(pack);
			return pack;		
	}
	@PutMapping
	@RequestMapping(path="/{id}/delete",method = RequestMethod.DELETE)
	@PreAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<Object> deletePack(PackDto  packDto,@PathVariable("id") Long id) throws JSONException {
			Pack pack = packService.getPack(id);
			packService.deletePack(pack);
			return new ResponseEntity<Object>((new JSONObject().put("message", "pack has been deleted")).toString(),HttpStatus.OK);		
	}
	

	
}
