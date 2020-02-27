package org.gupao.singleton.threadlocal;

/**
 * @Author: Spark_tang
 * @Description:
 * @Date: Created in 17:44 2020/2/27
 *
 * 在同一个主线程之内是线程安全的，是根据线程来的。
 *
 */
public class ThreadLocalSingleton {

    private ThreadLocalSingleton() {}

    private static final ThreadLocal<ThreadLocalSingleton> instance = ThreadLocal.withInitial(ThreadLocalSingleton::new);

    public static ThreadLocalSingleton getInstance() {
        return instance.get();
    }

}
