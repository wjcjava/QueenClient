package com.ainisi.queenmirror.queenmirrorcduan.ui.mine.bean;

/**
 * @author linxi
 * @date 2018/11/5 09:44
 * @use
 */
public class SettingPsdBean {
    private boolean success;
    private String errorCode;
    private String msg;

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
}
