package org.gp.chain.simple;

import org.gp.chain.Phone;

import java.util.Objects;

/**
 * @description:
 * @author: Spark_tang
 * @time: 2020/3/15 15:52
 */
public class PhoneHandler extends Handler {

    private Handler handler;

    public PhoneHandler(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void handleRequest(Phone phone) {
        if (Objects.isNull(phone)) {
            System.out.println("获取手机参数失败...");
            return;
        }

        System.out.println("获取手机所有参数成功, 进入测试阶段...");
        handler.handleRequest(phone);
    }
}
