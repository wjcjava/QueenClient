package com.ainisi.queenmirror.queenmirrorcduan.bean;

import java.util.List;

/**
 * Created by john on 2018/9/11.
 *
 * jl
 */

public class HolidayListBean {


    /**
     * success : true
     * errorCode : 0
     * msg : 获取数据成功
     * body : {"ansBannerphoto":{"id":"eaeeae22f23f4575bd782a7ebd013f8a","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"bannerStyle":"1","bannerCategory":"0","isPush":"0","pushContent":null,"pageLocation":"4","showSort":null,"bannerName":"拼团规则","bannerUrl":"","bannerLogo":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/img/2018-09-12/1536714418625.jpg","startTime":"2018-09-01 00:00:00","endTime":"2018-09-25 00:00:00","bannerDetails":"的","enableFlag":"0","releaseBy":null,"releaseDate":"2018-09-07 00:00:00","shopIds":null,"goodsIds":null,"platformType":0,"goodsId":"","bannerActivityType":"mid-autumn-festival","type":null,"activityId":null},"bannerList":[{"id":"a1810f52be634012989d9795e80c93a5","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"bannerStyle":"2","bannerCategory":"0","isPush":"0","pushContent":null,"pageLocation":"2","showSort":1,"bannerName":"人气爆款榜1","bannerUrl":"","bannerLogo":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/img/2018-09-12/1536714418625.jpg","startTime":"2018-09-07 00:00:00","endTime":"2018-09-25 00:00:00","bannerDetails":"","enableFlag":"0","releaseBy":null,"releaseDate":"2018-09-12 00:00:00","shopIds":null,"goodsIds":null,"platformType":0,"goodsId":"c653894c32564300a9dfabfdab0b71de","bannerActivityType":"mid-autumn-festival","type":null,"activityId":"e3ced9d754b841b189addbf4b37d1f2f"}],"goodslist":[{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"ecGoodsBasic":{"id":"a523d56d7187491f92562fe1ec3c03f3","isNewRecord":false,"remarks":null,"createDate":"2018-09-07 10:27:06","updateDate":"2018-09-07 10:28:59","startDate":null,"endDate":null,"goodsCate":"d93edbd7180246aca91c368b1d64b937","goodsType":"2","goodsName":"杭州半永久","goodsNo":"4132a4b62","goodsBrief":"半永久","goodsSort":0,"serviceTime":"30","goodsDetails":null,"goodsThumb":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018090710270015787395.jpg","goodsPic":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018090710270315974172.jpg","goodsShow":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018090710270015787395.jpg","goodsTab":null,"goodsStorage":0,"marketPrice":1,"salesPrice":1,"goodsActivity":null,"goodsBanner":null,"shopId":"a3eccc2f1ef649e09c03f5647241f363","saleFlag":"2","ifPoint":"0","pointRule":null,"approveBy":null,"approveDate":1536287277000,"approveRemarks":"","startTime":null,"endTime":null,"goodsRemarks":null,"updatePgm":"ApiGoodsController","shopName":null,"saleFlagName":null,"goodsTypeName":null,"goodsCateName":null,"ecPointsRule":null,"buyRule":null,"cityCode":null,"groupGoods":null,"activityId":"fc8c7453b9914aecaa1ed6561dba1419","groupPrice":0.1,"groupNumber":2,"queenCard":null,"fromPrice":0,"endPrice":0},"ecGoodsSocre":null,"ansShopBasic":{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"merchantId":null,"contractConfirm":null,"ifContract":null,"shopName":"品品品●®♡尚","shortName":null,"shopNo":null,"marketAssistant":null,"shopBrief":null,"shopAccounce":null,"ifNew":null,"shopBanner":null,"shopActivity":null,"shopFeature":null,"queenCard":null,"shopTab":null,"shopCate":null,"industryCate":null,"belongCity":null,"addrProvince":null,"addrCity":null,"addrDistrict":null,"shopAddr":null,"openTime":null,"closeTime":null,"serviceTel":null,"shopContacts":null,"contactsTel":null,"contactsMail":null,"ifLicence":null,"shopProperty":null,"shopLegal":null,"legalIdc":null,"legalIdp":null,"legalProvince":null,"legalCity":null,"legalDistrict":null,"legalAddress":null,"taxNumber":null,"businessLicence":null,"shopCharge":null,"chargeIdc":null,"chargeIdp":null,"shopLogo":null,"shopPhoto":null,"shopEnvPhoto":null,"joinTime":null,"businessFlag":null,"enableFlag":null,"signFlag":null,"geoX":null,"geoY":null,"updatePgm":null,"belongCityName":null,"apiAnsCustCartList":null,"goodsCounts":0,"approveBy":null,"marketAssistantName":null,"shopChargeTel":null,"shelfcount":0,"mainBusiness":null,"shopCashPhoto":null,"shopDoorPhoto":null,"shopOtherPhoto":null,"approveDate":null,"loginTime":null,"claimTime":null,"orderNumber":null,"goodsNumber":null,"openFee":0,"serviceFee":0,"servicePeriod":null,"signStart":null,"signEnd":null,"signStartDate":null,"signEndDate":null,"ansSnsType":null,"snsId":null,"snsName":null,"serviceAgreement":null,"adAgreement":null,"otherAgreement":null,"unionBeginTime":null,"unionEndTime":null,"queenShopDiscount":null,"avgService":0,"avgEnvironment":0,"comScore":0},"ecGoodsBrowses":{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"goodsId":null,"browseCounts":6,"enableFlag":null},"ansCustCollection":null,"praiseRate":0,"ecPointsRule":null,"goodsTabLabel":null,"goodsCateName":null,"goodsTypeLabel":null,"shopIdName":null,"saleFlagLabel":null,"contentByTitle":null,"goodsAppraiseLabel":null,"newFlagLabel":null,"enableFlag":null,"statusType":null}],"colorNo":"000000"}
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
         * ansBannerphoto : {"id":"eaeeae22f23f4575bd782a7ebd013f8a","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"bannerStyle":"1","bannerCategory":"0","isPush":"0","pushContent":null,"pageLocation":"4","showSort":null,"bannerName":"拼团规则","bannerUrl":"","bannerLogo":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/img/2018-09-12/1536714418625.jpg","startTime":"2018-09-01 00:00:00","endTime":"2018-09-25 00:00:00","bannerDetails":"的","enableFlag":"0","releaseBy":null,"releaseDate":"2018-09-07 00:00:00","shopIds":null,"goodsIds":null,"platformType":0,"goodsId":"","bannerActivityType":"mid-autumn-festival","type":null,"activityId":null}
         * bannerList : [{"id":"a1810f52be634012989d9795e80c93a5","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"bannerStyle":"2","bannerCategory":"0","isPush":"0","pushContent":null,"pageLocation":"2","showSort":1,"bannerName":"人气爆款榜1","bannerUrl":"","bannerLogo":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/img/2018-09-12/1536714418625.jpg","startTime":"2018-09-07 00:00:00","endTime":"2018-09-25 00:00:00","bannerDetails":"","enableFlag":"0","releaseBy":null,"releaseDate":"2018-09-12 00:00:00","shopIds":null,"goodsIds":null,"platformType":0,"goodsId":"c653894c32564300a9dfabfdab0b71de","bannerActivityType":"mid-autumn-festival","type":null,"activityId":"e3ced9d754b841b189addbf4b37d1f2f"}]
         * goodslist : [{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"ecGoodsBasic":{"id":"a523d56d7187491f92562fe1ec3c03f3","isNewRecord":false,"remarks":null,"createDate":"2018-09-07 10:27:06","updateDate":"2018-09-07 10:28:59","startDate":null,"endDate":null,"goodsCate":"d93edbd7180246aca91c368b1d64b937","goodsType":"2","goodsName":"杭州半永久","goodsNo":"4132a4b62","goodsBrief":"半永久","goodsSort":0,"serviceTime":"30","goodsDetails":null,"goodsThumb":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018090710270015787395.jpg","goodsPic":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018090710270315974172.jpg","goodsShow":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018090710270015787395.jpg","goodsTab":null,"goodsStorage":0,"marketPrice":1,"salesPrice":1,"goodsActivity":null,"goodsBanner":null,"shopId":"a3eccc2f1ef649e09c03f5647241f363","saleFlag":"2","ifPoint":"0","pointRule":null,"approveBy":null,"approveDate":1536287277000,"approveRemarks":"","startTime":null,"endTime":null,"goodsRemarks":null,"updatePgm":"ApiGoodsController","shopName":null,"saleFlagName":null,"goodsTypeName":null,"goodsCateName":null,"ecPointsRule":null,"buyRule":null,"cityCode":null,"groupGoods":null,"activityId":"fc8c7453b9914aecaa1ed6561dba1419","groupPrice":0.1,"groupNumber":2,"queenCard":null,"fromPrice":0,"endPrice":0},"ecGoodsSocre":null,"ansShopBasic":{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"merchantId":null,"contractConfirm":null,"ifContract":null,"shopName":"品品品●®♡尚","shortName":null,"shopNo":null,"marketAssistant":null,"shopBrief":null,"shopAccounce":null,"ifNew":null,"shopBanner":null,"shopActivity":null,"shopFeature":null,"queenCard":null,"shopTab":null,"shopCate":null,"industryCate":null,"belongCity":null,"addrProvince":null,"addrCity":null,"addrDistrict":null,"shopAddr":null,"openTime":null,"closeTime":null,"serviceTel":null,"shopContacts":null,"contactsTel":null,"contactsMail":null,"ifLicence":null,"shopProperty":null,"shopLegal":null,"legalIdc":null,"legalIdp":null,"legalProvince":null,"legalCity":null,"legalDistrict":null,"legalAddress":null,"taxNumber":null,"businessLicence":null,"shopCharge":null,"chargeIdc":null,"chargeIdp":null,"shopLogo":null,"shopPhoto":null,"shopEnvPhoto":null,"joinTime":null,"businessFlag":null,"enableFlag":null,"signFlag":null,"geoX":null,"geoY":null,"updatePgm":null,"belongCityName":null,"apiAnsCustCartList":null,"goodsCounts":0,"approveBy":null,"marketAssistantName":null,"shopChargeTel":null,"shelfcount":0,"mainBusiness":null,"shopCashPhoto":null,"shopDoorPhoto":null,"shopOtherPhoto":null,"approveDate":null,"loginTime":null,"claimTime":null,"orderNumber":null,"goodsNumber":null,"openFee":0,"serviceFee":0,"servicePeriod":null,"signStart":null,"signEnd":null,"signStartDate":null,"signEndDate":null,"ansSnsType":null,"snsId":null,"snsName":null,"serviceAgreement":null,"adAgreement":null,"otherAgreement":null,"unionBeginTime":null,"unionEndTime":null,"queenShopDiscount":null,"avgService":0,"avgEnvironment":0,"comScore":0},"ecGoodsBrowses":{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"goodsId":null,"browseCounts":6,"enableFlag":null},"ansCustCollection":null,"praiseRate":0,"ecPointsRule":null,"goodsTabLabel":null,"goodsCateName":null,"goodsTypeLabel":null,"shopIdName":null,"saleFlagLabel":null,"contentByTitle":null,"goodsAppraiseLabel":null,"newFlagLabel":null,"enableFlag":null,"statusType":null}]
         * colorNo : 000000
         */

