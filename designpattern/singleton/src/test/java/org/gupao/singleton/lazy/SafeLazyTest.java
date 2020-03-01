package org.gupao.singleton.lazy;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: Spark_tang
 * @Description:
 * @Date: Created in 15:22 2020/2/27
 */
public class SafeLazyTest {

    @Test
    public void safeLazySingletonTest() throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        executorService.submit(() -> {
            System.out.println(Thread.currentThread().getName() + "---" + StaticInnerSingleton.getInstance());
        });

        executorService.submit(() -> {
            System.out.println(Thread.currentThread().getName() + "---" + StaticInnerSingleton.getInstance());
        });

        executorService.submit(() -> {
            System.out.println(Thread.currentThread().getName() + "---" + StaticInnerSingleton.getInstance());
        });

        executorService.submit(() -> {
            System.out.println(Thread.currentThread().getName() + "---" + StaticInnerSingleton.getInstance());
        });

        Thread.sleep(500);
    }

}
