package org.gupao.singleton.lazy;

/**
 * @Author: Spark_tang
 * @Description: 简单懒汉单例
 * @Date: Created in 14:34 2020/2/27
 *
 * 简单懒汉式单例
 * 有点：节省内存空间
 * 缺点：线程不安全
 *
 */
public class SimpleLazySingleton {

    private static SimpleLazySingleton instance;

    private SimpleLazySingleton() {}

    public static SimpleLazySingleton getInstance() {
        if (instance == null) {
            instance = new SimpleLazySingleton();
        }
        return instance;
    }

}
