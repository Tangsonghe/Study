package org.gupao.singleton.container;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: Spark_tang
 * @Description: 容器注册单例模式
 * @Date: Created in 17:24 2020/2/27
 */
public class ContainerSingleton {

    private ContainerSingleton() {
    }

    private static Map<String, Object> ioc = new ConcurrentHashMap<String, Object>();

    public static Object getBean(String className) {
        if (!ioc.containsKey(className)) {
            Object object = null;
            synchronized (ioc) {
                // 如果没有值则创建，有值则返回。
                if (object != null) {
                    return object;
                }
                try {
                    object = Class.forName(className).newInstance();
                    ioc.put(className, object);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return object;
        } else {
            return ioc.get(className);
        }
    }
}
