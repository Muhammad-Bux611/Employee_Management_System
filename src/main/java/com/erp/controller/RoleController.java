package com.erp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erp.dto.RoleDTO;
import com.erp.service.RoleService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/roles")
public class RoleController {

	@Autowired
	private RoleService roleService;
	@PostMapping("/create")
	public ResponseEntity<RoleDTO> createRole(@Valid @RequestBody RoleDTO roleDTO){
		return ResponseEntity.status(HttpStatus.OK).body(roleService.createRoles(roleDTO));
	}
	
	
}
