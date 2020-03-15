package org.gp.chain.builder;

import org.gp.chain.Phone;

import java.util.Objects;

/**
 * @description:
 * @author: Spark_tang
 * @time: 2020/3/15 16:03
 */
public class PhoneOpenHandler extends Handler {

    @Override
    public void handleRequest(Phone phone) {
        if (Objects.isNull(phone.getOpen())) {
            System.out.println("手机已经不能正常开机");
            return;
        }

        System.out.println("手机测试通过..., 全部参数: " + phone);
        if (this.handler != null) {
            this.handler.handleRequest(phone);
        }
    }
}
