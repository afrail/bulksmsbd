package com.shopnobazz.bulksmsbd.service;

import java.util.List;

import com.shopnobazz.bulksmsbd.domain.SendingHistory;
import com.shopnobazz.bulksmsbd.domain.User;



public interface SendingHistoryService {
public SendingHistory save(String sendNumber,String text,User user);
List<SendingHistory> findAll(User user);
}
