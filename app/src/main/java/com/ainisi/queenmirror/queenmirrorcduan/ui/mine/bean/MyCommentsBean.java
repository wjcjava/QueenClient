package com.ainisi.queenmirror.queenmirrorcduan.ui.mine.bean;

import java.util.List;

/**
 * Created by john on 2018/5/17.
 */

public class MyCommentsBean {

    /**
     * success : true
     * errorCode : 0
     * msg : 获取数据成功
     * body : {"CommentsListData":[{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"ecAppraiseGoods":{"id":"0b7e3c2fa0cb4043bd893e163499b76b","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"custId":"eb651872decc49febc60089b2d4a788c","shopId":"a8636f2073eb4b89841195826ff68d41","goodsId":"2e6d355767bf4dbda0585c3c45c3d3dc","detailId":"babc3a180fa34bd4b66dbbb95365cf5c","ifMatch":null,"employeeAbility":"4","apprDetails":"gghbbb路路通","apprPic":"https://prodr.oss-cn-hangzhou.aliyuncs.com/img/2018-10-08/1538980644009_0_0.jpg,https://prodr.oss-cn-hangzhou.aliyuncs.com/img/2018-10-08/1538980644009_0_1.jpg","ifAnon":"1","apprLevel":null,"apprTime":"2018-10-08 14:37:25"},"ecAppraiseShop":{"id":"1fb51a02afac40a89be0a0699419d185","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"custId":"eb651872decc49febc60089b2d4a788c","shopId":"a8636f2073eb4b89841195826ff68d41","orderId":"5d15c98116014e298f739fcf4bb30bd8","serviceAttitude":"4","shopEnvironment":"4","employeeAbility":null,"apprTime":"2018-10-08 14:37:25"},"ansOrderDetails":{"id":"babc3a180fa34bd4b66dbbb95365cf5c","isNewRecord":false,"remarks":null,"createDate":"2018-10-08 14:34:33","updateDate":"2018-10-08 14:34:33","startDate":null,"endDate":null,"orderId":"5d15c98116014e298f739fcf4bb30bd8","goodsId":"2e6d355767bf4dbda0585c3c45c3d3dc","goodsName":"单品1","unitPrice":10,"purchaseNumber":1,"sumAmount":10,"memberDiscount":0,"redPacketDiscount":0,"couponDiscount":0,"cpAmount":0,"discountAmount":null,"usePoints":0,"afterAmount":10,"consumeQrcode":null,"detailsRemarks":null,"detailsStatus":null,"updatePgm":"apiOrderService"},"ecShopScore":null,"goodsIdName":"单品1","custIdName":"15050494634","custHeadPic":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/img/2018-10-08/1538975090240.jpg","shopIdName":"种太阳","ifMatchLabel":null,"employeeAbilityLabel":null,"ifAnonLabel":null,"serviceAttitudeLabel":null,"shopEnvironmentLabel":null,"goodsAppraiseLabel":null,"shopAppraiseLabel":null,"apiEcAppraiseReplyList":null}],"pageSum":2}
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
         * CommentsListData : [{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"ecAppraiseGoods":{"id":"0b7e3c2fa0cb4043bd893e163499b76b","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"custId":"eb651872decc49febc60089b2d4a788c","shopId":"a8636f2073eb4b89841195826ff68d41","goodsId":"2e6d355767bf4dbda0585c3c45c3d3dc","detailId":"babc3a180fa34bd4b66dbbb95365cf5c","ifMatch":null,"employeeAbility":"4","apprDetails":"gghbbb路路通","apprPic":"https://prodr.oss-cn-hangzhou.aliyuncs.com/img/2018-10-08/1538980644009_0_0.jpg,https://prodr.oss-cn-hangzhou.aliyuncs.com/img/2018-10-08/1538980644009_0_1.jpg","ifAnon":"1","apprLevel":null,"apprTime":"2018-10-08 14:37:25"},"ecAppraiseShop":{"id":"1fb51a02afac40a89be0a0699419d185","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"custId":"eb651872decc49febc60089b2d4a788c","shopId":"a8636f2073eb4b89841195826ff68d41","orderId":"5d15c98116014e298f739fcf4bb30bd8","serviceAttitude":"4","shopEnvironment":"4","employeeAbility":null,"apprTime":"2018-10-08 14:37:25"},"ansOrderDetails":{"id":"babc3a180fa34bd4b66dbbb95365cf5c","isNewRecord":false,"remarks":null,"createDate":"2018-10-08 14:34:33","updateDate":"2018-10-08 14:34:33","startDate":null,"endDate":null,"orderId":"5d15c98116014e298f739fcf4bb30bd8","goodsId":"2e6d355767bf4dbda0585c3c45c3d3dc","goodsName":"单品1","unitPrice":10,"purchaseNumber":1,"sumAmount":10,"memberDiscount":0,"redPacketDiscount":0,"couponDiscount":0,"cpAmount":0,"discountAmount":null,"usePoints":0,"afterAmount":10,"consumeQrcode":null,"detailsRemarks":null,"detailsStatus":null,"updatePgm":"apiOrderService"},"ecShopScore":null,"goodsIdName":"单品1","custIdName":"15050494634","custHeadPic":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/img/2018-10-08/1538975090240.jpg","shopIdName":"种太阳","ifMatchLabel":null,"employeeAbilityLabel":null,"ifAnonLabel":null,"serviceAttitudeLabel":null,"shopEnvironmentLabel":null,"goodsAppraiseLabel":null,"shopAppraiseLabel":null,"apiEcAppraiseReplyList":null}]
         * pageSum : 2
         */

