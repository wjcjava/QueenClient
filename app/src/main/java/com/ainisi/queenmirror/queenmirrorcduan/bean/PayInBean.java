package com.ainisi.queenmirror.queenmirrorcduan.bean;

import java.io.Serializable;

public class PayInBean implements Serializable{


    /**
     * success : true
     * errorCode : 0
     * msg : 请求成功
     * body : {"aliPayResult":"alipay_sdk=alipay-sdk-java-dynamicVersionNo&app_id=2018051160111354&biz_content=%7B%22out_trade_no%22%3A%223180528116074820000000001%22%2C%22product_code%22%3A%22QUICK_MSECURITY_PAY%22%2C%22subject%22%3A%22%E5%A5%B3%E7%8E%8B%E9%AD%94%E9%95%9C%22%2C%22timeout_express%22%3A%2230m%22%2C%22total_amount%22%3A%220.01%22%7D&charset=utf-8&format=json&method=alipay.trade.app.pay&notify_url=http%3A%2F%2F58.210.102.70%3A7080%2Fwg%2Fa%2Fapi%2Futil%2Fpay%2FaliPayNotify&sign=GXrtDbWdbP31kEw6ZCeGgBDIAK97kKS4mEnNXpdhAQIKkQ9u5%2BD2JqNJyBTzEQ%2B7UatridkGX2HsKrECYAfYcBY36pC5Dr9mXFhaStpr3J4r3oFNVbZLge92fWGbmjZxR5B%2B7qW%2B43oTPvv47FCsYHCnN77tKn7602SrZXjXreYZdmiIf9%2BhRdcpkazn28LvV4xg8FlM4lJ6pz%2B1NUmDPFTM4D7CE%2BXfXbl27rVhU3MtP5Ngi8iv6EjpETrPjV2JsRCOU19xyUAPz3RliBruAkDcLxpYqufBTk4azFSgFY4uvK1aI3HvB72nVuyZQ%2FbxjaArX1X0Q9HlmSSJ50mmBg%3D%3D&sign_type=RSA2&timestamp=2018-05-28+16%3A07%3A48&version=1.0"}
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
         * aliPayResult : alipay_sdk=alipay-sdk-java-dynamicVersionNo&app_id=2018051160111354&biz_content=%7B%22out_trade_no%22%3A%223180528116074820000000001%22%2C%22product_code%22%3A%22QUICK_MSECURITY_PAY%22%2C%22subject%22%3A%22%E5%A5%B3%E7%8E%8B%E9%AD%94%E9%95%9C%22%2C%22timeout_express%22%3A%2230m%22%2C%22total_amount%22%3A%220.01%22%7D&charset=utf-8&format=json&method=alipay.trade.app.pay&notify_url=http%3A%2F%2F58.210.102.70%3A7080%2Fwg%2Fa%2Fapi%2Futil%2Fpay%2FaliPayNotify&sign=GXrtDbWdbP31kEw6ZCeGgBDIAK97kKS4mEnNXpdhAQIKkQ9u5%2BD2JqNJyBTzEQ%2B7UatridkGX2HsKrECYAfYcBY36pC5Dr9mXFhaStpr3J4r3oFNVbZLge92fWGbmjZxR5B%2B7qW%2B43oTPvv47FCsYHCnN77tKn7602SrZXjXreYZdmiIf9%2BhRdcpkazn28LvV4xg8FlM4lJ6pz%2B1NUmDPFTM4D7CE%2BXfXbl27rVhU3MtP5Ngi8iv6EjpETrPjV2JsRCOU19xyUAPz3RliBruAkDcLxpYqufBTk4azFSgFY4uvK1aI3HvB72nVuyZQ%2FbxjaArX1X0Q9HlmSSJ50mmBg%3D%3D&sign_type=RSA2&timestamp=2018-05-28+16%3A07%3A48&version=1.0
         */

        private String aliPayResult;
        private String transId;

        public String getTransId() {
            return transId;
        }

        public void setTransId(String transId) {
            this.transId = transId;
        }

        public String getAliPayResult() {
            return aliPayResult;
        }

        public void setAliPayResult(String aliPayResult) {
            this.aliPayResult = aliPayResult;
        }
    }
}
