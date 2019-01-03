package com.ainisi.queenmirror.queenmirrorcduan.bean;

/**
 * Created by john on 2018/8/14.
 */

public class QueenCardStatueBean {


    /**
     * success : true
     * errorCode : 0
     * msg : 获取数据成功
     * body : {"memberStatus":"is","endTime":"2018年09月20日 17:06","ansQueenMemberInfo":{"id":"eb412bf2d3ca48aa8d5aa94aff474051","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"custId":"1b44842d74044291b710f925e16781f6","beginTime":1534237603000,"endTime":1537434403000,"memberLevel":null,"currentGrowth":null,"nextGrowth":null,"updatePgm":"ApiPurchaseMemberService"}}
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
         * memberStatus : is
         * endTime : 2018年09月20日 17:06
         * ansQueenMemberInfo : {"id":"eb412bf2d3ca48aa8d5aa94aff474051","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"custId":"1b44842d74044291b710f925e16781f6","beginTime":1534237603000,"endTime":1537434403000,"memberLevel":null,"currentGrowth":null,"nextGrowth":null,"updatePgm":"ApiPurchaseMemberService"}
         */

        private String memberStatus;
        private String endTime;
        private AnsQueenMemberInfoBean ansQueenMemberInfo;

        public String getMemberStatus() {
            return memberStatus;
        }

        public void setMemberStatus(String memberStatus) {
            this.memberStatus = memberStatus;
        }

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }

        public AnsQueenMemberInfoBean getAnsQueenMemberInfo() {
            return ansQueenMemberInfo;
        }

        public void setAnsQueenMemberInfo(AnsQueenMemberInfoBean ansQueenMemberInfo) {
            this.ansQueenMemberInfo = ansQueenMemberInfo;
        }

        public static class AnsQueenMemberInfoBean {
            /**
             * id : eb412bf2d3ca48aa8d5aa94aff474051
             * isNewRecord : false
             * remarks : null
             * createDate : null
             * updateDate : null
             * startDate : null
             * endDate : null
             * custId : 1b44842d74044291b710f925e16781f6
             * beginTime : 1534237603000
             * endTime : 1537434403000
             * memberLevel : null
             * currentGrowth : null
             * nextGrowth : null
             * updatePgm : ApiPurchaseMemberService
             */

            private String id;
            private boolean isNewRecord;
            private Object remarks;
            private Object createDate;
            private Object updateDate;
            private Object startDate;
            private Object endDate;
            private String custId;
            private long beginTime;
            private long endTime;
            private Object memberLevel;
            private Object currentGrowth;
            private Object nextGrowth;
            private String updatePgm;

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

            public String getCustId() {
                return custId;
            }

            public void setCustId(String custId) {
                this.custId = custId;
            }

            public long getBeginTime() {
                return beginTime;
            }

            public void setBeginTime(long beginTime) {
                this.beginTime = beginTime;
            }

            public long getEndTime() {
                return endTime;
            }

            public void setEndTime(long endTime) {
                this.endTime = endTime;
            }

            public Object getMemberLevel() {
                return memberLevel;
            }

            public void setMemberLevel(Object memberLevel) {
                this.memberLevel = memberLevel;
            }

            public Object getCurrentGrowth() {
                return currentGrowth;
            }

            public void setCurrentGrowth(Object currentGrowth) {
                this.currentGrowth = currentGrowth;
            }

            public Object getNextGrowth() {
                return nextGrowth;
            }

            public void setNextGrowth(Object nextGrowth) {
                this.nextGrowth = nextGrowth;
            }

            public String getUpdatePgm() {
                return updatePgm;
            }

            public void setUpdatePgm(String updatePgm) {
                this.updatePgm = updatePgm;
            }
        }
    }
}
