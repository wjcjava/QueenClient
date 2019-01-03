package com.ainisi.queenmirror.queenmirrorcduan.ui.shop.bean;

import java.util.List;

/**
 * Created by john on 2018/5/22.
 */

public class ShopDiscounBean {


    /**
     * success : true
     * errorCode : 0
     * msg : 获取数据成功
     * body : {"CouponListData":[{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"cpCreateInfo":{"id":"3785655fe96b4a67b493468c017bfe57","isNewRecord":false,"remarks":null,"createDate":"2018-06-22 19:26:56","updateDate":"2018-06-22 19:26:56","cpCate":"1","cpScope":"1","cpDiscount":"","cpAgeing":"","cpLimit":"","cpName":"通用券1","cpUsing":"0","cpRemark":"描述描述","shopId":"8def969e17984dbcb13b3751acd21c78","exGoodsIds":"","createTime":"2018-06-22 19:26:56","getFrom":"20180622","getTo":"20180623","createNums":10,"useDays":0,"useFrom":"20180622","useTo":"20180724","goodsId":"","fullCondition":"","reduceAmount":99,"discountRate":null,"getNums":null,"cpStatus":"2","approveBy":null,"approveDate":null,"updatePgm":"","shopName":null,"goodsName":null,"hasGet":0,"hasUse":0},"cpGetRecord":{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"cpId":null,"shopId":null,"goodsId":null,"custId":null,"getTime":null,"useQrcode":null,"getStatus":"1"},"cpNumsRecord":null,"shopAddr":null,"shopName":null}],"CouponListDataItem":[{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"cpCreateInfo":{"id":"1e4fc82e43534b75a0e7c37d20d0e43f","isNewRecord":false,"remarks":null,"createDate":"2018-06-22 18:01:17","updateDate":"2018-06-22 18:01:17","cpCate":"1","cpScope":"2","cpDiscount":"","cpAgeing":"","cpLimit":"","cpName":"理发单品抵扣券","cpUsing":"0","cpRemark":"单品抵扣券描述。","shopId":"8def969e17984dbcb13b3751acd21c78","exGoodsIds":"","createTime":"2018-06-22 18:01:17","getFrom":"20180622","getTo":"20180623","createNums":8,"useDays":0,"useFrom":"20180622","useTo":"20180626","goodsId":"c0470b395f2f47fb90a6cea213c888e7","fullCondition":"","reduceAmount":99.99,"discountRate":null,"getNums":null,"cpStatus":"2","approveBy":null,"approveDate":null,"updatePgm":"","shopName":null,"goodsName":null,"hasGet":0,"hasUse":0},"cpGetRecord":{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"cpId":null,"shopId":null,"goodsId":null,"custId":null,"getTime":null,"useQrcode":null,"getStatus":"1"},"cpNumsRecord":null,"shopAddr":null,"shopName":null}]}
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
        private List<CouponListDataBean> CouponListData;
        private List<CouponListDataItemBean> CouponListDataItem;

        public List<CouponListDataBean> getCouponListData() {
            return CouponListData;
        }

        public void setCouponListData(List<CouponListDataBean> CouponListData) {
            this.CouponListData = CouponListData;
        }

        public List<CouponListDataItemBean> getCouponListDataItem() {
            return CouponListDataItem;
        }

        public void setCouponListDataItem(List<CouponListDataItemBean> CouponListDataItem) {
            this.CouponListDataItem = CouponListDataItem;
        }

        public static class CouponListDataBean {
            /**
             * id : null
             * isNewRecord : true
             * remarks : null
             * createDate : null
             * updateDate : null
             * cpCreateInfo : {"id":"3785655fe96b4a67b493468c017bfe57","isNewRecord":false,"remarks":null,"createDate":"2018-06-22 19:26:56","updateDate":"2018-06-22 19:26:56","cpCate":"1","cpScope":"1","cpDiscount":"","cpAgeing":"","cpLimit":"","cpName":"通用券1","cpUsing":"0","cpRemark":"描述描述","shopId":"8def969e17984dbcb13b3751acd21c78","exGoodsIds":"","createTime":"2018-06-22 19:26:56","getFrom":"20180622","getTo":"20180623","createNums":10,"useDays":0,"useFrom":"20180622","useTo":"20180724","goodsId":"","fullCondition":"","reduceAmount":99,"discountRate":null,"getNums":null,"cpStatus":"2","approveBy":null,"approveDate":null,"updatePgm":"","shopName":null,"goodsName":null,"hasGet":0,"hasUse":0}
             * cpGetRecord : {"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"cpId":null,"shopId":null,"goodsId":null,"custId":null,"getTime":null,"useQrcode":null,"getStatus":"1"}
             * cpNumsRecord : null
             * shopAddr : null
             * shopName : null
             */

