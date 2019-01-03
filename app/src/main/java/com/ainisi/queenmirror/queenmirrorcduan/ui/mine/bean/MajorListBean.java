package com.ainisi.queenmirror.queenmirrorcduan.ui.mine.bean;

import java.util.List;

/**
 * Created by jiangchao on 2018/9/5 下午3:14.
 */


public class MajorListBean {

    /**
     * success : true
     * errorCode : 0
     * msg : 成功
     * body : {"majorList":[{"id":"a0d6aa40485c4ad494121500fb64bf42","isNewRecord":false,"remarks":"美容美发专业好","createDate":"2018-09-04 08:48:00","updateDate":"2018-09-04 14:54:53","startDate":null,"endDate":null,"enableFlag":"1","majorName":"美容美发专业","majorIcon":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/img/2018-09-04/1536044084648.png","majorIconSelect":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/img/2018-09-04/1536044091458.png","classId":null,"videoNums":null},{"id":"0c2b34934ad542ca9a826c1e5ef1cce4","isNewRecord":false,"remarks":"美甲专业","createDate":"2018-09-04 08:48:59","updateDate":"2018-09-04 14:55:36","startDate":null,"endDate":null,"enableFlag":"1","majorName":"美甲专业","majorIcon":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/img/2018-09-04/1536044126789.png","majorIconSelect":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/img/2018-09-04/1536044134466.png","classId":null,"videoNums":null},{"id":"26fb53a301804b04a4d94e85bfa482e2","isNewRecord":false,"remarks":"纹身专业","createDate":"2018-09-04 08:48:41","updateDate":"2018-09-04 14:55:14","startDate":null,"endDate":null,"enableFlag":"1","majorName":"纹身专业","majorIcon":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/img/2018-09-04/1536044105296.png","majorIconSelect":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/img/2018-09-04/1536044112396.png","classId":null,"videoNums":null}]}
     */

    private boolean success;
    private String errorCode;
    private String msg;
    private BodyEntity body;

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

    public BodyEntity getBody() {
        return body;
    }

    public void setBody(BodyEntity body) {
        this.body = body;
    }

    public static class BodyEntity {
        private List<MajorListEntity> majorList;

        public List<MajorListEntity> getMajorList() {
            return majorList;
        }

        public void setMajorList(List<MajorListEntity> majorList) {
            this.majorList = majorList;
        }

        public static class MajorListEntity {
            /**
             * id : a0d6aa40485c4ad494121500fb64bf42
             * isNewRecord : false
             * remarks : 美容美发专业好
             * createDate : 2018-09-04 08:48:00
             * updateDate : 2018-09-04 14:54:53
             * startDate : null
             * endDate : null
             * enableFlag : 1
             * majorName : 美容美发专业
             * majorIcon : https://nwptest.oss-cn-hangzhou.aliyuncs.com/img/2018-09-04/1536044084648.png
             * majorIconSelect : https://nwptest.oss-cn-hangzhou.aliyuncs.com/img/2018-09-04/1536044091458.png
             * classId : null
             * videoNums : null
             */

            private String id;
            private boolean isNewRecord;
            private String remarks;
            private String createDate;
            private String updateDate;
            private String startDate;
            private String endDate;
            private String enableFlag;
            private String majorName;
            private String majorIcon;
            private String majorIconSelect;
            private String classId;
            private String videoNums;

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

            public String getEnableFlag() {
                return enableFlag;
            }

            public void setEnableFlag(String enableFlag) {
                this.enableFlag = enableFlag;
            }

            public String getMajorName() {
                return majorName;
            }

            public void setMajorName(String majorName) {
                this.majorName = majorName;
            }

            public String getMajorIcon() {
                return majorIcon;
            }

            public void setMajorIcon(String majorIcon) {
                this.majorIcon = majorIcon;
            }

            public String getMajorIconSelect() {
                return majorIconSelect;
            }

            public void setMajorIconSelect(String majorIconSelect) {
                this.majorIconSelect = majorIconSelect;
            }

            public String getClassId() {
                return classId;
            }

            public void setClassId(String classId) {
                this.classId = classId;
            }

            public String getVideoNums() {
                return videoNums;
            }

            public void setVideoNums(String videoNums) {
                this.videoNums = videoNums;
            }
        }
    }
}
