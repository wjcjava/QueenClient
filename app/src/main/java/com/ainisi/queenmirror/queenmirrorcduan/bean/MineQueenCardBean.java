package com.ainisi.queenmirror.queenmirrorcduan.bean;

import java.util.List;

/**
 * Created by john on 2018/8/14.
 */

public class MineQueenCardBean {


    /**
     * success : true
     * errorCode : 0
     * msg : 成功
     * body : {"list":[{"id":"6d8b397c9d594221bfedcd7e36b63b99","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"royaltyName":"会员礼包","icon":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/%E5%A5%B3%E7%8E%8B%E7%89%B9%E6%9D%832.png","content":"待定"},{"id":"a17106e5a08246e88527b0e16f2c0c4d","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"royaltyName":"女王折扣","icon":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/%E5%A5%B3%E7%8E%8B%E7%89%B9%E6%9D%831.png","content":"待定"}]}
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
        private List<ListBean> list;

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * id : 6d8b397c9d594221bfedcd7e36b63b99
             * isNewRecord : false
             * remarks : null
             * createDate : null
             * updateDate : null
             * startDate : null
             * endDate : null
             * royaltyName : 会员礼包
             * icon : https://nwptest.oss-cn-hangzhou.aliyuncs.com/%E5%A5%B3%E7%8E%8B%E7%89%B9%E6%9D%832.png
             * content : 待定
             */

            private String id;
            private boolean isNewRecord;
            private Object remarks;
            private Object createDate;
            private Object updateDate;
            private Object startDate;
            private Object endDate;
            private String royaltyName;
            private String icon;
            private String content;

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

            public String getRoyaltyName() {
                return royaltyName;
            }

            public void setRoyaltyName(String royaltyName) {
                this.royaltyName = royaltyName;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }
        }
    }
}
