package com.atyeti.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseHAndle  {
    public static void database() throws Exception {
        String query = "CREATE TABLE logs (" + "id INT AUTO_INCREMENT PRIMARY KEY, " + "timestamp TIMESTAMP default CURRENT_TIMESTAMP, " +
                "error INT, " + "warning INT, " + "info INT)";
        String url = "jdbc:mysql://localhost:3306/logs";
        String user = "root";
        //String password="Revathi@2002";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection myConn = DriverManager.getConnection(url, user, "Revathi@2002");
                 Statement stmt = myConn.createStatement()) {
                stmt.execute(query);
                System.out.println("Table created ");
                System.out.println("connected succesfully");
            }
        }
        catch (SQLException e) {
                System.out.println("db not connected" + e.getMessage());

        }


    }


}
