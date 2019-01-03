package com.ainisi.queenmirror.queenmirrorcduan.bean;

import java.util.List;

/**
 * Created by john on 2018/7/4.
 */

public class NewsMessageSystemBean {


    /**
     * success : true
     * errorCode : 0
     * msg : 成功
     * body : {"messList":[{"id":"0257a0ecac44487c97c9e22ada961aa8","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"messId":"a483fea17ce5492591a63b2c038eaabb","messType":"5","receiverObject":"1","senderId":"??","receiverId":"94e5b1e26d7345c78fc069c6797b824c","ifRead":"1","messDetails":"","sendDate":"2018-07-02 19:43:34.0"},{"id":"0257a0ecac44487c97c9e22ada961aa8","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"messId":"a483fea17ce5492591a63b2c038eaabb","messType":"5","receiverObject":"1","senderId":"群发","receiverId":"94e5b1e26d7345c78fc069c6797b824c","ifRead":"1","messDetails":"{\"bannerStyle\":\"2\",\"content\":\"测试推送222\",\"bannerId\":\"88bcc5b13511469cab74fb4b38cedb65\"}","sendDate":"2018-07-02 17:46:06.0"},{"id":"0257a0ecac44487c97c9e22ada961aa8","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"messId":"a483fea17ce5492591a63b2c038eaabb","messType":"5","receiverObject":"1","senderId":"群发","receiverId":"94e5b1e26d7345c78fc069c6797b824c","ifRead":"1","messDetails":"{\"bannerStyle\":\"2\",\"content\":\"这是个活动测试推送\",\"bannerId\":\"0461ddea518d4d08abb1d842a1f306e2\"}","sendDate":"2018-06-28 16:09:52.0"},{"id":"0257a0ecac44487c97c9e22ada961aa8","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"messId":"a483fea17ce5492591a63b2c038eaabb","messType":"1","receiverObject":"1","senderId":"群发","receiverId":"94e5b1e26d7345c78fc069c6797b824c","ifRead":"1","messDetails":"","sendDate":"2018-07-02 20:30:45.0"},{"id":"0257a0ecac44487c97c9e22ada961aa8","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"messId":"a483fea17ce5492591a63b2c038eaabb","messType":"5","receiverObject":"1","senderId":"群发","receiverId":"94e5b1e26d7345c78fc069c6797b824c","ifRead":"1","messDetails":"{\"bannerStyle\":\"2\",\"content\":\"测试推送222\",\"bannerId\":\"88bcc5b13511469cab74fb4b38cedb65\"}","sendDate":"2018-07-02 17:47:01.0"},{"id":"0257a0ecac44487c97c9e22ada961aa8","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"messId":"a483fea17ce5492591a63b2c038eaabb","messType":"5","receiverObject":"1","senderId":"群发","receiverId":"94e5b1e26d7345c78fc069c6797b824c","ifRead":"1","messDetails":"{\"bannerStyle\":\"2\",\"content\":\"测试推送222\",\"bannerId\":\"88bcc5b13511469cab74fb4b38cedb65\"}","sendDate":"2018-07-02 17:29:39.0"},{"id":"0257a0ecac44487c97c9e22ada961aa8","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"messId":"a483fea17ce5492591a63b2c038eaabb","messType":"2","receiverObject":"1","senderId":"sender","receiverId":"94e5b1e26d7345c78fc069c6797b824c","ifRead":"1","messDetails":"【女王魔镜】订单消息，亲，您有新的订单，请及时查收！（测试）","sendDate":"2018-06-29 08:55:11.0"},{"id":"0257a0ecac44487c97c9e22ada961aa8","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"messId":"a483fea17ce5492591a63b2c038eaabb","messType":"5","receiverObject":"1","senderId":"群发","receiverId":"94e5b1e26d7345c78fc069c6797b824c","ifRead":"1","messDetails":"{\"bannerStyle\":\"2\",\"content\":\"测试推送222\",\"bannerId\":\"88bcc5b13511469cab74fb4b38cedb65\"}","sendDate":"2018-07-02 17:24:28.0"},{"id":"02df0b8cace14000b978feb876d94dfc","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"messId":"ee5d656af78a4d7096636ab11e021629","messType":"5","receiverObject":"1","senderId":"??","receiverId":"群发","ifRead":"1","messDetails":"","sendDate":"2018-07-02 19:43:34.0"},{"id":"02df0b8cace14000b978feb876d94dfc","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"messId":"ee5d656af78a4d7096636ab11e021629","messType":"5","receiverObject":"1","senderId":"群发","receiverId":"群发","ifRead":"1","messDetails":"{\"bannerStyle\":\"2\",\"content\":\"测试推送222\",\"bannerId\":\"88bcc5b13511469cab74fb4b38cedb65\"}","sendDate":"2018-07-02 17:46:06.0"}],"pageSum":761}
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
         * messList : [{"id":"0257a0ecac44487c97c9e22ada961aa8","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"messId":"a483fea17ce5492591a63b2c038eaabb","messType":"5","receiverObject":"1","senderId":"??","receiverId":"94e5b1e26d7345c78fc069c6797b824c","ifRead":"1","messDetails":"","sendDate":"2018-07-02 19:43:34.0"},{"id":"0257a0ecac44487c97c9e22ada961aa8","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"messId":"a483fea17ce5492591a63b2c038eaabb","messType":"5","receiverObject":"1","senderId":"群发","receiverId":"94e5b1e26d7345c78fc069c6797b824c","ifRead":"1","messDetails":"{\"bannerStyle\":\"2\",\"content\":\"测试推送222\",\"bannerId\":\"88bcc5b13511469cab74fb4b38cedb65\"}","sendDate":"2018-07-02 17:46:06.0"},{"id":"0257a0ecac44487c97c9e22ada961aa8","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"messId":"a483fea17ce5492591a63b2c038eaabb","messType":"5","receiverObject":"1","senderId":"群发","receiverId":"94e5b1e26d7345c78fc069c6797b824c","ifRead":"1","messDetails":"{\"bannerStyle\":\"2\",\"content\":\"这是个活动测试推送\",\"bannerId\":\"0461ddea518d4d08abb1d842a1f306e2\"}","sendDate":"2018-06-28 16:09:52.0"},{"id":"0257a0ecac44487c97c9e22ada961aa8","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"messId":"a483fea17ce5492591a63b2c038eaabb","messType":"1","receiverObject":"1","senderId":"群发","receiverId":"94e5b1e26d7345c78fc069c6797b824c","ifRead":"1","messDetails":"","sendDate":"2018-07-02 20:30:45.0"},{"id":"0257a0ecac44487c97c9e22ada961aa8","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"messId":"a483fea17ce5492591a63b2c038eaabb","messType":"5","receiverObject":"1","senderId":"群发","receiverId":"94e5b1e26d7345c78fc069c6797b824c","ifRead":"1","messDetails":"{\"bannerStyle\":\"2\",\"content\":\"测试推送222\",\"bannerId\":\"88bcc5b13511469cab74fb4b38cedb65\"}","sendDate":"2018-07-02 17:47:01.0"},{"id":"0257a0ecac44487c97c9e22ada961aa8","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"messId":"a483fea17ce5492591a63b2c038eaabb","messType":"5","receiverObject":"1","senderId":"群发","receiverId":"94e5b1e26d7345c78fc069c6797b824c","ifRead":"1","messDetails":"{\"bannerStyle\":\"2\",\"content\":\"测试推送222\",\"bannerId\":\"88bcc5b13511469cab74fb4b38cedb65\"}","sendDate":"2018-07-02 17:29:39.0"},{"id":"0257a0ecac44487c97c9e22ada961aa8","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"messId":"a483fea17ce5492591a63b2c038eaabb","messType":"2","receiverObject":"1","senderId":"sender","receiverId":"94e5b1e26d7345c78fc069c6797b824c","ifRead":"1","messDetails":"【女王魔镜】订单消息，亲，您有新的订单，请及时查收！（测试）","sendDate":"2018-06-29 08:55:11.0"},{"id":"0257a0ecac44487c97c9e22ada961aa8","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"messId":"a483fea17ce5492591a63b2c038eaabb","messType":"5","receiverObject":"1","senderId":"群发","receiverId":"94e5b1e26d7345c78fc069c6797b824c","ifRead":"1","messDetails":"{\"bannerStyle\":\"2\",\"content\":\"测试推送222\",\"bannerId\":\"88bcc5b13511469cab74fb4b38cedb65\"}","sendDate":"2018-07-02 17:24:28.0"},{"id":"02df0b8cace14000b978feb876d94dfc","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"messId":"ee5d656af78a4d7096636ab11e021629","messType":"5","receiverObject":"1","senderId":"??","receiverId":"群发","ifRead":"1","messDetails":"","sendDate":"2018-07-02 19:43:34.0"},{"id":"02df0b8cace14000b978feb876d94dfc","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"messId":"ee5d656af78a4d7096636ab11e021629","messType":"5","receiverObject":"1","senderId":"群发","receiverId":"群发","ifRead":"1","messDetails":"{\"bannerStyle\":\"2\",\"content\":\"测试推送222\",\"bannerId\":\"88bcc5b13511469cab74fb4b38cedb65\"}","sendDate":"2018-07-02 17:46:06.0"}]
         * pageSum : 761
         */

