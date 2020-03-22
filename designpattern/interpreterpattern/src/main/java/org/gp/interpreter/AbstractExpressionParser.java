package org.gp.interpreter;

/**
 * @description: 终结表达式解析器
 * @author: Spark_tang
 * @time: 2020/3/22 11:20
 */
public abstract class AbstractExpressionParser implements IExpressionParser {

    protected IExpressionParser left;
    protected IExpressionParser rigth;

    public AbstractExpressionParser(IExpressionParser left, IExpressionParser rigth) {
        this.left = left;
        this.rigth = rigth;
    }
}
