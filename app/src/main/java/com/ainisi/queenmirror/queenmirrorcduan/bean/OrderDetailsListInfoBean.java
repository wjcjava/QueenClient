package com.ainisi.queenmirror.queenmirrorcduan.bean;

public class OrderDetailsListInfoBean {

    String goodsId;
    String purchaseNumber;
    String unitPrice;
    String sumAmount;
    String discountAmount;
    String usePoints;

    public String getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(String discountAmount) {
        this.discountAmount = discountAmount;
    }

    public String getUsePoints() {
        return usePoints;
    }

    public void setUsePoints(String usePoints) {
        this.usePoints = usePoints;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getPurchaseNumber() {
        return purchaseNumber;
    }

    public void setPurchaseNumber(String purchaseNumber) {
        this.purchaseNumber = purchaseNumber;
    }

    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getSumAmount() {
        return sumAmount;
    }

    public void setSumAmount(String sumAmount) {
        this.sumAmount = sumAmount;
    }
}
