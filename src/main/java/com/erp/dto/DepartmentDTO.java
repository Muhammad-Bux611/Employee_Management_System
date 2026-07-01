package com.erp.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DepartmentDTO {

	@NotBlank(message = "Department name is required")
	@Size(min = 5 ,message = "department name should atleast contain 5 letters")
	private String departmentName;
	@NotBlank(message = "Department Discription filed is required")
	@Size(min = 25, max = 250,message = "write the discription for the department that contain between 25 to 250 letters")
	private String departmentDiscription;
	
}