        private int pageSum;
        private List<MessListBean> messList;

        public int getPageSum() {
            return pageSum;
        }

        public void setPageSum(int pageSum) {
            this.pageSum = pageSum;
        }

        public List<MessListBean> getMessList() {
            return messList;
        }

        public void setMessList(List<MessListBean> messList) {
            this.messList = messList;
        }

        public static class MessListBean {
            /**
             * id : 0257a0ecac44487c97c9e22ada961aa8
             * isNewRecord : false
             * remarks : null
             * createDate : null
             * updateDate : null
             * startDate : null
             * endDate : null
             * messId : a483fea17ce5492591a63b2c038eaabb
             * messType : 5
             * receiverObject : 1
             * senderId : ??
             * receiverId : 94e5b1e26d7345c78fc069c6797b824c
             * ifRead : 1
             * messDetails :
             * sendDate : 2018-07-02 19:43:34.0
             */

            private String id;
            private boolean isNewRecord;
            private Object remarks;
            private Object createDate;
            private Object updateDate;
            private Object startDate;
            private Object endDate;
            private String messId;
            private String messType;
            private String receiverObject;
            private String senderId;
            private String receiverId;
            private String ifRead;
            private String messDetails;
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

            public String getMessId() {
                return messId;
            }

            public void setMessId(String messId) {
                this.messId = messId;
            }

            public String getMessType() {
                return messType;
            }

            public void setMessType(String messType) {
                this.messType = messType;
            }

            public String getReceiverObject() {
                return receiverObject;
            }

            public void setReceiverObject(String receiverObject) {
                this.receiverObject = receiverObject;
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

            public String getIfRead() {
                return ifRead;
            }

            public void setIfRead(String ifRead) {
                this.ifRead = ifRead;
            }

            public String getMessDetails() {
                return messDetails;
            }

            public void setMessDetails(String messDetails) {
                this.messDetails = messDetails;
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
