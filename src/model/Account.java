package model;

public class Account {
    private int accountNumber;
    private Customer customer;
    private double balance;

    // Constructor
    public Account( Customer customer) {
        this.customer = customer;
        this.balance = 0.0;
    }

    public Account(int accountNumber, Customer customer) {
        this(customer);
        this.customer = customer;
        this.balance = 0.0;
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit of $" + amount + " successful.");
        }
    }

    // Withdraw method
    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawal of $" + amount + " successful.");
        } else {
            System.out.println("Insufficient funds for withdrawal.");
        }
    }

    // Getter methods
    public int getAccountNumber() {
        return accountNumber;
    }

    public Customer getCustomer() {
        return customer;
    }

    public double getBalance() {
        return balance;
    }
}
