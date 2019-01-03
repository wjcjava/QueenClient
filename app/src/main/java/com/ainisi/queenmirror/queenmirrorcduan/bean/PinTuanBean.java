package com.ainisi.queenmirror.queenmirrorcduan.bean;

import java.util.List;

public class PinTuanBean {

    /**
     * success : true
     * errorCode : 0
     * msg : 获取商家拼团信息列表成功
     * body : {"pageSum":2,"GroupActivityListData":[{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"gpActivity":{"id":"f24cb4d9c9df48bc85260fa6e91b6f48","isNewRecord":false,"remarks":null,"createDate":"2018-06-14 18:11:39","updateDate":"2018-06-14 18:11:39","goodsId":"396636108b214507a0bdcb91731704c5","shopId":"32c9080d24e4484c95ebb10ac07cc28e","groupName":"节日大放送","groupBrief":"","serviceTime":"","groupDetails":"","groupThumb":"","groupPic":"","groupShow":"","singlePrice":1,"groupPrice":1,"groupStart":"2018-06-13 00:00:00","groupEnd":"2018-06-30 00:00:00","groupPeriod":408,"groupNumber":2,"currentNumber":0,"groupStorage":1,"groupStatus":"3","approveBy":null,"approveDate":null,"approveRemarks":null,"groupSort":1,"groupRemarks":"","updatePgm":"","saleNums":0,"contentTitle":null},"ecGoodsBasic":{"id":"396636108b214507a0bdcb91731704c5","isNewRecord":false,"remarks":null,"createDate":"2018-06-14 16:57:44","updateDate":"2018-06-14 16:57:56","goodsCate":"27a7d133a8f94cb9b9bce03365cf6a48","goodsType":"2","goodsName":"洗剪吹组合","goodsNo":"d6254566f","goodsBrief":"节日大促销活动的123456","serviceTime":"30分钟","goodsDetails":null,"goodsThumb":null,"goodsPic":null,"goodsShow":null,"goodsTab":"AESDGFVBN,","goodsStorage":null,"marketPrice":null,"salesPrice":"1.00","goodsActivity":null,"goodsBanner":null,"shopId":"32c9080d24e4484c95ebb10ac07cc28e","saleFlag":"2","ifPoint":null,"pointRule":null,"approveBy":null,"approveDate":null,"approveRemarks":null,"startTime":1525400918000,"endTime":1525400923000,"goodsRemarks":null,"updatePgm":"ApiGoodsController","shopName":null,"saleFlagName":null,"goodsTypeName":null,"goodsCateName":null,"ecPointsRule":null},"browses":null,"contentByTitle":null,"groupStatusLabel":null,"saleFlagLabel":null,"goodsTypeLabel":null},{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"gpActivity":{"id":"fdbc716a2dce44f5803f07c476115ac0","isNewRecord":false,"remarks":null,"createDate":"2018-06-14 15:57:07","updateDate":"2018-06-14 16:12:58","goodsId":"c3958e7a06a5470994bb625bf186e7ce","shopId":"d429e772e94241518496417bc38b3145","groupName":"拼团指甲油","groupBrief":"","serviceTime":"","groupDetails":"","groupThumb":"","groupPic":"","groupShow":"","singlePrice":0.01,"groupPrice":0.01,"groupStart":"2018-06-13 00:00:00","groupEnd":"2018-06-30 00:00:00","groupPeriod":408,"groupNumber":100,"currentNumber":0,"groupStorage":1,"groupStatus":"3","approveBy":"c29c23051fc3488bad5ff17f0db39a40","approveDate":1528963978000,"approveRemarks":null,"groupSort":1,"groupRemarks":"","updatePgm":"","saleNums":0,"contentTitle":null},"ecGoodsBasic":{"id":"c3958e7a06a5470994bb625bf186e7ce","isNewRecord":false,"remarks":null,"createDate":"2018-06-14 15:52:44","updateDate":"2018-06-14 15:52:57","goodsCate":"9003d18c17bd4bb98969a72a4ca553d5","goodsType":"2","goodsName":"赤木晴子指甲油","goodsNo":"a0d8160ea","goodsBrief":"非常完美","serviceTime":"120分钟","goodsDetails":null,"goodsThumb":null,"goodsPic":null,"goodsShow":null,"goodsTab":"美甲,","goodsStorage":null,"marketPrice":null,"salesPrice":"0.01","goodsActivity":null,"goodsBanner":null,"shopId":"d429e772e94241518496417bc38b3145","saleFlag":"2","ifPoint":null,"pointRule":null,"approveBy":null,"approveDate":null,"approveRemarks":null,"startTime":1525400918000,"endTime":1525400923000,"goodsRemarks":null,"updatePgm":"ApiGoodsController","shopName":null,"saleFlagName":null,"goodsTypeName":null,"goodsCateName":null,"ecPointsRule":null},"browses":null,"contentByTitle":null,"groupStatusLabel":null,"saleFlagLabel":null,"goodsTypeLabel":null}]}
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
         * pageSum : 2
         * GroupActivityListData : [{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"gpActivity":{"id":"f24cb4d9c9df48bc85260fa6e91b6f48","isNewRecord":false,"remarks":null,"createDate":"2018-06-14 18:11:39","updateDate":"2018-06-14 18:11:39","goodsId":"396636108b214507a0bdcb91731704c5","shopId":"32c9080d24e4484c95ebb10ac07cc28e","groupName":"节日大放送","groupBrief":"","serviceTime":"","groupDetails":"","groupThumb":"","groupPic":"","groupShow":"","singlePrice":1,"groupPrice":1,"groupStart":"2018-06-13 00:00:00","groupEnd":"2018-06-30 00:00:00","groupPeriod":408,"groupNumber":2,"currentNumber":0,"groupStorage":1,"groupStatus":"3","approveBy":null,"approveDate":null,"approveRemarks":null,"groupSort":1,"groupRemarks":"","updatePgm":"","saleNums":0,"contentTitle":null},"ecGoodsBasic":{"id":"396636108b214507a0bdcb91731704c5","isNewRecord":false,"remarks":null,"createDate":"2018-06-14 16:57:44","updateDate":"2018-06-14 16:57:56","goodsCate":"27a7d133a8f94cb9b9bce03365cf6a48","goodsType":"2","goodsName":"洗剪吹组合","goodsNo":"d6254566f","goodsBrief":"节日大促销活动的123456","serviceTime":"30分钟","goodsDetails":null,"goodsThumb":null,"goodsPic":null,"goodsShow":null,"goodsTab":"AESDGFVBN,","goodsStorage":null,"marketPrice":null,"salesPrice":"1.00","goodsActivity":null,"goodsBanner":null,"shopId":"32c9080d24e4484c95ebb10ac07cc28e","saleFlag":"2","ifPoint":null,"pointRule":null,"approveBy":null,"approveDate":null,"approveRemarks":null,"startTime":1525400918000,"endTime":1525400923000,"goodsRemarks":null,"updatePgm":"ApiGoodsController","shopName":null,"saleFlagName":null,"goodsTypeName":null,"goodsCateName":null,"ecPointsRule":null},"browses":null,"contentByTitle":null,"groupStatusLabel":null,"saleFlagLabel":null,"goodsTypeLabel":null},{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"gpActivity":{"id":"fdbc716a2dce44f5803f07c476115ac0","isNewRecord":false,"remarks":null,"createDate":"2018-06-14 15:57:07","updateDate":"2018-06-14 16:12:58","goodsId":"c3958e7a06a5470994bb625bf186e7ce","shopId":"d429e772e94241518496417bc38b3145","groupName":"拼团指甲油","groupBrief":"","serviceTime":"","groupDetails":"","groupThumb":"","groupPic":"","groupShow":"","singlePrice":0.01,"groupPrice":0.01,"groupStart":"2018-06-13 00:00:00","groupEnd":"2018-06-30 00:00:00","groupPeriod":408,"groupNumber":100,"currentNumber":0,"groupStorage":1,"groupStatus":"3","approveBy":"c29c23051fc3488bad5ff17f0db39a40","approveDate":1528963978000,"approveRemarks":null,"groupSort":1,"groupRemarks":"","updatePgm":"","saleNums":0,"contentTitle":null},"ecGoodsBasic":{"id":"c3958e7a06a5470994bb625bf186e7ce","isNewRecord":false,"remarks":null,"createDate":"2018-06-14 15:52:44","updateDate":"2018-06-14 15:52:57","goodsCate":"9003d18c17bd4bb98969a72a4ca553d5","goodsType":"2","goodsName":"赤木晴子指甲油","goodsNo":"a0d8160ea","goodsBrief":"非常完美","serviceTime":"120分钟","goodsDetails":null,"goodsThumb":null,"goodsPic":null,"goodsShow":null,"goodsTab":"美甲,","goodsStorage":null,"marketPrice":null,"salesPrice":"0.01","goodsActivity":null,"goodsBanner":null,"shopId":"d429e772e94241518496417bc38b3145","saleFlag":"2","ifPoint":null,"pointRule":null,"approveBy":null,"approveDate":null,"approveRemarks":null,"startTime":1525400918000,"endTime":1525400923000,"goodsRemarks":null,"updatePgm":"ApiGoodsController","shopName":null,"saleFlagName":null,"goodsTypeName":null,"goodsCateName":null,"ecPointsRule":null},"browses":null,"contentByTitle":null,"groupStatusLabel":null,"saleFlagLabel":null,"goodsTypeLabel":null}]
         */

