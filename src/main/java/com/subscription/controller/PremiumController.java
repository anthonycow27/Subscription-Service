package com.subscription.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.subscription.dto.FamilyMemberRegistrationDto;
import com.subscription.entity.FamilyMember;
import com.subscription.entity.User;
import com.subscription.service.FamilyMemberService;
import com.subscription.service.UserService;

@Controller
public class PremiumController {

	@Autowired
	private FamilyMemberService familyMemberService;

	@Autowired
	private UserService userService;

	@ModelAttribute("member")
	public FamilyMemberRegistrationDto familyMemberRegistrationDto() {
		return new FamilyMemberRegistrationDto();
	}

	@RequestMapping(value="/premium", method=RequestMethod.GET)
	public String registerForm(Model model) {
		model.addAttribute("member", new FamilyMember());
		return "views/familyMemberForm";
	}

//	@GetMapping("/premium/update")
//	public String updatePremium(Model model) {
//		
//	}
	
	@RequestMapping(value="/premium", method=RequestMethod.POST)
	public String showFamilyMember(@ModelAttribute("member") @Valid FamilyMemberRegistrationDto familyMemberDto,
			BindingResult bindingResult,Principal principal) {
		
		String username = principal.getName();
		User user = userService.findByUsername(username);
		
		FamilyMember existing = familyMemberService.findByEmail(familyMemberDto.getEmail());

		if(existing != null) {
			bindingResult.rejectValue("email", null, "There is already an account registered with that email");
		}
		if(bindingResult.hasErrors()) {
			return "views/familyMemberForm";
		}

		//String email = (String) session.getAttribute("email");
		familyMemberService.addFamilyMember(familyMemberDto, userService.findByEmail(user.getEmail()));
		

		return "redirect:/familyMembers";
	}
}
