package zoz.bidproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import zoz.bidproject.model.Bid;
import zoz.bidproject.service.BidService;

@RestController
@RequestMapping("/bid")
public class BidController {

	@Autowired
	private BidService bidService;
	
	@PostMapping
	@RequestMapping("/new")
	public Bid newBid(@RequestBody Bid bid) {
		try {
			return bidService.newBid(bid);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

}
