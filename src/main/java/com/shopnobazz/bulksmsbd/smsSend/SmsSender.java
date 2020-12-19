package com.shopnobazz.bulksmsbd.smsSend;

import com.shopnobazz.bulksmsbd.domain.NonMasking;
import com.shopnobazz.bulksmsbd.domain.User;

public interface SmsSender {

    void sendSms(SmsRequest smsRequest,User user,NonMasking nonMasking);

    // or maybe void sendSms(String phoneNumber, String message);
}
