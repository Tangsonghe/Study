package org.gp.proxy.selfproxy.client;

/**
 * @description:
 * @author: Spark_tang
 * @time: 2020/3/3 22:53
 */
public class Wechat implements IWechat {
    @Override
    public void sendMsg(String msg) {
        System.out.println("====== " + msg);
    }
}
