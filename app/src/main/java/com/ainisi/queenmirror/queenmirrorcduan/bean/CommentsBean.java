package com.ainisi.queenmirror.queenmirrorcduan.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by john on 2018/5/11.
 */

public class CommentsBean {


    /**
     * success : true
     * errorCode : 0
     * msg : 获取数据成功
     * body : {"pageSum":7,"CommentsListData":[{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"ansOrderDetails":{"id":"dabb129dfcaf4aeca5ce586aabdc5982","isNewRecord":false,"remarks":null,"createDate":"2018-06-22 14:26:32","updateDate":"2018-06-22 14:26:32","orderId":"e220de271604419aa28fe9d260a061f7","goodsId":"9e293a8746ff4ce1b4a403a3f0086c4a","goodsName":"无痕接发","unitPrice":0.01,"purchaseNumber":1,"sumAmount":0.01,"cpAmount":null,"discountAmount":null,"usePoints":null,"afterAmount":null,"consumeQrcode":null,"detailsRemarks":null,"detailsStatus":"FN","updatePgm":"apiOrderService"},"ecAppraiseShop":{"id":"b157120e30b64392a940a74cf46864be","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"custId":"874a33f6e065437b936e5ac0f46fe278","shopId":"8def969e17984dbcb13b3751acd21c78","orderId":"e220de271604419aa28fe9d260a061f7","serviceAttitude":"3","shopEnvironment":"3","apprTime":"2018-06-22 14:45:09"},"ecAppraiseGoods":{"id":"7962682df26b4e01a82afc448c06be66","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"custId":"874a33f6e065437b936e5ac0f46fe278","shopId":"8def969e17984dbcb13b3751acd21c78","goodsId":"9e293a8746ff4ce1b4a403a3f0086c4a","detailId":"dabb129dfcaf4aeca5ce586aabdc5982","ifMatch":null,"employeeAbility":"","apprDetails":"一般一般，全国第三","apprPic":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/201806220245072618673.jpg","ifAnon":"1","apprLevel":null,"apprTime":"2018-06-22 14:45:09"},"goodsIdName":"无痕接发","custIdName":"琳","shopIdName":"友诚专业接发","detailsStatusLabel":null,"ifMatchLabel":null,"employeeAbilityLabel":null,"ifAnonLabel":null,"serviceAttitudeLabel":null,"shopEnvironmentLabel":null,"map":{"7962682df26b4e01a82afc448c06be66":[]}}]}
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
         * pageSum : 7
         * CommentsListData : [{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"ansOrderDetails":{"id":"dabb129dfcaf4aeca5ce586aabdc5982","isNewRecord":false,"remarks":null,"createDate":"2018-06-22 14:26:32","updateDate":"2018-06-22 14:26:32","orderId":"e220de271604419aa28fe9d260a061f7","goodsId":"9e293a8746ff4ce1b4a403a3f0086c4a","goodsName":"无痕接发","unitPrice":0.01,"purchaseNumber":1,"sumAmount":0.01,"cpAmount":null,"discountAmount":null,"usePoints":null,"afterAmount":null,"consumeQrcode":null,"detailsRemarks":null,"detailsStatus":"FN","updatePgm":"apiOrderService"},"ecAppraiseShop":{"id":"b157120e30b64392a940a74cf46864be","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"custId":"874a33f6e065437b936e5ac0f46fe278","shopId":"8def969e17984dbcb13b3751acd21c78","orderId":"e220de271604419aa28fe9d260a061f7","serviceAttitude":"3","shopEnvironment":"3","apprTime":"2018-06-22 14:45:09"},"ecAppraiseGoods":{"id":"7962682df26b4e01a82afc448c06be66","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"custId":"874a33f6e065437b936e5ac0f46fe278","shopId":"8def969e17984dbcb13b3751acd21c78","goodsId":"9e293a8746ff4ce1b4a403a3f0086c4a","detailId":"dabb129dfcaf4aeca5ce586aabdc5982","ifMatch":null,"employeeAbility":"","apprDetails":"一般一般，全国第三","apprPic":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/201806220245072618673.jpg","ifAnon":"1","apprLevel":null,"apprTime":"2018-06-22 14:45:09"},"goodsIdName":"无痕接发","custIdName":"琳","shopIdName":"友诚专业接发","detailsStatusLabel":null,"ifMatchLabel":null,"employeeAbilityLabel":null,"ifAnonLabel":null,"serviceAttitudeLabel":null,"shopEnvironmentLabel":null,"map":{"7962682df26b4e01a82afc448c06be66":[]}}]
         */

