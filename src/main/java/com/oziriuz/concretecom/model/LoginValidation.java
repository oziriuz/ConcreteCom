package com.oziriuz.concretecom.model;

import java.sql.*;

public class LoginValidation {
    public static boolean isValidLogin(String username, String password) {
        //TODO: table names and columns must not be hard-coded here
        //TODO: password must be encoded
        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement =
                    connection.prepareStatement("SELECT COUNT(1) FROM oper_data WHERE o_name = ? AND o_pass = ?");
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                if (rs.getInt(1) == 1) {
                    connection.close();
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
