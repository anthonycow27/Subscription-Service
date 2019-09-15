package com.subscription.controller;

import java.security.Principal;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.subscription.dto.FamilyMemberRegistrationDto;
import com.subscription.dto.UserRegistrationDto;
import com.subscription.entity.FamilyMember;
import com.subscription.entity.User;
import com.subscription.service.FamilyMemberService;
import com.subscription.service.UserService;

@Controller

public class FamilyMemberController {


	@Autowired
	private FamilyMemberService familyMemberService;

	@Autowired
	private UserService userService;

	@ModelAttribute("member")
	public FamilyMemberRegistrationDto familyMemberRegistrationDto() {
		return new FamilyMemberRegistrationDto();
	}

	@RequestMapping(value="/familyMembers",method=RequestMethod.GET)
	public String showProfilePage(Model model, Principal principal) {
		String username = principal.getName();
		User user = userService.findByUsername(username);

		model.addAttribute("familyMemberList", familyMemberService.findUserFamilyMember(user));
		return "views/profile";
	}


	@GetMapping("/{familyMemberId}")
//	@RequestMapping(value="{familyMemberId}",method=RequestMethod.GET)
	public String editFamilyMember(@PathVariable("familyMemberId") Integer familyMemberId, Model model, Principal principal) {
		String username = principal.getName();
		User user = userService.findByUsername(username);
		FamilyMember familyMember = familyMemberService.findByFamilyMemberId(familyMemberId);

		model.addAttribute("familyMember", familyMember);
//		model.addAttribute("familyMember", new FamilyMember());
		return "views/updateForm";


	}




//	@RequestMapping(value="/familyMembers/update/{familyMemberId}",method=RequestMethod.POST)
	@PostMapping("/{familyMemberId}")
	public String updateFamilyMember(@PathVariable("familyMemberId") Integer familyMemberId,  @ModelAttribute("member") @Valid FamilyMemberRegistrationDto familyMemberDto, BindingResult bindingResult, Principal principal) {		
				String username = principal.getName();
				User user = userService.findByUsername(username);
				FamilyMember familyMember = familyMemberService.findByFamilyMemberId(familyMemberId);
				if(bindingResult.hasErrors()) {
					familyMember.setFamilyMemberId(familyMemberId);
					return "views/updateForm";
				}
				familyMemberService.updateFamilyMember(familyMemberDto, userService.findByEmail(user.getEmail()));
				
		return "redirect:/familyMembers";
	}



	@GetMapping("/familyMembers/delete/{familyMemberId}")
	public String deleteFamilyMember(@PathVariable("familyMemberId") Integer familyMemberId, Model model, Principal principal) {
		String username = principal.getName();
		User user = userService.findByUsername(username);

		FamilyMember familyMember = familyMemberService.findByFamilyMemberId(familyMemberId);
		familyMemberService.deleteFamilyMember(familyMember);

		model.addAttribute("familyMemberList", familyMemberService.findUserFamilyMember(user));

		return "redirect:/familyMembers";
		//		return "views/profile";
	}
}
