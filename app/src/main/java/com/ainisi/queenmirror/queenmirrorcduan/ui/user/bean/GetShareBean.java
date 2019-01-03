package com.ainisi.queenmirror.queenmirrorcduan.ui.user.bean;

/**
 * Created by john on 2018/6/14.
 */

public class GetShareBean {

    /**
     * success : true
     * errorCode : 0
     * msg : 获取图形验证码成功
     * body : {"imageStr":"iVBORw0KGgoAAAANSUhEUgAAAFAAAAAaCAIAAACvsEzwAAABzklEQVR42t2YTU4DMQyFfQJYcQE2\nXATBiiUSd2CBhNTzl5EiRdaz/WxPplA6yqaJ8/PZju1UzvT7Pn2db+uTVOLGmKUidFXMi4f5f8CL\n56kCQ/t4f4Om5Z8eX7bmLgVDz6930K4CWG9jUYF5ExtUlnkORbS/wCytmZFJx5AFBmYLrEfrzPcP\nn9AuDszdXgMDM/F2zVxH7TJL3T0IrWvGw4Et3jx5BGzRfGBXBV3giacJK8CpeVuXGQRCC9vOHcA2\ngBHgHbR15ikj0Zw6sO3XVJoZglZKO84wjjuBIUHWr+QQE6Ik6NwNrH17klfurRaLLNxlFu4YFeYI\neM61YWwOpWFZhyUXWFu+V3hEE3S/m4eJhbX6LXAl69aBi3buAfNKC/JwVFcO4K1FlZZWQerVcLer\nwPwmkADm2lxTQYDpArtG1sxgYb0XC1oQuw95vpDVIv2m66SVFmFG4MVXSItZx7MoD7VqabcacZkl\nStB/AtxNM5VKgwGv7FS//6nAit7TraW72SVsElljXft2EdlxeliF+Gf6zwn3bR51ixqE6dIKoS5n\nPdi0Lp77s7iFGwvDxwO3GJhFa2f97tknwT5vJwlPOCfZD7CPYnaxD0wZP2ArOPsDBBvWAAAAAElF\nTkSuQmCC"}
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
         * imageStr : iVBORw0KGgoAAAANSUhEUgAAAFAAAAAaCAIAAACvsEzwAAABzklEQVR42t2YTU4DMQyFfQJYcQE2
         XATBiiUSd2CBhNTzl5EiRdaz/WxPplA6yqaJ8/PZju1UzvT7Pn2db+uTVOLGmKUidFXMi4f5f8CL
         56kCQ/t4f4Om5Z8eX7bmLgVDz6930K4CWG9jUYF5ExtUlnkORbS/wCytmZFJx5AFBmYLrEfrzPcP
         n9AuDszdXgMDM/F2zVxH7TJL3T0IrWvGw4Et3jx5BGzRfGBXBV3giacJK8CpeVuXGQRCC9vOHcA2
         gBHgHbR15ikj0Zw6sO3XVJoZglZKO84wjjuBIUHWr+QQE6Ik6NwNrH17klfurRaLLNxlFu4YFeYI
         eM61YWwOpWFZhyUXWFu+V3hEE3S/m4eJhbX6LXAl69aBi3buAfNKC/JwVFcO4K1FlZZWQerVcLer
         wPwmkADm2lxTQYDpArtG1sxgYb0XC1oQuw95vpDVIv2m66SVFmFG4MVXSItZx7MoD7VqabcacZkl
         StB/AtxNM5VKgwGv7FS//6nAit7TraW72SVsElljXft2EdlxeliF+Gf6zwn3bR51ixqE6dIKoS5n
         Pdi0Lp77s7iFGwvDxwO3GJhFa2f97tknwT5vJwlPOCfZD7CPYnaxD0wZP2ArOPsDBBvWAAAAAElF
         TkSuQmCC
         */

        private String imageStr;
        private String validateCode;

        public String getImageStr() {
            return imageStr;
        }

        public void setImageStr(String imageStr) {
            this.imageStr = imageStr;
        }

        public String getValidateCode() {
            return validateCode;
        }

        public void setValidateCode(String validateCode) {
            this.validateCode = validateCode;
        }
    }
}
