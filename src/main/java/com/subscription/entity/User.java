package com.subscription.entity;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;


import com.subscription.entity.Role;
import com.subscription.entity.FamilyMember;


@Entity
@Table( name = "users",uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;


	@NotEmpty
	@Column(unique=true)	
	private String username;


	@Email
	@NotEmpty
	//@Column(unique=true)
	private String email;

	@NotEmpty
	@Size(min = 4)
	private String password;

	@NotEmpty
	private String age;



	//	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)

	//	@ManyToMany( cascade = CascadeType.ALL)
	//	@Fetch(value = FetchMode.SUBSELECT)
	//    @JoinTable(
	//            name = "users_familyMembers",
	//            joinColumns = @JoinColumn(
	//                    name = "user_id", referencedColumnName = "userId"),
	//            inverseJoinColumns = @JoinColumn(
	//                    name = "familyMembers_id", referencedColumnName = "familyMembersId"))
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<FamilyMember> familyMembers;



	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	//	 @ManyToMany( fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	//	 @Fetch(value = FetchMode.SUBSELECT)


	//	 @JoinTable(name = "USER_ROLES", joinColumns={
	//				@JoinColumn(name = "USERS_ID", referencedColumnName = "userId") }, inverseJoinColumns = {
	//						@JoinColumn(name = "ROLES_ID", referencedColumnName = "roleId") })
	@JoinTable(name = "USERS_AND_ROLES", joinColumns={
			@JoinColumn(name = "USERS_ID") }, inverseJoinColumns = {
					@JoinColumn(name = "ROLES_ID") })
	private List<Role> roles;



	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}


	public List<FamilyMember> getFamilyMembers() {
		return familyMembers;
	}
	public void setFamilyMembers(List<FamilyMember> familyMembers) {
		this.familyMembers = familyMembers;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}



	public User() {

	}
	public User(@NotEmpty String username, @Email @NotEmpty String email, @Size(min = 4) String password,
			@NotBlank String age) {

		this.username = username;
		this.email = email;
		this.password = password;
		this.age = age;
	}

		
		public User(@NotEmpty String username, @Email @NotEmpty String email, @Size(min = 4) String password,
				@NotBlank String age, List<Role> roles) {
		
			this.username = username;
			this.email = email;
			this.password = password;
			this.age = age;
			this.roles = roles;
		}



	@Override
	public String toString() {
		return "User{" +
					                "id=" + userId +
				", username='" + username + '\'' +
				", email='" + email + '\'' +
				", password='" + "*********" + '\'' +
				", age='" + age + '\'' +
				", familyMembers=" + familyMembers +
				", roles=" + roles +
				'}';
	}
	//		




}
