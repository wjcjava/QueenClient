package com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean;

/**
 * 作者：linxi on 2018/10/12 09:10
 * 邮箱：707078566@qq.com
 * 用途：
 */
public class SecKillDetailBean {

    /**
     * success : true
     * errorCode : 0
     * msg : 成功
     * body : {"GoodsListData":{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"ecGoodsBasic":null,"ecGoodsSocre":null,"ansSecKillGoods":{"id":"67b49714b29c47928eb13577b436a22f","isNewRecord":false,"remarks":null,"createDate":"2018-10-08 15:06:51","updateDate":"2018-10-08 15:06:51","startDate":null,"endDate":null,"goodsNo":"181008002","goodsName":"溜溜小王子发型","onlinePrice":12,"offlinePrice":12,"serviceDesc":"12","serviceDuration":12,"shopId":"4000b361c752458082f41adce83fabed","goodsCover":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/img/2018-10-08/1538982402493.png","goodsPic":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/img/2018-10-08/1538982407532.jpg","goodsDetails":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/img/2018-10-08/1538982410666.jpg","goodsPageView":"0","goodsAverageScore":null,"goodsPraiseRate":null,"enableFlag":"0","packageNo":null,"goodsNumber":0,"secKillNumber":0,"status":null,"goodsNames":null},"ansShopBasic":{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"merchantId":null,"contractConfirm":null,"ifContract":null,"shopName":null,"shortName":null,"shopNo":null,"marketAssistant":null,"shopBrief":null,"shopAccounce":null,"ifNew":null,"shopBanner":null,"shopActivity":null,"shopFeature":null,"queenCard":"0","shopTab":null,"shopCate":null,"industryCate":null,"belongCity":null,"addrProvince":"江苏省","addrCity":"苏州市","addrDistrict":"相城区","shopAddr":"黄桥东街102号西南125米","openTime":null,"closeTime":null,"serviceTel":null,"shopContacts":null,"contactsTel":null,"contactsMail":null,"ifLicence":null,"shopProperty":null,"shopLegal":null,"legalIdc":null,"legalIdp":null,"legalProvince":null,"legalCity":null,"legalDistrict":null,"legalAddress":null,"taxNumber":null,"businessLicence":null,"shopCharge":null,"chargeIdc":null,"chargeIdp":null,"shopLogo":null,"shopPhoto":null,"shopEnvPhoto":null,"joinTime":null,"businessFlag":null,"enableFlag":null,"signFlag":null,"geoX":120.58833,"geoY":31.378402,"updatePgm":null,"belongCityName":null,"apiAnsCustCartList":null,"goodsCounts":0,"approveBy":null,"marketAssistantName":null,"shopChargeTel":null,"shelfcount":0,"mainBusiness":null,"shopCashPhoto":null,"shopDoorPhoto":null,"shopOtherPhoto":null,"approveDate":null,"loginTime":null,"claimTime":null,"orderNumber":null,"goodsNumber":null,"specialOfferGoods":0,"groupGoods":0,"cpNumber":0,"openFee":0,"serviceFee":0,"servicePeriod":null,"signStart":null,"signEnd":null,"signStartDate":null,"signEndDate":null,"ansSnsType":null,"snsId":null,"snsName":null,"serviceAgreement":null,"adAgreement":null,"otherAgreement":null,"unionBeginTime":null,"unionEndTime":null,"queenShopDiscount":null,"avgService":0,"avgEnvironment":0,"comScore":0},"ecGoodsBrowses":null,"ansCustCollection":null,"praiseRate":0,"ecPointsRule":null,"goodsTabLabel":null,"goodsCateName":null,"goodsTypeLabel":null,"shopIdName":"Fc测试","saleFlagLabel":null,"contentByTitle":null,"goodsAppraiseLabel":null,"newFlagLabel":null,"enableFlag":null,"ifCreateInfo":null,"apiGoodsType":null,"statusType":null}}
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
         * GoodsListData : {"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"ecGoodsBasic":null,"ecGoodsSocre":null,"ansSecKillGoods":{"id":"67b49714b29c47928eb13577b436a22f","isNewRecord":false,"remarks":null,"createDate":"2018-10-08 15:06:51","updateDate":"2018-10-08 15:06:51","startDate":null,"endDate":null,"goodsNo":"181008002","goodsName":"溜溜小王子发型","onlinePrice":12,"offlinePrice":12,"serviceDesc":"12","serviceDuration":12,"shopId":"4000b361c752458082f41adce83fabed","goodsCover":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/img/2018-10-08/1538982402493.png","goodsPic":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/img/2018-10-08/1538982407532.jpg","goodsDetails":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/img/2018-10-08/1538982410666.jpg","goodsPageView":"0","goodsAverageScore":null,"goodsPraiseRate":null,"enableFlag":"0","packageNo":null,"goodsNumber":0,"secKillNumber":0,"status":null,"goodsNames":null},"ansShopBasic":{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"merchantId":null,"contractConfirm":null,"ifContract":null,"shopName":null,"shortName":null,"shopNo":null,"marketAssistant":null,"shopBrief":null,"shopAccounce":null,"ifNew":null,"shopBanner":null,"shopActivity":null,"shopFeature":null,"queenCard":"0","shopTab":null,"shopCate":null,"industryCate":null,"belongCity":null,"addrProvince":"江苏省","addrCity":"苏州市","addrDistrict":"相城区","shopAddr":"黄桥东街102号西南125米","openTime":null,"closeTime":null,"serviceTel":null,"shopContacts":null,"contactsTel":null,"contactsMail":null,"ifLicence":null,"shopProperty":null,"shopLegal":null,"legalIdc":null,"legalIdp":null,"legalProvince":null,"legalCity":null,"legalDistrict":null,"legalAddress":null,"taxNumber":null,"businessLicence":null,"shopCharge":null,"chargeIdc":null,"chargeIdp":null,"shopLogo":null,"shopPhoto":null,"shopEnvPhoto":null,"joinTime":null,"businessFlag":null,"enableFlag":null,"signFlag":null,"geoX":120.58833,"geoY":31.378402,"updatePgm":null,"belongCityName":null,"apiAnsCustCartList":null,"goodsCounts":0,"approveBy":null,"marketAssistantName":null,"shopChargeTel":null,"shelfcount":0,"mainBusiness":null,"shopCashPhoto":null,"shopDoorPhoto":null,"shopOtherPhoto":null,"approveDate":null,"loginTime":null,"claimTime":null,"orderNumber":null,"goodsNumber":null,"specialOfferGoods":0,"groupGoods":0,"cpNumber":0,"openFee":0,"serviceFee":0,"servicePeriod":null,"signStart":null,"signEnd":null,"signStartDate":null,"signEndDate":null,"ansSnsType":null,"snsId":null,"snsName":null,"serviceAgreement":null,"adAgreement":null,"otherAgreement":null,"unionBeginTime":null,"unionEndTime":null,"queenShopDiscount":null,"avgService":0,"avgEnvironment":0,"comScore":0},"ecGoodsBrowses":null,"ansCustCollection":null,"praiseRate":0,"ecPointsRule":null,"goodsTabLabel":null,"goodsCateName":null,"goodsTypeLabel":null,"shopIdName":"Fc测试","saleFlagLabel":null,"contentByTitle":null,"goodsAppraiseLabel":null,"newFlagLabel":null,"enableFlag":null,"ifCreateInfo":null,"apiGoodsType":null,"statusType":null}
         */

