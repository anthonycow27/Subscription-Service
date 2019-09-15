package com.subscription.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;



@Entity
@Table( name = "familyMembers")
public class FamilyMember {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer familyMemberId;
	
	@NotEmpty
	private String name;
	@NotEmpty
	@Email
	private String email;
	@NotBlank
	private String age;
	@NotEmpty
	private String description;
	
	
	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private User user;
	


	
	
	
	public Integer getFamilyMemberId() {
		return familyMemberId;
	}



	public void setFamilyMemberId(Integer familyMemberId) {
		this.familyMemberId = familyMemberId;
	}



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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	

	public FamilyMember() {
		
	}

	public FamilyMember(@NotEmpty String name, @NotEmpty @Email String email, @NotBlank String age,
			@NotEmpty String description) {
		
		this.name = name;
		this.email = email;
		this.age = age;
		this.description = description;
	}
	
	
//	
//	public FamilyMember(@NotEmpty String name, @NotEmpty @Email String email, @NotBlank String age,
//			@NotEmpty String description, User user) {
//		
//		this.name = name;
//		this.email = email;
//		this.age = age;
//		this.description = description;
//		this.user = user;
//	}



	@Override
    public String toString() {
        return "FamilyMember{" +
                "id=" + familyMemberId +
                ", name='" + name + '\'' +
                ", name='" + email + '\'' +
                ", name='" + age + '\'' +
                ", name='" + description + '\'' +
                '}';
    }
	
	
	
}
