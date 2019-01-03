package com.ainisi.queenmirror.queenmirrorcduan.bean;

import java.util.List;

/**
 * Created by john on 2018/8/23.
 */

public class MineRedPacketBean {


    /**
     * success : true
     * errorCode : 0
     * msg : 成功
     * body : {"pageSum":1,"redPackets":[{"redPacketTitle":"新用户专享红包","fromDate":"2018-08-21 09:14:23","endDate":"2018-10-30 09:14:28","money":"40.00","useRequire":"100.00","useRule":"规则规则","receiveDate":"2018-08-23 10:23:43","id":"52a40a527cbf4dfb8714f6955dc1f42b","ifUse":"0","ifEnd":null}]}
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
         * pageSum : 1
         * redPackets : [{"redPacketTitle":"新用户专享红包","fromDate":"2018-08-21 09:14:23","endDate":"2018-10-30 09:14:28","money":"40.00","useRequire":"100.00","useRule":"规则规则","receiveDate":"2018-08-23 10:23:43","id":"52a40a527cbf4dfb8714f6955dc1f42b","ifUse":"0","ifEnd":null}]
         */

        private int pageSum;
        private List<RedPacketsBean> redPackets;

        public int getPageSum() {
            return pageSum;
        }

        public void setPageSum(int pageSum) {
            this.pageSum = pageSum;
        }

        public List<RedPacketsBean> getRedPackets() {
            return redPackets;
        }

        public void setRedPackets(List<RedPacketsBean> redPackets) {
            this.redPackets = redPackets;
        }

        public static class RedPacketsBean {
            /**
             * redPacketTitle : 新用户专享红包
             * fromDate : 2018-08-21 09:14:23
             * endDate : 2018-10-30 09:14:28
             * money : 40.00
             * useRequire : 100.00
             * useRule : 规则规则
             * receiveDate : 2018-08-23 10:23:43
             * id : 52a40a527cbf4dfb8714f6955dc1f42b
             * ifUse : 0
             * ifEnd : null
             */

            private String redPacketTitle;
            private String fromDate;
            private String endDate;
            private String money;
            private String useRequire;
            private String useRule;
            private String receiveDate;
            private String id;
            private String ifUse;
            private Object ifEnd;

            public String getRedPacketTitle() {
                return redPacketTitle;
            }

            public void setRedPacketTitle(String redPacketTitle) {
                this.redPacketTitle = redPacketTitle;
            }

            public String getFromDate() {
                return fromDate;
            }

            public void setFromDate(String fromDate) {
                this.fromDate = fromDate;
            }

            public String getEndDate() {
                return endDate;
            }

            public void setEndDate(String endDate) {
                this.endDate = endDate;
            }

            public String getMoney() {
                return money;
            }

            public void setMoney(String money) {
                this.money = money;
            }

            public String getUseRequire() {
                return useRequire;
            }

            public void setUseRequire(String useRequire) {
                this.useRequire = useRequire;
            }

            public String getUseRule() {
                return useRule;
            }

            public void setUseRule(String useRule) {
                this.useRule = useRule;
            }

            public String getReceiveDate() {
                return receiveDate;
            }

            public void setReceiveDate(String receiveDate) {
                this.receiveDate = receiveDate;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getIfUse() {
                return ifUse;
            }

            public void setIfUse(String ifUse) {
                this.ifUse = ifUse;
            }

            public Object getIfEnd() {
                return ifEnd;
            }

            public void setIfEnd(Object ifEnd) {
                this.ifEnd = ifEnd;
            }
        }
    }
}
