package com.ainisi.queenmirror.queenmirrorcduan.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/4/26.
 */

public class Bean {

    /**
     * success : true
     * errorCode : 0
     * msg : 获取数据成功
     * body : {"apiRefundList":[{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"ansCustRefund":{"id":"9ca4eba9a002422cbd4f1adf12696598","isNewRecord":false,"remarks":null,"createDate":"2018-04-15 23:35:06","updateDate":"2018-04-15 23:35:06","orderId":"111","detailsId":null,"custId":"111","shopId":"111","goodsId":"111","refundReason":"1","otherReason":"111","refundAmount":111,"actualAmount":111,"refundDetails":"111","refundEvidence":"111","refundStatus":"1","updatePgm":null},"ansOrderDetails":null,"ansOrder":null,"ansShopBasic":{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"contractConfirm":null,"shopName":"1","shortName":null,"shopNo":null,"marketAssistant":null,"shopBrief":null,"shopAccounce":null,"shopActivity":null,"shopFeature":null,"shopFeatureLabel":null,"queenCard":null,"queenCardLabel":null,"shopTab":null,"shopCate":null,"shopCateLabel":null,"industryCate":null,"belongCity":null,"addrProvince":null,"addrCity":null,"addrDistrict":null,"shopAddr":null,"openTime":null,"closeTime":null,"serviceTel":null,"shopContacts":null,"contactsTel":null,"ifLicence":null,"shopLegal":null,"legalIdc":null,"legalAddress":null,"taxNumber":null,"businessLicence":null,"shopCharge":null,"chargeIdc":null,"chargeIdp":null,"shopLogo":null,"shopPhoto":null,"shopEnvPhoto":null,"joinTime":null,"businessFlag":null,"businessFlagLabel":null,"enableFlag":null,"geoX":null,"geoY":null,"updatePgm":null},"ansCustBasic":{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"contractConfirm":null,"cellPhone":null,"userName":"122223221","userPass":null,"wechatId":null,"wechatToken":null,"qqId":null,"qqToken":null,"headPic":null,"lastName":null,"firstName":null,"idCard":null,"nameIdentify":null,"sex":null,"birthday":null,"registerDate":null,"nickName":null,"loginIp":null,"logininTime":null,"loginoutTime":null,"loginFlag":null,"recommendUser":null,"recommendCode":null,"updatBy":null,"updatePgm":null,"qqtoken":null},"ecGoodsBasic":{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"goodsCate":null,"goodsType":null,"goodsName":"1","goodsNo":null,"goodsBrief":null,"serviceTime":null,"goodsDetails":null,"goodsThumb":null,"goodsPic":null,"goodsShow":null,"goodsTab":null,"goodsStorage":null,"goodsPrice":null,"offlinePrice":null,"salesPrice":null,"promotionPrice":null,"goodsActivity":null,"shopId":null,"saleFlag":null,"startTime":null,"endTime":null,"goodsRemarks":null,"updatePgm":null},"refundReasonLabel":"不喜欢/效果不好","refundStatusLabel":"退款中"}]}
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
        private List<ApiRefundListBean> apiRefundList;

        public List<ApiRefundListBean> getApiRefundList() {
            return apiRefundList;
        }

        public void setApiRefundList(List<ApiRefundListBean> apiRefundList) {
            this.apiRefundList = apiRefundList;
        }

        public static class ApiRefundListBean {
            /**
             * id : null
             * isNewRecord : true
             * remarks : null
             * createDate : null
             * updateDate : null
             * ansCustRefund : {"id":"9ca4eba9a002422cbd4f1adf12696598","isNewRecord":false,"remarks":null,"createDate":"2018-04-15 23:35:06","updateDate":"2018-04-15 23:35:06","orderId":"111","detailsId":null,"custId":"111","shopId":"111","goodsId":"111","refundReason":"1","otherReason":"111","refundAmount":111,"actualAmount":111,"refundDetails":"111","refundEvidence":"111","refundStatus":"1","updatePgm":null}
             * ansOrderDetails : null
             * ansOrder : null
             * ansShopBasic : {"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"contractConfirm":null,"shopName":"1","shortName":null,"shopNo":null,"marketAssistant":null,"shopBrief":null,"shopAccounce":null,"shopActivity":null,"shopFeature":null,"shopFeatureLabel":null,"queenCard":null,"queenCardLabel":null,"shopTab":null,"shopCate":null,"shopCateLabel":null,"industryCate":null,"belongCity":null,"addrProvince":null,"addrCity":null,"addrDistrict":null,"shopAddr":null,"openTime":null,"closeTime":null,"serviceTel":null,"shopContacts":null,"contactsTel":null,"ifLicence":null,"shopLegal":null,"legalIdc":null,"legalAddress":null,"taxNumber":null,"businessLicence":null,"shopCharge":null,"chargeIdc":null,"chargeIdp":null,"shopLogo":null,"shopPhoto":null,"shopEnvPhoto":null,"joinTime":null,"businessFlag":null,"businessFlagLabel":null,"enableFlag":null,"geoX":null,"geoY":null,"updatePgm":null}
             * ansCustBasic : {"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"contractConfirm":null,"cellPhone":null,"userName":"122223221","userPass":null,"wechatId":null,"wechatToken":null,"qqId":null,"qqToken":null,"headPic":null,"lastName":null,"firstName":null,"idCard":null,"nameIdentify":null,"sex":null,"birthday":null,"registerDate":null,"nickName":null,"loginIp":null,"logininTime":null,"loginoutTime":null,"loginFlag":null,"recommendUser":null,"recommendCode":null,"updatBy":null,"updatePgm":null,"qqtoken":null}
             * ecGoodsBasic : {"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"goodsCate":null,"goodsType":null,"goodsName":"1","goodsNo":null,"goodsBrief":null,"serviceTime":null,"goodsDetails":null,"goodsThumb":null,"goodsPic":null,"goodsShow":null,"goodsTab":null,"goodsStorage":null,"goodsPrice":null,"offlinePrice":null,"salesPrice":null,"promotionPrice":null,"goodsActivity":null,"shopId":null,"saleFlag":null,"startTime":null,"endTime":null,"goodsRemarks":null,"updatePgm":null}
             * refundReasonLabel : 不喜欢/效果不好
             * refundStatusLabel : 退款中
             */

