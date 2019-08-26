package com.gp.springboot.rabbit.provider;

import com.gp.springboot.rabbit.entity.MessageEntity;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: Tangsonghe
 * @Description:
 * @Date: 12:05 2019/8/26
 */
@Component
public class RabbitSend {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send() {
        MessageEntity entity = new MessageEntity();
        entity.setId("1");
        entity.setMessage("我是一个Direct的mq消息");
        entity.setType("Direct");
        // 发送json消息格式
        amqpTemplate.convertAndSend("SP_DIRECT_EXCHAGE", "spark.news", entity);

        entity = new MessageEntity();
        entity.setId("2");
        entity.setMessage("我是一个Topic news的mq消息");
        entity.setType("Topic");
        amqpTemplate.convertAndSend("SP_TOPIC_EXCHAGE", "today.spark.news", entity);

        entity = new MessageEntity();
        entity.setId("3");
        entity.setMessage("我是一个Topic products的mq消息");
        entity.setType("Topic");
        amqpTemplate.convertAndSend("SP_TOPIC_EXCHAGE", "today.spark.products", entity);

        entity = new MessageEntity();
        entity.setId("4");
        entity.setMessage("我是一个fanout的mq消息");
        entity.setType("Fanout");
        amqpTemplate.convertAndSend("SP_FANOUT_EXCHAGE", "", entity);

        // 普通消息发送
//        // 发送一个direct的消息
//        String msg = "我是一个Direct的mq消息";
//        amqpTemplate.convertAndSend("SP_DIRECT_EXCHAGE", "spark.news", msg);
//
//        msg = "我是一个Topic news的mq消息";
//        amqpTemplate.convertAndSend("SP_TOPIC_EXCHAGE", "today.spark.news", msg);
//
//        msg = "我是一个Topic products的mq消息";
//        amqpTemplate.convertAndSend("SP_TOPIC_EXCHAGE", "today.spark.products", msg);
//
//        msg = "我是一个fanout的mq消息";
//        amqpTemplate.convertAndSend("SP_FANOUT_EXCHAGE", "", msg);

        System.out.println("发送消息成功..................");
    }

}
