package zoz.bidproject.controller;

import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Claims;
import zoz.bidproject.converter.BidConvert;
import zoz.bidproject.dto.BidDto;
import zoz.bidproject.model.Bid;
import zoz.bidproject.model.Buyer;
import zoz.bidproject.security.JwtProvider;
import zoz.bidproject.service.BidService;
import zoz.bidproject.service.BuyerService;
import zoz.bidproject.service.OfferService;

@RestController
@RequestMapping("/bid")
public class BidController {

	@Autowired
	private BidService bidService;
	@Autowired
	private BuyerService buyerService;
	@Autowired
	private OfferService offerService;
	private BidConvert bidConvert;
	
	@PostConstruct
	public void init() {
		bidConvert= new BidConvert();
	}
	@PostMapping
	@RequestMapping("/new")
	@PreAuthorize("hasAuthority('BUYER')")
	public ResponseEntity<Object> newBid(@RequestBody BidDto bidDto) {
		try {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		   
			Bid  bid = bidConvert.dtoToEntity(bidDto);
			String userName=authentication.getName();
			Buyer buyer=buyerService.getBuyerByUserName(userName);
			bid.setBuyer(buyer);
			bid.setOffer(offerService.getOfferById(bidDto.getIdOffer()));
			return new ResponseEntity<Object>(bidConvert.entityToDto(bidService.newBid(bid)) ,HttpStatus.ACCEPTED);
			
		} catch (Exception e) {
			
			return new ResponseEntity<Object> (e.getMessage().toString(),HttpStatus.NOT_ACCEPTABLE);
		}
	}

}
