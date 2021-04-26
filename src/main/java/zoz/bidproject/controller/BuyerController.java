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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import zoz.bidproject.model.Buyer;
import zoz.bidproject.model.Comment;
import zoz.bidproject.model.Pack;
import zoz.bidproject.model.User;
import zoz.bidproject.service.BuyerService;
import zoz.bidproject.service.CommentService;
import zoz.bidproject.service.PackService;

@RestController
@RequestMapping("/buyer")
public class BuyerController {
	@Autowired
	private BuyerService buyerService;
	@Autowired
	private CommentService commentService;
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
	@RequestMapping("/new")
	public Buyer addBuyer(@RequestBody Buyer buyer) {
		return buyerService.newBuyer(buyer);
	}

	@PutMapping
	@RequestMapping("/edit")
	public Buyer editBuyer(@RequestBody Buyer buyer) {
		return buyerService.newBuyer(buyer);
	}

	@DeleteMapping
	@RequestMapping("/delete/{id}")
	public void deleteBuyer(@PathVariable Long id) {
		Buyer buyer=buyerService.getBuyer(id);
		 buyerService.deleteBuyer(buyer);
	}
	@GetMapping
	@RequestMapping("/{id}/comments")
	public List<Comment> getCommentsBuyer(@PathVariable Long id) {
		Buyer buyer=buyerService.getBuyer(id);
		return commentService.getCommentsByBuyer(buyer);
	}

}
