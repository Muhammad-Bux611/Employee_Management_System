package com.erp.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer deptId;

	@Column(unique = true,nullable = false)
	private String departmentName;
	private String departmentDiscription;
	
	@OneToMany(mappedBy = "department")
	private List<Employee> employees;
	
}
