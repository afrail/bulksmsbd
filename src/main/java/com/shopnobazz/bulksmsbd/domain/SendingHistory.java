package com.shopnobazz.bulksmsbd.domain;

import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.twilio.type.PhoneNumber;



@Entity
public class SendingHistory {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private long id;
  
private String SendNumber;
private String text;
private Date date;
@ManyToOne()
@JoinColumn(name="user_id")
private User user;

public SendingHistory(long id, String sendNumber, String text, Date date,User user) {
	this.id = id;
	SendNumber = sendNumber;
	this.text = text;
	this.date = date;
	this.user=user;
}
public SendingHistory() {
	
}

public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getSendNumber() {
	return SendNumber;
}
public void setSendNumber(String sendNumber) {
	SendNumber = sendNumber;
}
public String getText() {
	return text;
}
public void setText(String text) {
	this.text = text;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}



}
