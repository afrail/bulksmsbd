package com.shopnobazz.bulksmsbd.domain;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Wallet {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;
private double balance;
@OneToOne(cascade = CascadeType.ALL)
private User user;

@OneToOne(cascade = CascadeType.ALL,mappedBy = "wallet",fetch = FetchType.LAZY)
private Masking masking;
 
@OneToOne(cascade = CascadeType.ALL,mappedBy = "wallet",fetch = FetchType.LAZY)
private NonMasking nonMasking;

public Wallet(Long id, double balance, User user, Masking masking, NonMasking nonMasking) {
	this.id = id;
	this.balance = balance;
	this.user = user;
	this.masking = masking;
	this.nonMasking = nonMasking;
}
public Wallet() {
	
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public double getBalance() {
	return balance;
}
public void setBalance(double balance) {
	this.balance = balance;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
public Masking getMasking() {
	return masking;
}
public void setMasking(Masking masking) {
	this.masking = masking;
}
public NonMasking getNonMasking() {
	return nonMasking;
}
public void setNonMasking(NonMasking nonMasking) {
	this.nonMasking = nonMasking;
}




}
