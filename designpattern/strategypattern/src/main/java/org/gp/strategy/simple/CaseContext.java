package org.gp.strategy.simple;

/**
 * @description:
 * @author: Spark_tang
 * @time: 2020/3/15 14:37
 */
public class CaseContext {

    private ICaseService caseService;
    private CaseInfo caseInfo;

    public CaseContext(ICaseService caseService, CaseInfo caseInfo) {
        this.caseService = caseService;
        this.caseInfo = caseInfo;
    }

    public void push() {
        caseService.pushCase(caseInfo);
    }
}
