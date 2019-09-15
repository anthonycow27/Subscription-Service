package com.subscription;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.templateresolver.ITemplateResolver;

import com.subscription.dto.UserRegistrationDto;
import com.subscription.entity.User;
import com.subscription.service.UserService;

@SpringBootApplication
public class SubscriptionServiceApplication   implements  CommandLineRunner{

	@Autowired
	private UserService userService;
	

	
	public static void main(String[] args) {
		SpringApplication.run(SubscriptionServiceApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		  {
			  User existing = userService.findByEmail( "admin@gmail.com");
			  if(existing == null) {
				  User newAdmin = new User("Admin", "admin@gmail.com",  "123456", "27");
	    		  userService.createAdmin(newAdmin); 
			  }
    		 
    	  }
	}
	

}
