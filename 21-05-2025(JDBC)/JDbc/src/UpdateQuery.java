package src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class UpdateQuery {
    public static void main(String[] args) throws  Exception{
        String query = "update employees set id =1  ,email='john.doe@gmail.com',department='delivery',salary=53330.0 where id =23 ";
        String sqlquery="update employees set id =14 where id =24 ";
        Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "student", "student");
        System.out.println("Connection  successful");
        Statement st = myConn.createStatement();
        st.execute(query);
        st.execute(sqlquery);
        System.out.println("Data updated successfully");

        System.out.println("Connection closed");
    }
}
