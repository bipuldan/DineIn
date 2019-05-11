package com.dinein.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dinein.model.User;

public interface UserRepository extends JpaRepository<User, String>{
	
	@Query("Select user from User user where user.email =email and user.password =password")
	User validate(String email, String password);
	
	User findByEmailAndPassword(String email, String password);

	Optional<User> findByEmail(String email);
}
