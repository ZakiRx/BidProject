package zoz.bidproject.controller;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import zoz.bidproject.model.Ordre;
import zoz.bidproject.model.Seller;
import zoz.bidproject.model.ShippingProof;
import zoz.bidproject.service.OrderService;
import zoz.bidproject.service.SellerService;
import zoz.bidproject.service.ShippingProofService;

@RestController
@RequestMapping("/shippingProof")
public class ShipingProofController {

	@Autowired
	private ShippingProofService proofService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private SellerService sellerService;
	
	@PostMapping
	@RequestMapping(path = "/new",method = RequestMethod.POST)
	@PreAuthorize("hasAuthority('SELLER')")
	public ResponseEntity<Object> newShippingProof(@RequestBody ShippingProof shippingProof) throws JSONException{
		String username =SecurityContextHolder.getContext().getAuthentication().getName();
		Seller seller  =sellerService.getSellerByUserName(username);
		List<Ordre> orders = seller.getOrdres().stream().filter(o->o.getShippingProof()==null).collect(Collectors.toList());
		JSONObject jsonObject = new JSONObject();
		for(Ordre order : orders) {
			if(order.getId()==1) {
				shippingProof.setOrdre(order);
				proofService.newShippingProof(shippingProof);
				order.setShippingProof(shippingProof);
				orderService.newOrder(order);
				jsonObject.put("success", "Your shipping Proof has been added wait confirmation by admin");
				return new ResponseEntity<Object>(jsonObject.toString(),HttpStatus.CREATED);
				
			}
		}
		jsonObject.put("error", "Your Order not found");
		return new ResponseEntity<Object>(jsonObject.toString(),HttpStatus.NOT_FOUND);
	}
	@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping
	@RequestMapping(path = "/enable",method = RequestMethod.POST)
	public ResponseEntity<Object> acceptProof(@RequestBody ShippingProof shippingProof) throws JSONException {
		List<ShippingProof> proofs = proofService.getShippingProofsNotVerified();
		JSONObject jsonObject = new JSONObject();
		for(ShippingProof proof:proofs) {
			if(proof.getId()==1) {
				proof.setVerified(true);
				jsonObject.put("success", "Shipping proof for order: "+shippingProof.getOrdre().getId()+" accepted");
				shippingProof.getOrdre().getPurchase().getShippingDetails().setShipped(true);
				shippingProof.getOrdre().getPurchase().setState(true);
				proofService.newShippingProof(shippingProof);
				return new ResponseEntity<Object>(jsonObject.toString(),HttpStatus.CREATED);
			}
		}
		jsonObject.put("error", "Shipping Proof not found");
		return new ResponseEntity<Object>(jsonObject.toString(),HttpStatus.NOT_FOUND);
	}
}
