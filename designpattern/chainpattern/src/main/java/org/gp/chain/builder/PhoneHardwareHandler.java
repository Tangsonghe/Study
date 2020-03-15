package org.gp.chain.builder;

import org.gp.chain.Phone;

import java.util.Objects;

/**
 * @description:
 * @author: Spark_tang
 * @time: 2020/3/15 16:01
 */
public class PhoneHardwareHandler extends Handler {

    @Override
    public void handleRequest(Phone phone) {
        if (Objects.isNull(phone.getHardware())) {
            System.out.println("手机硬件已经损坏");
            return;
        }

        System.out.println("手机硬件测试正常... 品牌: " + phone.getHardware());
        if (this.handler != null)
            this.handler.handleRequest(phone);
    }
}
