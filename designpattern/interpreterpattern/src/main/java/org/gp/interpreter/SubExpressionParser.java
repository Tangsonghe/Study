package org.gp.interpreter;

/**
 * @description: 减法表达式
 * @author: Spark_tang
 * @time: 2020/3/22 11:28
 */
public class SubExpressionParser extends AbstractExpressionParser {

    public SubExpressionParser(IExpressionParser left, IExpressionParser rigth) {
        super(left, rigth);
    }

    @Override
    public int interpreter() {
        return this.left.interpreter() - this.rigth.interpreter();
    }
}
