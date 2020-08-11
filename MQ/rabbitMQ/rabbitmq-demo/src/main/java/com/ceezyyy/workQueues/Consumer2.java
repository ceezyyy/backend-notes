package com.ceezyyy.workQueues;

import com.ceezyyy.util.ConnectionFactoryUtil;
import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * Consumer2 of work queues
 */
public class Consumer2 {
    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = ConnectionFactoryUtil.getConnectionFactory();
        Connection connection = factory.newConnection();
        final Channel channel = connection.createChannel();

        channel.queueDeclare(Publisher.WORK_QUEUE_NAME, true, false, false, null);
        System.out.println("Receiving message");

        // request a specific prefetchCount "quality of service" settings for this channel.
        channel.basicQos(1);

        DeliverCallback deliverCallback = new DeliverCallback() {
            @Override
            public void handle(String consumerTag, Delivery message) throws IOException {
                System.out.println("Consumer2 here!");

                try {
                    String receivedMessage = new String(message.getBody());
                    System.out.println(receivedMessage);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {

                    System.out.println("Done");

                    /*
                     * In order to make sure a message is never lost, RabbitMQ supports message acknowledgments.
                     * An acknowledgement is sent back by the consumer to tell RabbitMQ that a particular message has been received,
                     * processed and that RabbitMQ is free to delete it.
                     * */
                    channel.basicAck(message.getEnvelope().getDeliveryTag(), false);

                }
            }
        };

        CancelCallback cancelCallback = new CancelCallback() {
            @Override
            public void handle(String consumerTag) throws IOException {
                System.out.println("Receive failed!");
            }
        };

        channel.basicConsume(Publisher.WORK_QUEUE_NAME, deliverCallback, cancelCallback);

    }
}
