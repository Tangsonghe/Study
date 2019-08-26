package com.gp.rabbit;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Author: Tangsonghe
 * @Description:
 * @Date: 18:08 2019/8/25
 */
public class RabbitProvider {

    private static final String EXCHANGE_NAME = "ASIMPLE_EXCHANGE";

    public static void main(String[] args) {
        ConnectionFactory factory = RabbitConnectionFactory.getConnFactory();

        Connection providerCon = null;
        Channel proChannel = null;
        try {
            // 尝试创建mq连接和channel
            providerCon = factory.newConnection();
            proChannel = providerCon.createChannel();

            // 发送一波消息
            String mqMsg = "第一次学习rabbitMq, 很懵, 加油";

            // 创建交换机
            // 第一个参数是交换机的名称, 第二个是路由的key, 第三个是BaseProperties, 第四个是消息的载体
            proChannel.basicPublish(EXCHANGE_NAME, "news.mq", null, mqMsg.getBytes());
            System.out.println("消息发送成功...........");

        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        finally {

            try {
                if (proChannel != null)  proChannel.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                e.printStackTrace();
            }

            try {
                if (providerCon != null) providerCon.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
