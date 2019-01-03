package com.ainisi.queenmirror.queenmirrorcduan.ui.mine.bean;

/**
 * Created by john on 2018/6/11.
 */

public class RealNameBean {

    /**
     * success : true
     * errorCode : 0
     * msg : 操作成功
     * body : {}
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
    }
}
