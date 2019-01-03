package com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean;

/**
 * 作者：linxi on 2018/10/15 11:20
 * 邮箱：707078566@qq.com
 * 用途：
 */
public class SeckillOrderSubmitBean {

    /**
     * success : true
     * errorCode : 0
     * msg : 订单提交成功
     * body : {"submitId":"1424c76c02e4404db525ee9c1591a699","orderIds":"8ec368eb2d8e43b2b53be5971f08f5f1,64c09a7d951647e0a84dc98d6d298217"}
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
         * submitId : 1424c76c02e4404db525ee9c1591a699
         * orderIds : 8ec368eb2d8e43b2b53be5971f08f5f1,64c09a7d951647e0a84dc98d6d298217
         */

        private String submitId;
        private String orderIds;

        public String getSubmitId() {
            return submitId;
        }

        public void setSubmitId(String submitId) {
            this.submitId = submitId;
        }

        public String getOrderIds() {
            return orderIds;
        }

        public void setOrderIds(String orderIds) {
            this.orderIds = orderIds;
        }
    }
}
