package com.jdbc.basics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectJdbcParadeigm {
    public static void main(String[] args) {

        Connection c;
        Statement stmt;
        try {
            Class.forName("org.sqlite.JDBC"); //here you input the url of your database

            c = DriverManager.getConnection("jdbc:sqlite:C:/lessondb/test.db");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM PERSON;" );

            while ( rs.next() ) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String address = rs.getString("adress");
                String city = rs.getString("city");

                System.out.println( "ID = " + id );
                System.out.println( "NAME = " + name );
                System.out.println( "ADDRESS = " + address );
                System.out.println( "CITY = " + city );
                System.out.println( " ");

            }
            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Operation done successfully");

    }
}
