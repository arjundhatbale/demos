package net.javaguides.sms.post;

import java.util.List;
  
 
public interface PostService {
	
	// create
	
	PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);
	
	// update 
	
	 PostDto updatePost(PostDto postDto, Integer postId); 
	
	void deletePost(Integer postId); 
	
	// get All posts 
	
	PostResponse  getAllPost(Integer pageNumber, Integer pageSize,String sortBy, String sortDir);
	
	// get post by id 
	
	PostDto getPostById(Integer postId);
	
	// get all post by category 
	
	List<PostDto> getPostsByCategory(Integer categoryId);
	
	// get all post by user 
	
	List<PostDto> getPostByUser(Integer userId);
	
	// search posts
	List<PostDto> searchPosts(String keyword);
}
