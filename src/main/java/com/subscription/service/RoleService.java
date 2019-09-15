package com.subscription.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.subscription.dao.RoleDao;
import com.subscription.dto.RoleRegistrationDto;
import com.subscription.dto.UserRegistrationDto;
import com.subscription.entity.Role;
import com.subscription.entity.User;

@Service
public class RoleService {

	@Autowired
	@Qualifier("roleDaoImpl")
	private RoleDao roleDao;
	
	public Role getRole(Integer roleId) {
		return this.roleDao.getRole(roleId);
	}
	
	public Role findByName(String name) {
		return this.roleDao.findByName(name);
	}
	
	public Role updateRole(User user) {
		return this.roleDao.updateRole(user);
	}
	public void saveRole() {
		 this.roleDao.saveRole();
	}
}
