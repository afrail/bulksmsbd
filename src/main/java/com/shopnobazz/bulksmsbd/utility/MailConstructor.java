package com.shopnobazz.bulksmsbd.utility;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

import com.shopnobazz.bulksmsbd.domain.User;
@Component
public class MailConstructor {

	  @Autowired
	    private Environment env;


	    public SimpleMailMessage constructResetTokenEmail(
	            String contextPath, Locale locale, User user, String password,String encryptedPassword,
	    String token) {
	       String url = contextPath+"/confirm-account?token="+token;
	        String message = "\nPlease click on this link to verify your email and edit your personal information. Your password is: \n"+password+"\n";
	        SimpleMailMessage email = new SimpleMailMessage();
	        email.setTo(user.getEmail());
	        email.setSubject("Le's Shopnobaz Bulk sms - New User");
	        email.setText(url+message);
	        email.setFrom(env.getProperty("support.email"));
	        return email;
	    }
	
}
