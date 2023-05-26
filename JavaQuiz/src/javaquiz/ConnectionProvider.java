package javaquiz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

public class ConnectionProvider {
    public static Connection con=null;

    public static Connection getConnection() {
        try {
            if (con == null) {
                Class.forName("org.postgresql.Driver");
                con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/users", 
                        "postgres", "Varshu@16"); 
                
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return con;
    }
}
