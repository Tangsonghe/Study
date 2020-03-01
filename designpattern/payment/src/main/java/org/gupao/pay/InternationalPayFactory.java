package org.gupao.pay;

/**
 * @description: 国际支付工厂
 * @author: Spark_tang
 * @time: 2020/2/25 20:46
 */
public class InternationalPayFactory extends PaymentFactory {

    public IPay applePay() {
        return super.createPayment(ApplePay.class);
    }

    public IPay payPalPay() {
        return super.createPayment(PayPalPay.class);
    }

}
