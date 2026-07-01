package com.erp.payload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AuthRequest {

	@NotBlank(message = "message is required")
	@Email(message = "Please enter a valid email")
	@Pattern(
		    regexp = "^[A-Za-z0-9._%+-]+@gmail\\.com$",
		    message = "Only Gmail addresses are allowed"
		)
	
	private String email;

	@Size(min = 8 ,max = 12 ,message = "password should be 8-12 character" )
	private String password;
	
}
