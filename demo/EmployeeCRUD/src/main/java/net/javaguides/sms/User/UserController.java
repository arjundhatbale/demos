package net.javaguides.sms.User;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAllUser(){
		List<UserDto> alluser = userService.getAllUser();
		return new ResponseEntity<>(alluser,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> getUser(@Valid @PathVariable("userId") Integer userId){
		UserDto dto = userService.getUser(userId);
		return new ResponseEntity<>(dto,HttpStatus.ACCEPTED);
	}
	
//	@PostMapping("/saveUser")
//	public ResponseEntity<UserEntity> saveUser(@Valid   @RequestBody UserEntity userEntity){
// 		ResponseEntity<UserEntity> user = userService.saveUser(userEntity);
// 		return user;
// 	}
	@PostMapping("/")
	public UserEntity saveUser(@Valid @RequestBody UserEntity userEntity) {
		return userService.saveUserEntity(userEntity);
	}
	@DeleteMapping("/{userId}")
	public ResponseEntity<String> deleteUser(@Valid @PathVariable("userId") Integer userId){
 		userService.deleteUser(userId);
 		return new ResponseEntity("Empoyee Deleted successfully with id of : " + userId, HttpStatus.OK);
	}
}
