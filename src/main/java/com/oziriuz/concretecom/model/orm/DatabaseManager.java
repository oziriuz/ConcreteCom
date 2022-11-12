package com.oziriuz.concretecom.model.orm;

import com.oziriuz.concretecom.model.ModelConstants;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Set;
import java.util.stream.Collectors;

public class DatabaseManager {

    private static final String packageName = ModelConstants.PATH_TO_ENTITIES;

    public static void ensureDatabase() throws SQLException {
        Connection connection = DatabaseConnection.getConnection();

        Set<Class> classSet = getAllClassesFromPackage();

        for (Class entity : classSet) {
            DbContext<Class> context = new EntityManager<Class>(connection, entity);
            context.ensureTable();
        }

        connection.close();
    }

    private static Set<Class> getAllClassesFromPackage() {
        InputStream stream = ClassLoader.getSystemClassLoader()
                .getResourceAsStream(packageName.replaceAll("[.]", "/"));

        assert stream != null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        return reader.lines()
                .filter(line -> line.endsWith(".class"))
                .map(DatabaseManager::removeExtension)
                .map(DatabaseManager::addPath)
                .map(DatabaseManager::getClass)
                .collect(Collectors.toSet());
    }

    private static String addPath(String className) {
        return packageName + "." + className;
    }

    private static String removeExtension(String className) {
        return className.substring(0, className.lastIndexOf('.'));
    }

    private static Class getClass(String className) {
        try {
            return Class.forName(className);
        } catch (ClassNotFoundException e) {
            //TODO: handle the exception
            e.printStackTrace();
        }
        return null;
    }
}