            private Object id;
            private boolean isNewRecord;
            private Object remarks;
            private Object createDate;
            private Object updateDate;
            private AnsCustRefundBean ansCustRefund;
            private Object ansOrderDetails;
            private Object ansOrder;
            private AnsShopBasicBean ansShopBasic;
            private AnsCustBasicBean ansCustBasic;
            private EcGoodsBasicBean ecGoodsBasic;
            private String refundReasonLabel;
            private String refundStatusLabel;

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

            public AnsCustRefundBean getAnsCustRefund() {
                return ansCustRefund;
            }

            public void setAnsCustRefund(AnsCustRefundBean ansCustRefund) {
                this.ansCustRefund = ansCustRefund;
            }

            public Object getAnsOrderDetails() {
                return ansOrderDetails;
            }

            public void setAnsOrderDetails(Object ansOrderDetails) {
                this.ansOrderDetails = ansOrderDetails;
            }

            public Object getAnsOrder() {
                return ansOrder;
            }

            public void setAnsOrder(Object ansOrder) {
                this.ansOrder = ansOrder;
            }

            public AnsShopBasicBean getAnsShopBasic() {
                return ansShopBasic;
            }

            public void setAnsShopBasic(AnsShopBasicBean ansShopBasic) {
                this.ansShopBasic = ansShopBasic;
            }

            public AnsCustBasicBean getAnsCustBasic() {
                return ansCustBasic;
            }

