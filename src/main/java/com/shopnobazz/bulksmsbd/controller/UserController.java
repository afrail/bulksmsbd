package com.shopnobazz.bulksmsbd.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shopnobazz.bulksmsbd.domain.User;
import com.shopnobazz.bulksmsbd.service.UserService;

@Controller
@RequestMapping(value="/user")
public class UserController {
@Autowired
UserService userService;
	
	@RequestMapping("/profile")
	public String userProfile(Model model, Principal principal) {
		User user=userService.findByUsername(principal.getName());
		
		model.addAttribute("user", user);
		
		
		return "profile";
		
	}

}
