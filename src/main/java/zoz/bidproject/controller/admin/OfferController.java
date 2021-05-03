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

import zoz.bidproject.model.Bid;
import zoz.bidproject.model.Comment;
import zoz.bidproject.model.Offer;
import zoz.bidproject.model.Ordre;
import zoz.bidproject.model.Product;
import zoz.bidproject.service.BidService;
import zoz.bidproject.service.CommentService;
import zoz.bidproject.service.OfferService;
import zoz.bidproject.service.OrderService;
import zoz.bidproject.service.ProductService;

@RestController("adminOfferController")
@RequestMapping("/admin/offer")
public class OfferController {

	@Autowired
	private ProductService productService;
	@Autowired
	private OfferService offerService;
	@Autowired
	private CommentService commentService;
	@Autowired
	private OrderService orderService;  
	@Autowired
	private BidService bidService;
	
	@GetMapping
	@RequestMapping("/")
	public List<Offer> getOffers() {
		return offerService.getAllOffers();
	}
	@GetMapping
	@RequestMapping("/{id}")
	public Offer getOffer(@PathVariable Long id) {
		return offerService.getOfferById(id);
	}
	@PostMapping
	@RequestMapping("/{id}/verified")
	public boolean verifiedOffer(@PathVariable Long id) {
		Offer offer = offerService.getOfferById(id);
		return offerService.verifedOffer(offer);
		
	}
	
	
}
