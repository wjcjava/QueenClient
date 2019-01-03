package com.ainisi.queenmirror.queenmirrorcduan.bean;

import java.util.List;

/**
 * Created by john on 2018/8/13.
 */

public class MineQueeenCardPayStyle {


    /**
     * success : true
     * errorCode : 0
     * msg : 获取数据成功
     * body : {"ansQueenMemberTypeList":[{"id":"23157a0995bf42a6a81ac33bf5116364","isNewRecord":false,"remarks":"dads","createDate":"2018-08-13 13:13:23","updateDate":"2018-08-13 13:28:48","startDate":null,"endDate":null,"purchaseDays":"33","givenDays":"7","price":"15.00"}]}
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
        private List<AnsQueenMemberTypeListBean> ansQueenMemberTypeList;

        public List<AnsQueenMemberTypeListBean> getAnsQueenMemberTypeList() {
            return ansQueenMemberTypeList;
        }

        public void setAnsQueenMemberTypeList(List<AnsQueenMemberTypeListBean> ansQueenMemberTypeList) {
            this.ansQueenMemberTypeList = ansQueenMemberTypeList;
        }

        public static class AnsQueenMemberTypeListBean {
            /**
             * id : 23157a0995bf42a6a81ac33bf5116364
             * isNewRecord : false
             * remarks : dads
             * createDate : 2018-08-13 13:13:23
             * updateDate : 2018-08-13 13:28:48
             * startDate : null
             * endDate : null
             * purchaseDays : 33
             * givenDays : 7
             * price : 15.00
             */

            private String id;
            private boolean isNewRecord;
            private String remarks;
            private String createDate;
            private String updateDate;
            private Object startDate;
            private Object endDate;
            private String purchaseDays;
            private String givenDays;
            private String price;

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

            public String getPurchaseDays() {
                return purchaseDays;
            }

            public void setPurchaseDays(String purchaseDays) {
                this.purchaseDays = purchaseDays;
            }

            public String getGivenDays() {
                return givenDays;
            }

            public void setGivenDays(String givenDays) {
                this.givenDays = givenDays;
            }

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }
        }
    }
}
