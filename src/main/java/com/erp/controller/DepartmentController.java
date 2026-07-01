package com.erp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erp.dto.DepartmentDTO;
import com.erp.service.DepartmentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

	@Autowired
	DepartmentService departmentService;
	
	@PostMapping("/")
	public ResponseEntity<DepartmentDTO> create(@Valid @RequestBody DepartmentDTO departmentDTO){
		DepartmentDTO dto = departmentService.createDepartment(departmentDTO);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(dto);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<DepartmentDTO>> getAll(){
		return ResponseEntity.status(HttpStatus.FOUND).body(departmentService.getAllDepartment());
	}
	
	@GetMapping("/{deptId}")
	public ResponseEntity<DepartmentDTO> DepartmentById(@PathVariable Integer deptId)
	{
		return ResponseEntity.status(HttpStatus.FOUND).body(departmentService.getDepartmentById(deptId));
	}
	
	

	@DeleteMapping("/{deptId}")
	public ResponseEntity<?> delete(@PathVariable Integer deptId)
	{
		boolean isRemoved = departmentService.deleteDepartment(deptId);
		if (isRemoved) {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("The department is successfully deleted");
		}else
		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("The department is not deleted something went to  wrong");
		
	}
	
}
