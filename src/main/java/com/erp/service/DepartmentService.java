package com.erp.service;

import java.util.List;

import com.erp.dto.DepartmentDTO;

public interface DepartmentService {
	
	public DepartmentDTO createDepartment(DepartmentDTO departmentDTO);
	public List<DepartmentDTO> getAllDepartment();
	public DepartmentDTO getDepartmentById(Integer deptId);
	public boolean deleteDepartment(Integer deptId);

}
