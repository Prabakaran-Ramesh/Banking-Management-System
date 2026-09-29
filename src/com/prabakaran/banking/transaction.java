package com.prabakaran.banking;

public class transaction {

	private String transactionid;
	private String transactiontype;
	private double amount;
	private String description;
	public transaction(String transactionid, String transactiontype, double amount, String description) {
		super();
		this.transactionid = transactionid;
		this.transactiontype = transactiontype;
		this.amount = amount;
		this.description = description;
	}
	public String getTransactionid() {
		return transactionid;
	}
	public void setTransactionid(String transactionid) {
		this.transactionid = transactionid;
	}
	public String getTransactiontype() {
		return transactiontype;
	}
	public void setTransactiontype(String transactiontype) {
		this.transactiontype = transactiontype;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
