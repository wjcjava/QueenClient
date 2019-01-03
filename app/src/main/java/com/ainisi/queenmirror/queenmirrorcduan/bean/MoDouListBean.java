package com.ainisi.queenmirror.queenmirrorcduan.bean;

import java.io.Serializable;
import java.util.Date;

public class MoDouListBean implements Serializable{
    String custId;
    String pointsBusiness;
    String inOut;
    String businessId;
    int chargePoints;
    Date chargeDate;
    String recordsStatus;
    String sumPoints;

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public String getPointsBusiness() {
        return pointsBusiness;
    }

    public void setPointsBusiness(String pointsBusiness) {
        this.pointsBusiness = pointsBusiness;
    }

    public String getInOut() {
        return inOut;
    }

    public void setInOut(String inOut) {
        this.inOut = inOut;
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public int getChargePoints() {
        return chargePoints;
    }

    public void setChargePoints(int chargePoints) {
        this.chargePoints = chargePoints;
    }

    public Date getChargeDate() {
        return chargeDate;
    }

    public void setChargeDate(Date chargeDate) {
        this.chargeDate = chargeDate;
    }

    public String getRecordsStatus() {
        return recordsStatus;
    }

    public void setRecordsStatus(String recordsStatus) {
        this.recordsStatus = recordsStatus;
    }

    public String getSumPoints() {
        return sumPoints;
    }

    public void setSumPoints(String sumPoints) {
        this.sumPoints = sumPoints;
    }
}
