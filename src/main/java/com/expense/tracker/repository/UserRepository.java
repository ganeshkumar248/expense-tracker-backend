package com.expense.tracker.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.expense.tracker.model.User;

@Repository
public interface UserRepository extends JpaRepository<User , Long>{

	Optional<User> findByUsername(String username);

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);
	
	Optional<User> findById(Long id);
}
