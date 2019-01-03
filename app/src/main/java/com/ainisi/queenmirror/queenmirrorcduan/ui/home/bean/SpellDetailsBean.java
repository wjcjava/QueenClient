package com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean;

/**
 * Created by john on 2018/6/1.
 */

public class SpellDetailsBean {

    /**
     * success : true
     * errorCode : 0
     * msg : 获取商家拼团信息成功
     * body : {"GroupActivityData":{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"gpActivity":{"id":"123","isNewRecord":false,"remarks":null,"createDate":"2018-04-28 09:12:19","updateDate":"2018-04-28 09:12:19","goodsId":"111","shopId":"1","groupName":"商品大减价","groupBrief":"商品大减价上dengdeng","serviceTime":"12","groupDetails":"zxcvbnmxtcyvubhinj","groupThumb":"大事发生vdv","groupPic":"qd","groupShow":"xasd确定","singlePrice":12.3,"groupPrice":9.4,"groupStart":"2018-03-28 13:22:00","groupEnd":"2018-03-28 15:22:00","groupPeriod":null,"groupNumber":10,"currentNumber":3,"groupStorage":23,"groupStatus":"2","approveBy":"","approveDate":null,"groupSort":1,"groupRemarks":null,"updatePgm":"waesdfgdfsbgnh "},"ecGoodsBasic":{"id":"111","isNewRecord":false,"remarks":null,"createDate":"2018-05-08 10:21:05","updateDate":"2018-05-08 10:21:05","goodsCate":"美发定制","goodsType":"0","goodsName":"测试3","goodsNo":null,"goodsBrief":"啊啊啊啊","serviceTime":"60分钟","goodsDetails":null,"goodsThumb":null,"goodsPic":null,"goodsShow":null,"goodsTab":"美发定制","goodsStorage":null,"goodsPrice":"0.01","offlinePrice":"90.00","marketPrice":null,"salesPrice":"0.01","promotionPrice":null,"goodsActivity":null,"goodsBanner":null,"shopId":"9875411436d64be1a6d7d10c1d2a25cd","saleFlag":"2","ifPoint":null,"pointRule":null,"approveBy":null,"approveDate":null,"approveRemarks":null,"startTime":1525400918000,"endTime":1525400923000,"goodsRemarks":null,"updatePgm":"ApiGoodsController","shopName":null,"saleFlagName":null,"goodsTypeName":null,"ecPointsRule":null},"browses":{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"groupId":null,"browseCounts":0,"enableFlag":null},"contentByTitle":null,"groupStatusLabel":null,"saleFlagLabel":null,"goodsTypeLabel":null}}
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
         * GroupActivityData : {"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"gpActivity":{"id":"123","isNewRecord":false,"remarks":null,"createDate":"2018-04-28 09:12:19","updateDate":"2018-04-28 09:12:19","goodsId":"111","shopId":"1","groupName":"商品大减价","groupBrief":"商品大减价上dengdeng","serviceTime":"12","groupDetails":"zxcvbnmxtcyvubhinj","groupThumb":"大事发生vdv","groupPic":"qd","groupShow":"xasd确定","singlePrice":12.3,"groupPrice":9.4,"groupStart":"2018-03-28 13:22:00","groupEnd":"2018-03-28 15:22:00","groupPeriod":null,"groupNumber":10,"currentNumber":3,"groupStorage":23,"groupStatus":"2","approveBy":"","approveDate":null,"groupSort":1,"groupRemarks":null,"updatePgm":"waesdfgdfsbgnh "},"ecGoodsBasic":{"id":"111","isNewRecord":false,"remarks":null,"createDate":"2018-05-08 10:21:05","updateDate":"2018-05-08 10:21:05","goodsCate":"美发定制","goodsType":"0","goodsName":"测试3","goodsNo":null,"goodsBrief":"啊啊啊啊","serviceTime":"60分钟","goodsDetails":null,"goodsThumb":null,"goodsPic":null,"goodsShow":null,"goodsTab":"美发定制","goodsStorage":null,"goodsPrice":"0.01","offlinePrice":"90.00","marketPrice":null,"salesPrice":"0.01","promotionPrice":null,"goodsActivity":null,"goodsBanner":null,"shopId":"9875411436d64be1a6d7d10c1d2a25cd","saleFlag":"2","ifPoint":null,"pointRule":null,"approveBy":null,"approveDate":null,"approveRemarks":null,"startTime":1525400918000,"endTime":1525400923000,"goodsRemarks":null,"updatePgm":"ApiGoodsController","shopName":null,"saleFlagName":null,"goodsTypeName":null,"ecPointsRule":null},"browses":{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"groupId":null,"browseCounts":0,"enableFlag":null},"contentByTitle":null,"groupStatusLabel":null,"saleFlagLabel":null,"goodsTypeLabel":null}
         */

