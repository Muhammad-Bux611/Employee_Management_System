package com.erp.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erp.dto.EmployeeDTO;
import com.erp.entity.Employee;
import com.erp.exception.ResourceNotFoundException;
import com.erp.repositories.EmployeeRepository;
import com.erp.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private ModelMapper mapper;
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
		
		Employee employee = mapper.map(employeeDTO, Employee.class);
		
		Employee savedEmployee = employeeRepository.save(employee);
		
		return mapper.map(savedEmployee, EmployeeDTO.class);
	}

	@Override
	public EmployeeDTO getEmployeeById(Integer empId) {
		// TODO Auto-generated method stub
		
		Employee employee = employeeRepository.findById(empId).orElseThrow(()->new ResourceNotFoundException("Employee not found with id :"+empId));
		
		return mapper.map(employee, EmployeeDTO.class);
	}

	@Override
	public List<EmployeeDTO> getAll() {
		// TODO Auto-generated method stub
		
		List<Employee> list = employeeRepository.findAll();
		
		if (list.isEmpty()) {
			throw new ResourceNotFoundException("Not any employee is stored in the database");
		}
		else {
			List<EmployeeDTO> employees = list.stream().map(employee->mapper.map(employee, EmployeeDTO.class)).toList();
			return employees;
		}
		
	}

	@Override
	public EmployeeDTO getByEmail(String email) {
		
		Employee employee = employeeRepository.findByEmail(email).orElseThrow(()->new ResourceNotFoundException("Employee not found with id :"+email));

		return mapper.map(employee, EmployeeDTO.class);
	}

	@Override
	public boolean deleteEmployeeById(Integer empId) {
		// TODO Auto-generated method stub
		
		boolean isRemoved = false;
		
		Employee employee = employeeRepository.findById(empId).orElseThrow(()->new ResourceNotFoundException("Employee not found with id :"+empId));
		
		if (employee!=null) {
			employeeRepository.delete(employee);
			isRemoved = true;
		}
		
		return isRemoved;
	}

}
