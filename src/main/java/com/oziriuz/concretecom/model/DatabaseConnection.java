package com.oziriuz.concretecom.model;


import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    public Connection databaseLink;

    public Connection getConnection() {
        String databaseName = "postgres";
        String databaseUser = "postgres";
        String databasePassword = "1234";
        String url = "jdbc:postgresql://localhost/" + databaseName;

        try {
            Class.forName("org.postgresql.Driver");
            databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return databaseLink;
    }
}
