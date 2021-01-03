package com.shopnobazz.bulksmsbd.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.shopnobazz.bulksmsbd.Repository.ParchesHistoryRepository;
import com.shopnobazz.bulksmsbd.domain.ParchesHistory;
import com.shopnobazz.bulksmsbd.domain.SendingHistory;
import com.shopnobazz.bulksmsbd.domain.User;
import com.shopnobazz.bulksmsbd.service.ParchesService;
import com.shopnobazz.bulksmsbd.service.SendingHistoryService;
import com.shopnobazz.bulksmsbd.service.UserService;
import com.shopnobazz.bulksmsbd.serviceImplement.UserSecurityService;
import com.shopnobazz.bulksmsbd.utility.SecurityUtility;

@Controller
@RequestMapping(value="/user")
public class UserController {
@Autowired
UserService userService;
@Autowired
SendingHistoryService sendingHistoryService;
@Autowired
ParchesService parchesService;
@Autowired
UserSecurityService userSecurityService;
	
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
		model.addAttribute("user", user);
		return"sendingHistory";
	}
@RequestMapping("/updateUserInfo")
public String changePassword(Model model,Principal principal)
{
	User user=userService.findByUsername(principal.getName());
	model.addAttribute("user", user);
	return "changePassword";
	
}
	
	@RequestMapping(value="/updateUserInfo", method=RequestMethod.POST)
    public String updateUserInfo(
            @ModelAttribute("user") User user,
            @ModelAttribute("newPassword") String newPassword,
            Model model
    ) throws Exception {
        User currentUser = userService.findById(user.getId());

        if(currentUser == null) {
            throw new Exception ("User not found");
        }

//        check email already exists
        if(userService.findByEmail(user.getEmail()) != null) {
            if(userService.findByEmail(user.getEmail()).getId() != currentUser.getId()) {
                model.addAttribute("emailExists", true);
                return "myProfile";
            }
        }

//        check username already exists
        if(userService.findByUsername(user.getUsername()) != null) {
            if(userService.findByUsername(user.getUsername()).getId() !=currentUser.getId()) {
                model.addAttribute("usernameExists", true);
                return "myProfile";
            }
        }

//        update password
        if(newPassword != null && !newPassword.isEmpty() && !newPassword.equals("")) {
            BCryptPasswordEncoder passwordEncoder = SecurityUtility.passwordEncoder();
            String dbPassword = currentUser.getPassword();
            if(passwordEncoder.matches(user.getPassword(), dbPassword)) {
                currentUser.setPassword(passwordEncoder.encode(newPassword));
            } else {
                model.addAttribute("incorrectPassword", true);
                model.addAttribute("classActiveEdit", true);
                return "changePassword";
            }
        }

        userService.save(currentUser);

        model.addAttribute("updateSuccess", true);
        model.addAttribute("user", currentUser);
        model.addAttribute("classActiveEdit", true);
        model.addAttribute("listOfShippingAddresses", true);
        model.addAttribute("listOfCrecitCards", true);

        UserDetails userDetails = userSecurityService.loadUserByUsername(currentUser.getUsername());

        Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, userDetails.getPassword(), userDetails.getAuthorities());

        SecurityContextHolder.getContext().setAuthentication(authentication);

        

        return "changePassword";
    }
	
	
}
