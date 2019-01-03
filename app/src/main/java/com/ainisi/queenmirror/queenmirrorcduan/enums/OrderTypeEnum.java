package com.ainisi.queenmirror.queenmirrorcduan.enums;

/**
 * 作者：linxi on 2018/10/15 17:00
 * 邮箱：707078566@qq.com
 * 用途：
 */
public enum OrderTypeEnum {

    普通订单("0"),
    秒杀订单("1");

    OrderTypeEnum(String rv) {
        this.value = rv;
    }

    private String value;

    public String getValue() {
        return value;
    }
}
