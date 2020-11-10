package com.shopnobazz.bulksmsbd.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class NonMasking {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;
private String nonMaskSms;
@OneToOne(cascade = CascadeType.ALL)
private Wallet wallet;
public NonMasking(Long id, String nonMaskSms, Wallet wallet) {
	this.id = id;
	this.nonMaskSms = nonMaskSms;
	this.wallet = wallet;
}

public NonMasking() {
	
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getNonMaskSms() {
	return nonMaskSms;
}

public void setNonMaskSms(String nonMaskSms) {
	this.nonMaskSms = nonMaskSms;
}

public Wallet getWallet() {
	return wallet;
}

public void setWallet(Wallet wallet) {
	this.wallet = wallet;
}


}
