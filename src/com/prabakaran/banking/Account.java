package com.prabakaran.banking;
import java.util.ArrayList;

public class Account {
	
	private String accountnumber;
	private double balance;
	private String accounttype;
	private int transactionCounter = 1;
	
	private ArrayList<transaction> transactions;
	
	public Account(String accountNumber, double balance, String accountType) {

	    this.accountnumber = accountNumber;

	    if (balance < 0) {
	        this.balance = 0;
	        System.out.println("Opening balance cannot be negative. Balance set to zero.");
	    } else {
	        this.balance = balance;
	    }

	    this.accounttype = accountType;
	    this.transactions = new ArrayList<>();
	}
	
	public void addTransaction(transaction transaction) {
	    transactions.add(transaction);
	}

	public String getAccountnumber() {
		return accountnumber;
	}

	public void setAccountnumber(String accountnumber) {
		this.accountnumber = accountnumber;
	}

	public double getBalance() {
		return balance;
	}

	public String getAccounttype() {
		return accounttype;
	}

	public void setAccounttype(String accounttype) {
		this.accounttype = accounttype;
	}
	
	public void deposit(double amount) {

	    if (amount <= 0) {
	        System.out.println("Deposit amount must be greater than zero.");
	        return;
	    }

	    balance = balance + amount;

	    transaction transaction = new transaction(
	            "T" + (transactions.size() + 1),
	            "DEPOSIT",
	            amount,
	            "Money deposited");

	    addTransaction(transaction);

	    System.out.println("Amount deposited successfully.");
	}
	
	
	public void withdraw(double amount) {

	    if (amount <= 0) {
	        System.out.println("Withdrawal amount must be greater than zero.");
	        return;
	    }

	    if (amount > balance) {
	        System.out.println("Insufficient balance.");
	        return;
	    }

	    balance = balance - amount;

	    transaction transaction = new transaction(
	            "T" + (transactions.size() + 1),
	            "WITHDRAW",
	            amount,
	            "Money withdrawn");

	    addTransaction(transaction);

	    System.out.println("Amount withdrawn successfully.");
	}
	
	
//	public void transfer(Account receiverAccount, double amount) {
//
//	    if (receiverAccount == null) {
//	        System.out.println("Receiver account not found.");
//	        return;
//	    }
//
//	    if (amount <= 0) {
//	        System.out.println("Transfer amount must be greater than zero.");
//	        return;
//	    }
//
//	    if (amount > balance) {
//	        System.out.println("Insufficient balance.");
//	        return;
//	    }
//
//	    balance = balance - amount;
//	    receiverAccount.balance = receiverAccount.balance + amount;
//
//	    System.out.println("Money transferred successfully.");
//	    
//	    
//	}

	public void displayTransactions() {

	    if (transactions.isEmpty()) {
	        System.out.println("No transactions available.");
	        return;
	    }

	    for (transaction transaction : transactions) {
	        System.out.println("--------------------");
	        System.out.println("Transaction ID: " + transaction.getTransactionid());
	        System.out.println("Type: " + transaction.getTransactiontype());
	        System.out.println("Amount: " + transaction.getAmount());
	        System.out.println("Description: " + transaction.getDescription());
	    }

	    System.out.println("--------------------");
	}
	
	public void transfer(Account receiverAccount, double amount) {
		
		if (this == receiverAccount) {
		    System.out.println("Cannot transfer to the same account.");
		    return;
		}

	    if (receiverAccount == null) {
	        System.out.println("Receiver account not found.");
	        return;
	    }

	    if (receiverAccount == this) {
	        System.out.println("Cannot transfer to the same account.");
	        return;
	    }

	    if (amount <= 0) {
	        System.out.println("Transfer amount must be greater than zero.");
	        return;
	    }

	    if (amount > balance) {
	        System.out.println("Insufficient balance.");
	        return;
	    }

	    balance = balance - amount;
	    receiverAccount.balance = receiverAccount.balance + amount;

	    transaction senderTransaction = new transaction(
	            "T" + (transactions.size() + 1),
	            "TRANSFER SENT",
	            amount,
	            "Money transferred to " + receiverAccount.getAccountnumber());

	    addTransaction(senderTransaction);

	    transaction receiverTransaction = new transaction(
	            "T" + (receiverAccount.transactions.size() + 1),
	            "TRANSFER RECEIVED",
	            amount,
	            "Money received from " + accountnumber);

	    receiverAccount.addTransaction(receiverTransaction);

	    System.out.println("Money transferred successfully.");
	}


}
