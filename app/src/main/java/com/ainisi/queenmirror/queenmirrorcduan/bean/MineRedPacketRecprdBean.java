package com.ainisi.queenmirror.queenmirrorcduan.bean;

import java.util.List;

/**
 * Created by john on 2018/8/22.
 */

public class MineRedPacketRecprdBean {


    /**
     * success : true
     * errorCode : 0
     * msg : 成功
     * body : {"pageSum":1,"redPacketRecords":[{"redPacketTitle":"新用户专享红包","fromDate":"2018-08-21 17:36:26","endDate":"2018-11-20 17:36:29","money":"40.00","useRequire":"100.00","useRule":"这是使用规则这是使用规则这是使用规则这是使用规则这是使用规则这是使用规则","receiveDate":"2018-08-22 15:04:42","id":"93fe0d8b34fc4652b3a7c1f36950b684","ifUse":"0","ifEnd":"0"}]}
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
         * redPacketRecords : [{"redPacketTitle":"新用户专享红包","fromDate":"2018-08-21 17:36:26","endDate":"2018-11-20 17:36:29","money":"40.00","useRequire":"100.00","useRule":"这是使用规则这是使用规则这是使用规则这是使用规则这是使用规则这是使用规则","receiveDate":"2018-08-22 15:04:42","id":"93fe0d8b34fc4652b3a7c1f36950b684","ifUse":"0","ifEnd":"0"}]
         */

        private int pageSum;
        private List<RedPacketRecordsBean> redPacketRecords;

        public int getPageSum() {
            return pageSum;
        }

        public void setPageSum(int pageSum) {
            this.pageSum = pageSum;
        }

        public List<RedPacketRecordsBean> getRedPacketRecords() {
            return redPacketRecords;
        }

        public void setRedPacketRecords(List<RedPacketRecordsBean> redPacketRecords) {
            this.redPacketRecords = redPacketRecords;
        }

        public static class RedPacketRecordsBean {
            /**
             * redPacketTitle : 新用户专享红包
             * fromDate : 2018-08-21 17:36:26
             * endDate : 2018-11-20 17:36:29
             * money : 40.00
             * useRequire : 100.00
             * useRule : 这是使用规则这是使用规则这是使用规则这是使用规则这是使用规则这是使用规则
             * receiveDate : 2018-08-22 15:04:42
             * id : 93fe0d8b34fc4652b3a7c1f36950b684
             * ifUse : 0
             * ifEnd : 0
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
            private String ifEnd;

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

            public String getIfEnd() {
                return ifEnd;
            }

            public void setIfEnd(String ifEnd) {
                this.ifEnd = ifEnd;
            }
        }
    }
}
