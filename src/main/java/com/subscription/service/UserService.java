package com.subscription.service;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.subscription.dao.UserDao;
import com.subscription.dto.RoleRegistrationDto;
import com.subscription.dto.UserRegistrationDto;
import com.subscription.entity.User;

@Service
public class UserService  {
	
	@Autowired
	@Qualifier("userDaoImpl")
	private UserDao userDao;
	
	public User getUser(Integer userId) {
		return this.userDao.getUser(userId);
	}
	
	public User getUser(String user, String password) {
		return this.userDao.getUser(user, password);
	}
	public void updateUser(String username, String newPassword, String oldPassword) throws NoSuchAlgorithmException {
		this.userDao.updateUser(username, newPassword, oldPassword);
	}
	public void createUser(User user) {
		this.userDao.createUser(user);
	}
	public void createAdmin(User user) {
		this.userDao.createAdmin(user);
	}
	
	
	public User findByEmail(String email) {
		return this.userDao.findByEmail(email);
	}
	
	public User findByUsername(String username) {
		return this.userDao.findByUsername(username);
	}
	
	
	public User save(UserRegistrationDto registration) {
		return this.userDao.save(registration);
	}

	public List<User> findAll() {
		
		return this.userDao.findAll();
	}

	public List<User> findByName(String username) {
		return this.userDao.findByUsernameLike(username);
	}

	
}