        private AnsBannerphotoBean ansBannerphoto;
        private String colorNo;
        private List<BannerListBean> bannerList;
        private List<GoodslistBean> goodslist;

        public AnsBannerphotoBean getAnsBannerphoto() {
            return ansBannerphoto;
        }

        public void setAnsBannerphoto(AnsBannerphotoBean ansBannerphoto) {
            this.ansBannerphoto = ansBannerphoto;
        }

        public String getColorNo() {
            return colorNo;
        }

        public void setColorNo(String colorNo) {
            this.colorNo = colorNo;
        }

        public List<BannerListBean> getBannerList() {
            return bannerList;
        }

        public void setBannerList(List<BannerListBean> bannerList) {
            this.bannerList = bannerList;
        }

        public List<GoodslistBean> getGoodslist() {
            return goodslist;
        }

        public void setGoodslist(List<GoodslistBean> goodslist) {
            this.goodslist = goodslist;
        }

        public static class AnsBannerphotoBean {
            /**
             * id : eaeeae22f23f4575bd782a7ebd013f8a
             * isNewRecord : false
             * remarks : null
             * createDate : null
             * updateDate : null
             * startDate : null
             * endDate : null
             * bannerStyle : 1
             * bannerCategory : 0
             * isPush : 0
             * pushContent : null
             * pageLocation : 4
             * showSort : null
             * bannerName : 拼团规则
             * bannerUrl :
             * bannerLogo : https://nwptest.oss-cn-hangzhou.aliyuncs.com/img/2018-09-12/1536714418625.jpg
             * startTime : 2018-09-01 00:00:00
             * endTime : 2018-09-25 00:00:00
             * bannerDetails : 的
             * enableFlag : 0
             * releaseBy : null
             * releaseDate : 2018-09-07 00:00:00
             * shopIds : null
             * goodsIds : null
             * platformType : 0
             * goodsId :
             * bannerActivityType : mid-autumn-festival
             * type : null
             * activityId : null
             */

