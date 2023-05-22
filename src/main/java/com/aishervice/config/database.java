package com.aishervice.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class database {
    private static Connection dbConn = null;

    public static String dbName = "aishservice";
    private static final String dbHost = "localhost";
    private static final String dbPort = "3306";
    private static final String dbUsername = "root";
    private static final String dbPassword = "";

    public static Connection getConnection(String env) {
        if (env == "test") {
            database.dbName = "aishervice_test";
        }

        if (database.dbConn == null) {
            String url = "jdbc:mysql://"+database.dbHost+":"+database.dbPort+"/"+database.dbName;
            try {
                database.dbConn = DriverManager.getConnection(url, database.dbUsername, database.dbPassword);
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } 

        return database.dbConn;
    }
}
