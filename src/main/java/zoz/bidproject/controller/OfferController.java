package zoz.bidproject.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
@Transactional
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
		commentConvert = new CommentConvert();
		offerConverter = new OfferConvert();
		bidConvert = new BidConvert();
		authentication = SecurityContextHolder.getContext().getAuthentication();
	}

	@GetMapping
	@RequestMapping("/")
	public ResponseEntity<Object> getOffers() throws JSONException {
		try {
			List<Offer> offers = offerService.getEnabledAndVerifiedOffers();
			System.out.println("offers :" + offers);
			return new ResponseEntity<Object>(offerConverter.entityToDto(offers), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>((new JSONObject().put("message", "Offers Not Found")).toString(),
					HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping
	@RequestMapping("/{id}")
	public ResponseEntity<Object> getOffer(@PathVariable Long id) throws JSONException {
		try {
			Offer offer = offerService.getEnabledAndVerifiedOffer(id);
			return new ResponseEntity<Object>(offerConverter.entityToDto(offer), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>((new JSONObject().put("message", "Offer Not Found")).toString(),
					HttpStatus.NOT_FOUND);
		}

	}

	@PostMapping
	@RequestMapping(path = "/new", method = RequestMethod.POST)
	@PreAuthorize("hasAuthority('SELLER')")
	public ResponseEntity<Object> newOffer(@Valid @RequestBody OfferDto offerDto) throws JSONException {
		JSONObject json = new JSONObject();

		authentication = SecurityContextHolder.getContext().getAuthentication();
		Offer offer = offerConverter.dtoToEntity(offerDto);
		Seller seller = sellerService.getSellerByUserName(authentication.getName());
		if (seller.getSubscription().isEnabled()) {
			offer.setSeller(seller);
			offerService.saveOffre(offer);
			json.put("message", "offer has been added");
			return new ResponseEntity<Object>(json.toString(), HttpStatus.CREATED);
		}
		json.put("message", "your subscribe ended");
		return new ResponseEntity<Object>(json.toString(), HttpStatus.UNAUTHORIZED);

	}

	@PatchMapping
	@RequestMapping(path = "/edit/{id}", method = RequestMethod.PATCH)
	@PreAuthorize("hasAuthority('SELLER') && #offerDto.nameSeller==authentication.name")
	public Offer editOffer(@RequestBody OfferDto offerDto, @PathVariable("id") Long id) {

		Offer offer = offerService.getOfferById(id);
		offer.setAugmentationPrice(offerDto.getAugmentationPrice());
		offer.setName(offerDto.getName());
		offer.setDescription(offerDto.getDescription());
		offer.setEndAt(offerDto.getEndAt());
		offer.setStartedAt(offerDto.getStartedAt());
		return offerService.saveOffre(offer);
	}

	@DeleteMapping
	@RequestMapping(path = "/delete/{id}", method = RequestMethod.DELETE)
	@PostAuthorize("hasAuthority('ADMIN') || hasAuthority('SELLER') && returnObject.nameSeller==authentication.name")
	public OfferDto deleteOffer(@PathVariable Long id) throws JSONException {
		try {
			Offer offer = offerService.getOfferById(id);
			offerService.deleteOffre(offer);
			return offerConverter.entityToDto(offer);
		} catch (Exception e) {
			return null;
		}

	}

	@PutMapping
	@RequestMapping(path = "/disable/{id}", method = RequestMethod.PUT)
	@PreAuthorize("hasAuthority('SELLER')")
	public ResponseEntity<Object> disableOffer( @PathVariable("id") Long id) throws JSONException {

		Offer offer = offerService.getOfferById(id);
		offerService.disableOffer(offer);
		return new ResponseEntity<Object>((new JSONObject().put("message", "offer disabled")).toString(),HttpStatus.OK);
	}

	@PutMapping
	@RequestMapping(path = "/enable/{id}", method = RequestMethod.PUT)
	@PreAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<Object> enableOffer(@PathVariable("id") Long id) throws JSONException {
		Offer offer = offerService.getOfferById(id);
		offerService.enableOffer(offer);
		return new ResponseEntity<Object>((new JSONObject().put("message", "offer enabled")).toString(),HttpStatus.OK);
	}

	@PutMapping
	@RequestMapping(path = "/verified/{id}", method = RequestMethod.PUT)
	@PreAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<Object> verifiedOffer(@PathVariable("id") Long id) throws JSONException {
		Offer offer = offerService.getOfferById(id);
		offerService.verifedOffer(offer);
		return new ResponseEntity<Object>((new JSONObject().put("message", "offer verified")).toString(),HttpStatus.OK);
	}
	@GetMapping
	@RequestMapping("/{id}/comments")
	public List<CommentDto> getCommentsOffer(@PathVariable("id") Long id) {
		Offer offer = offerService.getOfferById(id);
		return commentConvert.entityToDto(commentService.getCommentsByOffer(offer));
	}

	@GetMapping
	@RequestMapping("/{id}/products")
	public List<Product> getProductsOffer(@PathVariable("id") Long id) {
		Offer offer = offerService.getOfferById(id);
		return productService.getProductsByOffre(offer);
	}

	@GetMapping
	@RequestMapping("/{id}/order")
	public Ordre getOrders(@PathVariable Long id) {
		Offer offer = offerService.getOfferById(id);
		return orderService.getOrderByOffer(offer);
	}

	@GetMapping
	@RequestMapping("/{id}/bid")
	public List<BidDto> getBids(@PathVariable Long id) {
		Offer offer = offerService.getOfferById(id);

		return bidConvert.entityToDto(bidService.getBidsByOffer(offer));
	}

}
