package com.subscription.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.subscription.dto.UserRegistrationDto;
import com.subscription.entity.Role;
import com.subscription.entity.User;
import com.subscription.service.RoleService;
import com.subscription.service.UserService;

@Controller

public class RegisterController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	@ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }
	
	@GetMapping("/register")
	public String registerForm(Model model) {
		model.addAttribute("user", new User());
		return "views/registerForm";
	}
	
	@PostMapping("/register")
	public String registerUser(@ModelAttribute("user") @Valid UserRegistrationDto userDto,
            BindingResult bindingResult) {
		User existing = userService.findByEmail(userDto.getEmail());
		
		if(existing != null) {
			bindingResult.rejectValue("email", null, "There is already an account registered with that email");
		}
		if(bindingResult.hasErrors()) {
			return "views/registerForm";
		}
		
		userService.save(userDto);

		return "views/success";

	}
	
	public boolean checkRoleExist() {
		String userRole = "USER";
		String adminRole = "ADMIN";
		Role existingUserRole = roleService.findByName(userRole);
		Role existingAdminRole = roleService.findByName(adminRole);
		return existingUserRole == null && existingAdminRole == null;
	}
}
