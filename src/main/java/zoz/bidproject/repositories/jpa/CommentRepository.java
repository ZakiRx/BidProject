package zoz.bidproject.repositories.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import zoz.bidproject.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
