package org.gp.interpreter;

import org.springframework.util.StringUtils;

import java.util.Objects;
import java.util.Stack;

/**
 * @description: 相对于第一种方案，通过空字符串分割数组显得有些不自然。
 *               第二种直接把所有的空格都去掉，动态去判断数字和操作符。
 * @author: Spark_tang
 * @time: 2020/3/22 16:12
 */
public class CalculatorV2 {

    private Stack<IExpressionParser> numbersStack = new Stack();
    private Stack<String> symbolsStack = new Stack<>();

    public void parser(String expression) {
        if (StringUtils.isEmpty(expression)) {
            throw new IllegalArgumentException("表达式为空");
        }

        expression = expression.replaceAll(" ", "");
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            // 拼接数字，因为数字有可能是多位数的
            if (!OperatorUtils.isSymbol(ch)) {
                sb.append(ch);
            }
            // 判断操作符计算
            else {
                String temp = sb.toString().trim();
                if (!StringUtils.isEmpty(temp)) {
                    numbersStack.push(new NumberExpressionParser(Integer.valueOf(temp)));
                    sb = new StringBuffer();
                }
                calc(ch);
            }
            // 循环结束  做最终的计算
            if (i == expression.length() - 1) {
                String temp = sb.toString().trim();
                if (!StringUtils.isEmpty(temp)) {
                    numbersStack.push(new NumberExpressionParser(Integer.valueOf(temp)));
                }
                // 全部循环完毕进行最后的计算
                calc(' ');
            }
        }
    }

    private void calc(char operator) {
        // 判断运算优先级
        while (!comparePri(operator) && !symbolsStack.isEmpty()) {

            // 取出操作符合要操作的数据
            IExpressionParser right = numbersStack.pop();
            IExpressionParser left = numbersStack.pop();

            IExpressionParser parser = OperatorUtils.getClassBySymbol(symbolsStack.pop(), left, right);
            numbersStack.push(parser);
        }
        symbolsStack.push(String.valueOf(operator));
        if (Objects.equals(String.valueOf(operator), ")")) {
            symbolsStack.pop();
            symbolsStack.pop();
        }
    }

    public Integer getValue() {
        return this.numbersStack.pop().interpreter();
    }

    private boolean comparePri(char symbolChar) {
        String symbol = String.valueOf(symbolChar);
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
            case " ":
                return false;
            case ")": // 优先级最低
                return false;
            default:
                break;
        }
        return true;
    }

}
