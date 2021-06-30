package zoz.bidproject.controller;



import javax.annotation.PostConstruct;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import zoz.bidproject.converter.CommentConvert;
import zoz.bidproject.dto.CommentDto;
import zoz.bidproject.model.Comment;
import zoz.bidproject.model.Offer;
import zoz.bidproject.service.BuyerService;
import zoz.bidproject.service.CommentService;
import zoz.bidproject.service.OfferService;

@RestController
@RequestMapping("/comment")
public class CommentController {
	@Autowired
	private CommentService commentService;
	@Autowired
	private BuyerService buyerService;
	@Autowired
	private OfferService offerService;
	private CommentConvert commentConvert;

	@PostConstruct
	public void init() {
		commentConvert = new CommentConvert();

	}

	@PostMapping
	@RequestMapping("/new")
	@PreAuthorize("hasAuthority('BUYER')")
	public CommentDto newComment(@RequestBody @Valid CommentDto commentDto) {
		Comment comment = commentConvert.dtoToEntity(commentDto);
		Offer offer = offerService.getOfferById(commentDto.getIdOffer());
		comment.setOffer(offer);
		Comment newComment = commentService.saveComment(comment);
		return commentConvert.entityToDto(newComment);
	}

	@PutMapping
	@RequestMapping("/edit/{id}")
	@PostAuthorize("hasAuthority('BUYER') && returnObject.nameBuyer==authentication.name")
	public CommentDto editComment(@RequestBody @Valid CommentDto commentDto, @PathVariable("id") Long id) {
		Comment comment = commentService.getComment(id);
		comment.setComment(commentDto.getComment());
		commentService.editComment(comment);
		return commentConvert.entityToDto(comment);
	}

	@DeleteMapping
	@RequestMapping("/delete/{id}")
	@PostAuthorize("hasAuthority('ADMIN') || (hasAuthority('BUYER') && returnObject.nameBuyer==authentication.name)")
	public CommentDto deleteComment(@PathVariable Long id) {
		Comment comment = commentService.getComment(id);
		commentService.deleteComment(comment);
		return commentConvert.entityToDto(comment);
	}

}
