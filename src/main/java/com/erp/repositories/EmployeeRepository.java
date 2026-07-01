package com.erp.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.erp.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
	public Optional<Employee> findByEmail(String email);

}
