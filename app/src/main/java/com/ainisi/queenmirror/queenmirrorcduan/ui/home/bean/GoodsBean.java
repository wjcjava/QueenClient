package com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean;

import java.util.List;

/**
 * Created by john on 2018/5/15.
 */

public class GoodsBean {

    /**
     * success : true
     * errorCode : 0
     * msg : 获取数据成功
     * body : {"ActivityListData":[{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"ecGoodsBasic":{"id":"0b5e8db1e94b4c44b3075940bc67a2e9","isNewRecord":false,"remarks":null,"createDate":"2018-05-08 10:23:30","updateDate":"2018-05-08 10:23:30","goodsCate":"美容美体","goodsType":"0","goodsName":"测试41","goodsNo":null,"goodsBrief":"哦哦哦咯饿了","serviceTime":"90分钟","goodsDetails":null,"goodsThumb":null,"goodsPic":null,"goodsShow":null,"goodsTab":"美发定制","goodsStorage":null,"goodsPrice":"2.00","offlinePrice":"23.00","marketPrice":null,"salesPrice":null,"promotionPrice":null,"goodsActivity":"111","shopId":"111","saleFlag":"0","approveBy":null,"approveDate":null,"startTime":1525400918000,"endTime":1525400923000,"goodsRemarks":null,"updatePgm":"ApiGoodsController"},"ansShopBasic":{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"merchantId":null,"contractConfirm":null,"ifContract":null,"shopName":"美美理发店","shortName":null,"shopNo":null,"marketAssistant":null,"shopBrief":null,"shopAccounce":null,"shopActivity":null,"shopFeature":null,"queenCard":null,"shopTab":null,"shopCate":null,"industryCate":null,"belongCity":null,"addrProvince":null,"addrCity":null,"addrDistrict":null,"shopAddr":null,"openTime":null,"closeTime":null,"serviceTel":null,"shopContacts":null,"contactsTel":null,"contactsMail":null,"ifLicence":null,"shopProperty":null,"shopLegal":null,"legalIdc":null,"legalAddress":null,"taxNumber":null,"businessLicence":null,"shopCharge":null,"chargeIdc":null,"chargeIdp":null,"shopLogo":null,"shopPhoto":null,"shopEnvPhoto":null,"joinTime":null,"businessFlag":null,"enableFlag":null,"signFlag":null,"geoX":null,"geoY":null,"updatePgm":null},"ecGoodsBrowses":{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"goodsId":null,"browseCounts":"37","enableFlag":null},"goodsCateLabel":null,"goodsTypeLabel":null,"saleFlagLabel":"待提交"}]}
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
        private List<ActivityListDataBean> ActivityListData;

        public List<ActivityListDataBean> getActivityListData() {
            return ActivityListData;
        }

        public void setActivityListData(List<ActivityListDataBean> ActivityListData) {
            this.ActivityListData = ActivityListData;
        }

        public static class ActivityListDataBean {
            /**
             * id : null
             * isNewRecord : true
             * remarks : null
             * createDate : null
             * updateDate : null
             * ecGoodsBasic : {"id":"0b5e8db1e94b4c44b3075940bc67a2e9","isNewRecord":false,"remarks":null,"createDate":"2018-05-08 10:23:30","updateDate":"2018-05-08 10:23:30","goodsCate":"美容美体","goodsType":"0","goodsName":"测试41","goodsNo":null,"goodsBrief":"哦哦哦咯饿了","serviceTime":"90分钟","goodsDetails":null,"goodsThumb":null,"goodsPic":null,"goodsShow":null,"goodsTab":"美发定制","goodsStorage":null,"goodsPrice":"2.00","offlinePrice":"23.00","marketPrice":null,"salesPrice":null,"promotionPrice":null,"goodsActivity":"111","shopId":"111","saleFlag":"0","approveBy":null,"approveDate":null,"startTime":1525400918000,"endTime":1525400923000,"goodsRemarks":null,"updatePgm":"ApiGoodsController"}
             * ansShopBasic : {"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"merchantId":null,"contractConfirm":null,"ifContract":null,"shopName":"美美理发店","shortName":null,"shopNo":null,"marketAssistant":null,"shopBrief":null,"shopAccounce":null,"shopActivity":null,"shopFeature":null,"queenCard":null,"shopTab":null,"shopCate":null,"industryCate":null,"belongCity":null,"addrProvince":null,"addrCity":null,"addrDistrict":null,"shopAddr":null,"openTime":null,"closeTime":null,"serviceTel":null,"shopContacts":null,"contactsTel":null,"contactsMail":null,"ifLicence":null,"shopProperty":null,"shopLegal":null,"legalIdc":null,"legalAddress":null,"taxNumber":null,"businessLicence":null,"shopCharge":null,"chargeIdc":null,"chargeIdp":null,"shopLogo":null,"shopPhoto":null,"shopEnvPhoto":null,"joinTime":null,"businessFlag":null,"enableFlag":null,"signFlag":null,"geoX":null,"geoY":null,"updatePgm":null}
             * ecGoodsBrowses : {"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"goodsId":null,"browseCounts":"37","enableFlag":null}
             * goodsCateLabel : null
             * goodsTypeLabel : null
             * saleFlagLabel : 待提交
             */

