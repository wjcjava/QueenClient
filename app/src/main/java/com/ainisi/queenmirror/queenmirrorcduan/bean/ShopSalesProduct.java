package com.ainisi.queenmirror.queenmirrorcduan.bean;

import java.util.List;

public class ShopSalesProduct {


    /**
     * success : true
     * errorCode : 0
     * msg : 获取数据成功
     * body : {"pageSum":3,"apiGoodsList":[{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"ecGoodsBasic":{"id":"e883991a7f94488b90da78ec7d7a6562","isNewRecord":false,"remarks":null,"createDate":"2018-05-04 14:34:42","updateDate":"2018-05-04 14:34:42","goodsCate":"美学汇","goodsType":"0","goodsName":"美甲03","goodsNo":null,"goodsBrief":"很好看啊","serviceTime":"10:00:00-22:00:00","goodsDetails":null,"goodsThumb":null,"goodsPic":null,"goodsShow":null,"goodsTab":"支持开发票","goodsStorage":null,"goodsPrice":"120.00","offlinePrice":"100.00","salesPrice":null,"promotionPrice":null,"goodsActivity":null,"shopId":"111","saleFlag":"2","startTime":1525400918000,"endTime":1525400923000,"goodsRemarks":null,"updatePgm":"ApiGoodsController"},"ecGoodsSocre":null,"ecGoodsBrowses":{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"goodsId":null,"browseCounts":"0","enableFlag":null},"goodsCateLabel":null,"goodsTypeLabel":null,"shopIdName":"美美理发店","saleFlagLabel":"上架","contentByTitle":null,"goodsAppraiseLabel":null,"newFlagLabel":null},{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"ecGoodsBasic":{"id":"ef4f51753e1d43b2a39e3d15ba10dcca","isNewRecord":false,"remarks":null,"createDate":"2018-05-08 10:20:41","updateDate":"2018-05-09 13:50:27","goodsCate":"美学汇","goodsType":"2","goodsName":"修改测试1","goodsNo":null,"goodsBrief":"测试1","serviceTime":"120分钟","goodsDetails":null,"goodsThumb":null,"goodsPic":null,"goodsShow":null,"goodsTab":"美甲美手","goodsStorage":null,"goodsPrice":"20.00","offlinePrice":"60.00","salesPrice":null,"promotionPrice":null,"goodsActivity":null,"shopId":"111","saleFlag":"2","startTime":1525400918000,"endTime":1525400923000,"goodsRemarks":null,"updatePgm":"ApiGoodsController"},"ecGoodsSocre":null,"ecGoodsBrowses":{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"goodsId":null,"browseCounts":"0","enableFlag":null},"goodsCateLabel":null,"goodsTypeLabel":"服务","shopIdName":"美美理发店","saleFlagLabel":"上架","contentByTitle":null,"goodsAppraiseLabel":null,"newFlagLabel":null},{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"ecGoodsBasic":{"id":"444","isNewRecord":false,"remarks":null,"createDate":"2018-05-08 10:23:30","updateDate":"2018-05-09 13:50:31","goodsCate":"美容美体","goodsType":"0","goodsName":"测试411","goodsNo":null,"goodsBrief":"哦哦哦咯饿了","serviceTime":"90分钟","goodsDetails":null,"goodsThumb":null,"goodsPic":null,"goodsShow":null,"goodsTab":"美发定制","goodsStorage":null,"goodsPrice":"2.00","offlinePrice":"23.00","salesPrice":null,"promotionPrice":null,"goodsActivity":null,"shopId":"111","saleFlag":"2","startTime":1525400918000,"endTime":1525400923000,"goodsRemarks":null,"updatePgm":"ApiGoodsController"},"ecGoodsSocre":null,"ecGoodsBrowses":null,"goodsCateLabel":null,"goodsTypeLabel":null,"shopIdName":"美美理发店","saleFlagLabel":"上架","contentByTitle":null,"goodsAppraiseLabel":null,"newFlagLabel":null}]}
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
         * pageSum : 3
         * apiGoodsList : [{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"ecGoodsBasic":{"id":"e883991a7f94488b90da78ec7d7a6562","isNewRecord":false,"remarks":null,"createDate":"2018-05-04 14:34:42","updateDate":"2018-05-04 14:34:42","goodsCate":"美学汇","goodsType":"0","goodsName":"美甲03","goodsNo":null,"goodsBrief":"很好看啊","serviceTime":"10:00:00-22:00:00","goodsDetails":null,"goodsThumb":null,"goodsPic":null,"goodsShow":null,"goodsTab":"支持开发票","goodsStorage":null,"goodsPrice":"120.00","offlinePrice":"100.00","salesPrice":null,"promotionPrice":null,"goodsActivity":null,"shopId":"111","saleFlag":"2","startTime":1525400918000,"endTime":1525400923000,"goodsRemarks":null,"updatePgm":"ApiGoodsController"},"ecGoodsSocre":null,"ecGoodsBrowses":{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"goodsId":null,"browseCounts":"0","enableFlag":null},"goodsCateLabel":null,"goodsTypeLabel":null,"shopIdName":"美美理发店","saleFlagLabel":"上架","contentByTitle":null,"goodsAppraiseLabel":null,"newFlagLabel":null},{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"ecGoodsBasic":{"id":"ef4f51753e1d43b2a39e3d15ba10dcca","isNewRecord":false,"remarks":null,"createDate":"2018-05-08 10:20:41","updateDate":"2018-05-09 13:50:27","goodsCate":"美学汇","goodsType":"2","goodsName":"修改测试1","goodsNo":null,"goodsBrief":"测试1","serviceTime":"120分钟","goodsDetails":null,"goodsThumb":null,"goodsPic":null,"goodsShow":null,"goodsTab":"美甲美手","goodsStorage":null,"goodsPrice":"20.00","offlinePrice":"60.00","salesPrice":null,"promotionPrice":null,"goodsActivity":null,"shopId":"111","saleFlag":"2","startTime":1525400918000,"endTime":1525400923000,"goodsRemarks":null,"updatePgm":"ApiGoodsController"},"ecGoodsSocre":null,"ecGoodsBrowses":{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"goodsId":null,"browseCounts":"0","enableFlag":null},"goodsCateLabel":null,"goodsTypeLabel":"服务","shopIdName":"美美理发店","saleFlagLabel":"上架","contentByTitle":null,"goodsAppraiseLabel":null,"newFlagLabel":null},{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"ecGoodsBasic":{"id":"444","isNewRecord":false,"remarks":null,"createDate":"2018-05-08 10:23:30","updateDate":"2018-05-09 13:50:31","goodsCate":"美容美体","goodsType":"0","goodsName":"测试411","goodsNo":null,"goodsBrief":"哦哦哦咯饿了","serviceTime":"90分钟","goodsDetails":null,"goodsThumb":null,"goodsPic":null,"goodsShow":null,"goodsTab":"美发定制","goodsStorage":null,"goodsPrice":"2.00","offlinePrice":"23.00","salesPrice":null,"promotionPrice":null,"goodsActivity":null,"shopId":"111","saleFlag":"2","startTime":1525400918000,"endTime":1525400923000,"goodsRemarks":null,"updatePgm":"ApiGoodsController"},"ecGoodsSocre":null,"ecGoodsBrowses":null,"goodsCateLabel":null,"goodsTypeLabel":null,"shopIdName":"美美理发店","saleFlagLabel":"上架","contentByTitle":null,"goodsAppraiseLabel":null,"newFlagLabel":null}]
         */

