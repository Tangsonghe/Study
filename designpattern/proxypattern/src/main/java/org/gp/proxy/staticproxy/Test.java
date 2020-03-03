package org.gp.proxy.staticproxy;

/**
 * @description:
 * @author: Spark_tang
 * @time: 2020/3/2 21:57
 */
public class Test {

    public static void main(String[] args) {
        PersonProxy proxy = new PersonProxy(new Boy());
        proxy.findFirend();
    }
}
