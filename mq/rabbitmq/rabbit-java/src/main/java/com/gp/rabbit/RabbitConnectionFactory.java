package com.gp.rabbit;

import com.rabbitmq.client.ConnectionFactory;

/**
 * @Author: Tangsonghe
 * @Description:
 * @Date: 18:34 2019/8/25
 */
public class RabbitConnectionFactory {

    public static ConnectionFactory getConnFactory() {

        ConnectionFactory factory = new ConnectionFactory();

        factory.setHost(RabbitConfig.MQ_HOST);
        factory.setPort(RabbitConfig.MQ_PORT);
        factory.setVirtualHost("/");
        factory.setUsername(RabbitConfig.MQ_USER_NAME);
        factory.setPassword(RabbitConfig.MQ_USER_PWD);

        return factory;

    }

}
