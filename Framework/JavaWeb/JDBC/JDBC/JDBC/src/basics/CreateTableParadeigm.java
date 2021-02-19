package com.jdbc.basics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateTableParadeigm {
    public static void main(String[] args) {

        Connection c;
        Statement stmt;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:c:/lessondb/test.db");
            System.out.println("Opened database successfully");
            stmt = c.createStatement();
            String sql = "CREATE TABLE COMPANY " +
                    "(ID INT PRIMARY KEY NOT NULL," +
                    " NAME TEXT NOT NULL, " +
                    " AGE INT NOT NULL, " +
                    " ADDRESS CHAR(50), " +
                    " SALARY REAL)";
            stmt.executeUpdate(sql);
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Table created successfully");

// TODO code application logic here
    }

}

