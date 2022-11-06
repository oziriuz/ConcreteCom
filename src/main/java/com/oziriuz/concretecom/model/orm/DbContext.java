package com.oziriuz.concretecom.model.orm;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

public interface DbContext<E> {
    void ensureTable() throws SQLException;

    boolean saveEntity(E entity) throws IllegalAccessException, SQLException;

    E FindOneEntity(E entity, long...id)
            throws IllegalAccessException, SQLException, NoSuchMethodException,
            InvocationTargetException, InstantiationException;

    Iterable<E> find();

    Iterable<E> find(String where);

    E findFirst() throws SQLException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException;

    E findFirst(String where) throws SQLException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException;
}
