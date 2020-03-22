package org.gp.interpreter;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**
 * @description:
 * @author: Spark_tang
 * @time: 2020/3/22 12:54
 */
public class OperatorUtils {

    static Map<String, Class<? extends IExpressionParser>> parserMap = new HashMap<>();

    static {
        parserMap.put("+", AddExpressionParser.class);
        parserMap.put("-", SubExpressionParser.class);
        parserMap.put("*", MultExpressionParser.class);
        parserMap.put("/", DivExpressionParser.class);
        parserMap.put("%", QuotExpressionParser.class);
        parserMap.put("(", null);
        parserMap.put(")", null);
    }

    public static boolean isSymbol(String operaStr) {

        return parserMap.containsKey(operaStr);
    }

    public static boolean isSymbol(char operaStr) {

        return isSymbol(String.valueOf(operaStr));
    }

    public static IExpressionParser getClassBySymbol(String symbol, IExpressionParser left, IExpressionParser right) {
        Class<? extends IExpressionParser> clazz = parserMap.get(symbol);
        try {
            IExpressionParser parser = clazz.getConstructor(IExpressionParser.class, IExpressionParser.class)
                    .newInstance(left, right);
            return parser;
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
