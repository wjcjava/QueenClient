package com.ainisi.queenmirror.queenmirrorcduan.bean;

/**
 * Created by john on 2018/7/12.
 */

public class MineProblemBean {


    /**
     * success : true
     * errorCode : 0
     * msg : 操作成功
     * body : {"proposalUrl":"http://58.210.102.70:7080/wg/h5/proposal.html"}
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
         * proposalUrl : http://58.210.102.70:7080/wg/h5/proposal.html
         */

        private String proposalUrl;

        public String getProposalUrl() {
            return proposalUrl;
        }

        public void setProposalUrl(String proposalUrl) {
            this.proposalUrl = proposalUrl;
        }
    }
}
