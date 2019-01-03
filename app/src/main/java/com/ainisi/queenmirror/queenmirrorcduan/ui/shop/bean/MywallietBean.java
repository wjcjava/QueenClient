package com.ainisi.queenmirror.queenmirrorcduan.ui.shop.bean;

/**
 * Created by john on 2018/6/9.
 */

public class MywallietBean {


    /**
     * success : true
     * errorCode : 0
     * msg : 获取余额成功
     * body : {"accountBalance":999}
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
         * accountBalance : 9999.99
         */

        private double accountBalance;

        public double getAccountBalance() {
            return accountBalance;
        }

        public void setAccountBalance(double accountBalance) {
            this.accountBalance = accountBalance;
        }
    }
}
