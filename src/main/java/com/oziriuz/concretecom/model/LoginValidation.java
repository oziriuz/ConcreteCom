package com.oziriuz.concretecom.model;

import com.oziriuz.concretecom.model.entities.Operator;
import com.oziriuz.concretecom.model.orm.DatabaseConnection;
import com.oziriuz.concretecom.model.orm.DbContext;
import com.oziriuz.concretecom.model.orm.EntityManager;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;

public class LoginValidation {
    public static boolean isValidLogin(long id, String password) {
        //TODO: password must be encoded
        Operator operator = new Operator(id, password);

        try (Connection connection = DatabaseConnection.getConnection()) {

            DbContext<Operator> operatorDbContext = new EntityManager<>(connection, Operator.class);

            Operator toLogIn = operatorDbContext.FindOneEntity(operator, id);

            if (toLogIn != null) {
                return true;
            }

        } catch (SQLException e) {
            //TODO: proper exception handling
            e.printStackTrace();
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException |
                 NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
}
