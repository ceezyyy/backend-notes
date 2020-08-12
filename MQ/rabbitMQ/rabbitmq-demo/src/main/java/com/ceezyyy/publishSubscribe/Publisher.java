package com.ceezyyy.publishSubscribe;

import com.ceezyyy.util.ConnectionFactoryUtil;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * Publisher of public & subscribe
 */
public class Publisher {

    static final String EXCHANGE_NAME = "exchange_fanout";
    static final String QUEUE_NAME1 = "exchange_fanout_queue1";
    static final String QUEUE_NAME2 = "exchange_fanout_queue2";

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = ConnectionFactoryUtil.getConnectionFactory();

        try (
                Connection connection = factory.newConnection();
                Channel channel = connection.createChannel();
        ) {
            channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.FANOUT);

            channel.queueDeclare(QUEUE_NAME1, true, false, true, null);
            channel.queueDeclare(QUEUE_NAME2, true, false, true, null);

            channel.queueBind(QUEUE_NAME1, EXCHANGE_NAME, "");
            channel.queueBind(QUEUE_NAME2, EXCHANGE_NAME, "");

            String message = "EXCHANGE FANOUT here!";
            channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes());

        }

    }

}
