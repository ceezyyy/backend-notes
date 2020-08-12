package com.ceezyyy.publishSubscribe;

import com.ceezyyy.util.ConnectionFactoryUtil;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * Consumer of publish & subscribe
 */
public class Consumer {

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = ConnectionFactoryUtil.getConnectionFactory();

        try (
                Connection connection = factory.newConnection();
                Channel channel = connection.createChannel();
        ) {
            channel.exchangeDeclare(Publisher.EXCHANGE_NAME, BuiltinExchangeType.FANOUT);




        }
    }

}
