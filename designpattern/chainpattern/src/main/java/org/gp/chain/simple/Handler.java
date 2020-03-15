package org.gp.chain.simple;

import org.gp.chain.Phone;

/**
 * @description:
 * @author: Spark_tang
 * @time: 2020/3/15 15:40
 */
public abstract class Handler {

    private Handler handler;

    public void next(Handler handler) {
        this.handler = handler;
    }

    //处理请求的方法,由子类进行去实现
    public abstract void handleRequest(Phone phone);
}
