package org.gp.interpreter;

/**
 * @description: 乘法表达式
 * @author: Spark_tang
 * @time: 2020/3/22 11:33
 */
public class MultExpressionParser extends AbstractExpressionParser {
    public MultExpressionParser(IExpressionParser left, IExpressionParser rigth) {
        super(left, rigth);
    }

    @Override
    public int interpreter() {
        return this.left.interpreter() * this.rigth.interpreter();
    }
}
