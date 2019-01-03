package com.ainisi.queenmirror.queenmirrorcduan.bean;

import java.io.Serializable;
import java.util.List;

public class ShopListHomeBean implements Serializable{


    /**
     * success : true
     * errorCode : 0
     * msg : 获取数据成功
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

    public static class BodyBean implements Serializable{
        /**
         * pageSum : 9
         */

        private int pageSum;
        private List<ShopListDataBean> ShopListData;

        public int getPageSum() {
            return pageSum;
        }

        public void setPageSum(int pageSum) {
            this.pageSum = pageSum;
        }

        public List<ShopListDataBean> getShopListData() {
            return ShopListData;
        }

        public void setShopListData(List<ShopListDataBean> ShopListData) {
            this.ShopListData = ShopListData;
        }

        public static class ShopListDataBean implements Serializable{
            /**
             * id : null
             * isNewRecord : true
             * remarks : null
             * createDate : null
             * updateDate : null
             * ansShopManager : null
             * ecCategory : null
             * nameIdentifyLabel : null
             * sexLabel : null
             * loginFlagLabel : null
             * contractConfirmLabel : null
             * shopFeatureLabel : null
             * queenCardLabel : null
             * shopCateLabel : null
             * industryCateLabel : null
             * ifLicenceLabel : null
             * businessFlagLabel : null
             * enableFlagLabel : null
             * contentByTitle : null
             * ifContractLabel : null
             * signFlagLabel : null
             * comScore : 5.0
             */

            private Object id;
            private boolean isNewRecord;
            private Object remarks;
            private Object createDate;
            private Object updateDate;
            private Object ansShopManager;
            private AnsShopBasicBean ansShopBasic;
            private Object ansShopModify;
            private Object ansMerchantInfo;
            private AreaBean area;
            private Object ansCustFollow;
            private AnsShopBrowsesBean ansShopBrowses;
            private Object ecCategory;
            private Object nameIdentifyLabel;
            private Object sexLabel;
            private Object loginFlagLabel;
            private Object contractConfirmLabel;
            private Object shopFeatureLabel;
            private Object queenCardLabel;
            private Object shopCateLabel;
            private Object industryCateLabel;
            private Object ifLicenceLabel;
            private Object businessFlagLabel;
            private Object enableFlagLabel;
            private Object contentByTitle;
            private Object ifContractLabel;
            private Object signFlagLabel;
            private String comScore;
            private String freeType;

            public boolean isNewRecord() {
                return isNewRecord;
            }

            public void setNewRecord(boolean newRecord) {
                isNewRecord = newRecord;
            }

            public String getFreeType() {
                return freeType;
            }

