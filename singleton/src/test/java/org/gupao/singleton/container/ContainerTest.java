package org.gupao.singleton.container;

import org.gupao.singleton.hungry.HungrySingleton;
import org.gupao.singleton.lazy.StaticInnerSingleton;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: Spark_tang
 * @Description:
 * @Date: Created in 17:25 2020/2/27
 */
public class ContainerTest {

    /**
     * Container Singleton Test
     */
    @Test
    public void ContainerSingletonTest() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        executorService.submit(() -> {
            System.out.println(Thread.currentThread().getName() + "---" + ContainerSingleton.getBean("org.gupao.singleton.container.ContainerObj"));
        });

        executorService.submit(() -> {
            System.out.println(Thread.currentThread().getName() + "---" + ContainerSingleton.getBean("org.gupao.singleton.container.ContainerObj"));
        });

        executorService.submit(() -> {
            System.out.println(Thread.currentThread().getName() + "---" + ContainerSingleton.getBean("org.gupao.singleton.container.ContainerObj"));
        });

        executorService.submit(() -> {
            System.out.println(Thread.currentThread().getName() + "---" + ContainerSingleton.getBean("org.gupao.singleton.container.ContainerObj"));
        });

        Thread.sleep(500);
    }

}
