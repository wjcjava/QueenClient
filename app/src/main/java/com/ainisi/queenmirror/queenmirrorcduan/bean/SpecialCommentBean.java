package com.ainisi.queenmirror.queenmirrorcduan.bean;

import java.util.List;

/**
 * Created by john on 2018/9/7.
 *
 * jl
 */

public class SpecialCommentBean {


    /**
     * success : true
     * errorCode : 0
     * msg : 获取数据成功
     * body : {"specialOfferGoodsRecommendedList":[{"id":"2cfb71c98e554ffabcf36c203986cd8b","isNewRecord":false,"remarks":null,"createDate":"2018-06-30 21:55:58","updateDate":"2018-08-31 10:41:20","startDate":null,"endDate":null,"goodsCate":"9003d18c17bd4bb98969a72a4ca553d5","goodsType":"1","goodsName":"小米净化器","goodsNo":"9f3696f82f","goodsBrief":"远离雾霾","goodsSort":0,"serviceTime":"100","goodsDetails":null,"goodsThumb":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018070211432833776980.jpg","goodsPic":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018070211433578888057.jpg,","goodsShow":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018070211432833776980.jpg,","goodsTab":null,"goodsStorage":0,"marketPrice":1000,"salesPrice":800,"goodsActivity":"","goodsBanner":null,"shopId":"97f6494cad0f4c8e9c0dfb62d1f9f50a","saleFlag":"1","ifPoint":"1","pointRule":"c5607f2b403b484fb48742ede8f6eee7","approveBy":null,"approveDate":null,"approveRemarks":null,"startTime":null,"endTime":null,"goodsRemarks":null,"updatePgm":"ApiGoodsController","shopName":null,"saleFlagName":null,"goodsTypeName":null,"goodsCateName":null,"ecPointsRule":null,"buyRule":"1","cityCode":null,"groupGoods":"0","activityId":null,"groupPrice":0,"queenCard":null,"fromPrice":0,"endPrice":0},{"id":"4eaa7e8e0e0e49c4a3747b9edbb79c4f","isNewRecord":false,"remarks":null,"createDate":"2018-07-02 12:07:42","updateDate":"2018-07-02 12:07:46","startDate":null,"endDate":null,"goodsCate":"d93edbd7180246aca91c368b1d64b937","goodsType":"2","goodsName":"鸭子3号","goodsNo":"d2353c1991","goodsBrief":"活好，服务好","goodsSort":0,"serviceTime":"90","goodsDetails":null,"goodsThumb":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018070211432833776980.jpg","goodsPic":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018070211433578888057.jpg,","goodsShow":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018070211432833776980.jpg,","goodsTab":"纹身,","goodsStorage":0,"marketPrice":8888,"salesPrice":100,"goodsActivity":null,"goodsBanner":null,"shopId":"2b0aa3070ea94dff863cbf32b321c801","saleFlag":"2","ifPoint":"0","pointRule":null,"approveBy":null,"approveDate":1530583630000,"approveRemarks":"","startTime":null,"endTime":null,"goodsRemarks":null,"updatePgm":"ApiGoodsController","shopName":null,"saleFlagName":null,"goodsTypeName":null,"goodsCateName":null,"ecPointsRule":null,"buyRule":"1","cityCode":null,"groupGoods":"0","activityId":null,"groupPrice":0,"queenCard":null,"fromPrice":0,"endPrice":0}]}
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
        private List<SpecialOfferGoodsRecommendedListBean> specialOfferGoodsRecommendedList;

        public List<SpecialOfferGoodsRecommendedListBean> getSpecialOfferGoodsRecommendedList() {
            return specialOfferGoodsRecommendedList;
        }

        public void setSpecialOfferGoodsRecommendedList(List<SpecialOfferGoodsRecommendedListBean> specialOfferGoodsRecommendedList) {
            this.specialOfferGoodsRecommendedList = specialOfferGoodsRecommendedList;
        }

        public static class SpecialOfferGoodsRecommendedListBean {
            /**
             * id : 2cfb71c98e554ffabcf36c203986cd8b
             * isNewRecord : false
             * remarks : null
             * createDate : 2018-06-30 21:55:58
             * updateDate : 2018-08-31 10:41:20
             * startDate : null
             * endDate : null
             * goodsCate : 9003d18c17bd4bb98969a72a4ca553d5
             * goodsType : 1
             * goodsName : 小米净化器
             * goodsNo : 9f3696f82f
             * goodsBrief : 远离雾霾
             * goodsSort : 0
             * serviceTime : 100
             * goodsDetails : null
             * goodsThumb : https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018070211432833776980.jpg
             * goodsPic : https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018070211433578888057.jpg,
             * goodsShow : https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018070211432833776980.jpg,
             * goodsTab : null
             * goodsStorage : 0
             * marketPrice : 1000.0
             * salesPrice : 800.0
             * goodsActivity :
             * goodsBanner : null
             * shopId : 97f6494cad0f4c8e9c0dfb62d1f9f50a
             * saleFlag : 1
             * ifPoint : 1
             * pointRule : c5607f2b403b484fb48742ede8f6eee7
             * approveBy : null
             * approveDate : null
             * approveRemarks : null
             * startTime : null
             * endTime : null
             * goodsRemarks : null
             * updatePgm : ApiGoodsController
             * shopName : null
             * saleFlagName : null
             * goodsTypeName : null
             * goodsCateName : null
             * ecPointsRule : null
             * buyRule : 1
             * cityCode : null
             * groupGoods : 0
             * activityId : null
             * groupPrice : 0.0
             * queenCard : null
             * fromPrice : 0.0
             * endPrice : 0.0
             */