        private GroupActivityDataBean GroupActivityData;

        public GroupActivityDataBean getGroupActivityData() {
            return GroupActivityData;
        }

        public void setGroupActivityData(GroupActivityDataBean GroupActivityData) {
            this.GroupActivityData = GroupActivityData;
        }

        public static class GroupActivityDataBean {
            /**
             * id : null
             * isNewRecord : true
             * remarks : null
             * createDate : null
             * updateDate : null
             * gpActivity : {"id":"123","isNewRecord":false,"remarks":null,"createDate":"2018-04-28 09:12:19","updateDate":"2018-04-28 09:12:19","goodsId":"111","shopId":"1","groupName":"商品大减价","groupBrief":"商品大减价上dengdeng","serviceTime":"12","groupDetails":"zxcvbnmxtcyvubhinj","groupThumb":"大事发生vdv","groupPic":"qd","groupShow":"xasd确定","singlePrice":12.3,"groupPrice":9.4,"groupStart":"2018-03-28 13:22:00","groupEnd":"2018-03-28 15:22:00","groupPeriod":null,"groupNumber":10,"currentNumber":3,"groupStorage":23,"groupStatus":"2","approveBy":"","approveDate":null,"groupSort":1,"groupRemarks":null,"updatePgm":"waesdfgdfsbgnh "}
             * ecGoodsBasic : {"id":"111","isNewRecord":false,"remarks":null,"createDate":"2018-05-08 10:21:05","updateDate":"2018-05-08 10:21:05","goodsCate":"美发定制","goodsType":"0","goodsName":"测试3","goodsNo":null,"goodsBrief":"啊啊啊啊","serviceTime":"60分钟","goodsDetails":null,"goodsThumb":null,"goodsPic":null,"goodsShow":null,"goodsTab":"美发定制","goodsStorage":null,"goodsPrice":"0.01","offlinePrice":"90.00","marketPrice":null,"salesPrice":"0.01","promotionPrice":null,"goodsActivity":null,"goodsBanner":null,"shopId":"9875411436d64be1a6d7d10c1d2a25cd","saleFlag":"2","ifPoint":null,"pointRule":null,"approveBy":null,"approveDate":null,"approveRemarks":null,"startTime":1525400918000,"endTime":1525400923000,"goodsRemarks":null,"updatePgm":"ApiGoodsController","shopName":null,"saleFlagName":null,"goodsTypeName":null,"ecPointsRule":null}
             * browses : {"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"groupId":null,"browseCounts":0,"enableFlag":null}
             * contentByTitle : null
             * groupStatusLabel : null
             * saleFlagLabel : null
             * goodsTypeLabel : null
             */

            private Object id;
            private boolean isNewRecord;
            private Object remarks;
            private Object createDate;
            private Object updateDate;
            private GpActivityBean gpActivity;
            private EcGoodsBasicBean ecGoodsBasic;
            private BrowsesBean browses;
            private Object contentByTitle;
            private Object groupStatusLabel;
            private Object saleFlagLabel;
            private Object goodsTypeLabel;

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

            public GpActivityBean getGpActivity() {
                return gpActivity;
            }

