package dao;

import model.Transaction;

import java.sql.Connection;

public class TransactionDAO extends GenericDAO {

    public TransactionDAO(Connection connection) {
        super(connection);
    }

    public void recordTransaction(Transaction transaction) {
        // Implement the method to insert a new transaction into the database
    }

//    public List<Transaction> getTransactionHistory(int accountNumber) {
//        // Implement the method to retrieve transaction history for an account
//    }

    // Other transaction-related methods...
}
