package com.gp.rabbit;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Author: Tangsonghe
 * @Description:
 * @Date: 18:08 2019/8/25
 */
public class RabbitConsumer {

    private final static String EXCHANGE_NAME = "ASIMPLE_EXCHANGE";
    private final static String QUEUE_NAME = "ASIMPLE_QUEUE";

    public static void main(String[] args) {

        ConnectionFactory factory = RabbitConnectionFactory.getConnFactory();

        Connection consumerConn = null;
        Channel consumerChannel = null;
        try {
            consumerConn = factory.newConnection();
            consumerChannel = consumerConn.createChannel();

            // declare 交换机和队列。并将交换机和队列绑定
            // String exchange, String type, boolean durable, boolean autoDelete, Map<String, Object> args
            // 交换机名称，转发类型，是否持久化，是否自动删除，map参数（未知）
            consumerChannel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.DIRECT, false, false, null);
            // String queue, boolean durable, boolean exclusive, boolean autoDelete, Map<String, Object> arguments
            consumerChannel.queueDeclare(QUEUE_NAME, false, false, false, null);
            // 绑定交换机和队列
            consumerChannel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "news.mq");

            // 创建消费者
            Consumer consumer = new DefaultConsumer(consumerChannel) {
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope,
                                           AMQP.BasicProperties properties, byte[] body) throws IOException {

                    String msg = new String(body, "utf-8");
                    System.out.println("收到的消息： " + msg);
                    System.out.println("参数consumerTag： " + consumerTag);
                    System.out.println("参数envelope： " + envelope);
                    System.out.println("参数properties： " + properties);
                }
            };

            consumerChannel.basicConsume(QUEUE_NAME, true, consumer);
            System.out.println("消费者服务已启动完毕..........");

        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }

        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
