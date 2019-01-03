package com.ainisi.queenmirror.queenmirrorcduan.bean;

import java.util.List;

/**
 * Created by john on 2018/8/15.
 */

public class MineQueenCardRecordBean {


    /**
     * success : true
     * errorCode : 0
     * msg : 成功
     * body : {"pageSum":4,"recordsList":[{"id":"dd0ad0e45ea6429ca3a20997ddf898b0","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"custId":"8aafefe862ae0bdc0162ae68207d0786","purchaseDay":0,"activityType":"免费试用","givenDays":30,"businessId":null,"chargeMethod":null,"chargeTrans":null,"chargeAmount":0,"chargeDate":"2018-08-15 13:51:50","recordsStatus":"0","ismember":null,"userName":null,"cellPhone":null,"countDay":0,"beginTime":null,"endTime":null},{"id":"4074ed38b98341da88db4a011ed46fab","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"custId":"8aafefe862ae0bdc0162ae68207d0786","purchaseDay":0,"activityType":"卡密","givenDays":90,"businessId":null,"chargeMethod":null,"chargeTrans":null,"chargeAmount":0,"chargeDate":"2018-08-14 19:14:46","recordsStatus":"0","ismember":null,"userName":null,"cellPhone":null,"countDay":0,"beginTime":null,"endTime":null},{"id":"7c81e4bdd5974e7784e8b43f2871e773","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"custId":"8aafefe862ae0bdc0162ae68207d0786","purchaseDay":0,"activityType":null,"givenDays":7,"businessId":null,"chargeMethod":"2","chargeTrans":"3180814215354820000000000","chargeAmount":15,"chargeDate":null,"recordsStatus":null,"ismember":null,"userName":null,"cellPhone":null,"countDay":0,"beginTime":null,"endTime":null},{"id":"ffd1eb1245b74b2fb72ce0e0488b20a6","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"custId":"8aafefe862ae0bdc0162ae68207d0786","purchaseDay":0,"activityType":null,"givenDays":7,"businessId":null,"chargeMethod":"1","chargeTrans":"3180814215340910000000000","chargeAmount":15,"chargeDate":null,"recordsStatus":null,"ismember":null,"userName":null,"cellPhone":null,"countDay":0,"beginTime":null,"endTime":null}]}
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
        /**
         * pageSum : 4
         * recordsList : [{"id":"dd0ad0e45ea6429ca3a20997ddf898b0","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"custId":"8aafefe862ae0bdc0162ae68207d0786","purchaseDay":0,"activityType":"免费试用","givenDays":30,"businessId":null,"chargeMethod":null,"chargeTrans":null,"chargeAmount":0,"chargeDate":"2018-08-15 13:51:50","recordsStatus":"0","ismember":null,"userName":null,"cellPhone":null,"countDay":0,"beginTime":null,"endTime":null},{"id":"4074ed38b98341da88db4a011ed46fab","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"custId":"8aafefe862ae0bdc0162ae68207d0786","purchaseDay":0,"activityType":"卡密","givenDays":90,"businessId":null,"chargeMethod":null,"chargeTrans":null,"chargeAmount":0,"chargeDate":"2018-08-14 19:14:46","recordsStatus":"0","ismember":null,"userName":null,"cellPhone":null,"countDay":0,"beginTime":null,"endTime":null},{"id":"7c81e4bdd5974e7784e8b43f2871e773","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"custId":"8aafefe862ae0bdc0162ae68207d0786","purchaseDay":0,"activityType":null,"givenDays":7,"businessId":null,"chargeMethod":"2","chargeTrans":"3180814215354820000000000","chargeAmount":15,"chargeDate":null,"recordsStatus":null,"ismember":null,"userName":null,"cellPhone":null,"countDay":0,"beginTime":null,"endTime":null},{"id":"ffd1eb1245b74b2fb72ce0e0488b20a6","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"custId":"8aafefe862ae0bdc0162ae68207d0786","purchaseDay":0,"activityType":null,"givenDays":7,"businessId":null,"chargeMethod":"1","chargeTrans":"3180814215340910000000000","chargeAmount":15,"chargeDate":null,"recordsStatus":null,"ismember":null,"userName":null,"cellPhone":null,"countDay":0,"beginTime":null,"endTime":null}]
         */