            public void setGpActivity(GpActivityBean gpActivity) {
                this.gpActivity = gpActivity;
            }

            public EcGoodsBasicBean getEcGoodsBasic() {
                return ecGoodsBasic;
            }

            public void setEcGoodsBasic(EcGoodsBasicBean ecGoodsBasic) {
                this.ecGoodsBasic = ecGoodsBasic;
            }

            public BrowsesBean getBrowses() {
                return browses;
            }

            public void setBrowses(BrowsesBean browses) {
                this.browses = browses;
            }

            public Object getContentByTitle() {
                return contentByTitle;
            }

            public void setContentByTitle(Object contentByTitle) {
                this.contentByTitle = contentByTitle;
            }

            public Object getGroupStatusLabel() {
                return groupStatusLabel;
            }

            public void setGroupStatusLabel(Object groupStatusLabel) {
                this.groupStatusLabel = groupStatusLabel;
            }

            public Object getSaleFlagLabel() {
                return saleFlagLabel;
            }

            public void setSaleFlagLabel(Object saleFlagLabel) {
                this.saleFlagLabel = saleFlagLabel;
            }

            public Object getGoodsTypeLabel() {
                return goodsTypeLabel;
            }

            public void setGoodsTypeLabel(Object goodsTypeLabel) {
                this.goodsTypeLabel = goodsTypeLabel;
            }

            public static class GpActivityBean {
                /**
                 * id : 123
                 * isNewRecord : false
                 * remarks : null
                 * createDate : 2018-04-28 09:12:19
                 * updateDate : 2018-04-28 09:12:19
                 * goodsId : 111
                 * shopId : 1
                 * groupName : 商品大减价
                 * groupBrief : 商品大减价上dengdeng
                 * serviceTime : 12
                 * groupDetails : zxcvbnmxtcyvubhinj
                 * groupThumb : 大事发生vdv
                 * groupPic : qd
                 * groupShow : xasd确定
                 * singlePrice : 12.3
                 * groupPrice : 9.4
                 * groupStart : 2018-03-28 13:22:00
                 * groupEnd : 2018-03-28 15:22:00
                 * groupPeriod : null
                 * groupNumber : 10
                 * currentNumber : 3
                 * groupStorage : 23
                 * groupStatus : 2
                 * approveBy :
                 * approveDate : null
                 * groupSort : 1
                 * groupRemarks : null
                 * updatePgm : waesdfgdfsbgnh
                 */

                private String id;
                private boolean isNewRecord;
                private Object remarks;
                private String createDate;
                private String updateDate;
                private String goodsId;
                private String shopId;
                private String groupName;
                private String groupBrief;
                private String serviceTime;
                private String groupDetails;
                private String groupThumb;
                private String groupPic;
                private String groupShow;
                private double singlePrice;
                private double groupPrice;
                private String groupStart;
                private String groupEnd;
                private Object groupPeriod;
                private int groupNumber;
                private int currentNumber;
                private int groupStorage;
                private String groupStatus;
                private String approveBy;
                private Object approveDate;
                private int groupSort;
                private Object groupRemarks;
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

                public String getGoodsId() {
                    return goodsId;
                }

                public void setGoodsId(String goodsId) {
                    this.goodsId = goodsId;
                }

                public String getShopId() {
                    return shopId;
                }

                public void setShopId(String shopId) {
                    this.shopId = shopId;
                }

                public String getGroupName() {
                    return groupName;
                }

                public void setGroupName(String groupName) {
                    this.groupName = groupName;
                }

                public String getGroupBrief() {
                    return groupBrief;
                }

                public void setGroupBrief(String groupBrief) {
                    this.groupBrief = groupBrief;
                }

                public String getServiceTime() {
                    return serviceTime;
                }

                public void setServiceTime(String serviceTime) {
                    this.serviceTime = serviceTime;
                }

                public String getGroupDetails() {
                    return groupDetails;
                }

                public void setGroupDetails(String groupDetails) {
                    this.groupDetails = groupDetails;
                }

