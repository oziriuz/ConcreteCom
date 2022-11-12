package com.oziriuz.concretecom.model.orm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {
    private static Connection connection;

    private static final String connectionString = DatabaseConstants.CONNECTION_STRING;
    private static final String user = DatabaseConstants.DATABASE_USER;
    private static final String password = DatabaseConstants.DATABASE_PASSWORD;
    private static final String databaseName = DatabaseConstants.DATABASE_NAME;

    private DatabaseConnection() {
    }

    private static void createConnection() throws SQLException {
        Properties properties = new Properties();
        properties.setProperty("user", user);
        properties.setProperty("password", password);

        connection = DriverManager.getConnection(connectionString + databaseName, properties);
    }

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            createConnection();
        }

        return connection;
    }
}
