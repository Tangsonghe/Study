package org.gp.interpreter;

import org.springframework.util.StringUtils;

import java.util.Objects;
import java.util.Stack;

/**
 * @description:
 * @author: Spark_tang
 * @time: 2020/3/22 11:37
 */
public class Calculator {

    private Stack<IExpressionParser> numbersStack = new Stack();
    private Stack<String> symbolsStack = new Stack<>();

    public void parser(String expression) {
        if (StringUtils.isEmpty(expression)) {
            throw new IllegalArgumentException("表达式为空");
        }

        String[] exps = expression.split(" ");
        for (int i = 0; i < exps.length; i++) {

            if (!OperatorUtils.isSymbol(exps[i])) {
                numbersStack.push(new NumberExpressionParser(Integer.valueOf(exps[i])));
            }
            else {
                calc(exps[i]);
            }
            if (i == exps.length - 1) {
                // 全部循环完毕进行最后的计算
                calc("");
            }
        }
    }

    private void calc(String operator) {
        // 判断运算优先级
        while (!comparePri(operator) && !symbolsStack.isEmpty()) {

            // 取出操作符合要操作的数据
            IExpressionParser right = numbersStack.pop();
            IExpressionParser left = numbersStack.pop();

            IExpressionParser parser = OperatorUtils.getClassBySymbol(symbolsStack.pop(), left, right);
            numbersStack.push(parser);
        }
        symbolsStack.push(operator);
        if (Objects.equals(operator, ")")) {
            symbolsStack.pop();
            symbolsStack.pop();
        }
    }

    public Integer getValue() {
        return this.numbersStack.pop().interpreter();
    }

    private boolean comparePri(String symbol) {
        if (symbolsStack.empty()) { // 空栈返回ture
            return true;
        }

        // 符号优先级说明（从高到低）:
        // 第1级: (
        // 第2级: * / %
        // 第3级: + -
        // 第4级: )

        String top = symbolsStack.peek(); // 查看堆栈顶部的对象，注意不是出栈
        if (Objects.equals("(", top)) {
            return true;
        }
        // 比较优先级
        switch (symbol) {
            case "(": // 优先级最高
                return true;
            case "*":
            case "/":
            case "%": {
                if (top.equals("+") || top.equals("-")) // 优先级比+和-高
                    return true;
                else
                    return false;
            }
            case "+":
            case "-":
            case "":
                return false;
            case ")": // 优先级最低
                return false;
            default:
                break;
        }
        return true;
    }

}
