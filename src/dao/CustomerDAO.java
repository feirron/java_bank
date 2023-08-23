package dao;

import model.Customer;
import dao.exceptions.CustomerDAOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDAO extends GenericDAO{

    public CustomerDAO(Connection connection) {

        super(connection);
    }

    public void insertCustomer(Customer customer) {
        String query = "INSERT INTO customers (name, address, phone_number, email) VALUES (?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, customer.getName());
            statement.setString(2, customer.getAddress());
            statement.setString(3, customer.getPhoneNumber());
            statement.setString(4, customer.getEmail());

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new CustomerDAOException("Error inserting customer", e);
        }
    }

    public int getCustomerIdByEmail(String email) {
        String query = "SELECT id FROM customers WHERE email = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, email);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt("id");
                }
            }
        } catch (SQLException e) {
            throw new CustomerDAOException("Error getting customer ID by email", e);
        }
        return 0;
    }

}
