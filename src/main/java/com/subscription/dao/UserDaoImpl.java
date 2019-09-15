package com.subscription.dao;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.subscription.dto.RoleRegistrationDto;
import com.subscription.dto.UserRegistrationDto;
import com.subscription.entity.Role;
import com.subscription.entity.User;
import com.subscription.repository.UserRepository;
import com.subscription.security.EncryptionHelper;

@Repository
@Qualifier("userDaoImpl")
public  class UserDaoImpl implements UserDao{

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public User getUser(Integer userId) {
		return userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User with id" + userId + "not found."));
	}

	@Override
	public User getUser(String user, String password) {
		String shaPassword=null;
		try {
			shaPassword = EncryptionHelper.toSHA256(password);
		} catch (NoSuchAlgorithmException e) {
			genericMessage();
		}
		return userRepository.findByUserAndPassword(user, shaPassword)
				.orElseThrow(() -> new RuntimeException("The username or password are incorrect."));
	}
	@Override
	public void updateUser(String username, String newPassword, String oldPassword) throws NoSuchAlgorithmException {
		User user = getUser(username, oldPassword);
		user.setPassword(newPassword);
		userRepository.save(user);
	}

	@Override
	public void createUser(User user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		Role userRole = new Role("USER");
		List<Role> roles =  new ArrayList<>();
		roles.add(userRole);
	//	user.setRoles(roles);
		userRepository.save(user);

	}

	@Override
	public void createAdmin(User user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		Role userRole = new Role("ADMIN");
		List<Role> roles =  new ArrayList<>();
		roles.add(userRole);
		user.setRoles(roles);
		userRepository.save(user);

	}

	public void genericMessage() {
		new RuntimeException("something went wrong please try again later.");
	}




	@Override
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public User save(UserRegistrationDto registration) {
		User user = new User();
		user.setUsername(registration.getUsername());
		user.setAge(registration.getAge());
		user.setEmail(registration.getEmail());
		user.setPassword(passwordEncoder.encode(registration.getPassword()));
		Role userRole = new Role("USER");
		userRole.setName("USER");
		List<Role> roles =  new ArrayList<>();
		roles.add(userRole);
		user.setRoles(roles);

		return userRepository.save(user);
		
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(email);
		if (user == null){
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(),
				user.getPassword(),
				mapRolesToAuthorities(user.getRoles()));
	}

	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
		return roles.stream()
				.map(role -> new SimpleGrantedAuthority(role.getName()))
				.collect(Collectors.toList());
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public List<User> findByUsernameLike(String username) {
		return userRepository.findByUsernameLike("%"+ username + "%");
	}

	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	

}
