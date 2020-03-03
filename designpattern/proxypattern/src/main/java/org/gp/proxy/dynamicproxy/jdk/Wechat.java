package org.gp.proxy.dynamicproxy.jdk;

/**
 * @description:
 * @author: Spark_tang
 * @time: 2020/3/2 21:41
 */
public class Wechat implements IWechat {
    @Override
    public void send(String msg) {
        System.out.println("发送消息，" + msg);
    }
}