                public String getGroupThumb() {
                    return groupThumb;
                }

                public void setGroupThumb(String groupThumb) {
                    this.groupThumb = groupThumb;
                }

                public String getGroupPic() {
                    return groupPic;
                }

                public void setGroupPic(String groupPic) {
                    this.groupPic = groupPic;
                }

                public String getGroupShow() {
                    return groupShow;
                }

                public void setGroupShow(String groupShow) {
                    this.groupShow = groupShow;
                }

                public double getSinglePrice() {
                    return singlePrice;
                }

                public void setSinglePrice(double singlePrice) {
                    this.singlePrice = singlePrice;
                }

                public double getGroupPrice() {
                    return groupPrice;
                }

                public void setGroupPrice(double groupPrice) {
                    this.groupPrice = groupPrice;
                }

                public String getGroupStart() {
                    return groupStart;
                }

                public void setGroupStart(String groupStart) {
                    this.groupStart = groupStart;
                }

                public String getGroupEnd() {
                    return groupEnd;
                }

                public void setGroupEnd(String groupEnd) {
                    this.groupEnd = groupEnd;
                }

                public Object getGroupPeriod() {
                    return groupPeriod;
                }

                public void setGroupPeriod(Object groupPeriod) {
                    this.groupPeriod = groupPeriod;
                }

                public int getGroupNumber() {
                    return groupNumber;
                }

                public void setGroupNumber(int groupNumber) {
                    this.groupNumber = groupNumber;
                }

                public int getCurrentNumber() {
                    return currentNumber;
                }

                public void setCurrentNumber(int currentNumber) {
                    this.currentNumber = currentNumber;
                }

                public int getGroupStorage() {
                    return groupStorage;
                }

                public void setGroupStorage(int groupStorage) {
                    this.groupStorage = groupStorage;
                }

                public String getGroupStatus() {
                    return groupStatus;
                }

                public void setGroupStatus(String groupStatus) {
                    this.groupStatus = groupStatus;
                }

                public String getApproveBy() {
                    return approveBy;
                }

                public void setApproveBy(String approveBy) {
                    this.approveBy = approveBy;
                }

                public Object getApproveDate() {
                    return approveDate;
                }

                public void setApproveDate(Object approveDate) {
                    this.approveDate = approveDate;
                }

                public int getGroupSort() {
                    return groupSort;
                }

                public void setGroupSort(int groupSort) {
                    this.groupSort = groupSort;
                }

                public Object getGroupRemarks() {
                    return groupRemarks;
                }

                public void setGroupRemarks(Object groupRemarks) {
                    this.groupRemarks = groupRemarks;
                }

                public String getUpdatePgm() {
                    return updatePgm;
                }

                public void setUpdatePgm(String updatePgm) {
                    this.updatePgm = updatePgm;
                }
            }

            public static class EcGoodsBasicBean {
                /**
                 * id : 111
                 * isNewRecord : false
                 * remarks : null
                 * createDate : 2018-05-08 10:21:05
                 * updateDate : 2018-05-08 10:21:05
                 * goodsCate : 美发定制
                 * goodsType : 0
                 * goodsName : 测试3
                 * goodsNo : null
                 * goodsBrief : 啊啊啊啊
                 * serviceTime : 60分钟
                 * goodsDetails : null
                 * goodsThumb : null
                 * goodsPic : null
                 * goodsShow : null
                 * goodsTab : 美发定制
                 * goodsStorage : null
                 * goodsPrice : 0.01
                 * offlinePrice : 90.00
                 * marketPrice : null
                 * salesPrice : 0.01
                 * promotionPrice : null
                 * goodsActivity : null
                 * goodsBanner : null
                 * shopId : 9875411436d64be1a6d7d10c1d2a25cd
                 * saleFlag : 2
                 * ifPoint : null
                 * pointRule : null
                 * approveBy : null
                 * approveDate : null
                 * approveRemarks : null
                 * startTime : 1525400918000
                 * endTime : 1525400923000
                 * goodsRemarks : null
                 * updatePgm : ApiGoodsController
                 * shopName : null
                 * saleFlagName : null
                 * goodsTypeName : null
                 * ecPointsRule : null
                 */

