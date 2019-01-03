package com.ainisi.queenmirror.queenmirrorcduan.bean;

import java.io.Serializable;
import java.util.List;

public class FightaloneBean implements Serializable{


    /**
     * success : true
     * errorCode : 0
     * msg : 成功
     * body : {"groupNums":2,"joinSums":1,"gpOrderList":[{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"intfAnsShopBasic":null,"intfAnsOrder":null,"intfAnsCustBasic":null,"intfCpCreateInfo":null,"orderStatusList":null,"gpOrder":{"id":"5abe4a7bc6a44d259ee44054c290aab3","isNewRecord":false,"remarks":null,"createDate":"2018-07-31 11:06:32","updateDate":"2018-07-31 11:06:56","startDate":null,"endDate":"2018-08-31 00:00:00","orderNo":"1807300001110600","custId":"452ed4d11ad7408cb287e8e6807cc84b","groupId":"1533006392339","groupType":"0","orderTime":"2018-07-31 11:08:06","orderAmount":0.01,"paymentMethod":"4","paymentKeys":null,"paymentTime":"2018-07-31 11:06:56","orderStatus":"PT","ifRefund":"0","refundTime":null,"custRemarks":null,"transId":"1180731511065640000000001","qrcode":null,"updatePgm":null,"isOwner":0,"gpactId":"2f9e6ebe9dae4c409c54f4f4ac4e8441","joinNums":1,"endTimes":"2629858196","shopId":"c4d50c6fd4ff4a438b956859f0546d45"},"ansOrderDetails":null,"ecGoodsBasic":null,"ansShopBasic":null,"ansCustBasic":{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"contractConfirm":null,"cellPhone":null,"deviceToken":null,"userName":"15720682665","userPass":null,"wechatId":null,"wechatToken":null,"qqId":null,"qqToken":null,"completeFlag":null,"headPic":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/img/2018-07-25/1532485141162.png","lastName":null,"firstName":null,"idCard":null,"nameIdentify":null,"sex":null,"birthday":null,"registerDate":null,"nickName":null,"loginIp":null,"logininTime":null,"loginoutTime":null,"loginFlag":null,"recommendUser":null,"recommendCode":null,"updatBy":null,"updatePgm":null},"paymentMethodLabel":null,"orderStatusLabel":null,"goodsCateLabel":null,"goodsTypeLabel":null,"saleFlagLabel":null,"shopCateLabel":null,"industryCateLabel":null,"businessFlagLabel":null,"enableFlagLabel":null}],"activity":{"id":"2f9e6ebe9dae4c409c54f4f4ac4e8441","isNewRecord":false,"remarks":null,"createDate":"2018-07-30 15:13:45","updateDate":"2018-07-31 11:06:56","startDate":null,"endDate":null,"goodsId":"738dcbd5d1714f9d8d7392503a6ffc05","shopId":"c4d50c6fd4ff4a438b956859f0546d45","groupName":"专业美甲拼团活动","groupBrief":"","serviceTime":"50","groupDetails":"","groupThumb":"","groupPic":"","groupShow":"","singlePrice":0.01,"groupPrice":1,"groupStart":"2018-07-30 00:00:00","groupEnd":"2018-08-31 00:00:00","groupPeriod":768,"groupNumber":2,"currentNumber":0,"groupStorage":1,"groupStatus":"3","approveBy":"1","approveDate":"2018-07-30 15:25:59","approveRemarks":"同意啦","groupSort":1,"groupRemarks":"","updatePgm":"","saleNums":1,"contentTitle":null,"hasReject":"0"},"ecGoodsBrowses":{"id":"01a579a58f8f44a3a71a305081bbc163","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"goodsId":"738dcbd5d1714f9d8d7392503a6ffc05","browseCounts":518,"enableFlag":"0"},"ecGoodsBasic":{"id":"738dcbd5d1714f9d8d7392503a6ffc05","isNewRecord":false,"remarks":null,"createDate":"2018-06-28 15:02:17","updateDate":"2018-07-30 15:27:34","startDate":null,"endDate":null,"goodsCate":"b718ade8a94f4b41993c0ecbcc2821d2","goodsType":"1","goodsName":"专业美甲","goodsNo":"b09329264c","goodsBrief":"商品好","goodsSort":0,"serviceTime":"50","goodsDetails":"","goodsThumb":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018070211290662068048.jpg","goodsPic":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018070211291482259133.jpg,","goodsShow":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018070211290662068048.jpg,","goodsTab":"美甲,","goodsStorage":0,"marketPrice":0.01,"salesPrice":0.01,"goodsActivity":"","goodsBanner":"","shopId":"c4d50c6fd4ff4a438b956859f0546d45","saleFlag":"2","ifPoint":"1","pointRule":"9ccaddb2f6b14268a740785d92489496","approveBy":null,"approveDate":1532574870000,"approveRemarks":"商品可以通过审核！ ","startTime":1530720000000,"endTime":1532707200000,"goodsRemarks":null,"updatePgm":"ApiGoodsController","shopName":null,"saleFlagName":null,"goodsTypeName":null,"goodsCateName":"美发定制","ecPointsRule":null,"buyRule":"0","cityCode":null,"groupGoods":"0"}}
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

    public static class BodyBean  implements Serializable{
        /**
         * groupNums : 2
         * joinSums : 1
         * gpOrderList : [{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"intfAnsShopBasic":null,"intfAnsOrder":null,"intfAnsCustBasic":null,"intfCpCreateInfo":null,"orderStatusList":null,"gpOrder":{"id":"5abe4a7bc6a44d259ee44054c290aab3","isNewRecord":false,"remarks":null,"createDate":"2018-07-31 11:06:32","updateDate":"2018-07-31 11:06:56","startDate":null,"endDate":"2018-08-31 00:00:00","orderNo":"1807300001110600","custId":"452ed4d11ad7408cb287e8e6807cc84b","groupId":"1533006392339","groupType":"0","orderTime":"2018-07-31 11:08:06","orderAmount":0.01,"paymentMethod":"4","paymentKeys":null,"paymentTime":"2018-07-31 11:06:56","orderStatus":"PT","ifRefund":"0","refundTime":null,"custRemarks":null,"transId":"1180731511065640000000001","qrcode":null,"updatePgm":null,"isOwner":0,"gpactId":"2f9e6ebe9dae4c409c54f4f4ac4e8441","joinNums":1,"endTimes":"2629858196","shopId":"c4d50c6fd4ff4a438b956859f0546d45"},"ansOrderDetails":null,"ecGoodsBasic":null,"ansShopBasic":null,"ansCustBasic":{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"contractConfirm":null,"cellPhone":null,"deviceToken":null,"userName":"15720682665","userPass":null,"wechatId":null,"wechatToken":null,"qqId":null,"qqToken":null,"completeFlag":null,"headPic":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/img/2018-07-25/1532485141162.png","lastName":null,"firstName":null,"idCard":null,"nameIdentify":null,"sex":null,"birthday":null,"registerDate":null,"nickName":null,"loginIp":null,"logininTime":null,"loginoutTime":null,"loginFlag":null,"recommendUser":null,"recommendCode":null,"updatBy":null,"updatePgm":null},"paymentMethodLabel":null,"orderStatusLabel":null,"goodsCateLabel":null,"goodsTypeLabel":null,"saleFlagLabel":null,"shopCateLabel":null,"industryCateLabel":null,"businessFlagLabel":null,"enableFlagLabel":null}]
         * activity : {"id":"2f9e6ebe9dae4c409c54f4f4ac4e8441","isNewRecord":false,"remarks":null,"createDate":"2018-07-30 15:13:45","updateDate":"2018-07-31 11:06:56","startDate":null,"endDate":null,"goodsId":"738dcbd5d1714f9d8d7392503a6ffc05","shopId":"c4d50c6fd4ff4a438b956859f0546d45","groupName":"专业美甲拼团活动","groupBrief":"","serviceTime":"50","groupDetails":"","groupThumb":"","groupPic":"","groupShow":"","singlePrice":0.01,"groupPrice":1,"groupStart":"2018-07-30 00:00:00","groupEnd":"2018-08-31 00:00:00","groupPeriod":768,"groupNumber":2,"currentNumber":0,"groupStorage":1,"groupStatus":"3","approveBy":"1","approveDate":"2018-07-30 15:25:59","approveRemarks":"同意啦","groupSort":1,"groupRemarks":"","updatePgm":"","saleNums":1,"contentTitle":null,"hasReject":"0"}
         * ecGoodsBrowses : {"id":"01a579a58f8f44a3a71a305081bbc163","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"goodsId":"738dcbd5d1714f9d8d7392503a6ffc05","browseCounts":518,"enableFlag":"0"}
         * ecGoodsBasic : {"id":"738dcbd5d1714f9d8d7392503a6ffc05","isNewRecord":false,"remarks":null,"createDate":"2018-06-28 15:02:17","updateDate":"2018-07-30 15:27:34","startDate":null,"endDate":null,"goodsCate":"b718ade8a94f4b41993c0ecbcc2821d2","goodsType":"1","goodsName":"专业美甲","goodsNo":"b09329264c","goodsBrief":"商品好","goodsSort":0,"serviceTime":"50","goodsDetails":"","goodsThumb":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018070211290662068048.jpg","goodsPic":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018070211291482259133.jpg,","goodsShow":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018070211290662068048.jpg,","goodsTab":"美甲,","goodsStorage":0,"marketPrice":0.01,"salesPrice":0.01,"goodsActivity":"","goodsBanner":"","shopId":"c4d50c6fd4ff4a438b956859f0546d45","saleFlag":"2","ifPoint":"1","pointRule":"9ccaddb2f6b14268a740785d92489496","approveBy":null,"approveDate":1532574870000,"approveRemarks":"商品可以通过审核！ ","startTime":1530720000000,"endTime":1532707200000,"goodsRemarks":null,"updatePgm":"ApiGoodsController","shopName":null,"saleFlagName":null,"goodsTypeName":null,"goodsCateName":"美发定制","ecPointsRule":null,"buyRule":"0","cityCode":null,"groupGoods":"0"}
         */

