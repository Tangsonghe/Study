package org.gp.proxy.dynamicproxy.cglib;

/**
 * @description:
 * @author: Spark_tang
 * @time: 2020/3/2 22:03
 */
public class WechatMessage {

    public void sendMsg(String msg) {
        System.out.println("发送小程序订阅消息：" + msg);
    }

}
