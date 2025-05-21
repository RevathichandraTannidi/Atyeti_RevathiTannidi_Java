package src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DEleteQuery {
    public static void main(String[] args)  throws Exception {
        String query = "delete from employees where id between 26 and 27";
        Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "student", "student");
        System.out.println("Connection successful");
        Statement st = myConn.createStatement();
        st.execute(query);
        System.out.println("Data deleted successfully");

        System.out.println("Connection closed");
    }
    }
