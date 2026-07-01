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

import com.erp.dto.EmployeeDTO;
import com.erp.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("/")
	public ResponseEntity<EmployeeDTO> createEmployee(@Valid @RequestBody EmployeeDTO employeeDTO ){
		EmployeeDTO employee = employeeService.createEmployee(employeeDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(employee);
	}
	

	@GetMapping("/")
	public ResponseEntity<List<EmployeeDTO>> getAll(){
		return ResponseEntity.status(HttpStatus.FOUND).body(employeeService.getAll());
	}
	
	@GetMapping("/{empId}")
	public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable Integer empId){
		
		return ResponseEntity.status(HttpStatus.FOUND).body(employeeService.getEmployeeById(empId)
				);
	}
	@DeleteMapping("/{empId}")
	public ResponseEntity<?> deleteEmployee(@PathVariable Integer empId){
		
		boolean deleteEmployeeById = employeeService.deleteEmployeeById(empId);
		if (deleteEmployeeById) {
			
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("The employee is successfully deleted from the database");
		}else
		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("The employee is not deleted something went to wrong");
	}
}
