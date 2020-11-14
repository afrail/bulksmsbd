package com.shopnobazz.bulksmsbd.smsSend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@org.springframework.stereotype.Service
public class Service {
    @Autowired
    private SmsSender smsSender;

    
//    public Service(@Qualifier("twilio") TwilioSmsSender smsSender) {
//        this.smsSender = smsSender;
//    }

    public void sendSms(SmsRequest smsRequest) {
        smsSender.sendSms(smsRequest);
    }
}
