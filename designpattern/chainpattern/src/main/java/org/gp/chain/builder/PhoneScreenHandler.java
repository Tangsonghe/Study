package org.gp.chain.builder;

import org.gp.chain.Phone;

import java.util.Objects;

/**
 * @description:
 * @author: Spark_tang
 * @time: 2020/3/15 15:44
 */
public class PhoneScreenHandler extends Handler {


    @Override
    public void handleRequest(Phone phone) {
        if (Objects.isNull(phone.getScreen())) {
            System.out.println("手机屏幕已经损坏");
            return;
        }

        System.out.println("屏幕测试正常... 屏幕大小: " + phone.getScreen());
        if (this.handler != null) {
            this.handler.handleRequest(phone);
        }
    }
}
