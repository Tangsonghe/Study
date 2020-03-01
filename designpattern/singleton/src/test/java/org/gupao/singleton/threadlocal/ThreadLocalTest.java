package org.gupao.singleton.threadlocal;

import org.gupao.singleton.lazy.SimpleLazySingleton;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: Spark_tang
 * @Description:
 * @Date: Created in 17:46 2020/2/27
 */
public class ThreadLocalTest {

    @Test
    public void ThreadLocalSingletonTest() {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        executorService.submit(() -> {
            System.out.println(Thread.currentThread().getName() + "---" + ThreadLocalSingleton.getInstance());
            System.out.println(Thread.currentThread().getName() + "---" + ThreadLocalSingleton.getInstance());
        });

        executorService.submit(() -> {
            System.out.println(Thread.currentThread().getName() + "---" + ThreadLocalSingleton.getInstance());
        });

        executorService.submit(() -> {
            System.out.println(Thread.currentThread().getName() + "---" + ThreadLocalSingleton.getInstance());
        });

        executorService.submit(() -> {
            System.out.println(Thread.currentThread().getName() + "---" + ThreadLocalSingleton.getInstance());
        });

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
