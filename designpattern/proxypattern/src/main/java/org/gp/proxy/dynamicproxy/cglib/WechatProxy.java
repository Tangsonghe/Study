package org.gp.proxy.dynamicproxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @description:
 * @author: Spark_tang
 * @time: 2020/3/2 22:04
 */
public class WechatProxy implements MethodInterceptor {

    public Object getInstance(Class<?> clazz) {
        // 等于jdk中的proxy工具类
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);

        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        methodProxy.invokeSuper(o, objects);
        after();
        return null;
    }

    private void after() {
        System.out.println("发送小程序订阅消息成功");
    }
}
