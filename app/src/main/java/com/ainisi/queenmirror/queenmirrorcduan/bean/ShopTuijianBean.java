package com.ainisi.queenmirror.queenmirrorcduan.bean;

import java.util.List;

public class ShopTuijianBean {


    /**
     * success : true
     * errorCode : 0
     * msg : 获取数据成功
     * body : {"pageSum":1,"apiEcGoodsBasicList":[{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"ecGoodsBasic":{"id":"a94fef8c0c4a4e25bc065cac1681783c","isNewRecord":false,"remarks":null,"createDate":"2018-07-03 16:36:29","updateDate":"2018-07-03 16:38:33","startDate":null,"endDate":null,"goodsCate":"575a4f781e48405f860f0dc7a7be4b79","goodsType":"2","goodsName":"测试","goodsNo":"c2fa15191f","goodsBrief":"孤独的","goodsSort":123,"serviceTime":"30分钟","goodsDetails":null,"goodsThumb":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/20180703043618087383.jpg","goodsPic":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/201807030436181074158.jpg","goodsShow":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/20180703043618087383.jpg","goodsTab":"手部保养","goodsStorage":0,"marketPrice":0.01,"salesPrice":0.01,"goodsActivity":null,"goodsBanner":null,"shopId":"97f6494cad0f4c8e9c0dfb62d1f9f50a","saleFlag":"2","ifPoint":"0","pointRule":null,"approveBy":null,"approveDate":1530607126000,"approveRemarks":"","startTime":null,"endTime":null,"goodsRemarks":null,"updatePgm":"ApiGoodsController","shopName":null,"saleFlagName":null,"goodsTypeName":null,"goodsCateName":null,"ecPointsRule":null,"buyRule":"0"},"ecGoodsSocre":null,"ansShopBasic":null,"ecGoodsBrowses":{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"goodsId":null,"browseCounts":0,"enableFlag":null},"ansCustCollection":null,"ecPointsRule":null,"goodsTabLabel":null,"goodsCateName":null,"goodsTypeLabel":null,"shopIdName":null,"saleFlagLabel":null,"contentByTitle":null,"goodsAppraiseLabel":null,"newFlagLabel":null}]}
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
         * pageSum : 1
         * apiEcGoodsBasicList : [{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"ecGoodsBasic":{"id":"a94fef8c0c4a4e25bc065cac1681783c","isNewRecord":false,"remarks":null,"createDate":"2018-07-03 16:36:29","updateDate":"2018-07-03 16:38:33","startDate":null,"endDate":null,"goodsCate":"575a4f781e48405f860f0dc7a7be4b79","goodsType":"2","goodsName":"测试","goodsNo":"c2fa15191f","goodsBrief":"孤独的","goodsSort":123,"serviceTime":"30分钟","goodsDetails":null,"goodsThumb":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/20180703043618087383.jpg","goodsPic":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/201807030436181074158.jpg","goodsShow":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/20180703043618087383.jpg","goodsTab":"手部保养","goodsStorage":0,"marketPrice":0.01,"salesPrice":0.01,"goodsActivity":null,"goodsBanner":null,"shopId":"97f6494cad0f4c8e9c0dfb62d1f9f50a","saleFlag":"2","ifPoint":"0","pointRule":null,"approveBy":null,"approveDate":1530607126000,"approveRemarks":"","startTime":null,"endTime":null,"goodsRemarks":null,"updatePgm":"ApiGoodsController","shopName":null,"saleFlagName":null,"goodsTypeName":null,"goodsCateName":null,"ecPointsRule":null,"buyRule":"0"},"ecGoodsSocre":null,"ansShopBasic":null,"ecGoodsBrowses":{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"goodsId":null,"browseCounts":0,"enableFlag":null},"ansCustCollection":null,"ecPointsRule":null,"goodsTabLabel":null,"goodsCateName":null,"goodsTypeLabel":null,"shopIdName":null,"saleFlagLabel":null,"contentByTitle":null,"goodsAppraiseLabel":null,"newFlagLabel":null}]
         */

        private int pageSum;
        private List<ApiEcGoodsBasicListBean> apiEcGoodsBasicList;

        public int getPageSum() {
            return pageSum;
        }

        public void setPageSum(int pageSum) {
            this.pageSum = pageSum;
        }

        public List<ApiEcGoodsBasicListBean> getApiEcGoodsBasicList() {
            return apiEcGoodsBasicList;
        }

        public void setApiEcGoodsBasicList(List<ApiEcGoodsBasicListBean> apiEcGoodsBasicList) {
            this.apiEcGoodsBasicList = apiEcGoodsBasicList;
        }

