package org.gp.builder;

/**
 * @description:
 * @author: Spark_tang
 * @time: 2020/3/5 21:01
 */
public class PhoneBuilder {

    private Phone phone = new Phone();

    public PhoneBuilder brand(String brand) {
        this.phone.setBrand(brand);
        return this;
    }

    public PhoneBuilder pixel(String pixel) {
        phone.setPixel(pixel);
        return this;
    }

    public PhoneBuilder camera(Integer camera) {
        phone.setCamera(camera);
        return this;
    }

    public PhoneBuilder color(String color) {
        phone.setColor(color);
        return this;
    }

    public PhoneBuilder length(Long length) {
        phone.setLength(length);
        return this;
    }

    public PhoneBuilder weight(long weight) {
        phone.setWeight(weight);
        return this;
    }

    public PhoneBuilder screenSize(String screenSize) {
        this.phone.setScreenSize(screenSize);
        return this;
    }

    public PhoneBuilder cpuType(String cpuType) {
        this.phone.setCpuType(cpuType);
        return this;
    }

    public Phone builder() {
        return this.phone;
    }

}
