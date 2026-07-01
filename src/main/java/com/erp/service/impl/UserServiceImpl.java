package com.erp.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.erp.dto.UserDTO;
import com.erp.entity.Role;
import com.erp.entity.Users;
import com.erp.exception.ResourceNotFoundException;
import com.erp.payload.AuthRequest;
import com.erp.repositories.RoleRepository;
import com.erp.repositories.UserRepository;
import com.erp.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl  implements UserService{

	
	public final ModelMapper mapper;
	public final UserRepository userRepository;
	public final PasswordEncoder encoder;
	public final RoleRepository roleRepository;
	@Override
	public UserDTO registerUser(UserDTO userDTO) {
		
		Users users = mapper.map(userDTO, Users.class);
		users.setPassword(encoder.encode(users.getPassword()));
		Users savedUser = userRepository.save(users);
		return mapper.map(savedUser, UserDTO.class);
	}

	@Override
	public UserDTO loginUser(AuthRequest authRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDTO assignRoleToUser(Integer roleId, Integer userId) {
		
		Role role = roleRepository.findById(roleId).orElseThrow(()->new ResourceNotFoundException("Role Not Found With id :"+roleId));
		
		Users users = userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User Not Found With id :"+userId));
		
		users.setRole(role);
		
		Users savedRepository = userRepository.save(users);
		
		
		return mapper.map(savedRepository, UserDTO.class);
	}

}
