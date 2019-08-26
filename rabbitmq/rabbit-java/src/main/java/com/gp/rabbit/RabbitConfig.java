package com.gp.rabbit;

/**
 * @Author: Tangsonghe
 * @Description:
 * @Date: 18:12 2019/8/25
 */
public interface RabbitConfig {

    /**
     * 远程rabbitmq服务器地址
     */
    String MQ_HOST = "192.168.60.225";

    /**
     * mq服务器的端口
     */
    Integer MQ_PORT = 5672;

    /**
     * mq链接用户
     */
    String MQ_USER_NAME = "guest";

    /**
     * mq链接密码
     */
    String MQ_USER_PWD = "guest";
}
