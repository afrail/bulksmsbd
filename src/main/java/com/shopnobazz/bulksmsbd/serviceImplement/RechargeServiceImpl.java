package com.shopnobazz.bulksmsbd.serviceImplement;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopnobazz.bulksmsbd.Repository.CardRepository;
import com.shopnobazz.bulksmsbd.Repository.RechargehistoryRepository;
import com.shopnobazz.bulksmsbd.Repository.WalletRepository;
import com.shopnobazz.bulksmsbd.domain.Card;
import com.shopnobazz.bulksmsbd.domain.RechargeHistory;
import com.shopnobazz.bulksmsbd.domain.SmsPackage;
import com.shopnobazz.bulksmsbd.domain.User;
import com.shopnobazz.bulksmsbd.domain.Wallet;
import com.shopnobazz.bulksmsbd.service.RechargeService;
import com.shopnobazz.bulksmsbd.service.UserService;
import com.shopnobazz.bulksmsbd.service.WalletService;
@Service
public class RechargeServiceImpl implements RechargeService{
	@Autowired
	UserService userService;
	@Autowired
	RechargehistoryRepository rechargehistoryRepository;
	@Autowired
	WalletService walletService;
	@Autowired
	WalletRepository walletRepository;
	@Autowired
	CardRepository cardRepository;
	@Override
	public String recharge(User user, Card card) {
		RechargeHistory rechargeHistory1 = new RechargeHistory();
		Card card1 = new Card();
		card1.setAmount(card.getAmount());
		card1.setCardNumber(card.getCardNumber());
		card1.setCbn(card.getCbn());
		card1.setMonth(card.getMonth());
		card1.setYear(card.getYear());
		card1.setRechargeHistory(rechargeHistory1);
		rechargeHistory1.setAmount(card.getAmount());
		rechargeHistory1.setCard(card1);
		rechargeHistory1.setUser(user);
		Date date = new Date();
		rechargeHistory1.setDate(date);
		rechargehistoryRepository.save(rechargeHistory1);
		cardRepository.save(card1);
		Wallet balance=ballance(user);
		double amount =balance.getBalance()+card.getAmount();
		balance.setBalance(amount);
		balance.setUser(user);
		walletRepository.save(balance);
		
		return null;
	}
	Wallet ballance(User user) {
		Wallet wallet =walletService.findByUser(user);
		
		return wallet;
		
	}
	@Override
	public List<RechargeHistory> findAll( User user) {
		List<RechargeHistory> sms = (List<RechargeHistory>) rechargehistoryRepository.findByUser(user);
		List<RechargeHistory> packageList = new ArrayList<>();
		for(RechargeHistory rechargeHistory:sms)
		{
			packageList.add(rechargeHistory);
			
		}
		return packageList;
	}

}