        public static class ApiEcGoodsBasicListBean {
            /**
             * id : null
             * isNewRecord : true
             * remarks : null
             * createDate : null
             * updateDate : null
             * startDate : null
             * endDate : null
             * ecGoodsBasic : {"id":"a94fef8c0c4a4e25bc065cac1681783c","isNewRecord":false,"remarks":null,"createDate":"2018-07-03 16:36:29","updateDate":"2018-07-03 16:38:33","startDate":null,"endDate":null,"goodsCate":"575a4f781e48405f860f0dc7a7be4b79","goodsType":"2","goodsName":"测试","goodsNo":"c2fa15191f","goodsBrief":"孤独的","goodsSort":123,"serviceTime":"30分钟","goodsDetails":null,"goodsThumb":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/20180703043618087383.jpg","goodsPic":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/201807030436181074158.jpg","goodsShow":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/20180703043618087383.jpg","goodsTab":"手部保养","goodsStorage":0,"marketPrice":0.01,"salesPrice":0.01,"goodsActivity":null,"goodsBanner":null,"shopId":"97f6494cad0f4c8e9c0dfb62d1f9f50a","saleFlag":"2","ifPoint":"0","pointRule":null,"approveBy":null,"approveDate":1530607126000,"approveRemarks":"","startTime":null,"endTime":null,"goodsRemarks":null,"updatePgm":"ApiGoodsController","shopName":null,"saleFlagName":null,"goodsTypeName":null,"goodsCateName":null,"ecPointsRule":null,"buyRule":"0"}
             * ecGoodsSocre : null
             * ansShopBasic : null
             * ecGoodsBrowses : {"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"goodsId":null,"browseCounts":0,"enableFlag":null}
             * ansCustCollection : null
             * ecPointsRule : null
             * goodsTabLabel : null
             * goodsCateName : null
             * goodsTypeLabel : null
             * shopIdName : null
             * saleFlagLabel : null
             * contentByTitle : null
             * goodsAppraiseLabel : null
             * newFlagLabel : null
             */

            private Object id;
            private boolean isNewRecord;
            private Object remarks;
            private Object createDate;
            private Object updateDate;
            private Object startDate;
            private Object endDate;
            private EcGoodsBasicBean ecGoodsBasic;
            private Object ecGoodsSocre;
            private Object ansShopBasic;
            private EcGoodsBrowsesBean ecGoodsBrowses;
            private Object ansCustCollection;
            private Object ecPointsRule;
            private Object goodsTabLabel;
            private Object goodsCateName;
            private Object goodsTypeLabel;
            private String shopIdName;
            private Object saleFlagLabel;
            private Object contentByTitle;
            private Object goodsAppraiseLabel;
            private Object newFlagLabel;

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

            public EcGoodsBasicBean getEcGoodsBasic() {
                return ecGoodsBasic;
            }

            public void setEcGoodsBasic(EcGoodsBasicBean ecGoodsBasic) {
                this.ecGoodsBasic = ecGoodsBasic;
            }

            public Object getEcGoodsSocre() {
                return ecGoodsSocre;
            }

            public void setEcGoodsSocre(Object ecGoodsSocre) {
                this.ecGoodsSocre = ecGoodsSocre;
            }

            public Object getAnsShopBasic() {
                return ansShopBasic;
            }

            public void setAnsShopBasic(Object ansShopBasic) {
                this.ansShopBasic = ansShopBasic;
            }

            public EcGoodsBrowsesBean getEcGoodsBrowses() {
                return ecGoodsBrowses;
            }

            public void setEcGoodsBrowses(EcGoodsBrowsesBean ecGoodsBrowses) {
                this.ecGoodsBrowses = ecGoodsBrowses;
            }

            public Object getAnsCustCollection() {
                return ansCustCollection;
            }

            public void setAnsCustCollection(Object ansCustCollection) {
                this.ansCustCollection = ansCustCollection;
            }

            public Object getEcPointsRule() {
                return ecPointsRule;
            }

            public void setEcPointsRule(Object ecPointsRule) {
                this.ecPointsRule = ecPointsRule;
            }

            public Object getGoodsTabLabel() {
                return goodsTabLabel;
            }

            public void setGoodsTabLabel(Object goodsTabLabel) {
                this.goodsTabLabel = goodsTabLabel;
            }

            public Object getGoodsCateName() {
                return goodsCateName;
            }

            public void setGoodsCateName(Object goodsCateName) {
                this.goodsCateName = goodsCateName;
            }

            public Object getGoodsTypeLabel() {
                return goodsTypeLabel;
            }

            public void setGoodsTypeLabel(Object goodsTypeLabel) {
                this.goodsTypeLabel = goodsTypeLabel;
            }

