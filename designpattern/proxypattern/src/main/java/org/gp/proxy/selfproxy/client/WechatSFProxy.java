package org.gp.proxy.selfproxy.client;

import org.gp.proxy.selfproxy.SFClassLoader;
import org.gp.proxy.selfproxy.SFInvocationHandler;
import org.gp.proxy.selfproxy.SFProxy;

import java.lang.reflect.Method;

/**
 * @description:
 * @author: Spark_tang
 * @time: 2020/3/3 22:53
 */
public class WechatSFProxy implements SFInvocationHandler {

    public IWechat wechat;
    public IWechat newInstance(IWechat wechat) {
        this.wechat = wechat;
        Class<? extends IWechat> clazz = wechat.getClass();
        Object o = SFProxy.newProxyInstance(new SFClassLoader(), clazz.getInterfaces(), this);
        return (IWechat) o;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(wechat, args);
    }
}
