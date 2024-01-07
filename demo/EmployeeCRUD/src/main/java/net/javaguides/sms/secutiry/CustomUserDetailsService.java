package net.javaguides.sms.secutiry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import net.javaguides.sms.Exception.ResourceNotFoundException;
import net.javaguides.sms.User.UserEntity;
import net.javaguides.sms.User.UserRepository;

public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
 		// loading user from database by username
		
		UserEntity user = this.userRepository.findByEmail(username).orElseThrow(()-> new ResourceNotFoundException(username));
		return null;
	}

}
