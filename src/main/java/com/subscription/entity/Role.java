package com.subscription.entity;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.subscription.entity.User;

@Entity
@Table( name = "roles")
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer roleId;
	
	
	@NotEmpty
	private String name;	
	
//	@ManyToMany
	@ManyToMany(mappedBy = "roles")
	private List<User> users ;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	
	public Role() {
		
	}
	

	
	
	public Role(@NotEmpty String name) {
		
		this.name = name;
	}
	
	
	public Role(@NotEmpty String name, List<User> users) {
		
		this.name = name;
		this.users = users;
	}
	
	
	@Override
    public String toString() {
        return "Role{" +
                "id=" + roleId +
                ", name='" + name + '\'' +
                '}';
    }
	
	
	
}
