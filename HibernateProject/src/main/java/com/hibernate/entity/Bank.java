package com.hibernate.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Bank {
	
	private String bankName;
	private String bankLocation;
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBankLocation() {
		return bankLocation;
	}
	public void setBankLocation(String bankLocation) {
		this.bankLocation = bankLocation;
	}
	public Bank(String bankName, String bankLocation) {
		super();
		this.bankName = bankName;
		this.bankLocation = bankLocation;
	}
	public Bank() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
