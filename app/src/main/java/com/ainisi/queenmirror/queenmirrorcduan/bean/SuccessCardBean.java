package com.ainisi.queenmirror.queenmirrorcduan.bean;

public class SuccessCardBean {

    /**
     * success : true
     * errorCode : 0
     * msg : 关注成功
     * body : {"flag":true}
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
         * flag : true
         */

        private String isNeedImgValidateCode;

        public String getIsNeedImgValidateCode() {
            return isNeedImgValidateCode;
        }

        public void setIsNeedImgValidateCode(String isNeedImgValidateCode) {
            this.isNeedImgValidateCode = isNeedImgValidateCode;
        }
    }
}