        private int groupNums;
        private int joinSums;
        private ActivityBean activity;
        private EcGoodsBrowsesBean ecGoodsBrowses;
        private EcGoodsBasicBean ecGoodsBasic;
        private List<GpOrderListBean> gpOrderList;

        public int getGroupNums() {
            return groupNums;
        }

        public void setGroupNums(int groupNums) {
            this.groupNums = groupNums;
        }

        public int getJoinSums() {
            return joinSums;
        }

        public void setJoinSums(int joinSums) {
            this.joinSums = joinSums;
        }

        public ActivityBean getActivity() {
            return activity;
        }

        public void setActivity(ActivityBean activity) {
            this.activity = activity;
        }

        public EcGoodsBrowsesBean getEcGoodsBrowses() {
            return ecGoodsBrowses;
        }

        public void setEcGoodsBrowses(EcGoodsBrowsesBean ecGoodsBrowses) {
            this.ecGoodsBrowses = ecGoodsBrowses;
        }

        public EcGoodsBasicBean getEcGoodsBasic() {
            return ecGoodsBasic;
        }

        public void setEcGoodsBasic(EcGoodsBasicBean ecGoodsBasic) {
            this.ecGoodsBasic = ecGoodsBasic;
        }

        public List<GpOrderListBean> getGpOrderList() {
            return gpOrderList;
        }

