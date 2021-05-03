package zoz.bidproject.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import zoz.bidproject.model.Bid;
import zoz.bidproject.model.Buyer;
import zoz.bidproject.model.Comment;

import zoz.bidproject.service.BidService;
import zoz.bidproject.service.BuyerService;
import zoz.bidproject.service.CommentService;

@RestController("adminBuyerController")
@RequestMapping("/admin/buyer")
public class BuyerController {
	@Autowired
	private BuyerService buyerService;
	@Autowired
	private CommentService commentService;
	@Autowired
	private BidService bidService;

	@GetMapping
	@RequestMapping("/")
	public List<Buyer> getBuyers() {
		return buyerService.getBuyers();
	}

	@GetMapping
	@RequestMapping("/{id}")
	public Buyer getBuyer(@PathVariable Long id) {
		return buyerService.getBuyer(id);
	}

	@PostMapping
	@RequestMapping("/{id}/disable")
	public void disableAccountBuyer(@PathVariable Long id) {
		Buyer buyer= buyerService.getBuyer(id);
		buyerService.disableAccount(buyer);
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

}
