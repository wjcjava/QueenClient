package com.ainisi.queenmirror.queenmirrorcduan.ui.mine.bean;

import java.util.List;

/**
 * Created by john on 2018/6/5.
 */

public class TouchbalanceBean {

    /**
     * success : true
     * errorCode : 0
     * msg : 没有数据
     * body : {"AccountChargeRecords":[{"id":"194e750ef866449f87dc396984537039","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"custId":"1a474a8202e84cc49beb65be3addcf9d","rechargeConsume":"1","businessId":"121","chargeMethod":"2","chargeTrans":"","chargeAmount":null,"chargeDate":"2018-06-05 15:03:07","recordsStatus":"0"}]}
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
        private List<AccountChargeRecordsBean> AccountChargeRecords;

        public List<AccountChargeRecordsBean> getAccountChargeRecords() {
            return AccountChargeRecords;
        }

        public void setAccountChargeRecords(List<AccountChargeRecordsBean> AccountChargeRecords) {
            this.AccountChargeRecords = AccountChargeRecords;
        }

        public static class AccountChargeRecordsBean {
            /**
             * id : 194e750ef866449f87dc396984537039
             * isNewRecord : false
             * remarks : null
             * createDate : null
             * updateDate : null
             * custId : 1a474a8202e84cc49beb65be3addcf9d
             * rechargeConsume : 1
             * businessId : 121
             * chargeMethod : 2
             * chargeTrans :
             * chargeAmount : null
             * chargeDate : 2018-06-05 15:03:07
             * recordsStatus : 0
             */

            private String id;
            private boolean isNewRecord;
            private Object remarks;
            private Object createDate;
            private Object updateDate;
            private String custId;
            private String rechargeConsume;
            private String businessId;
            private String chargeMethod;
            private String chargeTrans;
            private String chargeAmount;
            private String chargeDate;
            private String recordsStatus;

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

            public String getCustId() {
                return custId;
            }

            public void setCustId(String custId) {
                this.custId = custId;
            }

            public String getRechargeConsume() {
                return rechargeConsume;
            }

            public void setRechargeConsume(String rechargeConsume) {
                this.rechargeConsume = rechargeConsume;
            }

            public String getBusinessId() {
                return businessId;
            }

            public void setBusinessId(String businessId) {
                this.businessId = businessId;
            }

            public String getChargeMethod() {
                return chargeMethod;
            }

            public void setChargeMethod(String chargeMethod) {
                this.chargeMethod = chargeMethod;
            }

            public String getChargeTrans() {
                return chargeTrans;
            }

            public void setChargeTrans(String chargeTrans) {
                this.chargeTrans = chargeTrans;
            }

            public String getChargeAmount() {
                return chargeAmount;
            }

            public void setChargeAmount(String chargeAmount) {
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
        }
    }
}
