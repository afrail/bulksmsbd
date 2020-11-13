package com.shopnobazz.bulksmsbd.service;

import java.util.List;

import com.shopnobazz.bulksmsbd.domain.ParchesHistory;
import com.shopnobazz.bulksmsbd.domain.User;
import com.shopnobazz.bulksmsbd.domain.Wallet;

public interface ParchesService {
	public Wallet checkBalance(User user, Long id);
	public List<ParchesHistory> findByUser(User user);
	
	

}
