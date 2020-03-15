package org.gp.chain.builder;

import org.gp.chain.Phone;

import java.util.Objects;

/**
 * @description:
 * @author: Spark_tang
 * @time: 2020/3/15 15:55
 */
public class PhoneButtonHandler extends Handler {

    @Override
    public void handleRequest(Phone phone) {
        if (Objects.isNull(phone.getButton())) {
            System.out.println("手机按键已经损坏");
            return;
        }

        System.out.println("手机按键测试正常... 手机按键: " + phone.getButton());
        if (this.handler != null)
            handler.handleRequest(phone);
    }
}
