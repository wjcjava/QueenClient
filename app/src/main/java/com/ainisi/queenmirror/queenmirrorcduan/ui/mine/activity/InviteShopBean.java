package com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity;

/**
 * Created by john on 2018/6/11.
 */

class InviteShopBean {

    /**
     * success : true
     * errorCode : -1
     * msg : 操作成功
     * body : {"inviteUrlGenForB":"http://58.210.102.70:7080/wg/webpage/staticSource/bd_download.html?objectType=1&objectId=0"}
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
         * inviteUrlGenForB : http://58.210.102.70:7080/wg/webpage/staticSource/bd_download.html?objectType=1&objectId=0
         */

        private String inviteUrlGenForB;

        public String getInviteUrlGenForB() {
            return inviteUrlGenForB;
        }

        public void setInviteUrlGenForB(String inviteUrlGenForB) {
            this.inviteUrlGenForB = inviteUrlGenForB;
        }
    }
}
