package org.gp.chain.simple;

import org.gp.chain.Phone;

/**
 * @description:
 * @author: Spark_tang
 * @time: 2020/3/15 16:04
 */
public class Test {
    public static void main(String[] args) {
        Phone phone = new Phone();
        phone.setScreen("15.1寸");
        phone.setBattery("2000MA");
        phone.setButton("Home键, 音量键, 关机键");
        phone.setCamera("摄像头");
        phone.setCpu("A12");
        phone.setHardware("海力士");
        phone.setOpen("开机");

        PhoneOpenHandler phoneOpenHandler = new PhoneOpenHandler();
        PhoneHardwareHandler phoneHardwareHandler = new PhoneHardwareHandler(phoneOpenHandler);
        PhoneCpuHandler phoneCpuHandler = new PhoneCpuHandler(phoneHardwareHandler);
        PhoneCameraHandler phoneCameraHandler = new PhoneCameraHandler(phoneCpuHandler);
        PhoneButtonHandler phoneButtonHandler = new PhoneButtonHandler(phoneCameraHandler);
        PhoneBatteryHandler phoneBatteryHandler = new PhoneBatteryHandler(phoneButtonHandler);
        PhoneScreenHandler phoneScreenHandler = new PhoneScreenHandler(phoneBatteryHandler);
        PhoneHandler phoneHandler = new PhoneHandler(phoneScreenHandler);

        phoneHandler.handleRequest(phone);
    }
}
