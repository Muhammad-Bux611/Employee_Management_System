package com.erp.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class RoleDTO {

	@NotBlank(message = "Role name is required")
	 @Pattern(
		        regexp = "^ROLE_[A-Z]+$",
		        message = "Role must be in format ROLE_ADMIN, ROLE_EMPLOYEE, etc."
		    )
	private String roleName;
	
	
}
