package net.javaguides.sms.post;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import net.javaguides.sms.Categories.CategoryEntity;
import net.javaguides.sms.User.UserEntity;

public interface PostRepository extends JpaRepository<Post, Integer>{


	List<Post> findByUserEntity(UserEntity userEntity);
	
	List<Post> findByCategoryEntity(CategoryEntity categoryEntity);
   // List<Post> findByPostTitle(String  postTitle);
    
	@Query("select postTitle from Post  where postTitle like :key")
    List<Post> searchByPostTitle(@Param("key") String postTitle);
    
}
