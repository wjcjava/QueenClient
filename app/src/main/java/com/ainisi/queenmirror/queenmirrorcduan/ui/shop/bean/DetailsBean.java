package com.ainisi.queenmirror.queenmirrorcduan.ui.shop.bean;

/**
 * Created by john on 2018/5/12.
 */

public class DetailsBean {


    /**
     * success : true
     * errorCode : 0
     * msg : 获取数据成功
     * body : {"ifFollow":"0","apiShop":{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"ansShopManager":null,"ansShopBasic":{"id":"111","isNewRecord":false,"remarks":null,"createDate":"2018-05-07 14:24:02","updateDate":"2018-05-12 09:32:38","contractConfirm":"1","ifContract":"0","shopName":"美美理发店","shortName":null,"shopNo":null,"marketAssistant":null,"shopBrief":null,"shopAccounce":null,"shopActivity":null,"shopFeature":null,"queenCard":"0","shopTab":null,"shopCate":"1","industryCate":"1","belongCity":"17e8e72326574a0ea94b15d6eeddbb6d","addrProvince":"江苏省","addrCity":"南京市","addrDistrict":"雨花台区","shopAddr":"雨花路1008号","openTime":"10:00:00","closeTime":"22:00:00","serviceTel":"15852855888","shopContacts":"姜超","contactsTel":"15852855880","ifLicence":"1","shopLegal":"","legalIdc":"48675519930101354X","legalAddress":null,"taxNumber":null,"businessLicence":"A23791637529664","shopCharge":"陈伟霆","chargeIdc":"321087218968210902","chargeIdp":null,"shopLogo":null,"shopPhoto":null,"shopEnvPhoto":null,"joinTime":"2018-05-07 14:24:02","businessFlag":"1","enableFlag":"1","signFlag":"1","geoX":null,"geoY":null,"updatePgm":"ApiLoginController"},"area":{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"parentIds":null,"name":"雨花台区","sort":30,"code":null,"type":null,"parentId":"0"},"ansCustFollow":null,"ansShopBrowses":{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"shopId":null,"browseCounts":4,"enableFlag":null},"ecCategory":null,"nameIdentifyLabel":null,"sexLabel":null,"loginFlagLabel":null,"contractConfirmLabel":null,"shopFeatureLabel":null,"queenCardLabel":"否","shopCateLabel":"美业","industryCateLabel":"美业","ifLicenceLabel":null,"businessFlagLabel":"正常","enableFlagLabel":"无效","contentByTitle":null,"ifContractLabel":"是","signFlagLabel":"商家自开店"}}
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
         * ifFollow : 0
         * apiShop : {"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"ansShopManager":null,"ansShopBasic":{"id":"111","isNewRecord":false,"remarks":null,"createDate":"2018-05-07 14:24:02","updateDate":"2018-05-12 09:32:38","contractConfirm":"1","ifContract":"0","shopName":"美美理发店","shortName":null,"shopNo":null,"marketAssistant":null,"shopBrief":null,"shopAccounce":null,"shopActivity":null,"shopFeature":null,"queenCard":"0","shopTab":null,"shopCate":"1","industryCate":"1","belongCity":"17e8e72326574a0ea94b15d6eeddbb6d","addrProvince":"江苏省","addrCity":"南京市","addrDistrict":"雨花台区","shopAddr":"雨花路1008号","openTime":"10:00:00","closeTime":"22:00:00","serviceTel":"15852855888","shopContacts":"姜超","contactsTel":"15852855880","ifLicence":"1","shopLegal":"","legalIdc":"48675519930101354X","legalAddress":null,"taxNumber":null,"businessLicence":"A23791637529664","shopCharge":"陈伟霆","chargeIdc":"321087218968210902","chargeIdp":null,"shopLogo":null,"shopPhoto":null,"shopEnvPhoto":null,"joinTime":"2018-05-07 14:24:02","businessFlag":"1","enableFlag":"1","signFlag":"1","geoX":null,"geoY":null,"updatePgm":"ApiLoginController"},"area":{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"parentIds":null,"name":"雨花台区","sort":30,"code":null,"type":null,"parentId":"0"},"ansCustFollow":null,"ansShopBrowses":{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"shopId":null,"browseCounts":4,"enableFlag":null},"ecCategory":null,"nameIdentifyLabel":null,"sexLabel":null,"loginFlagLabel":null,"contractConfirmLabel":null,"shopFeatureLabel":null,"queenCardLabel":"否","shopCateLabel":"美业","industryCateLabel":"美业","ifLicenceLabel":null,"businessFlagLabel":"正常","enableFlagLabel":"无效","contentByTitle":null,"ifContractLabel":"是","signFlagLabel":"商家自开店"}
         */

        private String ifFollow;
        private ApiShopBean apiShop;

        public String getIfFollow() {
            return ifFollow;
        }

        public void setIfFollow(String ifFollow) {
            this.ifFollow = ifFollow;
        }

        public ApiShopBean getApiShop() {
            return apiShop;
        }

        public void setApiShop(ApiShopBean apiShop) {
            this.apiShop = apiShop;
        }

