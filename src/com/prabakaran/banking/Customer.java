package com.prabakaran.banking;

public class Customer {

	private int customerId;
	private String name;
	private String email;
	private String phnumber;
	
	
	 private Account account;
	public Account getAccount() {
		return account;
	}

	 public void setAccount(Account account) {
		 this.account = account;
	 }

	public Customer(int customerId, String name, String email, String phnumber) {
	    this.customerId = customerId;
	    this.name = name;
	    this.email = email;
	    this.phnumber = phnumber;
	    
	    
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhnumber() {
		return phnumber;
	}

	public void setPhnumber(String phnumber) {
		this.phnumber = phnumber;
	}
}
