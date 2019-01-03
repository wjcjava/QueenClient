package com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean;

import java.util.List;

/**
 * Created by john on 2018/5/11.
 */

public class HomeMessageBean {

    /**
     * success : true
     * errorCode : 0
     * msg : 存在消息类型数据
     * body : {"MessageTypeListData":[{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"dict":{"id":"05c136b4b3574643b6e06bd0954cf6f5","isNewRecord":false,"remarks":"","createDate":"2018-04-17 14:42:59","updateDate":"2018-04-17 14:42:59","value":"2","label":"订单消息","type":"ans_mess_type","description":"消息类型","sort":11,"parentId":null}},{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"dict":{"id":"830213fc3de34680b739d8366384c954","isNewRecord":false,"remarks":"","createDate":"2018-04-17 14:43:15","updateDate":"2018-04-17 14:43:15","value":"3","label":"互动消息","type":"ans_mess_type","description":"消息类型","sort":21,"parentId":null}},{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"dict":{"id":"87ba3f344a294bdcb3017e896c378593","isNewRecord":false,"remarks":"","createDate":"2018-04-17 14:42:45","updateDate":"2018-04-17 14:42:45","value":"1","label":"系统消息","type":"ans_mess_type","description":"消息类型","sort":1,"parentId":null}},{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"dict":{"id":"977576921df34a11a639d59d68d2f0c8","isNewRecord":false,"remarks":"","createDate":"2018-04-17 14:43:29","updateDate":"2018-04-17 14:43:29","value":"4","label":"点评消息","type":"ans_mess_type","description":"消息类型","sort":31,"parentId":null}}]}
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
        private List<MessageTypeListDataBean> MessageTypeListData;

        public List<MessageTypeListDataBean> getMessageTypeListData() {
            return MessageTypeListData;
        }

        public void setMessageTypeListData(List<MessageTypeListDataBean> MessageTypeListData) {
            this.MessageTypeListData = MessageTypeListData;
        }

        public static class MessageTypeListDataBean {
            /**
             * id : null
             * isNewRecord : true
             * remarks : null
             * createDate : null
             * updateDate : null
             * dict : {"id":"05c136b4b3574643b6e06bd0954cf6f5","isNewRecord":false,"remarks":"","createDate":"2018-04-17 14:42:59","updateDate":"2018-04-17 14:42:59","value":"2","label":"订单消息","type":"ans_mess_type","description":"消息类型","sort":11,"parentId":null}
             */

            private Object id;
            private boolean isNewRecord;
            private Object remarks;
            private Object createDate;
            private Object updateDate;
            private DictBean dict;

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

            public DictBean getDict() {
                return dict;
            }

            public void setDict(DictBean dict) {
                this.dict = dict;
            }

            public static class DictBean {
                /**
                 * id : 05c136b4b3574643b6e06bd0954cf6f5
                 * isNewRecord : false
                 * remarks :
                 * createDate : 2018-04-17 14:42:59
                 * updateDate : 2018-04-17 14:42:59
                 * value : 2
                 * label : 订单消息
                 * type : ans_mess_type
                 * description : 消息类型
                 * sort : 11
                 * parentId : null
                 */

                private String id;
                private boolean isNewRecord;
                private String remarks;
                private String createDate;
                private String updateDate;
                private String value;
                private String label;
                private String type;
                private String description;
                private int sort;
                private Object parentId;

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

                public String getRemarks() {
                    return remarks;
                }

                public void setRemarks(String remarks) {
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

                public int getSort() {
                    return sort;
                }

                public void setSort(int sort) {
                    this.sort = sort;
                }

                public Object getParentId() {
                    return parentId;
                }

                public void setParentId(Object parentId) {
                    this.parentId = parentId;
                }
            }
        }
    }
}
