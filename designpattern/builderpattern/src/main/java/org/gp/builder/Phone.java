package org.gp.builder;

/**
 * @description: 建造者模式实现举例
 * @author: Spark_tang
 * @time: 2020/3/5 20:48
 */
public class Phone {

    /**
     * 手机品牌
     */
    private String brand;

    /**
     * 像素
     */
    private String pixel;

    /**
     * 多少个摄像头
     */
    private Integer camera;

    /**
     * 颜色
     */
    private String color;

    /**
     * 长度
     */
    private Long length;

    /**
     * 重量
     */
    private Long weight;

    /**
     * 屏幕尺寸
     */
    private String screenSize;

    /**
     * cpu类型
     */
    private String cpuType;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getPixel() {
        return pixel;
    }

    public void setPixel(String pixel) {
        this.pixel = pixel;
    }

    public Integer getCamera() {
        return camera;
    }

    public void setCamera(Integer camera) {
        this.camera = camera;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Long getLength() {
        return length;
    }

    public void setLength(Long length) {
        this.length = length;
    }

    public Long getWeight() {
        return weight;
    }

    public void setWeight(Long weight) {
        this.weight = weight;
    }

    public String getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(String screenSize) {
        this.screenSize = screenSize;
    }

    public String getCpuType() {
        return cpuType;
    }

    public void setCpuType(String cpuType) {
        this.cpuType = cpuType;
    }

    @Override
    public String toString() {
        return "手机品牌:" + this.brand +
                ", 像素: " + this.pixel + "像素" +
                ", 摄像头: " + this.camera + "个" +
                ", 颜色: " + this.color +
                ", cpu类型: " + this.cpuType +
                ", 机身长度: " + this.length + "mm" +
                ", 屏幕尺寸: " + this.screenSize +
                ", 重量: " + this.weight + "克";
    }
}
