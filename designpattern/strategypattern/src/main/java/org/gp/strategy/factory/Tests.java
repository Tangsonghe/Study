package org.gp.strategy.factory;

/**
 * @description:
 * @author: Spark_tang
 * @time: 2020/3/15 15:02
 */
public class Tests {
    public static void main(String[] args) {

        CaseInfo caseInfo = new CaseInfo();
        caseInfo.setId("12333355555");
        caseInfo.setCaseNo("（2020）琼01知民初15号");
        caseInfo.setDisputeType("张三和李四的道路交通事故纠纷");

        // 道交平台
        ICaseService service = CasePushFactory.get(CasePushFactory.DAOJIAO);
        service.pushCase(caseInfo);

        // 证监会
        caseInfo.setDisputeType("张三和李四的金融纠纷");
        service = CasePushFactory.get(CasePushFactory.ZHENJIANHUI);
        service.pushCase(caseInfo);

        // 调解平台
        caseInfo.setDisputeType("张三和李四的婚姻纠纷");
        service = CasePushFactory.get(CasePushFactory.MEDIATION);
        service.pushCase(caseInfo);
    }
}
