package org.gupao.singleton.inner;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: Spark_tang
 * @Description:
 * @Date: Created in 16:11 2020/2/27
 */
public class StaticInnerTest {

    @Test
    public void staticInnerSingletonTest() throws InterruptedException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
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

        // 测试反射
        Class clazz = StaticInnerSingleton.class;
        Constructor c = clazz.getDeclaredConstructor();
        c.setAccessible(true);
        System.out.println(Thread.currentThread().getName() + "---" + c.newInstance());

        Thread.sleep(500);
    }

}
