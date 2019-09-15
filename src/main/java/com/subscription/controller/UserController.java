package com.subscription.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.subscription.dto.UserRegistrationDto;
import com.subscription.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	
	@GetMapping("/users")
	public String listUsers(Model model,  @RequestParam(defaultValue="")  String username) {
		model.addAttribute("users", userService.findByName(username));
		return "views/list";
	}
}