        private GoodsListDataBean GoodsListData;

        public GoodsListDataBean getGoodsListData() {
            return GoodsListData;
        }

        public void setGoodsListData(GoodsListDataBean GoodsListData) {
            this.GoodsListData = GoodsListData;
        }

        public static class GoodsListDataBean {
            /**
             * id : null
             * isNewRecord : true
             * remarks : null
             * createDate : null
             * updateDate : null
             * startDate : null
             * endDate : null
             * ecGoodsBasic : null
             * ecGoodsSocre : null
             * ansSecKillGoods : {"id":"67b49714b29c47928eb13577b436a22f","isNewRecord":false,"remarks":null,"createDate":"2018-10-08 15:06:51","updateDate":"2018-10-08 15:06:51","startDate":null,"endDate":null,"goodsNo":"181008002","goodsName":"溜溜小王子发型","onlinePrice":12,"offlinePrice":12,"serviceDesc":"12","serviceDuration":12,"shopId":"4000b361c752458082f41adce83fabed","goodsCover":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/img/2018-10-08/1538982402493.png","goodsPic":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/img/2018-10-08/1538982407532.jpg","goodsDetails":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/img/2018-10-08/1538982410666.jpg","goodsPageView":"0","goodsAverageScore":null,"goodsPraiseRate":null,"enableFlag":"0","packageNo":null,"goodsNumber":0,"secKillNumber":0,"status":null,"goodsNames":null}
             * ansShopBasic : {"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"merchantId":null,"contractConfirm":null,"ifContract":null,"shopName":null,"shortName":null,"shopNo":null,"marketAssistant":null,"shopBrief":null,"shopAccounce":null,"ifNew":null,"shopBanner":null,"shopActivity":null,"shopFeature":null,"queenCard":"0","shopTab":null,"shopCate":null,"industryCate":null,"belongCity":null,"addrProvince":"江苏省","addrCity":"苏州市","addrDistrict":"相城区","shopAddr":"黄桥东街102号西南125米","openTime":null,"closeTime":null,"serviceTel":null,"shopContacts":null,"contactsTel":null,"contactsMail":null,"ifLicence":null,"shopProperty":null,"shopLegal":null,"legalIdc":null,"legalIdp":null,"legalProvince":null,"legalCity":null,"legalDistrict":null,"legalAddress":null,"taxNumber":null,"businessLicence":null,"shopCharge":null,"chargeIdc":null,"chargeIdp":null,"shopLogo":null,"shopPhoto":null,"shopEnvPhoto":null,"joinTime":null,"businessFlag":null,"enableFlag":null,"signFlag":null,"geoX":120.58833,"geoY":31.378402,"updatePgm":null,"belongCityName":null,"apiAnsCustCartList":null,"goodsCounts":0,"approveBy":null,"marketAssistantName":null,"shopChargeTel":null,"shelfcount":0,"mainBusiness":null,"shopCashPhoto":null,"shopDoorPhoto":null,"shopOtherPhoto":null,"approveDate":null,"loginTime":null,"claimTime":null,"orderNumber":null,"goodsNumber":null,"specialOfferGoods":0,"groupGoods":0,"cpNumber":0,"openFee":0,"serviceFee":0,"servicePeriod":null,"signStart":null,"signEnd":null,"signStartDate":null,"signEndDate":null,"ansSnsType":null,"snsId":null,"snsName":null,"serviceAgreement":null,"adAgreement":null,"otherAgreement":null,"unionBeginTime":null,"unionEndTime":null,"queenShopDiscount":null,"avgService":0,"avgEnvironment":0,"comScore":0}
             * ecGoodsBrowses : null
             * ansCustCollection : null
             * praiseRate : 0.0
             * ecPointsRule : null
             * goodsTabLabel : null
             * goodsCateName : null
             * goodsTypeLabel : null
             * shopIdName : Fc测试
             * saleFlagLabel : null
             * contentByTitle : null
             * goodsAppraiseLabel : null
             * newFlagLabel : null
             * enableFlag : null
             * ifCreateInfo : null
             * apiGoodsType : null
             * statusType : null
             */

