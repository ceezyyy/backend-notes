package com.ceezyyy.publishSubscribe;

import com.ceezyyy.util.ConnectionFactoryUtil;
import com.rabbitmq.client.*;

import java.io.IOException;

import static com.ceezyyy.publishSubscribe.Publisher.EXCHANGE_NAME;
import static com.ceezyyy.publishSubscribe.Publisher.QUEUE_NAME2;

/**
 * Consumer2 of publish and subscribe
 */
public class Consumer2 {

    public static void main(String[] args) throws Exception {

        ConnectionFactory factory = ConnectionFactoryUtil.getConnectionFactory();

        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.FANOUT);

        channel.queueDeclare(QUEUE_NAME2, true, false, true, null);

        channel.queueBind(QUEUE_NAME2, EXCHANGE_NAME, "");

        DeliverCallback deliverCallback = new DeliverCallback() {
            @Override
            public void handle(String consumerTag, Delivery message) throws IOException {
                System.out.println("Consumer2 have received message: " + new String(message.getBody()));
            }
        };

        channel.basicConsume(QUEUE_NAME2, deliverCallback, (CancelCallback) null);

    }

}
