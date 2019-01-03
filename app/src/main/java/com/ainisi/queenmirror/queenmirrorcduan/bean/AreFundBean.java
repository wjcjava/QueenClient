package com.ainisi.queenmirror.queenmirrorcduan.bean;

import java.io.Serializable;

public class AreFundBean implements Serializable{

    /**
     * id : null
     * isNewRecord : true
     * remarks : null
     * createDate : null
     * updateDate : null
     * intfAnsOrderDetails : {"goodsId":"444","goodsName":"美容美发","unitPrice":"111.00","purchaseNumber":"4","sumAmount":"444.00","cpAmount":null,"afterAmount":null}
     * ansOrderDetails : null
     * ecGoodsBasic : null
     * ansShopBasic : null
     * detailsStatusLabel : null
     */

    private IntfAnsOrderDetailsBean intfAnsOrderDetails;

    private boolean isCheck;

    public boolean isCheck() {
        return isCheck;
    }
    public void setCheck(boolean check) {
        isCheck = check;
    }
    public IntfAnsOrderDetailsBean getIntfAnsOrderDetails() {
        return intfAnsOrderDetails;
    }
    public void setIntfAnsOrderDetails(IntfAnsOrderDetailsBean intfAnsOrderDetails) {
        this.intfAnsOrderDetails = intfAnsOrderDetails;
    }

    public static class IntfAnsOrderDetailsBean implements Serializable{
        /**
         * goodsId : 444
         * goodsName : 美容美发
         * unitPrice : 111.00
         * purchaseNumber : 4
         * sumAmount : 444.00
         * cpAmount : null
         * afterAmount : null
         */
        private String id;
        private String goodsId;
        private String goodsName;
        private String unitPrice;
        private String purchaseNumber;
        private String sumAmount;
        private String cpAmount;
        private String afterAmount;
        private String goodsThumb;

        public String getGoodsThumb() {
            return goodsThumb;
        }

        public void setGoodsThumb(String goodsThumb) {
            this.goodsThumb = goodsThumb;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getCpAmount() {
            return cpAmount;
        }

        public void setCpAmount(String cpAmount) {
            this.cpAmount = cpAmount;
        }

        public String getAfterAmount() {
            return afterAmount;
        }

        public void setAfterAmount(String afterAmount) {
            this.afterAmount = afterAmount;
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

        public String getSumAmount() {
            return sumAmount;
        }

        public void setSumAmount(String sumAmount) {
            this.sumAmount = sumAmount;
        }

    }
}