            private Object id;
            private boolean isNewRecord;
            private Object remarks;
            private Object createDate;
            private Object updateDate;
            private Object startDate;
            private Object endDate;
            private Object ecGoodsBasic;
            private Object ecGoodsSocre;
            private AnsSecKillGoodsBean ansSecKillGoods;
            private AnsShopBasicBean ansShopBasic;
            private Object ecGoodsBrowses;
            private Object ansCustCollection;
            private double praiseRate;
            private Object ecPointsRule;
            private Object goodsTabLabel;
            private Object goodsCateName;
            private Object goodsTypeLabel;
            private String shopIdName;
            private Object saleFlagLabel;
            private Object contentByTitle;
            private Object goodsAppraiseLabel;
            private Object newFlagLabel;
            private Object enableFlag;
            private Object ifCreateInfo;
            private Object apiGoodsType;
            private Object statusType;

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

            public Object getEcGoodsBasic() {
                return ecGoodsBasic;
            }

            public void setEcGoodsBasic(Object ecGoodsBasic) {
                this.ecGoodsBasic = ecGoodsBasic;
            }

            public Object getEcGoodsSocre() {
                return ecGoodsSocre;
            }

            public void setEcGoodsSocre(Object ecGoodsSocre) {
                this.ecGoodsSocre = ecGoodsSocre;
            }

            public AnsSecKillGoodsBean getAnsSecKillGoods() {
                return ansSecKillGoods;
            }

            public void setAnsSecKillGoods(AnsSecKillGoodsBean ansSecKillGoods) {
                this.ansSecKillGoods = ansSecKillGoods;
            }

            public AnsShopBasicBean getAnsShopBasic() {
                return ansShopBasic;
            }

            public void setAnsShopBasic(AnsShopBasicBean ansShopBasic) {
                this.ansShopBasic = ansShopBasic;
            }

            public Object getEcGoodsBrowses() {
                return ecGoodsBrowses;
            }

            public void setEcGoodsBrowses(Object ecGoodsBrowses) {
                this.ecGoodsBrowses = ecGoodsBrowses;
            }

            public Object getAnsCustCollection() {
                return ansCustCollection;
            }

            public void setAnsCustCollection(Object ansCustCollection) {
                this.ansCustCollection = ansCustCollection;
            }

            public double getPraiseRate() {
                return praiseRate;
            }