        private int pageSum;
        private List<CommentsListDataBean> CommentsListData;

        public int getPageSum() {
            return pageSum;
        }

        public void setPageSum(int pageSum) {
            this.pageSum = pageSum;
        }

        public List<CommentsListDataBean> getCommentsListData() {
            return CommentsListData;
        }

        public void setCommentsListData(List<CommentsListDataBean> CommentsListData) {
            this.CommentsListData = CommentsListData;
        }

        public static class CommentsListDataBean {
            /**
             * id : null
             * isNewRecord : true
             * remarks : null
             * createDate : null
             * updateDate : null
             * startDate : null
             * endDate : null
             * ecAppraiseGoods : {"id":"0b7e3c2fa0cb4043bd893e163499b76b","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"custId":"eb651872decc49febc60089b2d4a788c","shopId":"a8636f2073eb4b89841195826ff68d41","goodsId":"2e6d355767bf4dbda0585c3c45c3d3dc","detailId":"babc3a180fa34bd4b66dbbb95365cf5c","ifMatch":null,"employeeAbility":"4","apprDetails":"gghbbb路路通","apprPic":"https://prodr.oss-cn-hangzhou.aliyuncs.com/img/2018-10-08/1538980644009_0_0.jpg,https://prodr.oss-cn-hangzhou.aliyuncs.com/img/2018-10-08/1538980644009_0_1.jpg","ifAnon":"1","apprLevel":null,"apprTime":"2018-10-08 14:37:25"}
             * ecAppraiseShop : {"id":"1fb51a02afac40a89be0a0699419d185","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"custId":"eb651872decc49febc60089b2d4a788c","shopId":"a8636f2073eb4b89841195826ff68d41","orderId":"5d15c98116014e298f739fcf4bb30bd8","serviceAttitude":"4","shopEnvironment":"4","employeeAbility":null,"apprTime":"2018-10-08 14:37:25"}
             * ansOrderDetails : {"id":"babc3a180fa34bd4b66dbbb95365cf5c","isNewRecord":false,"remarks":null,"createDate":"2018-10-08 14:34:33","updateDate":"2018-10-08 14:34:33","startDate":null,"endDate":null,"orderId":"5d15c98116014e298f739fcf4bb30bd8","goodsId":"2e6d355767bf4dbda0585c3c45c3d3dc","goodsName":"单品1","unitPrice":10,"purchaseNumber":1,"sumAmount":10,"memberDiscount":0,"redPacketDiscount":0,"couponDiscount":0,"cpAmount":0,"discountAmount":null,"usePoints":0,"afterAmount":10,"consumeQrcode":null,"detailsRemarks":null,"detailsStatus":null,"updatePgm":"apiOrderService"}
             * ecShopScore : null
             * goodsIdName : 单品1
             * custIdName : 15050494634
             * custHeadPic : https://nwptest.oss-cn-hangzhou.aliyuncs.com/img/2018-10-08/1538975090240.jpg
             * shopIdName : 种太阳
             * ifMatchLabel : null
             * employeeAbilityLabel : null
             * ifAnonLabel : null
             * serviceAttitudeLabel : null
             * shopEnvironmentLabel : null
             * goodsAppraiseLabel : null
             * shopAppraiseLabel : null
             * apiEcAppraiseReplyList : null
             */

