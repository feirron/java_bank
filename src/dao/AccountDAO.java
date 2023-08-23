package dao;

import model.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class AccountDAO extends GenericDAO{

    public AccountDAO(Connection connection) {
        super(connection);
    }

    public void createAccount(Account account) {

        String insertQuery = "INSERT INTO accounts (customer_id, balance) VALUES (?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            preparedStatement.setInt(1, account.getCustomer().getId());
            preparedStatement.setDouble(2, account.getBalance());

            preparedStatement.executeUpdate();
            System.out.println("model.Account created: " + account.getAccountNumber());
        } catch (SQLException e) {
            System.err.println("Error creating account: " + e.getMessage());
        }
    }

}
