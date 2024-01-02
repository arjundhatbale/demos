package net.javaguides.sms.comments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.sms.Categories.ApiResponse;

@RestController
@RequestMapping("/api/")
public class CommentController {

	@Autowired
	private CommentServices commentServices;

	@PostMapping("/post/{postId}/comments")
	public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto commentDto,
			@PathVariable("postId") Integer postId){
		
	 	CommentDto createComment = this.commentServices.createComment(commentDto, postId);
	 	return new ResponseEntity<CommentDto>(createComment,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/comments/{id}")
	public ResponseEntity<ApiResponse> deleteComment(@PathVariable Integer id){
		this.commentServices.deleteComment(id);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Comment deleted successfully",  true),HttpStatus.OK);
	}
	
	
}
