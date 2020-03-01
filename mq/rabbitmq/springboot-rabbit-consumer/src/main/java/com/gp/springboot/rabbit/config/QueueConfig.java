package com.gp.springboot.rabbit.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: Tangsonghe
 * @Description: 定义queue
 * @Date: 19:20 2019/8/25
 */
//@Configuration
public class QueueConfig {

    private static final String QUEUE_TOPIC_NAME = "QUEUE_TOPIC";
    private static final String QUEUE_DIRECT_NAME = "QUEUE_DIRECT";
    private static final String QUEUE_FANOUT_NAME1 = "QUEUE_FANOUT_1";
    private static final String QUEUE_FANOUT_NAME2 = "QUEUE_FANOUT_2";

    @Bean("gpDirectQueue")
    public Queue getDirectQueue() {
        return new Queue(QUEUE_DIRECT_NAME);
    }

    @Bean("gpTopicQueue")
    public Queue getTopicQueue() {
        return new Queue(QUEUE_TOPIC_NAME);
    }

    @Bean("gpFanoutQueue1")
    public Queue getFanoutQueue1() {
        return new Queue(QUEUE_FANOUT_NAME1);
    }

    @Bean("gpFanoutQueue2")
    public Queue getFanoutQueue2() {
        return new Queue(QUEUE_FANOUT_NAME2);
    }
}
