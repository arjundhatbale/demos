package net.javaguides.sms.User;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import net.javaguides.sms.Exception.ResourceNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public List<UserDto> getAllUser(){
		List<UserEntity> userList = userRepository.findAll();
		List<UserDto> userDtoList = userList.stream().map(list -> this.modelMapper.map(list, UserDto.class)).collect(Collectors.toList());
		return  userDtoList;
	}
	
	public UserDto getUser(Integer userId) {
		UserEntity entity = userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException(" User id of : " + userId + " is not found "));
		return this.modelMapper.map(entity, UserDto.class);
	}
	
//	public ResponseEntity<UserEntity> saveUser(UserEntity entity){
//		UserEntity entity2 = userRepository.save(entity);
//		return new ResponseEntity< >(entity2,HttpStatus.CREATED);
//	}
	
	public UserEntity saveUserEntity(UserEntity userEntity) {
		return userRepository.save(userEntity);
	}
	public ResponseEntity<String> deleteUser(Integer userId){
		Optional<UserEntity> user = userRepository.findById(userId);
		if(((Optional<UserEntity>) user).isPresent()) {
			userRepository.deleteById(userId);
 			return new ResponseEntity("Employee with id : \" + id + \" is deleted successfully.", HttpStatus.ACCEPTED);
		}else {
			System.out.println();
 			return new ResponseEntity("Employee with id " + userId + " is not found.", HttpStatus.NOT_FOUND);
		}
	}
	
	public UserEntity dtoToUser(UserDto userDTO ) {
		UserEntity userEntity = this.modelMapper.map(userDTO, UserEntity.class);
		return userEntity;
	}
	
	public UserDto userDTOToUserEntity(UserEntity userEntity) {
		UserDto userDTO = modelMapper.map(userEntity, UserDto.class);
		return userDTO;
	}
}
