package zoz.bidproject.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import zoz.bidproject.converter.BidConvert;
import zoz.bidproject.converter.CommentConvert;
import zoz.bidproject.converter.OfferConvert;
import zoz.bidproject.dto.BidDto;
import zoz.bidproject.dto.CommentDto;
import zoz.bidproject.dto.OfferDto;
import zoz.bidproject.model.Offer;
import zoz.bidproject.model.Ordre;
import zoz.bidproject.model.Product;
import zoz.bidproject.model.Seller;
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
	private Authentication authentication;
	
	private CommentConvert commentConvert;
	private OfferConvert offerConverter;
	private BidConvert bidConvert;
	
	@PostConstruct
	public void init() {
		commentConvert= new CommentConvert();
		offerConverter= new OfferConvert();
		bidConvert = new BidConvert();
		authentication=SecurityContextHolder.getContext().getAuthentication();
	}
	
	@GetMapping
	@RequestMapping("/")
	public List<OfferDto> getOffers() {
		List<Offer> offers = offerService.getAllOffers();
		return offerConverter.entityToDto(offers) ;
	}
	@GetMapping
	@RequestMapping("/{id}")
	public ResponseEntity<Object> getOffer(@PathVariable Long id) throws JSONException {
		try {
			Offer offer =offerService.getOfferById(id);
			
			return new ResponseEntity<Object>( offer ,HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<Object>( (new JSONObject().put("message","Offer Not Found")).toString() ,HttpStatus.NOT_FOUND);
		}
		
	}
	@PostMapping
	@RequestMapping(path = "/new",method = RequestMethod.POST)
	@PreAuthorize("hasAuthority('SELLER')")
	public Offer newOffer(@Valid @RequestBody OfferDto offerDto) {
		authentication=SecurityContextHolder.getContext().getAuthentication();
		Offer offer= offerConverter.dtoToEntity(offerDto);
		Seller seller =sellerService.getSellerByUserName(authentication.getName());
		offer.setSeller(seller);
		return offerService.saveOffre(offer);
	}
	@PatchMapping
	@RequestMapping(path ="/edit/{id}",method = RequestMethod.PATCH)
	@PreAuthorize("hasAuthority('SELLER') && #offerDto.nameSeller==authentication.name")
	public Offer editOffer(@RequestBody OfferDto offerDto,@PathVariable("id") Long id) {
		
		Offer offer= offerService.getOfferById(id);
		offer.setAugmentationPrice(offerDto.getAugmentationPrice());
		offer.setName(offerDto.getName());
		offer.setDescription(offerDto.getDescription());
		offer.setEndAt(offerDto.getEndAt());
		offer.setStartedAt(offerDto.getStartedAt());
		return offerService.saveOffre(offer);
	}
	@DeleteMapping
	@RequestMapping(path = "/delete/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteOffer(@PathVariable Long id) throws JSONException {
		Offer offer = offerService.getOfferById(id);
		 offerService.deleteOffre(offer);
		 JSONObject jsonObject = new JSONObject();
		 jsonObject.put("message", "Offer :"+offer.getName()+" Has Been Deleted");
		 return new ResponseEntity<Object>( jsonObject.toString() ,HttpStatus.OK);
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
