package org.gp.strategy.simple;

/**
 * @description: 推送到道交平台处理
 * @author: Spark_tang
 * @time: 2020/3/15 14:33
 */
public class DaojiaoService implements ICaseService {
    @Override
    public void pushCase(CaseInfo caseInfo) {
        System.out.println(caseInfo);
        System.out.println("推送到道交平台处理....");
    }
}
