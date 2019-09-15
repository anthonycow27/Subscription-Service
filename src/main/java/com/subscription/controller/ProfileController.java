package com.subscription.controller;

//import java.security.Principal;
//
//import javax.validation.Valid;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import com.subscription.dto.FamilyMemberRegistrationDto;
//import com.subscription.entity.FamilyMember;
//import com.subscription.entity.User;
//import com.subscription.service.FamilyMemberService;
//import com.subscription.service.UserService;


public class ProfileController {

//	@Autowired
//	private FamilyMemberService familyMemberService;
//
//	@Autowired
//	private UserService userService;
//
//	@ModelAttribute("member")
//	public FamilyMemberRegistrationDto familyMemberRegistrationDto() {
//		return new FamilyMemberRegistrationDto();
//	}
//
//	@GetMapping("/familyMembers")
//	public String showProfilePage(Model model, Principal principal) {
//		String username = principal.getName();
//		User user = userService.findByUsername(username);
//
//		model.addAttribute("familyMemberList", familyMemberService.findUserFamilyMember(user));
//		return "views/profile";
//	}
//
//	
////	@GetMapping("/profile/edit")
//	@GetMapping("/profile/edit/{familyMemberId}")
//	public String editFamilyMember(@PathVariable("familyMemberId") Integer familyMemberId, Model model) {
////		String username = principal.getName();
////		User user = userService.findByUsername(username);
//		FamilyMember familyMember = familyMemberService.findByFamilyMemberId(familyMemberId);
//		if(familyMember != null) {
//			model.addAttribute("familyMember", familyMember);
//			return "views/updateForm";
//		}
////		return "redirect:/profile/update/{familyMemberId}";
//		return "redirect:/profile";
//		
//	}
//	
//	
//	
//	
//	@PostMapping("/profile/update/{familyMemberId}")
////	@PostMapping("/profile/update")
//	public String updateFamilyMember(@PathVariable("familyMemberId") Integer familyMemberId,  @ModelAttribute("familyMember") @Valid FamilyMemberRegistrationDto familyMemberDto, 	BindingResult bindingResult, Model model, Principal principal) {		
////		String username = principal.getName();
////		User user = userService.findByUsername(username);
////		FamilyMember familyMember = familyMemberService.findByFamilyMemberId(familyMemberId);
////		if(bindingResult.hasErrors()) {
////			familyMember.setFamilyMemberId(familyMemberId);
////			return "views/updateForm";
////		}
////		familyMemberService.addFamilyMember(familyMemberDto, userService.findByEmail(user.getEmail()));
////		
//		return "redirect:/profile";
//	}
//	
//
//
//	@GetMapping("/profile/delete/{familyMemberId}")
//	public String deleteFamilyMember(@PathVariable("familyMemberId") Integer familyMemberId, Model model, Principal principal) {
//		String username = principal.getName();
//		User user = userService.findByUsername(username);
//
//		FamilyMember familyMember = familyMemberService.findByFamilyMemberId(familyMemberId);
//		familyMemberService.deleteFamilyMember(familyMember);
//
//		model.addAttribute("familyMemberList", familyMemberService.findUserFamilyMember(user));
//		
//		return "redirect:/profile";
////		return "views/profile";
//	}
}
