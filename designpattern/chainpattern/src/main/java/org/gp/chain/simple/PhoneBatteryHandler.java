package org.gp.chain.simple;

import org.gp.chain.Phone;

import java.util.Objects;

/**
 * @description:
 * @author: Spark_tang
 * @time: 2020/3/15 15:59
 */
public class PhoneBatteryHandler extends Handler {

    private Handler handler;

    public PhoneBatteryHandler(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void handleRequest(Phone phone) {

        if (Objects.isNull(phone.getBattery())) {
            System.out.println("手机电池已经损坏");
            return;
        }

        System.out.println("电池测试正常... 电池容量: " + phone.getBattery());
        handler.handleRequest(phone);
    }
}
