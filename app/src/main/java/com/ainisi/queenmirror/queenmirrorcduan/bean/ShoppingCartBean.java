package com.ainisi.queenmirror.queenmirrorcduan.bean;

import java.io.Serializable;
import java.util.List;

public class ShoppingCartBean implements Serializable{


    /**
     * success : true
     * errorCode : 0
     * msg : 获取数据成功
     * body : {"shopList":[{"id":"a4f40e0fbb8240b681b3164166d8d04b","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"merchantId":null,"contractConfirm":null,"ifContract":null,"shopName":"poe的小店","shortName":null,"shopNo":null,"marketAssistant":null,"shopBrief":null,"shopAccounce":null,"ifNew":null,"shopBanner":null,"shopActivity":null,"shopFeature":null,"queenCard":"1","shopTab":null,"shopCate":null,"industryCate":null,"belongCity":null,"addrProvince":null,"addrCity":null,"addrDistrict":null,"shopAddr":null,"openTime":null,"closeTime":null,"serviceTel":null,"shopContacts":null,"contactsTel":null,"contactsMail":null,"ifLicence":null,"shopProperty":null,"shopLegal":null,"legalIdc":null,"legalIdp":null,"legalProvince":null,"legalCity":null,"legalDistrict":null,"legalAddress":null,"taxNumber":null,"businessLicence":null,"shopCharge":null,"chargeIdc":null,"chargeIdp":null,"shopLogo":null,"shopPhoto":null,"shopEnvPhoto":null,"joinTime":null,"businessFlag":null,"enableFlag":null,"signFlag":null,"geoX":null,"geoY":null,"updatePgm":null,"belongCityName":null,"apiAnsCustCartList":[{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"ansCustCart":{"id":"49adece6ed38443bb1eda5e006e0ecb7","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"custId":"8aafefe862ae0bdc0162ae68207d0786","goodId":"3130570eea75479282f479ea40127776","unitPrice":5,"purchaseNumber":1,"cartTime":"2018-08-15 16:33:31"},"ecGoodsBasic":{"id":"3130570eea75479282f479ea40127776","isNewRecord":false,"remarks":null,"createDate":"2018-07-27 11:19:25","updateDate":"2018-08-10 10:47:36","startDate":null,"endDate":null,"goodsCate":"d93edbd7180246aca91c368b1d64b937","goodsType":"2","goodsName":"半永久纹身","goodsNo":"cc929ad9c1","goodsBrief":"","goodsSort":0,"serviceTime":"20","goodsDetails":null,"goodsThumb":"https://prodr.oss-cn-hangzhou.aliyuncs.com/2018072711183599493508.jpg","goodsPic":"https://prodr.oss-cn-hangzhou.aliyuncs.com/2018072711190076230325.jpg,https://prodr.oss-cn-hangzhou.aliyuncs.com/2018072711190076430355.jpg,https://prodr.oss-cn-hangzhou.aliyuncs.com/2018072711190076625284.jpg,","goodsShow":"https://prodr.oss-cn-hangzhou.aliyuncs.com/2018072711183599493508.jpg,","goodsTab":null,"goodsStorage":0,"marketPrice":20,"salesPrice":5,"goodsActivity":null,"goodsBanner":null,"shopId":"a4f40e0fbb8240b681b3164166d8d04b","saleFlag":"2","ifPoint":"0","pointRule":null,"approveBy":null,"approveDate":1532668210000,"approveRemarks":null,"startTime":null,"endTime":null,"goodsRemarks":null,"updatePgm":"ApiGoodsController","shopName":null,"saleFlagName":null,"goodsTypeName":null,"goodsCateName":null,"ecPointsRule":null,"buyRule":null,"cityCode":null,"groupGoods":null,"activityId":null,"groupPrice":0},"ansShopBasic":null},{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"ansCustCart":{"id":"bf42446056044bd6afb258f56c89203c","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"custId":"8aafefe862ae0bdc0162ae68207d0786","goodId":"aba8d419964e44f4ac3e9a6b80250256","unitPrice":30,"purchaseNumber":2,"cartTime":"2018-08-15 15:54:31"},"ecGoodsBasic":{"id":"aba8d419964e44f4ac3e9a6b80250256","isNewRecord":false,"remarks":null,"createDate":"2018-07-07 16:42:30","updateDate":"2018-07-27 13:18:34","startDate":null,"endDate":null,"goodsCate":"27a7d133a8f94cb9b9bce03365cf6a48","goodsType":"1","goodsName":"1号商品商品名称1号商品商品名称1号商品商品名称1号商品商品名称","goodsNo":"3f3f1745fe","goodsBrief":"你不经常减肥胶囊说你呢潮男潮女你猜男女内参积极参加玩VB化粪池v吧","goodsSort":0,"serviceTime":"50","goodsDetails":null,"goodsThumb":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018070704420281460805.jpg","goodsPic":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018070704422822554277.jpg,https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018070704422822723127.jpg,https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018070704422822850214.jpg,","goodsShow":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018070704420281460805.jpg,https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018070704420281623832.jpg,","goodsTab":null,"goodsStorage":0,"marketPrice":100.99,"salesPrice":30,"goodsActivity":"","goodsBanner":null,"shopId":"a4f40e0fbb8240b681b3164166d8d04b","saleFlag":"2","ifPoint":"1","pointRule":"20.0","approveBy":"1","approveDate":1532668740000,"approveRemarks":null,"startTime":null,"endTime":null,"goodsRemarks":null,"updatePgm":"ApiGoodsController","shopName":null,"saleFlagName":null,"goodsTypeName":null,"goodsCateName":null,"ecPointsRule":null,"buyRule":null,"cityCode":null,"groupGoods":null,"activityId":null,"groupPrice":0},"ansShopBasic":null}],"goodsCounts":0,"approveBy":null,"marketAssistantName":null,"shopChargeTel":null,"shelfcount":0,"mainBusiness":null,"shopCashPhoto":null,"shopDoorPhoto":null,"shopOtherPhoto":null,"approveDate":null,"loginTime":null,"claimTime":null,"openFee":0,"serviceFee":0,"servicePeriod":null,"signStart":null,"signEnd":null,"signStartDate":null,"signEndDate":null,"ansSnsType":null,"snsId":null,"snsName":null,"serviceAgreement":null,"adAgreement":null,"otherAgreement":null,"unionBeginTime":null,"unionEndTime":null,"queenShopDiscount":"9","avgService":0,"avgEnvironment":0,"comScore":0},{"id":"e7f39cc573f140579818cd322ee2a9f0","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"merchantId":null,"contractConfirm":null,"ifContract":null,"shopName":"赵丽颖万能店铺","shortName":null,"shopNo":null,"marketAssistant":null,"shopBrief":null,"shopAccounce":null,"ifNew":null,"shopBanner":null,"shopActivity":null,"shopFeature":null,"queenCard":"0","shopTab":null,"shopCate":null,"industryCate":null,"belongCity":null,"addrProvince":null,"addrCity":null,"addrDistrict":null,"shopAddr":null,"openTime":null,"closeTime":null,"serviceTel":null,"shopContacts":null,"contactsTel":null,"contactsMail":null,"ifLicence":null,"shopProperty":null,"shopLegal":null,"legalIdc":null,"legalIdp":null,"legalProvince":null,"legalCity":null,"legalDistrict":null,"legalAddress":null,"taxNumber":null,"businessLicence":null,"shopCharge":null,"chargeIdc":null,"chargeIdp":null,"shopLogo":null,"shopPhoto":null,"shopEnvPhoto":null,"joinTime":null,"businessFlag":null,"enableFlag":null,"signFlag":null,"geoX":null,"geoY":null,"updatePgm":null,"belongCityName":null,"apiAnsCustCartList":[{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"ansCustCart":{"id":"51895769667249cc9b221634c645a844","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"custId":"8aafefe862ae0bdc0162ae68207d0786","goodId":"662bd49a1e1c4d5a93483946d32c9014","unitPrice":15,"purchaseNumber":1,"cartTime":"2018-08-13 15:09:55"},"ecGoodsBasic":{"id":"662bd49a1e1c4d5a93483946d32c9014","isNewRecord":false,"remarks":null,"createDate":"2018-07-13 14:41:25","updateDate":"2018-07-13 14:41:30","startDate":null,"endDate":null,"goodsCate":"575a4f781e48405f860f0dc7a7be4b79","goodsType":"2","goodsName":"红茶玛奇朵","goodsNo":"84333f2df","goodsBrief":"这世间唯有美食不可辜负","goodsSort":0,"serviceTime":"30","goodsDetails":null,"goodsThumb":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/201807130241247033553.jpg","goodsPic":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018071302412470347.jpg","goodsShow":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/201807130241247033553.jpg","goodsTab":"","goodsStorage":0,"marketPrice":15,"salesPrice":15,"goodsActivity":null,"goodsBanner":null,"shopId":"e7f39cc573f140579818cd322ee2a9f0","saleFlag":"2","ifPoint":"1","pointRule":"200.0","approveBy":"1c0207c92716488ea5b8b9bb8abba163","approveDate":1531473492000,"approveRemarks":null,"startTime":null,"endTime":null,"goodsRemarks":null,"updatePgm":"ApiGoodsController","shopName":null,"saleFlagName":null,"goodsTypeName":null,"goodsCateName":null,"ecPointsRule":null,"buyRule":null,"cityCode":null,"groupGoods":null,"activityId":null,"groupPrice":0},"ansShopBasic":null}],"goodsCounts":0,"approveBy":null,"marketAssistantName":null,"shopChargeTel":null,"shelfcount":0,"mainBusiness":null,"shopCashPhoto":null,"shopDoorPhoto":null,"shopOtherPhoto":null,"approveDate":null,"loginTime":null,"claimTime":null,"openFee":0,"serviceFee":0,"servicePeriod":null,"signStart":null,"signEnd":null,"signStartDate":null,"signEndDate":null,"ansSnsType":null,"snsId":null,"snsName":null,"serviceAgreement":null,"adAgreement":null,"otherAgreement":null,"unionBeginTime":null,"unionEndTime":null,"queenShopDiscount":null,"avgService":0,"avgEnvironment":0,"comScore":0}]}
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
        private List<ShopListBean> shopList;

        public List<ShopListBean> getShopList() {
            return shopList;
        }

        public void setShopList(List<ShopListBean> shopList) {
            this.shopList = shopList;
        }

        public static class ShopListBean implements Serializable{
            /**
             * id : a4f40e0fbb8240b681b3164166d8d04b
             * isNewRecord : false
             * remarks : null
             * createDate : null
             * updateDate : null
             * startDate : null
             * endDate : null
             * merchantId : null
             * contractConfirm : null
             * ifContract : null
             * shopName : poe的小店
             * shortName : null
             * shopNo : null
             * marketAssistant : null
             * shopBrief : null
             * shopAccounce : null
             * ifNew : null
             * shopBanner : null
             * shopActivity : null
             * shopFeature : null
             * queenCard : 1
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
             * apiAnsCustCartList : [{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"ansCustCart":{"id":"49adece6ed38443bb1eda5e006e0ecb7","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"custId":"8aafefe862ae0bdc0162ae68207d0786","goodId":"3130570eea75479282f479ea40127776","unitPrice":5,"purchaseNumber":1,"cartTime":"2018-08-15 16:33:31"},"ecGoodsBasic":{"id":"3130570eea75479282f479ea40127776","isNewRecord":false,"remarks":null,"createDate":"2018-07-27 11:19:25","updateDate":"2018-08-10 10:47:36","startDate":null,"endDate":null,"goodsCate":"d93edbd7180246aca91c368b1d64b937","goodsType":"2","goodsName":"半永久纹身","goodsNo":"cc929ad9c1","goodsBrief":"","goodsSort":0,"serviceTime":"20","goodsDetails":null,"goodsThumb":"https://prodr.oss-cn-hangzhou.aliyuncs.com/2018072711183599493508.jpg","goodsPic":"https://prodr.oss-cn-hangzhou.aliyuncs.com/2018072711190076230325.jpg,https://prodr.oss-cn-hangzhou.aliyuncs.com/2018072711190076430355.jpg,https://prodr.oss-cn-hangzhou.aliyuncs.com/2018072711190076625284.jpg,","goodsShow":"https://prodr.oss-cn-hangzhou.aliyuncs.com/2018072711183599493508.jpg,","goodsTab":null,"goodsStorage":0,"marketPrice":20,"salesPrice":5,"goodsActivity":null,"goodsBanner":null,"shopId":"a4f40e0fbb8240b681b3164166d8d04b","saleFlag":"2","ifPoint":"0","pointRule":null,"approveBy":null,"approveDate":1532668210000,"approveRemarks":null,"startTime":null,"endTime":null,"goodsRemarks":null,"updatePgm":"ApiGoodsController","shopName":null,"saleFlagName":null,"goodsTypeName":null,"goodsCateName":null,"ecPointsRule":null,"buyRule":null,"cityCode":null,"groupGoods":null,"activityId":null,"groupPrice":0},"ansShopBasic":null},{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"ansCustCart":{"id":"bf42446056044bd6afb258f56c89203c","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"custId":"8aafefe862ae0bdc0162ae68207d0786","goodId":"aba8d419964e44f4ac3e9a6b80250256","unitPrice":30,"purchaseNumber":2,"cartTime":"2018-08-15 15:54:31"},"ecGoodsBasic":{"id":"aba8d419964e44f4ac3e9a6b80250256","isNewRecord":false,"remarks":null,"createDate":"2018-07-07 16:42:30","updateDate":"2018-07-27 13:18:34","startDate":null,"endDate":null,"goodsCate":"27a7d133a8f94cb9b9bce03365cf6a48","goodsType":"1","goodsName":"1号商品商品名称1号商品商品名称1号商品商品名称1号商品商品名称","goodsNo":"3f3f1745fe","goodsBrief":"你不经常减肥胶囊说你呢潮男潮女你猜男女内参积极参加玩VB化粪池v吧","goodsSort":0,"serviceTime":"50","goodsDetails":null,"goodsThumb":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018070704420281460805.jpg","goodsPic":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018070704422822554277.jpg,https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018070704422822723127.jpg,https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018070704422822850214.jpg,","goodsShow":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018070704420281460805.jpg,https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018070704420281623832.jpg,","goodsTab":null,"goodsStorage":0,"marketPrice":100.99,"salesPrice":30,"goodsActivity":"","goodsBanner":null,"shopId":"a4f40e0fbb8240b681b3164166d8d04b","saleFlag":"2","ifPoint":"1","pointRule":"20.0","approveBy":"1","approveDate":1532668740000,"approveRemarks":null,"startTime":null,"endTime":null,"goodsRemarks":null,"updatePgm":"ApiGoodsController","shopName":null,"saleFlagName":null,"goodsTypeName":null,"goodsCateName":null,"ecPointsRule":null,"buyRule":null,"cityCode":null,"groupGoods":null,"activityId":null,"groupPrice":0},"ansShopBasic":null}]
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
             * queenShopDiscount : 9
             * avgService : 0
             * avgEnvironment : 0
             * comScore : 0
             */

