package com.ainisi.queenmirror.queenmirrorcduan.bean;

/**
 * Created by john on 2018/6/26.
 *
 * jl
 *
 *
 * 选择是否优惠券还是魔豆
 *
 *
 */

public class PayPurchaseBean {

    private String cpMethod;
    private String cpId;
    private String cpName;
    private String cpMoney;

    public String getCpMoney() {
        return cpMoney;
    }

    public void setCpMoney(String cpMoney) {
        this.cpMoney = cpMoney;
    }

    public String getCpName() {
        return cpName;
    }

    public void setCpName(String cpName) {
        this.cpName = cpName;
    }

    public String getCpMethod() {
        return cpMethod;
    }

    public void setCpMethod(String cpMethod) {
        this.cpMethod = cpMethod;
    }

    public String getCpId() {
        return cpId;
    }

    public void setCpId(String cpId) {
        this.cpId = cpId;
    }
}
