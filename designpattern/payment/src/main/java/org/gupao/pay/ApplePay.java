package org.gupao.pay;

/**
 * @description: 苹果pay
 * @author: Spark_tang
 * @time: 2020/2/25 20:52
 */
public class ApplePay extends InternationalPay {
    @Override
    public void pay() {
        System.out.println("apple pay");
    }
}
