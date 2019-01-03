package com.ainisi.queenmirror.queenmirrorcduan.ui.user.bean;

/**
 * Created by Administrator on 2018/4/27.
 */

public class LoginCeshiBean {

    /**
     * success : true
     * errorCode : 0
     * msg : 发送成功
     * body : {"verifyCode":"d3d80b656929a5bc0fa34381bf42fbdd"}
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
         * verifyCode : d3d80b656929a5bc0fa34381bf42fbdd
         */

        private String verifyCode;
        private String imageStr;

        public String getImageStr() {
            return imageStr;
        }

        public void setImageStr(String imageStr) {
            this.imageStr = imageStr;
        }

        public String getVerifyCode() {
            return verifyCode;
        }

        public void setVerifyCode(String verifyCode) {
            this.verifyCode = verifyCode;
        }
    }
}
