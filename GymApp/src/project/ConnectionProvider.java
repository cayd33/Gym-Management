package project;

import java.sql.*;

public class ConnectionProvider {
    public static Connection getCon() throws SQLException {
        String jdbcURL = "jdbc:mysql://localhost:3306/gymdb";
        String username = "root";
        String password = "FullStackDeveloper10.";

        return DriverManager.getConnection(jdbcURL, username, password);
    }
}
