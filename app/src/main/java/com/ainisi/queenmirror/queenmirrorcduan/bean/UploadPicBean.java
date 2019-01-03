package com.ainisi.queenmirror.queenmirrorcduan.bean;

public class UploadPicBean {


    /**
     * success : true
     * errorCode : 0
     * msg : 修改成功
     * body : {"HeadPic":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062105541234436990.jpg"}
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
         * HeadPic : https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062105541234436990.jpg
         */

        private String HeadPic;

        public String getHeadPic() {
            return HeadPic;
        }

        public void setHeadPic(String HeadPic) {
            this.HeadPic = HeadPic;
        }
    }
}