            private String id;
            private boolean isNewRecord;
            private String remarks;
            private String createDate;
            private String updateDate;
            private CpCreateInfoBean cpCreateInfo;
            private CpGetRecordBean cpGetRecord;
            private String cpNumsRecord;
            private String shopAddr;
            private String shopName;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public boolean isNewRecord() {
                return isNewRecord;
            }

            public void setNewRecord(boolean newRecord) {
                isNewRecord = newRecord;
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

            public CpCreateInfoBean getCpCreateInfo() {
                return cpCreateInfo;
            }

            public void setCpCreateInfo(CpCreateInfoBean cpCreateInfo) {
                this.cpCreateInfo = cpCreateInfo;
            }

            public CpGetRecordBean getCpGetRecord() {
                return cpGetRecord;
            }

            public void setCpGetRecord(CpGetRecordBean cpGetRecord) {
                this.cpGetRecord = cpGetRecord;
            }

            public String getCpNumsRecord() {
                return cpNumsRecord;
            }

            public void setCpNumsRecord(String cpNumsRecord) {
                this.cpNumsRecord = cpNumsRecord;
            }

            public String getShopAddr() {
                return shopAddr;
            }

            public void setShopAddr(String shopAddr) {
                this.shopAddr = shopAddr;
            }

            public String getShopName() {
                return shopName;
            }

            public void setShopName(String shopName) {
                this.shopName = shopName;
            }

            public static class CpCreateInfoBean {
                /**
                 * id : 3785655fe96b4a67b493468c017bfe57
                 * isNewRecord : false
                 * remarks : null
                 * createDate : 2018-06-22 19:26:56
                 * updateDate : 2018-06-22 19:26:56
                 * cpCate : 1
                 * cpScope : 1
                 * cpDiscount :
                 * cpAgeing :
                 * cpLimit :
                 * cpName : 通用券1
                 * cpUsing : 0
                 * cpRemark : 描述描述
                 * shopId : 8def969e17984dbcb13b3751acd21c78
                 * exGoodsIds :
                 * createTime : 2018-06-22 19:26:56
                 * getFrom : 20180622
                 * getTo : 20180623
                 * createNums : 10
                 * useDays : 0
                 * useFrom : 20180622
                 * useTo : 20180724
                 * goodsId :
                 * fullCondition :
                 * reduceAmount : 99
                 * discountRate : null
                 * getNums : null
                 * cpStatus : 2
                 * approveBy : null
                 * approveDate : null
                 * updatePgm :
                 * shopName : null
                 * goodsName : null
                 * hasGet : 0
                 * hasUse : 0
                 */

                private String id;
                private boolean isNewRecord;
                private String remarks;
                private String createDate;
                private String updateDate;
                private String cpCate;
                private String cpScope;
                private String cpDiscount;
                private String cpAgeing;
                private String cpLimit;
                private String cpName;
                private String cpUsing;
                private String cpRemark;
                private String shopId;
                private String exGoodsIds;
                private String createTime;
                private String getFrom;
                private String getTo;
                private String createNums;
                private String useDays;
                private String useFrom;
                private String useTo;
                private String goodsId;
                private String fullCondition;
                private String reduceAmount;
                private String discountRate;
                private String getNums;
                private String cpStatus;
                private String approveBy;
                private String approveDate;
                private String updatePgm;
                private String shopName;
                private String goodsName;
                private String hasGet;
                private String hasUse;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public boolean isNewRecord() {
                    return isNewRecord;
                }

                public void setNewRecord(boolean newRecord) {
                    isNewRecord = newRecord;
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

                public String getCpCate() {
                    return cpCate;
                }

                public void setCpCate(String cpCate) {
                    this.cpCate = cpCate;
                }

                public String getCpScope() {
                    return cpScope;
                }

                public void setCpScope(String cpScope) {
                    this.cpScope = cpScope;
                }

                public String getCpDiscount() {
                    return cpDiscount;
                }

                public void setCpDiscount(String cpDiscount) {
                    this.cpDiscount = cpDiscount;
                }

                public String getCpAgeing() {
                    return cpAgeing;
                }

                public void setCpAgeing(String cpAgeing) {
                    this.cpAgeing = cpAgeing;
                }

                public String getCpLimit() {
                    return cpLimit;
                }

                public void setCpLimit(String cpLimit) {
                    this.cpLimit = cpLimit;
                }

                public String getCpName() {
                    return cpName;
                }

                public void setCpName(String cpName) {
                    this.cpName = cpName;
                }

                public String getCpUsing() {
                    return cpUsing;
                }

                public void setCpUsing(String cpUsing) {
                    this.cpUsing = cpUsing;
                }

                public String getCpRemark() {
                    return cpRemark;
                }

                public void setCpRemark(String cpRemark) {
                    this.cpRemark = cpRemark;
                }

                public String getShopId() {
                    return shopId;
                }

                public void setShopId(String shopId) {
                    this.shopId = shopId;
                }

                public String getExGoodsIds() {
                    return exGoodsIds;
                }

                public void setExGoodsIds(String exGoodsIds) {
                    this.exGoodsIds = exGoodsIds;
                }

                public String getCreateTime() {
                    return createTime;
                }

                public void setCreateTime(String createTime) {
                    this.createTime = createTime;
                }

                public String getGetFrom() {
                    return getFrom;
                }

                public void setGetFrom(String getFrom) {
                    this.getFrom = getFrom;
                }

                public String getGetTo() {
                    return getTo;
                }

                public void setGetTo(String getTo) {
                    this.getTo = getTo;
                }

                public String getCreateNums() {
                    return createNums;
                }

                public void setCreateNums(String createNums) {
                    this.createNums = createNums;
                }

                public String getUseDays() {
                    return useDays;
                }

                public void setUseDays(String useDays) {
                    this.useDays = useDays;
                }

                public String getUseFrom() {
                    return useFrom;
                }

                public void setUseFrom(String useFrom) {
                    this.useFrom = useFrom;
                }

                public String getUseTo() {
                    return useTo;
                }

                public void setUseTo(String useTo) {
                    this.useTo = useTo;
                }

                public String getGoodsId() {
                    return goodsId;
                }

                public void setGoodsId(String goodsId) {
                    this.goodsId = goodsId;
                }

                public String getFullCondition() {
                    return fullCondition;
                }

                public void setFullCondition(String fullCondition) {
                    this.fullCondition = fullCondition;
                }

                public String getReduceAmount() {
                    return reduceAmount;
                }

                public void setReduceAmount(String reduceAmount) {
                    this.reduceAmount = reduceAmount;
                }

                public String getDiscountRate() {
                    return discountRate;
                }

                public void setDiscountRate(String discountRate) {
                    this.discountRate = discountRate;
                }

                public String getGetNums() {
                    return getNums;
                }

                public void setGetNums(String getNums) {
                    this.getNums = getNums;
                }

                public String getCpStatus() {
                    return cpStatus;
                }

                public void setCpStatus(String cpStatus) {
                    this.cpStatus = cpStatus;
                }

                public String getApproveBy() {
                    return approveBy;
                }

                public void setApproveBy(String approveBy) {
                    this.approveBy = approveBy;
                }

                public String getApproveDate() {
                    return approveDate;
                }

                public void setApproveDate(String approveDate) {
                    this.approveDate = approveDate;
                }

                public String getUpdatePgm() {
                    return updatePgm;
                }

                public void setUpdatePgm(String updatePgm) {
                    this.updatePgm = updatePgm;
                }

                public String getShopName() {
                    return shopName;
                }

                public void setShopName(String shopName) {
                    this.shopName = shopName;
                }

                public String getGoodsName() {
                    return goodsName;
                }

                public void setGoodsName(String goodsName) {
                    this.goodsName = goodsName;
                }

                public String getHasGet() {
                    return hasGet;
                }

                public void setHasGet(String hasGet) {
                    this.hasGet = hasGet;
                }

                public String getHasUse() {
                    return hasUse;
                }

                public void setHasUse(String hasUse) {
                    this.hasUse = hasUse;
                }
            }

            public static class CpGetRecordBean {
                /**
                 * id : null
                 * isNewRecord : true
                 * remarks : null
                 * createDate : null
                 * updateDate : null
                 * cpId : null
                 * shopId : null
                 * goodsId : null
                 * custId : null
                 * getTime : null
                 * useQrcode : null
                 * getStatus : 1
                 */

                private String id;
                private boolean isNewRecord;
                private String remarks;
                private String createDate;
                private String updateDate;
                private String cpId;
                private String shopId;
                private String goodsId;
                private String custId;
                private String getTime;
                private String useQrcode;
                private String getStatus;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public boolean isNewRecord() {
                    return isNewRecord;
                }

                public void setNewRecord(boolean newRecord) {
                    isNewRecord = newRecord;
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

                public String getCpId() {
                    return cpId;
                }

                public void setCpId(String cpId) {
                    this.cpId = cpId;
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

                public String getCustId() {
                    return custId;
                }

                public void setCustId(String custId) {
                    this.custId = custId;
                }

                public String getGetTime() {
                    return getTime;
                }

                public void setGetTime(String getTime) {
                    this.getTime = getTime;
                }

                public String getUseQrcode() {
                    return useQrcode;
                }

                public void setUseQrcode(String useQrcode) {
                    this.useQrcode = useQrcode;
                }

                public String getGetStatus() {
                    return getStatus;
                }

                public void setGetStatus(String getStatus) {
                    this.getStatus = getStatus;
                }
            }
        }

        public static class CouponListDataItemBean {
            /**
             * id : null
             * isNewRecord : true
             * remarks : null
             * createDate : null
             * updateDate : null
             * cpCreateInfo : {"id":"1e4fc82e43534b75a0e7c37d20d0e43f","isNewRecord":false,"remarks":null,"createDate":"2018-06-22 18:01:17","updateDate":"2018-06-22 18:01:17","cpCate":"1","cpScope":"2","cpDiscount":"","cpAgeing":"","cpLimit":"","cpName":"理发单品抵扣券","cpUsing":"0","cpRemark":"单品抵扣券描述。","shopId":"8def969e17984dbcb13b3751acd21c78","exGoodsIds":"","createTime":"2018-06-22 18:01:17","getFrom":"20180622","getTo":"20180623","createNums":8,"useDays":0,"useFrom":"20180622","useTo":"20180626","goodsId":"c0470b395f2f47fb90a6cea213c888e7","fullCondition":"","reduceAmount":99.99,"discountRate":null,"getNums":null,"cpStatus":"2","approveBy":null,"approveDate":null,"updatePgm":"","shopName":null,"goodsName":null,"hasGet":0,"hasUse":0}
             * cpGetRecord : {"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"cpId":null,"shopId":null,"goodsId":null,"custId":null,"getTime":null,"useQrcode":null,"getStatus":"1"}
             * cpNumsRecord : null
             * shopAddr : null
             * shopName : null
             */

            private String id;
            private boolean isNewRecord;
            private String remarks;
            private String createDate;
            private String updateDate;
            private CpCreateInfoBeanX cpCreateInfo;
            private CpGetRecordBeanX cpGetRecord;
            private String cpNumsRecord;
            private String shopAddr;
            private String shopName;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public boolean isNewRecord() {
                return isNewRecord;
            }

            public void setNewRecord(boolean newRecord) {
                isNewRecord = newRecord;
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

            public CpCreateInfoBeanX getCpCreateInfo() {
                return cpCreateInfo;
            }

            public void setCpCreateInfo(CpCreateInfoBeanX cpCreateInfo) {
                this.cpCreateInfo = cpCreateInfo;
            }

            public CpGetRecordBeanX getCpGetRecord() {
                return cpGetRecord;
            }

            public void setCpGetRecord(CpGetRecordBeanX cpGetRecord) {
                this.cpGetRecord = cpGetRecord;
            }

            public String getCpNumsRecord() {
                return cpNumsRecord;
            }

            public void setCpNumsRecord(String cpNumsRecord) {
                this.cpNumsRecord = cpNumsRecord;
            }

            public String getShopAddr() {
                return shopAddr;
            }

            public void setShopAddr(String shopAddr) {
                this.shopAddr = shopAddr;
            }

            public String getShopName() {
                return shopName;
            }

            public void setShopName(String shopName) {
                this.shopName = shopName;
            }

            public static class CpCreateInfoBeanX {
                /**
                 * id : 1e4fc82e43534b75a0e7c37d20d0e43f
                 * isNewRecord : false
                 * remarks : null
                 * createDate : 2018-06-22 18:01:17
                 * updateDate : 2018-06-22 18:01:17
                 * cpCate : 1
                 * cpScope : 2
                 * cpDiscount :
                 * cpAgeing :
                 * cpLimit :
                 * cpName : 理发单品抵扣券
                 * cpUsing : 0
                 * cpRemark : 单品抵扣券描述。
                 * shopId : 8def969e17984dbcb13b3751acd21c78
                 * exGoodsIds :
                 * createTime : 2018-06-22 18:01:17
                 * getFrom : 20180622
                 * getTo : 20180623
                 * createNums : 8
                 * useDays : 0
                 * useFrom : 20180622
                 * useTo : 20180626
                 * goodsId : c0470b395f2f47fb90a6cea213c888e7
                 * fullCondition :
                 * reduceAmount : 99.99
                 * discountRate : null
                 * getNums : null
                 * cpStatus : 2
                 * approveBy : null
                 * approveDate : null
                 * updatePgm :
                 * shopName : null
                 * goodsName : null
                 * hasGet : 0
                 * hasUse : 0
                 */

                private String id;
                private boolean isNewRecord;
                private String remarks;
                private String createDate;
                private String updateDate;
                private String cpCate;
                private String cpScope;
                private String cpDiscount;
                private String cpAgeing;
                private String cpLimit;
                private String cpName;
                private String cpUsing;
                private String cpRemark;
                private String shopId;
                private String exGoodsIds;
                private String createTime;
                private String getFrom;
                private String getTo;
                private String createNums;
                private String useDays;
                private String useFrom;
                private String useTo;
                private String goodsId;
                private String fullCondition;
                private String reduceAmount;
                private String discountRate;
                private String getNums;
                private String cpStatus;
                private String approveBy;
                private String approveDate;
                private String updatePgm;
                private String shopName;
                private String goodsName;
                private String hasGet;
                private String hasUse;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public boolean isNewRecord() {
                    return isNewRecord;
                }

                public void setNewRecord(boolean newRecord) {
                    isNewRecord = newRecord;
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

                public String getCpCate() {
                    return cpCate;
                }

                public void setCpCate(String cpCate) {
                    this.cpCate = cpCate;
                }

                public String getCpScope() {
                    return cpScope;
                }

                public void setCpScope(String cpScope) {
                    this.cpScope = cpScope;
                }

                public String getCpDiscount() {
                    return cpDiscount;
                }

                public void setCpDiscount(String cpDiscount) {
                    this.cpDiscount = cpDiscount;
                }

                public String getCpAgeing() {
                    return cpAgeing;
                }

                public void setCpAgeing(String cpAgeing) {
                    this.cpAgeing = cpAgeing;
                }

                public String getCpLimit() {
                    return cpLimit;
                }

                public void setCpLimit(String cpLimit) {
                    this.cpLimit = cpLimit;
                }

                public String getCpName() {
                    return cpName;
                }

                public void setCpName(String cpName) {
                    this.cpName = cpName;
                }

                public String getCpUsing() {
                    return cpUsing;
                }

                public void setCpUsing(String cpUsing) {
                    this.cpUsing = cpUsing;
                }

                public String getCpRemark() {
                    return cpRemark;
                }

                public void setCpRemark(String cpRemark) {
                    this.cpRemark = cpRemark;
                }

                public String getShopId() {
                    return shopId;
                }

                public void setShopId(String shopId) {
                    this.shopId = shopId;
                }

                public String getExGoodsIds() {
                    return exGoodsIds;
                }

                public void setExGoodsIds(String exGoodsIds) {
                    this.exGoodsIds = exGoodsIds;
                }

                public String getCreateTime() {
                    return createTime;
                }

                public void setCreateTime(String createTime) {
                    this.createTime = createTime;
                }

                public String getGetFrom() {
                    return getFrom;
                }

                public void setGetFrom(String getFrom) {
                    this.getFrom = getFrom;
                }

                public String getGetTo() {
                    return getTo;
                }

                public void setGetTo(String getTo) {
                    this.getTo = getTo;
                }

                public String getCreateNums() {
                    return createNums;
                }

                public void setCreateNums(String createNums) {
                    this.createNums = createNums;
                }

                public String getUseDays() {
                    return useDays;
                }

                public void setUseDays(String useDays) {
                    this.useDays = useDays;
                }

                public String getUseFrom() {
                    return useFrom;
                }

                public void setUseFrom(String useFrom) {
                    this.useFrom = useFrom;
                }

                public String getUseTo() {
                    return useTo;
                }

                public void setUseTo(String useTo) {
                    this.useTo = useTo;
                }

                public String getGoodsId() {
                    return goodsId;
                }

                public void setGoodsId(String goodsId) {
                    this.goodsId = goodsId;
                }

                public String getFullCondition() {
                    return fullCondition;
                }

                public void setFullCondition(String fullCondition) {
                    this.fullCondition = fullCondition;
                }

                public String getReduceAmount() {
                    return reduceAmount;
                }

                public void setReduceAmount(String reduceAmount) {
                    this.reduceAmount = reduceAmount;
                }

                public String getDiscountRate() {
                    return discountRate;
                }

                public void setDiscountRate(String discountRate) {
                    this.discountRate = discountRate;
                }

                public String getGetNums() {
                    return getNums;
                }

                public void setGetNums(String getNums) {
                    this.getNums = getNums;
                }

                public String getCpStatus() {
                    return cpStatus;
                }

                public void setCpStatus(String cpStatus) {
                    this.cpStatus = cpStatus;
                }

                public String getApproveBy() {
                    return approveBy;
                }

                public void setApproveBy(String approveBy) {
                    this.approveBy = approveBy;
                }

                public String getApproveDate() {
                    return approveDate;
                }

                public void setApproveDate(String approveDate) {
                    this.approveDate = approveDate;
                }

                public String getUpdatePgm() {
                    return updatePgm;
                }

                public void setUpdatePgm(String updatePgm) {
                    this.updatePgm = updatePgm;
                }

                public String getShopName() {
                    return shopName;
                }

                public void setShopName(String shopName) {
                    this.shopName = shopName;
                }

                public String getGoodsName() {
                    return goodsName;
                }

                public void setGoodsName(String goodsName) {
                    this.goodsName = goodsName;
                }

                public String getHasGet() {
                    return hasGet;
                }

                public void setHasGet(String hasGet) {
                    this.hasGet = hasGet;
                }

                public String getHasUse() {
                    return hasUse;
                }

                public void setHasUse(String hasUse) {
                    this.hasUse = hasUse;
                }
            }

            public static class CpGetRecordBeanX {
                /**
                 * id : null
                 * isNewRecord : true
                 * remarks : null
                 * createDate : null
                 * updateDate : null
                 * cpId : null
                 * shopId : null
                 * goodsId : null
                 * custId : null
                 * getTime : null
                 * useQrcode : null
                 * getStatus : 1
                 */

                private String id;
                private boolean isNewRecord;
                private String remarks;
                private String createDate;
                private String updateDate;
                private String cpId;
                private String shopId;
                private String goodsId;
                private String custId;
                private String getTime;
                private String useQrcode;
                private String getStatus;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public boolean isNewRecord() {
                    return isNewRecord;
                }

                public void setNewRecord(boolean newRecord) {
                    isNewRecord = newRecord;
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

                public String getCpId() {
                    return cpId;
                }

                public void setCpId(String cpId) {
                    this.cpId = cpId;
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

                public String getCustId() {
                    return custId;
                }

                public void setCustId(String custId) {
                    this.custId = custId;
                }

                public String getGetTime() {
                    return getTime;
                }

                public void setGetTime(String getTime) {
                    this.getTime = getTime;
                }

                public String getUseQrcode() {
                    return useQrcode;
                }

                public void setUseQrcode(String useQrcode) {
                    this.useQrcode = useQrcode;
                }

                public String getGetStatus() {
                    return getStatus;
                }

                public void setGetStatus(String getStatus) {
                    this.getStatus = getStatus;
                }
            }
        }
    }
}