package org.gp.interpreter;

/**
 * @description: 除法表达式
 * @author: Spark_tang
 * @time: 2020/3/22 11:34
 */
public class DivExpressionParser extends AbstractExpressionParser {
    public DivExpressionParser(IExpressionParser left, IExpressionParser rigth) {
        super(left, rigth);
    }

    @Override
    public int interpreter() {
        return this.left.interpreter() / this.rigth.interpreter();
    }
}
