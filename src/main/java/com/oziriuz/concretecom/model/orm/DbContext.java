package com.oziriuz.concretecom.model.orm;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

public interface DbContext<E> {
    boolean saveToDB(E entity) throws IllegalAccessException, SQLException;

    Iterable<E> find();

    Iterable<E> find(String where);

    E findFirst() throws SQLException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException;

    E findFirst(String where) throws SQLException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException;
}
