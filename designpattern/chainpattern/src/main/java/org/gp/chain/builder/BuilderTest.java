package org.gp.chain.builder;

import org.gp.chain.Phone;

/**
 * @description:
 * @author: Spark_tang
 * @time: 2020/3/15 16:23
 */
public class BuilderTest {
    public static void main(String[] args) {
        Phone phone = new Phone();
        phone.setScreen("15.1寸");
        phone.setBattery("2000MA");
        phone.setButton("Home键, 音量键, 关机键");
        phone.setCamera("摄像头");
        phone.setCpu("A12");
        phone.setHardware("海力士");
        phone.setOpen("开机");

        new PhoneBuilder().addHandler(new PhoneHandler()).addHandler(new PhoneScreenHandler())
                .addHandler(new PhoneButtonHandler()).addHandler(new PhoneCameraHandler())
                .addHandler(new PhoneBatteryHandler()).addHandler(new PhoneCpuHandler())
                .addHandler(new PhoneHardwareHandler()).addHandler(new PhoneOpenHandler())
                .builder().handleRequest(phone);
    }
}
