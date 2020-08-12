package com.ceezyyy.publishSubscribe;

import com.ceezyyy.util.ConnectionFactoryUtil;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Publisher of public & subscribe
 */
public class Publisher {

    static final String EXCHANGE_NAME = "exchange_fanout";

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = ConnectionFactoryUtil.getConnectionFactory();

        try (
                Connection connection = factory.newConnection();
                Channel channel = connection.createChannel();
        ) {
            channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.FANOUT);
            String message = "Fanout here!";
            channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes());
        } finally {
            System.out.println("Message sent!");
        }

    }

}
