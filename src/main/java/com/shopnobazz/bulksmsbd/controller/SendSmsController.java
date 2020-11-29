package com.shopnobazz.bulksmsbd.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shopnobazz.bulksmsbd.smsSend.Service;
import com.shopnobazz.bulksmsbd.smsSend.SmsRequest;



@Controller
@RequestMapping(value="/api")
public class SendSmsController {
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
    public  String sms(SmsRequest smsRequest) {
    	service.sendSms(new SmsRequest( smsRequest.getPhoneNumber(),smsRequest.getMessage()));
    	return "sms";
    }
    
	
}
