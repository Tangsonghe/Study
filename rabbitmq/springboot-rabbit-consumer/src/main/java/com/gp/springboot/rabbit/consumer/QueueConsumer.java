package com.gp.springboot.rabbit.consumer;

import com.gp.springboot.rabbit.entity.MessageEntity;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * @Author: Tangsonghe
 * @Description:
 * @Date: 10:19 2019/8/26
 */
@Component
@RabbitListener(queues = "QUEUE_TOPIC", containerFactory = "simpleRabbitListenerContainerFactory")
public class QueueConsumer {

    @RabbitHandler
    public void process(@Payload MessageEntity message) {
        System.out.println("Queue consumer ============== \n" + message);
    }

}
