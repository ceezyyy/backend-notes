package com.ceezyyy.util;

import com.rabbitmq.client.ConnectionFactory;

/**
 * Connection factory util
 */
public class ConnectionFactoryUtil {
    public static ConnectionFactory getConnectionFactory() {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setVirtualHost("/myVH");
        connectionFactory.setUsername("ceezyyy");
        connectionFactory.setPassword("123456");
        return connectionFactory;
    }
}
