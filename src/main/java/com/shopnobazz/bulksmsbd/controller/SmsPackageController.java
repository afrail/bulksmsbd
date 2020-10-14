package com.shopnobazz.bulksmsbd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shopnobazz.bulksmsbd.domain.SmsPackage;
import com.shopnobazz.bulksmsbd.service.SmspackageService;



@Controller
@RequestMapping(value="/package")
public class SmsPackageController {
	@Autowired
	SmspackageService smspackageService;
	
@RequestMapping("/add")
  public String smsPackage(Model model)
  {
	SmsPackage smsPackage=new SmsPackage();
	model.addAttribute("smsPackage",smsPackage);
	return "addSmspackage";
	  
  }
@RequestMapping(value="/add",method = RequestMethod.POST)
public String addsmsPackage(Model model,@ModelAttribute("smsPackage") SmsPackage smsPackage)
{
	
	smspackageService.Save(smsPackage);
	return "addSmspackage";
}

@RequestMapping("/allsms")
public String allSms(Model model)
{
	List<SmsPackage> smsPackage = smspackageService.findAll();
	model.addAttribute("smsPackage",smsPackage);
	return "allSmspackage";
	
}

}
