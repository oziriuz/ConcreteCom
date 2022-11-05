package com.oziriuz.concretecom.model.orm;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseManager {
    public static void ensureDatabase() throws SQLException {
        Connection connection = DatabaseConnection.getConnection();

        Entities.initEntities();

        for (Class entity : Entities.getEntitiesList()) {
            EntityManager<Class> entityManager = new EntityManager<Class>(connection, entity);
            entityManager.ensureTable();
        }

        //Do not close connection!
    }
}
