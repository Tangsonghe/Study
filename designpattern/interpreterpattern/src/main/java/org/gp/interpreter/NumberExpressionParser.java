package org.gp.interpreter;

/**
 * @description: 数字表达式
 * @author: Spark_tang
 * @time: 2020/3/22 11:36
 */
public class NumberExpressionParser implements IExpressionParser {

    private Integer value;

    public NumberExpressionParser(Integer value) {
        this.value = value;
    }

    @Override
    public int interpreter() {
        return this.value;
    }
}
