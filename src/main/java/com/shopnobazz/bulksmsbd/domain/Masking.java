package com.shopnobazz.bulksmsbd.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Masking {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;
private String maskSms;
@OneToOne(cascade =CascadeType.ALL )
private Wallet wallet;
public Masking(Long id, String maskSms, Wallet wallet) {
	this.id = id;
	this.maskSms = maskSms;
	this.wallet = wallet;
}
public Masking()
{
	
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getMaskSms() {
	return maskSms;
}
public void setMaskSms(String maskSms) {
	this.maskSms = maskSms;
}
public Wallet getWallet() {
	return wallet;
}
public void setWallet(Wallet wallet) {
	this.wallet = wallet;
}


}
