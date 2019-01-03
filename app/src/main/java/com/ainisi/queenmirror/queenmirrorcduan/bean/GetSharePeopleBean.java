package com.ainisi.queenmirror.queenmirrorcduan.bean;

/**
 * Created by john on 2018/7/7.
 */

public class GetSharePeopleBean {


    /**
     * success : true
     * errorCode : 0
     * msg : 成功
     * body : {"invitees":0,"points":0}
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
         * invitees : 0
         * points : 0
         */

        private String invitees;
        private String points;

        public String getInvitees() {
            return invitees;
        }

        public void setInvitees(String invitees) {
            this.invitees = invitees;
        }

        public String getPoints() {
            return points;
        }

        public void setPoints(String points) {
            this.points = points;
        }
    }
}
