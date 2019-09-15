package com.subscription.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class FamilyMemberRegistrationDto {
	
	
	

	@NotEmpty
	private String name;
	
	@NotEmpty
	@Email
	private String email;
	
	@NotBlank
	private String age;
	
	@NotEmpty
	private String description;
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getDescription() {
		return description;
	}

	

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public FamilyMemberRegistrationDto() {
		
	}

}
