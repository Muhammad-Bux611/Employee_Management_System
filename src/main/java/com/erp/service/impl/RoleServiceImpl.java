package com.erp.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erp.dto.RoleDTO;
import com.erp.dto.UserDTO;
import com.erp.entity.Role;
import com.erp.entity.Users;
import com.erp.exception.ResourceNotFoundException;
import com.erp.repositories.RoleRepository;
import com.erp.repositories.UserRepository;
import com.erp.service.RoleService;
@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	ModelMapper mapper;

	@Autowired
	UserRepository userRepository;
	
	@Override
	public RoleDTO createRoles(RoleDTO dto) {
		
		Role role = mapper.map(dto, Role.class);
		
		Role savedRole = roleRepository.save(role);
		
		return mapper.map(savedRole, RoleDTO.class);
	}



}