            private String id;
            private boolean isNewRecord;
            private Object remarks;
            private String createDate;
            private String updateDate;
            private Object startDate;
            private Object endDate;
            private String goodsCate;
            private String goodsType;
            private String goodsName;
            private String goodsNo;
            private String goodsBrief;
            private int goodsSort;
            private String serviceTime;
            private Object goodsDetails;
            private String goodsThumb;
            private String goodsPic;
            private String goodsShow;
            private Object goodsTab;
            private int goodsStorage;
            private double marketPrice;
            private double salesPrice;
            private String goodsActivity;
            private Object goodsBanner;
            private String shopId;
            private String saleFlag;
            private String ifPoint;
            private String pointRule;
            private Object approveBy;
            private Object approveDate;
            private Object approveRemarks;
            private Object startTime;
            private Object endTime;
            private Object goodsRemarks;
            private String updatePgm;
            private String shopName;
            private Object saleFlagName;
            private Object goodsTypeName;
            private Object goodsCateName;
            private Object ecPointsRule;
            private String buyRule;
            private Object cityCode;
            private String groupGoods;
            private Object activityId;
            private double groupPrice;
            private Object queenCard;
            private double fromPrice;
            private double endPrice;

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

            public String getGoodsNo() {
                return goodsNo;
            }

            public void setGoodsNo(String goodsNo) {
                this.goodsNo = goodsNo;
            }

            public String getGoodsBrief() {
                return goodsBrief;
            }

            public void setGoodsBrief(String goodsBrief) {
                this.goodsBrief = goodsBrief;
            }

            public int getGoodsSort() {
                return goodsSort;
            }

            public void setGoodsSort(int goodsSort) {
                this.goodsSort = goodsSort;
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

            public String getGoodsThumb() {
                return goodsThumb;
            }

            public void setGoodsThumb(String goodsThumb) {
                this.goodsThumb = goodsThumb;
            }

            public String getGoodsPic() {
                return goodsPic;
            }

            public void setGoodsPic(String goodsPic) {
                this.goodsPic = goodsPic;
            }

            public String getGoodsShow() {
                return goodsShow;
            }

            public void setGoodsShow(String goodsShow) {
                this.goodsShow = goodsShow;
            }

            public Object getGoodsTab() {
                return goodsTab;
            }

            public void setGoodsTab(Object goodsTab) {
                this.goodsTab = goodsTab;
            }

            public int getGoodsStorage() {
                return goodsStorage;
            }

            public void setGoodsStorage(int goodsStorage) {
                this.goodsStorage = goodsStorage;
            }

            public double getMarketPrice() {
                return marketPrice;
            }

            public void setMarketPrice(double marketPrice) {
                this.marketPrice = marketPrice;
            }

            public double getSalesPrice() {
                return salesPrice;
            }

            public void setSalesPrice(double salesPrice) {
                this.salesPrice = salesPrice;
            }

            public String getGoodsActivity() {
                return goodsActivity;
            }

            public void setGoodsActivity(String goodsActivity) {
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

            public String getIfPoint() {
                return ifPoint;
            }

            public void setIfPoint(String ifPoint) {
                this.ifPoint = ifPoint;
            }

            public String getPointRule() {
                return pointRule;
            }

            public void setPointRule(String pointRule) {
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

            public Object getStartTime() {
                return startTime;
            }

            public void setStartTime(Object startTime) {
                this.startTime = startTime;
            }

            public Object getEndTime() {
                return endTime;
            }

            public void setEndTime(Object endTime) {
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

            public String getShopName() {
                return shopName;
            }

            public void setShopName(String shopName) {
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

            public Object getGoodsCateName() {
                return goodsCateName;
            }

            public void setGoodsCateName(Object goodsCateName) {
                this.goodsCateName = goodsCateName;
            }

            public Object getEcPointsRule() {
                return ecPointsRule;
            }

            public void setEcPointsRule(Object ecPointsRule) {
                this.ecPointsRule = ecPointsRule;
            }

            public String getBuyRule() {
                return buyRule;
            }

            public void setBuyRule(String buyRule) {
                this.buyRule = buyRule;
            }

            public Object getCityCode() {
                return cityCode;
            }

            public void setCityCode(Object cityCode) {
                this.cityCode = cityCode;
            }

            public String getGroupGoods() {
                return groupGoods;
            }

            public void setGroupGoods(String groupGoods) {
                this.groupGoods = groupGoods;
            }

            public Object getActivityId() {
                return activityId;
            }

            public void setActivityId(Object activityId) {
                this.activityId = activityId;
            }

            public double getGroupPrice() {
                return groupPrice;
            }

            public void setGroupPrice(double groupPrice) {
                this.groupPrice = groupPrice;
            }

            public Object getQueenCard() {
                return queenCard;
            }

            public void setQueenCard(Object queenCard) {
                this.queenCard = queenCard;
            }

            public double getFromPrice() {
                return fromPrice;
            }

            public void setFromPrice(double fromPrice) {
                this.fromPrice = fromPrice;
            }

            public double getEndPrice() {
                return endPrice;
            }

            public void setEndPrice(double endPrice) {
                this.endPrice = endPrice;
            }
        }
    }
}
