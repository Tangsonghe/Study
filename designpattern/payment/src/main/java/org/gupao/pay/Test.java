package org.gupao.pay;

/**
 * @description:
 * @author: Spark_tang
 * @time: 2020/2/25 20:57
 */
public class Test {

    public static void main(String[] args) {
        ChinaPayFactory chinaPayFactory = new ChinaPayFactory();
        chinaPayFactory.aliPay().pay();
        chinaPayFactory.wechatPay().pay();
        chinaPayFactory.quickPay().pay();

        InternationalPayFactory internationalPayFactory = new InternationalPayFactory();
        internationalPayFactory.applePay().pay();
        internationalPayFactory.payPalPay().pay();
    }
}