            public void setFreeType(String freeType) {
                this.freeType = freeType;
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

            public Object getAnsShopManager() {
                return ansShopManager;
            }

            public void setAnsShopManager(Object ansShopManager) {
                this.ansShopManager = ansShopManager;
            }

            public AnsShopBasicBean getAnsShopBasic() {
                return ansShopBasic;
            }

            public void setAnsShopBasic(AnsShopBasicBean ansShopBasic) {
                this.ansShopBasic = ansShopBasic;
            }

            public Object getAnsShopModify() {
                return ansShopModify;
            }

            public void setAnsShopModify(Object ansShopModify) {
                this.ansShopModify = ansShopModify;
            }

            public Object getAnsMerchantInfo() {
                return ansMerchantInfo;
            }

            public void setAnsMerchantInfo(Object ansMerchantInfo) {
                this.ansMerchantInfo = ansMerchantInfo;
            }

            public AreaBean getArea() {
                return area;
            }

            public void setArea(AreaBean area) {
                this.area = area;
            }

            public Object getAnsCustFollow() {
                return ansCustFollow;
            }

            public void setAnsCustFollow(Object ansCustFollow) {
                this.ansCustFollow = ansCustFollow;
            }

            public AnsShopBrowsesBean getAnsShopBrowses() {
                return ansShopBrowses;
            }

            public void setAnsShopBrowses(AnsShopBrowsesBean ansShopBrowses) {
                this.ansShopBrowses = ansShopBrowses;
            }

            public Object getEcCategory() {
                return ecCategory;
            }

            public void setEcCategory(Object ecCategory) {
                this.ecCategory = ecCategory;
            }

            public Object getNameIdentifyLabel() {
                return nameIdentifyLabel;
            }

            public void setNameIdentifyLabel(Object nameIdentifyLabel) {
                this.nameIdentifyLabel = nameIdentifyLabel;
            }

            public Object getSexLabel() {
                return sexLabel;
            }

            public void setSexLabel(Object sexLabel) {
                this.sexLabel = sexLabel;
            }

            public Object getLoginFlagLabel() {
                return loginFlagLabel;
            }

            public void setLoginFlagLabel(Object loginFlagLabel) {
                this.loginFlagLabel = loginFlagLabel;
            }

            public Object getContractConfirmLabel() {
                return contractConfirmLabel;
            }

            public void setContractConfirmLabel(Object contractConfirmLabel) {
                this.contractConfirmLabel = contractConfirmLabel;
            }

            public Object getShopFeatureLabel() {
                return shopFeatureLabel;
            }

            public void setShopFeatureLabel(Object shopFeatureLabel) {
                this.shopFeatureLabel = shopFeatureLabel;
            }

            public Object getQueenCardLabel() {
                return queenCardLabel;
            }

            public void setQueenCardLabel(Object queenCardLabel) {
                this.queenCardLabel = queenCardLabel;
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

            public Object getIfLicenceLabel() {
                return ifLicenceLabel;
            }

            public void setIfLicenceLabel(Object ifLicenceLabel) {
                this.ifLicenceLabel = ifLicenceLabel;
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

            public Object getContentByTitle() {
                return contentByTitle;
            }

            public void setContentByTitle(Object contentByTitle) {
                this.contentByTitle = contentByTitle;
            }

            public Object getIfContractLabel() {
                return ifContractLabel;
            }

            public void setIfContractLabel(Object ifContractLabel) {
                this.ifContractLabel = ifContractLabel;
            }

            public Object getSignFlagLabel() {
                return signFlagLabel;
            }

            public void setSignFlagLabel(Object signFlagLabel) {
                this.signFlagLabel = signFlagLabel;
            }

            public String getComScore() {
                return comScore;
            }

            public void setComScore(String comScore) {
                this.comScore = comScore;
            }

            public static class AnsShopBasicBean implements Serializable{
                /**
                 * id : 97f6494cad0f4c8e9c0dfb62d1f9f50a
                 * isNewRecord : false
                 * remarks :
                 * createDate : 2018-06-28 14:17:05
                 * updateDate : 2018-06-28 14:17:05
                 * merchantId : null
                 * contractConfirm : 0
                 * ifContract : 0
                 * shopName : 姜超的店铺
                 * shortName : null
                 * shopNo : d18091edc6
                 * marketAssistant : null
                 * shopBrief : 全苏州仅此一家
                 * shopAccounce : null
                 * ifNew : 0
                 * shopBanner : null
                 * shopActivity : null
                 * shopFeature : null
                 * queenCard : 0
                 * shopTab : null
                 * shopCate : 1
                 * industryCate : 纯色
                 * belongCity : 337289fd68bb4af980141cae1446869f
                 * addrProvince : 江苏省
                 * addrCity : 苏州市
                 * addrDistrict : 相城区
                 * shopAddr : 黄桥半雅足浴店
                 * openTime : 08:00
                 * closeTime : 20:00
                 * serviceTel : 15852855880
                 * shopContacts : 姜超
                 * contactsTel :
                 * contactsMail : null
                 * ifLicence : 0
                 * shopProperty : null
                 * shopLegal : 姜超
                 * legalIdc : 321084199101010101
                 * legalIdp : 2018062802163972525086.jpg,2018062802163978882927.jpg,
                 * legalProvince : null
                 * legalCity : null
                 * legalDistrict : null
                 * legalAddress : null
                 * taxNumber : X2469764991949
                 * businessLicence : https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062802164518519971.jpg,https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062802164518940263.jpg,https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062802164519175777.jpg,
                 * shopCharge :
                 * chargeIdc :
                 * chargeIdp :
                 * shopLogo : https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062802165260426383.jpg,
                 * shopPhoto : null
                 * shopEnvPhoto : https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062802165953329615.jpg,https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062802165953754210.jpg,https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062802165953983222.jpg,https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062802165954168159.jpg,https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062802165954396572.jpg,
                 * joinTime : 2018-06-28 14:17:05
                 * businessFlag : 1
                 * enableFlag : 1
                 * signFlag : 1
                 * geoX : 120.592379
                 * geoY : 31.375791
                 * updatePgm : ApiLoginController
                 * belongCityName : null
                 * apiAnsCustCartList : null
                 * goodsCounts : 0
                 * approveBy : null
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
                 */

                private String id;
                private boolean isNewRecord;
                private String remarks;
                private String createDate;
                private String updateDate;
                private Object merchantId;
                private String contractConfirm;
                private String ifContract;
                private String shopName;
                private Object shortName;
                private String shopNo;
                private Object marketAssistant;
                private String shopBrief;
                private Object shopAccounce;
                private String ifNew;
                private Object shopBanner;
                private Object shopActivity;
                private Object shopFeature;
                private String queenCard;
                private Object shopTab;
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
                private Object contactsMail;
                private String ifLicence;
                private Object shopProperty;
                private String shopLegal;
                private String legalIdc;
                private String legalIdp;
                private Object legalProvince;
                private Object legalCity;
                private Object legalDistrict;
                private Object legalAddress;
                private String taxNumber;
                private String businessLicence;
                private String shopCharge;
                private String chargeIdc;
                private String chargeIdp;
                private String shopLogo;
                private Object shopPhoto;
                private String shopEnvPhoto;
                private String joinTime;
                private String businessFlag;
                private String enableFlag;
                private String signFlag;
                private String geoX;
                private String geoY;
                private String updatePgm;
                private Object belongCityName;
                private Object apiAnsCustCartList;
                private int goodsCounts;
                private Object approveBy;
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

                public Object getMerchantId() {
                    return merchantId;
                }

                public void setMerchantId(Object merchantId) {
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

                public Object getShortName() {
                    return shortName;
                }

                public void setShortName(Object shortName) {
                    this.shortName = shortName;
                }

                public String getShopNo() {
                    return shopNo;
                }

                public void setShopNo(String shopNo) {
                    this.shopNo = shopNo;
                }

                public Object getMarketAssistant() {
                    return marketAssistant;
                }

                public void setMarketAssistant(Object marketAssistant) {
                    this.marketAssistant = marketAssistant;
                }

                public String getShopBrief() {
                    return shopBrief;
                }

                public void setShopBrief(String shopBrief) {
                    this.shopBrief = shopBrief;
                }

                public Object getShopAccounce() {
                    return shopAccounce;
                }

                public void setShopAccounce(Object shopAccounce) {
                    this.shopAccounce = shopAccounce;
                }

                public String getIfNew() {
                    return ifNew;
                }

                public void setIfNew(String ifNew) {
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

                public Object getContactsMail() {
                    return contactsMail;
                }

                public void setContactsMail(Object contactsMail) {
                    this.contactsMail = contactsMail;
                }

                public String getIfLicence() {
                    return ifLicence;
                }

                public void setIfLicence(String ifLicence) {
                    this.ifLicence = ifLicence;
                }

                public Object getShopProperty() {
                    return shopProperty;
                }

                public void setShopProperty(Object shopProperty) {
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

                public Object getShopPhoto() {
                    return shopPhoto;
                }

                public void setShopPhoto(Object shopPhoto) {
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

                public boolean isNewRecord() {
                    return isNewRecord;
                }

                public void setNewRecord(boolean newRecord) {
                    isNewRecord = newRecord;
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
            }

            public static class AreaBean implements Serializable{
                /**
                 * id : null
                 * isNewRecord : true
                 * remarks : null
                 * createDate : null
                 * updateDate : null
                 * parentIds : null
                 * name : 相城区
                 * sort : 30
                 * code : null
                 * type : null
                 * parentId : 0
                 */

                private Object id;
                private boolean isNewRecord;
                private Object remarks;
                private Object createDate;
                private Object updateDate;
                private Object parentIds;
                private String name;
                private int sort;
                private Object code;
                private Object type;
                private String parentId;

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

                public Object getParentIds() {
                    return parentIds;
                }

                public void setParentIds(Object parentIds) {
                    this.parentIds = parentIds;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public int getSort() {
                    return sort;
                }

                public void setSort(int sort) {
                    this.sort = sort;
                }

                public Object getCode() {
                    return code;
                }

                public void setCode(Object code) {
                    this.code = code;
                }

                public Object getType() {
                    return type;
                }

                public void setType(Object type) {
                    this.type = type;
                }

                public String getParentId() {
                    return parentId;
                }

                public void setParentId(String parentId) {
                    this.parentId = parentId;
                }
            }

            public static class AnsShopBrowsesBean implements Serializable{
                /**
                 * id : null
                 * isNewRecord : true
                 * remarks : null
                 * createDate : null
                 * updateDate : null
                 * shopId : null
                 * browseCounts : 85
                 * enableFlag : null
                 */

                private Object id;
                private boolean isNewRecord;
                private Object remarks;
                private Object createDate;
                private Object updateDate;
                private Object shopId;
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

                public Object getShopId() {
                    return shopId;
                }

                public void setShopId(Object shopId) {
                    this.shopId = shopId;
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
