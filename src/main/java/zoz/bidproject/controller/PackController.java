package zoz.bidproject.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stripe.exception.StripeException;
import com.stripe.model.Plan;
import com.stripe.model.PlanCollection;

import zoz.bidproject.converter.PackConvert;
import zoz.bidproject.dto.PackDto;
import zoz.bidproject.model.Pack;
import zoz.bidproject.service.PackService;
import zoz.bidproject.service.StripeService;

@RestController
@RequestMapping("/pack")
public class PackController {

	@Autowired
	private PackService packService;
	@Autowired
	private StripeService stripeService;
	private PackConvert PackConvert;

	@PostConstruct
	public void init() {

	}

	@GetMapping
	@RequestMapping("/")
	public List<Pack> getPacks() throws StripeException {
		/*Map<String, Object> params = new HashMap<>();
		params.put("limit", 3);

		PlanCollection plans = Plan.list(params);
		
		for (Plan plan : plans.getData()) {
			System.out.println(plan.getId());
			System.out.println(plan.getProduct());
		}*/
		return packService.getPacks();
	}

	@GetMapping
	@RequestMapping("/{id}")
	public Pack getPack(@PathVariable Long id) {
		return packService.getPack(id);
	}

	@PostMapping
	@RequestMapping(path = "/new", method = RequestMethod.POST)
	@PreAuthorize("hasAnyAuthority('SELLER','ADMIN')")
	public ResponseEntity<Object> newPack(@RequestBody PackDto packDto) throws StripeException, JSONException {
		System.out.println(packDto.getName());
		Pack pack = new Pack(packDto.getId(), packDto.getName(), packDto.getNbrDays(), packDto.getDetails());
		pack.setPrice(packDto.getPrice());
		Plan plan=stripeService.createPlan(pack);
		pack.setPlanId(plan.getId());
		packService.newPack(pack);
		return new ResponseEntity<Object>((new JSONObject().put("message", "pack has been created")).toString(),
				HttpStatus.OK);
		
	}

	@PutMapping
	@RequestMapping(path = "/{id}/edit", method = RequestMethod.PUT)
	@PreAuthorize("hasAuthority('ADMIN')")
	public Pack editPack(PackDto packDto, @PathVariable("id") Long id) {
		Pack pack = packService.getPack(id);
		pack.setDetails(packDto.getDetails());
		pack.setName(packDto.getName());
		pack.setNbrDays(packDto.getNbrDays());
		packService.newPack(pack);
		return pack;
	}

	@PutMapping
	@RequestMapping(path = "/{id}/delete", method = RequestMethod.DELETE)
	@PreAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<Object> deletePack(PackDto packDto, @PathVariable("id") Long id) throws JSONException {
		Pack pack = packService.getPack(id);
		packService.deletePack(pack);
		return new ResponseEntity<Object>((new JSONObject().put("message", "pack has been deleted")).toString(),
				HttpStatus.OK);
	}

}