            public void setPraiseRate(double praiseRate) {
                this.praiseRate = praiseRate;
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

            public Object getEnableFlag() {
                return enableFlag;
            }

            public void setEnableFlag(Object enableFlag) {
                this.enableFlag = enableFlag;
            }

            public Object getIfCreateInfo() {
                return ifCreateInfo;
            }

            public void setIfCreateInfo(Object ifCreateInfo) {
                this.ifCreateInfo = ifCreateInfo;
            }

            public Object getApiGoodsType() {
                return apiGoodsType;
            }

            public void setApiGoodsType(Object apiGoodsType) {
                this.apiGoodsType = apiGoodsType;
            }

            public Object getStatusType() {
                return statusType;
            }

            public void setStatusType(Object statusType) {
                this.statusType = statusType;
            }

            public static class AnsSecKillGoodsBean {
                /**
                 * id : 67b49714b29c47928eb13577b436a22f
                 * isNewRecord : false
                 * remarks : null
                 * createDate : 2018-10-08 15:06:51
                 * updateDate : 2018-10-08 15:06:51
                 * startDate : null
                 * endDate : null
                 * goodsNo : 181008002
                 * goodsName : 溜溜小王子发型
                 * onlinePrice : 12.0
                 * offlinePrice : 12.0
                 * serviceDesc : 12
                 * serviceDuration : 12
                 * shopId : 4000b361c752458082f41adce83fabed
                 * goodsCover : https://nwptest.oss-cn-hangzhou.aliyuncs.com/img/2018-10-08/1538982402493.png
                 * goodsPic : https://nwptest.oss-cn-hangzhou.aliyuncs.com/img/2018-10-08/1538982407532.jpg
                 * goodsDetails : https://nwptest.oss-cn-hangzhou.aliyuncs.com/img/2018-10-08/1538982410666.jpg
                 * goodsPageView : 0
                 * goodsAverageScore : null
                 * goodsPraiseRate : null
                 * enableFlag : 0
                 * packageNo : null
                 * goodsNumber : 0
                 * secKillNumber : 0
                 * status : null
                 * goodsNames : null
                 */

                private String id;
                private boolean isNewRecord;
                private Object remarks;
                private String createDate;
                private String updateDate;
                private Object startDate;
                private Object endDate;
                private String goodsNo;
                private String goodsName;
                private double onlinePrice;
                private double offlinePrice;
                private String serviceDesc;
                private String serviceDuration;
                private String shopId;
                private String goodsCover;
                private String goodsPic;
                private String goodsDetails;
                private String goodsPageView;
                private Object goodsAverageScore;
                private Object goodsPraiseRate;
                private String enableFlag;
                private Object packageNo;
                private int goodsNumber;
                private int secKillNumber;
                private Object status;
                private Object goodsNames;

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

                public String getGoodsNo() {
                    return goodsNo;
                }

                public void setGoodsNo(String goodsNo) {
                    this.goodsNo = goodsNo;
                }

                public String getGoodsName() {
                    return goodsName;
                }

                public void setGoodsName(String goodsName) {
                    this.goodsName = goodsName;
                }

                public double getOnlinePrice() {
                    return onlinePrice;
                }

                public void setOnlinePrice(double onlinePrice) {
                    this.onlinePrice = onlinePrice;
                }

                public double getOfflinePrice() {
                    return offlinePrice;
                }

                public void setOfflinePrice(double offlinePrice) {
                    this.offlinePrice = offlinePrice;
                }

                public String getServiceDesc() {
                    return serviceDesc;
                }

                public void setServiceDesc(String serviceDesc) {
                    this.serviceDesc = serviceDesc;
                }

                public String getServiceDuration() {
                    return serviceDuration;
                }

                public void setServiceDuration(String serviceDuration) {
                    this.serviceDuration = serviceDuration;
                }

                public String getShopId() {
                    return shopId;
                }

                public void setShopId(String shopId) {
                    this.shopId = shopId;
                }

                public String getGoodsCover() {
                    return goodsCover;
                }

                public void setGoodsCover(String goodsCover) {
                    this.goodsCover = goodsCover;
                }

                public String getGoodsPic() {
                    return goodsPic;
                }

                public void setGoodsPic(String goodsPic) {
                    this.goodsPic = goodsPic;
                }

                public String getGoodsDetails() {
                    return goodsDetails;
                }

                public void setGoodsDetails(String goodsDetails) {
                    this.goodsDetails = goodsDetails;
                }

                public String getGoodsPageView() {
                    return goodsPageView;
                }

                public void setGoodsPageView(String goodsPageView) {
                    this.goodsPageView = goodsPageView;
                }

                public Object getGoodsAverageScore() {
                    return goodsAverageScore;
                }

                public void setGoodsAverageScore(Object goodsAverageScore) {
                    this.goodsAverageScore = goodsAverageScore;
                }

                public Object getGoodsPraiseRate() {
                    return goodsPraiseRate;
                }

                public void setGoodsPraiseRate(Object goodsPraiseRate) {
                    this.goodsPraiseRate = goodsPraiseRate;
                }

                public String getEnableFlag() {
                    return enableFlag;
                }

                public void setEnableFlag(String enableFlag) {
                    this.enableFlag = enableFlag;
                }

                public Object getPackageNo() {
                    return packageNo;
                }

                public void setPackageNo(Object packageNo) {
                    this.packageNo = packageNo;
                }

                public int getGoodsNumber() {
                    return goodsNumber;
                }

                public void setGoodsNumber(int goodsNumber) {
                    this.goodsNumber = goodsNumber;
                }

                public int getSecKillNumber() {
                    return secKillNumber;
                }

                public void setSecKillNumber(int secKillNumber) {
                    this.secKillNumber = secKillNumber;
                }

                public Object getStatus() {
                    return status;
                }

                public void setStatus(Object status) {
                    this.status = status;
                }

                public Object getGoodsNames() {
                    return goodsNames;
                }

                public void setGoodsNames(Object goodsNames) {
                    this.goodsNames = goodsNames;
                }
            }

            public static class AnsShopBasicBean {
                /**
                 * id : null
                 * isNewRecord : true
                 * remarks : null
                 * createDate : null
                 * updateDate : null
                 * startDate : null
                 * endDate : null
                 * merchantId : null
                 * contractConfirm : null
                 * ifContract : null
                 * shopName : null
                 * shortName : null
                 * shopNo : null
                 * marketAssistant : null
                 * shopBrief : null
                 * shopAccounce : null
                 * ifNew : null
                 * shopBanner : null
                 * shopActivity : null
                 * shopFeature : null
                 * queenCard : 0
                 * shopTab : null
                 * shopCate : null
                 * industryCate : null
                 * belongCity : null
                 * addrProvince : 江苏省
                 * addrCity : 苏州市
                 * addrDistrict : 相城区
                 * shopAddr : 黄桥东街102号西南125米
                 * openTime : null
                 * closeTime : null
                 * serviceTel : null
                 * shopContacts : null
                 * contactsTel : null
                 * contactsMail : null
                 * ifLicence : null
                 * shopProperty : null
                 * shopLegal : null
                 * legalIdc : null
                 * legalIdp : null
                 * legalProvince : null
                 * legalCity : null
                 * legalDistrict : null
                 * legalAddress : null
                 * taxNumber : null
                 * businessLicence : null
                 * shopCharge : null
                 * chargeIdc : null
                 * chargeIdp : null
                 * shopLogo : null
                 * shopPhoto : null
                 * shopEnvPhoto : null
                 * joinTime : null
                 * businessFlag : null
                 * enableFlag : null
                 * signFlag : null
                 * geoX : 120.58833
                 * geoY : 31.378402
                 * updatePgm : null
                 * belongCityName : null
                 * apiAnsCustCartList : null
                 * goodsCounts : 0
                 * approveBy : null
                 * marketAssistantName : null
                 * shopChargeTel : null
                 * shelfcount : 0
                 * mainBusiness : null
                 * shopCashPhoto : null
                 * shopDoorPhoto : null
                 * shopOtherPhoto : null
                 * approveDate : null
                 * loginTime : null
                 * claimTime : null
                 * orderNumber : null
                 * goodsNumber : null
                 * specialOfferGoods : 0
                 * groupGoods : 0
                 * cpNumber : 0
                 * openFee : 0.0
                 * serviceFee : 0.0
                 * servicePeriod : null
                 * signStart : null
                 * signEnd : null
                 * signStartDate : null
                 * signEndDate : null
                 * ansSnsType : null
                 * snsId : null
                 * snsName : null
                 * serviceAgreement : null
                 * adAgreement : null
                 * otherAgreement : null
                 * unionBeginTime : null
                 * unionEndTime : null
                 * queenShopDiscount : null
                 * avgService : 0.0
                 * avgEnvironment : 0.0
                 * comScore : 0.0
                 */

                private Object id;
                private boolean isNewRecord;
                private Object remarks;
                private Object createDate;
                private Object updateDate;
                private Object startDate;
                private Object endDate;
                private Object merchantId;
                private Object contractConfirm;
                private Object ifContract;
                private Object shopName;
                private Object shortName;
                private Object shopNo;
                private Object marketAssistant;
                private Object shopBrief;
                private Object shopAccounce;
                private Object ifNew;
                private Object shopBanner;
                private Object shopActivity;
                private Object shopFeature;
                private String queenCard;
                private Object shopTab;
                private Object shopCate;
                private Object industryCate;
                private Object belongCity;
                private String addrProvince;
                private String addrCity;
                private String addrDistrict;
                private String shopAddr;
                private Object openTime;
                private Object closeTime;
                private Object serviceTel;
                private Object shopContacts;
                private Object contactsTel;
                private Object contactsMail;
                private Object ifLicence;
                private Object shopProperty;
                private Object shopLegal;
                private Object legalIdc;
                private Object legalIdp;
                private Object legalProvince;
                private Object legalCity;
                private Object legalDistrict;
                private Object legalAddress;
                private Object taxNumber;
                private Object businessLicence;
                private Object shopCharge;
                private Object chargeIdc;
                private Object chargeIdp;
                private Object shopLogo;
                private Object shopPhoto;
                private Object shopEnvPhoto;
                private Object joinTime;
                private Object businessFlag;
                private Object enableFlag;
                private Object signFlag;
                private double geoX;
                private double geoY;
                private Object updatePgm;
                private Object belongCityName;
                private Object apiAnsCustCartList;
                private int goodsCounts;
                private Object approveBy;
                private Object marketAssistantName;
                private Object shopChargeTel;
                private int shelfcount;
                private Object mainBusiness;
                private Object shopCashPhoto;
                private Object shopDoorPhoto;
                private Object shopOtherPhoto;
                private Object approveDate;
                private Object loginTime;
                private Object claimTime;
                private Object orderNumber;
                private Object goodsNumber;
                private int specialOfferGoods;
                private int groupGoods;
                private int cpNumber;
                private double openFee;
                private double serviceFee;
                private Object servicePeriod;
                private Object signStart;
                private Object signEnd;
                private Object signStartDate;
                private Object signEndDate;
                private Object ansSnsType;
                private Object snsId;
                private Object snsName;
                private Object serviceAgreement;
                private Object adAgreement;
                private Object otherAgreement;
                private Object unionBeginTime;
                private Object unionEndTime;
                private Object queenShopDiscount;
                private double avgService;
                private double avgEnvironment;
                private double comScore;

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

                public Object getMerchantId() {
                    return merchantId;
                }

                public void setMerchantId(Object merchantId) {
                    this.merchantId = merchantId;
                }

                public Object getContractConfirm() {
                    return contractConfirm;
                }

                public void setContractConfirm(Object contractConfirm) {
                    this.contractConfirm = contractConfirm;
                }

                public Object getIfContract() {
                    return ifContract;
                }

                public void setIfContract(Object ifContract) {
                    this.ifContract = ifContract;
                }

                public Object getShopName() {
                    return shopName;
                }

                public void setShopName(Object shopName) {
                    this.shopName = shopName;
                }

                public Object getShortName() {
                    return shortName;
                }

                public void setShortName(Object shortName) {
                    this.shortName = shortName;
                }

                public Object getShopNo() {
                    return shopNo;
                }

                public void setShopNo(Object shopNo) {
                    this.shopNo = shopNo;
                }

                public Object getMarketAssistant() {
                    return marketAssistant;
                }

                public void setMarketAssistant(Object marketAssistant) {
                    this.marketAssistant = marketAssistant;
                }

                public Object getShopBrief() {
                    return shopBrief;
                }

                public void setShopBrief(Object shopBrief) {
                    this.shopBrief = shopBrief;
                }

                public Object getShopAccounce() {
                    return shopAccounce;
                }

                public void setShopAccounce(Object shopAccounce) {
                    this.shopAccounce = shopAccounce;
                }

                public Object getIfNew() {
                    return ifNew;
                }

                public void setIfNew(Object ifNew) {
                    this.ifNew = ifNew;
                }

                public Object getShopBanner() {
                    return shopBanner;
                }

                public void setShopBanner(Object shopBanner) {
                    this.shopBanner = shopBanner;
                }

                public Object getShopActivity() {
                    return shopActivity;
                }

                public void setShopActivity(Object shopActivity) {
                    this.shopActivity = shopActivity;
                }

                public Object getShopFeature() {
                    return shopFeature;
                }

                public void setShopFeature(Object shopFeature) {
                    this.shopFeature = shopFeature;
                }

                public String getQueenCard() {
                    return queenCard;
                }

                public void setQueenCard(String queenCard) {
                    this.queenCard = queenCard;
                }

                public Object getShopTab() {
                    return shopTab;
                }

                public void setShopTab(Object shopTab) {
                    this.shopTab = shopTab;
                }

                public Object getShopCate() {
                    return shopCate;
                }

                public void setShopCate(Object shopCate) {
                    this.shopCate = shopCate;
                }

                public Object getIndustryCate() {
                    return industryCate;
                }

                public void setIndustryCate(Object industryCate) {
                    this.industryCate = industryCate;
                }

                public Object getBelongCity() {
                    return belongCity;
                }

                public void setBelongCity(Object belongCity) {
                    this.belongCity = belongCity;
                }

                public String getAddrProvince() {
                    return addrProvince;
                }

                public void setAddrProvince(String addrProvince) {
                    this.addrProvince = addrProvince;
                }

                public String getAddrCity() {
                    return addrCity;
                }

                public void setAddrCity(String addrCity) {
                    this.addrCity = addrCity;
                }

                public String getAddrDistrict() {
                    return addrDistrict;
                }

                public void setAddrDistrict(String addrDistrict) {
                    this.addrDistrict = addrDistrict;
                }

                public String getShopAddr() {
                    return shopAddr;
                }

                public void setShopAddr(String shopAddr) {
                    this.shopAddr = shopAddr;
                }

                public Object getOpenTime() {
                    return openTime;
                }

                public void setOpenTime(Object openTime) {
                    this.openTime = openTime;
                }

                public Object getCloseTime() {
                    return closeTime;
                }

                public void setCloseTime(Object closeTime) {
                    this.closeTime = closeTime;
                }

                public Object getServiceTel() {
                    return serviceTel;
                }

                public void setServiceTel(Object serviceTel) {
                    this.serviceTel = serviceTel;
                }

                public Object getShopContacts() {
                    return shopContacts;
                }

                public void setShopContacts(Object shopContacts) {
                    this.shopContacts = shopContacts;
                }

                public Object getContactsTel() {
                    return contactsTel;
                }

                public void setContactsTel(Object contactsTel) {
                    this.contactsTel = contactsTel;
                }

                public Object getContactsMail() {
                    return contactsMail;
                }

                public void setContactsMail(Object contactsMail) {
                    this.contactsMail = contactsMail;
                }

                public Object getIfLicence() {
                    return ifLicence;
                }

                public void setIfLicence(Object ifLicence) {
                    this.ifLicence = ifLicence;
                }

                public Object getShopProperty() {
                    return shopProperty;
                }

                public void setShopProperty(Object shopProperty) {
                    this.shopProperty = shopProperty;
                }

                public Object getShopLegal() {
                    return shopLegal;
                }

                public void setShopLegal(Object shopLegal) {
                    this.shopLegal = shopLegal;
                }

                public Object getLegalIdc() {
                    return legalIdc;
                }

                public void setLegalIdc(Object legalIdc) {
                    this.legalIdc = legalIdc;
                }

                public Object getLegalIdp() {
                    return legalIdp;
                }

                public void setLegalIdp(Object legalIdp) {
                    this.legalIdp = legalIdp;
                }

                public Object getLegalProvince() {
                    return legalProvince;
                }

                public void setLegalProvince(Object legalProvince) {
                    this.legalProvince = legalProvince;
                }

                public Object getLegalCity() {
                    return legalCity;
                }

                public void setLegalCity(Object legalCity) {
                    this.legalCity = legalCity;
                }

                public Object getLegalDistrict() {
                    return legalDistrict;
                }

                public void setLegalDistrict(Object legalDistrict) {
                    this.legalDistrict = legalDistrict;
                }

                public Object getLegalAddress() {
                    return legalAddress;
                }

                public void setLegalAddress(Object legalAddress) {
                    this.legalAddress = legalAddress;
                }

                public Object getTaxNumber() {
                    return taxNumber;
                }

                public void setTaxNumber(Object taxNumber) {
                    this.taxNumber = taxNumber;
                }

                public Object getBusinessLicence() {
                    return businessLicence;
                }

                public void setBusinessLicence(Object businessLicence) {
                    this.businessLicence = businessLicence;
                }

                public Object getShopCharge() {
                    return shopCharge;
                }

                public void setShopCharge(Object shopCharge) {
                    this.shopCharge = shopCharge;
                }

                public Object getChargeIdc() {
                    return chargeIdc;
                }

                public void setChargeIdc(Object chargeIdc) {
                    this.chargeIdc = chargeIdc;
                }

                public Object getChargeIdp() {
                    return chargeIdp;
                }

                public void setChargeIdp(Object chargeIdp) {
                    this.chargeIdp = chargeIdp;
                }

                public Object getShopLogo() {
                    return shopLogo;
                }

                public void setShopLogo(Object shopLogo) {
                    this.shopLogo = shopLogo;
                }

                public Object getShopPhoto() {
                    return shopPhoto;
                }

                public void setShopPhoto(Object shopPhoto) {
                    this.shopPhoto = shopPhoto;
                }

                public Object getShopEnvPhoto() {
                    return shopEnvPhoto;
                }

                public void setShopEnvPhoto(Object shopEnvPhoto) {
                    this.shopEnvPhoto = shopEnvPhoto;
                }

                public Object getJoinTime() {
                    return joinTime;
                }

                public void setJoinTime(Object joinTime) {
                    this.joinTime = joinTime;
                }

                public Object getBusinessFlag() {
                    return businessFlag;
                }

                public void setBusinessFlag(Object businessFlag) {
                    this.businessFlag = businessFlag;
                }

                public Object getEnableFlag() {
                    return enableFlag;
                }

                public void setEnableFlag(Object enableFlag) {
                    this.enableFlag = enableFlag;
                }

                public Object getSignFlag() {
                    return signFlag;
                }

                public void setSignFlag(Object signFlag) {
                    this.signFlag = signFlag;
                }

                public double getGeoX() {
                    return geoX;
                }

                public void setGeoX(double geoX) {
                    this.geoX = geoX;
                }

                public double getGeoY() {
                    return geoY;
                }

                public void setGeoY(double geoY) {
                    this.geoY = geoY;
                }

                public Object getUpdatePgm() {
                    return updatePgm;
                }

                public void setUpdatePgm(Object updatePgm) {
                    this.updatePgm = updatePgm;
                }

                public Object getBelongCityName() {
                    return belongCityName;
                }

                public void setBelongCityName(Object belongCityName) {
                    this.belongCityName = belongCityName;
                }

                public Object getApiAnsCustCartList() {
                    return apiAnsCustCartList;
                }

                public void setApiAnsCustCartList(Object apiAnsCustCartList) {
                    this.apiAnsCustCartList = apiAnsCustCartList;
                }

                public int getGoodsCounts() {
                    return goodsCounts;
                }

                public void setGoodsCounts(int goodsCounts) {
                    this.goodsCounts = goodsCounts;
                }

                public Object getApproveBy() {
                    return approveBy;
                }

                public void setApproveBy(Object approveBy) {
                    this.approveBy = approveBy;
                }

                public Object getMarketAssistantName() {
                    return marketAssistantName;
                }

                public void setMarketAssistantName(Object marketAssistantName) {
                    this.marketAssistantName = marketAssistantName;
                }

                public Object getShopChargeTel() {
                    return shopChargeTel;
                }

                public void setShopChargeTel(Object shopChargeTel) {
                    this.shopChargeTel = shopChargeTel;
                }

                public int getShelfcount() {
                    return shelfcount;
                }

                public void setShelfcount(int shelfcount) {
                    this.shelfcount = shelfcount;
                }

                public Object getMainBusiness() {
                    return mainBusiness;
                }

                public void setMainBusiness(Object mainBusiness) {
                    this.mainBusiness = mainBusiness;
                }

                public Object getShopCashPhoto() {
                    return shopCashPhoto;
                }

                public void setShopCashPhoto(Object shopCashPhoto) {
                    this.shopCashPhoto = shopCashPhoto;
                }

                public Object getShopDoorPhoto() {
                    return shopDoorPhoto;
                }

                public void setShopDoorPhoto(Object shopDoorPhoto) {
                    this.shopDoorPhoto = shopDoorPhoto;
                }

                public Object getShopOtherPhoto() {
                    return shopOtherPhoto;
                }

                public void setShopOtherPhoto(Object shopOtherPhoto) {
                    this.shopOtherPhoto = shopOtherPhoto;
                }

                public Object getApproveDate() {
                    return approveDate;
                }

                public void setApproveDate(Object approveDate) {
                    this.approveDate = approveDate;
                }

                public Object getLoginTime() {
                    return loginTime;
                }

                public void setLoginTime(Object loginTime) {
                    this.loginTime = loginTime;
                }

                public Object getClaimTime() {
                    return claimTime;
                }

                public void setClaimTime(Object claimTime) {
                    this.claimTime = claimTime;
                }

                public Object getOrderNumber() {
                    return orderNumber;
                }

                public void setOrderNumber(Object orderNumber) {
                    this.orderNumber = orderNumber;
                }

                public Object getGoodsNumber() {
                    return goodsNumber;
                }

                public void setGoodsNumber(Object goodsNumber) {
                    this.goodsNumber = goodsNumber;
                }

                public int getSpecialOfferGoods() {
                    return specialOfferGoods;
                }

                public void setSpecialOfferGoods(int specialOfferGoods) {
                    this.specialOfferGoods = specialOfferGoods;
                }

                public int getGroupGoods() {
                    return groupGoods;
                }

                public void setGroupGoods(int groupGoods) {
                    this.groupGoods = groupGoods;
                }

                public int getCpNumber() {
                    return cpNumber;
                }

                public void setCpNumber(int cpNumber) {
                    this.cpNumber = cpNumber;
                }

                public double getOpenFee() {
                    return openFee;
                }

                public void setOpenFee(double openFee) {
                    this.openFee = openFee;
                }

                public double getServiceFee() {
                    return serviceFee;
                }

                public void setServiceFee(double serviceFee) {
                    this.serviceFee = serviceFee;
                }

                public Object getServicePeriod() {
                    return servicePeriod;
                }

                public void setServicePeriod(Object servicePeriod) {
                    this.servicePeriod = servicePeriod;
                }

                public Object getSignStart() {
                    return signStart;
                }

                public void setSignStart(Object signStart) {
                    this.signStart = signStart;
                }

                public Object getSignEnd() {
                    return signEnd;
                }

                public void setSignEnd(Object signEnd) {
                    this.signEnd = signEnd;
                }

                public Object getSignStartDate() {
                    return signStartDate;
                }

                public void setSignStartDate(Object signStartDate) {
                    this.signStartDate = signStartDate;
                }

                public Object getSignEndDate() {
                    return signEndDate;
                }

                public void setSignEndDate(Object signEndDate) {
                    this.signEndDate = signEndDate;
                }

                public Object getAnsSnsType() {
                    return ansSnsType;
                }

                public void setAnsSnsType(Object ansSnsType) {
                    this.ansSnsType = ansSnsType;
                }

                public Object getSnsId() {
                    return snsId;
                }

                public void setSnsId(Object snsId) {
                    this.snsId = snsId;
                }

                public Object getSnsName() {
                    return snsName;
                }

                public void setSnsName(Object snsName) {
                    this.snsName = snsName;
                }

                public Object getServiceAgreement() {
                    return serviceAgreement;
                }

                public void setServiceAgreement(Object serviceAgreement) {
                    this.serviceAgreement = serviceAgreement;
                }

                public Object getAdAgreement() {
                    return adAgreement;
                }

                public void setAdAgreement(Object adAgreement) {
                    this.adAgreement = adAgreement;
                }

                public Object getOtherAgreement() {
                    return otherAgreement;
                }

                public void setOtherAgreement(Object otherAgreement) {
                    this.otherAgreement = otherAgreement;
                }

                public Object getUnionBeginTime() {
                    return unionBeginTime;
                }

                public void setUnionBeginTime(Object unionBeginTime) {
                    this.unionBeginTime = unionBeginTime;
                }

                public Object getUnionEndTime() {
                    return unionEndTime;
                }

                public void setUnionEndTime(Object unionEndTime) {
                    this.unionEndTime = unionEndTime;
                }

                public Object getQueenShopDiscount() {
                    return queenShopDiscount;
                }

                public void setQueenShopDiscount(Object queenShopDiscount) {
                    this.queenShopDiscount = queenShopDiscount;
                }

                public double getAvgService() {
                    return avgService;
                }

                public void setAvgService(double avgService) {
                    this.avgService = avgService;
                }

                public double getAvgEnvironment() {
                    return avgEnvironment;
                }

                public void setAvgEnvironment(double avgEnvironment) {
                    this.avgEnvironment = avgEnvironment;
                }

                public double getComScore() {
                    return comScore;
                }

                public void setComScore(double comScore) {
                    this.comScore = comScore;
                }
            }
        }
    }
}
