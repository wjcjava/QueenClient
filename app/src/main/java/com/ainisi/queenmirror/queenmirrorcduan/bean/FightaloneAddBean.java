package com.ainisi.queenmirror.queenmirrorcduan.bean;

public class FightaloneAddBean {


    /**
     * success : true
     * errorCode : 0
     * msg : 团购单提交成功
     * body : {"groupOrderId":"644f5a16a73c4ba894509614b60f3616","groupId":"1529483953219","orderId":"f9a7caf161674669863591f3094d8796"}
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
         * groupOrderId : 644f5a16a73c4ba894509614b60f3616
         * groupId : 1529483953219
         * orderId : f9a7caf161674669863591f3094d8796
         */

        private String groupOrderId;
        private String groupId;
        private String orderId;

        public String getGroupOrderId() {
            return groupOrderId;
        }

        public void setGroupOrderId(String groupOrderId) {
            this.groupOrderId = groupOrderId;
        }

        public String getGroupId() {
            return groupId;
        }

        public void setGroupId(String groupId) {
            this.groupId = groupId;
        }

        public String getOrderId() {
            return orderId;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
        }
    }
}
