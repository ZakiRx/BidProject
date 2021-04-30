package zoz.bidproject.controller;

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
import zoz.bidproject.model.Seller;
import zoz.bidproject.service.BidService;
import zoz.bidproject.service.CommentService;
import zoz.bidproject.service.OfferService;
import zoz.bidproject.service.OrderService;
import zoz.bidproject.service.ProductService;

@RestController
@RequestMapping("/offer")
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
	@RequestMapping("/new")
	public Offer newOffer(@RequestBody Offer offer) {
		return offerService.saveOffre(offer);
	}
	@PutMapping
	@RequestMapping("/edit")
	public Offer editOffer(@RequestBody Offer offer) {
		return offerService.saveOffre(offer);
	}
	@DeleteMapping
	@RequestMapping("/delete")
	public void deleteOffer(@PathVariable Long id) {
		Offer offer = offerService.getOfferById(id);
		 offerService.deleteOffre(offer);
	}
	
	@GetMapping
	@RequestMapping("/{id}/comments")
	public List<Comment> getCommentsOffer(@PathVariable Long id) {
		Offer offer = offerService.getOfferById(id);
		return commentService.getCommentsByOffer(offer);
	}
	@GetMapping
	@RequestMapping("/{id}/products")
	public List<Product> getProductsOffer(Long id) {
		Offer offer = offerService.getOfferById(id);
		return productService.getProductsByOffre(offer);
	}
	@GetMapping
	@RequestMapping("/{id}/order")
	public Ordre  getOrders(@PathVariable Long id){
		Offer offer=offerService.getOfferById(id);
		return orderService.getOrderByOffer(offer);
	}
	@GetMapping
	@RequestMapping("/{id}/bid")
	public List<Bid>  getBids(@PathVariable Long id){
		Offer offer=offerService.getOfferById(id);
		return bidService.getBidsByOffer(offer);
	}
	
}
