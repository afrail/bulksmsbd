package com.shopnobazz.bulksmsbd.service;

import java.util.List;

import com.shopnobazz.bulksmsbd.domain.RechargeHistory;
import com.shopnobazz.bulksmsbd.domain.SendingHistory;
import com.shopnobazz.bulksmsbd.domain.User;
import com.twilio.type.PhoneNumber;


public interface SendingHistoryService {
public SendingHistory save(String sendNumber,String text,User user);
List<SendingHistory> findAll(User user);
}
