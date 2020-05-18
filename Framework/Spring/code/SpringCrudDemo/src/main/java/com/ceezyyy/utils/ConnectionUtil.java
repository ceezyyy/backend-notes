package com.ceezyyy.utils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionUtil {
    // connection stored in threadlocal
    private ThreadLocal<Connection> threadLocal = new ThreadLocal<>();
    private DataSource dataSource;

    // spring dependency injection
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Connection getThreadConnection() {
        /**
         * Description: get connection from datasource and bind to thread
         * @param: []
         * @return: java.sql.Connection
         */
        Connection connection = null;
        try {
            // get connection from datasource
            connection = dataSource.getConnection();
            // bind to thread
            threadLocal.set(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void removeThreadConnection() {
        /**
         * Description: unbind connection from threadlocal
         * @param: []
         * @return: void
         */
        threadLocal.remove();
    }
}
