package com.shopnobazz.bulksmsbd.controller;

import java.security.Principal;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.access.event.PublicInvocationEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shopnobazz.bulksmsbd.Repository.PasswordResetTokenRepository;
import com.shopnobazz.bulksmsbd.Repository.UserRepository;
import com.shopnobazz.bulksmsbd.domain.Masking;
import com.shopnobazz.bulksmsbd.domain.NonMasking;
import com.shopnobazz.bulksmsbd.domain.User;
import com.shopnobazz.bulksmsbd.domain.Wallet;
import com.shopnobazz.bulksmsbd.domainsecurity.PasswordResetToken;
import com.shopnobazz.bulksmsbd.domainsecurity.Role;
import com.shopnobazz.bulksmsbd.domainsecurity.UserRole;
import com.shopnobazz.bulksmsbd.service.UserService;
import com.shopnobazz.bulksmsbd.service.WalletService;
import com.shopnobazz.bulksmsbd.utility.MailConstructor;
import com.shopnobazz.bulksmsbd.utility.SecurityUtility;
@Controller
public class HomeController {

	@Autowired
	PasswordResetTokenRepository passwordResetTokenRepository;
	
	@Autowired
    private JavaMailSender mailSender;
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private MailConstructor mailConstructor;

    @Autowired
    private UserService userService;
    @Autowired
    private WalletService walletService; 

    

    
    @RequestMapping(value="/login", method = RequestMethod.GET)
    public ModelAndView displayRegistration(ModelAndView modelAndView, User user)
    {
        modelAndView.addObject("user", user);
        modelAndView.setViewName("login");
        return modelAndView;
    }
 
   @RequestMapping("/")
   public String dashbord(Model model,Principal principal){
	   User user =userService.findByUsername(principal.getName());
	   Wallet wallet = walletService.findByUser(user);
	   Masking masking = walletService.maskingSms(wallet);
	   NonMasking nonMasking= walletService.nonMaskingms(wallet);
	   model.addAttribute("wallet",wallet );
	   model.addAttribute("masking",masking );
	   model.addAttribute("nonmasking",nonMasking);
	   model.addAttribute("user",user);
	   
	 
	   return "index";
   }
    
@RequestMapping("/registration")
public String newUser(Model model) {
	User user=new User();
	model.addAttribute("user", user);
	return "registration";
}

	  @RequestMapping(value = "/register", method = RequestMethod.POST)
	    public String newUserPost(
	            HttpServletRequest request,
	            //@ModelAttribute("email") String userEmail,
	            @ModelAttribute("user") User user,
	            Model model
	    ) throws Exception {
	      
	        if(userService.findByUsername(user.getUsername()) != null) {
	            model.addAttribute("usernameExists", true);

	            return "registration";
	        }
	        model.addAttribute("classActiveNewAccount", true);
	        model.addAttribute("email", user.getEmail());
	        model.addAttribute("username", user.getUsername());


	        if(userService.findByEmail(user.getEmail()) != null) {
	            model.addAttribute("emailExists", true);

	            return "registration";
	        }

	        User user1 = new User();
	        user1.setUsername(user.getUsername());
	        user1.setEmail(user.getEmail());
	        user1.setFirstName(user.getFirstName());
	        user1.setLastName(user.getLastName());
	        user1.setPhone(user.getPhone());
	        user1.setEnabled(false);
	        String password = user.getPassword();
	        String encryptedPassword =SecurityUtility.passwordEncoder().encode(password); 
	        user1.setPassword(encryptedPassword);
	        Role role = new Role();
	        role.setRoleId(1);
	        role.setName("ROLE_USER");
	        Set<UserRole> userRoles = new HashSet<>();
	        userRoles.add(new UserRole(user1, role));
	        userService.createUser(user1, userRoles);

	        String token = UUID.randomUUID().toString();
	        userService.createPasswordResetTokenForUser(user1, token);
           
	        String appUrl = "http://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();


	        SimpleMailMessage email = mailConstructor.constructResetTokenEmail(appUrl, request.getLocale(),  user,password,encryptedPassword,token);

	        mailSender.send(email);

	        model.addAttribute("emailSent", "true");
	        

	       
	        return "login";
	    }
	  @RequestMapping(value="/confirm-account", method= {RequestMethod.GET})
	    public String confirmUserAccount(Model model, @RequestParam("token")String confirmationToken)
	    {
		  PasswordResetToken token = passwordResetTokenRepository.findByToken(confirmationToken);

	        if(token != null)
	        {
	            User user = userRepository.findByEmail(token.getUser().getEmail());
	            user.setEnabled(true);
	            userRepository.save(user);
	           model.addAttribute("accountVerified", true);
	           model.addAttribute("user",user);
	            return "login";
	           // modelAndView.setViewName("accountVerified",true);
	        }
	        else
	        {
	           // modelAndView.addObject("message","The link is invalid or broken!");
	            //modelAndView.setViewName(" accountVerifi faild ");
	        }

	        return "login";
	    } 
	  
	  
	 
	
}
