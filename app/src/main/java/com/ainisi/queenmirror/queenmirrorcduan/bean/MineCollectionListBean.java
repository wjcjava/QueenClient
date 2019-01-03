package com.ainisi.queenmirror.queenmirrorcduan.bean;

import java.util.List;

public class MineCollectionListBean {


    /**
     * success : true
     * errorCode : 0
     * msg : 获取数据成功
     * body : {"CollectListData":[{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"ansCustCollection":{"id":"1c154df4c65543d69886d26afae60cde","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"custId":"f5756af5bd3b4c0b83e73f4645a634a7","goodId":"6f2febe505a349d1b0f5b652c03f55af","collectTime":"2018-06-30 10:24:32"},"ecGoodsBasic":{"id":"6f2febe505a349d1b0f5b652c03f55af","isNewRecord":false,"remarks":null,"createDate":"2018-06-29 16:30:11","updateDate":"2018-06-29 16:30:16","startDate":null,"endDate":null,"goodsCate":"575a4f781e48405f860f0dc7a7be4b79","goodsType":"2","goodsName":"猪肉炖粉条","goodsNo":"10bdf42b2","goodsBrief":"东北特色菜","goodsSort":0,"serviceTime":"50","goodsDetails":null,"goodsThumb":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062904293636327568.jpg","goodsPic":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062904300842542580.jpg,https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062904300842814196.jpg,https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062904300843088841.jpg,https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062904300843247147.jpg,https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062904300843391457.jpg,","goodsShow":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062904293636327568.jpg,https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062904293636521268.jpg,","goodsTab":"美甲,","goodsStorage":0,"marketPrice":0,"salesPrice":0.01,"goodsActivity":null,"goodsBanner":null,"shopId":"97f6494cad0f4c8e9c0dfb62d1f9f50a","saleFlag":"2","ifPoint":null,"pointRule":null,"approveBy":null,"approveDate":null,"approveRemarks":null,"startTime":null,"endTime":null,"goodsRemarks":null,"updatePgm":"ApiGoodsController","shopName":null,"saleFlagName":null,"goodsTypeName":null,"goodsCateName":null,"ecPointsRule":null,"buyRule":null},"ansShopBasic":{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"merchantId":null,"contractConfirm":null,"ifContract":null,"shopName":"姜超的店铺","shortName":null,"shopNo":null,"marketAssistant":null,"shopBrief":null,"shopAccounce":null,"ifNew":null,"shopBanner":null,"shopActivity":null,"shopFeature":null,"queenCard":null,"shopTab":null,"shopCate":null,"industryCate":null,"belongCity":null,"addrProvince":null,"addrCity":null,"addrDistrict":null,"shopAddr":null,"openTime":null,"closeTime":null,"serviceTel":null,"shopContacts":null,"contactsTel":null,"contactsMail":null,"ifLicence":null,"shopProperty":null,"shopLegal":null,"legalIdc":null,"legalIdp":null,"legalProvince":null,"legalCity":null,"legalDistrict":null,"legalAddress":null,"taxNumber":null,"businessLicence":null,"shopCharge":null,"chargeIdc":null,"chargeIdp":null,"shopLogo":null,"shopPhoto":null,"shopEnvPhoto":null,"joinTime":null,"businessFlag":null,"enableFlag":null,"signFlag":null,"geoX":null,"geoY":null,"updatePgm":null,"belongCityName":null,"apiAnsCustCartList":null,"goodsCounts":0,"approveBy":null,"openFee":0,"serviceFee":0,"servicePeriod":null,"signStart":null,"signEnd":null,"signStartDate":null,"signEndDate":null,"ansSnsType":null,"snsId":null,"snsName":null,"serviceAgreement":null,"adAgreement":null,"otherAgreement":null,"unionBeginTime":null,"unionEndTime":null},"ecGoodsBrowses":{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"goodsId":null,"browseCounts":8,"enableFlag":null},"custIdName":"13405024815","goodsIdName":"猪肉炖粉条","goodsCateLabel":null,"goodsTypeLabel":null,"saleFlagLabel":null},{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"ansCustCollection":{"id":"e61ab832e2a74aca855b56f472f825ee","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"custId":"f5756af5bd3b4c0b83e73f4645a634a7","goodId":"ae75403df84e42cca57c1b19bf6a8fea","collectTime":"2018-07-02 16:05:54"},"ecGoodsBasic":{"id":"ae75403df84e42cca57c1b19bf6a8fea","isNewRecord":false,"remarks":null,"createDate":"2018-06-28 16:49:29","updateDate":"2018-06-28 16:49:45","startDate":null,"endDate":null,"goodsCate":"27a7d133a8f94cb9b9bce03365cf6a48","goodsType":"2","goodsName":"贾氏辣条","goodsNo":"4652f72e","goodsBrief":"情况特别好。我特别喜欢","goodsSort":0,"serviceTime":"60","goodsDetails":null,"goodsThumb":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062804491517025447.jpg","goodsPic":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062804492457812990.jpg,https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062804492458052295.jpg,https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062804492458111279.jpg,https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062804492458213436.jpg,https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062804492458498213.jpg,","goodsShow":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062804491517025447.jpg,https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062804491517280265.jpg,https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062804491517311198.jpg,https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062804491517412498.jpg,https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062804491517592770.jpg,","goodsTab":"美甲,","goodsStorage":0,"marketPrice":0,"salesPrice":0.01,"goodsActivity":null,"goodsBanner":null,"shopId":"b4129d89efa44d069c656b26fec16499","saleFlag":"2","ifPoint":null,"pointRule":null,"approveBy":null,"approveDate":null,"approveRemarks":null,"startTime":null,"endTime":null,"goodsRemarks":null,"updatePgm":"ApiGoodsController","shopName":null,"saleFlagName":null,"goodsTypeName":null,"goodsCateName":null,"ecPointsRule":null,"buyRule":null},"ansShopBasic":{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"merchantId":null,"contractConfirm":null,"ifContract":null,"shopName":"贾氏集团","shortName":null,"shopNo":null,"marketAssistant":null,"shopBrief":null,"shopAccounce":null,"ifNew":null,"shopBanner":null,"shopActivity":null,"shopFeature":null,"queenCard":null,"shopTab":null,"shopCate":null,"industryCate":null,"belongCity":null,"addrProvince":null,"addrCity":null,"addrDistrict":null,"shopAddr":null,"openTime":null,"closeTime":null,"serviceTel":null,"shopContacts":null,"contactsTel":null,"contactsMail":null,"ifLicence":null,"shopProperty":null,"shopLegal":null,"legalIdc":null,"legalIdp":null,"legalProvince":null,"legalCity":null,"legalDistrict":null,"legalAddress":null,"taxNumber":null,"businessLicence":null,"shopCharge":null,"chargeIdc":null,"chargeIdp":null,"shopLogo":null,"shopPhoto":null,"shopEnvPhoto":null,"joinTime":null,"businessFlag":null,"enableFlag":null,"signFlag":null,"geoX":null,"geoY":null,"updatePgm":null,"belongCityName":null,"apiAnsCustCartList":null,"goodsCounts":0,"approveBy":null,"openFee":0,"serviceFee":0,"servicePeriod":null,"signStart":null,"signEnd":null,"signStartDate":null,"signEndDate":null,"ansSnsType":null,"snsId":null,"snsName":null,"serviceAgreement":null,"adAgreement":null,"otherAgreement":null,"unionBeginTime":null,"unionEndTime":null},"ecGoodsBrowses":{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"goodsId":null,"browseCounts":7,"enableFlag":null},"custIdName":"13405024815","goodsIdName":"贾氏辣条","goodsCateLabel":null,"goodsTypeLabel":null,"saleFlagLabel":null}],"pageSum":2}
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
         * CollectListData : [{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"ansCustCollection":{"id":"1c154df4c65543d69886d26afae60cde","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"custId":"f5756af5bd3b4c0b83e73f4645a634a7","goodId":"6f2febe505a349d1b0f5b652c03f55af","collectTime":"2018-06-30 10:24:32"},"ecGoodsBasic":{"id":"6f2febe505a349d1b0f5b652c03f55af","isNewRecord":false,"remarks":null,"createDate":"2018-06-29 16:30:11","updateDate":"2018-06-29 16:30:16","startDate":null,"endDate":null,"goodsCate":"575a4f781e48405f860f0dc7a7be4b79","goodsType":"2","goodsName":"猪肉炖粉条","goodsNo":"10bdf42b2","goodsBrief":"东北特色菜","goodsSort":0,"serviceTime":"50","goodsDetails":null,"goodsThumb":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062904293636327568.jpg","goodsPic":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062904300842542580.jpg,https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062904300842814196.jpg,https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062904300843088841.jpg,https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062904300843247147.jpg,https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062904300843391457.jpg,","goodsShow":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062904293636327568.jpg,https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062904293636521268.jpg,","goodsTab":"美甲,","goodsStorage":0,"marketPrice":0,"salesPrice":0.01,"goodsActivity":null,"goodsBanner":null,"shopId":"97f6494cad0f4c8e9c0dfb62d1f9f50a","saleFlag":"2","ifPoint":null,"pointRule":null,"approveBy":null,"approveDate":null,"approveRemarks":null,"startTime":null,"endTime":null,"goodsRemarks":null,"updatePgm":"ApiGoodsController","shopName":null,"saleFlagName":null,"goodsTypeName":null,"goodsCateName":null,"ecPointsRule":null,"buyRule":null},"ansShopBasic":{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"merchantId":null,"contractConfirm":null,"ifContract":null,"shopName":"姜超的店铺","shortName":null,"shopNo":null,"marketAssistant":null,"shopBrief":null,"shopAccounce":null,"ifNew":null,"shopBanner":null,"shopActivity":null,"shopFeature":null,"queenCard":null,"shopTab":null,"shopCate":null,"industryCate":null,"belongCity":null,"addrProvince":null,"addrCity":null,"addrDistrict":null,"shopAddr":null,"openTime":null,"closeTime":null,"serviceTel":null,"shopContacts":null,"contactsTel":null,"contactsMail":null,"ifLicence":null,"shopProperty":null,"shopLegal":null,"legalIdc":null,"legalIdp":null,"legalProvince":null,"legalCity":null,"legalDistrict":null,"legalAddress":null,"taxNumber":null,"businessLicence":null,"shopCharge":null,"chargeIdc":null,"chargeIdp":null,"shopLogo":null,"shopPhoto":null,"shopEnvPhoto":null,"joinTime":null,"businessFlag":null,"enableFlag":null,"signFlag":null,"geoX":null,"geoY":null,"updatePgm":null,"belongCityName":null,"apiAnsCustCartList":null,"goodsCounts":0,"approveBy":null,"openFee":0,"serviceFee":0,"servicePeriod":null,"signStart":null,"signEnd":null,"signStartDate":null,"signEndDate":null,"ansSnsType":null,"snsId":null,"snsName":null,"serviceAgreement":null,"adAgreement":null,"otherAgreement":null,"unionBeginTime":null,"unionEndTime":null},"ecGoodsBrowses":{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"goodsId":null,"browseCounts":8,"enableFlag":null},"custIdName":"13405024815","goodsIdName":"猪肉炖粉条","goodsCateLabel":null,"goodsTypeLabel":null,"saleFlagLabel":null},{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"ansCustCollection":{"id":"e61ab832e2a74aca855b56f472f825ee","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"custId":"f5756af5bd3b4c0b83e73f4645a634a7","goodId":"ae75403df84e42cca57c1b19bf6a8fea","collectTime":"2018-07-02 16:05:54"},"ecGoodsBasic":{"id":"ae75403df84e42cca57c1b19bf6a8fea","isNewRecord":false,"remarks":null,"createDate":"2018-06-28 16:49:29","updateDate":"2018-06-28 16:49:45","startDate":null,"endDate":null,"goodsCate":"27a7d133a8f94cb9b9bce03365cf6a48","goodsType":"2","goodsName":"贾氏辣条","goodsNo":"4652f72e","goodsBrief":"情况特别好。我特别喜欢","goodsSort":0,"serviceTime":"60","goodsDetails":null,"goodsThumb":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062804491517025447.jpg","goodsPic":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062804492457812990.jpg,https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062804492458052295.jpg,https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062804492458111279.jpg,https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062804492458213436.jpg,https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062804492458498213.jpg,","goodsShow":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062804491517025447.jpg,https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062804491517280265.jpg,https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062804491517311198.jpg,https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062804491517412498.jpg,https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062804491517592770.jpg,","goodsTab":"美甲,","goodsStorage":0,"marketPrice":0,"salesPrice":0.01,"goodsActivity":null,"goodsBanner":null,"shopId":"b4129d89efa44d069c656b26fec16499","saleFlag":"2","ifPoint":null,"pointRule":null,"approveBy":null,"approveDate":null,"approveRemarks":null,"startTime":null,"endTime":null,"goodsRemarks":null,"updatePgm":"ApiGoodsController","shopName":null,"saleFlagName":null,"goodsTypeName":null,"goodsCateName":null,"ecPointsRule":null,"buyRule":null},"ansShopBasic":{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"merchantId":null,"contractConfirm":null,"ifContract":null,"shopName":"贾氏集团","shortName":null,"shopNo":null,"marketAssistant":null,"shopBrief":null,"shopAccounce":null,"ifNew":null,"shopBanner":null,"shopActivity":null,"shopFeature":null,"queenCard":null,"shopTab":null,"shopCate":null,"industryCate":null,"belongCity":null,"addrProvince":null,"addrCity":null,"addrDistrict":null,"shopAddr":null,"openTime":null,"closeTime":null,"serviceTel":null,"shopContacts":null,"contactsTel":null,"contactsMail":null,"ifLicence":null,"shopProperty":null,"shopLegal":null,"legalIdc":null,"legalIdp":null,"legalProvince":null,"legalCity":null,"legalDistrict":null,"legalAddress":null,"taxNumber":null,"businessLicence":null,"shopCharge":null,"chargeIdc":null,"chargeIdp":null,"shopLogo":null,"shopPhoto":null,"shopEnvPhoto":null,"joinTime":null,"businessFlag":null,"enableFlag":null,"signFlag":null,"geoX":null,"geoY":null,"updatePgm":null,"belongCityName":null,"apiAnsCustCartList":null,"goodsCounts":0,"approveBy":null,"openFee":0,"serviceFee":0,"servicePeriod":null,"signStart":null,"signEnd":null,"signStartDate":null,"signEndDate":null,"ansSnsType":null,"snsId":null,"snsName":null,"serviceAgreement":null,"adAgreement":null,"otherAgreement":null,"unionBeginTime":null,"unionEndTime":null},"ecGoodsBrowses":{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"goodsId":null,"browseCounts":7,"enableFlag":null},"custIdName":"13405024815","goodsIdName":"贾氏辣条","goodsCateLabel":null,"goodsTypeLabel":null,"saleFlagLabel":null}]
         * pageSum : 2
         */