            private Object id;
            private boolean isNewRecord;
            private Object remarks;
            private Object createDate;
            private Object updateDate;
            private Object startDate;
            private Object endDate;
            private EcAppraiseGoodsBean ecAppraiseGoods;
            private EcAppraiseShopBean ecAppraiseShop;
            private AnsOrderDetailsBean ansOrderDetails;
            private Object ecShopScore;
            private String goodsIdName;
            private String custIdName;
            private String custHeadPic;
            private String shopIdName;
            private Object ifMatchLabel;
            private Object employeeAbilityLabel;
            private Object ifAnonLabel;
            private Object serviceAttitudeLabel;
            private Object shopEnvironmentLabel;
            private Object goodsAppraiseLabel;
            private Object shopAppraiseLabel;
            private Object apiEcAppraiseReplyList;

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

            public EcAppraiseGoodsBean getEcAppraiseGoods() {
                return ecAppraiseGoods;
            }

            public void setEcAppraiseGoods(EcAppraiseGoodsBean ecAppraiseGoods) {
                this.ecAppraiseGoods = ecAppraiseGoods;
            }

            public EcAppraiseShopBean getEcAppraiseShop() {
                return ecAppraiseShop;
            }

            public void setEcAppraiseShop(EcAppraiseShopBean ecAppraiseShop) {
                this.ecAppraiseShop = ecAppraiseShop;
            }

            public AnsOrderDetailsBean getAnsOrderDetails() {
                return ansOrderDetails;
            }

            public void setAnsOrderDetails(AnsOrderDetailsBean ansOrderDetails) {
                this.ansOrderDetails = ansOrderDetails;
            }

            public Object getEcShopScore() {
                return ecShopScore;
            }

            public void setEcShopScore(Object ecShopScore) {
                this.ecShopScore = ecShopScore;
            }

            public String getGoodsIdName() {
                return goodsIdName;
            }

            public void setGoodsIdName(String goodsIdName) {
                this.goodsIdName = goodsIdName;
            }

            public String getCustIdName() {
                return custIdName;
            }

            public void setCustIdName(String custIdName) {
                this.custIdName = custIdName;
            }

            public String getCustHeadPic() {
                return custHeadPic;
            }

            public void setCustHeadPic(String custHeadPic) {
                this.custHeadPic = custHeadPic;
            }

            public String getShopIdName() {
                return shopIdName;
            }

            public void setShopIdName(String shopIdName) {
                this.shopIdName = shopIdName;
            }

            public Object getIfMatchLabel() {
                return ifMatchLabel;
            }

            public void setIfMatchLabel(Object ifMatchLabel) {
                this.ifMatchLabel = ifMatchLabel;
            }

            public Object getEmployeeAbilityLabel() {
                return employeeAbilityLabel;
            }

            public void setEmployeeAbilityLabel(Object employeeAbilityLabel) {
                this.employeeAbilityLabel = employeeAbilityLabel;
            }

            public Object getIfAnonLabel() {
                return ifAnonLabel;
            }

            public void setIfAnonLabel(Object ifAnonLabel) {
                this.ifAnonLabel = ifAnonLabel;
            }

            public Object getServiceAttitudeLabel() {
                return serviceAttitudeLabel;
            }

            public void setServiceAttitudeLabel(Object serviceAttitudeLabel) {
                this.serviceAttitudeLabel = serviceAttitudeLabel;
            }

            public Object getShopEnvironmentLabel() {
                return shopEnvironmentLabel;
            }

            public void setShopEnvironmentLabel(Object shopEnvironmentLabel) {
                this.shopEnvironmentLabel = shopEnvironmentLabel;
            }

            public Object getGoodsAppraiseLabel() {
                return goodsAppraiseLabel;
            }

            public void setGoodsAppraiseLabel(Object goodsAppraiseLabel) {
                this.goodsAppraiseLabel = goodsAppraiseLabel;
            }

            public Object getShopAppraiseLabel() {
                return shopAppraiseLabel;
            }

            public void setShopAppraiseLabel(Object shopAppraiseLabel) {
                this.shopAppraiseLabel = shopAppraiseLabel;
            }

            public Object getApiEcAppraiseReplyList() {
                return apiEcAppraiseReplyList;
            }

            public void setApiEcAppraiseReplyList(Object apiEcAppraiseReplyList) {
                this.apiEcAppraiseReplyList = apiEcAppraiseReplyList;
            }

