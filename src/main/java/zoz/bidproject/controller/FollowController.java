package zoz.bidproject.controller;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import zoz.bidproject.dto.FollowDto;
import zoz.bidproject.model.Buyer;
import zoz.bidproject.model.Follow;
import zoz.bidproject.model.Seller;
import zoz.bidproject.service.BuyerService;
import zoz.bidproject.service.FollowService;
import zoz.bidproject.service.SellerService;

@RestController
@RequestMapping("/follow")
public class FollowController {

	@Autowired
	private FollowService followService;
	@Autowired
	private BuyerService buyerService;
	@Autowired
	private SellerService sellerService;
	
	@PostMapping
	@RequestMapping(path="/new",method = RequestMethod.POST)
	@PreAuthorize("hasAuthority('BUYER')")
	public ResponseEntity<Object> newFollow(@RequestBody FollowDto followDto ) throws JSONException {
		Follow follow = new Follow();
		Buyer buyer = buyerService.getBuyer(followDto.getIdBuyer());
		Seller seller = sellerService.getSeller(followDto.getIdSeller());
		follow.setBuyer(buyer);
		follow.setSeller(seller);
		System.out.println(seller.getFirstName());
		followService.newFollow(follow);
		return new ResponseEntity<Object>((new JSONObject().put("message","Follow Has been added")).toString(),HttpStatus.CREATED);
	}
	@PostMapping
	@RequestMapping(path="/{id}/delete",method = RequestMethod.POST)
	public void newFollow(@PathVariable("id") Long id ) {
		Follow follow = followService.getFollow(id);
		
		followService.deleteFollow(follow);
		
	}
}