            public String getShopIdName() {
                return shopIdName;
            }

            public void setShopIdName(String shopIdName) {
                this.shopIdName = shopIdName;
            }

            public Object getSaleFlagLabel() {
                return saleFlagLabel;
            }

            public void setSaleFlagLabel(Object saleFlagLabel) {
                this.saleFlagLabel = saleFlagLabel;
            }

            public Object getContentByTitle() {
                return contentByTitle;
            }

            public void setContentByTitle(Object contentByTitle) {
                this.contentByTitle = contentByTitle;
            }

            public Object getGoodsAppraiseLabel() {
                return goodsAppraiseLabel;
            }

            public void setGoodsAppraiseLabel(Object goodsAppraiseLabel) {
                this.goodsAppraiseLabel = goodsAppraiseLabel;
            }

            public Object getNewFlagLabel() {
                return newFlagLabel;
            }

            public void setNewFlagLabel(Object newFlagLabel) {
                this.newFlagLabel = newFlagLabel;
            }

            public static class EcGoodsBasicBean {
                /**
                 * id : a94fef8c0c4a4e25bc065cac1681783c
                 * isNewRecord : false
                 * remarks : null
                 * createDate : 2018-07-03 16:36:29
                 * updateDate : 2018-07-03 16:38:33
                 * startDate : null
                 * endDate : null
                 * goodsCate : 575a4f781e48405f860f0dc7a7be4b79
                 * goodsType : 2
                 * goodsName : 测试
                 * goodsNo : c2fa15191f
                 * goodsBrief : 孤独的
                 * goodsSort : 123
                 * serviceTime : 30分钟
                 * goodsDetails : null
                 * goodsThumb : https://nwptest.oss-cn-hangzhou.aliyuncs.com/20180703043618087383.jpg
                 * goodsPic : https://nwptest.oss-cn-hangzhou.aliyuncs.com/201807030436181074158.jpg
                 * goodsShow : https://nwptest.oss-cn-hangzhou.aliyuncs.com/20180703043618087383.jpg
                 * goodsTab : 手部保养
                 * goodsStorage : 0
                 * marketPrice : 0.01
                 * salesPrice : 0.01
                 * goodsActivity : null
                 * goodsBanner : null
                 * shopId : 97f6494cad0f4c8e9c0dfb62d1f9f50a
                 * saleFlag : 2
                 * ifPoint : 0
                 * pointRule : null
                 * approveBy : null
                 * approveDate : 1530607126000
                 * approveRemarks :
                 * startTime : null
                 * endTime : null
                 * goodsRemarks : null
                 * updatePgm : ApiGoodsController
                 * shopName : null
                 * saleFlagName : null
                 * goodsTypeName : null
                 * goodsCateName : null
                 * ecPointsRule : null
                 * buyRule : 0
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
                private String goodsTab;
                private int goodsStorage;
                private double marketPrice;
                private double salesPrice;
                private Object goodsActivity;
                private Object goodsBanner;
                private String shopId;
                private String saleFlag;
                private String ifPoint;
                private Object pointRule;
                private Object approveBy;
                private long approveDate;
                private String approveRemarks;
                private Object startTime;
                private Object endTime;
                private Object goodsRemarks;
                private String updatePgm;
                private Object shopName;
                private Object saleFlagName;
                private Object goodsTypeName;
                private Object goodsCateName;
                private Object ecPointsRule;
                private String buyRule;

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

                public String getGoodsTab() {
                    return goodsTab;
                }

                public void setGoodsTab(String goodsTab) {
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

                public String getIfPoint() {
                    return ifPoint;
                }

                public void setIfPoint(String ifPoint) {
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

                public long getApproveDate() {
                    return approveDate;
                }

                public void setApproveDate(long approveDate) {
                    this.approveDate = approveDate;
                }

                public String getApproveRemarks() {
                    return approveRemarks;
                }

                public void setApproveRemarks(String approveRemarks) {
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
            }

            public static class EcGoodsBrowsesBean {
                /**
                 * id : null
                 * isNewRecord : true
                 * remarks : null
                 * createDate : null
                 * updateDate : null
                 * startDate : null
                 * endDate : null
                 * goodsId : null
                 * browseCounts : 0
                 * enableFlag : null
                 */

                private Object id;
                private boolean isNewRecord;
                private Object remarks;
                private Object createDate;
                private Object updateDate;
                private Object startDate;
                private Object endDate;
                private Object goodsId;
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

                public Object getGoodsId() {
                    return goodsId;
                }

                public void setGoodsId(Object goodsId) {
                    this.goodsId = goodsId;
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
