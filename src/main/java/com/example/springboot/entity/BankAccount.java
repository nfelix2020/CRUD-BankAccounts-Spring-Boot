package com.example.springboot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BankAccounts")
public class BankAccount {
	
	  @Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	  private long id;
	  
	  @Column(name = "FullName")
	  private String ownerFullName;
	  
	  @Column(name = "Email")
	  private String ownerEmail;
	  
	  @Column(name = " Phone")
	  private String ownerPhone;
	  
	  @Column(name = "AccountNumber")
	  private String accountNumber;
	  
	  
	  @Column(name = "BankName")
	  private String bankName;
	  
	  @Column(name = "ZipCode")
	  private int zipCode;
	  
	  @Column(name = "Country")
	  private String country;
	  
	  @Column(name = "TotalAmount")
	  private int totalAmount;
	  

	//Empty Constructor 
	public BankAccount() {
		 
	}

	//Constructor with fields
	public BankAccount(String ownerFullName, String ownerEmail, String ownerPhone, String accountNumber,
			String bankName, int zipCode, String country, int totalAmount) {
		super();
		this.ownerFullName = ownerFullName;
		this.ownerEmail = ownerEmail;
		this.ownerPhone = ownerPhone;
		this.accountNumber = accountNumber;
		this.bankName = bankName;
		this.zipCode = zipCode;
		this.country = country;
		this.totalAmount = totalAmount;
	}


	//Getters and Setters
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getOwnerFullName() {
		return ownerFullName;
	}


	public void setOwnerFullName(String ownerFullName) {
		this.ownerFullName = ownerFullName;
	}


	public String getOwnerEmail() {
		return ownerEmail;
	}


	public void setOwnerEmail(String ownerEmail) {
		this.ownerEmail = ownerEmail;
	}


	public String getOwnerPhone() {
		return ownerPhone;
	}


	public void setOwnerPhone(String ownerPhone) {
		this.ownerPhone = ownerPhone;
	}


	public String getAccountNumber() {
		return accountNumber;
	}


	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}


	public String getBankName() {
		return bankName;
	}


	public void setBankName(String bankName) {
		this.bankName = bankName;
	}


	public int getZipCode() {
		return zipCode;
	}


	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public int getTotalAmount() {
		return totalAmount;
	}


	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}
	  
}
