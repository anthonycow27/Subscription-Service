package com.subscription.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.subscription.dto.RoleRegistrationDto;
import com.subscription.dto.UserRegistrationDto;
import com.subscription.entity.Role;
import com.subscription.entity.User;
import com.subscription.repository.RoleRepository;

@Repository
@Qualifier("roleDaoImpl")
public class RoleDaoImpl implements RoleDao{

	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public Role getRole(Integer roleId) {
		return roleRepository.findById(roleId).orElse(null);
	}

	@Override
	public Role updateRole(User user) {
		String name  = "";
		for(Role role :user.getRoles()) {
			name = role.getName();
		}
		Role role = roleRepository.findByName(name);
		List<User> list = role.getUsers();
//		User user = new User();
//		user.setUsername(userDto.getUsername());
//		user.setAge(userDto.getAge());
//		user.setEmail(userDto.getEmail());
//		user.setPassword(passwordEncoder.encode(userDto.getPassword()));
//		Role userRole = new Role("USER");
//		Set<Role> userRoleSet = new HashSet<Role>();
//		userRoleSet.add(userRole);
//		user.setRoles(userRoleSet);
		list.add(user);
		return roleRepository.save(role);
	}

	@Override
	public Role findByName(String name) {
		return roleRepository.findByName(name);
	}

	@Override
	public void  saveRole() {
		List<User> userSet = new ArrayList();
		Role userRole = new Role("USER", userSet);
		Role adminRole = new Role("ADMIN", userSet);
		roleRepository.save(userRole);
		roleRepository.save(adminRole);
		
		
	}
	
	

}
