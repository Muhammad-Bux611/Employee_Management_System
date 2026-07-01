package com.erp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import com.erp.entity.Users;
import com.erp.exception.ResourceNotFoundException;
import com.erp.repositories.UserRepository;

@Component
public class UserDetailServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username)  {

		Users users = userRepository.findByEmail(username).orElseThrow(()->new ResourceNotFoundException("User not found with email "+username));
		
		return new CustomUserDetail(users);
	}

}
