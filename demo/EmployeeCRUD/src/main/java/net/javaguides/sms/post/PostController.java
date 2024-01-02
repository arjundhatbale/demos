package net.javaguides.sms.post;

 
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.util.StreamUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpServletResponse;
import net.javaguides.sms.Categories.ApiResponse;
import net.javaguides.sms.config.AppConstants;
 

@RestController
@RequestMapping("/api/posts")
public class PostController {

	@Autowired
	private PostService postService;
	
	@Autowired
	private FileService fileService ; 
	
	@Value("${porject.image}")
	private String path;
	
	// create 
	@PostMapping("/user/{userId}/category/{categoryId}/posts")
	public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto,
			@PathVariable Integer userId, 
			@PathVariable Integer categoryId){
		
		PostDto createPost = this.postService.createPost(postDto, userId, categoryId);
		return new ResponseEntity<PostDto>(createPost,HttpStatus.CREATED);
	}
	
	// get post by id 
	
	@GetMapping("/{postId}")
	public PostDto getPostByPostId( @PathVariable("postId") Integer postId){
		return this.postService.getPostById(postId); 
	}
	
	// update post dto
	
	@PostMapping("/{postId}")
	public PostDto updatePostDto(@RequestBody PostDto dto, @PathVariable("postId") Integer postId) {
		return this.postService.updatePost(dto, postId);
	}
	
	// get by user
	@GetMapping("/user/{userId}/post")
	public ResponseEntity< List<PostDto>> getPostsByUserEntiy(@PathVariable("userId") Integer userId){
		List<PostDto> posts = this.postService.getPostByUser(userId);
		return new ResponseEntity<List<PostDto>>(posts,HttpStatus.OK);
	}
	
	// get by category
	@GetMapping("/category/{categoryId}/post")
	public ResponseEntity<List<PostDto>> getPostsDtoByCategoryEntity(@PathVariable("categoryId") Integer categoryId){
		
		List<PostDto> posts = postService.getPostsByCategory(categoryId);
		
		return new ResponseEntity<List<PostDto>>(posts,HttpStatus.OK) ;
		
	}
	
	// get all posts
	@GetMapping("/")
	public ResponseEntity< PostResponse> getAllPost(
			@RequestParam(value = "pageNumber",defaultValue = AppConstants.PAGE_NUMBER,required = false) Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue =  AppConstants.PAGE_SIZE,required = false)Integer pageSize,
			@RequestParam(value = "sortBy", defaultValue =   AppConstants.SORT_BY, required = false) String sortBy,
			@RequestParam(value = "sortDir", defaultValue =  AppConstants.SORT_DIR, required =  false)String sortDir){
		
		PostResponse  postResponse = this.postService.getAllPost(pageNumber,pageSize,sortBy,sortDir);
		return new ResponseEntity<PostResponse>(postResponse,HttpStatus.OK);
	}
	
	
	// delete post 
	@DeleteMapping("/{postId}")
	public ApiResponse deletePost(@PathVariable ("postId") Integer postId) {
		this.postService.getPostById(postId);
		return new ApiResponse("Post is successfully deleted ", true);
	}
	
	// search
	@GetMapping("/search/{keyword}")
	public ResponseEntity<List<PostDto>> searchPostByPostTitle(@PathVariable("keyword") String keyword){
		List<PostDto> result = this.postService.searchPosts(keyword);
		return new ResponseEntity<List<PostDto>>(result,HttpStatus.OK);
	}
	
	//  Post Image upload 
	
	@PostMapping("/post/image/upload/{postId}")
	public ResponseEntity<PostDto> uploadPostImage(
			@RequestParam("image") MultipartFile image,
			@PathVariable("postId") Integer postId)throws IOException {
		
		PostDto postDto =  this.postService.getPostById(postId);
		String fileName =  this.fileService.uploadImage(path, image);
		
		postDto.setImageName(fileName);
		
		PostDto updatePostDto =  this.postService.updatePost(postDto, postId);
		return new ResponseEntity<PostDto>(updatePostDto,HttpStatus.OK);
	}
	
	// method to serve files 
	@GetMapping(value = "/post/image/{imageName}",produces = MediaType.IMAGE_JPEG_VALUE)
	public void downloadImage(
			@PathVariable("imageName") String imageName,
			HttpServletResponse response) throws IOException{
		InputStream resource = this.fileService.getResource(path, imageName);
		response.setContentType(MediaType.IMAGE_JPEG_VALUE);
		org.springframework.util.StreamUtils.copy(resource, response.getOutputStream());
	}
	
}
