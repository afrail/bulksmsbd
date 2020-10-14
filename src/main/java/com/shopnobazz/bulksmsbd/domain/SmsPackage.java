package com.shopnobazz.bulksmsbd.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SmsPackage {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id",nullable = false,updatable = false)
 private long id;
 private String packageName;
 private String price;
 private String quantity;
 private String packageType;
 private String validationDate;
public SmsPackage() {

}
public SmsPackage(long id, String packageName, String price, String quantity, String validationDate,String packageType) {
	this.id = id;
	this.packageName = packageName;
	this.price = price;
	this.quantity = quantity;
	this.validationDate = validationDate;
	this.packageType=packageType;
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
public String getPrice() {
	return price;
}
public void setPrice(String price) {
	this.price = price;
}
public String getQuantity() {
	return quantity;
}
public void setQuantity(String quantity) {
	this.quantity = quantity;
}
public String getValidationDate() {
	return validationDate;
}
public void setValidationDate(String validationDate) {
	this.validationDate = validationDate;
}
 

 
 
}
