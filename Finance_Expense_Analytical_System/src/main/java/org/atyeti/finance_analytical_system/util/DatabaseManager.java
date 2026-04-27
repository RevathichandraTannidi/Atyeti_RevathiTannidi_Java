package org.atyeti.finance_analytical_system.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseManager {

    private static DatabaseManager instance;
    private Connection connection;

    private String url = "jdbc:mysql://localhost:3306/fincoach";
    private String username = "root";
    private String password = "Revathi@2002";

    private DatabaseManager() {
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static DatabaseManager getInstance() {
        if (instance == null) {
            instance = new DatabaseManager();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}