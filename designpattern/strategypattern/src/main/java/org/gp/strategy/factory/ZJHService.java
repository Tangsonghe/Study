package org.gp.strategy.factory;

/**
 * @description: 推送到证监会平台处理
 * @author: Spark_tang
 * @time: 2020/3/15 14:33
 */
public class ZJHService implements ICaseService {
    @Override
    public void pushCase(CaseInfo caseInfo) {
        System.out.print(caseInfo.getDisputeType());
        System.out.println("处理证监会平台处理流程....");
    }
}
