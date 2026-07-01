package com.erp.service;

import com.erp.dto.RoleDTO;
import com.erp.dto.UserDTO;
import com.erp.payload.AuthRequest;

public interface UserService {
	
	public UserDTO registerUser(UserDTO userDTO);
	public UserDTO loginUser(AuthRequest authRequest);

	public UserDTO assignRoleToUser(Integer roleId,Integer userId);

}