        public void setGpOrderList(List<GpOrderListBean> gpOrderList) {
            this.gpOrderList = gpOrderList;
        }

        public static class ActivityBean  implements Serializable{
            /**
             * id : 2f9e6ebe9dae4c409c54f4f4ac4e8441
             * isNewRecord : false
             * remarks : null
             * createDate : 2018-07-30 15:13:45
             * updateDate : 2018-07-31 11:06:56
             * startDate : null
             * endDate : null
             * goodsId : 738dcbd5d1714f9d8d7392503a6ffc05
             * shopId : c4d50c6fd4ff4a438b956859f0546d45
             * groupName : 专业美甲拼团活动
             * groupBrief :
             * serviceTime : 50
             * groupDetails :
             * groupThumb :
             * groupPic :
             * groupShow :
             * singlePrice : 0.01
             * groupPrice : 1
             * groupStart : 2018-07-30 00:00:00
             * groupEnd : 2018-08-31 00:00:00
             * groupPeriod : 768
             * groupNumber : 2
             * currentNumber : 0
             * groupStorage : 1
             * groupStatus : 3
             * approveBy : 1
             * approveDate : 2018-07-30 15:25:59
             * approveRemarks : 同意啦
             * groupSort : 1
             * groupRemarks :
             * updatePgm :
             * saleNums : 1
             * contentTitle : null
             * hasReject : 0
             */

            private String id;
            private boolean isNewRecord;
            private Object remarks;
            private String createDate;
            private String updateDate;
            private String startDate;
            private String endDate;
            private String goodsId;
            private String shopId;
            private String groupName;
            private String groupBrief;
            private String serviceTime;
            private String groupDetails;
            private String groupThumb;
            private String groupPic;
            private String groupShow;
            private String singlePrice;
            private String groupPrice;
            private String groupStart;
            private String groupEnd;
            private String groupPeriod;
            private String groupNumber;
            private String currentNumber;
            private String groupStorage;
            private String groupStatus;
            private String approveBy;
            private String approveDate;
            private String approveRemarks;
            private String groupSort;
            private String groupRemarks;
            private String updatePgm;
            private String saleNums;
            private String contentTitle;
            private String hasReject;

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

            public String getSinglePrice() {
                return singlePrice;
            }

            public void setSinglePrice(String singlePrice) {
                this.singlePrice = singlePrice;
            }

            public String getGroupPrice() {
                return groupPrice;
            }

