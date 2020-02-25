package org.gupao.pay;

/**
 * @description: 微信pay
 * @author: Spark_tang
 * @time: 2020/2/25 20:51
 */
public class WechatPay extends ChinaPay {
    @Override
    public void pay() {
        System.out.println("wechat pay");
    }
}
