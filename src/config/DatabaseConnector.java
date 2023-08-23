package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
    private static final String URL = "jdbc:h2:~/bank";
    private static final String USERNAME = "davi_silva";
    private static final String PASSWORD = "12345";

    private Connection connection;

    public DatabaseConnector() {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Connected to database");
        } catch (SQLException e) {
            System.err.println("Error connecting to the database: " + e.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Connection closed");
            } catch (SQLException e) {
                System.err.println("Error closing the database connection: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        DatabaseConnector dbConnector = new DatabaseConnector();

        // Use the connection for database operations
        // ...

        dbConnector.closeConnection();
    }
}
