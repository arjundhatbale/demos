package net.javaguides.sms.post;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
 import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import net.javaguides.sms.Categories.CategoryEntity;
import net.javaguides.sms.Categories.CategoryRepository;
import net.javaguides.sms.Exception.ResourceNotFoundException;
import net.javaguides.sms.User.UserEntity;
import net.javaguides.sms.User.UserRepository;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserRepository userRepository; 
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public PostDto createPost(PostDto postDto , Integer userId, Integer categoryId ) {
		
		UserEntity user = this.userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User  user id : " + userId + " not found"));
		
		CategoryEntity categoryEntity = this.categoryRepository.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category category id " + categoryId + " not found"));
		Post post = this.modelMapper.map(postDto, Post.class);
		
		post.setImageName("default.png");
		post.setDate( new Date());
		
		post.setUserEntity(user);
	 //	post.setCategoryEntity(categoryEntity);
		Post newPost = this.postRepository.save(post);
 		return  this.modelMapper.map(newPost, PostDto.class);
	}

	@Override
	public PostDto updatePost(PostDto postDto, Integer postId) {
		Post post = postRepository.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException("Post Id of " + postId + " is not found "));
		
		post.setPostTitle(postDto.getPostTitle());
		post.setContent(postDto.getContent());
		post.setImageName(postDto.getImageName());
		Post updatePostDto= this.postRepository.save(post);
		return modelMapper.map(updatePostDto, PostDto.class);
	}

	@Override
	public void deletePost(Integer postId) {
 
       Post post =  this.postRepository.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post of Id : " + postId + " is not exists"));
       this.postRepository.delete(post);
	}

	@Override
	public PostResponse getAllPost(Integer pageNumber, Integer pageSize,String sortBy, String sortDir) { 
		
		Sort sort = null;
		if(sortDir.equalsIgnoreCase("asc")) {
			sort = Sort.by(sortBy).ascending();
		}else {
			sort=Sort.by(sortBy).descending();
		}
		
		
		Pageable p = PageRequest.of(pageNumber, pageSize,  sort);
		Page<Post> pagePost = this.postRepository.findAll(p);
			
		List<Post> allPostDto =  pagePost.getContent();
		List<PostDto> postsDtos = allPostDto.stream().map((post) -> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		
		PostResponse postResponse = new PostResponse();
		
		postResponse.setContent(postsDtos);
		postResponse.setPageNumber(pagePost.getNumber());
		postResponse.setPageSize(pagePost.getSize());
		postResponse.setTotalElements(pagePost.getTotalElements());
		postResponse.setTotalPages(pagePost.getTotalPages());
		
		postResponse.setLastPage(pagePost.isLast());
		return  postResponse;
	}

	@Override
	public PostDto getPostById(Integer postId) {
		Post post = this.postRepository.findById(postId)
				.orElseThrow( ()-> new ResourceNotFoundException("Post of post Id : " + postId  + " does not found "));

		return  this.modelMapper.map(post, PostDto.class);
		 
 	}

	@Override
	public List<PostDto> getPostsByCategory(Integer categoryId) {
 	
		CategoryEntity cat = this.categoryRepository.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category id : " + categoryId + " is not found " ));
	 	List<Post> posts = this.postRepository.findByCategoryEntity(cat);
	 	
	 	List<PostDto> listofPostDto = posts.stream().map((post) -> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
	 	
		
 		return listofPostDto ;
	}

	@Override
	public List<PostDto> getPostByUser(Integer userId) {
		UserEntity user = this.userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("user of Id : " + userId + " is not found "));
		
		List<Post> listofPost = this.postRepository.findByUserEntity(user);
		
		List<PostDto> dto = listofPost.stream().map((p)-> this.modelMapper.map(p, PostDto.class)).collect(Collectors.toList());
		return  dto;
		
 		 
	}

	@Override
	public List<PostDto> searchPosts(String keyword) {
	//	List<Post> posts = this.postRepository.findByPostTitle(keyword);
		List<Post> posts = this.postRepository.searchByPostTitle("%" + keyword + "%");
		List<PostDto> postDtos = posts.stream().map((post)-> this.modelMapper.map(posts,  PostDto.class)).collect((Collectors.toList()));
		
 		return  postDtos;
	}

}
