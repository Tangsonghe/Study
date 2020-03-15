package org.gp.chain.builder;

import org.gp.chain.Phone;

import java.util.Objects;

/**
 * @description:
 * @author: Spark_tang
 * @time: 2020/3/15 15:52
 */
public class PhoneHandler extends Handler {

    @Override
    public void handleRequest(Phone phone) {
        if (Objects.isNull(phone)) {
            System.out.println("获取手机参数失败...");
            return;
        }

        System.out.println("获取手机所有参数成功, 进入测试阶段...");
        if (this.handler != null)
            handler.handleRequest(phone);
    }
}
