package com.ainisi.queenmirror.queenmirrorcduan.ui.mine.bean;

/**
 * Created by jiangchao on 2018/9/12 下午5:26.
 */


public class BuyClassByAlipayBean {

    /**
     * success : true
     * errorCode : 0
     * msg : 请求成功
     * body : {"transId":"3180912717255620000000000","aliPayResult":"alipay_sdk=alipay-sdk-java-dynamicVersionNo&app_id=2018051160111354&biz_content=%7B%22out_trade_no%22%3A%223180912717255620000000000%22%2C%22product_code%22%3A%22QUICK_MSECURITY_PAY%22%2C%22subject%22%3A%22%E5%A5%B3%E7%8E%8B%E9%AD%94%E9%95%9C%22%2C%22timeout_express%22%3A%2230m%22%2C%22total_amount%22%3A%220.1%22%7D&charset=utf-8&format=json&method=alipay.trade.app.pay&notify_url=http%3A%2F%2F58.210.102.70%3A7080%2Fwg%2Fa%2Fapi%2Futil%2Falipay%2FaliPayNotify&sign=eUi2LHjWbseqepSuF9ou4S2M%2BBVgu9JnmXDfdo7jW%2BQ4I3vA9NJ23xtt5M6NNAqj1SLbbRlgumFClJIooGoRSzJw5Ke%2BUOL2h%2Fj1hiukX12ZsJ3EUifm7roaNBvnOw2KFLt3etYdo%2B2y45QVA6774MUIOTF24LbSwUpZBeSUEQDWpo3oMHxrm5nxM8QbnjlE0VYyENtqADYZRWt%2FHB5j8SZeDs%2F6pAKE5WJuahkJEXcCADGGCSJ%2FmBZtB0H3SIrGLe5nr8GwXWTOCYVqxXS958YBDq4fPS4IYA2l1ldUkRHACPHDePhRVhO1oWiI5lR26zHxP2TOXnKLdbeaEBavTw%3D%3D&sign_type=RSA2&timestamp=2018-09-12+17%3A25%3A56&version=1.0"}
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
         * transId : 3180912717255620000000000
         * aliPayResult : alipay_sdk=alipay-sdk-java-dynamicVersionNo&app_id=2018051160111354&biz_content=%7B%22out_trade_no%22%3A%223180912717255620000000000%22%2C%22product_code%22%3A%22QUICK_MSECURITY_PAY%22%2C%22subject%22%3A%22%E5%A5%B3%E7%8E%8B%E9%AD%94%E9%95%9C%22%2C%22timeout_express%22%3A%2230m%22%2C%22total_amount%22%3A%220.1%22%7D&charset=utf-8&format=json&method=alipay.trade.app.pay&notify_url=http%3A%2F%2F58.210.102.70%3A7080%2Fwg%2Fa%2Fapi%2Futil%2Falipay%2FaliPayNotify&sign=eUi2LHjWbseqepSuF9ou4S2M%2BBVgu9JnmXDfdo7jW%2BQ4I3vA9NJ23xtt5M6NNAqj1SLbbRlgumFClJIooGoRSzJw5Ke%2BUOL2h%2Fj1hiukX12ZsJ3EUifm7roaNBvnOw2KFLt3etYdo%2B2y45QVA6774MUIOTF24LbSwUpZBeSUEQDWpo3oMHxrm5nxM8QbnjlE0VYyENtqADYZRWt%2FHB5j8SZeDs%2F6pAKE5WJuahkJEXcCADGGCSJ%2FmBZtB0H3SIrGLe5nr8GwXWTOCYVqxXS958YBDq4fPS4IYA2l1ldUkRHACPHDePhRVhO1oWiI5lR26zHxP2TOXnKLdbeaEBavTw%3D%3D&sign_type=RSA2&timestamp=2018-09-12+17%3A25%3A56&version=1.0
         */

        private String transId;
        private String aliPayResult;

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