        public static class ApiShopBean {
            /**
             * id : null
             * isNewRecord : true
             * remarks : null
             * createDate : null
             * updateDate : null
             * ansShopManager : null
             * ansShopBasic : {"id":"111","isNewRecord":false,"remarks":null,"createDate":"2018-05-07 14:24:02","updateDate":"2018-05-12 09:32:38","contractConfirm":"1","ifContract":"0","shopName":"美美理发店","shortName":null,"shopNo":null,"marketAssistant":null,"shopBrief":null,"shopAccounce":null,"shopActivity":null,"shopFeature":null,"queenCard":"0","shopTab":null,"shopCate":"1","industryCate":"1","belongCity":"17e8e72326574a0ea94b15d6eeddbb6d","addrProvince":"江苏省","addrCity":"南京市","addrDistrict":"雨花台区","shopAddr":"雨花路1008号","openTime":"10:00:00","closeTime":"22:00:00","serviceTel":"15852855888","shopContacts":"姜超","contactsTel":"15852855880","ifLicence":"1","shopLegal":"","legalIdc":"48675519930101354X","legalAddress":null,"taxNumber":null,"businessLicence":"A23791637529664","shopCharge":"陈伟霆","chargeIdc":"321087218968210902","chargeIdp":null,"shopLogo":null,"shopPhoto":null,"shopEnvPhoto":null,"joinTime":"2018-05-07 14:24:02","businessFlag":"1","enableFlag":"1","signFlag":"1","geoX":null,"geoY":null,"updatePgm":"ApiLoginController"}
             * area : {"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"parentIds":null,"name":"雨花台区","sort":30,"code":null,"type":null,"parentId":"0"}
             * ansCustFollow : null
             * ansShopBrowses : {"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"shopId":null,"browseCounts":4,"enableFlag":null}
             * ecCategory : null
             * nameIdentifyLabel : null
             * sexLabel : null
             * loginFlagLabel : null
             * contractConfirmLabel : null
             * shopFeatureLabel : null
             * queenCardLabel : 否
             * shopCateLabel : 美业
             * industryCateLabel : 美业
             * ifLicenceLabel : null
             * businessFlagLabel : 正常
             * enableFlagLabel : 无效
             * contentByTitle : null
             * ifContractLabel : 是
             * signFlagLabel : 商家自开店
             */

            private Object id;
            private boolean isNewRecord;
            private Object remarks;
            private Object createDate;
            private Object updateDate;
            private Object ansShopManager;
            private AnsShopBasicBean ansShopBasic;
            private AreaBean area;
            private Object ansCustFollow;
            private AnsShopBrowsesBean ansShopBrowses;
            private Object ecCategory;
            private Object nameIdentifyLabel;
            private Object sexLabel;
            private Object loginFlagLabel;
            private Object contractConfirmLabel;
            private Object shopFeatureLabel;
            private String queenCardLabel;
            private String shopCateLabel;
            private String industryCateLabel;
            private Object ifLicenceLabel;
            private String businessFlagLabel;
            private String enableFlagLabel;
            private Object contentByTitle;
            private String ifContractLabel;
            private String signFlagLabel;

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

            public Object getContentByTitle() {
                return contentByTitle;
            }

            public void setContentByTitle(Object contentByTitle) {
                this.contentByTitle = contentByTitle;
            }

            public String getIfContractLabel() {
                return ifContractLabel;
            }

            public void setIfContractLabel(String ifContractLabel) {
                this.ifContractLabel = ifContractLabel;
            }

            public String getSignFlagLabel() {
                return signFlagLabel;
            }

            public void setSignFlagLabel(String signFlagLabel) {
                this.signFlagLabel = signFlagLabel;
            }

            public static class AnsShopBasicBean {
                /**
                 * id : 111
                 * isNewRecord : false
                 * remarks : null
                 * createDate : 2018-05-07 14:24:02
                 * updateDate : 2018-05-12 09:32:38
                 * contractConfirm : 1
                 * ifContract : 0
                 * shopName : 美美理发店
                 * shortName : null
                 * shopNo : null
                 * marketAssistant : null
                 * shopBrief : null
                 * shopAccounce : null
                 * shopActivity : null
                 * shopFeature : null
                 * queenCard : 0
                 * shopTab : null
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
                 * ifLicence : 1
                 * shopLegal :
                 * legalIdc : 48675519930101354X
                 * legalAddress : null
                 * taxNumber : null
                 * businessLicence : A23791637529664
                 * shopCharge : 陈伟霆
                 * chargeIdc : 321087218968210902
                 * chargeIdp : null
                 * shopLogo : null
                 * shopPhoto : null
                 * shopEnvPhoto : null
                 * joinTime : 2018-05-07 14:24:02
                 * businessFlag : 1
                 * enableFlag : 1
                 * signFlag : 1
                 * geoX : null
                 * geoY : null
                 * updatePgm : ApiLoginController
                 */

                private String id;
                private boolean isNewRecord;
                private Object remarks;
                private String createDate;
                private String updateDate;
                private String contractConfirm;
                private String ifContract;
                private String shopName;
                private Object shortName;
                private Object shopNo;
                private Object marketAssistant;
                private Object shopBrief;
                private Object shopAccounce;
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
                private String ifLicence;
                private String shopLegal;
                private String legalIdc;
                private Object legalAddress;
                private Object taxNumber;
                private String businessLicence;
                private String shopCharge;
                private String chargeIdc;
                private Object chargeIdp;
                private Object shopLogo;
                private Object shopPhoto;
                private Object shopEnvPhoto;
                private String joinTime;
                private String businessFlag;
                private String enableFlag;
                private String signFlag;
                private Object geoX;
                private Object geoY;
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

                public String getIfLicence() {
                    return ifLicence;
                }

                public void setIfLicence(String ifLicence) {
                    this.ifLicence = ifLicence;
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
                 * browseCounts : 4
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