            public void setAnsCustBasic(AnsCustBasicBean ansCustBasic) {
                this.ansCustBasic = ansCustBasic;
            }

            public EcGoodsBasicBean getEcGoodsBasic() {
                return ecGoodsBasic;
            }

            public void setEcGoodsBasic(EcGoodsBasicBean ecGoodsBasic) {
                this.ecGoodsBasic = ecGoodsBasic;
            }

            public String getRefundReasonLabel() {
                return refundReasonLabel;
            }

            public void setRefundReasonLabel(String refundReasonLabel) {
                this.refundReasonLabel = refundReasonLabel;
            }

            public String getRefundStatusLabel() {
                return refundStatusLabel;
            }

            public void setRefundStatusLabel(String refundStatusLabel) {
                this.refundStatusLabel = refundStatusLabel;
            }

            public static class AnsCustRefundBean {
                /**
                 * id : 9ca4eba9a002422cbd4f1adf12696598
                 * isNewRecord : false
                 * remarks : null
                 * createDate : 2018-04-15 23:35:06
                 * updateDate : 2018-04-15 23:35:06
                 * orderId : 111
                 * detailsId : null
                 * custId : 111
                 * shopId : 111
                 * goodsId : 111
                 * refundReason : 1
                 * otherReason : 111
                 * refundAmount : 111.0
                 * actualAmount : 111.0
                 * refundDetails : 111
                 * refundEvidence : 111
                 * refundStatus : 1
                 * updatePgm : null
                 */

                private String id;
                private boolean isNewRecord;
                private Object remarks;
                private String createDate;
                private String updateDate;
                private String orderId;
                private Object detailsId;
                private String custId;
                private String shopId;
                private String goodsId;
                private String refundReason;
                private String otherReason;
                private double refundAmount;
                private double actualAmount;
                private String refundDetails;
                private String refundEvidence;
                private String refundStatus;
                private Object updatePgm;

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

                public String getOrderId() {
                    return orderId;
                }

                public void setOrderId(String orderId) {
                    this.orderId = orderId;
                }

                public Object getDetailsId() {
                    return detailsId;
                }

                public void setDetailsId(Object detailsId) {
                    this.detailsId = detailsId;
                }

                public String getCustId() {
                    return custId;
                }

                public void setCustId(String custId) {
                    this.custId = custId;
                }

                public String getShopId() {
                    return shopId;
                }

                public void setShopId(String shopId) {
                    this.shopId = shopId;
                }

                public String getGoodsId() {
                    return goodsId;
                }

                public void setGoodsId(String goodsId) {
                    this.goodsId = goodsId;
                }

                public String getRefundReason() {
                    return refundReason;
                }

                public void setRefundReason(String refundReason) {
                    this.refundReason = refundReason;
                }

                public String getOtherReason() {
                    return otherReason;
                }

                public void setOtherReason(String otherReason) {
                    this.otherReason = otherReason;
                }

                public double getRefundAmount() {
                    return refundAmount;
                }

                public void setRefundAmount(double refundAmount) {
                    this.refundAmount = refundAmount;
                }

                public double getActualAmount() {
                    return actualAmount;
                }

                public void setActualAmount(double actualAmount) {
                    this.actualAmount = actualAmount;
                }

                public String getRefundDetails() {
                    return refundDetails;
                }

                public void setRefundDetails(String refundDetails) {
                    this.refundDetails = refundDetails;
                }

                public String getRefundEvidence() {
                    return refundEvidence;
                }

                public void setRefundEvidence(String refundEvidence) {
                    this.refundEvidence = refundEvidence;
                }

                public String getRefundStatus() {
                    return refundStatus;
                }

                public void setRefundStatus(String refundStatus) {
                    this.refundStatus = refundStatus;
                }

                public Object getUpdatePgm() {
                    return updatePgm;
                }

                public void setUpdatePgm(Object updatePgm) {
                    this.updatePgm = updatePgm;
                }
            }

