package com.atyeti.jdbc;

import java.sql.*;

public class Connection {
    public static void main(String[] args) throws Exception {
       java.sql.Connection myConn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "student" , "student");
        System.out.println("Connection successful");

    }
}
