package org.gupao.pay;

/**
 * @description:
 * @author: Spark_tang
 * @time: 2020/2/25 20:40
 */
public interface IPaymentFactory {
    IPay createChinaPay();

    IPay createInternationalPay();
}
