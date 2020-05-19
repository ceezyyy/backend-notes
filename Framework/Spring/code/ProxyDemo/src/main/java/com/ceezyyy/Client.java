package com.ceezyyy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) {
        // include producer
        final ProducerImpl producer = new ProducerImpl();
        // create proxyProducer
        Producer proxyProducer = (Producer) Proxy.newProxyInstance(producer.getClass().getClassLoader(),
                producer.getClass().getInterfaces(), new InvocationHandler() {
                    // enhance method
                    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                        if ("sell".equals(method.getName())) {
                            // get parameters
                            Double money = (Double) objects[0];
                            // With the Method instance in place,
                            // we can now call invoke() to execute the underlying method and get the returned object.
                            return method.invoke(producer, money * 0.8);
                        }
                        return method.invoke(producer, objects);
                    }
                });
        proxyProducer.sell(10000);
        proxyProducer.afterSalesService();
    }
}
