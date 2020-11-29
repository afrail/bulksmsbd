package com.shopnobazz.bulksmsbd.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ParchesHistory {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;
private double total;
private Date date;
private int sms;
@ManyToOne()
@JoinColumn(name="user_id")
private User user;

@ManyToOne()
@JoinColumn(name = "sms_package_id")
private SmsPackage smsPackage;

public ParchesHistory(Long id, double total, Date date, int sms, User user,
		SmsPackage smsPackage) {
	this.id = id;
	this.total = total;
	this.date = date;
	this.sms = sms;
	this.user = user;
	this.smsPackage = smsPackage;
}
public ParchesHistory() {
	
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public double getTotal() {
	return total;
}
public void setTotal(double total) {
	this.total = total;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
public int getSms() {
	return sms;
}
public void setSms(int sms) {
	this.sms = sms;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
public SmsPackage getSmsPackage() {
	return smsPackage;
}
public void setSmsPackage(SmsPackage smsPackage) {
	this.smsPackage = smsPackage;
}




}
