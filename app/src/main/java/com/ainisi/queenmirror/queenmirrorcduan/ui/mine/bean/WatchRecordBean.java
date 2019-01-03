package com.ainisi.queenmirror.queenmirrorcduan.ui.mine.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by jiangchao on 2018/9/10 下午4:51.
 */


public class WatchRecordBean {


    /**
     * success : true
     * errorCode : 0
     * msg : 成功
     * body : {"pageSum":8,"recordsList":[{"id":"720727d1af344506b31384cd3f8f3595","isNewRecord":false,"remarks":null,"createDate":"2018-09-13 13:31:42","updateDate":"2018-09-25 13:30:50","startDate":null,"endDate":null,"custId":"5ce75e910007480f9690ca9fd741f871","videoId":"034400bd2b344a16bbdacd7a0c48af96","classId":"27ce1136fad0488c9f13e8e10f34997b","enableFlag":"1","playSeconds":0,"videoCover":"http://v.jiyuanet.com/6e8c8ee712af4ceea68ecbdffbb6be53/covers/6a2d2436999344018bc85168742ba402-00001.jpg","majorId":"a0d6aa40485c4ad494121500fb64bf42","videoSort":"1","className":"龙哥美容美发精品教程","videoTitle":"01","classCover":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/img/2018-09-04/1536022559017.jpg"},{"id":"4bdd8dd642494f3bacfa9be4266f8b82","isNewRecord":false,"remarks":null,"createDate":"2018-09-25 13:30:31","updateDate":"2018-09-25 13:30:31","startDate":null,"endDate":null,"custId":"5ce75e910007480f9690ca9fd741f871","videoId":"031170dce5d84f4f927cc224ececae52","classId":"416f404d76474af6bca3abf1b241d01b","enableFlag":"1","playSeconds":0,"videoCover":"http://v.jiyuanet.com/54de47512cb14f019b4d3ebe07d54ecb/covers/b2a0afe70eeb43d9aadf3921b90df7ca-00002.jpg","majorId":"3d2036f29e434351a0c42884cbbd5bee","videoSort":"1","className":"摄影教程","videoTitle":"\u2014\u2014）（）*&\u2026\u2026&%¥#@！#（）\u2014\u2014++","classCover":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/img/2018-09-06/1536223381587.png"},{"id":"fdae37735d2e4ff2a84fe942da253879","isNewRecord":false,"remarks":null,"createDate":"2018-09-13 13:31:42","updateDate":"2018-09-18 09:31:57","startDate":null,"endDate":null,"custId":"5ce75e910007480f9690ca9fd741f871","videoId":"b2958cc6152e45dc9826337e72af7147","classId":"27ce1136fad0488c9f13e8e10f34997b","enableFlag":"1","playSeconds":0,"videoCover":"http://v.jiyuanet.com/601e5903fadf4edd8584084c5e67b1d9/covers/329116bea4cb45e08effe653025a30bd-00001.jpg","majorId":"a0d6aa40485c4ad494121500fb64bf42","videoSort":"2","className":"龙哥美容美发精品教程","videoTitle":"02","classCover":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/img/2018-09-04/1536022559017.jpg"},{"id":"21df85223e7f40d1b451b19afecebc9f","isNewRecord":false,"remarks":null,"createDate":"2018-09-14 09:02:40","updateDate":"2018-09-14 16:28:12","startDate":null,"endDate":null,"custId":"5ce75e910007480f9690ca9fd741f871","videoId":"074d48f901f241c284f1d598ea57bf6d","classId":"1904207511114a9792767b74b62fcc91","enableFlag":"1","playSeconds":0,"videoCover":"http://v.jiyuanet.com/eded4588259541d3880227296e69ac10/covers/5db6625f70c648838030be4e25214573-00001.jpg","majorId":"ee377e6161554046a7171820621a78b6","videoSort":"3","className":"一招学会半永久","videoTitle":"一招学会半永久03","classCover":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/img/2018-09-06/1536222993894.png"},{"id":"494da21cac4a4571b98ad1767409729a","isNewRecord":false,"remarks":null,"createDate":"2018-09-14 09:15:27","updateDate":"2018-09-14 15:16:25","startDate":null,"endDate":null,"custId":"5ce75e910007480f9690ca9fd741f871","videoId":"320eb54c5ef24e5da1fbe3f7743f1bc7","classId":"3891894e8e014764b68511d2594051f8","enableFlag":"1","playSeconds":0,"videoCover":"http://v.jiyuanet.com/0b3b72403f524ee4b743b3ab387ff500/covers/60fa71f75a924723802959c59c9fff0e-00001.jpg","majorId":"0c2b34934ad542ca9a826c1e5ef1cce4","videoSort":"1","className":"十日教你学会美甲","videoTitle":"第一集","classCover":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/img/2018-09-04/1536022168556.jpg"}]}
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
         * pageSum : 8
         * recordsList : [{"id":"720727d1af344506b31384cd3f8f3595","isNewRecord":false,"remarks":null,"createDate":"2018-09-13 13:31:42","updateDate":"2018-09-25 13:30:50","startDate":null,"endDate":null,"custId":"5ce75e910007480f9690ca9fd741f871","videoId":"034400bd2b344a16bbdacd7a0c48af96","classId":"27ce1136fad0488c9f13e8e10f34997b","enableFlag":"1","playSeconds":0,"videoCover":"http://v.jiyuanet.com/6e8c8ee712af4ceea68ecbdffbb6be53/covers/6a2d2436999344018bc85168742ba402-00001.jpg","majorId":"a0d6aa40485c4ad494121500fb64bf42","videoSort":"1","className":"龙哥美容美发精品教程","videoTitle":"01","classCover":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/img/2018-09-04/1536022559017.jpg"},{"id":"4bdd8dd642494f3bacfa9be4266f8b82","isNewRecord":false,"remarks":null,"createDate":"2018-09-25 13:30:31","updateDate":"2018-09-25 13:30:31","startDate":null,"endDate":null,"custId":"5ce75e910007480f9690ca9fd741f871","videoId":"031170dce5d84f4f927cc224ececae52","classId":"416f404d76474af6bca3abf1b241d01b","enableFlag":"1","playSeconds":0,"videoCover":"http://v.jiyuanet.com/54de47512cb14f019b4d3ebe07d54ecb/covers/b2a0afe70eeb43d9aadf3921b90df7ca-00002.jpg","majorId":"3d2036f29e434351a0c42884cbbd5bee","videoSort":"1","className":"摄影教程","videoTitle":"\u2014\u2014）（）*&\u2026\u2026&%¥#@！#（）\u2014\u2014++","classCover":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/img/2018-09-06/1536223381587.png"},{"id":"fdae37735d2e4ff2a84fe942da253879","isNewRecord":false,"remarks":null,"createDate":"2018-09-13 13:31:42","updateDate":"2018-09-18 09:31:57","startDate":null,"endDate":null,"custId":"5ce75e910007480f9690ca9fd741f871","videoId":"b2958cc6152e45dc9826337e72af7147","classId":"27ce1136fad0488c9f13e8e10f34997b","enableFlag":"1","playSeconds":0,"videoCover":"http://v.jiyuanet.com/601e5903fadf4edd8584084c5e67b1d9/covers/329116bea4cb45e08effe653025a30bd-00001.jpg","majorId":"a0d6aa40485c4ad494121500fb64bf42","videoSort":"2","className":"龙哥美容美发精品教程","videoTitle":"02","classCover":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/img/2018-09-04/1536022559017.jpg"},{"id":"21df85223e7f40d1b451b19afecebc9f","isNewRecord":false,"remarks":null,"createDate":"2018-09-14 09:02:40","updateDate":"2018-09-14 16:28:12","startDate":null,"endDate":null,"custId":"5ce75e910007480f9690ca9fd741f871","videoId":"074d48f901f241c284f1d598ea57bf6d","classId":"1904207511114a9792767b74b62fcc91","enableFlag":"1","playSeconds":0,"videoCover":"http://v.jiyuanet.com/eded4588259541d3880227296e69ac10/covers/5db6625f70c648838030be4e25214573-00001.jpg","majorId":"ee377e6161554046a7171820621a78b6","videoSort":"3","className":"一招学会半永久","videoTitle":"一招学会半永久03","classCover":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/img/2018-09-06/1536222993894.png"},{"id":"494da21cac4a4571b98ad1767409729a","isNewRecord":false,"remarks":null,"createDate":"2018-09-14 09:15:27","updateDate":"2018-09-14 15:16:25","startDate":null,"endDate":null,"custId":"5ce75e910007480f9690ca9fd741f871","videoId":"320eb54c5ef24e5da1fbe3f7743f1bc7","classId":"3891894e8e014764b68511d2594051f8","enableFlag":"1","playSeconds":0,"videoCover":"http://v.jiyuanet.com/0b3b72403f524ee4b743b3ab387ff500/covers/60fa71f75a924723802959c59c9fff0e-00001.jpg","majorId":"0c2b34934ad542ca9a826c1e5ef1cce4","videoSort":"1","className":"十日教你学会美甲","videoTitle":"第一集","classCover":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/img/2018-09-04/1536022168556.jpg"}]
         */

