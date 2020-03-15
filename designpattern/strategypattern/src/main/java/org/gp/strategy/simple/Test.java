package org.gp.strategy.simple;

/**
 * @description:
 * @author: Spark_tang
 * @time: 2020/3/15 14:39
 */
public class Test {
    public static void main(String[] args) {

        CaseInfo caseInfo = new CaseInfo();
        caseInfo.setId("12333355555");
        caseInfo.setCaseNo("（2020）琼01知民初15号");
        caseInfo.setDisputeType("张三和李四的道路交通事故纠纷");

        CaseContext context = new CaseContext(new DaojiaoService(), caseInfo);
        context.push();
    }
}
