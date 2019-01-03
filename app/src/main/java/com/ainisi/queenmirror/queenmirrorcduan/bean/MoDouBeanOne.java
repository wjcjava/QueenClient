package com.ainisi.queenmirror.queenmirrorcduan.bean;

import java.util.List;

public class MoDouBeanOne {


    /**
     * success : true
     * errorCode : 0
     * msg : 获取数据成功
     * body : {"pointsChargeSumByMonth":[{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"custId":null,"pointsBusiness":null,"inOut":"1","businessId":null,"chargePoints":null,"chargeDate":null,"recordsStatus":null,"sumPoints":"0"},{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"custId":null,"pointsBusiness":null,"inOut":"2","businessId":null,"chargePoints":null,"chargeDate":null,"recordsStatus":null,"sumPoints":"0"}]}
     */

    private boolean success;
    private String errorCode;
    private String msg;
    private BodyBean body;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public BodyBean getBody() {
        return body;
    }

    public void setBody(BodyBean body) {
        this.body = body;
    }

    public static class BodyBean {
        private List<PointsChargeSumByMonthBean> pointsChargeSumByMonth;

        public List<PointsChargeSumByMonthBean> getPointsChargeSumByMonth() {
            return pointsChargeSumByMonth;
        }

        public void setPointsChargeSumByMonth(List<PointsChargeSumByMonthBean> pointsChargeSumByMonth) {
            this.pointsChargeSumByMonth = pointsChargeSumByMonth;
        }

        public static class PointsChargeSumByMonthBean {
            /**
             * id : null
             * isNewRecord : true
             * remarks : null
             * createDate : null
             * updateDate : null
             * startDate : null
             * endDate : null
             * custId : null
             * pointsBusiness : null
             * inOut : 1
             * businessId : null
             * chargePoints : null
             * chargeDate : null
             * recordsStatus : null
             * sumPoints : 0
             */

            private Object id;
            private boolean isNewRecord;
            private Object remarks;
            private Object createDate;
            private Object updateDate;
            private Object startDate;
            private Object endDate;
            private Object custId;
            private Object pointsBusiness;
            private String inOut;
            private Object businessId;
            private Object chargePoints;
            private Object chargeDate;
            private Object recordsStatus;
            private String sumPoints;

            public Object getId() {
                return id;
            }

            public void setId(Object id) {
                this.id = id;
            }

            public boolean isIsNewRecord() {
                return isNewRecord;
            }

            public void setIsNewRecord(boolean isNewRecord) {
                this.isNewRecord = isNewRecord;
            }

            public Object getRemarks() {
                return remarks;
            }

            public void setRemarks(Object remarks) {
                this.remarks = remarks;
            }

            public Object getCreateDate() {
                return createDate;
            }

            public void setCreateDate(Object createDate) {
                this.createDate = createDate;
            }

            public Object getUpdateDate() {
                return updateDate;
            }

            public void setUpdateDate(Object updateDate) {
                this.updateDate = updateDate;
            }

            public Object getStartDate() {
                return startDate;
            }

            public void setStartDate(Object startDate) {
                this.startDate = startDate;
            }

            public Object getEndDate() {
                return endDate;
            }

            public void setEndDate(Object endDate) {
                this.endDate = endDate;
            }

            public Object getCustId() {
                return custId;
            }

            public void setCustId(Object custId) {
                this.custId = custId;
            }

            public Object getPointsBusiness() {
                return pointsBusiness;
            }

            public void setPointsBusiness(Object pointsBusiness) {
                this.pointsBusiness = pointsBusiness;
            }

            public String getInOut() {
                return inOut;
            }

            public void setInOut(String inOut) {
                this.inOut = inOut;
            }

            public Object getBusinessId() {
                return businessId;
            }

            public void setBusinessId(Object businessId) {
                this.businessId = businessId;
            }

            public Object getChargePoints() {
                return chargePoints;
            }

            public void setChargePoints(Object chargePoints) {
                this.chargePoints = chargePoints;
            }

            public Object getChargeDate() {
                return chargeDate;
            }

            public void setChargeDate(Object chargeDate) {
                this.chargeDate = chargeDate;
            }

            public Object getRecordsStatus() {
                return recordsStatus;
            }

            public void setRecordsStatus(Object recordsStatus) {
                this.recordsStatus = recordsStatus;
            }

            public String getSumPoints() {
                return sumPoints;
            }

            public void setSumPoints(String sumPoints) {
                this.sumPoints = sumPoints;
            }
        }
    }
}