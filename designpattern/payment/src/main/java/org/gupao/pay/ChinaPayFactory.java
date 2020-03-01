package org.gupao.pay;

/**
 * @description: 国内支付工程
 * @author: Spark_tang
 * @time: 2020/2/25 20:49
 */
public class ChinaPayFactory extends PaymentFactory {

    public IPay aliPay() {
        return super.createPayment(AliPay.class);
    }

    public IPay wechatPay() {
        return super.createPayment(WechatPay.class);
    }

    public IPay quickPay() {
        return super.createPayment(QuickPay.class);
    }
}
