package com.gp.springboot.rabbit.consumer;

import com.gp.springboot.rabbit.entity.MessageEntity;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * @Author: Tangsonghe
 * @Description:
 * @Date: 10:21 2019/8/26
 */
@Component
@RabbitListener(queues = "QUEUE_FANOUT_1", containerFactory = "simpleRabbitListenerContainerFactory")
public class FanoutConsumer1 {

    @RabbitHandler
    public void process(@Payload MessageEntity message) {
        System.out.println("FanoutConsumer1 ================== ");
        System.out.println(message);
    }

}
