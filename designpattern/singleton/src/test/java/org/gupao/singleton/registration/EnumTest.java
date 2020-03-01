package org.gupao.singleton.registration;

import org.gupao.singleton.lazy.StaticInnerSingleton;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: Spark_tang
 * @Description:
 * @Date: Created in 17:18 2020/2/27
 */
public class EnumTest {

    @Test
    public void enumSingletonTest() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        EnumSingleton instance = EnumSingleton.getInstance();

        executorService.submit(() -> {

            instance.setData(new EnumObj());
            System.out.println(Thread.currentThread().getName() + "---" + instance.getData());
        });

        executorService.submit(() -> {

            instance.setData(new EnumObj());
            System.out.println(Thread.currentThread().getName() + "---" + instance.getData());
        });

        executorService.submit(() -> {
            instance.setData(new EnumObj());
            System.out.println(Thread.currentThread().getName() + "---" + instance.getData());
        });

        executorService.submit(() -> {
            instance.setData(new EnumObj());
            System.out.println(Thread.currentThread().getName() + "---" + instance.getData());
        });

        Thread.sleep(500);
    }

}