                private String id;
                private boolean isNewRecord;
                private Object remarks;
                private String createDate;
                private String updateDate;
                private String goodsCate;
                private String goodsType;
                private String goodsName;
                private Object goodsNo;
                private String goodsBrief;
                private String serviceTime;
                private Object goodsDetails;
                private Object goodsThumb;
                private Object goodsPic;
                private Object goodsShow;
                private String goodsTab;
                private Object goodsStorage;
                private String goodsPrice;
                private String offlinePrice;
                private Object marketPrice;
                private String salesPrice;
                private Object promotionPrice;
                private Object goodsActivity;
                private Object goodsBanner;
                private String shopId;
                private String saleFlag;
                private Object ifPoint;
                private Object pointRule;
                private Object approveBy;
                private Object approveDate;
                private Object approveRemarks;
                private long startTime;
                private long endTime;
                private Object goodsRemarks;
                private String updatePgm;
                private Object shopName;
                private Object saleFlagName;
                private Object goodsTypeName;
                private Object ecPointsRule;

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

                public String getGoodsCate() {
                    return goodsCate;
                }

                public void setGoodsCate(String goodsCate) {
                    this.goodsCate = goodsCate;
                }

                public String getGoodsType() {
                    return goodsType;
                }

                public void setGoodsType(String goodsType) {
                    this.goodsType = goodsType;
                }

                public String getGoodsName() {
                    return goodsName;
                }

                public void setGoodsName(String goodsName) {
                    this.goodsName = goodsName;
                }

                public Object getGoodsNo() {
                    return goodsNo;
                }

                public void setGoodsNo(Object goodsNo) {
                    this.goodsNo = goodsNo;
                }

                public String getGoodsBrief() {
                    return goodsBrief;
                }

                public void setGoodsBrief(String goodsBrief) {
                    this.goodsBrief = goodsBrief;
                }

                public String getServiceTime() {
                    return serviceTime;
                }

                public void setServiceTime(String serviceTime) {
                    this.serviceTime = serviceTime;
                }

                public Object getGoodsDetails() {
                    return goodsDetails;
                }

                public void setGoodsDetails(Object goodsDetails) {
                    this.goodsDetails = goodsDetails;
                }

                public Object getGoodsThumb() {
                    return goodsThumb;
                }

                public void setGoodsThumb(Object goodsThumb) {
                    this.goodsThumb = goodsThumb;
                }

                public Object getGoodsPic() {
                    return goodsPic;
                }

                public void setGoodsPic(Object goodsPic) {
                    this.goodsPic = goodsPic;
                }

                public Object getGoodsShow() {
                    return goodsShow;
                }

                public void setGoodsShow(Object goodsShow) {
                    this.goodsShow = goodsShow;
                }

                public String getGoodsTab() {
                    return goodsTab;
                }

                public void setGoodsTab(String goodsTab) {
                    this.goodsTab = goodsTab;
                }

                public Object getGoodsStorage() {
                    return goodsStorage;
                }

                public void setGoodsStorage(Object goodsStorage) {
                    this.goodsStorage = goodsStorage;
                }

                public String getGoodsPrice() {
                    return goodsPrice;
                }

                public void setGoodsPrice(String goodsPrice) {
                    this.goodsPrice = goodsPrice;
                }

                public String getOfflinePrice() {
                    return offlinePrice;
                }

                public void setOfflinePrice(String offlinePrice) {
                    this.offlinePrice = offlinePrice;
                }

                public Object getMarketPrice() {
                    return marketPrice;
                }

                public void setMarketPrice(Object marketPrice) {
                    this.marketPrice = marketPrice;
                }

                public String getSalesPrice() {
                    return salesPrice;
                }

                public void setSalesPrice(String salesPrice) {
                    this.salesPrice = salesPrice;
                }

