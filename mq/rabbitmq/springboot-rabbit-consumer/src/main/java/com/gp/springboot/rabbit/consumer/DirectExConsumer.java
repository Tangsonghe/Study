package com.gp.springboot.rabbit.consumer;

import com.gp.springboot.rabbit.entity.MessageEntity;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * @Author: Tangsonghe
 * @Description: 第一个交换机
 * @Date: 19:43 2019/8/25
 */
@Component
@RabbitListener(queues = "QUEUE_DIRECT", containerFactory = "simpleRabbitListenerContainerFactory")
public class DirectExConsumer {

    @RabbitHandler
    public void process(@Payload MessageEntity message) {
        System.out.println("Direct ex ==============");
        System.out.println(message);
    }

}
