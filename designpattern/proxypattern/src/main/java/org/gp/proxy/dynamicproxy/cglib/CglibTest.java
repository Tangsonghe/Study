package org.gp.proxy.dynamicproxy.cglib;

/**
 * @description:
 * @author: Spark_tang
 * @time: 2020/3/2 22:09
 *
 *
 *
 */
public class CglibTest {
    public static void main(String[] args) {
        WechatProxy proxy = new WechatProxy();
        WechatMessage instance = (WechatMessage) proxy.getInstance(WechatMessage.class);
        instance.sendMsg("欢迎使用cglib代理");
    }
}
