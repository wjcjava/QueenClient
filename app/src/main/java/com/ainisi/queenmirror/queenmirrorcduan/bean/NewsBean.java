package com.ainisi.queenmirror.queenmirrorcduan.bean;

import java.io.Serializable;
import java.util.List;

public class NewsBean implements Serializable {


    /**
     * success : true
     * errorCode : 0
     * msg : 成功
     * body : {"messTypeList":[{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"value":"2","label":"订单消息","type":"ans_mess_type","description":"消息类型","sort":null,"parentId":null,"msgContent":"【女王魔镜】女王，您的订单：贾氏集团商家已确认服务完成，快来进行评价吧，五星好评更有好礼相送。"},{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"value":"5","label":"活动消息","type":"ans_mess_type","description":"消息类型","sort":null,"parentId":null,"msgContent":"test"},{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"value":"3","label":"互动消息","type":"ans_mess_type","description":"消息类型","sort":null,"parentId":null,"msgContent":"test"},{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"value":"1","label":"系统消息","type":"ans_mess_type","description":"消息类型","sort":null,"parentId":null,"msgContent":"test"},{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"value":"4","label":"点评消息","type":"ans_mess_type","description":"消息类型","sort":null,"parentId":null,"msgContent":"test"}]}
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

    public static class BodyBean implements Serializable{
        private List<MessTypeListBean> messTypeList;

        public List<MessTypeListBean> getMessTypeList() {
            return messTypeList;
        }

        public void setMessTypeList(List<MessTypeListBean> messTypeList) {
            this.messTypeList = messTypeList;
        }

        public static class MessTypeListBean  implements Serializable{
            /**
             * id : null
             * isNewRecord : true
             * remarks : null
             * createDate : null
             * updateDate : null
             * startDate : null
             * endDate : null
             * value : 2
             * label : 订单消息
             * type : ans_mess_type
             * description : 消息类型
             * sort : null
             * parentId : null
             * msgContent : 【女王魔镜】女王，您的订单：贾氏集团商家已确认服务完成，快来进行评价吧，五星好评更有好礼相送。
             */

            private Object id;
            private boolean isNewRecord;
            private Object remarks;
            private Object createDate;
            private Object updateDate;
            private Object startDate;
            private Object endDate;
            private String value;
            private String label;
            private String type;
            private String description;
            private Object sort;
            private Object parentId;
            private String msgContent;

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

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }

            public String getLabel() {
                return label;
            }

            public void setLabel(String label) {
                this.label = label;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public Object getSort() {
                return sort;
            }

            public void setSort(Object sort) {
                this.sort = sort;
            }

            public Object getParentId() {
                return parentId;
            }

            public void setParentId(Object parentId) {
                this.parentId = parentId;
            }

            public String getMsgContent() {
                return msgContent;
            }

            public void setMsgContent(String msgContent) {
                this.msgContent = msgContent;
            }
        }
    }
}
