package com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean;

import java.util.List;

/**
 * Created by john on 2018/5/15.
 */

public class ShopsBean {

    /**
     * success : true
     * errorCode : 0
     * msg : 获取数据成功
     * body : {"ShopListData":[{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"ansShopBasic":{"id":"111","isNewRecord":false,"remarks":"","createDate":"2018-05-07 14:24:02","updateDate":"2018-05-14 17:26:30","merchantId":"1","contractConfirm":"1","ifContract":"0","shopName":"美美理发店","shortName":"","shopNo":"132","marketAssistant":"","shopBrief":"专业美发","shopAccounce":"全面不休息","shopActivity":"","shopFeature":"131","queenCard":"0","shopTab":"美甲美手,美容美体","shopCate":"1","industryCate":"1","belongCity":"17e8e72326574a0ea94b15d6eeddbb6d","addrProvince":"江苏省","addrCity":"南京市","addrDistrict":"雨花台区","shopAddr":"雨花路1008号","openTime":"10:00:00","closeTime":"22:00:00","serviceTel":"15852855888","shopContacts":"姜超","contactsTel":"15852855880","contactsMail":null,"ifLicence":"1","shopProperty":"00","shopLegal":"132","legalIdc":"48675519930101354X","legalAddress":"12","taxNumber":"213456","businessLicence":"A23791637529664","shopCharge":"陈伟霆","chargeIdc":"321087218968210902","chargeIdp":"213456776543","shopLogo":"","shopPhoto":"","shopEnvPhoto":"","joinTime":"2018-05-07 14:24:02","businessFlag":"1","enableFlag":"1","signFlag":"1","geoX":"12.230000","geoY":"14.200000","updatePgm":"AnsShopBasicController"},"area":{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"parentIds":null,"name":"雨花台区","sort":30,"code":null,"type":null,"parentId":"0"},"ansShopBrowses":{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"shopId":null,"browseCounts":122,"enableFlag":null},"ecGoodsBasic":null,"ansSalesVolume":null,"ecShopScore":null,"ecCategory":null,"contractConfirmLabel":null,"ifSignLabel":"否","shopFeatureLabel":null,"queenCardLabel":"否","shopCateLabel":"美业","industryCateLabel":"美业","ifLicenceLabel":null,"businessFlagLabel":"正常","enableFlagLabel":"无效","signFlagLabel":"商家自开店","distanceScope":null,"contentByTitle":null,"sortKey":null,"list":null,"distanceShopId":null}]}
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
        private List<ShopListDataBean> ShopListData;

        public List<ShopListDataBean> getShopListData() {
            return ShopListData;
        }

        public void setShopListData(List<ShopListDataBean> ShopListData) {
            this.ShopListData = ShopListData;
        }

        public static class ShopListDataBean {
            /**
             * id : null
             * isNewRecord : true
             * remarks : null
             * createDate : null
             * updateDate : null
             * ansShopBasic : {"id":"111","isNewRecord":false,"remarks":"","createDate":"2018-05-07 14:24:02","updateDate":"2018-05-14 17:26:30","merchantId":"1","contractConfirm":"1","ifContract":"0","shopName":"美美理发店","shortName":"","shopNo":"132","marketAssistant":"","shopBrief":"专业美发","shopAccounce":"全面不休息","shopActivity":"","shopFeature":"131","queenCard":"0","shopTab":"美甲美手,美容美体","shopCate":"1","industryCate":"1","belongCity":"17e8e72326574a0ea94b15d6eeddbb6d","addrProvince":"江苏省","addrCity":"南京市","addrDistrict":"雨花台区","shopAddr":"雨花路1008号","openTime":"10:00:00","closeTime":"22:00:00","serviceTel":"15852855888","shopContacts":"姜超","contactsTel":"15852855880","contactsMail":null,"ifLicence":"1","shopProperty":"00","shopLegal":"132","legalIdc":"48675519930101354X","legalAddress":"12","taxNumber":"213456","businessLicence":"A23791637529664","shopCharge":"陈伟霆","chargeIdc":"321087218968210902","chargeIdp":"213456776543","shopLogo":"","shopPhoto":"","shopEnvPhoto":"","joinTime":"2018-05-07 14:24:02","businessFlag":"1","enableFlag":"1","signFlag":"1","geoX":"12.230000","geoY":"14.200000","updatePgm":"AnsShopBasicController"}
             * area : {"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"parentIds":null,"name":"雨花台区","sort":30,"code":null,"type":null,"parentId":"0"}
             * ansShopBrowses : {"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"shopId":null,"browseCounts":122,"enableFlag":null}
             * ecGoodsBasic : null
             * ansSalesVolume : null
             * ecShopScore : null
             * ecCategory : null
             * contractConfirmLabel : null
             * ifSignLabel : 否
             * shopFeatureLabel : null
             * queenCardLabel : 否
             * shopCateLabel : 美业
             * industryCateLabel : 美业
             * ifLicenceLabel : null
             * businessFlagLabel : 正常
             * enableFlagLabel : 无效
             * signFlagLabel : 商家自开店
             * distanceScope : null
             * contentByTitle : null
             * sortKey : null
             * list : null
             * distanceShopId : null
             */

