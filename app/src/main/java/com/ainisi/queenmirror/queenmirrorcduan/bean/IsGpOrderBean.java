package com.ainisi.queenmirror.queenmirrorcduan.bean;

/**
 * Created by john on 2018/8/3.
 */

public class IsGpOrderBean {


    /**
     * success : true
     * errorCode : 0
     * msg : 操作成功
     * body : {"isGporder":true}
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
         * isGporder : true
         */

        private boolean isGporder;
        private String groupId;

        public String getGroupId() {
            return groupId;
        }

        public void setGroupId(String groupId) {
            this.groupId = groupId;
        }

        public boolean isIsGporder() {
            return isGporder;
        }

        public void setIsGporder(boolean isGporder) {
            this.isGporder = isGporder;
        }
    }
}
