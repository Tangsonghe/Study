package org.gupao.pay;

/**
 * @description: 闪付
 * @author: Spark_tang
 * @time: 2020/2/25 20:52
 */
public class QuickPay extends ChinaPay {
    @Override
    public void pay() {
        System.out.println("quick pay");
    }
}
