package com.oziriuz.concretecom.model.orm;

import com.oziriuz.concretecom.model.annotations.Column;
import com.oziriuz.concretecom.model.annotations.Id;
import com.oziriuz.concretecom.model.annotations.Table;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class EntityManager<E> implements DbContext<E> {
    private final Connection connection;
    private final Class<E> clazz;
    private final String tableName;


    public EntityManager(Connection connection, Class<E> clazz) {
        this.connection = connection;
        this.clazz = clazz;
        this.tableName = getTableName();
    }

    @Override
    public boolean persist(E entity) throws IllegalAccessException, SQLException {
        Field idColumn = getIdColumn();
        idColumn.setAccessible(true);
        Object idValue = idColumn.get(entity);

        if (idValue == null || (int) idValue <= 0) {
            return doInsert(entity, idColumn);
        }

        return doUpdate(entity, idColumn);
    }

    private boolean doUpdate(E entity, Field idColumn) {
        return false;
    }

    private boolean doInsert(E entity, Field idColumn) throws SQLException, IllegalAccessException {
        String tableFields = String.join(", ", getColumnsWithoutId());
        String tableValues = String.join(", ", getValuesWithoutId(entity));
//TODO: refactor with ??? in statement
        String insertQuery = String.format("INSERT INTO %s (%s) VALUES (%s)", tableName, tableFields, tableValues);

        return connection.prepareStatement(insertQuery).execute();
    }

    private List<String> getColumnsWithoutId() {
        return Arrays.stream(clazz.getDeclaredFields())
                .filter(f -> !f.isAnnotationPresent(Id.class))
                .filter((f -> f.isAnnotationPresent(Column.class)))
                .map(f -> f.getAnnotationsByType(Column.class))
                .map(a -> a[0].value())
                .collect(Collectors.toList());
    }

    private List<String> getValuesWithoutId(E entity) throws IllegalAccessException {
        List<Field> fields = Arrays.stream(clazz.getDeclaredFields())
                .filter(f -> !f.isAnnotationPresent(Id.class))
                .filter((f -> f.isAnnotationPresent(Column.class)))
                .collect(Collectors.toList());

        List<String> values = new ArrayList<>();
        for (Field field : fields) {
            field.setAccessible(true);
            Object o = field.get(entity);
            if (o instanceof String || o instanceof LocalDate) {
                values.add("'" + o + "'");
            } else {
                values.add(o.toString());
            }
        }

        return values;
    }

    private String getTableName() {
        Table[] annotationsByType = clazz.getAnnotationsByType(Table.class);

        if (annotationsByType.length == 0) {
            throw new UnsupportedOperationException("Class must be Table");
        }
        return annotationsByType[0].value();
    }

    @Override
    public Iterable<E> find() {
        return null;
    }

    @Override
    public Iterable<E> find(String where) {
        return null;
    }

    @Override
    public E findFirst() throws SQLException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        return findFirst(null);
    }

    @Override
    public E findFirst(String where) throws SQLException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        List<E> result = baseFind(where, "LIMIT 1");

        return result.get(0);
    }

    public E FindEntityInTable(E entity) throws IllegalAccessException, SQLException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        List<String> tableFields = getColumnsWithoutId();
        List<String> tableValues = getValuesWithoutId(entity);
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM ")
                .append(tableName)
                .append(" ")
                .append("WHERE");

        for (int i = 0; i < tableFields.size(); i++) {
            sb.append(" ")
                    .append(tableFields.get(i))
                    .append(" = ")
                    .append(tableValues.get(i));
            if (i < tableFields.size() - 1) {
                sb.append(" AND");
            }
        }

        sb.append(" LIMIT 1");

        String selectQuery = sb.toString();
        PreparedStatement statement = connection.prepareStatement(selectQuery);
        ResultSet resultSet = statement.executeQuery();
        List<E> result = new ArrayList<>();
        while (resultSet.next()) {
            E newEntity = clazz.getDeclaredConstructor().newInstance();
            fillEntity(resultSet, newEntity);
            result.add(newEntity);
        }
        if (result.size() > 0) {
            return result.get(0);
        }

        return null;
    }

    private List<E> baseFind(String where, String limit) throws SQLException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        String selectQuery = String.format("SELECT * FROM %s %s %s",
                tableName,
                where != null ? "WHERE " + where : "",
                limit != null ? limit : "");

        PreparedStatement statement = connection.prepareStatement(selectQuery);
        ResultSet resultSet = statement.executeQuery();

        List<E> result = new ArrayList<>();
        while (resultSet.next()) {
            E entity = clazz.getDeclaredConstructor().newInstance();
            fillEntity(resultSet, entity);

            result.add(entity);
        }

        return result;
    }

    private void fillEntity(ResultSet resultSet, E entity) throws SQLException, IllegalAccessException {
        Field[] declaredFields = clazz.getDeclaredFields();

        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true);
            fillField(declaredField, resultSet, entity);
        }
    }

    private void fillField(Field declaredField, ResultSet resultSet, E entity) throws SQLException, IllegalAccessException {
        Class<?> fieldType = declaredField.getType();
        String fieldName = getSQLColumnName(declaredField);

        if (fieldType == int.class || fieldType == Integer.class) {
            int value = resultSet.getInt(fieldName);

            declaredField.set(entity, value);
        } else if (fieldType == long.class || fieldType == Long.class) {
            long value = resultSet.getLong(fieldName);

            declaredField.set(entity, value);
        } else if (fieldType == LocalDate.class) {
            LocalDate value = LocalDate.parse(resultSet.getString(fieldName));

            declaredField.set(entity, value);
        } else {
            String value = resultSet.getString(fieldName);

            declaredField.set(entity, value);
        }
    }

    private String getSQLColumnName(Field idColumn) {
        return idColumn.getAnnotationsByType(Column.class)[0].value();
    }

    private Field getIdColumn() {
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            boolean annotationPresent = declaredField.isAnnotationPresent(Id.class);

            if (annotationPresent) {
                return declaredField;
            }
        }

        throw new UnsupportedOperationException("Entity does not have Id column");
    }
}
