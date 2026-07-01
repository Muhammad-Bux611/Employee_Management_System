package com.erp.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erp.dto.DepartmentDTO;
import com.erp.entity.Department;
import com.erp.exception.ResourceNotFoundException;
import com.erp.repositories.DepartmentRepository;
import com.erp.service.DepartmentService;
@Service
public class DepartmentServiceImpl implements DepartmentService {
	
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public DepartmentDTO createDepartment(DepartmentDTO departmentDTO) {
		Department department = mapper.map(departmentDTO, Department.class);
		
		Department savedDepartment = departmentRepository.save(department);
		return mapper.map(savedDepartment, DepartmentDTO.class);
	}

	@Override
	public List<DepartmentDTO> getAllDepartment() {

		List<Department> listOfDepartment = departmentRepository.findAll();
		if (listOfDepartment.isEmpty()) {
			throw new ResourceNotFoundException("NO any department is storoed in the database");
			
		}
		List<DepartmentDTO> listOfDepartmentDTos = listOfDepartment.stream().map(dept->mapper.map(dept, DepartmentDTO.class)).toList();
		
		return listOfDepartmentDTos;
	}

	@Override
	public DepartmentDTO getDepartmentById(Integer deptId) {

		Department department = departmentRepository.findById(deptId).orElseThrow(()->new ResourceNotFoundException("Department not found with id :"+deptId));
		
		return mapper.map(department, DepartmentDTO.class);
	}

	@Override
	public boolean deleteDepartment(Integer deptId) {

		boolean isRemoved = false;
		Department department = departmentRepository.findById(deptId).orElseThrow(()->new ResourceNotFoundException("Department not found with id :"+deptId));

		if (department!=null) {
			departmentRepository.delete(department);
			
			isRemoved = true;
			
		}
		
		
		return isRemoved;
	}

}
