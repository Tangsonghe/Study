package org.gp.interpreter;

/**
 * @description: 取余表达式
 * @author: Spark_tang
 * @time: 2020/3/22 12:56
 */
public class QuotExpressionParser extends AbstractExpressionParser {

    public QuotExpressionParser(IExpressionParser left, IExpressionParser rigth) {
        super(left, rigth);
    }

    @Override
    public int interpreter() {
        return this.left.interpreter() % this.rigth.interpreter();
    }
}
