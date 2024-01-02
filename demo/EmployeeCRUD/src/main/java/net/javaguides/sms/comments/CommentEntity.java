package net.javaguides.sms.comments;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import net.javaguides.sms.post.Post;

@Entity
@Table(name="comments")
public class CommentEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String content;  // comment of post
	
	@ManyToOne
	private Post post;

	public CommentEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CommentEntity(int id, String content, Post post) {
		super();
		this.id = id;
		this.content = content;
		this.post = post;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	@Override
	public String toString() {
		return "CommentEntity [id=" + id + ", content=" + content + ", post=" + post + "]";
	}
	
	
}
