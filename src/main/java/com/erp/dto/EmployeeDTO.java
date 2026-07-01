package com.erp.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EmployeeDTO {

	@NotBlank( message =  "Full Name is required")
	@Size(min = 3,message = "full name must contain atleast 3 letters")
	private String fullName;
	@NotBlank(message = "last name is required")
	@Size(min = 3 ,message = "last name must contain atleast 3 letters")
	private String lastName;
	@NotBlank(message =  "Email is required")
	@Email(message = "Please enter a valid email")
	@Pattern(
		    regexp = "^[A-Za-z0-9._%+-]+@gmail\\.com$",
		    message = "Only Gmail addresses are allowed"
		)
	private String email;
	@NotNull(message =  "Salary is required")
	@Min(1000)
	private Double salary;
	@NotBlank(message =  "Designation is required")
	private String designation;
}
