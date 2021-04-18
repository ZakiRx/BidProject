package zoz.bidproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zoz.bidproject.model.Comment;
import zoz.bidproject.repositories.jpa.CommentRepository;

/**
 * 
 * @author othmane
 *
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
	public Comment SaveComment(Comment comment) {
		return commentRepository.save(comment);
	}

}
