package zoz.bidproject.converter;

import java.util.List;
import java.util.stream.Collectors;
import zoz.bidproject.dto.CommentDto;
import zoz.bidproject.model.Comment;

public class CommentConvert {
	public CommentDto entityToDto(Comment comment) {
		CommentDto commentDto = new CommentDto(comment.getId(),comment.getComment(),comment.getCreatedAt(),comment.getUpdatedAt(),comment.getBuyer().getId(),comment.getBuyer().getUserName());

		return commentDto;
	}

	public List<CommentDto> entityToDto(List<Comment> comments) {

		return comments.stream().map(b -> entityToDto(b)).collect(Collectors.toList());
	}

	public Comment dtoToEntity(CommentDto commentDto) {
		Comment comment = new Comment();
		return comment;
	}

	public List<Comment> dtoToEntity(List<CommentDto> CommentsDto) {

		return CommentsDto.stream().map(b -> dtoToEntity(b)).collect(Collectors.toList());
	}
}
