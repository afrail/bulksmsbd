package com.shopnobazz.bulksmsbd.serviceImplement;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopnobazz.bulksmsbd.Repository.SendingHistoryRepositry;
import com.shopnobazz.bulksmsbd.domain.SendingHistory;
import com.shopnobazz.bulksmsbd.domain.User;
import com.shopnobazz.bulksmsbd.service.SendingHistoryService;


@Service
public class SendingHistoryServiceImpl implements SendingHistoryService{
@Autowired
SendingHistoryRepositry sendingHistoryRepositry;
	Date date = new Date();
	 

	@Override
	public SendingHistory save(String sendNumber, String text, User user) {
		SendingHistory sendingHistory = new SendingHistory();
		sendingHistory.setSendNumber(sendNumber);
		sendingHistory.setText(text);
		sendingHistory.setUser(user);
		sendingHistory.setDate(date);
		
		return sendingHistoryRepositry.save(sendingHistory);
		
	}


	@Override
	public List<SendingHistory> findAll(User user) {

		List<SendingHistory> sms =  sendingHistoryRepositry.findByUser(user);
		List<SendingHistory> packageList = new ArrayList<>();
		for(SendingHistory sendingHistory:sms)
		{
			packageList.add(sendingHistory);
			
		}
		return packageList;
		
		
	}

}
