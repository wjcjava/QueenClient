package com.ainisi.queenmirror.queenmirrorcduan.bean;

/**
 * Created by john on 2018/7/14.
 */

public class CheckApkBean {


    /**
     * success : true
     * errorCode : 0
     * msg : 成功！
     * body : {"ansAndroidVersion":{"id":"c1315387ec3447e5a3c7c58d50dd386c","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"versionNo":"1","downloadUrl":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/app/2018-07-02/1530530121270.apk","forceUpdate":"1","appFlag":"1","updateTime":"2018-07-02","startDateString":null,"endDateString":null}}
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
         * ansAndroidVersion : {"id":"c1315387ec3447e5a3c7c58d50dd386c","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"versionNo":"1","downloadUrl":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/app/2018-07-02/1530530121270.apk","forceUpdate":"1","appFlag":"1","updateTime":"2018-07-02","startDateString":null,"endDateString":null}
         */

        private AnsAndroidVersionBean ansAndroidVersion;

        public AnsAndroidVersionBean getAnsAndroidVersion() {
            return ansAndroidVersion;
        }

        public void setAnsAndroidVersion(AnsAndroidVersionBean ansAndroidVersion) {
            this.ansAndroidVersion = ansAndroidVersion;
        }

        public static class AnsAndroidVersionBean {
            /**
             * id : c1315387ec3447e5a3c7c58d50dd386c
             * isNewRecord : false
             * remarks : null
             * createDate : null
             * updateDate : null
             * startDate : null
             * endDate : null
             * versionNo : 1
             * downloadUrl : https://nwptest.oss-cn-hangzhou.aliyuncs.com/app/2018-07-02/1530530121270.apk
             * forceUpdate : 1
             * appFlag : 1
             * updateTime : 2018-07-02
             * startDateString : null
             * endDateString : null
             */

            private String id;
            private boolean isNewRecord;
            private String remarks;
            private String createDate;
            private String updateDate;
            private String startDate;
            private String endDate;
            private String versionNo;
            private String downloadUrl;
            private String forceUpdate;
            private String appFlag;
            private String updateTime;
            private String startDateString;
            private String endDateString;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public boolean isNewRecord() {
                return isNewRecord;
            }

            public void setNewRecord(boolean newRecord) {
                isNewRecord = newRecord;
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

            public String getStartDate() {
                return startDate;
            }

            public void setStartDate(String startDate) {
                this.startDate = startDate;
            }

            public String getEndDate() {
                return endDate;
            }

            public void setEndDate(String endDate) {
                this.endDate = endDate;
            }

            public String getVersionNo() {
                return versionNo;
            }

            public void setVersionNo(String versionNo) {
                this.versionNo = versionNo;
            }

            public String getDownloadUrl() {
                return downloadUrl;
            }

            public void setDownloadUrl(String downloadUrl) {
                this.downloadUrl = downloadUrl;
            }

            public String getForceUpdate() {
                return forceUpdate;
            }

            public void setForceUpdate(String forceUpdate) {
                this.forceUpdate = forceUpdate;
            }

            public String getAppFlag() {
                return appFlag;
            }

            public void setAppFlag(String appFlag) {
                this.appFlag = appFlag;
            }

            public String getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(String updateTime) {
                this.updateTime = updateTime;
            }

            public String getStartDateString() {
                return startDateString;
            }

            public void setStartDateString(String startDateString) {
                this.startDateString = startDateString;
            }

            public String getEndDateString() {
                return endDateString;
            }

            public void setEndDateString(String endDateString) {
                this.endDateString = endDateString;
            }
        }
    }
}