        private int pageSum;
        private List<CommentsListDataBean> CommentsListData;

        public int getPageSum() {
            return pageSum;
        }

        public void setPageSum(int pageSum) {
            this.pageSum = pageSum;
        }

        public List<CommentsListDataBean> getCommentsListData() {
            return CommentsListData;
        }

        public void setCommentsListData(List<CommentsListDataBean> CommentsListData) {
            this.CommentsListData = CommentsListData;
        }

        public static class CommentsListDataBean {
            /**
             * id : null
             * isNewRecord : true
             * remarks : null
             * createDate : null
             * updateDate : null
             * ansOrderDetails : {"id":"dabb129dfcaf4aeca5ce586aabdc5982","isNewRecord":false,"remarks":null,"createDate":"2018-06-22 14:26:32","updateDate":"2018-06-22 14:26:32","orderId":"e220de271604419aa28fe9d260a061f7","goodsId":"9e293a8746ff4ce1b4a403a3f0086c4a","goodsName":"无痕接发","unitPrice":0.01,"purchaseNumber":1,"sumAmount":0.01,"cpAmount":null,"discountAmount":null,"usePoints":null,"afterAmount":null,"consumeQrcode":null,"detailsRemarks":null,"detailsStatus":"FN","updatePgm":"apiOrderService"}
             * ecAppraiseShop : {"id":"b157120e30b64392a940a74cf46864be","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"custId":"874a33f6e065437b936e5ac0f46fe278","shopId":"8def969e17984dbcb13b3751acd21c78","orderId":"e220de271604419aa28fe9d260a061f7","serviceAttitude":"3","shopEnvironment":"3","apprTime":"2018-06-22 14:45:09"}
             * ecAppraiseGoods : {"id":"7962682df26b4e01a82afc448c06be66","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"custId":"874a33f6e065437b936e5ac0f46fe278","shopId":"8def969e17984dbcb13b3751acd21c78","goodsId":"9e293a8746ff4ce1b4a403a3f0086c4a","detailId":"dabb129dfcaf4aeca5ce586aabdc5982","ifMatch":null,"employeeAbility":"","apprDetails":"一般一般，全国第三","apprPic":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/201806220245072618673.jpg","ifAnon":"1","apprLevel":null,"apprTime":"2018-06-22 14:45:09"}
             * goodsIdName : 无痕接发
             * custIdName : 琳
             * shopIdName : 友诚专业接发
             * detailsStatusLabel : null
             * ifMatchLabel : null
             * employeeAbilityLabel : null
             * ifAnonLabel : null
             * serviceAttitudeLabel : null
             * shopEnvironmentLabel : null
             * map : {"7962682df26b4e01a82afc448c06be66":[]}
             */

            private Object id;
            private boolean isNewRecord;
            private Object remarks;
            private Object createDate;
            private Object updateDate;
            private AnsOrderDetailsBean ansOrderDetails;
            private EcAppraiseShopBean ecAppraiseShop;
            private EcAppraiseGoodsBean ecAppraiseGoods;
            private String goodsIdName;
            private String custIdName;
            private String headPic;
            private String shopIdName;
            private Object detailsStatusLabel;
            private Object ifMatchLabel;
            private Object employeeAbilityLabel;
            private Object ifAnonLabel;
            private Object serviceAttitudeLabel;
            private Object shopEnvironmentLabel;
            private MapBean map;

