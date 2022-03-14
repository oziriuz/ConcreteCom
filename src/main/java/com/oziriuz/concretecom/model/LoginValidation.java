package com.oziriuz.concretecom.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginValidation {

    public static boolean isValidLogin(String username, String password) {
        DatabaseConnection connection = new DatabaseConnection();
        Connection connectDB = connection.getConnection();

        //TODO: this method must not connect to DB
        //TODO: table names and columns must not be hard-coded here
        //TODO: this string must be passed to the method or not??
        //TODO: all sql string must be stored somewhere in one place
        //TODO: password must be encoded
        String verifyLogin = "SELECT count(1) FROM oper_data WHERE o_name = '" + username
                + "' AND o_pass = '" + password + "'";

        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);

            while (queryResult.next()) {
                if (queryResult.getInt(1) == 1) {
                    connectDB.close();
                    return true;
                }
            }
        } catch (SQLException e) {
            //TODO: proper exception handling
            e.printStackTrace();
        }
        return false;
    }
}