        private int pageSum;
        private List<CollectListDataBean> CollectListData;

        public int getPageSum() {
            return pageSum;
        }

        public void setPageSum(int pageSum) {
            this.pageSum = pageSum;
        }

        public List<CollectListDataBean> getCollectListData() {
            return CollectListData;
        }

        public void setCollectListData(List<CollectListDataBean> CollectListData) {
            this.CollectListData = CollectListData;
        }

        public static class CollectListDataBean {
            /**
             * id : null
             * isNewRecord : true
             * remarks : null
             * createDate : null
             * updateDate : null
             * startDate : null
             * endDate : null
             * ansCustCollection : {"id":"1c154df4c65543d69886d26afae60cde","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"custId":"f5756af5bd3b4c0b83e73f4645a634a7","goodId":"6f2febe505a349d1b0f5b652c03f55af","collectTime":"2018-06-30 10:24:32"}
             * ecGoodsBasic : {"id":"6f2febe505a349d1b0f5b652c03f55af","isNewRecord":false,"remarks":null,"createDate":"2018-06-29 16:30:11","updateDate":"2018-06-29 16:30:16","startDate":null,"endDate":null,"goodsCate":"575a4f781e48405f860f0dc7a7be4b79","goodsType":"2","goodsName":"猪肉炖粉条","goodsNo":"10bdf42b2","goodsBrief":"东北特色菜","goodsSort":0,"serviceTime":"50","goodsDetails":null,"goodsThumb":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062904293636327568.jpg","goodsPic":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062904300842542580.jpg,https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062904300842814196.jpg,https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062904300843088841.jpg,https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062904300843247147.jpg,https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062904300843391457.jpg,","goodsShow":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062904293636327568.jpg,https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062904293636521268.jpg,","goodsTab":"美甲,","goodsStorage":0,"marketPrice":0,"salesPrice":0.01,"goodsActivity":null,"goodsBanner":null,"shopId":"97f6494cad0f4c8e9c0dfb62d1f9f50a","saleFlag":"2","ifPoint":null,"pointRule":null,"approveBy":null,"approveDate":null,"approveRemarks":null,"startTime":null,"endTime":null,"goodsRemarks":null,"updatePgm":"ApiGoodsController","shopName":null,"saleFlagName":null,"goodsTypeName":null,"goodsCateName":null,"ecPointsRule":null,"buyRule":null}
             * ansShopBasic : {"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"merchantId":null,"contractConfirm":null,"ifContract":null,"shopName":"姜超的店铺","shortName":null,"shopNo":null,"marketAssistant":null,"shopBrief":null,"shopAccounce":null,"ifNew":null,"shopBanner":null,"shopActivity":null,"shopFeature":null,"queenCard":null,"shopTab":null,"shopCate":null,"industryCate":null,"belongCity":null,"addrProvince":null,"addrCity":null,"addrDistrict":null,"shopAddr":null,"openTime":null,"closeTime":null,"serviceTel":null,"shopContacts":null,"contactsTel":null,"contactsMail":null,"ifLicence":null,"shopProperty":null,"shopLegal":null,"legalIdc":null,"legalIdp":null,"legalProvince":null,"legalCity":null,"legalDistrict":null,"legalAddress":null,"taxNumber":null,"businessLicence":null,"shopCharge":null,"chargeIdc":null,"chargeIdp":null,"shopLogo":null,"shopPhoto":null,"shopEnvPhoto":null,"joinTime":null,"businessFlag":null,"enableFlag":null,"signFlag":null,"geoX":null,"geoY":null,"updatePgm":null,"belongCityName":null,"apiAnsCustCartList":null,"goodsCounts":0,"approveBy":null,"openFee":0,"serviceFee":0,"servicePeriod":null,"signStart":null,"signEnd":null,"signStartDate":null,"signEndDate":null,"ansSnsType":null,"snsId":null,"snsName":null,"serviceAgreement":null,"adAgreement":null,"otherAgreement":null,"unionBeginTime":null,"unionEndTime":null}
             * ecGoodsBrowses : {"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"goodsId":null,"browseCounts":8,"enableFlag":null}
             * custIdName : 13405024815
             * goodsIdName : 猪肉炖粉条
             * goodsCateLabel : null
             * goodsTypeLabel : null
             * saleFlagLabel : null
             */

