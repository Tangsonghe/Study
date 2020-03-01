package org.gupao.pay;

/**
 * @description: paypal pay
 * @author: Spark_tang
 * @time: 2020/2/25 20:52
 */
public class PayPalPay extends InternationalPay {
    @Override
    public void pay() {
        System.out.println("paypal pay");
    }
}
