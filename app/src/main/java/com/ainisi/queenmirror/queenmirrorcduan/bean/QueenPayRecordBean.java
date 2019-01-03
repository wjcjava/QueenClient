package com.ainisi.queenmirror.queenmirrorcduan.bean;

import java.util.List;

/**
 * Created by john on 2018/7/6.
 */

public class QueenPayRecordBean {


    /**
     * success : true
     * errorCode : 0
     * msg : 获取数据成功
     * body : {"QueenChargeRecords":[{"id":"16b37a7551e1408489025a6b2158035e","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"custId":"1b44842d74044291b710f925e16781f6","rechargeConsume":"1","giftAmount":0,"businessId":null,"chargeMethod":"1","chargeTrans":"2180630213420610000000000","chargeAmount":0.01,"chargeDate":"2018-06-30 13:42:13","recordsStatus":"0","rechargeRate":null},{"id":"210b344449bf44289487489fdd33c5a0","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"custId":"1b44842d74044291b710f925e16781f6","rechargeConsume":"2","giftAmount":0,"businessId":null,"chargeMethod":"5","chargeTrans":"2180629120593450000000001","chargeAmount":0.01,"chargeDate":"2018-06-29 20:59:34","recordsStatus":"0","rechargeRate":null},{"id":"46658f2e3c7542e6a7f85a6bef164277","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"custId":"1b44842d74044291b710f925e16781f6","rechargeConsume":"1","giftAmount":0,"businessId":null,"chargeMethod":"1","chargeTrans":"2180630212540510000000000","chargeAmount":0.05,"chargeDate":"2018-06-30 12:54:24","recordsStatus":"0","rechargeRate":null},{"id":"6b32e60517a84830917c62fc18e433dd","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"custId":"1b44842d74044291b710f925e16781f6","rechargeConsume":"1","giftAmount":0,"businessId":null,"chargeMethod":"1","chargeTrans":"2180630213472710000000000","chargeAmount":0.01,"chargeDate":"2018-06-30 13:47:33","recordsStatus":"0","rechargeRate":null},{"id":"804050d95c0a42de840cb575358d315d","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"custId":"1b44842d74044291b710f925e16781f6","rechargeConsume":"2","giftAmount":0,"businessId":null,"chargeMethod":"5","chargeTrans":"2180703119532150000000001","chargeAmount":0.01,"chargeDate":"2018-07-03 19:53:21","recordsStatus":"0","rechargeRate":null},{"id":"96ad57165f55450fa092eb4c377099b3","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"custId":"1b44842d74044291b710f925e16781f6","rechargeConsume":"1","giftAmount":0,"businessId":null,"chargeMethod":"1","chargeTrans":"2180630213460710000000000","chargeAmount":0.01,"chargeDate":"2018-06-30 13:46:14","recordsStatus":"0","rechargeRate":null},{"id":"9ee8f59d5634406f8a8716a79ea689d3","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"custId":"1b44842d74044291b710f925e16781f6","rechargeConsume":"2","giftAmount":0,"businessId":null,"chargeMethod":"5","chargeTrans":"3180706110064250000000001","chargeAmount":0.02,"chargeDate":"2018-07-06 10:06:42","recordsStatus":"0","rechargeRate":null},{"id":"bad1cf10be254fbcbfda0d43eeca9a83","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"custId":"1b44842d74044291b710f925e16781f6","rechargeConsume":"1","giftAmount":0,"businessId":null,"chargeMethod":"1","chargeTrans":"2180629220412010000000000","chargeAmount":0.01,"chargeDate":"2018-06-29 20:41:34","recordsStatus":"0","rechargeRate":null},{"id":"c663431643c346d19bebe15908707195","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"custId":"1b44842d74044291b710f925e16781f6","rechargeConsume":"1","giftAmount":0,"businessId":null,"chargeMethod":"2","chargeTrans":"2180630213130720000000000","chargeAmount":0.01,"chargeDate":"2018-06-30 13:13:21","recordsStatus":"0","rechargeRate":null},{"id":"ce785dceddc04996a5d40c731856c6e9","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"custId":"1b44842d74044291b710f925e16781f6","rechargeConsume":"1","giftAmount":0,"businessId":null,"chargeMethod":"2","chargeTrans":"3180706215433220000000000","chargeAmount":0.01,"chargeDate":"2018-07-06 15:43:43","recordsStatus":"0","rechargeRate":null},{"id":"dc391ba3494b4e7492c47322d6e804b1","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"custId":"1b44842d74044291b710f925e16781f6","rechargeConsume":"1","giftAmount":0,"businessId":null,"chargeMethod":"2","chargeTrans":"2180630213414820000000000","chargeAmount":0.01,"chargeDate":"2018-06-30 13:41:53","recordsStatus":"0","rechargeRate":null},{"id":"f291293b88c8479abebf375aa54d7a2d","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"custId":"1b44842d74044291b710f925e16781f6","rechargeConsume":"1","giftAmount":0,"businessId":null,"chargeMethod":"2","chargeTrans":"2180630213114720000000000","chargeAmount":0.05,"chargeDate":"2018-06-30 13:11:54","recordsStatus":"0","rechargeRate":null}]}
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
        private List<QueenChargeRecordsBean> QueenChargeRecords;

        public List<QueenChargeRecordsBean> getQueenChargeRecords() {
            return QueenChargeRecords;
        }

        public void setQueenChargeRecords(List<QueenChargeRecordsBean> QueenChargeRecords) {
            this.QueenChargeRecords = QueenChargeRecords;
        }

        public static class QueenChargeRecordsBean {
            /**
             * id : 16b37a7551e1408489025a6b2158035e
             * isNewRecord : false
             * remarks : null
             * createDate : null
             * updateDate : null
             * startDate : null
             * endDate : null
             * custId : 1b44842d74044291b710f925e16781f6
             * rechargeConsume : 1
             * giftAmount : 0
             * businessId : null
             * chargeMethod : 1
             * chargeTrans : 2180630213420610000000000
             * chargeAmount : 0.01
             * chargeDate : 2018-06-30 13:42:13
             * recordsStatus : 0
             * rechargeRate : null
             */

            private String id;
            private boolean isNewRecord;
            private Object remarks;
            private Object createDate;
            private Object updateDate;
            private Object startDate;
            private Object endDate;
            private String custId;
            private String rechargeConsume;
            private int giftAmount;
            private Object businessId;
            private String chargeMethod;
            private String chargeTrans;
            private double chargeAmount;
            private String chargeDate;
            private String recordsStatus;
            private Object rechargeRate;

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

            public String getRechargeConsume() {
                return rechargeConsume;
            }

            public void setRechargeConsume(String rechargeConsume) {
                this.rechargeConsume = rechargeConsume;
            }

            public int getGiftAmount() {
                return giftAmount;
            }

            public void setGiftAmount(int giftAmount) {
                this.giftAmount = giftAmount;
            }

            public Object getBusinessId() {
                return businessId;
            }

            public void setBusinessId(Object businessId) {
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

            public Object getRechargeRate() {
                return rechargeRate;
            }

            public void setRechargeRate(Object rechargeRate) {
                this.rechargeRate = rechargeRate;
            }
        }
    }
}
