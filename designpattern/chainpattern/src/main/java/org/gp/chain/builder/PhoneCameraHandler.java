package org.gp.chain.builder;

import org.gp.chain.Phone;

import java.util.Objects;

/**
 * @description:
 * @author: Spark_tang
 * @time: 2020/3/15 15:56
 */
public class PhoneCameraHandler extends Handler {

    @Override
    public void handleRequest(Phone phone) {

        if (Objects.isNull(phone.getCamera())) {
            System.out.println("手机摄像头已经损坏");
            return;
        }

        System.out.println("手机摄像头测试正常... 像素: " + phone.getCamera());
        if (this.handler != null)
            handler.handleRequest(phone);
    }
}
