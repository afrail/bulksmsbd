package com.shopnobazz.bulksmsbd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.shopnobazz.bulksmsbd.domain.Masking;
import com.shopnobazz.bulksmsbd.domain.SmsPackage;
import com.shopnobazz.bulksmsbd.domain.User;
import com.shopnobazz.bulksmsbd.service.SmspackageService;
import com.shopnobazz.bulksmsbd.service.UserService;



@Controller
@RequestMapping(value="/package")
public class SmsPackageController {
	@Autowired
	SmspackageService smspackageService;
    @Autowired
    UserService userService;
	
@RequestMapping("/add")
  public String smsPackage(Model model)
  {
	SmsPackage smsPackage=new SmsPackage();
	model.addAttribute("smsPackage",smsPackage);
	return "smsPackage";
	  
  }
@RequestMapping(value="/add",method = RequestMethod.POST)
public String addsmsPackage(
@ModelAttribute("smsPackage") SmsPackage smsPackage)
{
	
	smspackageService.Save(smsPackage);
	return "redirect:allsms";
}

@RequestMapping("/allsms")
public String allSms(Model model)
{
	List<SmsPackage> smsPackage = smspackageService.findAll();
	model.addAttribute("smsPackage",smsPackage);
	return "allSmspackage";
	
}
@RequestMapping("/del")
public String delete(@RequestParam("id")  Long id) {
	smspackageService.removeOne(id);
	return "redirect:allsms";
}
@RequestMapping("/edit")
public String edit(@RequestParam("id")  Long id,Model model) {
	SmsPackage smsPackage;
	smsPackage=smspackageService.findOne(id);
	model.addAttribute("smsPackage",smsPackage);
	return "smsPackage";
}

@RequestMapping("/user")
public String user(Model model) {
	List<User> allUser = userService.allUser();
	model.addAttribute("allUser",allUser);
	return"userinfo";
}


}
