package org.gp.strategy.factory;

/**
 * @description: 案件信息
 * @author: Spark_tang
 * @time: 2020/3/15 14:41
 */
public class CaseInfo {

    private String id;

    private String caseTitle;

    private String caseNo;

    private String disputeType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCaseTitle() {
        return caseTitle;
    }

    public void setCaseTitle(String caseTitle) {
        this.caseTitle = caseTitle;
    }

    public String getCaseNo() {
        return caseNo;
    }

    public void setCaseNo(String caseNo) {
        this.caseNo = caseNo;
    }

    public String getDisputeType() {
        return disputeType;
    }

    public void setDisputeType(String disputeType) {
        this.disputeType = disputeType;
    }

    @Override
    public String toString() {
        return "案件信息: {" +
                "id='" + id + '\'' +
                ", caseTitle='" + caseTitle + '\'' +
                ", caseNo='" + caseNo + '\'' +
                ", disputeType='" + disputeType + '\'' +
                '}';
    }
}
