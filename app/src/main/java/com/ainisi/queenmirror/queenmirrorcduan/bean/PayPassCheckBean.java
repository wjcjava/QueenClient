package com.ainisi.queenmirror.queenmirrorcduan.bean;

public class PayPassCheckBean {


    /**
     * success : true
     * errorCode : 0
     * msg : 不存在
     * body : {"isExists":1}
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
         * isExists : 1
         */

        private int isExists;

        public int getIsExists() {
            return isExists;
        }

        public void setIsExists(int isExists) {
            this.isExists = isExists;
        }
    }
}