            public void setGroupPrice(String groupPrice) {
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

            public String getGroupPeriod() {
                return groupPeriod;
            }

            public void setGroupPeriod(String groupPeriod) {
                this.groupPeriod = groupPeriod;
            }

            public String getGroupNumber() {
                return groupNumber;
            }

            public void setGroupNumber(String groupNumber) {
                this.groupNumber = groupNumber;
            }

            public String getCurrentNumber() {
                return currentNumber;
            }

            public void setCurrentNumber(String currentNumber) {
                this.currentNumber = currentNumber;
            }

            public String getGroupStorage() {
                return groupStorage;
            }

            public void setGroupStorage(String groupStorage) {
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

            public String getApproveDate() {
                return approveDate;
            }

            public void setApproveDate(String approveDate) {
                this.approveDate = approveDate;
            }

            public String getApproveRemarks() {
                return approveRemarks;
            }

            public void setApproveRemarks(String approveRemarks) {
                this.approveRemarks = approveRemarks;
            }

            public String getGroupSort() {
                return groupSort;
            }

            public void setGroupSort(String groupSort) {
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

            public String getSaleNums() {
                return saleNums;
            }

            public void setSaleNums(String saleNums) {
                this.saleNums = saleNums;
            }

            public String getContentTitle() {
                return contentTitle;
            }

            public void setContentTitle(String contentTitle) {
                this.contentTitle = contentTitle;
            }

            public String getHasReject() {
                return hasReject;
            }

            public void setHasReject(String hasReject) {
                this.hasReject = hasReject;
            }
        }

        public static class EcGoodsBrowsesBean  implements Serializable{
            /**
             * id : 01a579a58f8f44a3a71a305081bbc163
             * isNewRecord : false
             * remarks : null
             * createDate : null
             * updateDate : null
             * startDate : null
             * endDate : null
             * goodsId : 738dcbd5d1714f9d8d7392503a6ffc05
             * browseCounts : 518
             * enableFlag : 0
             */

            private String id;
            private boolean isNewRecord;
            private Object remarks;
            private Object createDate;
            private Object updateDate;
            private Object startDate;
            private Object endDate;
            private String goodsId;
            private int browseCounts;
            private String enableFlag;

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

            public String getGoodsId() {
                return goodsId;
            }

            public void setGoodsId(String goodsId) {
                this.goodsId = goodsId;
            }

            public int getBrowseCounts() {
                return browseCounts;
            }

            public void setBrowseCounts(int browseCounts) {
                this.browseCounts = browseCounts;
            }

            public String getEnableFlag() {
                return enableFlag;
            }

            public void setEnableFlag(String enableFlag) {
                this.enableFlag = enableFlag;
            }
        }

        public static class EcGoodsBasicBean  implements Serializable{
            /**
             * id : 738dcbd5d1714f9d8d7392503a6ffc05
             * isNewRecord : false
             * remarks : null
             * createDate : 2018-06-28 15:02:17
             * updateDate : 2018-07-30 15:27:34
             * startDate : null
             * endDate : null
             * goodsCate : b718ade8a94f4b41993c0ecbcc2821d2
             * goodsType : 1
             * goodsName : 专业美甲
             * goodsNo : b09329264c
             * goodsBrief : 商品好
             * goodsSort : 0
             * serviceTime : 50
             * goodsDetails :
             * goodsThumb : https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018070211290662068048.jpg
             * goodsPic : https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018070211291482259133.jpg,
             * goodsShow : https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018070211290662068048.jpg,
             * goodsTab : 美甲,
             * goodsStorage : 0
             * marketPrice : 0.01
             * salesPrice : 0.01
             * goodsActivity :
             * goodsBanner :
             * shopId : c4d50c6fd4ff4a438b956859f0546d45
             * saleFlag : 2
             * ifPoint : 1
             * pointRule : 9ccaddb2f6b14268a740785d92489496
             * approveBy : null
             * approveDate : 1532574870000
             * approveRemarks : 商品可以通过审核！
             * startTime : 1530720000000
             * endTime : 1532707200000
             * goodsRemarks : null
             * updatePgm : ApiGoodsController
             * shopName : null
             * saleFlagName : null
             * goodsTypeName : null
             * goodsCateName : 美发定制
             * ecPointsRule : null
             * buyRule : 0
             * cityCode : null
             * groupGoods : 0
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
            private String goodsDetails;
            private String goodsThumb;
            private String goodsPic;
            private String goodsShow;
            private String goodsTab;
            private int goodsStorage;
            private double marketPrice;
            private double salesPrice;
            private String goodsActivity;
            private String goodsBanner;
            private String shopId;
            private String saleFlag;
            private String ifPoint;
            private String pointRule;
            private Object approveBy;
            private long approveDate;
            private String approveRemarks;
            private long startTime;
            private long endTime;
            private Object goodsRemarks;
            private String updatePgm;
            private Object shopName;
            private Object saleFlagName;
            private Object goodsTypeName;
            private String goodsCateName;
            private Object ecPointsRule;
            private String buyRule;
            private Object cityCode;
            private String groupGoods;

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

            public String getGoodsDetails() {
                return goodsDetails;
            }

            public void setGoodsDetails(String goodsDetails) {
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

            public String getGoodsActivity() {
                return goodsActivity;
            }

            public void setGoodsActivity(String goodsActivity) {
                this.goodsActivity = goodsActivity;
            }

            public String getGoodsBanner() {
                return goodsBanner;
            }

            public void setGoodsBanner(String goodsBanner) {
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

            public String getGoodsCateName() {
                return goodsCateName;
            }

            public void setGoodsCateName(String goodsCateName) {
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
        }

        public static class GpOrderListBean  implements Serializable{
            /**
             * id : null
             * isNewRecord : true
             * remarks : null
             * createDate : null
             * updateDate : null
             * startDate : null
             * endDate : null
             * intfAnsShopBasic : null
             * intfAnsOrder : null
             * intfAnsCustBasic : null
             * intfCpCreateInfo : null
             * orderStatusList : null
             * gpOrder : {"id":"5abe4a7bc6a44d259ee44054c290aab3","isNewRecord":false,"remarks":null,"createDate":"2018-07-31 11:06:32","updateDate":"2018-07-31 11:06:56","startDate":null,"endDate":"2018-08-31 00:00:00","orderNo":"1807300001110600","custId":"452ed4d11ad7408cb287e8e6807cc84b","groupId":"1533006392339","groupType":"0","orderTime":"2018-07-31 11:08:06","orderAmount":0.01,"paymentMethod":"4","paymentKeys":null,"paymentTime":"2018-07-31 11:06:56","orderStatus":"PT","ifRefund":"0","refundTime":null,"custRemarks":null,"transId":"1180731511065640000000001","qrcode":null,"updatePgm":null,"isOwner":0,"gpactId":"2f9e6ebe9dae4c409c54f4f4ac4e8441","joinNums":1,"endTimes":"2629858196","shopId":"c4d50c6fd4ff4a438b956859f0546d45"}
             * ansOrderDetails : null
             * ecGoodsBasic : null
             * ansShopBasic : null
             * ansCustBasic : {"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"contractConfirm":null,"cellPhone":null,"deviceToken":null,"userName":"15720682665","userPass":null,"wechatId":null,"wechatToken":null,"qqId":null,"qqToken":null,"completeFlag":null,"headPic":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/img/2018-07-25/1532485141162.png","lastName":null,"firstName":null,"idCard":null,"nameIdentify":null,"sex":null,"birthday":null,"registerDate":null,"nickName":null,"loginIp":null,"logininTime":null,"loginoutTime":null,"loginFlag":null,"recommendUser":null,"recommendCode":null,"updatBy":null,"updatePgm":null}
             * paymentMethodLabel : null
             * orderStatusLabel : null
             * goodsCateLabel : null
             * goodsTypeLabel : null
             * saleFlagLabel : null
             * shopCateLabel : null
             * industryCateLabel : null
             * businessFlagLabel : null
             * enableFlagLabel : null
             */

            private Object id;
            private boolean isNewRecord;
            private Object remarks;
            private Object createDate;
            private Object updateDate;
            private Object startDate;
            private Object endDate;
            private Object intfAnsShopBasic;
            private Object intfAnsOrder;
            private Object intfAnsCustBasic;
            private Object intfCpCreateInfo;
            private Object orderStatusList;
            private GpOrderBean gpOrder;
            private Object ansOrderDetails;
            private Object ecGoodsBasic;
            private Object ansShopBasic;
            private AnsCustBasicBean ansCustBasic;
            private Object paymentMethodLabel;
            private Object orderStatusLabel;
            private Object goodsCateLabel;
            private Object goodsTypeLabel;
            private Object saleFlagLabel;
            private Object shopCateLabel;
            private Object industryCateLabel;
            private Object businessFlagLabel;
            private Object enableFlagLabel;

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

            public Object getIntfAnsShopBasic() {
                return intfAnsShopBasic;
            }

            public void setIntfAnsShopBasic(Object intfAnsShopBasic) {
                this.intfAnsShopBasic = intfAnsShopBasic;
            }

            public Object getIntfAnsOrder() {
                return intfAnsOrder;
            }

            public void setIntfAnsOrder(Object intfAnsOrder) {
                this.intfAnsOrder = intfAnsOrder;
            }

            public Object getIntfAnsCustBasic() {
                return intfAnsCustBasic;
            }

            public void setIntfAnsCustBasic(Object intfAnsCustBasic) {
                this.intfAnsCustBasic = intfAnsCustBasic;
            }

            public Object getIntfCpCreateInfo() {
                return intfCpCreateInfo;
            }

            public void setIntfCpCreateInfo(Object intfCpCreateInfo) {
                this.intfCpCreateInfo = intfCpCreateInfo;
            }

            public Object getOrderStatusList() {
                return orderStatusList;
            }

            public void setOrderStatusList(Object orderStatusList) {
                this.orderStatusList = orderStatusList;
            }

            public GpOrderBean getGpOrder() {
                return gpOrder;
            }

            public void setGpOrder(GpOrderBean gpOrder) {
                this.gpOrder = gpOrder;
            }

            public Object getAnsOrderDetails() {
                return ansOrderDetails;
            }

            public void setAnsOrderDetails(Object ansOrderDetails) {
                this.ansOrderDetails = ansOrderDetails;
            }

            public Object getEcGoodsBasic() {
                return ecGoodsBasic;
            }

            public void setEcGoodsBasic(Object ecGoodsBasic) {
                this.ecGoodsBasic = ecGoodsBasic;
            }

            public Object getAnsShopBasic() {
                return ansShopBasic;
            }

            public void setAnsShopBasic(Object ansShopBasic) {
                this.ansShopBasic = ansShopBasic;
            }

            public AnsCustBasicBean getAnsCustBasic() {
                return ansCustBasic;
            }

            public void setAnsCustBasic(AnsCustBasicBean ansCustBasic) {
                this.ansCustBasic = ansCustBasic;
            }

            public Object getPaymentMethodLabel() {
                return paymentMethodLabel;
            }

            public void setPaymentMethodLabel(Object paymentMethodLabel) {
                this.paymentMethodLabel = paymentMethodLabel;
            }

            public Object getOrderStatusLabel() {
                return orderStatusLabel;
            }

            public void setOrderStatusLabel(Object orderStatusLabel) {
                this.orderStatusLabel = orderStatusLabel;
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

            public Object getSaleFlagLabel() {
                return saleFlagLabel;
            }

            public void setSaleFlagLabel(Object saleFlagLabel) {
                this.saleFlagLabel = saleFlagLabel;
            }

            public Object getShopCateLabel() {
                return shopCateLabel;
            }

            public void setShopCateLabel(Object shopCateLabel) {
                this.shopCateLabel = shopCateLabel;
            }

            public Object getIndustryCateLabel() {
                return industryCateLabel;
            }

            public void setIndustryCateLabel(Object industryCateLabel) {
                this.industryCateLabel = industryCateLabel;
            }

            public Object getBusinessFlagLabel() {
                return businessFlagLabel;
            }

            public void setBusinessFlagLabel(Object businessFlagLabel) {
                this.businessFlagLabel = businessFlagLabel;
            }

            public Object getEnableFlagLabel() {
                return enableFlagLabel;
            }

            public void setEnableFlagLabel(Object enableFlagLabel) {
                this.enableFlagLabel = enableFlagLabel;
            }

            public static class GpOrderBean  implements Serializable{
                /**
                 * id : 5abe4a7bc6a44d259ee44054c290aab3
                 * isNewRecord : false
                 * remarks : null
                 * createDate : 2018-07-31 11:06:32
                 * updateDate : 2018-07-31 11:06:56
                 * startDate : null
                 * endDate : 2018-08-31 00:00:00
                 * orderNo : 1807300001110600
                 * custId : 452ed4d11ad7408cb287e8e6807cc84b
                 * groupId : 1533006392339
                 * groupType : 0
                 * orderTime : 2018-07-31 11:08:06
                 * orderAmount : 0.01
                 * paymentMethod : 4
                 * paymentKeys : null
                 * paymentTime : 2018-07-31 11:06:56
                 * orderStatus : PT
                 * ifRefund : 0
                 * refundTime : null
                 * custRemarks : null
                 * transId : 1180731511065640000000001
                 * qrcode : null
                 * updatePgm : null
                 * isOwner : 0
                 * gpactId : 2f9e6ebe9dae4c409c54f4f4ac4e8441
                 * joinNums : 1
                 * endTimes : 2629858196
                 * shopId : c4d50c6fd4ff4a438b956859f0546d45
                 */

                private String id;
                private boolean isNewRecord;
                private Object remarks;
                private String createDate;
                private String updateDate;
                private Object startDate;
                private String endDate;
                private String orderNo;
                private String custId;
                private String groupId;
                private String groupType;
                private String orderTime;
                private double orderAmount;
                private String paymentMethod;
                private Object paymentKeys;
                private String paymentTime;
                private String orderStatus;
                private String ifRefund;
                private Object refundTime;
                private Object custRemarks;
                private String transId;
                private Object qrcode;
                private Object updatePgm;
                private int isOwner;
                private String gpactId;
                private int joinNums;
                private String endTimes;
                private String shopId;

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

                public String getEndDate() {
                    return endDate;
                }

                public void setEndDate(String endDate) {
                    this.endDate = endDate;
                }

                public String getOrderNo() {
                    return orderNo;
                }

                public void setOrderNo(String orderNo) {
                    this.orderNo = orderNo;
                }

                public String getCustId() {
                    return custId;
                }

                public void setCustId(String custId) {
                    this.custId = custId;
                }

                public String getGroupId() {
                    return groupId;
                }

                public void setGroupId(String groupId) {
                    this.groupId = groupId;
                }

                public String getGroupType() {
                    return groupType;
                }

                public void setGroupType(String groupType) {
                    this.groupType = groupType;
                }

                public String getOrderTime() {
                    return orderTime;
                }

                public void setOrderTime(String orderTime) {
                    this.orderTime = orderTime;
                }

                public double getOrderAmount() {
                    return orderAmount;
                }

                public void setOrderAmount(double orderAmount) {
                    this.orderAmount = orderAmount;
                }

                public String getPaymentMethod() {
                    return paymentMethod;
                }

                public void setPaymentMethod(String paymentMethod) {
                    this.paymentMethod = paymentMethod;
                }

                public Object getPaymentKeys() {
                    return paymentKeys;
                }

                public void setPaymentKeys(Object paymentKeys) {
                    this.paymentKeys = paymentKeys;
                }

                public String getPaymentTime() {
                    return paymentTime;
                }

                public void setPaymentTime(String paymentTime) {
                    this.paymentTime = paymentTime;
                }

                public String getOrderStatus() {
                    return orderStatus;
                }

                public void setOrderStatus(String orderStatus) {
                    this.orderStatus = orderStatus;
                }

                public String getIfRefund() {
                    return ifRefund;
                }

                public void setIfRefund(String ifRefund) {
                    this.ifRefund = ifRefund;
                }

                public Object getRefundTime() {
                    return refundTime;
                }

                public void setRefundTime(Object refundTime) {
                    this.refundTime = refundTime;
                }

                public Object getCustRemarks() {
                    return custRemarks;
                }

                public void setCustRemarks(Object custRemarks) {
                    this.custRemarks = custRemarks;
                }

                public String getTransId() {
                    return transId;
                }

                public void setTransId(String transId) {
                    this.transId = transId;
                }

                public Object getQrcode() {
                    return qrcode;
                }

                public void setQrcode(Object qrcode) {
                    this.qrcode = qrcode;
                }

                public Object getUpdatePgm() {
                    return updatePgm;
                }

                public void setUpdatePgm(Object updatePgm) {
                    this.updatePgm = updatePgm;
                }

                public int getIsOwner() {
                    return isOwner;
                }

                public void setIsOwner(int isOwner) {
                    this.isOwner = isOwner;
                }

                public String getGpactId() {
                    return gpactId;
                }

                public void setGpactId(String gpactId) {
                    this.gpactId = gpactId;
                }

                public int getJoinNums() {
                    return joinNums;
                }

                public void setJoinNums(int joinNums) {
                    this.joinNums = joinNums;
                }

                public String getEndTimes() {
                    return endTimes;
                }

                public void setEndTimes(String endTimes) {
                    this.endTimes = endTimes;
                }

                public String getShopId() {
                    return shopId;
                }

                public void setShopId(String shopId) {
                    this.shopId = shopId;
                }
            }

            public static class AnsCustBasicBean  implements Serializable{
                /**
                 * id : null
                 * isNewRecord : true
                 * remarks : null
                 * createDate : null
                 * updateDate : null
                 * startDate : null
                 * endDate : null
                 * contractConfirm : null
                 * cellPhone : null
                 * deviceToken : null
                 * userName : 15720682665
                 * userPass : null
                 * wechatId : null
                 * wechatToken : null
                 * qqId : null
                 * qqToken : null
                 * completeFlag : null
                 * headPic : https://nwptest.oss-cn-hangzhou.aliyuncs.com/img/2018-07-25/1532485141162.png
                 * lastName : null
                 * firstName : null
                 * idCard : null
                 * nameIdentify : null
                 * sex : null
                 * birthday : null
                 * registerDate : null
                 * nickName : null
                 * loginIp : null
                 * logininTime : null
                 * loginoutTime : null
                 * loginFlag : null
                 * recommendUser : null
                 * recommendCode : null
                 * updatBy : null
                 * updatePgm : null
                 */

                private Object id;
                private boolean isNewRecord;
                private Object remarks;
                private Object createDate;
                private Object updateDate;
                private Object startDate;
                private Object endDate;
                private Object contractConfirm;
                private Object cellPhone;
                private Object deviceToken;
                private String userName;
                private Object userPass;
                private Object wechatId;
                private Object wechatToken;
                private Object qqId;
                private Object qqToken;
                private Object completeFlag;
                private String headPic;
                private Object lastName;
                private Object firstName;
                private Object idCard;
                private Object nameIdentify;
                private Object sex;
                private Object birthday;
                private Object registerDate;
                private Object nickName;
                private Object loginIp;
                private Object logininTime;
                private Object loginoutTime;
                private Object loginFlag;
                private Object recommendUser;
                private Object recommendCode;
                private Object updatBy;
                private Object updatePgm;

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

                public Object getContractConfirm() {
                    return contractConfirm;
                }

                public void setContractConfirm(Object contractConfirm) {
                    this.contractConfirm = contractConfirm;
                }

                public Object getCellPhone() {
                    return cellPhone;
                }

                public void setCellPhone(Object cellPhone) {
                    this.cellPhone = cellPhone;
                }

                public Object getDeviceToken() {
                    return deviceToken;
                }

                public void setDeviceToken(Object deviceToken) {
                    this.deviceToken = deviceToken;
                }

                public String getUserName() {
                    return userName;
                }

                public void setUserName(String userName) {
                    this.userName = userName;
                }

                public Object getUserPass() {
                    return userPass;
                }

                public void setUserPass(Object userPass) {
                    this.userPass = userPass;
                }

                public Object getWechatId() {
                    return wechatId;
                }

                public void setWechatId(Object wechatId) {
                    this.wechatId = wechatId;
                }

                public Object getWechatToken() {
                    return wechatToken;
                }

                public void setWechatToken(Object wechatToken) {
                    this.wechatToken = wechatToken;
                }

                public Object getQqId() {
                    return qqId;
                }

                public void setQqId(Object qqId) {
                    this.qqId = qqId;
                }

                public Object getQqToken() {
                    return qqToken;
                }

                public void setQqToken(Object qqToken) {
                    this.qqToken = qqToken;
                }

                public Object getCompleteFlag() {
                    return completeFlag;
                }

                public void setCompleteFlag(Object completeFlag) {
                    this.completeFlag = completeFlag;
                }

                public String getHeadPic() {
                    return headPic;
                }

                public void setHeadPic(String headPic) {
                    this.headPic = headPic;
                }

                public Object getLastName() {
                    return lastName;
                }

                public void setLastName(Object lastName) {
                    this.lastName = lastName;
                }

                public Object getFirstName() {
                    return firstName;
                }

                public void setFirstName(Object firstName) {
                    this.firstName = firstName;
                }

                public Object getIdCard() {
                    return idCard;
                }

                public void setIdCard(Object idCard) {
                    this.idCard = idCard;
                }

                public Object getNameIdentify() {
                    return nameIdentify;
                }

                public void setNameIdentify(Object nameIdentify) {
                    this.nameIdentify = nameIdentify;
                }

                public Object getSex() {
                    return sex;
                }

                public void setSex(Object sex) {
                    this.sex = sex;
                }

                public Object getBirthday() {
                    return birthday;
                }

                public void setBirthday(Object birthday) {
                    this.birthday = birthday;
                }

                public Object getRegisterDate() {
                    return registerDate;
                }

                public void setRegisterDate(Object registerDate) {
                    this.registerDate = registerDate;
                }

                public Object getNickName() {
                    return nickName;
                }

                public void setNickName(Object nickName) {
                    this.nickName = nickName;
                }

                public Object getLoginIp() {
                    return loginIp;
                }

                public void setLoginIp(Object loginIp) {
                    this.loginIp = loginIp;
                }

                public Object getLogininTime() {
                    return logininTime;
                }

                public void setLogininTime(Object logininTime) {
                    this.logininTime = logininTime;
                }

                public Object getLoginoutTime() {
                    return loginoutTime;
                }

                public void setLoginoutTime(Object loginoutTime) {
                    this.loginoutTime = loginoutTime;
                }

                public Object getLoginFlag() {
                    return loginFlag;
                }

                public void setLoginFlag(Object loginFlag) {
                    this.loginFlag = loginFlag;
                }

                public Object getRecommendUser() {
                    return recommendUser;
                }

                public void setRecommendUser(Object recommendUser) {
                    this.recommendUser = recommendUser;
                }

                public Object getRecommendCode() {
                    return recommendCode;
                }

                public void setRecommendCode(Object recommendCode) {
                    this.recommendCode = recommendCode;
                }

                public Object getUpdatBy() {
                    return updatBy;
                }

                public void setUpdatBy(Object updatBy) {
                    this.updatBy = updatBy;
                }

                public Object getUpdatePgm() {
                    return updatePgm;
                }

                public void setUpdatePgm(Object updatePgm) {
                    this.updatePgm = updatePgm;
                }
            }
        }
    }
}
