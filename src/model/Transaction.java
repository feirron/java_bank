package model;

import model.Account;

public class Transaction {
    private int transactionId;
    private Account account;
    private double amount;
    private String description;

    // Constructor
    public Transaction(int transactionId, Account account, double amount, String description) {
        this.transactionId = transactionId;
        this.account = account;
        this.amount = amount;
        this.description = description;
    }

    // Getter methods
    public int getTransactionId() {
        return transactionId;
    }

    public Account getAccount() {
        return account;
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

}
