package com.ainisi.queenmirror.queenmirrorcduan.bean;

/**
 * Created by john on 2018/7/13.
 */

public class PurchaseCheckBean {


    /**
     * success : true
     * errorCode : 0
     * msg : 获取标志成功
     * body : {"checkFlag":"not"}
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
         * checkFlag : not
         */

        private String checkFlag;

        public String getCheckFlag() {
            return checkFlag;
        }

        public void setCheckFlag(String checkFlag) {
            this.checkFlag = checkFlag;
        }
    }
}
