package org.gupao.singleton.lazy;

import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: Spark_tang
 * @Description: 简单懒汉单例测试
 * @Date: Created in 14:39 2020/2/27
 *
 */

/**
 *
 * 控制台的输出：
 * pool-1-thread-3---org.gupao.singleton.lazy.SimpleLazySingleton@4e12f8cb
 * pool-1-thread-1---org.gupao.singleton.lazy.SimpleLazySingleton@1aa89286
 * pool-1-thread-4---org.gupao.singleton.lazy.SimpleLazySingleton@1aa89286
 * pool-1-thread-2---org.gupao.singleton.lazy.SimpleLazySingleton@1aa89286
 *
 * 可以看出  简单的懒汉式单例是线程不安全的。
 */
public class SimpleLazyTest {

    @Test
    public void simpleLazySingletonTest() throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        executorService.submit(() -> {
            System.out.println(Thread.currentThread().getName() + "---" + SimpleLazySingleton.getInstance());
        });

        executorService.submit(() -> {
            System.out.println(Thread.currentThread().getName() + "---" + SimpleLazySingleton.getInstance());
        });

        executorService.submit(() -> {
            System.out.println(Thread.currentThread().getName() + "---" + SimpleLazySingleton.getInstance());
        });

        executorService.submit(() -> {
            System.out.println(Thread.currentThread().getName() + "---" + SimpleLazySingleton.getInstance());
        });

        Thread.sleep(500);
    }

}
