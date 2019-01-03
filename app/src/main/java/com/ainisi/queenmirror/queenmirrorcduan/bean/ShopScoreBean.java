package com.ainisi.queenmirror.queenmirrorcduan.bean;

/**
 * Created by john on 2018/7/3.
 */

public class ShopScoreBean {


    /**
     * success : true
     * errorCode : 0
     * msg : 获取数据成功
     * body : {"apiGoodsScoreGet":{"avgScore":"3.3333333333333335","good":"0.67"}}
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
         * apiGoodsScoreGet : {"avgScore":"3.3333333333333335","good":"0.67"}
         */

        private ApiGoodsScoreGetBean apiGoodsScoreGet;

        public ApiGoodsScoreGetBean getApiGoodsScoreGet() {
            return apiGoodsScoreGet;
        }

        public void setApiGoodsScoreGet(ApiGoodsScoreGetBean apiGoodsScoreGet) {
            this.apiGoodsScoreGet = apiGoodsScoreGet;
        }

        public static class ApiGoodsScoreGetBean {
            /**
             * avgScore : 3.3333333333333335
             * good : 0.67
             */

            private String avgScore;
            private String good;

            public String getAvgScore() {
                return avgScore;
            }

            public void setAvgScore(String avgScore) {
                this.avgScore = avgScore;
            }

            public String getGood() {
                return good;
            }

            public void setGood(String good) {
                this.good = good;
            }
        }
    }
}