            private String id;
            private boolean isNewRecord;
            private String remarks;
            private String createDate;
            private String updateDate;
            private String startDate;
            private String endDate;
            private String merchantId;
            private String contractConfirm;
            private String ifContract;
            private String shopName;
            private String shortName;
            private String shopNo;
            private String marketAssistant;
            private String shopBrief;
            private String shopAccounce;
            private String ifNew;
            private String shopBanner;
            private String shopActivity;
            private String shopFeature;
            private String queenCard;
            private String shopTab;
            private String shopCate;
            private String industryCate;
            private String belongCity;
            private String addrProvince;
            private String addrCity;
            private String addrDistrict;
            private String shopAddr;
            private String openTime;
            private String closeTime;
            private String serviceTel;
            private String shopContacts;
            private String contactsTel;
            private String contactsMail;
            private String ifLicence;
            private String shopProperty;
            private String shopLegal;
            private String legalIdc;
            private String legalIdp;
            private String legalProvince;
            private String legalCity;
            private String legalDistrict;
            private String legalAddress;
            private String taxNumber;
            private String businessLicence;
            private String shopCharge;
            private String chargeIdc;
            private String chargeIdp;
            private String shopLogo;
            private String shopPhoto;
            private String shopEnvPhoto;
            private String joinTime;
            private String businessFlag;
            private String enableFlag;
            private String signFlag;
            private String geoX;
            private String geoY;
            private String updatePgm;
            private String belongCityName;
            private String goodsCounts;
            private String approveBy;
            private String marketAssistantName;
            private String shopChargeTel;
            private String shelfcount;
            private String mainBusiness;
            private String shopCashPhoto;
            private String shopDoorPhoto;
            private String shopOtherPhoto;
            private String approveDate;
            private String loginTime;
            private String claimTime;
            private String openFee;
            private String serviceFee;
            private String servicePeriod;
            private String signStart;
            private String signEnd;
            private String signStartDate;
            private String signEndDate;
            private String ansSnsType;
            private String snsId;
            private String snsName;
            private String serviceAgreement;
            private String adAgreement;
            private String otherAgreement;
            private String unionBeginTime;
            private String unionEndTime;
            private String queenShopDiscount;
            private String avgService;
            private String avgEnvironment;
            private String comScore;
            private List<ApiAnsCustCartListBean> apiAnsCustCartList;

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

