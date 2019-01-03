package com.ainisi.queenmirror.queenmirrorcduan.bean;

/**
 * Created by john on 2018/8/22.
 */

public class ChaiRedPacketBean {


    /**
     * success : true
     * errorCode : 0
     * msg : 成功
     * body : {"ansRedPacket":{"id":"1e2cee21500f4406b51dae2061c92289","isNewRecord":false,"remarks":null,"createDate":"2018-08-21 16:04:59","updateDate":"2018-08-21 16:04:59","startDate":null,"endDate":null,"redPacketName":null,"getTimeFrom":null,"getTimeEnd":"2018-10-30 17:36:13","useTimeFrom":"2018-08-21 17:36:26","useTimeEnd":null,"userType":"0","platformType":"1","createType":"1","activityRule":"这是使用规则这是使用规则这是使用规则这是使用规则这是使用规则这是使用规则","redPacketTemplate":"1","templateHeadTitle":"恭喜你获得女王红包","templateButtonTitle":null,"templateClickTrigger":"0","templateIfOpen":"1","openHeadTitle":"恭喜女王大人获得新人红包","openBottomTitle":"首次下单还可以可以获得最高100.00元现金红包","openButtonTitle":"去逛逛","openClickTrigger":"1","enableFlag":"1","maxMoney":null,"redPacketMoney":"30.0"}}
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
         * ansRedPacket : {"id":"1e2cee21500f4406b51dae2061c92289","isNewRecord":false,"remarks":null,"createDate":"2018-08-21 16:04:59","updateDate":"2018-08-21 16:04:59","startDate":null,"endDate":null,"redPacketName":null,"getTimeFrom":null,"getTimeEnd":"2018-10-30 17:36:13","useTimeFrom":"2018-08-21 17:36:26","useTimeEnd":null,"userType":"0","platformType":"1","createType":"1","activityRule":"这是使用规则这是使用规则这是使用规则这是使用规则这是使用规则这是使用规则","redPacketTemplate":"1","templateHeadTitle":"恭喜你获得女王红包","templateButtonTitle":null,"templateClickTrigger":"0","templateIfOpen":"1","openHeadTitle":"恭喜女王大人获得新人红包","openBottomTitle":"首次下单还可以可以获得最高100.00元现金红包","openButtonTitle":"去逛逛","openClickTrigger":"1","enableFlag":"1","maxMoney":null,"redPacketMoney":"30.0"}
         */

        private AnsRedPacketBean ansRedPacket;

        public AnsRedPacketBean getAnsRedPacket() {
            return ansRedPacket;
        }

        public void setAnsRedPacket(AnsRedPacketBean ansRedPacket) {
            this.ansRedPacket = ansRedPacket;
        }

        public static class AnsRedPacketBean {
            /**
             * id : 1e2cee21500f4406b51dae2061c92289
             * isNewRecord : false
             * remarks : null
             * createDate : 2018-08-21 16:04:59
             * updateDate : 2018-08-21 16:04:59
             * startDate : null
             * endDate : null
             * redPacketName : null
             * getTimeFrom : null
             * getTimeEnd : 2018-10-30 17:36:13
             * useTimeFrom : 2018-08-21 17:36:26
             * useTimeEnd : null
             * userType : 0
             * platformType : 1
             * createType : 1
             * activityRule : 这是使用规则这是使用规则这是使用规则这是使用规则这是使用规则这是使用规则
             * redPacketTemplate : 1
             * templateHeadTitle : 恭喜你获得女王红包
             * templateButtonTitle : null
             * templateClickTrigger : 0
             * templateIfOpen : 1
             * openHeadTitle : 恭喜女王大人获得新人红包
             * openBottomTitle : 首次下单还可以可以获得最高100.00元现金红包
             * openButtonTitle : 去逛逛
             * openClickTrigger : 1
             * enableFlag : 1
             * maxMoney : null
             * redPacketMoney : 30.0
             */

            private String id;
            private boolean isNewRecord;
            private Object remarks;
            private String createDate;
            private String updateDate;
            private Object startDate;
            private Object endDate;
            private Object redPacketName;
            private Object getTimeFrom;
            private String getTimeEnd;
            private String useTimeFrom;
            private Object useTimeEnd;
            private String userType;
            private String platformType;
            private String createType;
            private String activityRule;
            private String redPacketTemplate;
            private String templateHeadTitle;
            private Object templateButtonTitle;
            private String templateClickTrigger;
            private String templateIfOpen;
            private String openHeadTitle;
            private String openBottomTitle;
            private String openButtonTitle;
            private String openClickTrigger;
            private String enableFlag;
            private Object maxMoney;
            private String redPacketMoney;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public boolean isIsNewRecord() {
                return isNewRecord;
            }

