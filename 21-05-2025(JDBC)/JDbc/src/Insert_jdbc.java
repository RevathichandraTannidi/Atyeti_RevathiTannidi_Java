package src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Insert_jdbc {
    public static void main(String[] args) throws SQLException {
        String query = "insert into employees (last_name, first_name, email, department, salary) values('Revathi', ' chandra Tannidi', 'revathi.t@atyeti.com', 'STrainne', 33000.00)";
        Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "student", "student");
        System.out.println("Connection successful");
        Statement st = myConn.createStatement();
        //default boolean is false
        boolean rs = st.execute(query);
        System.out.println("Data inserted successfully");
        System.out.println(rs);
        myConn.close();
        System.out.println("Connection closed");
    }
}
