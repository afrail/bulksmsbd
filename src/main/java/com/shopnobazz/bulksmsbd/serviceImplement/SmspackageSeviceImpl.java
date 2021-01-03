package com.shopnobazz.bulksmsbd.serviceImplement;

import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.filters.AddDefaultCharsetFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopnobazz.bulksmsbd.Repository.SmsPackageRepository;
import com.shopnobazz.bulksmsbd.domain.SmsPackage;
import com.shopnobazz.bulksmsbd.service.SmspackageService;
@Service
public class SmspackageSeviceImpl implements SmspackageService{
@Autowired
SmsPackageRepository smsPackageRepository;
	



	@Override
	public SmsPackage Save(SmsPackage smsPackage) {
		
		return smsPackageRepository.save(smsPackage);
	}


	@Override
	public SmsPackage findOne(Long id) {
		// TODO Auto-generated method stub
		return smsPackageRepository.findById(id).get();
	}

	@Override
	public List<SmsPackage> findAll() {
		List<SmsPackage> sms = (List<SmsPackage>) smsPackageRepository.findAll();
		List<SmsPackage> packageList = new ArrayList<>();
		for(SmsPackage smsPackage:sms)
		{
			packageList.add(smsPackage);
			
		}
		return packageList;
	}




	@Override
	public void removeOne(Long id) {
		smsPackageRepository.deleteById(id);
		
	}

	

}
