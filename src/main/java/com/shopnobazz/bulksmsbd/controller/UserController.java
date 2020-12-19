package com.shopnobazz.bulksmsbd.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shopnobazz.bulksmsbd.Repository.ParchesHistoryRepository;
import com.shopnobazz.bulksmsbd.domain.ParchesHistory;
import com.shopnobazz.bulksmsbd.domain.SendingHistory;
import com.shopnobazz.bulksmsbd.domain.User;
import com.shopnobazz.bulksmsbd.service.ParchesService;
import com.shopnobazz.bulksmsbd.service.SendingHistoryService;
import com.shopnobazz.bulksmsbd.service.UserService;

@Controller
@RequestMapping(value="/user")
public class UserController {
@Autowired
UserService userService;
@Autowired
SendingHistoryService sendingHistoryService;
@Autowired
ParchesService parchesService;
	
	@RequestMapping("/profile")
	public String userProfile(Model model, Principal principal) {
		User user=userService.findByUsername(principal.getName());
		List<ParchesHistory> parchesHistory= parchesService.findByUser(user);
		model.addAttribute("parchesHistory", parchesHistory);
		model.addAttribute("user", user);
		
		
		return "profile";
		
	}
	@RequestMapping("/creditcard")
	public String creditCard() {
		return "addCard";
	}
	@RequestMapping("/sending")
	public String sendingHistory(Model model, Principal principal) {
		User user=userService.findByUsername(principal.getName());
		List<SendingHistory> sendingHistory = sendingHistoryService.findAll(user);
		model.addAttribute("sendingHistory", sendingHistory);
		return"sendingHistory";
	}

}
