package TastyFood;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;


public class DBMS {

    public static Connection c;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3307/tasty_burger";
            String un = "root";
            String pw = "1234";
            c = DriverManager.getConnection(url, un, pw);

        } catch (Exception e) {
            System.out.println("Error");
            System.out.println(e);
        }
    }

    public static void iud(String q) throws Exception {

        Statement s = c.createStatement();
        int X = s.executeUpdate(q);
    }

    public static ResultSet search(String q) throws Exception {

        Statement s = c.createStatement();
        ResultSet r = s.executeQuery(q);
        return r;
    }

}


   