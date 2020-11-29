package com.shopnobazz.bulksmsbd.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class SmsPackage {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id",nullable = false,updatable = false)
 private long id;
 private String packageName;
 private double price;
 private int quantity;
 private String packageType;
 private int validationDate;
 @OneToMany(mappedBy = "smsPackage")
 @JsonIgnore
 private List<ParchesHistory> parchesHistory;
 
public SmsPackage() {

}
public SmsPackage(long id, String packageName, double price, int quantity, int validationDate,String packageType,List<ParchesHistory> parchesHistory) {
	this.id = id;
	this.packageName = packageName;
	this.price = price;
	this.quantity = quantity;
	this.validationDate = validationDate;
	this.packageType=packageType;
	this.parchesHistory=parchesHistory;
}



public List<ParchesHistory> getParchesHistory() {
	return parchesHistory;
}
public void setParchesHistory(List<ParchesHistory> parchesHistory) {
	this.parchesHistory = parchesHistory;
}
public String getPackageType() {
	return packageType;
}
public void setPackageType(String packageType) {
	this.packageType = packageType;
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getPackageName() {
	return packageName;
}
public void setPackageName(String packageName) {
	this.packageName = packageName;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public int getValidationDate() {
	return validationDate;
}
public void setValidationDate(int validationDate) {
	this.validationDate = validationDate;
}
 

 
 
}
