package com.gp.springboot.rabbit.config;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: Tangsonghe
 * @Description:
 * @Date: 19:15 2019/8/25
 */
//@Configuration
public class ExchangeConfig {

    private static final String DIRECT_EX = "SP_DIRECT_EXCHAGE";
    private static final String TOPIC_EX = "SP_TOPIC_EXCHAGE";
    private static final String FANOUT_EXT = "SP_FANOUT_EXCHAGE";

    @Bean("gpDirectExchange")
    public DirectExchange directExchange() {
        return new DirectExchange(DIRECT_EX);
    }

    @Bean("gpTopicExchange")
    public TopicExchange topicExchange() {
        return new TopicExchange(TOPIC_EX);
    }

    @Bean("gpFanoutExchange")
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange(FANOUT_EXT);
    }
}
