package com.ainisi.queenmirror.queenmirrorcduan.bean;

import java.io.Serializable;
import java.util.List;

public class OrderPayDetailBean implements Serializable{


    /**
     * success : true
     * errorCode : 0
     * msg : 订单提交成功
     * body : {"orderIdList":["9d58cfac78234bbcb8856fb6ff89591b"]}
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

    public static class BodyBean implements Serializable{
        private List<String> orderIdList;
        private String submitId;
        private String zeroOrderIds;

        public String getSubmitId() {
            return submitId;
        }

        public void setSubmitId(String submitId) {
            this.submitId = submitId;
        }

        public String getZeroOrderIds() {
            return zeroOrderIds;
        }

        public void setZeroOrderIds(String zeroOrderIds) {
            this.zeroOrderIds = zeroOrderIds;
        }

        public List<String> getOrderIdList() {
            return orderIdList;
        }

        public void setOrderIdList(List<String> orderIdList) {
            this.orderIdList = orderIdList;
        }
    }
}
