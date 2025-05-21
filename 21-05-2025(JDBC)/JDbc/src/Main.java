package src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "student" , "student");
        System.out.println("Connection successful");
    }
}
