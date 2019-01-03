package com.ainisi.queenmirror.queenmirrorcduan.bean;

public class RechargeFreashBean {


    /**
     * success : true
     * errorCode : 0
     * msg : 获取数据成功
     * body : {"ansChargeTrans":{"id":"3180608220180220000000001","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"transTime":"2018-06-08 20:18:02.0","bodyType":"2","bodyId":"6f2f98dc426646f7adf978637e3e077a","buyerId":null,"tradeNo":null,"transAmount":0.01,"actualAmount":0.01,"transFee":0,"transType":"2","transChannel":"2","transStatus":"1"}}
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
         * ansChargeTrans : {"id":"3180608220180220000000001","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"transTime":"2018-06-08 20:18:02.0","bodyType":"2","bodyId":"6f2f98dc426646f7adf978637e3e077a","buyerId":null,"tradeNo":null,"transAmount":0.01,"actualAmount":0.01,"transFee":0,"transType":"2","transChannel":"2","transStatus":"1"}
         */

        private AnsChargeTransBean ansChargeTrans;

        public AnsChargeTransBean getAnsChargeTrans() {
            return ansChargeTrans;
        }

        public void setAnsChargeTrans(AnsChargeTransBean ansChargeTrans) {
            this.ansChargeTrans = ansChargeTrans;
        }

        public static class AnsChargeTransBean {
            /**
             * id : 3180608220180220000000001
             * isNewRecord : false
             * remarks : null
             * createDate : null
             * updateDate : null
             * transTime : 2018-06-08 20:18:02.0
             * bodyType : 2
             * bodyId : 6f2f98dc426646f7adf978637e3e077a
             * buyerId : null
             * tradeNo : null
             * transAmount : 0.01
             * actualAmount : 0.01
             * transFee : 0.0
             * transType : 2
             * transChannel : 2
             * transStatus : 1
             */

            private String id;
            private boolean isNewRecord;
            private Object remarks;
            private Object createDate;
            private Object updateDate;
            private String transTime;
            private String bodyType;
            private String bodyId;
            private Object buyerId;
            private Object tradeNo;
            private double transAmount;
            private double actualAmount;
            private double transFee;
            private String transType;
            private String transChannel;
            private String transStatus;

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

            public String getTransTime() {
                return transTime;
            }

            public void setTransTime(String transTime) {
                this.transTime = transTime;
            }

            public String getBodyType() {
                return bodyType;
            }

            public void setBodyType(String bodyType) {
                this.bodyType = bodyType;
            }

            public String getBodyId() {
                return bodyId;
            }

            public void setBodyId(String bodyId) {
                this.bodyId = bodyId;
            }

            public Object getBuyerId() {
                return buyerId;
            }

            public void setBuyerId(Object buyerId) {
                this.buyerId = buyerId;
            }

            public Object getTradeNo() {
                return tradeNo;
            }

            public void setTradeNo(Object tradeNo) {
                this.tradeNo = tradeNo;
            }

            public double getTransAmount() {
                return transAmount;
            }

            public void setTransAmount(double transAmount) {
                this.transAmount = transAmount;
            }

            public double getActualAmount() {
                return actualAmount;
            }

            public void setActualAmount(double actualAmount) {
                this.actualAmount = actualAmount;
            }

            public double getTransFee() {
                return transFee;
            }

            public void setTransFee(double transFee) {
                this.transFee = transFee;
            }

            public String getTransType() {
                return transType;
            }

            public void setTransType(String transType) {
                this.transType = transType;
            }

            public String getTransChannel() {
                return transChannel;
            }

            public void setTransChannel(String transChannel) {
                this.transChannel = transChannel;
            }

            public String getTransStatus() {
                return transStatus;
            }

            public void setTransStatus(String transStatus) {
                this.transStatus = transStatus;
            }
        }
    }
}
