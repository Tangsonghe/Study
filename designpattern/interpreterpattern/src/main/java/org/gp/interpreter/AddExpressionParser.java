package org.gp.interpreter;

/**
 * @description: 加法表达式
 * @author: Spark_tang
 * @time: 2020/3/22 11:21
 */
public class AddExpressionParser extends AbstractExpressionParser {

    public AddExpressionParser(IExpressionParser left, IExpressionParser rigth) {
        super(left, rigth);
    }

    @Override
    public int interpreter() {
        return this.left.interpreter() + this.rigth.interpreter();
    }
}
