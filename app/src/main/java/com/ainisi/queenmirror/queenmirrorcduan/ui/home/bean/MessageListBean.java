package com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean;

import java.util.List;

/**
 * Created by john on 2018/5/11.
 */

public class MessageListBean {

    /**
     * success : true
     * errorCode : 0
     * msg : 存在消息数据
     * body : {"MessageListData":[{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"ecMessageObject":{"id":"20712244211240f0a5c3a1484499b5d9","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"messId":"0f393dea8fad42a691573aff1b00e20e","custId":"12421","ifRead":"1","readTime":"2018-05-04 16:50:16"},"ecSysMessage":{"id":"0f393dea8fad42a691573aff1b00e20e","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"messCategory":"1","messType":"1","templateId":"123","senderId":"小丽","receiverId":"小王","messDetails":"深V舍不得放不放大的奶粉呢","messStatus":"1","sendDate":"2018-04-03 00:00:00"},"ifReadLabel":"是"}]}
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
        private List<MessageListDataBean> MessageListData;

        public List<MessageListDataBean> getMessageListData() {
            return MessageListData;
        }

        public void setMessageListData(List<MessageListDataBean> MessageListData) {
            this.MessageListData = MessageListData;
        }

        public static class MessageListDataBean {
            /**
             * id : null
             * isNewRecord : true
             * remarks : null
             * createDate : null
             * updateDate : null
             * ecMessageObject : {"id":"20712244211240f0a5c3a1484499b5d9","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"messId":"0f393dea8fad42a691573aff1b00e20e","custId":"12421","ifRead":"1","readTime":"2018-05-04 16:50:16"}
             * ecSysMessage : {"id":"0f393dea8fad42a691573aff1b00e20e","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"messCategory":"1","messType":"1","templateId":"123","senderId":"小丽","receiverId":"小王","messDetails":"深V舍不得放不放大的奶粉呢","messStatus":"1","sendDate":"2018-04-03 00:00:00"}
             * ifReadLabel : 是
             */

            private Object id;
            private boolean isNewRecord;
            private Object remarks;
            private Object createDate;
            private Object updateDate;
            private EcMessageObjectBean ecMessageObject;
            private EcSysMessageBean ecSysMessage;
            private String ifReadLabel;

            public Object getId() {
                return id;
            }

            public void setId(Object id) {
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

            public Object getCreateDate() {
                return createDate;
            }

            public void setCreateDate(Object createDate) {
                this.createDate = createDate;
            }

            public Object getUpdateDate() {
                return updateDate;
            }

            public void setUpdateDate(Object updateDate) {
                this.updateDate = updateDate;
            }

            public EcMessageObjectBean getEcMessageObject() {
                return ecMessageObject;
            }

            public void setEcMessageObject(EcMessageObjectBean ecMessageObject) {
                this.ecMessageObject = ecMessageObject;
            }

            public EcSysMessageBean getEcSysMessage() {
                return ecSysMessage;
            }

            public void setEcSysMessage(EcSysMessageBean ecSysMessage) {
                this.ecSysMessage = ecSysMessage;
            }

            public String getIfReadLabel() {
                return ifReadLabel;
            }

            public void setIfReadLabel(String ifReadLabel) {
                this.ifReadLabel = ifReadLabel;
            }

            public static class EcMessageObjectBean {
                /**
                 * id : 20712244211240f0a5c3a1484499b5d9
                 * isNewRecord : false
                 * remarks : null
                 * createDate : null
                 * updateDate : null
                 * messId : 0f393dea8fad42a691573aff1b00e20e
                 * custId : 12421
                 * ifRead : 1
                 * readTime : 2018-05-04 16:50:16
                 */

                private String id;
                private boolean isNewRecord;
                private Object remarks;
                private Object createDate;
                private Object updateDate;
                private String messId;
                private String custId;
                private String ifRead;
                private String readTime;

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

                public Object getCreateDate() {
                    return createDate;
                }

                public void setCreateDate(Object createDate) {
                    this.createDate = createDate;
                }

                public Object getUpdateDate() {
                    return updateDate;
                }

                public void setUpdateDate(Object updateDate) {
                    this.updateDate = updateDate;
                }

                public String getMessId() {
                    return messId;
                }

                public void setMessId(String messId) {
                    this.messId = messId;
                }

                public String getCustId() {
                    return custId;
                }

                public void setCustId(String custId) {
                    this.custId = custId;
                }

                public String getIfRead() {
                    return ifRead;
                }

                public void setIfRead(String ifRead) {
                    this.ifRead = ifRead;
                }

                public String getReadTime() {
                    return readTime;
                }

                public void setReadTime(String readTime) {
                    this.readTime = readTime;
                }
            }

            public static class EcSysMessageBean {
                /**
                 * id : 0f393dea8fad42a691573aff1b00e20e
                 * isNewRecord : false
                 * remarks : null
                 * createDate : null
                 * updateDate : null
                 * messCategory : 1
                 * messType : 1
                 * templateId : 123
                 * senderId : 小丽
                 * receiverId : 小王
                 * messDetails : 深V舍不得放不放大的奶粉呢
                 * messStatus : 1
                 * sendDate : 2018-04-03 00:00:00
                 */

                private String id;
                private boolean isNewRecord;
                private Object remarks;
                private Object createDate;
                private Object updateDate;
                private String messCategory;
                private String messType;
                private String templateId;
                private String senderId;
                private String receiverId;
                private String messDetails;
                private String messStatus;
                private String sendDate;

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

                public Object getCreateDate() {
                    return createDate;
                }

                public void setCreateDate(Object createDate) {
                    this.createDate = createDate;
                }

                public Object getUpdateDate() {
                    return updateDate;
                }

                public void setUpdateDate(Object updateDate) {
                    this.updateDate = updateDate;
                }

                public String getMessCategory() {
                    return messCategory;
                }

                public void setMessCategory(String messCategory) {
                    this.messCategory = messCategory;
                }

                public String getMessType() {
                    return messType;
                }

                public void setMessType(String messType) {
                    this.messType = messType;
                }

                public String getTemplateId() {
                    return templateId;
                }

                public void setTemplateId(String templateId) {
                    this.templateId = templateId;
                }

                public String getSenderId() {
                    return senderId;
                }

                public void setSenderId(String senderId) {
                    this.senderId = senderId;
                }

                public String getReceiverId() {
                    return receiverId;
                }

                public void setReceiverId(String receiverId) {
                    this.receiverId = receiverId;
                }

                public String getMessDetails() {
                    return messDetails;
                }

                public void setMessDetails(String messDetails) {
                    this.messDetails = messDetails;
                }

                public String getMessStatus() {
                    return messStatus;
                }

                public void setMessStatus(String messStatus) {
                    this.messStatus = messStatus;
                }

                public String getSendDate() {
                    return sendDate;
                }

                public void setSendDate(String sendDate) {
                    this.sendDate = sendDate;
                }
            }
        }
    }
}
