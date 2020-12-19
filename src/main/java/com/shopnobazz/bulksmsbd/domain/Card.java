package com.shopnobazz.bulksmsbd.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Card {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private long id;
private String cardNumber;
private String month;
private String year;
private String cbn;
private double amount;
@OneToOne(cascade = CascadeType.ALL)
private RechargeHistory rechargeHistory;
public Card(long id, String cardNumber, String month, String year, String cbn, double amount,
		RechargeHistory rechargeHistory) {
	
	this.id = id;
	this.cardNumber = cardNumber;
	this.month = month;
	this.year = year;
	this.cbn = cbn;
	this.amount = amount;
	this.rechargeHistory = rechargeHistory;
}
public Card() {
	
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getCardNumber() {
	return cardNumber;
}
public void setCardNumber(String cardNumber) {
	this.cardNumber = cardNumber;
}
public String getMonth() {
	return month;
}
public void setMonth(String month) {
	this.month = month;
}
public String getYear() {
	return year;
}
public void setYear(String year) {
	this.year = year;
}
public String getCbn() {
	return cbn;
}
public void setCbn(String cbn) {
	this.cbn = cbn;
}
public double getAmount() {
	return amount;
}
public void setAmount(double amount) {
	this.amount = amount;
}
public RechargeHistory getRechargeHistory() {
	return rechargeHistory;
}
public void setRechargeHistory(RechargeHistory rechargeHistory) {
	this.rechargeHistory = rechargeHistory;
}


}
