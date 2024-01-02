package net.javaguides.sms.comments;

public interface CommentServices {

	CommentDto createComment(CommentDto commentDto, Integer postId);
	
	void deleteComment(Integer id);
}