        private int pageSum;
        private List<ApiGoodsListBean> apiGoodsList;

        public int getPageSum() {
            return pageSum;
        }

        public void setPageSum(int pageSum) {
            this.pageSum = pageSum;
        }

        public List<ApiGoodsListBean> getApiGoodsList() {
            return apiGoodsList;
        }

        public void setApiGoodsList(List<ApiGoodsListBean> apiGoodsList) {
            this.apiGoodsList = apiGoodsList;
        }

        public static class ApiGoodsListBean {
            /**
             * id : null
             * isNewRecord : true
             * remarks : null
             * createDate : null
             * updateDate : null
             * ecGoodsBasic : {"id":"e883991a7f94488b90da78ec7d7a6562","isNewRecord":false,"remarks":null,"createDate":"2018-05-04 14:34:42","updateDate":"2018-05-04 14:34:42","goodsCate":"美学汇","goodsType":"0","goodsName":"美甲03","goodsNo":null,"goodsBrief":"很好看啊","serviceTime":"10:00:00-22:00:00","goodsDetails":null,"goodsThumb":null,"goodsPic":null,"goodsShow":null,"goodsTab":"支持开发票","goodsStorage":null,"goodsPrice":"120.00","offlinePrice":"100.00","salesPrice":null,"promotionPrice":null,"goodsActivity":null,"shopId":"111","saleFlag":"2","startTime":1525400918000,"endTime":1525400923000,"goodsRemarks":null,"updatePgm":"ApiGoodsController"}
             * ecGoodsSocre : null
             * ecGoodsBrowses : {"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"goodsId":null,"browseCounts":"0","enableFlag":null}
             * goodsCateLabel : null
             * goodsTypeLabel : null
             * shopIdName : 美美理发店
             * saleFlagLabel : 上架
             * contentByTitle : null
             * goodsAppraiseLabel : null
             * newFlagLabel : null
             */

