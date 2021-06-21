package zoz.bidproject.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import zoz.bidproject.model.Buyer;
import zoz.bidproject.model.Comment;
import zoz.bidproject.model.Offer;
import zoz.bidproject.model.Seller;
import zoz.bidproject.repositories.jpa.CommentRepository;

/**
 * 
 * @author othmane
 * @author Zaki_Guemi
 */
@Service
@Transactional
public class CommentService {

	@Autowired
	private CommentRepository commentRepository;
	@Autowired
	private BuyerService buyerService;

	/**
	 * 
	 * @param comment
	 * @return comment
	 */
	@Transactional
	public Comment saveComment(Comment comment) {
		Authentication authntication = SecurityContextHolder.getContext().getAuthentication();
		Buyer buyer = buyerService.getBuyerByUserName(authntication.getName());
		comment.setBuyer(buyer);
		comment.setCreatedAt(new Date());
		comment.setUpdatedAt(new Date());
		return commentRepository.save(comment);
	}

	@Transactional
	@PreAuthorize("hasAuthority('BUYER') && #comment.buyer.userName==authentication.name")
	public Comment editComment(Comment comment) {
		comment.setCreatedAt(new Date());
		comment.setUpdatedAt(new Date());
		return commentRepository.save(comment);
	}

	/**
	 * @author Zaki_Guemi
	 * @param id
	 * @return
	 */
	public Comment getComment(Long id) {
		return commentRepository.getOne(id);
	}

	/**
	 * @author Zaki_Guemi
	 * @param offer
	 * @return
	 */
	public List<Comment> getCommentsByOffer(Offer offer) {
		return offer.getComment();
	}

	/**
	 * @author Zaki_Guemi
	 * @param buyer
	 * @return
	 */
	public List<Comment> getCommentsByBuyer(Buyer buyer) {
		return buyer.getComments();
	}

	/**
	 * @author Zaki_Guemi
	 * @param comment
	 */
	@PreAuthorize("hasAuthority('ADMIN') || #comment.offer.seller.userName==authentication.name || (hasAuthority('BUYER') && #comment.buyer.userName==authentication.name)")
	public void deleteComment(Comment comment) {
		commentRepository.delete(comment);
	}

}
