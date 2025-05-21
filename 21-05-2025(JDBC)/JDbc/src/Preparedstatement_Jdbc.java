package src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Preparedstatement_Jdbc {
    public static void main(String[] args) throws Exception {
        String query = "insert into employees values(?,?,?,?,?,?)";
        Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "student", "student");

        PreparedStatement st = myConn.prepareStatement(query);
        st.setInt(1, 19);
        st.setString(2, "Revathi T ");
        st.setString(3, "chandra T");
        st.setString(4, "chandra.T@gmail.com");
        st.setString(5, "softtrainee");
        st.setDouble(6, 33000.00);
        st.execute();
        st.setInt(1, 15);
        st.setString(2, "someswari");
        st.setString(3, "karanam");
        st.setString(4, "somes.k@gmail.com");
        st.setString(5, "softtrainee");
        st.setDouble(6, 33000.00);
        st.execute();

        myConn.close();

    }
}