            public static class EcAppraiseGoodsBean {
                /**
                 * id : 0b7e3c2fa0cb4043bd893e163499b76b
                 * isNewRecord : false
                 * remarks : null
                 * createDate : null
                 * updateDate : null
                 * startDate : null
                 * endDate : null
                 * custId : eb651872decc49febc60089b2d4a788c
                 * shopId : a8636f2073eb4b89841195826ff68d41
                 * goodsId : 2e6d355767bf4dbda0585c3c45c3d3dc
                 * detailId : babc3a180fa34bd4b66dbbb95365cf5c
                 * ifMatch : null
                 * employeeAbility : 4
                 * apprDetails : gghbbb路路通
                 * apprPic : https://prodr.oss-cn-hangzhou.aliyuncs.com/img/2018-10-08/1538980644009_0_0.jpg,https://prodr.oss-cn-hangzhou.aliyuncs.com/img/2018-10-08/1538980644009_0_1.jpg
                 * ifAnon : 1
                 * apprLevel : null
                 * apprTime : 2018-10-08 14:37:25
                 */

                private String id;
                private boolean isNewRecord;
                private Object remarks;
                private Object createDate;
                private Object updateDate;
                private Object startDate;
                private Object endDate;
                private String custId;
                private String shopId;
                private String goodsId;
                private String detailId;
                private Object ifMatch;
                private String employeeAbility;
                private String apprDetails;
                private String apprPic;
                private String ifAnon;
                private Object apprLevel;
                private String apprTime;

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

                public String getShopId() {
                    return shopId;
                }

                public void setShopId(String shopId) {
                    this.shopId = shopId;
                }

                public String getGoodsId() {
                    return goodsId;
                }

                public void setGoodsId(String goodsId) {
                    this.goodsId = goodsId;
                }

                public String getDetailId() {
                    return detailId;
                }

                public void setDetailId(String detailId) {
                    this.detailId = detailId;
                }

                public Object getIfMatch() {
                    return ifMatch;
                }

                public void setIfMatch(Object ifMatch) {
                    this.ifMatch = ifMatch;
                }

                public String getEmployeeAbility() {
                    return employeeAbility;
                }

                public void setEmployeeAbility(String employeeAbility) {
                    this.employeeAbility = employeeAbility;
                }

                public String getApprDetails() {
                    return apprDetails;
                }

                public void setApprDetails(String apprDetails) {
                    this.apprDetails = apprDetails;
                }

                public String getApprPic() {
                    return apprPic;
                }

                public void setApprPic(String apprPic) {
                    this.apprPic = apprPic;
                }

                public String getIfAnon() {
                    return ifAnon;
                }

                public void setIfAnon(String ifAnon) {
                    this.ifAnon = ifAnon;
                }

                public Object getApprLevel() {
                    return apprLevel;
                }

                public void setApprLevel(Object apprLevel) {
                    this.apprLevel = apprLevel;
                }

                public String getApprTime() {
                    return apprTime;
                }

                public void setApprTime(String apprTime) {
                    this.apprTime = apprTime;
                }
            }

            public static class EcAppraiseShopBean {
                /**
                 * id : 1fb51a02afac40a89be0a0699419d185
                 * isNewRecord : false
                 * remarks : null
                 * createDate : null
                 * updateDate : null
                 * startDate : null
                 * endDate : null
                 * custId : eb651872decc49febc60089b2d4a788c
                 * shopId : a8636f2073eb4b89841195826ff68d41
                 * orderId : 5d15c98116014e298f739fcf4bb30bd8
                 * serviceAttitude : 4
                 * shopEnvironment : 4
                 * employeeAbility : null
                 * apprTime : 2018-10-08 14:37:25
                 */

                private String id;
                private boolean isNewRecord;
                private Object remarks;
                private Object createDate;
                private Object updateDate;
                private Object startDate;
                private Object endDate;
                private String custId;
                private String shopId;
                private String orderId;
                private String serviceAttitude;
                private String shopEnvironment;
                private Object employeeAbility;
                private String apprTime;

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

                public String getShopId() {
                    return shopId;
                }

                public void setShopId(String shopId) {
                    this.shopId = shopId;
                }

                public String getOrderId() {
                    return orderId;
                }

                public void setOrderId(String orderId) {
                    this.orderId = orderId;
                }

                public String getServiceAttitude() {
                    return serviceAttitude;
                }

                public void setServiceAttitude(String serviceAttitude) {
                    this.serviceAttitude = serviceAttitude;
                }

                public String getShopEnvironment() {
                    return shopEnvironment;
                }

                public void setShopEnvironment(String shopEnvironment) {
                    this.shopEnvironment = shopEnvironment;
                }

                public Object getEmployeeAbility() {
                    return employeeAbility;
                }

                public void setEmployeeAbility(Object employeeAbility) {
                    this.employeeAbility = employeeAbility;
                }

                public String getApprTime() {
                    return apprTime;
                }

                public void setApprTime(String apprTime) {
                    this.apprTime = apprTime;
                }
            }