            public String getMerchantId() {
                return merchantId;
            }

            public void setMerchantId(String merchantId) {
                this.merchantId = merchantId;
            }

            public String getContractConfirm() {
                return contractConfirm;
            }

            public void setContractConfirm(String contractConfirm) {
                this.contractConfirm = contractConfirm;
            }

            public String getIfContract() {
                return ifContract;
            }

            public void setIfContract(String ifContract) {
                this.ifContract = ifContract;
            }

            public String getShopName() {
                return shopName;
            }

            public void setShopName(String shopName) {
                this.shopName = shopName;
            }

            public String getShortName() {
                return shortName;
            }

            public void setShortName(String shortName) {
                this.shortName = shortName;
            }

            public String getShopNo() {
                return shopNo;
            }

            public void setShopNo(String shopNo) {
                this.shopNo = shopNo;
            }

            public String getMarketAssistant() {
                return marketAssistant;
            }

            public void setMarketAssistant(String marketAssistant) {
                this.marketAssistant = marketAssistant;
            }

            public String getShopBrief() {
                return shopBrief;
            }

            public void setShopBrief(String shopBrief) {
                this.shopBrief = shopBrief;
            }

            public String getShopAccounce() {
                return shopAccounce;
            }

            public void setShopAccounce(String shopAccounce) {
                this.shopAccounce = shopAccounce;
            }

