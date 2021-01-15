package com.shopnobazz.bulksmsbd.smsSend;

import com.shopnobazz.bulksmsbd.cofigaretion.TwilioConfiguration;
import com.shopnobazz.bulksmsbd.domain.NonMasking;
import com.shopnobazz.bulksmsbd.domain.User;
import com.shopnobazz.bulksmsbd.service.SendingHistoryService;
import com.shopnobazz.bulksmsbd.service.WalletService;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;

import javax.validation.ValidationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("twilio")
public class TwilioSmsSender implements SmsSender {
	@Autowired
	WalletService walletService;	
 @Autowired
 SendingHistoryService SendingHistoryService;
    private static final Logger LOGGER = LoggerFactory.getLogger(TwilioSmsSender.class);

    private final TwilioConfiguration twilioConfiguration;

    @Autowired
    public TwilioSmsSender(TwilioConfiguration twilioConfiguration) {
        this.twilioConfiguration = twilioConfiguration;
    }

    @Override
    public void sendSms(SmsRequest smsRequest,User user,NonMasking nonMasking) {
    	
    	if(smsRequest.getPhoneNumber().contains(",")) {
    	String[]  phoneNumberArray = smsRequest.getPhoneNumber().split(",");
    	for(String phoneNumber : phoneNumberArray)
    	{
    	 	System.err.println("Phone No is valid: "+isPhoneNumberValid(phoneNumber));
    	    
    	    if (isPhoneNumberValid(phoneNumber)) {
    	    	try {
    	    		if(nonMasking.getNonMaskSms()>=1) {
					 PhoneNumber to = new PhoneNumber("+88"+phoneNumber);
                PhoneNumber from = new PhoneNumber(twilioConfiguration.getTrialNumber());
                String message = smsRequest.getMessage();
                MessageCreator creator = Message.creator(to, from, message);
                creator.create();
                LOGGER.info("Send sms {}", smsRequest);
                String to1 =String.valueOf(to);
                SendingHistoryService.save(to1, message, user);
                nonMasking.setNonMaskSms(nonMasking.getNonMaskSms()-1);
                walletService.save(nonMasking);
                
    	    		}
				} 
    	    		catch (Exception e) {
					// TODO: handle exception
				}
               
            } else {
                throw new ValidationException("Phone Number is  not valid");     
                }
    	}
    	}else {
        if (isPhoneNumberValid(smsRequest.getPhoneNumber())) {
        	try {
            PhoneNumber to = new PhoneNumber("+88"+smsRequest.getPhoneNumber());
            PhoneNumber from = new PhoneNumber(twilioConfiguration.getTrialNumber());
            String message = smsRequest.getMessage();
            MessageCreator creator = Message.creator(to, from, message);
            creator.create();
            LOGGER.info("Send sms {}", smsRequest);
            String to1 =String.valueOf(to);
            SendingHistoryService.save(to1, message, user);
            nonMasking.setNonMaskSms(nonMasking.getNonMaskSms()-1);
            walletService.save(nonMasking);
        	}
        	catch(Exception e) {
        		
        	}
        } else {
            throw new ValidationException("Phone Number is  not valid");     
            }
    	}
    }

    private boolean isPhoneNumberValid(String phoneNumber) {
    	System.out.println("================================"+phoneNumber.length());
        if(phoneNumber.length() == 11)
        {
        	  if(phoneNumber.substring(0,3).equals("019") 
        			  || phoneNumber.substring(0,3).equals("018")
        			  || phoneNumber.substring(0,3).equals("017")
        			  || phoneNumber.substring(0,3).equals("016")
        			  || phoneNumber.substring(0,3).equals("015")
        			  || phoneNumber.substring(0,3).equals("013")
        			  || phoneNumber.substring(0,3).equals("014"))
              {
        		  return true;
              }else
              {
            	  return false;
              }
        	
        }
      
        else {
        	return false;
        }
    }
}