            public static class AnsShopBasicBean {
                /**
                 * id : null
                 * isNewRecord : true
                 * remarks : null
                 * createDate : null
                 * updateDate : null
                 * contractConfirm : null
                 * shopName : 1
                 * shortName : null
                 * shopNo : null
                 * marketAssistant : null
                 * shopBrief : null
                 * shopAccounce : null
                 * shopActivity : null
                 * shopFeature : null
                 * shopFeatureLabel : null
                 * queenCard : null
                 * queenCardLabel : null
                 * shopTab : null
                 * shopCate : null
                 * shopCateLabel : null
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
                 * ifLicence : null
                 * shopLegal : null
                 * legalIdc : null
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
                 * businessFlagLabel : null
                 * enableFlag : null
                 * geoX : null
                 * geoY : null
                 * updatePgm : null
                 */

                private Object id;
                private boolean isNewRecord;
                private Object remarks;
                private Object createDate;
                private Object updateDate;
                private Object contractConfirm;
                private String shopName;
                private Object shortName;
                private Object shopNo;
                private Object marketAssistant;
                private Object shopBrief;
                private Object shopAccounce;
                private Object shopActivity;
                private Object shopFeature;
                private Object shopFeatureLabel;
                private Object queenCard;
                private Object queenCardLabel;
                private Object shopTab;
                private String shopCate;
                private Object shopCateLabel;
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
                private Object ifLicence;
                private Object shopLegal;
                private Object legalIdc;
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
                private Object businessFlagLabel;
                private Object enableFlag;
                private Object geoX;
                private Object geoY;
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

                public Object getContractConfirm() {
                    return contractConfirm;
                }