            private String id;
            private boolean isNewRecord;
            private Object remarks;
            private Object createDate;
            private Object updateDate;
            private Object startDate;
            private Object endDate;
            private String bannerStyle;
            private String bannerCategory;
            private String isPush;
            private Object pushContent;
            private String pageLocation;
            private Object showSort;
            private String bannerName;
            private String bannerUrl;
            private String bannerLogo;
            private String startTime;
            private String endTime;
            private String bannerDetails;
            private String enableFlag;
            private Object releaseBy;
            private String releaseDate;
            private Object shopIds;
            private Object goodsIds;
            private int platformType;
            private String goodsId;
            private String bannerActivityType;
            private Object type;
            private Object activityId;

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

            public String getBannerStyle() {
                return bannerStyle;
            }

            public void setBannerStyle(String bannerStyle) {
                this.bannerStyle = bannerStyle;
            }

            public String getBannerCategory() {
                return bannerCategory;
            }

            public void setBannerCategory(String bannerCategory) {
                this.bannerCategory = bannerCategory;
            }

            public String getIsPush() {
                return isPush;
            }

            public void setIsPush(String isPush) {
                this.isPush = isPush;
            }

            public Object getPushContent() {
                return pushContent;
            }

            public void setPushContent(Object pushContent) {
                this.pushContent = pushContent;
            }

