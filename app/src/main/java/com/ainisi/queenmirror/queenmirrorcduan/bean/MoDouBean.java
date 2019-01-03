package com.ainisi.queenmirror.queenmirrorcduan.bean;

public class MoDouBean {


    /**
     * success : true
     * errorCode : 0
     * msg : 获取成功
     * body : {"map":{"cardLevel":"1","pointsNow":108790}}
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
         * map : {"cardLevel":"1","pointsNow":108790}
         */

        private MapBean map;

        public MapBean getMap() {
            return map;
        }

        public void setMap(MapBean map) {
            this.map = map;
        }

        public static class MapBean {
            /**
             * cardLevel : 1
             * pointsNow : 108790
             */

            private String cardLevel;
            private int pointsNow;

            public String getCardLevel() {
                return cardLevel;
            }

            public void setCardLevel(String cardLevel) {
                this.cardLevel = cardLevel;
            }

            public int getPointsNow() {
                return pointsNow;
            }

            public void setPointsNow(int pointsNow) {
                this.pointsNow = pointsNow;
            }
        }
    }
}
