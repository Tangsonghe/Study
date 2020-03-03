package org.gp.proxy.selfproxy;

import java.lang.reflect.Method;

/**
 * @description:
 * @author: Spark_tang
 * @time: 2020/3/3 20:51
 */
public interface SFInvocationHandler {
    Object invoke(Object proxy, Method method, Object[] args) throws Throwable;
}
