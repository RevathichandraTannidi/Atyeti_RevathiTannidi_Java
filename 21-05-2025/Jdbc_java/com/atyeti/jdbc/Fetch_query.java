package com.atyeti.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Fetch_query {
    public static void main(String[] args) throws Exception {
        String query = "select * from employees";
        Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "student", "student");
        System.out.println("Connection successful");
        Statement st = myConn.createStatement();
        ResultSet rs = st.executeQuery(query);

//        rs.next();
//        String name = rs.getString("last_name");
//        System.out.println(name);
        // C R U D --> reading part = fetching data from database
        while (rs.next()) {
            System.out.print(rs.getInt("id") +" ");
            System.out.print(rs.getString("first_name")+" ");
            System.out.println(rs.getString("last_name"));
        }

        myConn.close();
        System.out.println("Connection  closed");


    }
}
