package com.erp.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.erp.entity.Users;

public interface UserRepository extends JpaRepository<Users, Integer> {

	Optional<Users> findByEmail(String email);
	
}
