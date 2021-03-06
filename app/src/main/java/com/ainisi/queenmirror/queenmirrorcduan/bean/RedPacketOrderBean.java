package com.ainisi.queenmirror.queenmirrorcduan.bean;

import java.util.List;

/**
 * Created by john on 2018/8/23.
 */

public class RedPacketOrderBean {

    /**
     * success : true
     * errorCode : 0
     * msg : 成功
     * body : {"status":"2","ansRedPacket":{"id":"e222e374ebad4a68859969469248151c","isNewRecord":false,"remarks":null,"createDate":"2018-08-23 08:43:33","updateDate":"2018-08-23 08:43:33","startDate":null,"endDate":null,"redPacketName":"首单","getTimeFrom":"2018-08-03 00:00:00","getTimeEnd":"2018-08-25 00:00:00","useTimeFrom":"2018-08-04 00:00:00","useTimeEnd":"2018-08-29 00:00:00","userType":"0","platformType":"0","createType":"0","activityRule":"首单领取","redPacketTemplate":"0","templateHeadTitle":"恭喜获得首单红包","templateButtonTitle":"去消费吧","templateClickTrigger":"1","templateIfOpen":"0","openHeadTitle":"恭喜获得首单红包","openBottomTitle":"首次下单还可获得","openButtonTitle":"点击吧","openClickTrigger":"1","enableFlag":"1","maxMoney":"30.0","redPacketMoney":null,"columnList":[]}}
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
         * status : 2
         * ansRedPacket : {"id":"e222e374ebad4a68859969469248151c","isNewRecord":false,"remarks":null,"createDate":"2018-08-23 08:43:33","updateDate":"2018-08-23 08:43:33","startDate":null,"endDate":null,"redPacketName":"首单","getTimeFrom":"2018-08-03 00:00:00","getTimeEnd":"2018-08-25 00:00:00","useTimeFrom":"2018-08-04 00:00:00","useTimeEnd":"2018-08-29 00:00:00","userType":"0","platformType":"0","createType":"0","activityRule":"首单领取","redPacketTemplate":"0","templateHeadTitle":"恭喜获得首单红包","templateButtonTitle":"去消费吧","templateClickTrigger":"1","templateIfOpen":"0","openHeadTitle":"恭喜获得首单红包","openBottomTitle":"首次下单还可获得","openButtonTitle":"点击吧","openClickTrigger":"1","enableFlag":"1","maxMoney":"30.0","redPacketMoney":null,"columnList":[]}
         */

        private String status;
        private String hasReceive;
        private AnsRedPacketBean ansRedPacket;

        public String getHasReceive() {
            return hasReceive;
        }

        public void setHasReceive(String hasReceive) {
            this.hasReceive = hasReceive;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public AnsRedPacketBean getAnsRedPacket() {
            return ansRedPacket;
        }

        public void setAnsRedPacket(AnsRedPacketBean ansRedPacket) {
            this.ansRedPacket = ansRedPacket;
        }

        public static class AnsRedPacketBean {
            /**
             * id : e222e374ebad4a68859969469248151c
             * isNewRecord : false
             * remarks : null
             * createDate : 2018-08-23 08:43:33
             * updateDate : 2018-08-23 08:43:33
             * startDate : null
             * endDate : null
             * redPacketName : 首单
             * getTimeFrom : 2018-08-03 00:00:00
             * getTimeEnd : 2018-08-25 00:00:00
             * useTimeFrom : 2018-08-04 00:00:00
             * useTimeEnd : 2018-08-29 00:00:00
             * userType : 0
             * platformType : 0
             * createType : 0
             * activityRule : 首单领取
             * redPacketTemplate : 0
             * templateHeadTitle : 恭喜获得首单红包
             * templateButtonTitle : 去消费吧
             * templateClickTrigger : 1
             * templateIfOpen : 0
             * openHeadTitle : 恭喜获得首单红包
             * openBottomTitle : 首次下单还可获得
             * openButtonTitle : 点击吧
             * openClickTrigger : 1
             * enableFlag : 1
             * maxMoney : 30.0
             * redPacketMoney : null
             * columnList : []
             */

            private String id;
            private boolean isNewRecord;
            private Object remarks;
            private String createDate;
            private String updateDate;
            private Object startDate;
            private Object endDate;
            private String redPacketName;
            private String getTimeFrom;
            private String getTimeEnd;
            private String useTimeFrom;
            private String useTimeEnd;
            private String userType;
            private String platformType;
            private String createType;
            private String activityRule;
            private String redPacketTemplate;
            private String templateHeadTitle;
            private String templateButtonTitle;
            private String templateClickTrigger;
            private String templateIfOpen;
            private String openHeadTitle;
            private String openBottomTitle;
            private String openButtonTitle;
            private String openClickTrigger;
            private String enableFlag;
            private String maxMoney;
            private String redPacketMoney;
            private List<?> columnList;

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

            public String getRedPacketName() {
                return redPacketName;
            }

            public void setRedPacketName(String redPacketName) {
                this.redPacketName = redPacketName;
            }

            public String getGetTimeFrom() {
                return getTimeFrom;
            }

            public void setGetTimeFrom(String getTimeFrom) {
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

            public String getUseTimeEnd() {
                return useTimeEnd;
            }

            public void setUseTimeEnd(String useTimeEnd) {
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

            public String getTemplateButtonTitle() {
                return templateButtonTitle;
            }

            public void setTemplateButtonTitle(String templateButtonTitle) {
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

            public String getMaxMoney() {
                return maxMoney;
            }

            public void setMaxMoney(String maxMoney) {
                this.maxMoney = maxMoney;
            }

            public String getRedPacketMoney() {
                return redPacketMoney;
            }

            public void setRedPacketMoney(String redPacketMoney) {
                this.redPacketMoney = redPacketMoney;
            }

            public List<?> getColumnList() {
                return columnList;
            }

            public void setColumnList(List<?> columnList) {
                this.columnList = columnList;
            }
        }
    }
}
