package com.oziriuz.concretecom.model.orm;

import com.oziriuz.concretecom.model.entities.*;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseManager {
    public static void ensureDatabase() throws SQLException {
        Connection connection = DatabaseConnection.getConnection();

        EntityManager<Operator> operatorEntityManager = new EntityManager<>(connection, Operator.class);
        operatorEntityManager.ensureTable();

        EntityManager<Administrator> administratorEntityManager = new EntityManager<>(connection, Administrator.class);
        administratorEntityManager.ensureTable();

        EntityManager<Client> clientEntityManager = new EntityManager<>(connection, Client.class);
        clientEntityManager.ensureTable();

        EntityManager<Worksite> worksiteEntityManager = new EntityManager<>(connection, Worksite.class);
        worksiteEntityManager.ensureTable();

        EntityManager<Supplier> supplierEntityManager = new EntityManager<>(connection, Supplier.class);
        supplierEntityManager.ensureTable();

        EntityManager<Driver> driverEntityManager = new EntityManager<>(connection, Driver.class);
        driverEntityManager.ensureTable();

        EntityManager<DailyExpenses> dailyExpensesEntityManager = new EntityManager<>(connection, DailyExpenses.class);
        dailyExpensesEntityManager.ensureTable();

        EntityManager<Delivery> deliveryEntityManager = new EntityManager<>(connection, Delivery.class);
        deliveryEntityManager.ensureTable();

        EntityManager<EntryLog1> entryLog1EntityManager = new EntityManager<>(connection, EntryLog1.class);
        entryLog1EntityManager.ensureTable();

        EntityManager<EntryLog2> entryLog2EntityManager = new EntityManager<>(connection, EntryLog2.class);
        entryLog2EntityManager.ensureTable();

        EntityManager<Materials1> materials1EntityManager = new EntityManager<>(connection, Materials1.class);
        materials1EntityManager.ensureTable();

        EntityManager<Materials2> materials2EntityManager = new EntityManager<>(connection, Materials2.class);
        materials2EntityManager.ensureTable();

        EntityManager<MixResults1> mixResults1EntityManager = new EntityManager<>(connection, MixResults1.class);
        mixResults1EntityManager.ensureTable();

        EntityManager<MixResults2> mixResults2EntityManager = new EntityManager<>(connection, MixResults2.class);
        mixResults2EntityManager.ensureTable();
        //Do not close connection!
    }
}
