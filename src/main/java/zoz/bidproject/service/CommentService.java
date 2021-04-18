package zoz.bidproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
public class CommentService {

	@Autowired
	private CommentRepository commentRepository;

	/**
	 * 
	 * @param comment
	 * @return comment
	 */
	public Comment saveComment(Comment comment) {
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
	public void deleteComment(Comment comment) {
		commentRepository.delete(comment);
	}

}
