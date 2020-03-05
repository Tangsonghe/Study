package org.gp.builder;

/**
 * @description:
 * @author: Spark_tang
 * @time: 2020/3/5 21:13
 */
public class Test {

    public static void main(String[] args) {
        Phone iphone = new PhoneBuilder().brand("Apple iPhone11")
                .camera(2).color("紫色").cpuType("A13仿生")
                .length(Long.valueOf("151")).weight(Long.valueOf(194))
                .pixel("1200万").screenSize("6.1英寸").builder();

        Phone huawei = new PhoneBuilder().brand("华为 P30")
                .camera(2).color("亮黑色").cpuType("麒麟980")
                .length(Long.valueOf("150")).weight(Long.valueOf(165))
                .pixel("1670万").screenSize("6.1英寸").builder();

        System.out.println(iphone);
        System.out.println(huawei);


    }

}
