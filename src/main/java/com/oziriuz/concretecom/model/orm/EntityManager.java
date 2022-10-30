package com.oziriuz.concretecom.model.orm;

import com.oziriuz.concretecom.model.annotations.*;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;


public class EntityManager<E> implements DbContext<E> {
    private final Connection connection;
    private final Class<E> clazz;
    private final String tableName;
    private final String idColumn;
    private final List<String> tableFieldsWithoutId;
    List<String> uniques;

    public EntityManager(Connection connection, Class<E> clazz) {
        this.connection = connection;
        this.clazz = clazz;
        this.tableName = getTableName();
        this.idColumn = getEntityIdColumn();
        this.tableFieldsWithoutId = getEntityColumnsWithoutId();
        this.uniques = getEntityUniqueColumns();
    }

    public void ensureTableInDatabase() throws SQLException {
        if (hasTableInDB()) {
            alterTableInDBIfNeeded();
            return;
        }
        createTableInDB();
    }
    public void createTableInDB() throws SQLException {
        String fieldsWithTypes = getSQLFieldsWithTypes();
        StringBuilder sb = new StringBuilder("CREATE TABLE ");
        sb.append(tableName)
                .append(" (")
                .append(idColumn)
                .append(" SERIAL PRIMARY KEY, ")
                .append(fieldsWithTypes);

        if (uniques != null) {
            String uniquesStr = String.join(", ", uniques);
            sb.append(", ")
                    .append("UNIQUE (")
                    .append(uniquesStr)
                    .append(")");
        }

        sb.append(")");

        String createQuery = sb.toString();
        PreparedStatement statement = connection.prepareStatement(createQuery);
        statement.execute();
    }

    public void alterTableInDBIfNeeded() throws SQLException {
        String addColumnStatements = getAddColumnStatementsForNewFields();

        if (addColumnStatements.equals("")) {
            return;
        }

        String alterQuery = String.format("ALTER TABLE %s %s", tableName, addColumnStatements);
        PreparedStatement statement = connection.prepareStatement(alterQuery);
        statement.execute();
    }

    //region helpers
    private String getAddColumnStatementsForNewFields() throws SQLException {
        Set<String> sqlColumns = getSQLColumnNames();
        List<Field> fields = getFieldsWithoutId();

        List<String> allAddStatements = new ArrayList<>();
        for (Field field : fields) {
            String fieldName = getSQLColumnName(field);

            if (sqlColumns.contains(fieldName)) {
                continue;
            }

            String sqlType = getSQLType(field.getType());

            String addStatement = String.format("ADD COLUMN %s %s", fieldName, sqlType);
            allAddStatements.add(addStatement);
        }

        return String.join(", ", allAddStatements);
    }

    private Set<String> getSQLColumnNames() throws SQLException {
        Field idColumn = getIdColumn();
        String idColumnName = getSQLColumnName(idColumn);
        String selectQuery = "SELECT column_name FROM information_schema.columns WHERE table_name = ? AND column_name != ?";
        PreparedStatement statement = connection.prepareStatement(selectQuery);
        statement.setString(1, tableName);
        statement.setString(2, idColumnName);

        ResultSet resultSet = statement.executeQuery();

        Set<String> result = new HashSet<>();
        while(resultSet.next()) {
            String columnName = resultSet.getString("COLUMN_NAME");
            result.add(columnName);
        }

        return result;
    }
    private boolean hasTableInDB() throws SQLException {
        String selectQuery = "SELECT table_name FROM information_schema.tables WHERE table_name = ?";
        PreparedStatement statement = connection.prepareStatement(selectQuery);
        statement.setString(1, tableName);
        ResultSet resultSet = statement.executeQuery();
        return resultSet.next();
    }

    private String getSQLFieldsWithTypes() {
        return getFieldsWithoutId()
                .stream()
                .map(field -> {
                    String fieldName = getSQLColumnName(field);
                    String sqlType = getSQLType(field.getType());
                    return fieldName + " " + sqlType;
                })
                .collect(Collectors.joining(", "));
    }

    private List<Field> getFieldsWithoutId() {
        return Arrays.stream(clazz.getDeclaredFields())
                .filter(f -> !f.isAnnotationPresent(Id.class))
                .filter(f -> f.isAnnotationPresent(Column.class))
                .collect(Collectors.toList());
    }

    private String getSQLColumnName(Field idColumn) {
        return idColumn.getAnnotationsByType(Column.class)[0].value();
    }

    private String getSQLType(Class<?> type) {
        String sqlType = "";
        if (type == Integer.class || type == int.class) {
            sqlType = "integer";
        } else if (type == String.class) {
            sqlType = "text";
        } else if (type == LocalDate.class) {
            sqlType = "text";
        }

        return sqlType;
    }