                public void setContractConfirm(Object contractConfirm) {
                    this.contractConfirm = contractConfirm;
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

                public Object getShopFeatureLabel() {
                    return shopFeatureLabel;
                }

                public void setShopFeatureLabel(Object shopFeatureLabel) {
                    this.shopFeatureLabel = shopFeatureLabel;
                }

                public Object getQueenCard() {
                    return queenCard;
                }

                public void setQueenCard(Object queenCard) {
                    this.queenCard = queenCard;
                }

                public Object getQueenCardLabel() {
                    return queenCardLabel;
                }

                public void setQueenCardLabel(Object queenCardLabel) {
                    this.queenCardLabel = queenCardLabel;
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

                public Object getShopCateLabel() {
                    return shopCateLabel;
                }

                public void setShopCateLabel(Object shopCateLabel) {
                    this.shopCateLabel = shopCateLabel;
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

                public Object getIfLicence() {
                    return ifLicence;
                }

                public void setIfLicence(Object ifLicence) {
                    this.ifLicence = ifLicence;
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

                public Object getBusinessFlagLabel() {
                    return businessFlagLabel;
                }

                public void setBusinessFlagLabel(Object businessFlagLabel) {
                    this.businessFlagLabel = businessFlagLabel;
                }

                public Object getEnableFlag() {
                    return enableFlag;
                }

                public void setEnableFlag(Object enableFlag) {
                    this.enableFlag = enableFlag;
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
            }

            public static class AnsCustBasicBean {
                /**
                 * id : null
                 * isNewRecord : true
                 * remarks : null
                 * createDate : null
                 * updateDate : null
                 * contractConfirm : null
                 * cellPhone : null
                 * userName : 122223221
                 * userPass : null
                 * wechatId : null
                 * wechatToken : null
                 * qqId : null
                 * qqToken : null
                 * headPic : null
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
                 * qqtoken : null
                 */

                private Object id;
                private boolean isNewRecord;
                private Object remarks;
                private Object createDate;
                private Object updateDate;
                private Object contractConfirm;
                private Object cellPhone;
                private String userName;
                private Object userPass;
                private Object wechatId;
                private Object wechatToken;
                private Object qqId;
                private Object qqToken;
                private Object headPic;
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
                private Object qqtoken;

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

                public Object getHeadPic() {
                    return headPic;
                }

                public void setHeadPic(Object headPic) {
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

                public Object getQqtoken() {
                    return qqtoken;
                }

                public void setQqtoken(Object qqtoken) {
                    this.qqtoken = qqtoken;
                }
            }

            public static class EcGoodsBasicBean {
                /**
                 * id : null
                 * isNewRecord : true
                 * remarks : null
                 * createDate : null
                 * updateDate : null
                 * goodsCate : null
                 * goodsType : null
                 * goodsName : 1
                 * goodsNo : null
                 * goodsBrief : null
                 * serviceTime : null
                 * goodsDetails : null
                 * goodsThumb : null
                 * goodsPic : null
                 * goodsShow : null
                 * goodsTab : null
                 * goodsStorage : null
                 * goodsPrice : null
                 * offlinePrice : null
                 * salesPrice : null
                 * promotionPrice : null
                 * goodsActivity : null
                 * shopId : null
                 * saleFlag : null
                 * startTime : null
                 * endTime : null
                 * goodsRemarks : null
                 * updatePgm : null
                 */

                private Object id;
                private boolean isNewRecord;
                private Object remarks;
                private Object createDate;
                private Object updateDate;
                private Object goodsCate;
                private Object goodsType;
                private String goodsName;
                private Object goodsNo;
                private Object goodsBrief;
                private Object serviceTime;
                private Object goodsDetails;
                private Object goodsThumb;
                private Object goodsPic;
                private Object goodsShow;
                private Object goodsTab;
                private Object goodsStorage;
                private Object goodsPrice;
                private Object offlinePrice;
                private Object salesPrice;
                private Object promotionPrice;
                private Object goodsActivity;
                private Object shopId;
                private Object saleFlag;
                private Object startTime;
                private Object endTime;
                private Object goodsRemarks;
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

                public Object getGoodsCate() {
                    return goodsCate;
                }

                public void setGoodsCate(Object goodsCate) {
                    this.goodsCate = goodsCate;
                }

                public Object getGoodsType() {
                    return goodsType;
                }

                public void setGoodsType(Object goodsType) {
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

                public Object getGoodsBrief() {
                    return goodsBrief;
                }

                public void setGoodsBrief(Object goodsBrief) {
                    this.goodsBrief = goodsBrief;
                }

                public Object getServiceTime() {
                    return serviceTime;
                }

                public void setServiceTime(Object serviceTime) {
                    this.serviceTime = serviceTime;
                }

                public Object getGoodsDetails() {
                    return goodsDetails;
                }

                public void setGoodsDetails(Object goodsDetails) {
                    this.goodsDetails = goodsDetails;
                }

                public Object getGoodsThumb() {
                    return goodsThumb;
                }

                public void setGoodsThumb(Object goodsThumb) {
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

                public Object getGoodsTab() {
                    return goodsTab;
                }

                public void setGoodsTab(Object goodsTab) {
                    this.goodsTab = goodsTab;
                }

                public Object getGoodsStorage() {
                    return goodsStorage;
                }

                public void setGoodsStorage(Object goodsStorage) {
                    this.goodsStorage = goodsStorage;
                }

                public Object getGoodsPrice() {
                    return goodsPrice;
                }

                public void setGoodsPrice(Object goodsPrice) {
                    this.goodsPrice = goodsPrice;
                }

                public Object getOfflinePrice() {
                    return offlinePrice;
                }

                public void setOfflinePrice(Object offlinePrice) {
                    this.offlinePrice = offlinePrice;
                }

                public Object getSalesPrice() {
                    return salesPrice;
                }

                public void setSalesPrice(Object salesPrice) {
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

                public Object getShopId() {
                    return shopId;
                }

                public void setShopId(Object shopId) {
                    this.shopId = shopId;
                }

                public Object getSaleFlag() {
                    return saleFlag;
                }

                public void setSaleFlag(Object saleFlag) {
                    this.saleFlag = saleFlag;
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