        private int pageSum;
        private List<RecordsListBean> recordsList;

        public int getPageSum() {
            return pageSum;
        }

        public void setPageSum(int pageSum) {
            this.pageSum = pageSum;
        }

        public List<RecordsListBean> getRecordsList() {
            return recordsList;
        }

        public void setRecordsList(List<RecordsListBean> recordsList) {
            this.recordsList = recordsList;
        }

        public static class RecordsListBean {
            /**
             * id : dd0ad0e45ea6429ca3a20997ddf898b0
             * isNewRecord : false
             * remarks : null
             * createDate : null
             * updateDate : null
             * startDate : null
             * endDate : null
             * custId : 8aafefe862ae0bdc0162ae68207d0786
             * purchaseDays : 0
             * activityType : 免费试用
             * givenDays : 30
             * businessId : null
             * chargeMethod : null
             * chargeTrans : null
             * chargeAmount : 0.0
             * chargeDate : 2018-08-15 13:51:50
             * recordsStatus : 0
             * ismember : null
             * userName : null
             * cellPhone : null
             * countDay : 0
             * beginTime : null
             * endTime : null
             */

            private String id;
            private boolean isNewRecord;
            private Object remarks;
            private Object createDate;
            private Object updateDate;
            private Object startDate;
            private Object endDate;
            private String custId;
            private int purchaseDays;
            private String activityType;
            private int givenDays;
            private Object businessId;
            private Object chargeMethod;
            private String chargeTrans;
            private double chargeAmount;
            private String chargeDate;
            private String recordsStatus;
            private Object ismember;
            private Object userName;
            private Object cellPhone;
            private int countDay;
            private Object beginTime;
            private Object endTime;

            public String getId() {
                return id;
            }

            public void setId(String id) {
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

            public String getCustId() {
                return custId;
            }

            public void setCustId(String custId) {
                this.custId = custId;
            }

            public int getPurchaseDays() {
                return purchaseDays;
            }

            public void setPurchaseDays(int purchaseDays) {
                this.purchaseDays = purchaseDays;
            }

            public String getActivityType() {
                return activityType;
            }

            public void setActivityType(String activityType) {
                this.activityType = activityType;
            }

            public int getGivenDays() {
                return givenDays;
            }

            public void setGivenDays(int givenDays) {
                this.givenDays = givenDays;
            }

            public Object getBusinessId() {
                return businessId;
            }

            public void setBusinessId(Object businessId) {
                this.businessId = businessId;
            }

            public Object getChargeMethod() {
                return chargeMethod;
            }

            public void setChargeMethod(Object chargeMethod) {
                this.chargeMethod = chargeMethod;
            }

            public String getChargeTrans() {
                return chargeTrans;
            }

            public void setChargeTrans(String chargeTrans) {
                this.chargeTrans = chargeTrans;
            }

            public double getChargeAmount() {
                return chargeAmount;
            }

            public void setChargeAmount(double chargeAmount) {
                this.chargeAmount = chargeAmount;
            }

            public String getChargeDate() {
                return chargeDate;
            }

            public void setChargeDate(String chargeDate) {
                this.chargeDate = chargeDate;
            }

            public String getRecordsStatus() {
                return recordsStatus;
            }

            public void setRecordsStatus(String recordsStatus) {
                this.recordsStatus = recordsStatus;
            }

            public Object getIsmember() {
                return ismember;
            }

            public void setIsmember(Object ismember) {
                this.ismember = ismember;
            }

            public Object getUserName() {
                return userName;
            }

            public void setUserName(Object userName) {
                this.userName = userName;
            }

            public Object getCellPhone() {
                return cellPhone;
            }

            public void setCellPhone(Object cellPhone) {
                this.cellPhone = cellPhone;
            }

            public int getCountDay() {
                return countDay;
            }

            public void setCountDay(int countDay) {
                this.countDay = countDay;
            }

            public Object getBeginTime() {
                return beginTime;
            }

            public void setBeginTime(Object beginTime) {
                this.beginTime = beginTime;
            }

            public Object getEndTime() {
                return endTime;
            }

            public void setEndTime(Object endTime) {
                this.endTime = endTime;
            }
        }
    }
}
