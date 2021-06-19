package zoz.bidproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import zoz.bidproject.model.Buyer;
import zoz.bidproject.model.Comment;
import zoz.bidproject.service.BuyerService;
import zoz.bidproject.service.CommentService;

@RestController
@RequestMapping("/comment")
public class CommentController {
	@Autowired
	private CommentService commentService;
	@Autowired
	private BuyerService buyerService;
	
	@PostMapping 
	@RequestMapping("/new")
	public Comment newComment(@RequestBody Comment comment ) {
		return commentService.saveComment(comment);
	}
	
	@PutMapping 
	@RequestMapping("/edit")
	public Comment editComment(@RequestBody Comment comment) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if(buyerService.getBuyerByUserName(authentication.getName()).getId()==comment.getBuyer().getId()){
		  return commentService.saveComment(comment);
		}
		return null;
	}
	@DeleteMapping
	@RequestMapping("{id}/delete")
	public void deleteComment(@PathVariable Long id) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Comment comment = commentService.getComment(id);
		if(buyerService.getBuyerByUserName(authentication.getName()).getId()==comment.getBuyer().getId()){
			commentService.deleteComment(comment);
		}
	}

}
