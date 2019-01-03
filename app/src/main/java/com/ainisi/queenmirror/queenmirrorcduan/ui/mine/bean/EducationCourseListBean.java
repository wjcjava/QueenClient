package com.ainisi.queenmirror.queenmirrorcduan.ui.mine.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by jiangchao on 2018/9/10 上午10:44.
 */


public class EducationCourseListBean {


    /**
     * success : true
     * errorCode : 0
     * msg : 成功
     * body : {"classList":[{"id":"a01c7821c25b408785b8e4d3b641a311","isNewRecord":false,"remarks":"","createDate":"2018-09-25 11:20:30","updateDate":"2018-09-25 17:56:42","startDate":null,"endDate":null,"enableFlag":"1","className":"0925","classCover":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/img/2018-09-25/1537845600408.png","majorId":"5bc9b585870c4a7ea26b8a81f9d2ef85","videoIds":null,"videoTitles":null,"majorName":null,"videoList":null,"playNums":0},{"id":"aaff54033e2c4e6987a53673d1fdf33e","isNewRecord":false,"remarks":"摄影中级教程","createDate":"2018-09-10 10:20:20","updateDate":"2018-09-10 10:30:36","startDate":null,"endDate":null,"enableFlag":"1","className":"摄影中级教程","classCover":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/img/2018-09-10/1536545991271.png","majorId":"3d2036f29e434351a0c42884cbbd5bee","videoIds":null,"videoTitles":null,"majorName":null,"videoList":null,"playNums":0}]}
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
        private List<ClassListEntity> classList;

        public List<ClassListEntity> getClassList() {
            return classList;
        }

        public void setClassList(List<ClassListEntity> classList) {
            this.classList = classList;
        }

        public static class ClassListEntity implements Serializable{
            /**
             * id : a01c7821c25b408785b8e4d3b641a311
             * isNewRecord : false
             * remarks :
             * createDate : 2018-09-25 11:20:30
             * updateDate : 2018-09-25 17:56:42
             * startDate : null
             * endDate : null
             * enableFlag : 1
             * className : 0925
             * classCover : https://nwptest.oss-cn-hangzhou.aliyuncs.com/img/2018-09-25/1537845600408.png
             * majorId : 5bc9b585870c4a7ea26b8a81f9d2ef85
             * videoIds : null
             * videoTitles : null
             * majorName : null
             * videoList : null
             * playNums : 0
             */

            private String id;
            private boolean isNewRecord;
            private String remarks;
            private String createDate;
            private String updateDate;
            private String startDate;
            private String endDate;
            private String enableFlag;
            private String className;
            private String classCover;
            private String majorId;
            private String videoIds;
            private String videoTitles;
            private String majorName;
            private String videoList;
            private int playNums;

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

            public String getClassName() {
                return className;
            }

            public void setClassName(String className) {
                this.className = className;
            }

            public String getClassCover() {
                return classCover;
            }

            public void setClassCover(String classCover) {
                this.classCover = classCover;
            }

            public String getMajorId() {
                return majorId;
            }

            public void setMajorId(String majorId) {
                this.majorId = majorId;
            }

            public String getVideoIds() {
                return videoIds;
            }

            public void setVideoIds(String videoIds) {
                this.videoIds = videoIds;
            }

            public String getVideoTitles() {
                return videoTitles;
            }

            public void setVideoTitles(String videoTitles) {
                this.videoTitles = videoTitles;
            }

            public String getMajorName() {
                return majorName;
            }

            public void setMajorName(String majorName) {
                this.majorName = majorName;
            }

            public String getVideoList() {
                return videoList;
            }

            public void setVideoList(String videoList) {
                this.videoList = videoList;
            }

            public int getPlayNums() {
                return playNums;
            }

            public void setPlayNums(int playNums) {
                this.playNums = playNums;
            }
        }
    }
}
