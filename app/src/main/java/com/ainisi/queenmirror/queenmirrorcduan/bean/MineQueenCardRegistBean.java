package com.ainisi.queenmirror.queenmirrorcduan.bean;

/**
 * Created by john on 2018/8/15.
 */

public class MineQueenCardRegistBean {


    /**
     * success : true
     * errorCode : 0
     * msg : 成功
     * body : {"status":"2","givenDays":5,"remarks":null}
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
         * status : 2
         * givenDays : 5
         * remarks : null
         */

        private String status;
        private int givenDays;
        private Object remarks;

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

        public Object getRemarks() {
            return remarks;
        }

        public void setRemarks(Object remarks) {
            this.remarks = remarks;
        }
    }
}
