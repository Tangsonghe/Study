package org.gp.chain.simple;

import org.gp.chain.Phone;

import java.util.Objects;

/**
 * @description:
 * @author: Spark_tang
 * @time: 2020/3/15 15:58
 */
public class PhoneCpuHandler extends Handler {

    private Handler handler;

    public PhoneCpuHandler(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void handleRequest(Phone phone) {
        if (Objects.isNull(phone.getCpu())) {
            System.out.println("手机cpu已经损坏");
            return;
        }

        System.out.println("手机cpu测试正常... 型号: " + phone.getCpu());
        handler.handleRequest(phone);
    }
}
