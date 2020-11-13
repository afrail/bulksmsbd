package com.shopnobazz.bulksmsbd.domain;

import java.util.Date;

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
private int nonMaskSms;
private Date nonMaskDate;
@OneToOne(cascade = CascadeType.ALL)
private Wallet wallet;
public NonMasking(Long id, int nonMaskSms, Wallet wallet,Date nonMaskDate) {
	this.id = id;
	this.nonMaskSms = nonMaskSms;
	this.wallet = wallet;
	this.nonMaskDate=nonMaskDate;
}

public NonMasking() {
	
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public int getNonMaskSms() {
	return nonMaskSms;
}

public void setNonMaskSms(int nonMaskSms) {
	this.nonMaskSms = nonMaskSms;
}

public Wallet getWallet() {
	return wallet;
}

public void setWallet(Wallet wallet) {
	this.wallet = wallet;
}

public Date getNonMaskDate() {
	return nonMaskDate;
}

public void setNonMaskDate(Date nonMaskDate) {
	this.nonMaskDate = nonMaskDate;
}




}
