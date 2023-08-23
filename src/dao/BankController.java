package dao;

import model.Customer;
import model.Account;
import model.Transaction;


import java.sql.Connection;

public class BankController {
    private AccountDAO accountDAO;
    private CustomerDAO customerDAO;
    private TransactionDAO transactionDAO;

    public BankController(Connection connection) {
        accountDAO = new AccountDAO(connection);
        customerDAO = new CustomerDAO(connection);
        transactionDAO = new TransactionDAO(connection);
    }

    // Methods to interact with DAOs
    public void createCustomer(Customer customer) {

        customerDAO.insertCustomer(customer);
        customerDAO.spitOutAllTableRows("customers");
    }

    public void createAccount(Account account) {
        // Retrieve the generated ID from the customer
        int customerId = customerDAO.getCustomerIdByEmail(account.getCustomer().getEmail());
        Customer internalCustomer = new Customer(
                customerId,
                account.getCustomer().getName(),
                account.getCustomer().getAddress(),
                account.getCustomer().getPhoneNumber(),
                account.getCustomer().getEmail()
        );
        // Set the retrieved ID and create the account
        Account internalAccount = new Account(internalCustomer);
        accountDAO.createAccount(internalAccount);
        accountDAO.spitOutAllTableRows("accounts");
    }

    public void recordTransaction(Transaction transaction) {
        transactionDAO.recordTransaction(transaction);
    }

    // Other methods...

    // Close DAO connections
    public void close() {
        accountDAO.close();
        customerDAO.close();
        transactionDAO.close();
    }
}