        private int pageSum;
        private List<GroupActivityListDataBean> GroupActivityListData;

        public int getPageSum() {
            return pageSum;
        }

        public void setPageSum(int pageSum) {
            this.pageSum = pageSum;
        }

        public List<GroupActivityListDataBean> getGroupActivityListData() {
            return GroupActivityListData;
        }

        public void setGroupActivityListData(List<GroupActivityListDataBean> GroupActivityListData) {
            this.GroupActivityListData = GroupActivityListData;
        }

        public static class GroupActivityListDataBean {
            /**
             * id : null
             * isNewRecord : true
             * remarks : null
             * createDate : null
             * updateDate : null
             * gpActivity : {"id":"f24cb4d9c9df48bc85260fa6e91b6f48","isNewRecord":false,"remarks":null,"createDate":"2018-06-14 18:11:39","updateDate":"2018-06-14 18:11:39","goodsId":"396636108b214507a0bdcb91731704c5","shopId":"32c9080d24e4484c95ebb10ac07cc28e","groupName":"节日大放送","groupBrief":"","serviceTime":"","groupDetails":"","groupThumb":"","groupPic":"","groupShow":"","singlePrice":1,"groupPrice":1,"groupStart":"2018-06-13 00:00:00","groupEnd":"2018-06-30 00:00:00","groupPeriod":408,"groupNumber":2,"currentNumber":0,"groupStorage":1,"groupStatus":"3","approveBy":null,"approveDate":null,"approveRemarks":null,"groupSort":1,"groupRemarks":"","updatePgm":"","saleNums":0,"contentTitle":null}
             * ecGoodsBasic : {"id":"396636108b214507a0bdcb91731704c5","isNewRecord":false,"remarks":null,"createDate":"2018-06-14 16:57:44","updateDate":"2018-06-14 16:57:56","goodsCate":"27a7d133a8f94cb9b9bce03365cf6a48","goodsType":"2","goodsName":"洗剪吹组合","goodsNo":"d6254566f","goodsBrief":"节日大促销活动的123456","serviceTime":"30分钟","goodsDetails":null,"goodsThumb":null,"goodsPic":null,"goodsShow":null,"goodsTab":"AESDGFVBN,","goodsStorage":null,"marketPrice":null,"salesPrice":"1.00","goodsActivity":null,"goodsBanner":null,"shopId":"32c9080d24e4484c95ebb10ac07cc28e","saleFlag":"2","ifPoint":null,"pointRule":null,"approveBy":null,"approveDate":null,"approveRemarks":null,"startTime":1525400918000,"endTime":1525400923000,"goodsRemarks":null,"updatePgm":"ApiGoodsController","shopName":null,"saleFlagName":null,"goodsTypeName":null,"goodsCateName":null,"ecPointsRule":null}
             * browses : null
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
            private Object browses;
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

            public Object getBrowses() {
                return browses;
            }

            public void setBrowses(Object browses) {
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
                 * id : f24cb4d9c9df48bc85260fa6e91b6f48
                 * isNewRecord : false
                 * remarks : null
                 * createDate : 2018-06-14 18:11:39
                 * updateDate : 2018-06-14 18:11:39
                 * goodsId : 396636108b214507a0bdcb91731704c5
                 * shopId : 32c9080d24e4484c95ebb10ac07cc28e
                 * groupName : 节日大放送
                 * groupBrief :
                 * serviceTime :
                 * groupDetails :
                 * groupThumb :
                 * groupPic :
                 * groupShow :
                 * singlePrice : 1
                 * groupPrice : 1
                 * groupStart : 2018-06-13 00:00:00
                 * groupEnd : 2018-06-30 00:00:00
                 * groupPeriod : 408
                 * groupNumber : 2
                 * currentNumber : 0
                 * groupStorage : 1
                 * groupStatus : 3
                 * approveBy : null
                 * approveDate : null
                 * approveRemarks : null
                 * groupSort : 1
                 * groupRemarks :
                 * updatePgm :
                 * saleNums : 0
                 * contentTitle : null
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
                private String groupPrice;
                private String groupStart;
                private String groupEnd;
                private int groupPeriod;
                private int groupNumber;
                private int currentNumber;
                private int groupStorage;
                private String groupStatus;
                private Object approveBy;
                private Object approveDate;
                private Object approveRemarks;
                private int groupSort;
                private String groupRemarks;
                private String updatePgm;
                private int saleNums;
                private Object contentTitle;

                public boolean isNewRecord() {
                    return isNewRecord;
                }

                public void setNewRecord(boolean newRecord) {
                    isNewRecord = newRecord;
                }

                public double getSinglePrice() {
                    return singlePrice;
                }

                public void setSinglePrice(double singlePrice) {
                    this.singlePrice = singlePrice;
                }

                public String getGroupPrice() {
                    return groupPrice;
                }

                public void setGroupPrice(String groupPrice) {
                    this.groupPrice = groupPrice;
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

                public int getGroupPeriod() {
                    return groupPeriod;
                }

                public void setGroupPeriod(int groupPeriod) {
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

                public int getGroupSort() {
                    return groupSort;
                }

                public void setGroupSort(int groupSort) {
                    this.groupSort = groupSort;
                }

                public String getGroupRemarks() {
                    return groupRemarks;
                }

                public void setGroupRemarks(String groupRemarks) {
                    this.groupRemarks = groupRemarks;
                }

                public String getUpdatePgm() {
                    return updatePgm;
                }

                public void setUpdatePgm(String updatePgm) {
                    this.updatePgm = updatePgm;
                }

                public int getSaleNums() {
                    return saleNums;
                }

                public void setSaleNums(int saleNums) {
                    this.saleNums = saleNums;
                }

                public Object getContentTitle() {
                    return contentTitle;
                }

                public void setContentTitle(Object contentTitle) {
                    this.contentTitle = contentTitle;
                }
            }

            public static class EcGoodsBasicBean {
                /**
                 * id : 396636108b214507a0bdcb91731704c5
                 * isNewRecord : false
                 * remarks : null
                 * createDate : 2018-06-14 16:57:44
                 * updateDate : 2018-06-14 16:57:56
                 * goodsCate : 27a7d133a8f94cb9b9bce03365cf6a48
                 * goodsType : 2
                 * goodsName : 洗剪吹组合
                 * goodsNo : d6254566f
                 * goodsBrief : 节日大促销活动的123456
                 * serviceTime : 30分钟
                 * goodsDetails : null
                 * goodsThumb : null
                 * goodsPic : null
                 * goodsShow : null
                 * goodsTab : AESDGFVBN,
                 * goodsStorage : null
                 * marketPrice : null
                 * salesPrice : 1.00
                 * goodsActivity : null
                 * goodsBanner : null
                 * shopId : 32c9080d24e4484c95ebb10ac07cc28e
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
                 * goodsCateName : null
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
                private String goodsNo;
                private String goodsBrief;
                private String serviceTime;
                private Object goodsDetails;
                private String goodsThumb;
                private Object goodsPic;
                private Object goodsShow;
                private String goodsTab;
                private Object goodsStorage;
                private String marketPrice;
                private String salesPrice;
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
                private Object goodsCateName;
                private Object ecPointsRule;

                public boolean isNewRecord() {
                    return isNewRecord;
                }

                public void setNewRecord(boolean newRecord) {
                    isNewRecord = newRecord;
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
                public String getSalesPrice() {
                    return salesPrice;
                }

                public void setSalesPrice(String salesPrice) {
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
            }
        }
    }
}
