package org.gp.proxy.dynamicproxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @description:
 * @author: Spark_tang
 * @time: 2020/3/2 21:42
 */
public class WechatProxy implements InvocationHandler {
    private IWechat wechat;

    public IWechat getInstance(IWechat wechat) {
        this.wechat = wechat;
        Class<? extends IWechat> clazz = wechat.getClass();
        Object o = Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
        return (IWechat) o;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object invoke = method.invoke(this.wechat, args);
        after();
        return invoke;
    }

    private void after() {
        System.out.println("发送成功");
    }
}
