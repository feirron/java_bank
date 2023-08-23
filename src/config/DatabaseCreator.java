package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseCreator {
    private static final String URL = "jdbc:h2:~/bank";
    private static final String USERNAME = "davi_silva";
    private static final String PASSWORD = "12345";
    private static final String DATABASE_NAME = "bank";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            System.out.println("Connected to MySQL");

            Statement statement = connection.createStatement();
//            String createDatabaseSQL = "CREATE DATABASE IF NOT EXISTS " + DATABASE_NAME;
//            statement.executeUpdate(createDatabaseSQL);

            String createTableSQL = "CREATE TABLE IF NOT EXISTS customers ( " +
                    "id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "name VARCHAR(255)," +
                    "address VARCHAR(255)," +
                    "phone_number VARCHAR(255)," +
                    "email VARCHAR(255))";
            statement.executeUpdate(createTableSQL);

            createTableSQL = "CREATE TABLE IF NOT EXISTS accounts (" +
                    "account_number INT AUTO_INCREMENT PRIMARY KEY," +
                    "customer_id INT," +
                    "balance DECIMAL(10, 2))";
            statement.executeUpdate(createTableSQL);

            createTableSQL = "CREATE TABLE IF NOT EXISTS transactions (" +
                    "transaction_id INT AUTO_INCREMENT PRIMARY KEY," +
                    "account_number INT," +
                    "transaction_type VARCHAR(255)," +
                    "amount DECIMAL(10, 2))";
            statement.executeUpdate(createTableSQL);


            System.out.println("Database created: " + DATABASE_NAME);
        } catch (SQLException e) {
            System.err.println("Error creating database: " + e.getMessage());
        }
    }
}