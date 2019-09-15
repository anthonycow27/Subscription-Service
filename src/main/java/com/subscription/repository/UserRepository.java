package com.subscription.repository;


import java.util.List;
import java.util.Optional;

import javax.persistence.Id;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.subscription.entity.User;


public interface UserRepository extends JpaRepository<User, Integer>{
	
	@Query(value = "SELECT id, username, password, email, age FROM user WHERE username = ?1 AND password = ?2", nativeQuery = true)
	Optional<User> findByUserAndPassword(String user, String shaPassword);
	
	User findByEmail(String email);
	User findByUsername(String username);

	List<User> findByUsernameLike(String username);
}