            public String getIfNew() {
                return ifNew;
            }

            public void setIfNew(String ifNew) {
                this.ifNew = ifNew;
            }

            public String getShopBanner() {
                return shopBanner;
            }

            public void setShopBanner(String shopBanner) {
                this.shopBanner = shopBanner;
            }

            public String getShopActivity() {
                return shopActivity;
            }

            public void setShopActivity(String shopActivity) {
                this.shopActivity = shopActivity;
            }

            public String getShopFeature() {
                return shopFeature;
            }

            public void setShopFeature(String shopFeature) {
                this.shopFeature = shopFeature;
            }

            public String getQueenCard() {
                return queenCard;
            }

            public void setQueenCard(String queenCard) {
                this.queenCard = queenCard;
            }

            public String getShopTab() {
                return shopTab;
            }

            public void setShopTab(String shopTab) {
                this.shopTab = shopTab;
            }

            public String getShopCate() {
                return shopCate;
            }

            public void setShopCate(String shopCate) {
                this.shopCate = shopCate;
            }

            public String getIndustryCate() {
                return industryCate;
            }

            public void setIndustryCate(String industryCate) {
                this.industryCate = industryCate;
            }

            public String getBelongCity() {
                return belongCity;
            }

            public void setBelongCity(String belongCity) {
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

            public String getOpenTime() {
                return openTime;
            }

            public void setOpenTime(String openTime) {
                this.openTime = openTime;
            }

            public String getCloseTime() {
                return closeTime;
            }

            public void setCloseTime(String closeTime) {
                this.closeTime = closeTime;
            }

            public String getServiceTel() {
                return serviceTel;
            }

            public void setServiceTel(String serviceTel) {
                this.serviceTel = serviceTel;
            }

            public String getShopContacts() {
                return shopContacts;
            }

            public void setShopContacts(String shopContacts) {
                this.shopContacts = shopContacts;
            }

            public String getContactsTel() {
                return contactsTel;
            }

            public void setContactsTel(String contactsTel) {
                this.contactsTel = contactsTel;
            }

            public String getContactsMail() {
                return contactsMail;
            }

            public void setContactsMail(String contactsMail) {
                this.contactsMail = contactsMail;
            }

            public String getIfLicence() {
                return ifLicence;
            }

            public void setIfLicence(String ifLicence) {
                this.ifLicence = ifLicence;
            }

            public String getShopProperty() {
                return shopProperty;
            }

            public void setShopProperty(String shopProperty) {
                this.shopProperty = shopProperty;
            }

            public String getShopLegal() {
                return shopLegal;
            }

            public void setShopLegal(String shopLegal) {
                this.shopLegal = shopLegal;
            }

            public String getLegalIdc() {
                return legalIdc;
            }

            public void setLegalIdc(String legalIdc) {
                this.legalIdc = legalIdc;
            }

            public String getLegalIdp() {
                return legalIdp;
            }

            public void setLegalIdp(String legalIdp) {
                this.legalIdp = legalIdp;
            }

            public String getLegalProvince() {
                return legalProvince;
            }

            public void setLegalProvince(String legalProvince) {
                this.legalProvince = legalProvince;
            }

            public String getLegalCity() {
                return legalCity;
            }

            public void setLegalCity(String legalCity) {
                this.legalCity = legalCity;
            }

            public String getLegalDistrict() {
                return legalDistrict;
            }

            public void setLegalDistrict(String legalDistrict) {
                this.legalDistrict = legalDistrict;
            }

            public String getLegalAddress() {
                return legalAddress;
            }

            public void setLegalAddress(String legalAddress) {
                this.legalAddress = legalAddress;
            }

            public String getTaxNumber() {
                return taxNumber;
            }

            public void setTaxNumber(String taxNumber) {
                this.taxNumber = taxNumber;
            }

            public String getBusinessLicence() {
                return businessLicence;
            }

            public void setBusinessLicence(String businessLicence) {
                this.businessLicence = businessLicence;
            }

            public String getShopCharge() {
                return shopCharge;
            }

            public void setShopCharge(String shopCharge) {
                this.shopCharge = shopCharge;
            }

            public String getChargeIdc() {
                return chargeIdc;
            }

            public void setChargeIdc(String chargeIdc) {
                this.chargeIdc = chargeIdc;
            }

            public String getChargeIdp() {
                return chargeIdp;
            }

            public void setChargeIdp(String chargeIdp) {
                this.chargeIdp = chargeIdp;
            }

            public String getShopLogo() {
                return shopLogo;
            }

            public void setShopLogo(String shopLogo) {
                this.shopLogo = shopLogo;
            }

            public String getShopPhoto() {
                return shopPhoto;
            }

            public void setShopPhoto(String shopPhoto) {
                this.shopPhoto = shopPhoto;
            }

            public String getShopEnvPhoto() {
                return shopEnvPhoto;
            }

            public void setShopEnvPhoto(String shopEnvPhoto) {
                this.shopEnvPhoto = shopEnvPhoto;
            }

            public String getJoinTime() {
                return joinTime;
            }

            public void setJoinTime(String joinTime) {
                this.joinTime = joinTime;
            }

            public String getBusinessFlag() {
                return businessFlag;
            }

            public void setBusinessFlag(String businessFlag) {
                this.businessFlag = businessFlag;
            }

            public String getEnableFlag() {
                return enableFlag;
            }

            public void setEnableFlag(String enableFlag) {
                this.enableFlag = enableFlag;
            }

            public String getSignFlag() {
                return signFlag;
            }

            public void setSignFlag(String signFlag) {
                this.signFlag = signFlag;
            }

            public String getGeoX() {
                return geoX;
            }

            public void setGeoX(String geoX) {
                this.geoX = geoX;
            }

            public String getGeoY() {
                return geoY;
            }

            public void setGeoY(String geoY) {
                this.geoY = geoY;
            }

            public String getUpdatePgm() {
                return updatePgm;
            }

            public void setUpdatePgm(String updatePgm) {
                this.updatePgm = updatePgm;
            }

            public String getBelongCityName() {
                return belongCityName;
            }

            public void setBelongCityName(String belongCityName) {
                this.belongCityName = belongCityName;
            }

            public String getGoodsCounts() {
                return goodsCounts;
            }

            public void setGoodsCounts(String goodsCounts) {
                this.goodsCounts = goodsCounts;
            }

            public String getApproveBy() {
                return approveBy;
            }

            public void setApproveBy(String approveBy) {
                this.approveBy = approveBy;
            }

            public String getMarketAssistantName() {
                return marketAssistantName;
            }

            public void setMarketAssistantName(String marketAssistantName) {
                this.marketAssistantName = marketAssistantName;
            }

            public String getShopChargeTel() {
                return shopChargeTel;
            }

            public void setShopChargeTel(String shopChargeTel) {
                this.shopChargeTel = shopChargeTel;
            }

            public String getShelfcount() {
                return shelfcount;
            }

            public void setShelfcount(String shelfcount) {
                this.shelfcount = shelfcount;
            }

            public String getMainBusiness() {
                return mainBusiness;
            }

            public void setMainBusiness(String mainBusiness) {
                this.mainBusiness = mainBusiness;
            }

            public String getShopCashPhoto() {
                return shopCashPhoto;
            }

            public void setShopCashPhoto(String shopCashPhoto) {
                this.shopCashPhoto = shopCashPhoto;
            }

            public String getShopDoorPhoto() {
                return shopDoorPhoto;
            }

            public void setShopDoorPhoto(String shopDoorPhoto) {
                this.shopDoorPhoto = shopDoorPhoto;
            }

            public String getShopOtherPhoto() {
                return shopOtherPhoto;
            }

            public void setShopOtherPhoto(String shopOtherPhoto) {
                this.shopOtherPhoto = shopOtherPhoto;
            }

            public String getApproveDate() {
                return approveDate;
            }

            public void setApproveDate(String approveDate) {
                this.approveDate = approveDate;
            }

            public String getLoginTime() {
                return loginTime;
            }

            public void setLoginTime(String loginTime) {
                this.loginTime = loginTime;
            }

            public String getClaimTime() {
                return claimTime;
            }

            public void setClaimTime(String claimTime) {
                this.claimTime = claimTime;
            }

            public String getOpenFee() {
                return openFee;
            }

            public void setOpenFee(String openFee) {
                this.openFee = openFee;
            }

            public String getServiceFee() {
                return serviceFee;
            }

            public void setServiceFee(String serviceFee) {
                this.serviceFee = serviceFee;
            }

            public String getServicePeriod() {
                return servicePeriod;
            }

            public void setServicePeriod(String servicePeriod) {
                this.servicePeriod = servicePeriod;
            }

            public String getSignStart() {
                return signStart;
            }

            public void setSignStart(String signStart) {
                this.signStart = signStart;
            }

            public String getSignEnd() {
                return signEnd;
            }

            public void setSignEnd(String signEnd) {
                this.signEnd = signEnd;
            }

            public String getSignStartDate() {
                return signStartDate;
            }

            public void setSignStartDate(String signStartDate) {
                this.signStartDate = signStartDate;
            }

            public String getSignEndDate() {
                return signEndDate;
            }

            public void setSignEndDate(String signEndDate) {
                this.signEndDate = signEndDate;
            }

            public String getAnsSnsType() {
                return ansSnsType;
            }

            public void setAnsSnsType(String ansSnsType) {
                this.ansSnsType = ansSnsType;
            }

            public String getSnsId() {
                return snsId;
            }

            public void setSnsId(String snsId) {
                this.snsId = snsId;
            }

            public String getSnsName() {
                return snsName;
            }

            public void setSnsName(String snsName) {
                this.snsName = snsName;
            }

            public String getServiceAgreement() {
                return serviceAgreement;
            }

            public void setServiceAgreement(String serviceAgreement) {
                this.serviceAgreement = serviceAgreement;
            }

            public String getAdAgreement() {
                return adAgreement;
            }

            public void setAdAgreement(String adAgreement) {
                this.adAgreement = adAgreement;
            }

            public String getOtherAgreement() {
                return otherAgreement;
            }

            public void setOtherAgreement(String otherAgreement) {
                this.otherAgreement = otherAgreement;
            }

            public String getUnionBeginTime() {
                return unionBeginTime;
            }

            public void setUnionBeginTime(String unionBeginTime) {
                this.unionBeginTime = unionBeginTime;
            }

            public String getUnionEndTime() {
                return unionEndTime;
            }

            public void setUnionEndTime(String unionEndTime) {
                this.unionEndTime = unionEndTime;
            }

            public String getQueenShopDiscount() {
                return queenShopDiscount;
            }

            public void setQueenShopDiscount(String queenShopDiscount) {
                this.queenShopDiscount = queenShopDiscount;
            }

            public String getAvgService() {
                return avgService;
            }

            public void setAvgService(String avgService) {
                this.avgService = avgService;
            }

            public String getAvgEnvironment() {
                return avgEnvironment;
            }

            public void setAvgEnvironment(String avgEnvironment) {
                this.avgEnvironment = avgEnvironment;
            }

            public String getComScore() {
                return comScore;
            }

            public void setComScore(String comScore) {
                this.comScore = comScore;
            }

            public List<ApiAnsCustCartListBean> getApiAnsCustCartList() {
                return apiAnsCustCartList;
            }

            public void setApiAnsCustCartList(List<ApiAnsCustCartListBean> apiAnsCustCartList) {
                this.apiAnsCustCartList = apiAnsCustCartList;
            }

            public static class ApiAnsCustCartListBean implements Serializable{
                /**
                 * id : null
                 * isNewRecord : true
                 * remarks : null
                 * createDate : null
                 * updateDate : null
                 * startDate : null
                 * endDate : null
                 * ansCustCart : {"id":"49adece6ed38443bb1eda5e006e0ecb7","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"custId":"8aafefe862ae0bdc0162ae68207d0786","goodId":"3130570eea75479282f479ea40127776","unitPrice":5,"purchaseNumber":1,"cartTime":"2018-08-15 16:33:31"}
                 * ecGoodsBasic : {"id":"3130570eea75479282f479ea40127776","isNewRecord":false,"remarks":null,"createDate":"2018-07-27 11:19:25","updateDate":"2018-08-10 10:47:36","startDate":null,"endDate":null,"goodsCate":"d93edbd7180246aca91c368b1d64b937","goodsType":"2","goodsName":"半永久纹身","goodsNo":"cc929ad9c1","goodsBrief":"","goodsSort":0,"serviceTime":"20","goodsDetails":null,"goodsThumb":"https://prodr.oss-cn-hangzhou.aliyuncs.com/2018072711183599493508.jpg","goodsPic":"https://prodr.oss-cn-hangzhou.aliyuncs.com/2018072711190076230325.jpg,https://prodr.oss-cn-hangzhou.aliyuncs.com/2018072711190076430355.jpg,https://prodr.oss-cn-hangzhou.aliyuncs.com/2018072711190076625284.jpg,","goodsShow":"https://prodr.oss-cn-hangzhou.aliyuncs.com/2018072711183599493508.jpg,","goodsTab":null,"goodsStorage":0,"marketPrice":20,"salesPrice":5,"goodsActivity":null,"goodsBanner":null,"shopId":"a4f40e0fbb8240b681b3164166d8d04b","saleFlag":"2","ifPoint":"0","pointRule":null,"approveBy":null,"approveDate":1532668210000,"approveRemarks":null,"startTime":null,"endTime":null,"goodsRemarks":null,"updatePgm":"ApiGoodsController","shopName":null,"saleFlagName":null,"goodsTypeName":null,"goodsCateName":null,"ecPointsRule":null,"buyRule":null,"cityCode":null,"groupGoods":null,"activityId":null,"groupPrice":0}
                 * ansShopBasic : null
                 */

                private Object id;
                private boolean isNewRecord;
                private Object remarks;
                private Object createDate;
                private Object updateDate;
                private Object startDate;
                private Object endDate;
                private AnsCustCartBean ansCustCart;
                private EcGoodsBasicBean ecGoodsBasic;
                private Object ansShopBasic;

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

                public AnsCustCartBean getAnsCustCart() {
                    return ansCustCart;
                }

                public void setAnsCustCart(AnsCustCartBean ansCustCart) {
                    this.ansCustCart = ansCustCart;
                }

                public EcGoodsBasicBean getEcGoodsBasic() {
                    return ecGoodsBasic;
                }

                public void setEcGoodsBasic(EcGoodsBasicBean ecGoodsBasic) {
                    this.ecGoodsBasic = ecGoodsBasic;
                }

                public Object getAnsShopBasic() {
                    return ansShopBasic;
                }

                public void setAnsShopBasic(Object ansShopBasic) {
                    this.ansShopBasic = ansShopBasic;
                }

                public static class AnsCustCartBean implements Serializable{
                    /**
                     * id : 49adece6ed38443bb1eda5e006e0ecb7
                     * isNewRecord : false
                     * remarks : null
                     * createDate : null
                     * updateDate : null
                     * startDate : null
                     * endDate : null
                     * custId : 8aafefe862ae0bdc0162ae68207d0786
                     * goodId : 3130570eea75479282f479ea40127776
                     * unitPrice : 5
                     * purchaseNumber : 1
                     * cartTime : 2018-08-15 16:33:31
                     */

                    private String id;
                    private boolean isNewRecord;
                    private Object remarks;
                    private Object createDate;
                    private Object updateDate;
                    private Object startDate;
                    private Object endDate;
                    private String custId;
                    private String goodId;
                    private String unitPrice;
                    private String purchaseNumber;
                    private String cartTime;

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

                    public String getGoodId() {
                        return goodId;
                    }

                    public void setGoodId(String goodId) {
                        this.goodId = goodId;
                    }

                    public boolean isNewRecord() {
                        return isNewRecord;
                    }

                    public void setNewRecord(boolean newRecord) {
                        isNewRecord = newRecord;
                    }

                    public String getUnitPrice() {
                        return unitPrice;
                    }

                    public void setUnitPrice(String unitPrice) {
                        this.unitPrice = unitPrice;
                    }

                    public String getPurchaseNumber() {
                        return purchaseNumber;
                    }

                    public void setPurchaseNumber(String purchaseNumber) {
                        this.purchaseNumber = purchaseNumber;
                    }

                    public String getCartTime() {
                        return cartTime;
                    }

                    public void setCartTime(String cartTime) {
                        this.cartTime = cartTime;
                    }
                }

                public static class EcGoodsBasicBean implements Serializable{
                    /**
                     * id : 3130570eea75479282f479ea40127776
                     * isNewRecord : false
                     * remarks : null
                     * createDate : 2018-07-27 11:19:25
                     * updateDate : 2018-08-10 10:47:36
                     * startDate : null
                     * endDate : null
                     * goodsCate : d93edbd7180246aca91c368b1d64b937
                     * goodsType : 2
                     * goodsName : 半永久纹身
                     * goodsNo : cc929ad9c1
                     * goodsBrief :
                     * goodsSort : 0
                     * serviceTime : 20
                     * goodsDetails : null
                     * goodsThumb : https://prodr.oss-cn-hangzhou.aliyuncs.com/2018072711183599493508.jpg
                     * goodsPic : https://prodr.oss-cn-hangzhou.aliyuncs.com/2018072711190076230325.jpg,https://prodr.oss-cn-hangzhou.aliyuncs.com/2018072711190076430355.jpg,https://prodr.oss-cn-hangzhou.aliyuncs.com/2018072711190076625284.jpg,
                     * goodsShow : https://prodr.oss-cn-hangzhou.aliyuncs.com/2018072711183599493508.jpg,
                     * goodsTab : null
                     * goodsStorage : 0
                     * marketPrice : 20
                     * salesPrice : 5
                     * goodsActivity : null
                     * goodsBanner : null
                     * shopId : a4f40e0fbb8240b681b3164166d8d04b
                     * saleFlag : 2
                     * ifPoint : 0
                     * pointRule : null
                     * approveBy : null
                     * approveDate : 1532668210000
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
                     * buyRule : null
                     * cityCode : null
                     * groupGoods : null
                     * activityId : null
                     * groupPrice : 0
                     */

                    private String id;
                    private boolean isNewRecord;
                    private Object remarks;
                    private String createDate;
                    private String updateDate;
                    private String startDate;
                    private String endDate;
                    private String goodsCate;
                    private String goodsType;
                    private String goodsName;
                    private String goodsNo;
                    private String goodsBrief;
                    private String goodsSort;
                    private String serviceTime;
                    private String goodsDetails;
                    private String goodsThumb;
                    private String goodsPic;
                    private String goodsShow;
                    private String goodsTab;
                    private String goodsStorage;
                    private String marketPrice;
                    private String salesPrice;
                    private String goodsActivity;
                    private String goodsBanner;
                    private String shopId;
                    private String saleFlag;
                    private String ifPoint;
                    private String pointRule;
                    private String approveBy;
                    private String approveDate;
                    private String approveRemarks;
                    private String startTime;
                    private String endTime;
                    private String goodsRemarks;
                    private String updatePgm;
                    private String shopName;
                    private String saleFlagName;
                    private String goodsTypeName;
                    private String goodsCateName;
                    private String ecPointsRule;
                    private String buyRule;
                    private String cityCode;
                    private String groupGoods;
                    private String activityId;
                    private String groupPrice;

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

                    public String getGoodsSort() {
                        return goodsSort;
                    }

                    public void setGoodsSort(String goodsSort) {
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

                    public String getGoodsStorage() {
                        return goodsStorage;
                    }

                    public void setGoodsStorage(String goodsStorage) {
                        this.goodsStorage = goodsStorage;
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

                    public String getGoodsRemarks() {
                        return goodsRemarks;
                    }

                    public void setGoodsRemarks(String goodsRemarks) {
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

                    public String getSaleFlagName() {
                        return saleFlagName;
                    }

                    public void setSaleFlagName(String saleFlagName) {
                        this.saleFlagName = saleFlagName;
                    }

                    public String getGoodsTypeName() {
                        return goodsTypeName;
                    }

                    public void setGoodsTypeName(String goodsTypeName) {
                        this.goodsTypeName = goodsTypeName;
                    }

                    public String getGoodsCateName() {
                        return goodsCateName;
                    }

                    public void setGoodsCateName(String goodsCateName) {
                        this.goodsCateName = goodsCateName;
                    }

                    public String getEcPointsRule() {
                        return ecPointsRule;
                    }

                    public void setEcPointsRule(String ecPointsRule) {
                        this.ecPointsRule = ecPointsRule;
                    }

                    public String getBuyRule() {
                        return buyRule;
                    }

                    public void setBuyRule(String buyRule) {
                        this.buyRule = buyRule;
                    }

                    public String getCityCode() {
                        return cityCode;
                    }

                    public void setCityCode(String cityCode) {
                        this.cityCode = cityCode;
                    }

                    public String getGroupGoods() {
                        return groupGoods;
                    }

                    public void setGroupGoods(String groupGoods) {
                        this.groupGoods = groupGoods;
                    }

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
                }
            }
        }
    }
}