            private Object id;
            private boolean isNewRecord;
            private Object remarks;
            private Object createDate;
            private Object updateDate;
            private AnsShopBasicBean ansShopBasic;
            private AreaBean area;
            private AnsShopBrowsesBean ansShopBrowses;
            private Object ecGoodsBasic;
            private Object ansSalesVolume;
            private Object ecShopScore;
            private Object ecCategory;
            private Object contractConfirmLabel;
            private String ifSignLabel;
            private Object shopFeatureLabel;
            private String queenCardLabel;
            private String shopCateLabel;
            private String industryCateLabel;
            private Object ifLicenceLabel;
            private String businessFlagLabel;
            private String enableFlagLabel;
            private String signFlagLabel;
            private Object distanceScope;
            private Object contentByTitle;
            private Object sortKey;
            private Object list;
            private Object distanceShopId;

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

            public AnsShopBasicBean getAnsShopBasic() {
                return ansShopBasic;
            }

            public void setAnsShopBasic(AnsShopBasicBean ansShopBasic) {
                this.ansShopBasic = ansShopBasic;
            }

            public AreaBean getArea() {
                return area;
            }

            public void setArea(AreaBean area) {
                this.area = area;
            }

            public AnsShopBrowsesBean getAnsShopBrowses() {
                return ansShopBrowses;
            }

            public void setAnsShopBrowses(AnsShopBrowsesBean ansShopBrowses) {
                this.ansShopBrowses = ansShopBrowses;
            }

            public Object getEcGoodsBasic() {
                return ecGoodsBasic;
            }

            public void setEcGoodsBasic(Object ecGoodsBasic) {
                this.ecGoodsBasic = ecGoodsBasic;
            }

            public Object getAnsSalesVolume() {
                return ansSalesVolume;
            }

            public void setAnsSalesVolume(Object ansSalesVolume) {
                this.ansSalesVolume = ansSalesVolume;
            }

            public Object getEcShopScore() {
                return ecShopScore;
            }

            public void setEcShopScore(Object ecShopScore) {
                this.ecShopScore = ecShopScore;
            }

            public Object getEcCategory() {
                return ecCategory;
            }

            public void setEcCategory(Object ecCategory) {
                this.ecCategory = ecCategory;
            }

            public Object getContractConfirmLabel() {
                return contractConfirmLabel;
            }

            public void setContractConfirmLabel(Object contractConfirmLabel) {
                this.contractConfirmLabel = contractConfirmLabel;
            }

            public String getIfSignLabel() {
                return ifSignLabel;
            }

            public void setIfSignLabel(String ifSignLabel) {
                this.ifSignLabel = ifSignLabel;
            }

            public Object getShopFeatureLabel() {
                return shopFeatureLabel;
            }

            public void setShopFeatureLabel(Object shopFeatureLabel) {
                this.shopFeatureLabel = shopFeatureLabel;
            }

            public String getQueenCardLabel() {
                return queenCardLabel;
            }

            public void setQueenCardLabel(String queenCardLabel) {
                this.queenCardLabel = queenCardLabel;
            }

            public String getShopCateLabel() {
                return shopCateLabel;
            }

            public void setShopCateLabel(String shopCateLabel) {
                this.shopCateLabel = shopCateLabel;
            }

            public String getIndustryCateLabel() {
                return industryCateLabel;
            }

            public void setIndustryCateLabel(String industryCateLabel) {
                this.industryCateLabel = industryCateLabel;
            }

            public Object getIfLicenceLabel() {
                return ifLicenceLabel;
            }

