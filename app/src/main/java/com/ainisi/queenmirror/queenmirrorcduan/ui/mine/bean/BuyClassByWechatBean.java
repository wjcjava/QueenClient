package com.ainisi.queenmirror.queenmirrorcduan.ui.mine.bean;

/**
 * Created by jiangchao on 2018/9/12 下午5:27.
 */


public class BuyClassByWechatBean {


    /**
     * success : true
     * errorCode : 0
     * msg : 请求成功
     * body : {"isSuccess":"0","map":{"nonce_str":"B2IwleofKlHPPM1z","appid":"wxc3a8d687d3fd120d","sign":"84CDC83F58E848BBBAFD2A0E784228C4","trade_type":"APP","return_msg":"OK","result_code":"SUCCESS","mch_id":"1505011561","return_code":"SUCCESS","prepay_id":"wx12172713295512aad161f7150721112614"},"outTradeNo":"3180912717271210000000000"}
     */

    private boolean success;
    private String errorCode;
    private String msg;
    private BodyEntity body;

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

    public BodyEntity getBody() {
        return body;
    }

    public void setBody(BodyEntity body) {
        this.body = body;
    }

    public static class BodyEntity {
        /**
         * isSuccess : 0
         * map : {"nonce_str":"B2IwleofKlHPPM1z","appid":"wxc3a8d687d3fd120d","sign":"84CDC83F58E848BBBAFD2A0E784228C4","trade_type":"APP","return_msg":"OK","result_code":"SUCCESS","mch_id":"1505011561","return_code":"SUCCESS","prepay_id":"wx12172713295512aad161f7150721112614"}
         * outTradeNo : 3180912717271210000000000
         */

        private String isSuccess;
        private MapEntity map;
        private String outTradeNo;

        public String getIsSuccess() {
            return isSuccess;
        }

        public void setIsSuccess(String isSuccess) {
            this.isSuccess = isSuccess;
        }

        public MapEntity getMap() {
            return map;
        }

        public void setMap(MapEntity map) {
            this.map = map;
        }

        public String getOutTradeNo() {
            return outTradeNo;
        }

        public void setOutTradeNo(String outTradeNo) {
            this.outTradeNo = outTradeNo;
        }

        public static class MapEntity {
            /**
             * nonce_str : B2IwleofKlHPPM1z
             * appid : wxc3a8d687d3fd120d
             * sign : 84CDC83F58E848BBBAFD2A0E784228C4
             * trade_type : APP
             * return_msg : OK
             * result_code : SUCCESS
             * mch_id : 1505011561
             * return_code : SUCCESS
             * prepay_id : wx12172713295512aad161f7150721112614
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
