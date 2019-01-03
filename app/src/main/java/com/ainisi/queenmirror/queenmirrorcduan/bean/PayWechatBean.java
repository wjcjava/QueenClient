package com.ainisi.queenmirror.queenmirrorcduan.bean;

/**
 * Created by john on 2018/6/28.
 *
 * jl
 */

public class PayWechatBean {


    /**
     * success : true
     * errorCode : 0
     * msg : 微信统一订单下单成功
     * body : {"map":{"nonce_str":"FjXu3wljYC8SL1L8","appid":"wxc3a8d687d3fd120d","sign":"77B7880278F6399CDAD7C045F96CA3D9",
     * "trade_type":"APP","return_msg":"OK","result_code":"SUCCESS","mch_id":"1505011561","return_code":"SUCCESS",
     * "prepay_id":"wx2810583907324266e9aad2782632286324"},"isSuccess":"0","outTradeNo":"3180628110583810000000001"}
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
         * map : {"nonce_str":"FjXu3wljYC8SL1L8","appid":"wxc3a8d687d3fd120d","sign":"77B7880278F6399CDAD7C045F96CA3D9","trade_type":"APP","return_msg":"OK","result_code":"SUCCESS","mch_id":"1505011561","return_code":"SUCCESS","prepay_id":"wx2810583907324266e9aad2782632286324"}
         * isSuccess : 0
         * outTradeNo : 3180628110583810000000001
         */

        private MapBean map;
        private String isSuccess;
        private String outTradeNo;

        public MapBean getMap() {
            return map;
        }

        public void setMap(MapBean map) {
            this.map = map;
        }

        public String getIsSuccess() {
            return isSuccess;
        }

        public void setIsSuccess(String isSuccess) {
            this.isSuccess = isSuccess;
        }

        public String getOutTradeNo() {
            return outTradeNo;
        }

        public void setOutTradeNo(String outTradeNo) {
            this.outTradeNo = outTradeNo;
        }

        public static class MapBean {
            /**
             * nonce_str : FjXu3wljYC8SL1L8
             * appid : wxc3a8d687d3fd120d
             * sign : 77B7880278F6399CDAD7C045F96CA3D9
             * trade_type : APP
             * return_msg : OK
             * result_code : SUCCESS
             * mch_id : 1505011561
             * return_code : SUCCESS
             * prepay_id : wx2810583907324266e9aad2782632286324
             */

            private String nonce_str;
            private String appid;
            private String sign;
            private String trade_type;
            private String return_msg;
            private String result_code;
            private String mch_id;
            private String return_code;
            private String prepay_id;

            public String getNonce_str() {
                return nonce_str;
            }

            public void setNonce_str(String nonce_str) {
                this.nonce_str = nonce_str;
            }

            public String getAppid() {
                return appid;
            }

            public void setAppid(String appid) {
                this.appid = appid;
            }

            public String getSign() {
                return sign;
            }

            public void setSign(String sign) {
                this.sign = sign;
            }

            public String getTrade_type() {
                return trade_type;
            }

            public void setTrade_type(String trade_type) {
                this.trade_type = trade_type;
            }

            public String getReturn_msg() {
                return return_msg;
            }

            public void setReturn_msg(String return_msg) {
                this.return_msg = return_msg;
            }

            public String getResult_code() {
                return result_code;
            }

            public void setResult_code(String result_code) {
                this.result_code = result_code;
            }

            public String getMch_id() {
                return mch_id;
            }

            public void setMch_id(String mch_id) {
                this.mch_id = mch_id;
            }

            public String getReturn_code() {
                return return_code;
            }

            public void setReturn_code(String return_code) {
                this.return_code = return_code;
            }

            public String getPrepay_id() {
                return prepay_id;
            }

            public void setPrepay_id(String prepay_id) {
                this.prepay_id = prepay_id;
            }
        }
    }
}