            public void setIfLicenceLabel(Object ifLicenceLabel) {
                this.ifLicenceLabel = ifLicenceLabel;
            }

            public String getBusinessFlagLabel() {
                return businessFlagLabel;
            }

            public void setBusinessFlagLabel(String businessFlagLabel) {
                this.businessFlagLabel = businessFlagLabel;
            }

            public String getEnableFlagLabel() {
                return enableFlagLabel;
            }

            public void setEnableFlagLabel(String enableFlagLabel) {
                this.enableFlagLabel = enableFlagLabel;
            }

            public String getSignFlagLabel() {
                return signFlagLabel;
            }

            public void setSignFlagLabel(String signFlagLabel) {
                this.signFlagLabel = signFlagLabel;
            }

            public Object getDistanceScope() {
                return distanceScope;
            }

            public void setDistanceScope(Object distanceScope) {
                this.distanceScope = distanceScope;
            }

            public Object getContentByTitle() {
                return contentByTitle;
            }

            public void setContentByTitle(Object contentByTitle) {
                this.contentByTitle = contentByTitle;
            }

            public Object getSortKey() {
                return sortKey;
            }

            public void setSortKey(Object sortKey) {
                this.sortKey = sortKey;
            }

            public Object getList() {
                return list;
            }

            public void setList(Object list) {
                this.list = list;
            }

            public Object getDistanceShopId() {
                return distanceShopId;
            }

            public void setDistanceShopId(Object distanceShopId) {
                this.distanceShopId = distanceShopId;
            }

            public static class AnsShopBasicBean {
                /**
                 * id : 111
                 * isNewRecord : false
                 * remarks :
                 * createDate : 2018-05-07 14:24:02
                 * updateDate : 2018-05-14 17:26:30
                 * merchantId : 1
                 * contractConfirm : 1
                 * ifContract : 0
                 * shopName : 美美理发店
                 * shortName :
                 * shopNo : 132
                 * marketAssistant :
                 * shopBrief : 专业美发
                 * shopAccounce : 全面不休息
                 * shopActivity :
                 * shopFeature : 131
                 * queenCard : 0
                 * shopTab : 美甲美手,美容美体
                 * shopCate : 1
                 * industryCate : 1
                 * belongCity : 17e8e72326574a0ea94b15d6eeddbb6d
                 * addrProvince : 江苏省
                 * addrCity : 南京市
                 * addrDistrict : 雨花台区
                 * shopAddr : 雨花路1008号
                 * openTime : 10:00:00
                 * closeTime : 22:00:00
                 * serviceTel : 15852855888
                 * shopContacts : 姜超
                 * contactsTel : 15852855880
                 * contactsMail : null
                 * ifLicence : 1
                 * shopProperty : 00
                 * shopLegal : 132
                 * legalIdc : 48675519930101354X
                 * legalAddress : 12
                 * taxNumber : 213456
                 * businessLicence : A23791637529664
                 * shopCharge : 陈伟霆
                 * chargeIdc : 321087218968210902
                 * chargeIdp : 213456776543
                 * shopLogo :
                 * shopPhoto :
                 * shopEnvPhoto :
                 * joinTime : 2018-05-07 14:24:02
                 * businessFlag : 1
                 * enableFlag : 1
                 * signFlag : 1
                 * geoX : 12.230000
                 * geoY : 14.200000
                 * updatePgm : AnsShopBasicController
                 */

                private String id;
                private boolean isNewRecord;
                private String remarks;
                private String createDate;
                private String updateDate;
                private String merchantId;
                private String contractConfirm;
                private String ifContract;
                private String shopName;
                private String shortName;
                private String shopNo;
                private String marketAssistant;
                private String shopBrief;
                private String shopAccounce;
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
                private Object contactsMail;
                private String ifLicence;
                private String shopProperty;
                private String shopLegal;
                private String legalIdc;
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
            }

            public static class AreaBean {
                /**
                 * id : null
                 * isNewRecord : true
                 * remarks : null
                 * createDate : null
                 * updateDate : null
                 * parentIds : null
                 * name : 雨花台区
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

            public static class AnsShopBrowsesBean {
                /**
                 * id : null
                 * isNewRecord : true
                 * remarks : null
                 * createDate : null
                 * updateDate : null
                 * shopId : null
                 * browseCounts : 122
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
