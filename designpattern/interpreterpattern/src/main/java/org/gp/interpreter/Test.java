package org.gp.interpreter;

/**
 * @description:
 * @author: Spark_tang
 * @time: 2020/3/22 11:12
 */
public class Test {
    public static void main(String[] args) {

        // 第一种是通过分割空字符串来实现,感觉不灵活，少输入一个空格就会报错。体验不好
        Calculator c = new Calculator();
        c.parser("1 + 4 * 3 + ( ( 3 + 4 ) * ( 7 + 55 ) ) / 3");
        System.out.println("V1版本：" + c.getValue());

        // 第二种直接把空格全部替换为空，然后截取字符串动态判断是数字还是操作符去计算
        CalculatorV2 v2 = new CalculatorV2();
        v2.parser("1 + 4 *3 + ((3 + 4) * (7+55)) / 3");
        System.out.println("V2版本：" + v2.getValue());
    }
}
