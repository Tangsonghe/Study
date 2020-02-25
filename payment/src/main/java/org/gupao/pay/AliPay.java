package org.gupao.pay;

/**
 * @description: 阿里pay
 * @author: Spark_tang
 * @time: 2020/2/25 20:51
 */
public class AliPay extends ChinaPay {

    @Override
    public void pay() {
        System.out.println("ali pay");
    }
}
