package com.erp.service;

import java.util.List;

import com.erp.dto.EmployeeDTO;

public interface EmployeeService {

	public EmployeeDTO createEmployee(EmployeeDTO employeeDTO);
	public EmployeeDTO getEmployeeById(Integer empId);
	public List<EmployeeDTO> getAll();
	public EmployeeDTO getByEmail(String email);
	public boolean deleteEmployeeById(Integer empId);
	
	
}
