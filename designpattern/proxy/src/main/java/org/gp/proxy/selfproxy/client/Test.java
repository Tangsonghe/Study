package org.gp.proxy.selfproxy.client;

/**
 * @description:
 * @author: Spark_tang
 * @time: 2020/3/3 22:58
 */
public class Test {
    public static void main(String[] args) {
        WechatSFProxy proxy = new WechatSFProxy();
        IWechat wechat = proxy.newInstance(new Wechat());
        wechat.sendMsg("11111111111111");

    }
}