            private Object id;
            private boolean isNewRecord;
            private Object remarks;
            private Object createDate;
            private Object updateDate;
            private EcGoodsBasicBean ecGoodsBasic;
            private AnsShopBasicBean ansShopBasic;
            private EcGoodsBrowsesBean ecGoodsBrowses;
            private Object goodsCateLabel;
            private Object goodsTypeLabel;
            private String saleFlagLabel;

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

            public String getSaleFlagLabel() {
                return saleFlagLabel;
            }

            public void setSaleFlagLabel(String saleFlagLabel) {
                this.saleFlagLabel = saleFlagLabel;
            }

            public static class EcGoodsBasicBean {
                /**
                 * id : 0b5e8db1e94b4c44b3075940bc67a2e9
                 * isNewRecord : false
                 * remarks : null
                 * createDate : 2018-05-08 10:23:30
                 * updateDate : 2018-05-08 10:23:30
                 * goodsCate : 美容美体
                 * goodsType : 0
                 * goodsName : 测试41
                 * goodsNo : null
                 * goodsBrief : 哦哦哦咯饿了
                 * serviceTime : 90分钟
                 * goodsDetails : null
                 * goodsThumb : null
                 * goodsPic : null
                 * goodsShow : null
                 * goodsTab : 美发定制
                 * goodsStorage : null
                 * goodsPrice : 2.00
                 * offlinePrice : 23.00
                 * marketPrice : null
                 * salesPrice : null
                 * promotionPrice : null
                 * goodsActivity : 111
                 * shopId : 111
                 * saleFlag : 0
                 * approveBy : null
                 * approveDate : null
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
                private Object goodsNo;
                private String goodsBrief;
                private String serviceTime;
                private Object goodsDetails;
                private Object goodsThumb;
                private Object goodsPic;
                private Object goodsShow;
                private String goodsTab;
                private Object goodsStorage;
                private String goodsPrice;
                private String offlinePrice;
                private Object marketPrice;
                private Object salesPrice;
                private Object promotionPrice;
                private String goodsActivity;
                private String shopId;
                private String saleFlag;
                private Object approveBy;
                private Object approveDate;
                private long startTime;
                private long endTime;
                private Object goodsRemarks;
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

                public Object getMarketPrice() {
                    return marketPrice;
                }

                public void setMarketPrice(Object marketPrice) {
                    this.marketPrice = marketPrice;
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

                public String getGoodsActivity() {
                    return goodsActivity;
                }

                public void setGoodsActivity(String goodsActivity) {
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

            public static class AnsShopBasicBean {
                /**
                 * id : null
                 * isNewRecord : true
                 * remarks : null
                 * createDate : null
                 * updateDate : null
                 * merchantId : null
                 * contractConfirm : null
                 * ifContract : null
                 * shopName : 美美理发店
                 * shortName : null
                 * shopNo : null
                 * marketAssistant : null
                 * shopBrief : null
                 * shopAccounce : null
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
                 */

                private Object id;
                private boolean isNewRecord;
                private Object remarks;
                private Object createDate;
                private Object updateDate;
                private Object merchantId;
                private Object contractConfirm;
                private Object ifContract;
                private String shopName;
                private Object shortName;
                private Object shopNo;
                private Object marketAssistant;
                private Object shopBrief;
                private Object shopAccounce;
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
            }

            public static class EcGoodsBrowsesBean {
                /**
                 * id : null
                 * isNewRecord : true
                 * remarks : null
                 * createDate : null
                 * updateDate : null
                 * goodsId : null
                 * browseCounts : 37
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
