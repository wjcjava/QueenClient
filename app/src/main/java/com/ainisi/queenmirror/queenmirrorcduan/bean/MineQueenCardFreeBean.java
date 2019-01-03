package com.ainisi.queenmirror.queenmirrorcduan.bean;

/**
 * Created by john on 2018/8/14.
 */

public class MineQueenCardFreeBean {


    /**
     * success : true
     * errorCode : 0
     * msg : 成功
     * body : {"status":"0","givenDays":10,"remarks":"免费试用赠送会员"}
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
         * status : 0
         * givenDays : 10
         * remarks : 免费试用赠送会员
         */

        private String status;//  0未领取    1已领取    2是活动过期或下架
        private int givenDays;
        private String remarks;

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public int getGivenDays() {
            return givenDays;
        }

        public void setGivenDays(int givenDays) {
            this.givenDays = givenDays;
        }

        public String getRemarks() {
            return remarks;
        }

        public void setRemarks(String remarks) {
            this.remarks = remarks;
        }
    }
}
