package com.company;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

public class Main {

    public static void main(String[] args) throws Exception {
        Properties pro = new Properties();
        InputStream inputStream = Main.class.getClassLoader().getResourceAsStream("druid.properties");
        pro.load(inputStream);

        // Creat DataSource
        DataSource dataSource = DruidDataSourceFactory.createDataSource(pro);

        // Get Connection
        Connection connection = dataSource.getConnection();

        System.out.println(connection);

        // Return back connection
        connection.close();
    }
}
