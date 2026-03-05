package com.slom.main;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBConnection {
    public static final String URL ="jdbc:mysql://localhost:3306/SLOM";
    public static final String user ="root";
    public static final String password =" ";
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(URL,user,password);
    }
}