            private Object id;
            private boolean isNewRecord;
            private Object remarks;
            private Object createDate;
            private Object updateDate;
            private Object startDate;
            private Object endDate;
            private AnsCustCollectionBean ansCustCollection;
            private EcGoodsBasicBean ecGoodsBasic;
            private AnsShopBasicBean ansShopBasic;
            private EcGoodsBrowsesBean ecGoodsBrowses;
            private String custIdName;
            private String goodsIdName;
            private Object goodsCateLabel;
            private Object goodsTypeLabel;
            private Object saleFlagLabel;

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

            public AnsCustCollectionBean getAnsCustCollection() {
                return ansCustCollection;
            }

            public void setAnsCustCollection(AnsCustCollectionBean ansCustCollection) {
                this.ansCustCollection = ansCustCollection;
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

            public String getCustIdName() {
                return custIdName;
            }

            public void setCustIdName(String custIdName) {
                this.custIdName = custIdName;
            }

            public String getGoodsIdName() {
                return goodsIdName;
            }

            public void setGoodsIdName(String goodsIdName) {
                this.goodsIdName = goodsIdName;
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

            public static class AnsCustCollectionBean {
                /**
                 * id : 1c154df4c65543d69886d26afae60cde
                 * isNewRecord : false
                 * remarks : null
                 * createDate : null
                 * updateDate : null
                 * startDate : null
                 * endDate : null
                 * custId : f5756af5bd3b4c0b83e73f4645a634a7
                 * goodId : 6f2febe505a349d1b0f5b652c03f55af
                 * collectTime : 2018-06-30 10:24:32
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
                private String collectTime;

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

                public String getCollectTime() {
                    return collectTime;
                }

                public void setCollectTime(String collectTime) {
                    this.collectTime = collectTime;
                }
            }

            public static class EcGoodsBasicBean {
                /**
                 * id : 6f2febe505a349d1b0f5b652c03f55af
                 * isNewRecord : false
                 * remarks : null
                 * createDate : 2018-06-29 16:30:11
                 * updateDate : 2018-06-29 16:30:16
                 * startDate : null
                 * endDate : null
                 * goodsCate : 575a4f781e48405f860f0dc7a7be4b79
                 * goodsType : 2
                 * goodsName : 猪肉炖粉条
                 * goodsNo : 10bdf42b2
                 * goodsBrief : 东北特色菜
                 * goodsSort : 0
                 * serviceTime : 50
                 * goodsDetails : null
                 * goodsThumb : https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062904293636327568.jpg
                 * goodsPic : https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062904300842542580.jpg,https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062904300842814196.jpg,https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062904300843088841.jpg,https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062904300843247147.jpg,https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062904300843391457.jpg,
                 * goodsShow : https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062904293636327568.jpg,https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062904293636521268.jpg,
                 * goodsTab : 美甲,
                 * goodsStorage : 0
                 * marketPrice : 0
                 * salesPrice : 0.01
                 * goodsActivity : null
                 * goodsBanner : null
                 * shopId : 97f6494cad0f4c8e9c0dfb62d1f9f50a
                 * saleFlag : 2
                 * ifPoint : null
                 * pointRule : null
                 * approveBy : null
                 * approveDate : null
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
                private String goodsTab;
                private int goodsStorage;
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
                 * shopName : 姜超的店铺
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
                 * browseCounts : 8
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
