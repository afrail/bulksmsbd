package com.shopnobazz.bulksmsbd.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shopnobazz.bulksmsbd.smsSend.Service;
import com.shopnobazz.bulksmsbd.smsSend.SmsRequest;
@Controller
@RequestMapping(value="/api")
public class SendSmsController {
	@Autowired
     private  Service service;

	@RequestMapping("/send")
	public String sms(Model model,SmsRequest smsRequest) {
		model.addAttribute("smsRequest", smsRequest);
		return "sms";
	}

	@RequestMapping(value="/send",method = RequestMethod.POST)
    public void sendSms(SmsRequest smsRequest) {
        service.sendSms(smsRequest);
    }
	
	
}
