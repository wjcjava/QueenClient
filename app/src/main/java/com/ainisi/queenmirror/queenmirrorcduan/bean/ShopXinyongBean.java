package com.ainisi.queenmirror.queenmirrorcduan.bean;

public class ShopXinyongBean {


    /**
     * success : true
     * errorCode : 1
     * msg : 没有数据
     * body : {"apiShopScoreGet":{"avgTakeMinutes":"0","avgService":"0","avgEnvironment":"0","comScore":"0"}}
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
         * apiShopScoreGet : {"avgTakeMinutes":"0","avgService":"0","avgEnvironment":"0","comScore":"0"}
         */

        private ApiShopScoreGetBean apiShopScoreGet;

        public ApiShopScoreGetBean getApiShopScoreGet() {
            return apiShopScoreGet;
        }

        public void setApiShopScoreGet(ApiShopScoreGetBean apiShopScoreGet) {
            this.apiShopScoreGet = apiShopScoreGet;
        }

        public static class ApiShopScoreGetBean {
            /**
             * avgTakeMinutes : 0
             * avgService : 0
             * avgEnvironment : 0
             * comScore : 0
             */

            private String avgTakeMinutes;
            private String avgService;
            private String avgEnvironment;
            private String comScore;

            public String getAvgTakeMinutes() {
                return avgTakeMinutes;
            }

            public void setAvgTakeMinutes(String avgTakeMinutes) {
                this.avgTakeMinutes = avgTakeMinutes;
            }

            public String getAvgService() {
                return avgService;
            }

            public void setAvgService(String avgService) {
                this.avgService = avgService;
            }

            public String getAvgEnvironment() {
                return avgEnvironment;
            }

            public void setAvgEnvironment(String avgEnvironment) {
                this.avgEnvironment = avgEnvironment;
            }

            public String getComScore() {
                return comScore;
            }

            public void setComScore(String comScore) {
                this.comScore = comScore;
            }
        }
    }
}
