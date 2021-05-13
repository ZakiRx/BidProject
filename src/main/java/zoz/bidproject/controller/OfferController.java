package zoz.bidproject.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import zoz.bidproject.converter.BidConvert;
import zoz.bidproject.converter.CommentConvert;
import zoz.bidproject.converter.OfferConvert;
import zoz.bidproject.dto.BidDto;
import zoz.bidproject.dto.CommentDto;
import zoz.bidproject.dto.OfferDto;
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
import zoz.bidproject.service.SellerService;

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
	@Autowired
	private SellerService sellerService;
	
	private CommentConvert commentConvert;
	private OfferConvert offerConverter;
	private BidConvert bidConvert;
	
	@PostConstruct
	public void init() {
		commentConvert= new CommentConvert();
		offerConverter= new OfferConvert();
		bidConvert = new BidConvert();
	}
	
	@GetMapping
	@RequestMapping("/")
	public List<OfferDto> getOffers() {
		List<Offer> offers = offerService.getAllOffers();
		return offerConverter.entityToDto(offers) ;
	}
	@GetMapping
	@RequestMapping("/{id}")
	public OfferDto getOffer(@PathVariable Long id) {
		return offerConverter.entityToDto(offerService.getOfferById(id)) ;
	}
	@PostMapping
	@RequestMapping("/new")
	public Offer newOffer(@Valid @RequestBody OfferDto offerDto) {
		
		Offer offer= offerConverter.dtoToEntity(offerDto);
		offer.setSeller(sellerService.getSeller(offerDto.getIdSeller()));
		return offerService.saveOffre(offer);
	}
	@PutMapping
	@RequestMapping("/edit")
	public Offer editOffer(@RequestBody OfferDto offerDto) {
		Offer offer= offerConverter.dtoToEntity(offerDto);
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
	public List<CommentDto> getCommentsOffer(@PathVariable Long id) {
		Offer offer = offerService.getOfferById(id);
		return commentConvert.entityToDto(commentService.getCommentsByOffer(offer));
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
	public List<BidDto>  getBids(@PathVariable Long id){
		Offer offer=offerService.getOfferById(id);
	
		return  bidConvert.entityToDto(bidService.getBidsByOffer(offer));
	}
	
}
