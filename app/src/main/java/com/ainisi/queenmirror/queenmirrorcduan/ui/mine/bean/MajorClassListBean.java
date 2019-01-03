package com.ainisi.queenmirror.queenmirrorcduan.ui.mine.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by jiangchao on 2018/9/6 下午5:34.
 */


public class MajorClassListBean {
    /**
     * success : true
     * errorCode : 0
     * msg : 成功
     * body : {"pageSum":1,"classList":[{"id":"3891894e8e014764b68511d2594051f8","isNewRecord":false,"remarks":"十日教你学会美甲十日教你学会美甲十日教你学会美甲十日教你学会美甲十日教你学会美甲十日教你学会美甲十日教你学会美甲十日教你学会美甲十日教你学会美甲十日教你学会美甲十日教你学会美甲十日教你学会美甲十日教你学会美甲十日教你学会美甲","createDate":"2018-09-04 08:50:21","updateDate":"2018-09-21 13:23:43","startDate":null,"endDate":null,"enableFlag":"1","className":"十日教你学会美甲","classCover":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/img/2018-09-04/1536022168556.jpg","majorId":"0c2b34934ad542ca9a826c1e5ef1cce4","videoIds":null,"videoTitles":null,"majorName":"美甲专业","videoList":null,"playNums":0}]}
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
         * pageSum : 1
         * classList : [{"id":"3891894e8e014764b68511d2594051f8","isNewRecord":false,"remarks":"十日教你学会美甲十日教你学会美甲十日教你学会美甲十日教你学会美甲十日教你学会美甲十日教你学会美甲十日教你学会美甲十日教你学会美甲十日教你学会美甲十日教你学会美甲十日教你学会美甲十日教你学会美甲十日教你学会美甲十日教你学会美甲","createDate":"2018-09-04 08:50:21","updateDate":"2018-09-21 13:23:43","startDate":null,"endDate":null,"enableFlag":"1","className":"十日教你学会美甲","classCover":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/img/2018-09-04/1536022168556.jpg","majorId":"0c2b34934ad542ca9a826c1e5ef1cce4","videoIds":null,"videoTitles":null,"majorName":"美甲专业","videoList":null,"playNums":0}]
         */

        private int pageSum;
        private List<ClassListEntity> classList;

        public int getPageSum() {
            return pageSum;
        }

        public void setPageSum(int pageSum) {
            this.pageSum = pageSum;
        }

        public List<ClassListEntity> getClassList() {
            return classList;
        }

        public void setClassList(List<ClassListEntity> classList) {
            this.classList = classList;
        }