        private int pageSum;
        private List<RecordsListEntity> recordsList;

        public int getPageSum() {
            return pageSum;
        }

        public void setPageSum(int pageSum) {
            this.pageSum = pageSum;
        }

        public List<RecordsListEntity> getRecordsList() {
            return recordsList;
        }

        public void setRecordsList(List<RecordsListEntity> recordsList) {
            this.recordsList = recordsList;
        }

        public static class RecordsListEntity implements Serializable{
            /**
             * id : 720727d1af344506b31384cd3f8f3595
             * isNewRecord : false
             * remarks : null
             * createDate : 2018-09-13 13:31:42
             * updateDate : 2018-09-25 13:30:50
             * startDate : null
             * endDate : null
             * custId : 5ce75e910007480f9690ca9fd741f871
             * videoId : 034400bd2b344a16bbdacd7a0c48af96
             * classId : 27ce1136fad0488c9f13e8e10f34997b
             * enableFlag : 1
             * playSeconds : 0
             * videoCover : http://v.jiyuanet.com/6e8c8ee712af4ceea68ecbdffbb6be53/covers/6a2d2436999344018bc85168742ba402-00001.jpg
             * majorId : a0d6aa40485c4ad494121500fb64bf42
             * videoSort : 1
             * className : 龙哥美容美发精品教程
             * videoTitle : 01
             * classCover : https://nwptest.oss-cn-hangzhou.aliyuncs.com/img/2018-09-04/1536022559017.jpg
             */

