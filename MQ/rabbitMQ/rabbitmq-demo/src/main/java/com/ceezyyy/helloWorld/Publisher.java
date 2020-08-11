package com.ceezyyy.helloWorld;

import com.ceezyyy.util.ConnectionFactoryUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Publisher of "hello world"
 */
public class Publisher {

    static final String QUEUE_NAME = "hello";

    public static void main(String[] args) throws IOException, TimeoutException {

        // get factory
        ConnectionFactory factory = ConnectionFactoryUtil.getConnectionFactory();

        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            String message = "Hello World";
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
            System.out.println("Message sent!");
        }

    }

}