            public String getHeadPic() {
                return headPic;
            }

            public void setHeadPic(String headPic) {
                this.headPic = headPic;
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

            public AnsOrderDetailsBean getAnsOrderDetails() {
                return ansOrderDetails;
            }

            public void setAnsOrderDetails(AnsOrderDetailsBean ansOrderDetails) {
                this.ansOrderDetails = ansOrderDetails;
            }

            public EcAppraiseShopBean getEcAppraiseShop() {
                return ecAppraiseShop;
            }

            public void setEcAppraiseShop(EcAppraiseShopBean ecAppraiseShop) {
                this.ecAppraiseShop = ecAppraiseShop;
            }

            public EcAppraiseGoodsBean getEcAppraiseGoods() {
                return ecAppraiseGoods;
            }

            public void setEcAppraiseGoods(EcAppraiseGoodsBean ecAppraiseGoods) {
                this.ecAppraiseGoods = ecAppraiseGoods;
            }

            public String getGoodsIdName() {
                return goodsIdName;
            }

            public void setGoodsIdName(String goodsIdName) {
                this.goodsIdName = goodsIdName;
            }

            public String getCustIdName() {
                return custIdName;
            }

            public void setCustIdName(String custIdName) {
                this.custIdName = custIdName;
            }

            public String getShopIdName() {
                return shopIdName;
            }

            public void setShopIdName(String shopIdName) {
                this.shopIdName = shopIdName;
            }

            public Object getDetailsStatusLabel() {
                return detailsStatusLabel;
            }

            public void setDetailsStatusLabel(Object detailsStatusLabel) {
                this.detailsStatusLabel = detailsStatusLabel;
            }

            public Object getIfMatchLabel() {
                return ifMatchLabel;
            }

            public void setIfMatchLabel(Object ifMatchLabel) {
                this.ifMatchLabel = ifMatchLabel;
            }

            public Object getEmployeeAbilityLabel() {
                return employeeAbilityLabel;
            }

            public void setEmployeeAbilityLabel(Object employeeAbilityLabel) {
                this.employeeAbilityLabel = employeeAbilityLabel;
            }

            public Object getIfAnonLabel() {
                return ifAnonLabel;
            }

            public void setIfAnonLabel(Object ifAnonLabel) {
                this.ifAnonLabel = ifAnonLabel;
            }

            public Object getServiceAttitudeLabel() {
                return serviceAttitudeLabel;
            }

            public void setServiceAttitudeLabel(Object serviceAttitudeLabel) {
                this.serviceAttitudeLabel = serviceAttitudeLabel;
            }

            public Object getShopEnvironmentLabel() {
                return shopEnvironmentLabel;
            }

            public void setShopEnvironmentLabel(Object shopEnvironmentLabel) {
                this.shopEnvironmentLabel = shopEnvironmentLabel;
            }

            public MapBean getMap() {
                return map;
            }

            public void setMap(MapBean map) {
                this.map = map;
            }

            public static class AnsOrderDetailsBean {
                /**
                 * id : dabb129dfcaf4aeca5ce586aabdc5982
                 * isNewRecord : false
                 * remarks : null
                 * createDate : 2018-06-22 14:26:32
                 * updateDate : 2018-06-22 14:26:32
                 * orderId : e220de271604419aa28fe9d260a061f7
                 * goodsId : 9e293a8746ff4ce1b4a403a3f0086c4a
                 * goodsName : 无痕接发
                 * unitPrice : 0.01
                 * purchaseNumber : 1
                 * sumAmount : 0.01
                 * cpAmount : null
                 * discountAmount : null
                 * usePoints : null
                 * afterAmount : null
                 * consumeQrcode : null
                 * detailsRemarks : null
                 * detailsStatus : FN
                 * updatePgm : apiOrderService
                 */

                private String id;
                private boolean isNewRecord;
                private Object remarks;
                private String createDate;
                private String updateDate;
                private String orderId;
                private String goodsId;
                private String goodsName;
                private double unitPrice;
                private int purchaseNumber;
                private double sumAmount;
                private Object cpAmount;
                private Object discountAmount;
                private Object usePoints;
                private Object afterAmount;
                private Object consumeQrcode;
                private Object detailsRemarks;
                private String detailsStatus;
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

                public String getOrderId() {
                    return orderId;
                }

                public void setOrderId(String orderId) {
                    this.orderId = orderId;
                }

                public String getGoodsId() {
                    return goodsId;
                }

                public void setGoodsId(String goodsId) {
                    this.goodsId = goodsId;
                }

                public String getGoodsName() {
                    return goodsName;
                }

                public void setGoodsName(String goodsName) {
                    this.goodsName = goodsName;
                }

                public double getUnitPrice() {
                    return unitPrice;
                }

                public void setUnitPrice(double unitPrice) {
                    this.unitPrice = unitPrice;
                }

                public int getPurchaseNumber() {
                    return purchaseNumber;
                }

                public void setPurchaseNumber(int purchaseNumber) {
                    this.purchaseNumber = purchaseNumber;
                }

                public double getSumAmount() {
                    return sumAmount;
                }

                public void setSumAmount(double sumAmount) {
                    this.sumAmount = sumAmount;
                }

                public Object getCpAmount() {
                    return cpAmount;
                }

                public void setCpAmount(Object cpAmount) {
                    this.cpAmount = cpAmount;
                }

                public Object getDiscountAmount() {
                    return discountAmount;
                }

                public void setDiscountAmount(Object discountAmount) {
                    this.discountAmount = discountAmount;
                }

                public Object getUsePoints() {
                    return usePoints;
                }

                public void setUsePoints(Object usePoints) {
                    this.usePoints = usePoints;
                }

                public Object getAfterAmount() {
                    return afterAmount;
                }

                public void setAfterAmount(Object afterAmount) {
                    this.afterAmount = afterAmount;
                }

                public Object getConsumeQrcode() {
                    return consumeQrcode;
                }

                public void setConsumeQrcode(Object consumeQrcode) {
                    this.consumeQrcode = consumeQrcode;
                }

                public Object getDetailsRemarks() {
                    return detailsRemarks;
                }

                public void setDetailsRemarks(Object detailsRemarks) {
                    this.detailsRemarks = detailsRemarks;
                }

                public String getDetailsStatus() {
                    return detailsStatus;
                }

                public void setDetailsStatus(String detailsStatus) {
                    this.detailsStatus = detailsStatus;
                }

                public String getUpdatePgm() {
                    return updatePgm;
                }

                public void setUpdatePgm(String updatePgm) {
                    this.updatePgm = updatePgm;
                }
            }

            public static class EcAppraiseShopBean {
                /**
                 * id : b157120e30b64392a940a74cf46864be
                 * isNewRecord : false
                 * remarks : null
                 * createDate : null
                 * updateDate : null
                 * custId : 874a33f6e065437b936e5ac0f46fe278
                 * shopId : 8def969e17984dbcb13b3751acd21c78
                 * orderId : e220de271604419aa28fe9d260a061f7
                 * serviceAttitude : 3
                 * shopEnvironment : 3
                 * apprTime : 2018-06-22 14:45:09
                 */

                private String id;
                private boolean isNewRecord;
                private Object remarks;
                private Object createDate;
                private Object updateDate;
                private String custId;
                private String shopId;
                private String orderId;
                private String serviceAttitude;
                private String shopEnvironment;
                private String apprTime;

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

                public String getOrderId() {
                    return orderId;
                }

                public void setOrderId(String orderId) {
                    this.orderId = orderId;
                }

                public String getServiceAttitude() {
                    return serviceAttitude;
                }

                public void setServiceAttitude(String serviceAttitude) {
                    this.serviceAttitude = serviceAttitude;
                }

                public String getShopEnvironment() {
                    return shopEnvironment;
                }

                public void setShopEnvironment(String shopEnvironment) {
                    this.shopEnvironment = shopEnvironment;
                }

                public String getApprTime() {
                    return apprTime;
                }

                public void setApprTime(String apprTime) {
                    this.apprTime = apprTime;
                }
            }

            public static class EcAppraiseGoodsBean {
                /**
                 * id : 7962682df26b4e01a82afc448c06be66
                 * isNewRecord : false
                 * remarks : null
                 * createDate : null
                 * updateDate : null
                 * custId : 874a33f6e065437b936e5ac0f46fe278
                 * shopId : 8def969e17984dbcb13b3751acd21c78
                 * goodsId : 9e293a8746ff4ce1b4a403a3f0086c4a
                 * detailId : dabb129dfcaf4aeca5ce586aabdc5982
                 * ifMatch : null
                 * employeeAbility :
                 * apprDetails : 一般一般，全国第三
                 * apprPic : https://nwptest.oss-cn-hangzhou.aliyuncs.com/201806220245072618673.jpg
                 * ifAnon : 1
                 * apprLevel : null
                 * apprTime : 2018-06-22 14:45:09
                 */

                private String id;
                private boolean isNewRecord;
                private Object remarks;
                private Object createDate;
                private Object updateDate;
                private String custId;
                private String shopId;
                private String goodsId;
                private String detailId;
                private Object ifMatch;
                private String employeeAbility;
                private String apprDetails;
                private String apprPic;
                private String ifAnon;
                private String apprLevel;
                private String apprTime;

                public boolean isNewRecord() {
                    return isNewRecord;
                }

                public void setNewRecord(boolean newRecord) {
                    isNewRecord = newRecord;
                }

                public String getApprLevel() {
                    return apprLevel;
                }

                public void setApprLevel(String apprLevel) {
                    this.apprLevel = apprLevel;
                }

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

                public String getDetailId() {
                    return detailId;
                }

                public void setDetailId(String detailId) {
                    this.detailId = detailId;
                }

                public Object getIfMatch() {
                    return ifMatch;
                }

                public void setIfMatch(Object ifMatch) {
                    this.ifMatch = ifMatch;
                }

                public String getEmployeeAbility() {
                    return employeeAbility;
                }

                public void setEmployeeAbility(String employeeAbility) {
                    this.employeeAbility = employeeAbility;
                }

                public String getApprDetails() {
                    return apprDetails;
                }

                public void setApprDetails(String apprDetails) {
                    this.apprDetails = apprDetails;
                }

                public String getApprPic() {
                    return apprPic;
                }

                public void setApprPic(String apprPic) {
                    this.apprPic = apprPic;
                }

                public String getIfAnon() {
                    return ifAnon;
                }

                public void setIfAnon(String ifAnon) {
                    this.ifAnon = ifAnon;
                }

                public String getApprTime() {
                    return apprTime;
                }

                public void setApprTime(String apprTime) {
                    this.apprTime = apprTime;
                }
            }

            public static class MapBean {
                @SerializedName("7962682df26b4e01a82afc448c06be66")
                private List<?> _$7962682df26b4e01a82afc448c06be66;

                public List<?> get_$7962682df26b4e01a82afc448c06be66() {
                    return _$7962682df26b4e01a82afc448c06be66;
                }

                public void set_$7962682df26b4e01a82afc448c06be66(List<?> _$7962682df26b4e01a82afc448c06be66) {
                    this._$7962682df26b4e01a82afc448c06be66 = _$7962682df26b4e01a82afc448c06be66;
                }
            }
        }
    }
}
