package zoz.bidproject.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;


import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
	@PostMapping
	@RequestMapping("/{id}/image")
	@PreAuthorize("hasAuthority('SELLER')")
	public void uploadImages(@RequestParam("files") MultipartFile files[],@PathVariable Long id) throws IOException {
		ShippingProof proof = proofService.getShippingProof(id);
		for(MultipartFile file:files) {
			String imageName=proof.getId()+"_"+file.getOriginalFilename();
			File image =new File( "src/main/resources/images/products/"+imageName);
			image.createNewFile();
			FileOutputStream stream = new FileOutputStream(image);
			stream.write(file.getBytes());
			proof.setImage(imageName);
			proofService.newShippingProof(proof);
			stream.close();
		}
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
