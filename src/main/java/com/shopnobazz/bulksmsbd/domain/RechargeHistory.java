package com.shopnobazz.bulksmsbd.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class RechargeHistory {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private long id;
private double amount;
private Date date;
@ManyToOne()
@JoinColumn(name="user_id")
private User user;
@OneToOne(cascade = CascadeType.ALL)
private Card card;
public RechargeHistory(long id, double amount, Date date, User user, Card card) {
	
	this.id = id;
	this.amount = amount;
	this.date = date;
	this.user = user;
	this.card = card;
}
public RechargeHistory() {
	
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public double getAmount() {
	return amount;
}
public void setAmount(double amount) {
	this.amount = amount;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
public Card getCard() {
	return card;
}
public void setCard(Card card) {
	this.card = card;
}


}
