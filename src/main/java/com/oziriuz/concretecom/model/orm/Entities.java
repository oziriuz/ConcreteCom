package com.oziriuz.concretecom.model.orm;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

public class Entities {
    private static Set<Class> entitiesList;

    public static Set<Class> findAllClassesUsingClassLoader(String packageName) {
        InputStream stream = ClassLoader.getSystemClassLoader()
                .getResourceAsStream(packageName.replaceAll("[.]", "/"));
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        return reader.lines()
                .filter(line -> line.endsWith(".class"))
                .map(line -> getClass(line, packageName))
                .collect(Collectors.toSet());
    }

    private static Class getClass(String className, String packageName) {
        try {
            return Class.forName(packageName + "."
                    + className.substring(0, className.lastIndexOf('.')));
        } catch (ClassNotFoundException e) {
            //TODO: handle the exception
        }
        return null;
    }

    public static void initEntities() {
        entitiesList = findAllClassesUsingClassLoader("com.oziriuz.concretecom.model.entities");
    }

    public static Set<Class> getEntitiesList() {
        return Collections.unmodifiableSet(entitiesList);
    }
}
