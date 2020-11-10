package com.shopnobazz.bulksmsbd.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class PackageParchesHistory {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sms_package_id")
	private SmsPackage smsPackage;

	@ManyToOne()
	@JoinColumn()
	private ParchesHistory parchesHistory;

	public PackageParchesHistory(SmsPackage smsPackage, ParchesHistory parchesHistory) {

		this.smsPackage = smsPackage;
		this.parchesHistory = parchesHistory;
	}

	public PackageParchesHistory() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public SmsPackage getSmsPackage() {
		return smsPackage;
	}

	public void setSmsPackage(SmsPackage smsPackage) {
		this.smsPackage = smsPackage;
	}

	public ParchesHistory getParchesHistory() {
		return parchesHistory;
	}

	public void setParchesHistory(ParchesHistory parchesHistory) {
		this.parchesHistory = parchesHistory;
	}

}
