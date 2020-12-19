package com.shopnobazz.bulksmsbd.serviceImplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopnobazz.bulksmsbd.Repository.MaskingRepository;
import com.shopnobazz.bulksmsbd.Repository.NonMaskingRepository;
import com.shopnobazz.bulksmsbd.Repository.WalletRepository;
import com.shopnobazz.bulksmsbd.domain.Masking;
import com.shopnobazz.bulksmsbd.domain.NonMasking;
import com.shopnobazz.bulksmsbd.domain.User;
import com.shopnobazz.bulksmsbd.domain.Wallet;
import com.shopnobazz.bulksmsbd.service.WalletService;
@Service
public class WalletServiceImpl implements WalletService{
@Autowired
WalletRepository walletRepository;
@Autowired
MaskingRepository maskingRepository;
@Autowired
NonMaskingRepository nonMaskingRepository;

	@Override
	public Masking maskingSms(Wallet wallet) {
		
		return maskingRepository.findByWallet(wallet);
	}

	@Override
	public NonMasking nonMaskingms(Wallet wallet) {
		
		return nonMaskingRepository.findByWallet(wallet);
	}

	@Override
	public Wallet findByUser (User user) {
		
		return walletRepository.findByUser(user);
	}

	@Override
	public void save(NonMasking nonMaskingms) {
		nonMaskingRepository.save(nonMaskingms);
		
	}


}
