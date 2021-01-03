//package com.shopnobazz.bulksmsbd.controller;
//
//
//
//import java.security.Principal;
//import java.util.Date;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import com.shopnobazz.bulksmsbd.Repository.CardRepository;
//import com.shopnobazz.bulksmsbd.Repository.RechargehistoryRepository;
//import com.shopnobazz.bulksmsbd.domain.Card;
//import com.shopnobazz.bulksmsbd.domain.RechargeHistory;
//import com.shopnobazz.bulksmsbd.domain.SmsPackage;
//import com.shopnobazz.bulksmsbd.domain.User;
//import com.shopnobazz.bulksmsbd.service.RechargeService;
//import com.shopnobazz.bulksmsbd.service.UserService;
//
//@Controller
//@RequestMapping(value="/balance")
//public class RechargeController {
//	@Autowired
//	UserService userService;
//	@Autowired
//	RechargeService rechargeService;
//	@RequestMapping("/recharge")
//	public String balance(Model model, Principal principal)
//	{
//		User user=userService.findByUsername(principal.getName());
//		List<RechargeHistory> rechargeHistory = rechargeService.findAll(user);
//		
//		Card card= new Card();
//		model.addAttribute("card",card);
//		model.addAttribute("rechargeHistory", rechargeHistory);
//	    
//		return "addCard";
//		
//	} 
//	@RequestMapping(value = "/recharge", method = RequestMethod.POST)
//	public String recharge(@ModelAttribute ("card") Card card, Principal principal ) {
//		User user= userService.findByUsername(principal.getName());
//		rechargeService.recharge(user, card);
//		return "redirect:/";
//		
//	}
//	
//}
