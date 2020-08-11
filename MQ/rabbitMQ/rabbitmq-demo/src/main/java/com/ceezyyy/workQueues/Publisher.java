package com.ceezyyy.workQueues;

import com.ceezyyy.util.ConnectionFactoryUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Publisher of work queues
 */
public class Publisher {

    static final String WORK_QUEUE_NAME = "work_queue";

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = ConnectionFactoryUtil.getConnectionFactory();

        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()
        ) {
            channel.queueDeclare(WORK_QUEUE_NAME, true, false, false, null);

            StringBuilder s = new StringBuilder("Work queue here!");

            // simulate
            for (int i = 0; i < 10; i++) {
                s.append(i);
                channel.basicPublish("", WORK_QUEUE_NAME, null, s.toString().getBytes());
            }

            System.out.println("Message sent!");
        }

    }

}