            private Object id;
            private boolean isNewRecord;
            private Object remarks;
            private Object createDate;
            private Object updateDate;
            private EcGoodsBasicBean ecGoodsBasic;
            private Object ecGoodsSocre;
            private EcGoodsBrowsesBean ecGoodsBrowses;
            private Object goodsCateLabel;
            private Object goodsTypeLabel;
            private String shopIdName;
            private String saleFlagLabel;
            private Object contentByTitle;
            private Object goodsAppraiseLabel;
            private Object newFlagLabel;
            private String praiseRate;

            public String getPraiseRate() {
                return praiseRate;
            }

            public void setPraiseRate(String praiseRate) {
                this.praiseRate = praiseRate;
            }

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

            public EcGoodsBrowsesBean getEcGoodsBrowses() {
                return ecGoodsBrowses;
            }

            public void setEcGoodsBrowses(EcGoodsBrowsesBean ecGoodsBrowses) {
                this.ecGoodsBrowses = ecGoodsBrowses;
            }

            public Object getGoodsCateLabel() {
                return goodsCateLabel;
            }

            public void setGoodsCateLabel(Object goodsCateLabel) {
                this.goodsCateLabel = goodsCateLabel;
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

            public String getSaleFlagLabel() {
                return saleFlagLabel;
            }

            public void setSaleFlagLabel(String saleFlagLabel) {
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
                 * marketPrice
                 * id : e883991a7f94488b90da78ec7d7a6562
                 * isNewRecord : false
                 * remarks : null
                 * createDate : 2018-05-04 14:34:42
                 * updateDate : 2018-05-04 14:34:42
                 * goodsCate : 美学汇
                 * goodsType : 0
                 * goodsName : 美甲03
                 * goodsNo : null
                 * goodsBrief : 很好看啊
                 * serviceTime : 10:00:00-22:00:00
                 * goodsDetails : null
                 * goodsThumb : null
                 * goodsPic : null
                 * goodsShow : null
                 * goodsTab : 支持开发票
                 * goodsStorage : null
                 * goodsPrice : 120.00
                 * offlinePrice : 100.00
                 * salesPrice : null
                 * promotionPrice : null
                 * goodsActivity : null
                 * shopId : 111
                 * saleFlag : 2
                 * startTime : 1525400918000
                 * endTime : 1525400923000
                 * goodsRemarks : null
                 * updatePgm : ApiGoodsController
                 */

                private String id;
                private boolean isNewRecord;
                private Object remarks;
                private String createDate;
                private String updateDate;
                private String goodsCate;
                private String goodsType;
                private String goodsName;
                private String marketPrice;
                private Object goodsNo;
                private String goodsBrief;
                private String serviceTime;
                private Object goodsDetails;
                private String goodsThumb;
                private String goodsPic;
                private String goodsShow;
                private String goodsTab;
                private Object goodsStorage;
                private String goodsPrice;
                private String offlinePrice;
                private String salesPrice;
                private String ifPoint;
                private String pointRule;
                private Object promotionPrice;
                private Object goodsActivity;
                private String shopId;
                private String saleFlag;
                private long startTime;
                private long endTime;
                private Object goodsRemarks;
                private String updatePgm;
                private String buyRule;
                private String groupGoods;
                private String groupPrice;
                private String activityId;

                public String getActivityId() {
                    return activityId;
                }

                public void setActivityId(String activityId) {
                    this.activityId = activityId;
                }

                public String getGroupPrice() {
                    return groupPrice;
                }

                public void setGroupPrice(String groupPrice) {
                    this.groupPrice = groupPrice;
                }

                public String getGroupGoods() {
                    return groupGoods;
                }

                public void setGroupGoods(String groupGoods) {
                    this.groupGoods = groupGoods;
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

                public String getBuyRule() {
                    return buyRule;
                }

                public void setBuyRule(String buyRule) {
                    this.buyRule = buyRule;
                }

                public boolean isNewRecord() {
                    return isNewRecord;
                }

                public void setNewRecord(boolean newRecord) {
                    isNewRecord = newRecord;
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

                public String getMarketPrice() {
                    return marketPrice;
                }

                public void setMarketPrice(String marketPrice) {
                    this.marketPrice = marketPrice;
                }

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
            }

            public static class EcGoodsBrowsesBean {
                /**
                 * id : null
                 * isNewRecord : true
                 * remarks : null
                 * createDate : null
                 * updateDate : null
                 * goodsId : null
                 * browseCounts : 0
                 * enableFlag : null
                 */

                private Object id;
                private boolean isNewRecord;
                private Object remarks;
                private Object createDate;
                private Object updateDate;
                private Object goodsId;
                private String browseCounts;
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

                public Object getGoodsId() {
                    return goodsId;
                }

                public void setGoodsId(Object goodsId) {
                    this.goodsId = goodsId;
                }

                public String getBrowseCounts() {
                    return browseCounts;
                }

                public void setBrowseCounts(String browseCounts) {
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
