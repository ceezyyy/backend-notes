package com.ceezyyy.helloWorld;

import com.ceezyyy.util.ConnectionFactoryUtil;
import com.rabbitmq.client.*;
import oracle.jvm.hotspot.jfr.Producer;

import java.io.IOException;

/**
 * Consumer of "hello world"
 * <p>
 * we want the process to stay alive while the consumer is listening asynchronously for messages to arrive
 */
public class Consumer {

    public static void main(String[] args) throws Exception {

        ConnectionFactory factory = ConnectionFactoryUtil.getConnectionFactory();

        Connection connection = factory.newConnection();

        Channel channel = connection.createChannel();

        channel.queueDeclare(Publisher.QUEUE_NAME, false, false, false, null);
        System.out.println("Waiting for message");

        DeliverCallback deliverCallback = new DeliverCallback() {
            @Override
            public void handle(String consumerTag, Delivery message) throws IOException {
                String receivedMessage = new String(message.getBody());
                System.out.println("Received message: " + receivedMessage);
            }
        };

        CancelCallback cancelCallback = new CancelCallback() {
            @Override
            public void handle(String consumerTag) throws IOException {
                System.out.println("Receive failed!");
            }
        };

        channel.basicConsume(Publisher.QUEUE_NAME, deliverCallback, cancelCallback);

    }

}
