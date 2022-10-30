package com.oziriuz.concretecom.model.orm;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {
    private static Connection connection;
    private static final String connectionString = "jdbc:postgresql://localhost/";

    private DatabaseConnection() {
    }

    private static void createConnection() throws SQLException {
        Properties properties = new Properties();
        properties.setProperty("user", "postgres");
        properties.setProperty("password", "1234");
        String databaseName = "postgres";

        connection = DriverManager.getConnection(connectionString + databaseName, properties);
    }

    public static Connection getConnection() throws SQLException {
        if (connection == null) {
            createConnection();
        }
        return connection;
    }
}
