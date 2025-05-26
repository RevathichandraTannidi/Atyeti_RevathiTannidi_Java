package com.atyeti.DatabaseHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;


public interface DatabaseConnection {
    static Connection getConnection() {
        Logger loggers= Logger.getLogger(DatabaseConnection.class.getName());
        String url = "jdbc:mysql://localhost:3306/logs";
        String user = "root";
        //String password="Revathi@2002";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection myConn = DriverManager.getConnection(url, user, "Revathi@2002");
            loggers.info("database connected succesfully");
            return  myConn;

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("db not connected" + e.getMessage());

        }

        return null;
    }
}
