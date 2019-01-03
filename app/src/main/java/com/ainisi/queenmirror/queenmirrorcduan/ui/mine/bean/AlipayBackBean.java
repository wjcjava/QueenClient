package com.ainisi.queenmirror.queenmirrorcduan.ui.mine.bean;

/**
 * Created by jiangchao on 2018/9/13 上午9:54.
 */


public class AlipayBackBean {


    /**
     * success : true
     * errorCode : 1
     * msg : 未查询到订单信息
     * body : {"ansChargeTrans":{"id":"3180913709465220000000000","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"bodyType":"2","bodyId":"5ce75e910007480f9690ca9fd741f871","buyerId":"625***@qq.com","tradeNo":"2018091322001476730536084666","transAmount":0.1,"actualAmount":0.1,"transFee":0,"transType":"7","transChannel":"2","transStatus":"1","transTime":"2018-09-13 09:46:52.0","transChannelName":null,"transStatusName":null,"bodyTypeName":null,"transTimeFrom":null,"transTimeTo":null,"orderNo":null,"shopName":null,"count":0}}
     */

    private boolean success;
    private String errorCode;
    private String msg;
    private BodyEntity body;

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

    public BodyEntity getBody() {
        return body;
    }

    public void setBody(BodyEntity body) {
        this.body = body;
    }

    public static class BodyEntity {
        /**
         * ansChargeTrans : {"id":"3180913709465220000000000","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"bodyType":"2","bodyId":"5ce75e910007480f9690ca9fd741f871","buyerId":"625***@qq.com","tradeNo":"2018091322001476730536084666","transAmount":0.1,"actualAmount":0.1,"transFee":0,"transType":"7","transChannel":"2","transStatus":"1","transTime":"2018-09-13 09:46:52.0","transChannelName":null,"transStatusName":null,"bodyTypeName":null,"transTimeFrom":null,"transTimeTo":null,"orderNo":null,"shopName":null,"count":0}
         */

        private AnsChargeTransEntity ansChargeTrans;

        public AnsChargeTransEntity getAnsChargeTrans() {
            return ansChargeTrans;
        }

        public void setAnsChargeTrans(AnsChargeTransEntity ansChargeTrans) {
            this.ansChargeTrans = ansChargeTrans;
        }

        public static class AnsChargeTransEntity {
            /**
             * id : 3180913709465220000000000
             * isNewRecord : false
             * remarks : null
             * createDate : null
             * updateDate : null
             * startDate : null
             * endDate : null
             * bodyType : 2
             * bodyId : 5ce75e910007480f9690ca9fd741f871
             * buyerId : 625***@qq.com
             * tradeNo : 2018091322001476730536084666
             * transAmount : 0.1
             * actualAmount : 0.1
             * transFee : 0.0
             * transType : 7
             * transChannel : 2
             * transStatus : 1
             * transTime : 2018-09-13 09:46:52.0
             * transChannelName : null
             * transStatusName : null
             * bodyTypeName : null
             * transTimeFrom : null
             * transTimeTo : null
             * orderNo : null
             * shopName : null
             * count : 0
             */

            private String id;
            private boolean isNewRecord;
            private String remarks;
            private String createDate;
            private String updateDate;
            private String startDate;
            private String endDate;
            private String bodyType;
            private String bodyId;
            private String buyerId;
            private String tradeNo;
            private double transAmount;
            private double actualAmount;
            private double transFee;
            private String transType;
            private String transChannel;
            private String transStatus;
            private String transTime;
            private String transChannelName;
            private String transStatusName;
            private String bodyTypeName;
            private String transTimeFrom;
            private String transTimeTo;
            private String orderNo;
            private String shopName;
            private int count;

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

            public String getRemarks() {
                return remarks;
            }

            public void setRemarks(String remarks) {
                this.remarks = remarks;
            }

            public String getCreateDate() {
                return createDate;
            }

            public void setCreateDate(String createDate) {
                this.createDate = createDate;
            }

            public String getUpdateDate() {
                return updateDate;
            }

            public void setUpdateDate(String updateDate) {
                this.updateDate = updateDate;
            }

            public String getStartDate() {
                return startDate;
            }

            public void setStartDate(String startDate) {
                this.startDate = startDate;
            }

            public String getEndDate() {
                return endDate;
            }

            public void setEndDate(String endDate) {
                this.endDate = endDate;
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

            public String getBuyerId() {
                return buyerId;
            }

            public void setBuyerId(String buyerId) {
                this.buyerId = buyerId;
            }

            public String getTradeNo() {
                return tradeNo;
            }

            public void setTradeNo(String tradeNo) {
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

            public String getTransTime() {
                return transTime;
            }

            public void setTransTime(String transTime) {
                this.transTime = transTime;
            }

            public String getTransChannelName() {
                return transChannelName;
            }

            public void setTransChannelName(String transChannelName) {
                this.transChannelName = transChannelName;
            }

            public String getTransStatusName() {
                return transStatusName;
            }

            public void setTransStatusName(String transStatusName) {
                this.transStatusName = transStatusName;
            }

            public String getBodyTypeName() {
                return bodyTypeName;
            }

            public void setBodyTypeName(String bodyTypeName) {
                this.bodyTypeName = bodyTypeName;
            }

            public String getTransTimeFrom() {
                return transTimeFrom;
            }

            public void setTransTimeFrom(String transTimeFrom) {
                this.transTimeFrom = transTimeFrom;
            }

            public String getTransTimeTo() {
                return transTimeTo;
            }

            public void setTransTimeTo(String transTimeTo) {
                this.transTimeTo = transTimeTo;
            }

            public String getOrderNo() {
                return orderNo;
            }

            public void setOrderNo(String orderNo) {
                this.orderNo = orderNo;
            }

            public String getShopName() {
                return shopName;
            }

            public void setShopName(String shopName) {
                this.shopName = shopName;
            }

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }
        }
    }
}
