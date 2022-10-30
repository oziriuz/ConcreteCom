package com.oziriuz.concretecom.model;

import com.oziriuz.concretecom.model.entities.Operator;
import com.oziriuz.concretecom.model.orm.DatabaseConnection;
import com.oziriuz.concretecom.model.orm.EntityManager;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;

public class LoginValidation {
    public static boolean isValidLogin(String username, String password) {
        //TODO: table names and columns must not be hard-coded here
        //TODO: password must be encoded
        try {
            Connection connection = DatabaseConnection.getConnection();
            EntityManager<Operator> operatorEntityManager = new EntityManager<>(connection, Operator.class);
            Operator operator = new Operator(username, password);
            Operator toLogIn = operatorEntityManager.FindEntityInTable(operator);

            if (toLogIn != null) {
                connection.close();
                return true;
            }
        } catch (SQLException e) {
            //TODO: proper exception handling
            e.printStackTrace();
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
}
