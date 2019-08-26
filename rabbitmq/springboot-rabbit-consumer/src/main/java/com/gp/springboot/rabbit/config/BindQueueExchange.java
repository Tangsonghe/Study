package com.gp.springboot.rabbit.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: Tangsonghe
 * @Description: 绑定交换机和queue
 * @Date: 19:36 2019/8/25
 */
@Configuration
public class BindQueueExchange {

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

    private static final String QUEUE_DIRECT_NAME = "QUEUE_DIRECT";
    private static final String QUEUE_TOPIC_NAME = "QUEUE_TOPIC";
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

    @Bean
    public Binding bingDirectQueue(@Qualifier("gpDirectExchange")DirectExchange exchange,
                                   @Qualifier("gpDirectQueue")Queue queue) {

        return BindingBuilder.bind(queue).to(exchange).with("spark.news");
    }

    @Bean
    public Binding bingTopicQueue(@Qualifier("gpTopicExchange") TopicExchange exchange,
                                   @Qualifier("gpTopicQueue")Queue queue) {

        return BindingBuilder.bind(queue).to(exchange).with("*.spark.*");
    }

    @Bean
    public Binding bingFanoutQueue1(@Qualifier("gpFanoutExchange")FanoutExchange exchange,
                                  @Qualifier("gpFanoutQueue1")Queue queue) {

        return BindingBuilder.bind(queue).to(exchange);
    }

    @Bean
    public Binding bingFanoutQueue2(@Qualifier("gpFanoutExchange")FanoutExchange exchange,
                                   @Qualifier("gpFanoutQueue2")Queue queue) {

        return BindingBuilder.bind(queue).to(exchange);
    }
}