    //endregion
    @Override
    public boolean saveToDB(E entity) throws IllegalAccessException, SQLException {
        Field idColumn = getIdColumn();
        idColumn.setAccessible(true);
        Object idValue = idColumn.get(entity);

        if (idValue == null || (int) idValue <= 0) {
            return doInsert(entity);
        }

        return doUpdate(entity, (long) idValue);
    }

    private boolean doInsert(E entity) throws SQLException, IllegalAccessException {
        String tableFieldsStr = String.join(", ", tableFieldsWithoutId);
        String tableValuesStr = String.join(", ", getEntityValuesWithoutId(entity));

        StringBuilder sb = new StringBuilder("INSERT INTO ");
        sb.append(tableName)
                .append(" (")
                .append(tableFieldsStr)
                .append(") VALUES (")
                .append(tableValuesStr)
                .append(")");

        String insertQuery = sb.toString();
        return connection.prepareStatement(insertQuery).execute();
    }

    private boolean doUpdate(E entity, long idValue) throws SQLException, IllegalAccessException {
        List<String> tableFields = getEntityColumnsWithoutId();
        List<String> tableValues = getEntityValuesWithoutId(entity);

        List<String> setStatements = new ArrayList<>();
        for (int i = 0; i < tableFields.size(); i++) {
            String statement = tableFields.get(i) + " = " + tableValues.get(i);
            setStatements.add(statement);
        }
        String statementStr = String.join(",", setStatements);
        StringBuilder sb = new StringBuilder("UPDATE ");
        sb.append(tableName)
                .append(" SET ")
                .append(statementStr)
                .append(" WHERE ")
                .append(idColumn)
                .append(" = ")
                .append(idValue);

        String updateQuery = sb.toString();
        PreparedStatement statement = connection.prepareStatement(updateQuery);
        return statement.execute();
    }

    private List<String> getEntityColumnsWithoutId() {
        return Arrays.stream(clazz.getDeclaredFields())
                .filter(f -> !f.isAnnotationPresent(Id.class))
                .filter((f -> f.isAnnotationPresent(Column.class)))
                .map(f -> f.getAnnotationsByType(Column.class))
                .map(a -> a[0].value())
                .collect(Collectors.toList());
    }

    private String getEntityIdColumn() {
        List<String> columns = Arrays.stream(clazz.getDeclaredFields())
                .filter(f -> f.isAnnotationPresent(Column.class))
                .filter(f -> f.isAnnotationPresent(Id.class))
                .map(f -> f.getAnnotationsByType(Column.class))
                .map(a -> a[0].value())
                .collect(Collectors.toList());

        if (columns.size() > 0) {
            return columns.get(0);
        }

        return null;
    }

    private List<String> getEntityUniqueColumns() {
        List<String> columns = Arrays.stream(clazz.getDeclaredFields())
                .filter(f -> f.isAnnotationPresent(Column.class))
                .filter(f -> f.isAnnotationPresent(Unique.class))
                .map(f -> f.getAnnotationsByType(Column.class))
                .map(a -> a[0].value())
                .collect(Collectors.toList());

        if (columns.size() > 0) {
            return columns;
        }

        return null;
    }

    private List<String> getEntityValuesWithoutId(E entity) throws IllegalAccessException {
        List<Field> fields = Arrays.stream(clazz.getDeclaredFields())
                .filter(f -> !f.isAnnotationPresent(Id.class))
                .filter((f -> f.isAnnotationPresent(Column.class)))
                .collect(Collectors.toList());

        List<String> values = new ArrayList<>();
        for (Field field : fields) {
            field.setAccessible(true);
            Object o = field.get(entity);
            if (o == null) {
                //TODO: when a new field is added and table is altered
                o = "";
            }

            if (o instanceof String || o instanceof LocalDate) {
                values.add("'" + o + "'");
            } else {
                values.add(o.toString());
            }
        }

        return values;
    }

    private String getTableName() {
        Entity[] annotationsByType = clazz.getAnnotationsByType(Entity.class);

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
        //TODO: bug when there is a new field and column has an empty cell
        List<String> tableValues = getEntityValuesWithoutId(entity);
        StringBuilder sb = new StringBuilder("SELECT * FROM ");
        sb.append(tableName)
                .append(" ")
                .append("WHERE");

        for (int i = 0; i < tableFieldsWithoutId.size(); i++) {
            sb.append(" ")
                    .append(tableFieldsWithoutId.get(i))
                    .append(" = ")
                    .append(tableValues.get(i));
            if (i < tableFieldsWithoutId.size() - 1) {
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