                public Object getPromotionPrice() {
                    return promotionPrice;
                }

                public void setPromotionPrice(Object promotionPrice) {
                    this.promotionPrice = promotionPrice;
                }

                public Object getGoodsActivity() {
                    return goodsActivity;
                }

                public void setGoodsActivity(Object goodsActivity) {
                    this.goodsActivity = goodsActivity;
                }

                public Object getGoodsBanner() {
                    return goodsBanner;
                }

                public void setGoodsBanner(Object goodsBanner) {
                    this.goodsBanner = goodsBanner;
                }

                public String getShopId() {
                    return shopId;
                }

                public void setShopId(String shopId) {
                    this.shopId = shopId;
                }

                public String getSaleFlag() {
                    return saleFlag;
                }

                public void setSaleFlag(String saleFlag) {
                    this.saleFlag = saleFlag;
                }

                public Object getIfPoint() {
                    return ifPoint;
                }

                public void setIfPoint(Object ifPoint) {
                    this.ifPoint = ifPoint;
                }

                public Object getPointRule() {
                    return pointRule;
                }

                public void setPointRule(Object pointRule) {
                    this.pointRule = pointRule;
                }

                public Object getApproveBy() {
                    return approveBy;
                }

                public void setApproveBy(Object approveBy) {
                    this.approveBy = approveBy;
                }

                public Object getApproveDate() {
                    return approveDate;
                }

                public void setApproveDate(Object approveDate) {
                    this.approveDate = approveDate;
                }

                public Object getApproveRemarks() {
                    return approveRemarks;
                }

                public void setApproveRemarks(Object approveRemarks) {
                    this.approveRemarks = approveRemarks;
                }

                public long getStartTime() {
                    return startTime;
                }

                public void setStartTime(long startTime) {
                    this.startTime = startTime;
                }

                public long getEndTime() {
                    return endTime;
                }

                public void setEndTime(long endTime) {
                    this.endTime = endTime;
                }

                public Object getGoodsRemarks() {
                    return goodsRemarks;
                }

                public void setGoodsRemarks(Object goodsRemarks) {
                    this.goodsRemarks = goodsRemarks;
                }

                public String getUpdatePgm() {
                    return updatePgm;
                }

                public void setUpdatePgm(String updatePgm) {
                    this.updatePgm = updatePgm;
                }

                public Object getShopName() {
                    return shopName;
                }

                public void setShopName(Object shopName) {
                    this.shopName = shopName;
                }

                public Object getSaleFlagName() {
                    return saleFlagName;
                }

                public void setSaleFlagName(Object saleFlagName) {
                    this.saleFlagName = saleFlagName;
                }

                public Object getGoodsTypeName() {
                    return goodsTypeName;
                }

                public void setGoodsTypeName(Object goodsTypeName) {
                    this.goodsTypeName = goodsTypeName;
                }

                public Object getEcPointsRule() {
                    return ecPointsRule;
                }

                public void setEcPointsRule(Object ecPointsRule) {
                    this.ecPointsRule = ecPointsRule;
                }
            }

            public static class BrowsesBean {
                /**
                 * id : null
                 * isNewRecord : true
                 * remarks : null
                 * createDate : null
                 * updateDate : null
                 * groupId : null
                 * browseCounts : 0
                 * enableFlag : null
                 */

                private Object id;
                private boolean isNewRecord;
                private Object remarks;
                private Object createDate;
                private Object updateDate;
                private Object groupId;
                private int browseCounts;
                private Object enableFlag;

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

                public Object getGroupId() {
                    return groupId;
                }

                public void setGroupId(Object groupId) {
                    this.groupId = groupId;
                }

                public int getBrowseCounts() {
                    return browseCounts;
                }

                public void setBrowseCounts(int browseCounts) {
                    this.browseCounts = browseCounts;
                }

                public Object getEnableFlag() {
                    return enableFlag;
                }

                public void setEnableFlag(Object enableFlag) {
                    this.enableFlag = enableFlag;
                }
            }
        }
    }
}
