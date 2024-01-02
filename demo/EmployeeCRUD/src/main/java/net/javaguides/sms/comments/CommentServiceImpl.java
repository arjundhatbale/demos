package net.javaguides.sms.comments;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.sms.Exception.ResourceNotFoundException;
import net.javaguides.sms.post.Post;
import net.javaguides.sms.post.PostRepository;

@Service
public class CommentServiceImpl implements CommentServices{

	@Autowired
	private ModelMapper modelMapper ; 
	@Autowired
	private PostRepository postRepository;
	@Autowired
	private CommentRepository commentRepository;
	@Override
	public CommentDto createComment(CommentDto commentDto, Integer postId) {
		// TODO Auto-generated method stub
		Post post = this.postRepository.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post of post Id : " + postId + " is not found "));
		
		CommentEntity commentEntity =  this.modelMapper.map(commentDto, CommentEntity.class);
		commentEntity.setPost(post);
		this.commentRepository.save(commentEntity);
		
		return null;
	}

	@Override
	public void deleteComment(Integer id) {
		// TODO Auto-generated method stub
		
		CommentEntity com = this.commentRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Post of id : " + id + " is not found "));
		
		this.commentRepository.delete(com);
		
	}

}
