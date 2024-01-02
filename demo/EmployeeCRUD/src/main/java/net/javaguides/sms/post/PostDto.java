package net.javaguides.sms.post;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import net.javaguides.sms.Categories.CategoryDTO;
import net.javaguides.sms.User.UserDto;
import net.javaguides.sms.comments.CommentDto;
import net.javaguides.sms.comments.CommentEntity;
 
public class PostDto {

	private Integer postId;
	private String postTitle;
	
	private String content;

	private String imageName;
	
	private Date date;
	
	private CategoryDTO categoryDto;
	
	private UserDto userDto;

	private Set<CommentDto> comment = new HashSet<>();
	public PostDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PostDto(Integer postId, String postTitle, String content, String imageName, Date date,
			CategoryDTO categoryDto, UserDto userDto, Set<CommentDto> comment) {
		super();
		this.postId = postId;
		this.postTitle = postTitle;
		this.content = content;
		this.imageName = imageName;
		this.date = date;
		this.categoryDto = categoryDto;
		this.userDto = userDto;
		this.comment = comment;
	}
	public Integer getPostId() {
		return postId;
	}
	public void setPostId(Integer postId) {
		this.postId = postId;
	}
	public String getPostTitle() {
		return postTitle;
	}
	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public CategoryDTO getCategoryDto() {
		return categoryDto;
	}
	public void setCategoryDto(CategoryDTO categoryDto) {
		this.categoryDto = categoryDto;
	}
	public UserDto getUserDto() {
		return userDto;
	}
	public void setUserDto(UserDto userDto) {
		this.userDto = userDto;
	}
	public Set<CommentDto> getComment() {
		return comment;
	}
	public void setComment(Set<CommentDto> comment) {
		this.comment = comment;
	}
	@Override
	public String toString() {
		return "PostDto [postId=" + postId + ", postTitle=" + postTitle + ", content=" + content + ", imageName="
				+ imageName + ", date=" + date + ", categoryDto=" + categoryDto + ", userDto=" + userDto + ", comment="
				+ comment + "]";
	}

 
 
}
