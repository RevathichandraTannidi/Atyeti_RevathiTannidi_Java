package com.atyeti.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Delete {
    public static void main(String[] args) throws Exception
    {
        String query = "delete from employees where id between 26 and 27";
        Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "student", "student");
        System.out.println("Connect ion successful");
        Statement st = myConn.createStatement();
        st.execute(query);
        System.out.println("Data deleted successfully");

        System.out.println("Connection closed");

    }
}
