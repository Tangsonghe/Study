package org.gupao.singleton.lazy;

/**
 * @Author: Spark_tang
 * @Description:
 * @Date: Created in 15:17 2020/2/27
 *
 * 带锁的懒汉式单例
 * 优点：线程安全
 * 缺点：代码可读性差，不优雅
 *
 */
public class StaticInnerSingleton {
    private static StaticInnerSingleton instance;

    private StaticInnerSingleton() {}

    /**
     *
     * 第一层判断是否为空表示是否需要并发
     * 第二层判断是并发后是否对象已经被创建，如果没有则创建，已经创建则直接返回
     *
     * @return
     */
    public static StaticInnerSingleton getInstance() {
        if (instance == null) {
            synchronized (StaticInnerSingleton.class) {
                if (instance == null) {
                    instance = new StaticInnerSingleton();
                }
            }
        }
        return instance;
    }

}
