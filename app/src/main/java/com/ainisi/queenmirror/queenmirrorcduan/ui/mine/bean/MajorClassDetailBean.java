package com.ainisi.queenmirror.queenmirrorcduan.ui.mine.bean;

import java.util.List;

/**
 * Created by jiangchao on 2018/9/7 下午4:46.
 */


public class MajorClassDetailBean {


    /**
     * success : true
     * errorCode : 0
     * msg : 成功
     * body : {"ansSchoolClass":{"id":"27ce1136fad0488c9f13e8e10f34997b","isNewRecord":false,"remarks":"龙哥美容美发精品教程","createDate":"2018-09-04 08:56:33","updateDate":"2018-09-04 08:56:33","startDate":null,"endDate":null,"enableFlag":"1","className":"龙哥美容美发精品教程","classCover":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/img/2018-09-04/1536022559017.jpg","majorId":"a0d6aa40485c4ad494121500fb64bf42","videoIds":null,"videoTitles":null,"majorName":null,"videoList":null,"playNums":263},"videoList":[{"id":"034400bd2b344a16bbdacd7a0c48af96","isNewRecord":false,"remarks":null,"createDate":"2018-09-04 08:56:45","updateDate":"2018-09-12 17:22:14","startDate":null,"endDate":null,"videoTitle":"01","videoId":"6e8c8ee712af4ceea68ecbdffbb6be53","videoCover":"http://v.jiyuanet.com/6e8c8ee712af4ceea68ecbdffbb6be53/covers/6a2d2436999344018bc85168742ba402-00001.jpg","videoDuration":7.849,"playUrl":null,"videoStatus":"Normal","classId":"27ce1136fad0488c9f13e8e10f34997b","majorId":"a0d6aa40485c4ad494121500fb64bf42","videoSort":1,"videoPrice":0.1,"playNums":182,"freeType":null,"enableFlag":"1","className":null,"majorName":null,"videoIds":null,"isFree":"1"},{"id":"b2958cc6152e45dc9826337e72af7147","isNewRecord":false,"remarks":null,"createDate":"2018-09-04 08:56:56","updateDate":"2018-09-12 17:22:14","startDate":null,"endDate":null,"videoTitle":"02","videoId":"601e5903fadf4edd8584084c5e67b1d9","videoCover":"http://v.jiyuanet.com/601e5903fadf4edd8584084c5e67b1d9/covers/329116bea4cb45e08effe653025a30bd-00001.jpg","videoDuration":7.849,"playUrl":null,"videoStatus":"Normal","classId":"27ce1136fad0488c9f13e8e10f34997b","majorId":"a0d6aa40485c4ad494121500fb64bf42","videoSort":2,"videoPrice":0.1,"playNums":81,"freeType":null,"enableFlag":"1","className":null,"majorName":null,"videoIds":null,"isFree":"1"}]}
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
        /**
         * ansSchoolClass : {"id":"27ce1136fad0488c9f13e8e10f34997b","isNewRecord":false,"remarks":"龙哥美容美发精品教程","createDate":"2018-09-04 08:56:33","updateDate":"2018-09-04 08:56:33","startDate":null,"endDate":null,"enableFlag":"1","className":"龙哥美容美发精品教程","classCover":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/img/2018-09-04/1536022559017.jpg","majorId":"a0d6aa40485c4ad494121500fb64bf42","videoIds":null,"videoTitles":null,"majorName":null,"videoList":null,"playNums":263}
         * videoList : [{"id":"034400bd2b344a16bbdacd7a0c48af96","isNewRecord":false,"remarks":null,"createDate":"2018-09-04 08:56:45","updateDate":"2018-09-12 17:22:14","startDate":null,"endDate":null,"videoTitle":"01","videoId":"6e8c8ee712af4ceea68ecbdffbb6be53","videoCover":"http://v.jiyuanet.com/6e8c8ee712af4ceea68ecbdffbb6be53/covers/6a2d2436999344018bc85168742ba402-00001.jpg","videoDuration":7.849,"playUrl":null,"videoStatus":"Normal","classId":"27ce1136fad0488c9f13e8e10f34997b","majorId":"a0d6aa40485c4ad494121500fb64bf42","videoSort":1,"videoPrice":0.1,"playNums":182,"freeType":null,"enableFlag":"1","className":null,"majorName":null,"videoIds":null,"isFree":"1"},{"id":"b2958cc6152e45dc9826337e72af7147","isNewRecord":false,"remarks":null,"createDate":"2018-09-04 08:56:56","updateDate":"2018-09-12 17:22:14","startDate":null,"endDate":null,"videoTitle":"02","videoId":"601e5903fadf4edd8584084c5e67b1d9","videoCover":"http://v.jiyuanet.com/601e5903fadf4edd8584084c5e67b1d9/covers/329116bea4cb45e08effe653025a30bd-00001.jpg","videoDuration":7.849,"playUrl":null,"videoStatus":"Normal","classId":"27ce1136fad0488c9f13e8e10f34997b","majorId":"a0d6aa40485c4ad494121500fb64bf42","videoSort":2,"videoPrice":0.1,"playNums":81,"freeType":null,"enableFlag":"1","className":null,"majorName":null,"videoIds":null,"isFree":"1"}]
         */

