package com.shopnobazz.bulksmsbd.domain;

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
private String total;
private String date;
private String sms;
@ManyToOne()
@JoinColumn(name="user_id")
private User user;

@OneToMany(mappedBy = "parchesHistory",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
private List<PackageParchesHistory> packageParchesHistoryList;

public ParchesHistory(Long id, String total, String date, String sms, User user,
		List<PackageParchesHistory> packageParchesHistoryList) {
	this.id = id;
	this.total = total;
	this.date = date;
	this.sms = sms;
	this.user = user;
	this.packageParchesHistoryList = packageParchesHistoryList;
}
public ParchesHistory() {
	
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getTotal() {
	return total;
}
public void setTotal(String total) {
	this.total = total;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
public String getSms() {
	return sms;
}
public void setSms(String sms) {
	this.sms = sms;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
public List<PackageParchesHistory> getPackageParchesHistory() {
	return packageParchesHistoryList;
}
public void setPackageParchesHistory(List<PackageParchesHistory> packageParchesHistoryList) {
	this.packageParchesHistoryList = packageParchesHistoryList;
}



}
