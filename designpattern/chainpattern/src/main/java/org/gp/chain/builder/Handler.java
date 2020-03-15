package org.gp.chain.builder;

import org.gp.chain.Phone;

/**
 * @description:
 * @author: Spark_tang
 * @time: 2020/3/15 15:40
 */
public abstract class Handler {

    protected Handler handler;

    public void next(Handler handler) {
        this.handler = handler;
    }

    //处理请求的方法,由子类进行去实现
    public abstract void handleRequest(Phone phone);

//    public static class PhoneBuilder {
//
//        private Handler header;
//        private Handler laster;
//
//        public PhoneBuilder addHandler(Handler handler) {
//            if (header == null) {
//                this.header = this.laster = handler;
//            }
//
//            this.laster.next(handler);
//            this.laster = handler;
//
//            return this;
//        }
//
//        public Handler builder() {
//            return this.header;
//        }
//
//    }
}