            public String getPageLocation() {
                return pageLocation;
            }

            public void setPageLocation(String pageLocation) {
                this.pageLocation = pageLocation;
            }

            public Object getShowSort() {
                return showSort;
            }

            public void setShowSort(Object showSort) {
                this.showSort = showSort;
            }

            public String getBannerName() {
                return bannerName;
            }

            public void setBannerName(String bannerName) {
                this.bannerName = bannerName;
            }

            public String getBannerUrl() {
                return bannerUrl;
            }

            public void setBannerUrl(String bannerUrl) {
                this.bannerUrl = bannerUrl;
            }

            public String getBannerLogo() {
                return bannerLogo;
            }

            public void setBannerLogo(String bannerLogo) {
                this.bannerLogo = bannerLogo;
            }

            public String getStartTime() {
                return startTime;
            }

            public void setStartTime(String startTime) {
                this.startTime = startTime;
            }

            public String getEndTime() {
                return endTime;
            }

            public void setEndTime(String endTime) {
                this.endTime = endTime;
            }

            public String getBannerDetails() {
                return bannerDetails;
            }

            public void setBannerDetails(String bannerDetails) {
                this.bannerDetails = bannerDetails;
            }

            public String getEnableFlag() {
                return enableFlag;
            }

            public void setEnableFlag(String enableFlag) {
                this.enableFlag = enableFlag;
            }

            public Object getReleaseBy() {
                return releaseBy;
            }

            public void setReleaseBy(Object releaseBy) {
                this.releaseBy = releaseBy;
            }

            public String getReleaseDate() {
                return releaseDate;
            }

            public void setReleaseDate(String releaseDate) {
                this.releaseDate = releaseDate;
            }

            public Object getShopIds() {
                return shopIds;
            }

            public void setShopIds(Object shopIds) {
                this.shopIds = shopIds;
            }

            public Object getGoodsIds() {
                return goodsIds;
            }

            public void setGoodsIds(Object goodsIds) {
                this.goodsIds = goodsIds;
            }

            public int getPlatformType() {
                return platformType;
            }

            public void setPlatformType(int platformType) {
                this.platformType = platformType;
            }

            public String getGoodsId() {
                return goodsId;
            }

            public void setGoodsId(String goodsId) {
                this.goodsId = goodsId;
            }

            public String getBannerActivityType() {
                return bannerActivityType;
            }

