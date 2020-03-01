package org.gupao.pay;

/**
 * @description:
 * @author: Spark_tang
 * @time: 2020/2/25 20:44
 */
public abstract class PaymentFactory implements IPaymentFactory {

    public IPay createPayment(Class<? extends IPay> clazz) {

        try {
            return clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
