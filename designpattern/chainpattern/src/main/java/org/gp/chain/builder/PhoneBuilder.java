package org.gp.chain.builder;

/**
 * @description:
 * @author: Spark_tang
 * @time: 2020/3/15 16:18
 */
public class PhoneBuilder {

    private Handler header;
    private Handler laster;

    public PhoneBuilder addHandler(Handler handler) {
        if (header == null) {
            this.header = this.laster = handler;
        }

        this.laster.next(handler);
        this.laster = handler;

        return this;
    }

    public Handler builder() {
        return this.header;
    }

}
