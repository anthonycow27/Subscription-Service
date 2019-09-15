package com.subscription.dto;

import java.util.Collection;

import javax.persistence.ManyToMany;
import javax.validation.constraints.NotEmpty;

import com.subscription.entity.User;

public class RoleRegistrationDto {

	
	
	@NotEmpty
	private String name;
	
	private Collection<User> users ;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Collection<User> getUsers() {
		return users;
	}

	public void setUsers(Collection<User> users) {
		this.users = users;
	}

	
	

}
