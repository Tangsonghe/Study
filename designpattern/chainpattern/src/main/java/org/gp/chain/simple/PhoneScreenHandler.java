package org.gp.chain.simple;

import org.gp.chain.Phone;

import java.util.Objects;

/**
 * @description:
 * @author: Spark_tang
 * @time: 2020/3/15 15:44
 */
public class PhoneScreenHandler extends Handler {

    private Handler handler;

    public PhoneScreenHandler(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void handleRequest(Phone phone) {
        if (Objects.isNull(phone.getScreen())) {
            System.out.println("手机屏幕已经损坏");
            return;
        }

        System.out.println("屏幕测试正常... 屏幕大小: " + phone.getScreen());
        handler.handleRequest(phone);
    }
}