            public void setIsNewRecord(boolean isNewRecord) {
                this.isNewRecord = isNewRecord;
            }

            public Object getRemarks() {
                return remarks;
            }

            public void setRemarks(Object remarks) {
                this.remarks = remarks;
            }

            public String getCreateDate() {
                return createDate;
            }

            public void setCreateDate(String createDate) {
                this.createDate = createDate;
            }

            public String getUpdateDate() {
                return updateDate;
            }

            public void setUpdateDate(String updateDate) {
                this.updateDate = updateDate;
            }

            public Object getStartDate() {
                return startDate;
            }

            public void setStartDate(Object startDate) {
                this.startDate = startDate;
            }

            public Object getEndDate() {
                return endDate;
            }

            public void setEndDate(Object endDate) {
                this.endDate = endDate;
            }

            public Object getRedPacketName() {
                return redPacketName;
            }

            public void setRedPacketName(Object redPacketName) {
                this.redPacketName = redPacketName;
            }

            public Object getGetTimeFrom() {
                return getTimeFrom;
            }

            public void setGetTimeFrom(Object getTimeFrom) {
                this.getTimeFrom = getTimeFrom;
            }

            public String getGetTimeEnd() {
                return getTimeEnd;
            }

            public void setGetTimeEnd(String getTimeEnd) {
                this.getTimeEnd = getTimeEnd;
            }

            public String getUseTimeFrom() {
                return useTimeFrom;
            }

            public void setUseTimeFrom(String useTimeFrom) {
                this.useTimeFrom = useTimeFrom;
            }

            public Object getUseTimeEnd() {
                return useTimeEnd;
            }

            public void setUseTimeEnd(Object useTimeEnd) {
                this.useTimeEnd = useTimeEnd;
            }

            public String getUserType() {
                return userType;
            }

            public void setUserType(String userType) {
                this.userType = userType;
            }

            public String getPlatformType() {
                return platformType;
            }

            public void setPlatformType(String platformType) {
                this.platformType = platformType;
            }

            public String getCreateType() {
                return createType;
            }

            public void setCreateType(String createType) {
                this.createType = createType;
            }

            public String getActivityRule() {
                return activityRule;
            }

            public void setActivityRule(String activityRule) {
                this.activityRule = activityRule;
            }

            public String getRedPacketTemplate() {
                return redPacketTemplate;
            }

            public void setRedPacketTemplate(String redPacketTemplate) {
                this.redPacketTemplate = redPacketTemplate;
            }

            public String getTemplateHeadTitle() {
                return templateHeadTitle;
            }

            public void setTemplateHeadTitle(String templateHeadTitle) {
                this.templateHeadTitle = templateHeadTitle;
            }

            public Object getTemplateButtonTitle() {
                return templateButtonTitle;
            }

            public void setTemplateButtonTitle(Object templateButtonTitle) {
                this.templateButtonTitle = templateButtonTitle;
            }

            public String getTemplateClickTrigger() {
                return templateClickTrigger;
            }

            public void setTemplateClickTrigger(String templateClickTrigger) {
                this.templateClickTrigger = templateClickTrigger;
            }

            public String getTemplateIfOpen() {
                return templateIfOpen;
            }

            public void setTemplateIfOpen(String templateIfOpen) {
                this.templateIfOpen = templateIfOpen;
            }

            public String getOpenHeadTitle() {
                return openHeadTitle;
            }

            public void setOpenHeadTitle(String openHeadTitle) {
                this.openHeadTitle = openHeadTitle;
            }

            public String getOpenBottomTitle() {
                return openBottomTitle;
            }

            public void setOpenBottomTitle(String openBottomTitle) {
                this.openBottomTitle = openBottomTitle;
            }

            public String getOpenButtonTitle() {
                return openButtonTitle;
            }

            public void setOpenButtonTitle(String openButtonTitle) {
                this.openButtonTitle = openButtonTitle;
            }

            public String getOpenClickTrigger() {
                return openClickTrigger;
            }

            public void setOpenClickTrigger(String openClickTrigger) {
                this.openClickTrigger = openClickTrigger;
            }

            public String getEnableFlag() {
                return enableFlag;
            }

            public void setEnableFlag(String enableFlag) {
                this.enableFlag = enableFlag;
            }

            public Object getMaxMoney() {
                return maxMoney;
            }

            public void setMaxMoney(Object maxMoney) {
                this.maxMoney = maxMoney;
            }

            public String getRedPacketMoney() {
                return redPacketMoney;
            }

            public void setRedPacketMoney(String redPacketMoney) {
                this.redPacketMoney = redPacketMoney;
            }
        }
    }
}