        private AnsSchoolClassEntity ansSchoolClass;
        private List<VideoListEntity> videoList;

        public AnsSchoolClassEntity getAnsSchoolClass() {
            return ansSchoolClass;
        }

        public void setAnsSchoolClass(AnsSchoolClassEntity ansSchoolClass) {
            this.ansSchoolClass = ansSchoolClass;
        }

        public List<VideoListEntity> getVideoList() {
            return videoList;
        }

        public void setVideoList(List<VideoListEntity> videoList) {
            this.videoList = videoList;
        }

        public static class AnsSchoolClassEntity {
            /**
             * id : 27ce1136fad0488c9f13e8e10f34997b
             * isNewRecord : false
             * remarks : 龙哥美容美发精品教程
             * createDate : 2018-09-04 08:56:33
             * updateDate : 2018-09-04 08:56:33
             * startDate : null
             * endDate : null
             * enableFlag : 1
             * className : 龙哥美容美发精品教程
             * classCover : https://nwptest.oss-cn-hangzhou.aliyuncs.com/img/2018-09-04/1536022559017.jpg
             * majorId : a0d6aa40485c4ad494121500fb64bf42
             * videoIds : null
             * videoTitles : null
             * majorName : null
             * videoList : null
             * playNums : 263
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

        public static class VideoListEntity {
            /**
             * id : 034400bd2b344a16bbdacd7a0c48af96
             * isNewRecord : false
             * remarks : null
             * createDate : 2018-09-04 08:56:45
             * updateDate : 2018-09-12 17:22:14
             * startDate : null
             * endDate : null
             * videoTitle : 01
             * videoId : 6e8c8ee712af4ceea68ecbdffbb6be53
             * videoCover : http://v.jiyuanet.com/6e8c8ee712af4ceea68ecbdffbb6be53/covers/6a2d2436999344018bc85168742ba402-00001.jpg
             * videoDuration : 7.849
             * playUrl : null
             * videoStatus : Normal
             * classId : 27ce1136fad0488c9f13e8e10f34997b
             * majorId : a0d6aa40485c4ad494121500fb64bf42
             * videoSort : 1
             * videoPrice : 0.1
             * playNums : 182
             * freeType : null
             * enableFlag : 1
             * className : null
             * majorName : null
             * videoIds : null
             * isFree : 1
             */

            private String id;
            private boolean isNewRecord;
            private String remarks;
            private String createDate;
            private String updateDate;
            private String startDate;
            private String endDate;
            private String videoTitle;
            private String videoId;
            private String videoCover;
            private double videoDuration;
            private String playUrl;
            private String videoStatus;
            private String classId;
            private String majorId;
            private int videoSort;
            private double videoPrice;
            private int playNums;
            private String freeType;
            private String enableFlag;
            private String className;
            private String majorName;
            private String videoIds;
            private String isFree;

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

            public String getVideoTitle() {
                return videoTitle;
            }

            public void setVideoTitle(String videoTitle) {
                this.videoTitle = videoTitle;
            }

            public String getVideoId() {
                return videoId;
            }

            public void setVideoId(String videoId) {
                this.videoId = videoId;
            }

            public String getVideoCover() {
                return videoCover;
            }

            public void setVideoCover(String videoCover) {
                this.videoCover = videoCover;
            }

            public double getVideoDuration() {
                return videoDuration;
            }

            public void setVideoDuration(double videoDuration) {
                this.videoDuration = videoDuration;
            }

            public String getPlayUrl() {
                return playUrl;
            }

            public void setPlayUrl(String playUrl) {
                this.playUrl = playUrl;
            }

            public String getVideoStatus() {
                return videoStatus;
            }

            public void setVideoStatus(String videoStatus) {
                this.videoStatus = videoStatus;
            }

            public String getClassId() {
                return classId;
            }

            public void setClassId(String classId) {
                this.classId = classId;
            }

            public String getMajorId() {
                return majorId;
            }

            public void setMajorId(String majorId) {
                this.majorId = majorId;
            }

            public int getVideoSort() {
                return videoSort;
            }

            public void setVideoSort(int videoSort) {
                this.videoSort = videoSort;
            }

            public double getVideoPrice() {
                return videoPrice;
            }

            public void setVideoPrice(double videoPrice) {
                this.videoPrice = videoPrice;
            }

            public int getPlayNums() {
                return playNums;
            }

            public void setPlayNums(int playNums) {
                this.playNums = playNums;
            }

            public String getFreeType() {
                return freeType;
            }

            public void setFreeType(String freeType) {
                this.freeType = freeType;
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

            public String getMajorName() {
                return majorName;
            }

            public void setMajorName(String majorName) {
                this.majorName = majorName;
            }

            public String getVideoIds() {
                return videoIds;
            }

            public void setVideoIds(String videoIds) {
                this.videoIds = videoIds;
            }

            public String getIsFree() {
                return isFree;
            }

            public void setIsFree(String isFree) {
                this.isFree = isFree;
            }
        }
    }
}
