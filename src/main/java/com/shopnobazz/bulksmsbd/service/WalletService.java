package com.shopnobazz.bulksmsbd.service;

import com.shopnobazz.bulksmsbd.domain.Masking;
import com.shopnobazz.bulksmsbd.domain.NonMasking;
import com.shopnobazz.bulksmsbd.domain.User;
import com.shopnobazz.bulksmsbd.domain.Wallet;

public interface WalletService {
  
	Masking maskingSms(Wallet wallet);
	NonMasking nonMaskingms(Wallet wallet);
	Wallet findByUser(User user);
    void save(NonMasking nonMaskingms);
}
