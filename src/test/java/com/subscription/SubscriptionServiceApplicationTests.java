package com.subscription;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.subscription.dto.FamilyMemberRegistrationDto;
import com.subscription.entity.FamilyMember;
import com.subscription.entity.User;
import com.subscription.service.FamilyMemberService;
import com.subscription.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SubscriptionServiceApplicationTests {
	@Autowired
	private UserService userService;
	@Autowired
	private FamilyMemberService familyMemberService;

	@Before
	public void initDB() {
		{
			User newUser = new User("newUser123", "newUser123@gmail.com","12345678", "27");
			userService.createUser(newUser);
		}
		{
			User newUser = new User("newAdmin123", "newAdmin123@gmail.com","12345678", "27");
			userService.createUser(newUser);
		}
		FamilyMemberRegistrationDto familyMemberDto = new FamilyMemberRegistrationDto();
		familyMemberDto.setName("Peter");
		familyMemberDto.setAge("20");
		familyMemberDto.setEmail("peter123@gmail.com");
		familyMemberDto.setDescription("Brother");
				

		User user = userService.findByEmail("newUser123@gmail.com");
		familyMemberService.addFamilyMember(familyMemberDto, user);
		
	}
	

	@Test
	public void testUser() {
		User user = userService.findByEmail("newUser123@gmail.com");
		assertNotNull(user);
		User admin  = userService.findByEmail("newAdmin123@gmail.com");
		assertEquals(admin.getEmail(), "newAdmin123@gmail.com");
	}

	
	@Test
	public void testFamilyMember() {
		User user = userService.findByEmail("newUser123@gmail.com");
		List<FamilyMember> familyMember = familyMemberService.findUserFamilyMember(user);
		assertNotNull(familyMember);
		
	}
}
