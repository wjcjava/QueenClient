package com.ainisi.queenmirror.queenmirrorcduan.bean;

/**
 * Created by john on 2018/7/31.
 */

public class MineQiandaoBean {


    /**
     * success : true
     * errorCode : 0
     * msg : 今日未签到
     * body : {"isSignin":"not"}
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
         * isSignin : not
         */

        private String isSignin;

        public String getIsSignin() {
            return isSignin;
        }

        public void setIsSignin(String isSignin) {
            this.isSignin = isSignin;
        }
    }
}
