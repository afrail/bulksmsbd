package com.shopnobazz.bulksmsbd.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shopnobazz.bulksmsbd.domain.Masking;
import com.shopnobazz.bulksmsbd.domain.NonMasking;
import com.shopnobazz.bulksmsbd.domain.User;
import com.shopnobazz.bulksmsbd.service.UserService;
import com.shopnobazz.bulksmsbd.service.WalletService;
import com.shopnobazz.bulksmsbd.smsSend.Service;
import com.shopnobazz.bulksmsbd.smsSend.SmsRequest;



@Controller
@RequestMapping(value="/api")
public class SendSmsController {
	@Autowired
	WalletService walletService;
	@Autowired
	UserService userService;
    private final Service service;
    @Autowired
    SendSmsController(Service service){
    	this.service=service;
    }

    @RequestMapping("/send")
    public String sendSms(SmsRequest smsRequest,Model model) {
    	model.addAttribute("smsRequest",smsRequest);
    	return "sms";
        
    }
    @RequestMapping(value="/send",method=RequestMethod.POST)
    public  String sms(SmsRequest smsRequest,Principal principal) {
    	User user = userService.findByUsername(principal.getName());
    	NonMasking nonMasking= walletService.nonMaskingms(walletService.findByUser(user));
    	service.sendSms(new SmsRequest( smsRequest.getPhoneNumber(),smsRequest.getMessage()),user,nonMasking);
    	return "sms";
    }
    
	
}
