package org.gp.strategy.factory;

/**
 * @description: 推送到自己的平台处理
 * @author: Spark_tang
 * @time: 2020/3/15 14:32
 */
public class MediationService implements ICaseService {
    @Override
    public void pushCase(CaseInfo caseInfo) {
        System.out.print(caseInfo.getDisputeType());
        System.out.println("推送到调解平台处理流程....");
    }
}
