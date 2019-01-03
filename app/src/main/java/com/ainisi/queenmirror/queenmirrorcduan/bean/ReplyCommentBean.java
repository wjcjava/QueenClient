package com.ainisi.queenmirror.queenmirrorcduan.bean;

import java.util.List;

public class ReplyCommentBean {


    /**
     * success : true
     * errorCode : 0
     * msg : 获取数据成功
     * body : {"apiEcAppraiseReplyList":[{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"ecAppraiseReply":{"id":"a34838a82fe74ec0b8fd5edab31ba38e","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"appraiseId":"abb2ee94d60d4e00a6f94f9feed0081c","objectId":"abb2ee94d60d4e00a6f94f9feed0081c","replyContent":"这个商品是verygood啊","replyFrom":"2","replyUser":"784c86c5a355436b9e169ac3b40651d4","objectUser":"6f2f98dc426646f7adf978637e3e077a","replyTime":"2018-04-25 00:00:00"},"replyUserName":null,"objectUserName":null}]}
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
        private List<ApiEcAppraiseReplyListBean> apiEcAppraiseReplyList;

        public List<ApiEcAppraiseReplyListBean> getApiEcAppraiseReplyList() {
            return apiEcAppraiseReplyList;
        }

        public void setApiEcAppraiseReplyList(List<ApiEcAppraiseReplyListBean> apiEcAppraiseReplyList) {
            this.apiEcAppraiseReplyList = apiEcAppraiseReplyList;
        }

        public static class ApiEcAppraiseReplyListBean {
            /**
             * id : null
             * isNewRecord : true
             * remarks : null
             * createDate : null
             * updateDate : null
             * ecAppraiseReply : {"id":"a34838a82fe74ec0b8fd5edab31ba38e","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"appraiseId":"abb2ee94d60d4e00a6f94f9feed0081c","objectId":"abb2ee94d60d4e00a6f94f9feed0081c","replyContent":"这个商品是verygood啊","replyFrom":"2","replyUser":"784c86c5a355436b9e169ac3b40651d4","objectUser":"6f2f98dc426646f7adf978637e3e077a","replyTime":"2018-04-25 00:00:00"}
             * replyUserName : null
             * objectUserName : null
             */

            private Object id;
            private boolean isNewRecord;
            private Object remarks;
            private Object createDate;
            private Object updateDate;
            private EcAppraiseReplyBean ecAppraiseReply;
            private String replyUserName;
            private String objectUserName;

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

            public EcAppraiseReplyBean getEcAppraiseReply() {
                return ecAppraiseReply;
            }

            public void setEcAppraiseReply(EcAppraiseReplyBean ecAppraiseReply) {
                this.ecAppraiseReply = ecAppraiseReply;
            }

            public String getReplyUserName() {
                return replyUserName;
            }

            public void setReplyUserName(String replyUserName) {
                this.replyUserName = replyUserName;
            }

            public String getObjectUserName() {
                return objectUserName;
            }

            public void setObjectUserName(String objectUserName) {
                this.objectUserName = objectUserName;
            }

            public static class EcAppraiseReplyBean {
                /**
                 * id : a34838a82fe74ec0b8fd5edab31ba38e
                 * isNewRecord : false
                 * remarks : null
                 * createDate : null
                 * updateDate : null
                 * appraiseId : abb2ee94d60d4e00a6f94f9feed0081c
                 * objectId : abb2ee94d60d4e00a6f94f9feed0081c
                 * replyContent : 这个商品是verygood啊
                 * replyFrom : 2
                 * replyUser : 784c86c5a355436b9e169ac3b40651d4
                 * objectUser : 6f2f98dc426646f7adf978637e3e077a
                 * replyTime : 2018-04-25 00:00:00
                 */

                private String id;
                private boolean isNewRecord;
                private Object remarks;
                private Object createDate;
                private Object updateDate;
                private String appraiseId;
                private String objectId;
                private String replyContent;
                private String replyFrom;
                private String replyUser;
                private String objectUser;
                private String replyTime;

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

                public String getAppraiseId() {
                    return appraiseId;
                }

                public void setAppraiseId(String appraiseId) {
                    this.appraiseId = appraiseId;
                }

                public String getObjectId() {
                    return objectId;
                }

                public void setObjectId(String objectId) {
                    this.objectId = objectId;
                }

                public String getReplyContent() {
                    return replyContent;
                }

                public void setReplyContent(String replyContent) {
                    this.replyContent = replyContent;
                }

                public String getReplyFrom() {
                    return replyFrom;
                }

                public void setReplyFrom(String replyFrom) {
                    this.replyFrom = replyFrom;
                }

                public String getReplyUser() {
                    return replyUser;
                }

                public void setReplyUser(String replyUser) {
                    this.replyUser = replyUser;
                }

                public String getObjectUser() {
                    return objectUser;
                }

                public void setObjectUser(String objectUser) {
                    this.objectUser = objectUser;
                }

                public String getReplyTime() {
                    return replyTime;
                }

                public void setReplyTime(String replyTime) {
                    this.replyTime = replyTime;
                }
            }
        }
    }
}
