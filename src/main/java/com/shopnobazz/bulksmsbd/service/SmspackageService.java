package com.shopnobazz.bulksmsbd.service;

import java.util.List;

import com.shopnobazz.bulksmsbd.domain.SmsPackage;

public interface SmspackageService {
	SmsPackage findOne(Long id);
	List <SmsPackage> findAll();
	SmsPackage Save(SmsPackage smsPackage);
	
	void removeOne(Long id);
}
