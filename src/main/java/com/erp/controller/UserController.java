package com.erp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erp.dto.UserDTO;
import com.erp.payload.AuthRequest;
import com.erp.payload.AuthResponse;
import com.erp.security.JwtService;
import com.erp.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class UserController {
	
	@Autowired
	JwtService jwtService;
	
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	private UserService userService;
	@PostMapping("/register")
	public UserDTO register(@Valid @RequestBody UserDTO dto) {
	return	userService.registerUser(dto);
	}
	
	@PostMapping("/login")
	public AuthResponse login(@RequestBody AuthRequest authRequest){
	
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword())
				);
		
		String token = jwtService.generateToken(authRequest.getEmail());
		
		AuthResponse authResponse = new AuthResponse();
		authResponse.setToken(token);
		
		return authResponse;
	}
	
	@PostMapping("/assignRole/role/{roleId}/users/{userId}")
	public UserDTO assignRole(@PathVariable Integer roleId , @PathVariable Integer userId) {
		UserDTO userDTO = userService.assignRoleToUser(roleId, userId);
		
		return userDTO;
	}
	
}
