package zoz.bidproject.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import zoz.bidproject.converter.BuyerConverter;
import zoz.bidproject.dto.BuyerDto;
import zoz.bidproject.model.Bid;
import zoz.bidproject.model.Buyer;
import zoz.bidproject.model.Comment;
import zoz.bidproject.model.Pack;
import zoz.bidproject.model.Purchase;
import zoz.bidproject.model.Seller;
import zoz.bidproject.model.User;
import zoz.bidproject.repositories.jpa.BuyerRepository;
import zoz.bidproject.service.BidService;
import zoz.bidproject.service.BuyerService;
import zoz.bidproject.service.CommentService;
import zoz.bidproject.service.PackService;
import zoz.bidproject.service.PurchaseService;

@RestController
@RequestMapping("/buyer")
public class BuyerController {
	@Autowired
	private BuyerService buyerService;
	@Autowired
	private CommentService commentService;
	@Autowired
	private BidService bidService;
	@Autowired
	private PurchaseService purchaseService;
	private Authentication principal;
	private BuyerConverter buyerConverter;
	
	
	@PostConstruct
	public void init() {
		buyerConverter= new BuyerConverter();
	}
	@GetMapping
	@RequestMapping("/")
	public Buyer profile() {
		this.principal =SecurityContextHolder.getContext().getAuthentication();
		Buyer buyer = buyerService.getBuyerByUserName(principal.getName());
		return  buyer;
		
	}

	@GetMapping
	@RequestMapping("/{id}")
	public Object getBuyer(@PathVariable Long id) {
		Authentication principal=SecurityContextHolder.getContext().getAuthentication();
		System.out.println("user:"+principal.getName());
        try {
        	Buyer buyer = buyerService.getBuyer(id);
        	return  buyerConverter.entityToDto(buyer);
        }catch(Exception e) {
        	
            return "User not found :"+HttpStatus.NOT_FOUND.value();
            
        }
		
	}


	@PutMapping
	@RequestMapping("/edit")
	public Buyer editBuyer(@RequestBody BuyerDto buyerDto) {
		Buyer buyer=buyerService.getBuyer(buyerDto.getId());
		buyer.setFirstName(buyerDto.getFirstName());
		buyer.setLastName(buyerDto.getLastName());
		return buyerService.newBuyer(buyer);
	}

	@DeleteMapping
	@RequestMapping("/delete/{id}")
	public void deleteBuyer(@PathVariable Long id) {
		Buyer buyer = buyerService.getBuyer(id);
		buyerService.deleteBuyer(buyer);
	}

	@GetMapping
	@RequestMapping("/{id}/comments")
	public List<Comment> getComments(@PathVariable Long id) {
		Buyer buyer = buyerService.getBuyer(id);
		return commentService.getCommentsByBuyer(buyer);
	}

	@GetMapping
	@RequestMapping("/{id}/bid")
	public List<Bid> getBids(@PathVariable Long id) {
		Buyer buyer = buyerService.getBuyer(id);
		return bidService.getBidsByBuyer(buyer);
	}
	@GetMapping
	@RequestMapping("/{id}/purchase")
	public List<Purchase> getPurchases(@PathVariable Long id) {
		Buyer buyer = buyerService.getBuyer(id);
		return purchaseService.getPurchasesByBuyer(buyer);
	}
	

	

}
