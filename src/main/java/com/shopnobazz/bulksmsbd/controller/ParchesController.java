package com.shopnobazz.bulksmsbd.controller;

import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.shopnobazz.bulksmsbd.domain.Masking;
import com.shopnobazz.bulksmsbd.domain.NonMasking;
import com.shopnobazz.bulksmsbd.domain.User;
import com.shopnobazz.bulksmsbd.domain.Wallet;
import com.shopnobazz.bulksmsbd.service.ParchesService;
import com.shopnobazz.bulksmsbd.service.UserService;
import com.shopnobazz.bulksmsbd.service.WalletService;

@Controller

@RequestMapping(value="/parches")
public class ParchesController {
	@Autowired
	UserService userService;
	@Autowired
	ParchesService parchesService;
	@Autowired
	WalletService walletService;
	
	
  @RequestMapping("/buy")
  public String buyPackage(@RequestParam("id") Long id,Model model,Principal principal)
  {
	  
	  
	User user=userService.findByUsername(principal.getName());
	parchesService.checkBalance(user, id);
	
	 Wallet wallet = walletService.findByUser(user);
	   Masking masking = walletService.maskingSms(wallet);
	   NonMasking nonMasking= walletService.nonMaskingms(wallet);
	   model.addAttribute("wallet",wallet );
	   model.addAttribute("masking",masking );
	   model.addAttribute("nonmasking",nonMasking);
	   model.addAttribute("user",user);
	   
	 
	   return "index";
  }
  
  
  
}