            public void setBannerActivityType(String bannerActivityType) {
                this.bannerActivityType = bannerActivityType;
            }

            public Object getType() {
                return type;
            }

            public void setType(Object type) {
                this.type = type;
            }

            public Object getActivityId() {
                return activityId;
            }

            public void setActivityId(Object activityId) {
                this.activityId = activityId;
            }
        }

        public static class BannerListBean {
            /**
             * id : a1810f52be634012989d9795e80c93a5
             * isNewRecord : false
             * remarks : null
             * createDate : null
             * updateDate : null
             * startDate : null
             * endDate : null
             * bannerStyle : 2
             * bannerCategory : 0
             * isPush : 0
             * pushContent : null
             * pageLocation : 2
             * showSort : 1
             * bannerName : 人气爆款榜1
             * bannerUrl :
             * bannerLogo : https://nwptest.oss-cn-hangzhou.aliyuncs.com/img/2018-09-12/1536714418625.jpg
             * startTime : 2018-09-07 00:00:00
             * endTime : 2018-09-25 00:00:00
             * bannerDetails :
             * enableFlag : 0
             * releaseBy : null
             * releaseDate : 2018-09-12 00:00:00
             * shopIds : null
             * goodsIds : null
             * platformType : 0
             * goodsId : c653894c32564300a9dfabfdab0b71de
             * bannerActivityType : mid-autumn-festival
             * type : null
             * activityId : e3ced9d754b841b189addbf4b37d1f2f
             */

            private String id;
            private boolean isNewRecord;
            private Object remarks;
            private Object createDate;
            private Object updateDate;
            private Object startDate;
            private Object endDate;
            private String bannerStyle;
            private String bannerCategory;
            private String isPush;
            private Object pushContent;
            private String pageLocation;
            private int showSort;
            private String bannerName;
            private String bannerUrl;
            private String bannerLogo;
            private String startTime;
            private String endTime;
            private String bannerDetails;
            private String enableFlag;
            private Object releaseBy;
            private String releaseDate;
            private Object shopIds;
            private Object goodsIds;
            private int platformType;
            private String goodsId;
            private String bannerActivityType;
            private Object type;
            private String activityId;

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

            public String getBannerStyle() {
                return bannerStyle;
            }

            public void setBannerStyle(String bannerStyle) {
                this.bannerStyle = bannerStyle;
            }

            public String getBannerCategory() {
                return bannerCategory;
            }

            public void setBannerCategory(String bannerCategory) {
                this.bannerCategory = bannerCategory;
            }

            public String getIsPush() {
                return isPush;
            }

            public void setIsPush(String isPush) {
                this.isPush = isPush;
            }

            public Object getPushContent() {
                return pushContent;
            }

            public void setPushContent(Object pushContent) {
                this.pushContent = pushContent;
            }

            public String getPageLocation() {
                return pageLocation;
            }

            public void setPageLocation(String pageLocation) {
                this.pageLocation = pageLocation;
            }

            public int getShowSort() {
                return showSort;
            }

            public void setShowSort(int showSort) {
                this.showSort = showSort;
            }

            public String getBannerName() {
                return bannerName;
            }

            public void setBannerName(String bannerName) {
                this.bannerName = bannerName;
            }

            public String getBannerUrl() {
                return bannerUrl;
            }

            public void setBannerUrl(String bannerUrl) {
                this.bannerUrl = bannerUrl;
            }

            public String getBannerLogo() {
                return bannerLogo;
            }

            public void setBannerLogo(String bannerLogo) {
                this.bannerLogo = bannerLogo;
            }

            public String getStartTime() {
                return startTime;
            }

            public void setStartTime(String startTime) {
                this.startTime = startTime;
            }

            public String getEndTime() {
                return endTime;
            }

            public void setEndTime(String endTime) {
                this.endTime = endTime;
            }

            public String getBannerDetails() {
                return bannerDetails;
            }

            public void setBannerDetails(String bannerDetails) {
                this.bannerDetails = bannerDetails;
            }

            public String getEnableFlag() {
                return enableFlag;
            }

            public void setEnableFlag(String enableFlag) {
                this.enableFlag = enableFlag;
            }

            public Object getReleaseBy() {
                return releaseBy;
            }

            public void setReleaseBy(Object releaseBy) {
                this.releaseBy = releaseBy;
            }

            public String getReleaseDate() {
                return releaseDate;
            }