            private String id;
            private boolean isNewRecord;
            private String remarks;
            private String createDate;
            private String updateDate;
            private String startDate;
            private String endDate;
            private String custId;
            private String videoId;
            private String classId;
            private String enableFlag;
            private int playSeconds;
            private String videoCover;
            private String majorId;
            private String videoSort;
            private String className;
            private String videoTitle;
            private String classCover;

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

            public String getCustId() {
                return custId;
            }

            public void setCustId(String custId) {
                this.custId = custId;
            }

            public String getVideoId() {
                return videoId;
            }

            public void setVideoId(String videoId) {
                this.videoId = videoId;
            }

            public String getClassId() {
                return classId;
            }

            public void setClassId(String classId) {
                this.classId = classId;
            }

            public String getEnableFlag() {
                return enableFlag;
            }

            public void setEnableFlag(String enableFlag) {
                this.enableFlag = enableFlag;
            }

            public int getPlaySeconds() {
                return playSeconds;
            }

            public void setPlaySeconds(int playSeconds) {
                this.playSeconds = playSeconds;
            }

            public String getVideoCover() {
                return videoCover;
            }

            public void setVideoCover(String videoCover) {
                this.videoCover = videoCover;
            }

            public String getMajorId() {
                return majorId;
            }

            public void setMajorId(String majorId) {
                this.majorId = majorId;
            }

            public String getVideoSort() {
                return videoSort;
            }

            public void setVideoSort(String videoSort) {
                this.videoSort = videoSort;
            }

            public String getClassName() {
                return className;
            }

            public void setClassName(String className) {
                this.className = className;
            }

            public String getVideoTitle() {
                return videoTitle;
            }

            public void setVideoTitle(String videoTitle) {
                this.videoTitle = videoTitle;
            }

            public String getClassCover() {
                return classCover;
            }

            public void setClassCover(String classCover) {
                this.classCover = classCover;
            }
        }
    }
}
