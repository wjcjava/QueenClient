package com.ainisi.queenmirror.queenmirrorcduan.ui.mine.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by jiangchao on 2018/9/11 下午5:56.
 */


public class MyCourseListBean {


    /**
     * success : true
     * errorCode : 0
     * msg : 成功
     * body : {"list":[{"id":"416f404d76474af6bca3abf1b241d01b","className":"摄影教程","classCover":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/img/2018-09-06/1536223381587.png","majorId":"3d2036f29e434351a0c42884cbbd5bee"},{"id":"27ce1136fad0488c9f13e8e10f34997b","className":"龙哥美容美发精品教程","classCover":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/img/2018-09-04/1536022559017.jpg","majorId":"a0d6aa40485c4ad494121500fb64bf42"},{"id":"74fa3c111748415987ea7b9230d7fbdc","className":"测试课程test","classCover":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/img/2018-09-21/1537512548440.png","majorId":"08e64c8d8de24d88993d9608cfade497"},{"id":"62910284a6cb46de8703a7a98ed5134b","className":"龙哥纹身教程","classCover":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/img/2018-09-04/1536022441396.jpg","majorId":"26fb53a301804b04a4d94e85bfa482e2"},{"id":"1904207511114a9792767b74b62fcc91","className":"一招学会半永久","classCover":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/img/2018-09-06/1536222993894.png","majorId":"ee377e6161554046a7171820621a78b6"}]}
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
        private List<ListEntity> list;

        public List<ListEntity> getList() {
            return list;
        }

        public void setList(List<ListEntity> list) {
            this.list = list;
        }

        public static class ListEntity implements Serializable{
            /**
             * id : 416f404d76474af6bca3abf1b241d01b
             * className : 摄影教程
             * classCover : https://nwptest.oss-cn-hangzhou.aliyuncs.com/img/2018-09-06/1536223381587.png
             * majorId : 3d2036f29e434351a0c42884cbbd5bee
             */

            private String id;
            private String className;
            private String classCover;
            private String majorId;
            private String classId;

            public String getClassId() {
                return classId;
            }

            public void setClassId(String classId) {
                this.classId = classId;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
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
        }
    }
}
