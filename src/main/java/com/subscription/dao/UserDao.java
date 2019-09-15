package com.subscription.dao;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.subscription.dto.RoleRegistrationDto;
import com.subscription.dto.UserRegistrationDto;
import com.subscription.entity.User;

public interface UserDao extends UserDetailsService {
	//	The most relevant facet of this process is how UserDao hides from the application all the low-level details 
	//	on how the objects are persisted, updated, and deleted.
	User getUser(Integer userId);
	User getUser(String user, String password);
	void updateUser(String username, String newPassword, String oldPassword) throws NoSuchAlgorithmException;
	void createUser(User user);
	void createAdmin(User user);
	
	User findByEmail(String email);
	User findByUsername(String username);
	User save(UserRegistrationDto registration);
	List<User> findAll();
	List<User> findByUsernameLike(String username);
}
