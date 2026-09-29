package com.prabakaran.banking;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        bank bank = new bank();

        Customer customer1 = new Customer(
                101, "Prabakaran", "prabakaran@gmail.com", "9876543210");

        Account account1 = new Account("ACC1001", 5000, "Savings");
        customer1.setAccount(account1);
        bank.addCustomer(customer1);

        Customer customer2 = new Customer(
                102, "Rahul", "rahul@gmail.com", "9876543211");

        Account account2 = new Account("ACC1002", 3000, "Savings");
        customer2.setAccount(account2);
        bank.addCustomer(customer2);

        int choice;

        do {
            System.out.println("\n===== BANKING MANAGEMENT SYSTEM =====");
            System.out.println("1. View All Customers");
            System.out.println("2. Search Customer");
            System.out.println("3. Check Balance");
            System.out.println("4. Deposit Money");
            System.out.println("5. Withdraw Money");
            System.out.println("6. Transfer Money");
            System.out.println("7. Transaction History");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            if (sc.hasNextInt()) {
                choice = sc.nextInt();
            } else {
                System.out.println("Invalid input. Please enter a number.");
                sc.next();
                choice = 0;
            }

            switch (choice) {

                case 1:
                    System.out.println("\nAll Customers:");
                    bank.displayAllCustomers();
                    break;

               
                case 2:
                    System.out.print("Enter Customer ID: ");
                    if (!sc.hasNextInt()) {
                        System.out.println("Invalid customer ID. Please enter a number.");
                        sc.next();
                        break;
                    }

                    int customerId = sc.nextInt();

                    Customer foundCustomer = bank.findCustomer(customerId);

                    if (foundCustomer != null) {
                        System.out.println("\nCustomer Found!");
                        System.out.println("Customer ID: " + foundCustomer.getCustomerId());
                        System.out.println("Name: " + foundCustomer.getName());
                        System.out.println("Email: " + foundCustomer.getEmail());
                        System.out.println("Phone: " + foundCustomer.getPhnumber());

                        if (foundCustomer.getAccount() != null) {
                            System.out.println("Account Number: "
                                    + foundCustomer.getAccount().getAccountnumber());
                            System.out.println("Balance: "
                                    + foundCustomer.getAccount().getBalance());
                        }

                    } else {
                        System.out.println("Customer not found.");
                    }

                    break;

                case 3:
                    System.out.print("Enter Account Number: ");
                    String accountNumber = sc.next().trim();

                    if (accountNumber.isEmpty()) {
                        System.out.println("Account number cannot be empty.");
                        break;
                    }

                    Account foundAccount = bank.findAccount(accountNumber);

                    if (foundAccount != null) {
                        System.out.println("Account Number: "
                                + foundAccount.getAccountnumber());
                        System.out.println("Current Balance: "
                                + foundAccount.getBalance());
                    } else {
                        System.out.println("Account not found.");
                    }

                    break;

                case 4:
                    System.out.print("Enter Account Number: ");
                    String depositAccountNumber = sc.next();

                    Account depositAccount = bank.findAccount(depositAccountNumber);

                    if (depositAccount != null) {

                    	System.out.print("Enter amount: ");

                    	if (!sc.hasNextDouble()) {
                    	    System.out.println("Invalid amount. Please enter a number.");
                    	    sc.next();
                    	    break;
                    	}

                    	double depositAmount = sc.nextDouble();

                        depositAccount.deposit(depositAmount);

                        System.out.println("Updated Balance: " + depositAccount.getBalance());

                    } else {
                        System.out.println("Account not found.");
                    }

                    break;

                case 5:
                    System.out.print("Enter Account Number: ");
                    String withdrawAccountNumber = sc.next();

                    Account withdrawAccount = bank.findAccount(withdrawAccountNumber);

                    if (withdrawAccount != null) {

                        System.out.print("Enter Withdrawal Amount: ");
                        double withdrawAmount = sc.nextDouble();

                        withdrawAccount.withdraw(withdrawAmount);

                        System.out.println("Updated Balance: "
                                + withdrawAccount.getBalance());

                    } else {
                        System.out.println("Account not found.");
                    }

                    break;

                case 6:
                    System.out.print("Enter Sender Account Number: ");
                    String senderAccountNumber = sc.next();

                    Account senderAccount = bank.findAccount(senderAccountNumber);

                    if (senderAccount != null) {

                        System.out.print("Enter Receiver Account Number: ");
                        String receiverAccountNumber = sc.next();

                        Account receiverAccount = bank.findAccount(receiverAccountNumber);
                        
                        if (senderAccount == null) {
                            System.out.println("Sender account not found.");
                            break;
                        }

                        if (receiverAccount != null) {

                            System.out.print("Enter Transfer Amount: ");
                            double transferAmount = sc.nextDouble();

                            senderAccount.transfer(receiverAccount, transferAmount);
                            
                            if (senderAccount == null) {
                                System.out.println("Sender account not found.");
                                break;
                            }

                            System.out.println("Sender Balance: "
                                    + senderAccount.getBalance());

                            System.out.println("Receiver Balance: "
                                    + receiverAccount.getBalance());

                        } else {
                            System.out.println("Receiver account not found.");
                        }

                    } else {
                        System.out.println("Sender account not found.");
                    }

                    break;

                case 7:
                    System.out.print("Enter Account Number: ");
                    String historyAccountNumber = sc.next();

                    Account historyAccount = bank.findAccount(historyAccountNumber);

                    if (historyAccount != null) {

                        System.out.println("\nTransaction History:");
                        historyAccount.displayTransactions();

                    } else {
                        System.out.println("Account not found.");
                    }

                    break;

                case 8:
                    System.out.println("Thank you for using our Banking System.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 8);

        sc.close();
    }
}