            public static class AnsOrderDetailsBean {
                /**
                 * id : babc3a180fa34bd4b66dbbb95365cf5c
                 * isNewRecord : false
                 * remarks : null
                 * createDate : 2018-10-08 14:34:33
                 * updateDate : 2018-10-08 14:34:33
                 * startDate : null
                 * endDate : null
                 * orderId : 5d15c98116014e298f739fcf4bb30bd8
                 * goodsId : 2e6d355767bf4dbda0585c3c45c3d3dc
                 * goodsName : 单品1
                 * unitPrice : 10.0
                 * purchaseNumber : 1
                 * sumAmount : 10.0
                 * memberDiscount : 0.0
                 * redPacketDiscount : 0.0
                 * couponDiscount : 0.0
                 * cpAmount : 0.0
                 * discountAmount : null
                 * usePoints : 0
                 * afterAmount : 10.0
                 * consumeQrcode : null
                 * detailsRemarks : null
                 * detailsStatus : null
                 * updatePgm : apiOrderService
                 */

                private String id;
                private boolean isNewRecord;
                private Object remarks;
                private String createDate;
                private String updateDate;
                private Object startDate;
                private Object endDate;
                private String orderId;
                private String goodsId;
                private String goodsName;
                private double unitPrice;
                private int purchaseNumber;
                private double sumAmount;
                private double memberDiscount;
                private double redPacketDiscount;
                private double couponDiscount;
                private double cpAmount;
                private Object discountAmount;
                private int usePoints;
                private double afterAmount;
                private Object consumeQrcode;
                private Object detailsRemarks;
                private Object detailsStatus;
                private String updatePgm;

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

                public String getOrderId() {
                    return orderId;
                }

                public void setOrderId(String orderId) {
                    this.orderId = orderId;
                }

                public String getGoodsId() {
                    return goodsId;
                }

                public void setGoodsId(String goodsId) {
                    this.goodsId = goodsId;
                }

                public String getGoodsName() {
                    return goodsName;
                }

                public void setGoodsName(String goodsName) {
                    this.goodsName = goodsName;
                }

                public double getUnitPrice() {
                    return unitPrice;
                }

                public void setUnitPrice(double unitPrice) {
                    this.unitPrice = unitPrice;
                }

                public int getPurchaseNumber() {
                    return purchaseNumber;
                }

                public void setPurchaseNumber(int purchaseNumber) {
                    this.purchaseNumber = purchaseNumber;
                }

                public double getSumAmount() {
                    return sumAmount;
                }

                public void setSumAmount(double sumAmount) {
                    this.sumAmount = sumAmount;
                }

                public double getMemberDiscount() {
                    return memberDiscount;
                }

                public void setMemberDiscount(double memberDiscount) {
                    this.memberDiscount = memberDiscount;
                }

                public double getRedPacketDiscount() {
                    return redPacketDiscount;
                }

                public void setRedPacketDiscount(double redPacketDiscount) {
                    this.redPacketDiscount = redPacketDiscount;
                }

                public double getCouponDiscount() {
                    return couponDiscount;
                }

                public void setCouponDiscount(double couponDiscount) {
                    this.couponDiscount = couponDiscount;
                }

                public double getCpAmount() {
                    return cpAmount;
                }

                public void setCpAmount(double cpAmount) {
                    this.cpAmount = cpAmount;
                }

                public Object getDiscountAmount() {
                    return discountAmount;
                }

                public void setDiscountAmount(Object discountAmount) {
                    this.discountAmount = discountAmount;
                }

                public int getUsePoints() {
                    return usePoints;
                }

                public void setUsePoints(int usePoints) {
                    this.usePoints = usePoints;
                }

                public double getAfterAmount() {
                    return afterAmount;
                }

                public void setAfterAmount(double afterAmount) {
                    this.afterAmount = afterAmount;
                }

                public Object getConsumeQrcode() {
                    return consumeQrcode;
                }

                public void setConsumeQrcode(Object consumeQrcode) {
                    this.consumeQrcode = consumeQrcode;
                }

                public Object getDetailsRemarks() {
                    return detailsRemarks;
                }

                public void setDetailsRemarks(Object detailsRemarks) {
                    this.detailsRemarks = detailsRemarks;
                }

                public Object getDetailsStatus() {
                    return detailsStatus;
                }

                public void setDetailsStatus(Object detailsStatus) {
                    this.detailsStatus = detailsStatus;
                }

                public String getUpdatePgm() {
                    return updatePgm;
                }

                public void setUpdatePgm(String updatePgm) {
                    this.updatePgm = updatePgm;
                }
            }
        }
    }
}
