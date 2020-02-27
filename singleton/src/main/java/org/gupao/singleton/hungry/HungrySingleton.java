package org.gupao.singleton.hungry;

/**
 * @Author: Spark_tang
 * @Description: 饿汉式单利模式
 * @Date: Created in 14:23 2020/2/27
 *
 * 饿汉式单利分析
 * 优点：执行效率高，性能高，没有任何锁
 * 缺点：在某些情况下（比如很多单利），会造成内存的浪费
 *
 */
public class HungrySingleton {

    private static HungrySingleton hungrySingleton;

    static {
        hungrySingleton = new HungrySingleton();
    }

    private HungrySingleton() {}

    public static HungrySingleton getInstance() {
        return hungrySingleton;
    }
}
