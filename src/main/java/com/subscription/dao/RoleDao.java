package com.subscription.dao;

import com.subscription.dto.RoleRegistrationDto;
import com.subscription.dto.UserRegistrationDto;
import com.subscription.entity.Role;
import com.subscription.entity.User;

public interface RoleDao {

	Role getRole(Integer roleId);
	Role updateRole(User user);
	Role findByName(String name);
	void  saveRole();
	
}
