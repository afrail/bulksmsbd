package com.shopnobazz.bulksmsbd.serviceImplement;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopnobazz.bulksmsbd.Repository.MaskingRepository;
import com.shopnobazz.bulksmsbd.Repository.NonMaskingRepository;
import com.shopnobazz.bulksmsbd.Repository.ParchesHistoryRepository;
import com.shopnobazz.bulksmsbd.Repository.WalletRepository;
import com.shopnobazz.bulksmsbd.domain.Masking;
import com.shopnobazz.bulksmsbd.domain.NonMasking;
import com.shopnobazz.bulksmsbd.domain.ParchesHistory;
import com.shopnobazz.bulksmsbd.domain.SmsPackage;
import com.shopnobazz.bulksmsbd.domain.User;
import com.shopnobazz.bulksmsbd.domain.Wallet;
import com.shopnobazz.bulksmsbd.service.ParchesService;
import com.shopnobazz.bulksmsbd.service.SmspackageService;
import com.shopnobazz.bulksmsbd.service.WalletService;

@Service
public class ParchesServiceImpl implements ParchesService{
@Autowired 
WalletService walletService;
@Autowired
WalletRepository walletRepository;
@Autowired
SmspackageService smspackageService;
@Autowired
ParchesHistoryRepository parchesHistoryRepository;
@Autowired
MaskingRepository maskingRepository;
@Autowired
NonMaskingRepository nonMaskingRepository;


	@Override
	public Wallet checkBalance(User user,Long id) {
		Wallet wallet = walletService.findByUser(user);
		SmsPackage smsPackage = smspackageService.findOne(id);
		Date parchesDate = new Date();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, smsPackage.getValidationDate());
		if(wallet.getBalance() >= smsPackage.getPrice()) {
			
			
			if(smsPackage.getPackageType().matches("masking")) {
				ParchesHistory paHistory = new ParchesHistory();
				paHistory.setSms(smsPackage.getQuantity());
				paHistory.setTotal(smsPackage.getPrice());
				paHistory.setDate(parchesDate);
				paHistory.setUser(user);
				paHistory.setSmsPackage(smsPackage);
				parchesHistoryRepository.save(paHistory);
				Masking masking=maskingRepository.findByWallet(wallet);
				int sms=masking.getMaskSms()+smsPackage.getQuantity();
				
				masking.setMaskDate(cal.getTime());
				masking.setMaskSms(sms);
				maskingRepository.save(masking);
				double ballance= wallet.getBalance()-smsPackage.getPrice();
				wallet.setBalance(ballance);
				walletRepository.save(wallet);
				return wallet;
			}
			else {
				ParchesHistory paHistory = new ParchesHistory();
				paHistory.setSms(smsPackage.getQuantity());
				paHistory.setTotal(smsPackage.getPrice());
				paHistory.setDate(parchesDate);
				paHistory.setUser(user);
				paHistory.setSmsPackage(smsPackage);
				parchesHistoryRepository.save(paHistory);
				NonMasking nonMasking=nonMaskingRepository.findByWallet(wallet);
				int sms=nonMasking.getNonMaskSms()+smsPackage.getQuantity();
				wallet.setNonMasking(nonMasking);
				nonMasking.setNonMaskDate(cal.getTime());
				nonMasking.setNonMaskSms(sms);
				nonMaskingRepository.save(nonMasking);
				double ballance= wallet.getBalance()-smsPackage.getPrice();
				wallet.setBalance(ballance);
				walletRepository.save(wallet);
				return wallet;
			}
			
		
		}
		
		return null;
		
	}


	@Override
	public List<ParchesHistory> findByUser(User user) {
		List<ParchesHistory> historyList = parchesHistoryRepository.findByUser(user);
		List<ParchesHistory> history = new ArrayList<>();
		for(ParchesHistory parchesHistory : historyList) {
			history.add(parchesHistory);
		}
	
		
		return history;
	}


}
