package com.ainisi.queenmirror.queenmirrorcduan.bean;

public class ConfirmRefundBean {

    String orderId;
    String detailsId;
    String custId;
    String shopId;
    String goodsId;
    String refundReason;
    String refundAmount;
    String actualAmount;
    String refundDetails;
    String refundEvidence;
    String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getDetailsId() {
        return detailsId;
    }

    public void setDetailsId(String detailsId) {
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

    public String getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(String refundAmount) {
        this.refundAmount = refundAmount;
    }

    public String getActualAmount() {
        return actualAmount;
    }

    public void setActualAmount(String actualAmount) {
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
}
