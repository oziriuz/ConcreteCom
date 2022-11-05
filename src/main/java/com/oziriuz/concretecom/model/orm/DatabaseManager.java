package com.oziriuz.concretecom.model.orm;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Set;
import java.util.stream.Collectors;

public class DatabaseManager {

    private static final String PACKAGE_NAME = "com.oziriuz.concretecom.model.entities";

    public static void ensureDatabase() throws SQLException {
        Connection connection = DatabaseConnection.getConnection();

        Set<Class> entitiesList = findAllClassesInPackage();

        for (Class entity : entitiesList) {
            EntityManager<Class> entityManager = new EntityManager<Class>(connection, entity);
            entityManager.ensureTable();
        }

        //Do not close connection!
    }

    private static Set<Class> findAllClassesInPackage() {
        InputStream stream = ClassLoader.getSystemClassLoader()
                .getResourceAsStream(PACKAGE_NAME.replaceAll("[.]", "/"));
        assert stream != null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        return reader.lines()
                .filter(line -> line.endsWith(".class"))
                .map(DatabaseManager::getClass)
                .collect(Collectors.toSet());
    }

    private static Class getClass(String className) {
        try {
            return Class.forName(PACKAGE_NAME + "."
                    + className.substring(0, className.lastIndexOf('.')));
        } catch (ClassNotFoundException e) {
            //TODO: handle the exception
            e.printStackTrace();
        }
        return null;
    }
}
