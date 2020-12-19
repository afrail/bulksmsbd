package com.shopnobazz.bulksmsbd.smsSend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.shopnobazz.bulksmsbd.domain.NonMasking;
import com.shopnobazz.bulksmsbd.domain.User;

@org.springframework.stereotype.Service
public class Service {
   
    private final SmsSender smsSender;

     @Autowired
    public Service(@Qualifier("twilio") TwilioSmsSender smsSender) {
        this.smsSender = smsSender;
    }

     
    public void sendSms(SmsRequest smsRequest,User user,NonMasking nonMasking) {
        smsSender.sendSms(smsRequest,user,nonMasking);
    }
}
