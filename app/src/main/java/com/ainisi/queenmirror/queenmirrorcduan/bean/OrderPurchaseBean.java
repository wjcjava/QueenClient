package com.ainisi.queenmirror.queenmirrorcduan.bean;

import java.util.List;

public class OrderPurchaseBean {

    String shopId;
    String cpId;
    String cpMethod;
    String cartIds;
    List<OrderDetailsListInfoBean> orderDetailsListInfo;

    public String getCpId() {
        return cpId;
    }

    public void setCpId(String cpId) {
        this.cpId = cpId;
    }

    public String getCpMethod() {
        return cpMethod;
    }

    public void setCpMethod(String cpMethod) {
        this.cpMethod = cpMethod;
    }

    public String getCartIds() {
        return cartIds;
    }

    public void setCartIds(String cartIds) {
        this.cartIds = cartIds;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public List<OrderDetailsListInfoBean> getOrderDetailsListInfo() {
        return orderDetailsListInfo;
    }

    public void setOrderDetailsListInfo(List<OrderDetailsListInfoBean> orderDetailsListInfo) {
        this.orderDetailsListInfo = orderDetailsListInfo;
    }
}
