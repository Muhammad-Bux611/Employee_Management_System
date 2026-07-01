package com.erp.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class UserDTO {

	@NotBlank(message = "username is required")
	@Size(min = 3,message = "Username should contail atleast 3 characters")
	private String username;
	@NotBlank(message = "Email is required")
	@Email(message = "Please enter a valid email address")
	@Pattern(
	    regexp = "^[A-Za-z0-9._%+-]+@gmail\\.com$",
	    message = "Only Gmail addresses are allowed"
	)
	private String email;
	@Size(min = 8 ,max = 12 ,message = "password should be 8-12 character" )
	private String password;
	
	private RoleDTO role;
}