        public static class ClassListEntity implements Serializable{
            /**
             * id : 3891894e8e014764b68511d2594051f8
             * isNewRecord : false
             * remarks : 十日教你学会美甲十日教你学会美甲十日教你学会美甲十日教你学会美甲十日教你学会美甲十日教你学会美甲十日教你学会美甲十日教你学会美甲十日教你学会美甲十日教你学会美甲十日教你学会美甲十日教你学会美甲十日教你学会美甲十日教你学会美甲
             * createDate : 2018-09-04 08:50:21
             * updateDate : 2018-09-21 13:23:43
             * startDate : null
             * endDate : null
             * enableFlag : 1
             * className : 十日教你学会美甲
             * classCover : https://nwptest.oss-cn-hangzhou.aliyuncs.com/img/2018-09-04/1536022168556.jpg
             * majorId : 0c2b34934ad542ca9a826c1e5ef1cce4
             * videoIds : null
             * videoTitles : null
             * majorName : 美甲专业
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


//    /**
//     * success : true
//     * errorCode : 0
//     * msg : 成功
//     * body : {"pageSum":2,"classList":[{"id":"c66737b58ee4408984e34a75be685d3a","isNewRecord":false,"remarks":"刺青初级教程","createDate":"2018-09-06 17:29:20","updateDate":"2018-09-06 17:29:20","startDate":null,"endDate":null,"enableFlag":"1","className":"刺青初级教程","classCover":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/img/2018-09-06/1536226140475.jpg","majorId":"26fb53a301804b04a4d94e85bfa482e2","videoIds":null,"videoTitles":null,"majorName":"纹身专业","videoList":null,"playNums":0},{"id":"62910284a6cb46de8703a7a98ed5134b","isNewRecord":false,"remarks":"龙哥纹身教程","createDate":"2018-09-04 08:54:45","updateDate":"2018-09-04 08:54:45","startDate":null,"endDate":null,"enableFlag":"1","className":"龙哥纹身教程","classCover":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/img/2018-09-04/1536022441396.jpg","majorId":"26fb53a301804b04a4d94e85bfa482e2","videoIds":null,"videoTitles":null,"majorName":"纹身专业","videoList":null,"playNums":0}]}
//     */
//
//    private boolean success;
//    private String errorCode;
//    private String msg;
//    private BodyEntity body;
//
//    public boolean isSuccess() {
//        return success;
//    }
//
//    public void setSuccess(boolean success) {
//        this.success = success;
//    }
//
//    public String getErrorCode() {
//        return errorCode;
//    }
//
//    public void setErrorCode(String errorCode) {
//        this.errorCode = errorCode;
//    }
//
//    public String getMsg() {
//        return msg;
//    }
//
//    public void setMsg(String msg) {
//        this.msg = msg;
//    }
//
//    public BodyEntity getBody() {
//        return body;
//    }
//
//    public void setBody(BodyEntity body) {
//        this.body = body;
//    }
//
//    public static class BodyEntity {
//        /**
//         * pageSum : 2
//         * classList : [{"id":"c66737b58ee4408984e34a75be685d3a","isNewRecord":false,"remarks":"刺青初级教程","createDate":"2018-09-06 17:29:20","updateDate":"2018-09-06 17:29:20","startDate":null,"endDate":null,"enableFlag":"1","className":"刺青初级教程","classCover":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/img/2018-09-06/1536226140475.jpg","majorId":"26fb53a301804b04a4d94e85bfa482e2","videoIds":null,"videoTitles":null,"majorName":"纹身专业","videoList":null,"playNums":0},{"id":"62910284a6cb46de8703a7a98ed5134b","isNewRecord":false,"remarks":"龙哥纹身教程","createDate":"2018-09-04 08:54:45","updateDate":"2018-09-04 08:54:45","startDate":null,"endDate":null,"enableFlag":"1","className":"龙哥纹身教程","classCover":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/img/2018-09-04/1536022441396.jpg","majorId":"26fb53a301804b04a4d94e85bfa482e2","videoIds":null,"videoTitles":null,"majorName":"纹身专业","videoList":null,"playNums":0}]
//         */
//
//        private int pageSum;
//        private List<ClassListEntity> classList;
//
//        public int getPageSum() {
//            return pageSum;
//        }
//
//        public void setPageSum(int pageSum) {
//            this.pageSum = pageSum;
//        }
//
//        public List<ClassListEntity> getClassList() {
//            return classList;
//        }
//
//        public void setClassList(List<ClassListEntity> classList) {
//            this.classList = classList;
//        }
//
//        public static class ClassListEntity implements Serializable {
//            /**
//             * id : c66737b58ee4408984e34a75be685d3a
//             * isNewRecord : false
//             * remarks : 刺青初级教程
//             * createDate : 2018-09-06 17:29:20
//             * updateDate : 2018-09-06 17:29:20
//             * startDate : null
//             * endDate : null
//             * enableFlag : 1
//             * className : 刺青初级教程
//             * classCover : https://nwptest.oss-cn-hangzhou.aliyuncs.com/img/2018-09-06/1536226140475.jpg
//             * majorId : 26fb53a301804b04a4d94e85bfa482e2
//             * videoIds : null
//             * videoTitles : null
//             * majorName : 纹身专业
//             * videoList : null
//             * playNums : 0
//             */
//
//            private String id;
//            private boolean isNewRecord;
//            private String remarks;
//            private String createDate;
//            private String updateDate;
//            private String startDate;
//            private String endDate;
//            private String enableFlag;
//            private String className;
//            private String classCover;
//            private String majorId;
//            private String videoIds;
//            private String videoTitles;
//            private String majorName;
//            private String videoList;
//            private int playNums;
//
//            private String classId;
//
//            public String getClassId() {
//                return classId;
//            }
//
//            public void setClassId(String classId) {
//                this.classId = classId;
//            }
//
//            public String getId() {
//                return id;
//            }
//
//            public void setId(String id) {
//                this.id = id;
//            }
//
//            public boolean isIsNewRecord() {
//                return isNewRecord;
//            }
//
//            public void setIsNewRecord(boolean isNewRecord) {
//                this.isNewRecord = isNewRecord;
//            }
//
//            public String getRemarks() {
//                return remarks;
//            }
//
//            public void setRemarks(String remarks) {
//                this.remarks = remarks;
//            }
//
//            public String getCreateDate() {
//                return createDate;
//            }
//
//            public void setCreateDate(String createDate) {
//                this.createDate = createDate;
//            }
//
//            public String getUpdateDate() {
//                return updateDate;
//            }
//
//            public void setUpdateDate(String updateDate) {
//                this.updateDate = updateDate;
//            }
//
//            public String getStartDate() {
//                return startDate;
//            }
//
//            public void setStartDate(String startDate) {
//                this.startDate = startDate;
//            }
//
//            public String getEndDate() {
//                return endDate;
//            }
//
//            public void setEndDate(String endDate) {
//                this.endDate = endDate;
//            }
//
//            public String getEnableFlag() {
//                return enableFlag;
//            }
//
//            public void setEnableFlag(String enableFlag) {
//                this.enableFlag = enableFlag;
//            }
//
//            public String getClassName() {
//                return className;
//            }
//
//            public void setClassName(String className) {
//                this.className = className;
//            }
//
//            public String getClassCover() {
//                return classCover;
//            }
//
//            public void setClassCover(String classCover) {
//                this.classCover = classCover;
//            }
//
//            public String getMajorId() {
//                return majorId;
//            }
//
//            public void setMajorId(String majorId) {
//                this.majorId = majorId;
//            }
//
//            public String getVideoIds() {
//                return videoIds;
//            }
//
//            public void setVideoIds(String videoIds) {
//                this.videoIds = videoIds;
//            }
//
//            public String getVideoTitles() {
//                return videoTitles;
//            }
//
//            public void setVideoTitles(String videoTitles) {
//                this.videoTitles = videoTitles;
//            }
//
//            public String getMajorName() {
//                return majorName;
//            }
//
//            public void setMajorName(String majorName) {
//                this.majorName = majorName;
//            }
//
//            public String getVideoList() {
//                return videoList;
//            }
//
//            public void setVideoList(String videoList) {
//                this.videoList = videoList;
//            }
//
//            public int getPlayNums() {
//                return playNums;
//            }
//
//            public void setPlayNums(int playNums) {
//                this.playNums = playNums;
//            }
//        }
//    }
}