            public void setReleaseDate(String releaseDate) {
                this.releaseDate = releaseDate;
            }

            public Object getShopIds() {
                return shopIds;
            }

            public void setShopIds(Object shopIds) {
                this.shopIds = shopIds;
            }

            public Object getGoodsIds() {
                return goodsIds;
            }

            public void setGoodsIds(Object goodsIds) {
                this.goodsIds = goodsIds;
            }

            public int getPlatformType() {
                return platformType;
            }

            public void setPlatformType(int platformType) {
                this.platformType = platformType;
            }

            public String getGoodsId() {
                return goodsId;
            }

            public void setGoodsId(String goodsId) {
                this.goodsId = goodsId;
            }

            public String getBannerActivityType() {
                return bannerActivityType;
            }

            public void setBannerActivityType(String bannerActivityType) {
                this.bannerActivityType = bannerActivityType;
            }

            public Object getType() {
                return type;
            }

            public void setType(Object type) {
                this.type = type;
            }

            public String getActivityId() {
                return activityId;
            }

            public void setActivityId(String activityId) {
                this.activityId = activityId;
            }
        }

        public static class GoodslistBean {
            /**
             * id : null
             * isNewRecord : true
             * remarks : null
             * createDate : null
             * updateDate : null
             * startDate : null
             * endDate : null
             * ecGoodsBasic : {"id":"a523d56d7187491f92562fe1ec3c03f3","isNewRecord":false,"remarks":null,"createDate":"2018-09-07 10:27:06","updateDate":"2018-09-07 10:28:59","startDate":null,"endDate":null,"goodsCate":"d93edbd7180246aca91c368b1d64b937","goodsType":"2","goodsName":"杭州半永久","goodsNo":"4132a4b62","goodsBrief":"半永久","goodsSort":0,"serviceTime":"30","goodsDetails":null,"goodsThumb":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018090710270015787395.jpg","goodsPic":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018090710270315974172.jpg","goodsShow":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018090710270015787395.jpg","goodsTab":null,"goodsStorage":0,"marketPrice":1,"salesPrice":1,"goodsActivity":null,"goodsBanner":null,"shopId":"a3eccc2f1ef649e09c03f5647241f363","saleFlag":"2","ifPoint":"0","pointRule":null,"approveBy":null,"approveDate":1536287277000,"approveRemarks":"","startTime":null,"endTime":null,"goodsRemarks":null,"updatePgm":"ApiGoodsController","shopName":null,"saleFlagName":null,"goodsTypeName":null,"goodsCateName":null,"ecPointsRule":null,"buyRule":null,"cityCode":null,"groupGoods":null,"activityId":"fc8c7453b9914aecaa1ed6561dba1419","groupPrice":0.1,"groupNumber":2,"queenCard":null,"fromPrice":0,"endPrice":0}
             * ecGoodsSocre : null
             * ansShopBasic : {"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"merchantId":null,"contractConfirm":null,"ifContract":null,"shopName":"品品品●®♡尚","shortName":null,"shopNo":null,"marketAssistant":null,"shopBrief":null,"shopAccounce":null,"ifNew":null,"shopBanner":null,"shopActivity":null,"shopFeature":null,"queenCard":null,"shopTab":null,"shopCate":null,"industryCate":null,"belongCity":null,"addrProvince":null,"addrCity":null,"addrDistrict":null,"shopAddr":null,"openTime":null,"closeTime":null,"serviceTel":null,"shopContacts":null,"contactsTel":null,"contactsMail":null,"ifLicence":null,"shopProperty":null,"shopLegal":null,"legalIdc":null,"legalIdp":null,"legalProvince":null,"legalCity":null,"legalDistrict":null,"legalAddress":null,"taxNumber":null,"businessLicence":null,"shopCharge":null,"chargeIdc":null,"chargeIdp":null,"shopLogo":null,"shopPhoto":null,"shopEnvPhoto":null,"joinTime":null,"businessFlag":null,"enableFlag":null,"signFlag":null,"geoX":null,"geoY":null,"updatePgm":null,"belongCityName":null,"apiAnsCustCartList":null,"goodsCounts":0,"approveBy":null,"marketAssistantName":null,"shopChargeTel":null,"shelfcount":0,"mainBusiness":null,"shopCashPhoto":null,"shopDoorPhoto":null,"shopOtherPhoto":null,"approveDate":null,"loginTime":null,"claimTime":null,"orderNumber":null,"goodsNumber":null,"openFee":0,"serviceFee":0,"servicePeriod":null,"signStart":null,"signEnd":null,"signStartDate":null,"signEndDate":null,"ansSnsType":null,"snsId":null,"snsName":null,"serviceAgreement":null,"adAgreement":null,"otherAgreement":null,"unionBeginTime":null,"unionEndTime":null,"queenShopDiscount":null,"avgService":0,"avgEnvironment":0,"comScore":0}
             * ecGoodsBrowses : {"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"goodsId":null,"browseCounts":6,"enableFlag":null}
             * ansCustCollection : null
             * praiseRate : 0
             * ecPointsRule : null
             * goodsTabLabel : null
             * goodsCateName : null
             * goodsTypeLabel : null
             * shopIdName : null
             * saleFlagLabel : null
             * contentByTitle : null
             * goodsAppraiseLabel : null
             * newFlagLabel : null
             * enableFlag : null
             * statusType : null
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
            private AnsShopBasicBean ansShopBasic;
            private EcGoodsBrowsesBean ecGoodsBrowses;
            private Object ansCustCollection;
            private int praiseRate;
            private Object ecPointsRule;
            private Object goodsTabLabel;
            private Object goodsCateName;
            private Object goodsTypeLabel;
            private Object shopIdName;
            private Object saleFlagLabel;
            private Object contentByTitle;
            private Object goodsAppraiseLabel;
            private Object newFlagLabel;
            private Object enableFlag;
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

            public AnsShopBasicBean getAnsShopBasic() {
                return ansShopBasic;
            }

            public void setAnsShopBasic(AnsShopBasicBean ansShopBasic) {
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

            public int getPraiseRate() {
                return praiseRate;
            }

            public void setPraiseRate(int praiseRate) {
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

            public Object getShopIdName() {
                return shopIdName;
            }

            public void setShopIdName(Object shopIdName) {
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

            public Object getStatusType() {
                return statusType;
            }

            public void setStatusType(Object statusType) {
                this.statusType = statusType;
            }

            public static class EcGoodsBasicBean {
                /**
                 * id : a523d56d7187491f92562fe1ec3c03f3
                 * isNewRecord : false
                 * remarks : null
                 * createDate : 2018-09-07 10:27:06
                 * updateDate : 2018-09-07 10:28:59
                 * startDate : null
                 * endDate : null
                 * goodsCate : d93edbd7180246aca91c368b1d64b937
                 * goodsType : 2
                 * goodsName : 杭州半永久
                 * goodsNo : 4132a4b62
                 * goodsBrief : 半永久
                 * goodsSort : 0
                 * serviceTime : 30
                 * goodsDetails : null
                 * goodsThumb : https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018090710270015787395.jpg
                 * goodsPic : https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018090710270315974172.jpg
                 * goodsShow : https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018090710270015787395.jpg
                 * goodsTab : null
                 * goodsStorage : 0
                 * marketPrice : 1
                 * salesPrice : 1
                 * goodsActivity : null
                 * goodsBanner : null
                 * shopId : a3eccc2f1ef649e09c03f5647241f363
                 * saleFlag : 2
                 * ifPoint : 0
                 * pointRule : null
                 * approveBy : null
                 * approveDate : 1536287277000
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
                 * buyRule : null
                 * cityCode : null
                 * groupGoods : null
                 * activityId : fc8c7453b9914aecaa1ed6561dba1419
                 * groupPrice : 0.1
                 * groupNumber : 2
                 * queenCard : null
                 * fromPrice : 0
                 * endPrice : 0
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
                private String marketPrice;
                private String salesPrice;
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
                private Object buyRule;
                private Object cityCode;
                private Object groupGoods;
                private String activityId;
                private double groupPrice;
                private int groupNumber;
                private Object queenCard;
                private int fromPrice;
                private int endPrice;

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

                public Object getBuyRule() {
                    return buyRule;
                }

                public void setBuyRule(Object buyRule) {
                    this.buyRule = buyRule;
                }

                public Object getCityCode() {
                    return cityCode;
                }

                public void setCityCode(Object cityCode) {
                    this.cityCode = cityCode;
                }

                public Object getGroupGoods() {
                    return groupGoods;
                }

                public void setGroupGoods(Object groupGoods) {
                    this.groupGoods = groupGoods;
                }

                public String getActivityId() {
                    return activityId;
                }

                public void setActivityId(String activityId) {
                    this.activityId = activityId;
                }

                public double getGroupPrice() {
                    return groupPrice;
                }

                public void setGroupPrice(double groupPrice) {
                    this.groupPrice = groupPrice;
                }

                public int getGroupNumber() {
                    return groupNumber;
                }

                public void setGroupNumber(int groupNumber) {
                    this.groupNumber = groupNumber;
                }

                public Object getQueenCard() {
                    return queenCard;
                }

                public void setQueenCard(Object queenCard) {
                    this.queenCard = queenCard;
                }

                public int getFromPrice() {
                    return fromPrice;
                }

                public void setFromPrice(int fromPrice) {
                    this.fromPrice = fromPrice;
                }

                public int getEndPrice() {
                    return endPrice;
                }

                public void setEndPrice(int endPrice) {
                    this.endPrice = endPrice;
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
                 * shopName : 品品品●®♡尚
                 * shortName : null
                 * shopNo : null
                 * marketAssistant : null
                 * shopBrief : null
                 * shopAccounce : null
                 * ifNew : null
                 * shopBanner : null
                 * shopActivity : null
                 * shopFeature : null
                 * queenCard : null
                 * shopTab : null
                 * shopCate : null
                 * industryCate : null
                 * belongCity : null
                 * addrProvince : null
                 * addrCity : null
                 * addrDistrict : null
                 * shopAddr : null
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
                 * geoX : null
                 * geoY : null
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
                 * openFee : 0
                 * serviceFee : 0
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
                 * avgService : 0
                 * avgEnvironment : 0
                 * comScore : 0
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
                private String shopName;
                private Object shortName;
                private Object shopNo;
                private Object marketAssistant;
                private Object shopBrief;
                private Object shopAccounce;
                private Object ifNew;
                private Object shopBanner;
                private Object shopActivity;
                private Object shopFeature;
                private Object queenCard;
                private Object shopTab;
                private Object shopCate;
                private Object industryCate;
                private Object belongCity;
                private Object addrProvince;
                private Object addrCity;
                private Object addrDistrict;
                private Object shopAddr;
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
                private Object geoX;
                private Object geoY;
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
                private int openFee;
                private int serviceFee;
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
                private int avgService;
                private int avgEnvironment;
                private int comScore;

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

                public String getShopName() {
                    return shopName;
                }

                public void setShopName(String shopName) {
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

                public Object getQueenCard() {
                    return queenCard;
                }

                public void setQueenCard(Object queenCard) {
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

                public Object getAddrProvince() {
                    return addrProvince;
                }

                public void setAddrProvince(Object addrProvince) {
                    this.addrProvince = addrProvince;
                }

                public Object getAddrCity() {
                    return addrCity;
                }

                public void setAddrCity(Object addrCity) {
                    this.addrCity = addrCity;
                }

                public Object getAddrDistrict() {
                    return addrDistrict;
                }

                public void setAddrDistrict(Object addrDistrict) {
                    this.addrDistrict = addrDistrict;
                }

                public Object getShopAddr() {
                    return shopAddr;
                }

                public void setShopAddr(Object shopAddr) {
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

                public Object getGeoX() {
                    return geoX;
                }

                public void setGeoX(Object geoX) {
                    this.geoX = geoX;
                }

                public Object getGeoY() {
                    return geoY;
                }

                public void setGeoY(Object geoY) {
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

                public int getOpenFee() {
                    return openFee;
                }

                public void setOpenFee(int openFee) {
                    this.openFee = openFee;
                }

                public int getServiceFee() {
                    return serviceFee;
                }

                public void setServiceFee(int serviceFee) {
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

                public int getAvgService() {
                    return avgService;
                }

                public void setAvgService(int avgService) {
                    this.avgService = avgService;
                }

                public int getAvgEnvironment() {
                    return avgEnvironment;
                }

                public void setAvgEnvironment(int avgEnvironment) {
                    this.avgEnvironment = avgEnvironment;
                }

                public int getComScore() {
                    return comScore;
                }

                public void setComScore(int comScore) {
                    this.comScore = comScore;
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
                 * browseCounts : 6
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
