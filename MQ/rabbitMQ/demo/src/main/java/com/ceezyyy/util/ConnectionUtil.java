package com.ceezyyy.util;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Connection Util
 */
public class ConnectionUtil {

    public Connection createConnection() throws IOException, TimeoutException {

        // create connection factory
        ConnectionFactory connectionFactory = new ConnectionFactory();

        // set connection
        connectionFactory.setVirtualHost("/myVH");
        connectionFactory.setUsername("ceezyyy");
        connectionFactory.setPassword("123456");

        // create connection
        return connectionFactory.newConnection();

    }

}
