package com.prabakaran.banking;

import java.util.ArrayList;

public class bank {

    private ArrayList<Customer> customers;

    public bank() {
        customers = new ArrayList<>();
    }

    public void addCustomer(Customer customer) {

        if (findCustomer(customer.getCustomerId()) != null) {
            System.out.println("Customer ID already exists.");
            return;
        }

        if (customer.getAccount() != null &&
                isAccountNumberExists(customer.getAccount().getAccountnumber())) {

            System.out.println("Account number already exists.");
            return;
        }

        customers.add(customer);

        System.out.println("Customer added successfully.");
    }
    
    public Customer findCustomer(int customerId) {

        for (Customer customer : customers) {

            if (customer.getCustomerId() == customerId) {
                return customer;
            }
        }

        return null;
    }
    public boolean isAccountNumberExists(String accountNumber) {

        for (Customer customer : customers) {

            if (customer.getAccount() != null &&
                    customer.getAccount().getAccountnumber().equals(accountNumber)) {

                return true;
            }
        }

        return false;
    }
    
    public Account findAccount(String accountNumber) {

        for (Customer customer : customers) {

            if (customer.getAccount() != null &&
                    customer.getAccount().getAccountnumber().equals(accountNumber)) {

                return customer.getAccount();
            }
        }

        return null;
    }
    public void displayAllCustomers() {

        if (customers.isEmpty()) {
            System.out.println("No customers available.");
            return;
        }

        for (Customer customer : customers) {

            System.out.println("--------------------");
            System.out.println("Customer ID: " + customer.getCustomerId());
            System.out.println("Name: " + customer.getName());
            System.out.println("Email: " + customer.getEmail());
            System.out.println("Phone: " + customer.getPhnumber());

            if (customer.getAccount() != null) {
                System.out.println("Account Number: "
                        + customer.getAccount().getAccountnumber());
                System.out.println("Balance: "
                        + customer.getAccount().getBalance());
                System.out.println("Account Type: "
                        + customer.getAccount().getAccounttype());
            }
        }

        System.out.println("--------------------");
    }
}