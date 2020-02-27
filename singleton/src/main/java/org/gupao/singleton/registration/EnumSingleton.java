package org.gupao.singleton.registration;

/**
 * @Author: Spark_tang
 * @Description: 注册模式单例（枚举模式单例）
 * @Date: Created in 16:57 2020/2/27
 *
 * 优点：防止放射（jdk底层就限制死了），线程安全
 * 缺点：大批量的情况下会造成内存浪费
 */
public enum EnumSingleton {
    INSTANCE;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    private Object data;

    public static EnumSingleton getInstance() {
        return INSTANCE;
    }

}
