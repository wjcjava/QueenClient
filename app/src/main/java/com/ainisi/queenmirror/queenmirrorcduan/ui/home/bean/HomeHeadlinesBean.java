package com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean;

import java.util.List;

/**
 * Created by john on 2018/5/10.
 */

public class HomeHeadlinesBean {

    /**
     * success : true
     * errorCode : 0
     * msg : 获取数据成功
     * body : {"TopListData":[{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"ecTop":{"id":"8876a59eb21e483594aa065ef38d38de","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"topType":"0","topName":"34","topUrl":null,"startTime":"2018-04-17 00:00:00","endTime":"2018-04-17 00:00:00","topClicks":"45","topTetails":"","enableFlag":"0","releaseBy":"32","releaseDate":"2018-04-09 00:00:00"},"topTypeLabel":null,"enableFlagLabel":"有效"},{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"ecTop":{"id":"936d916b18364cf59825e859604264be","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"topType":"3","topName":"【头条】女王魔镜正式上线运营。。。","topUrl":null,"startTime":"2018-05-10 00:00:00","endTime":"2018-05-31 00:00:00","topClicks":"34","topTetails":"���������������������������������������","enableFlag":"0","releaseBy":"1","releaseDate":"2018-05-09 00:00:00"},"topTypeLabel":"文字","enableFlagLabel":"有效"},{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"ecTop":{"id":"e566a05d0bb543fa9f214c835e7f8fdb","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"topType":"3","topName":"【公告】女王魔镜正式上线 ！！！","topUrl":null,"startTime":"2018-05-09 00:00:00","endTime":"2018-05-31 00:00:00","topClicks":"23","topTetails":"������������������������������������������������������������������������ ���������������������������","enableFlag":"0","releaseBy":"1","releaseDate":"2018-05-10 00:00:00"},"topTypeLabel":"文字","enableFlagLabel":"有效"}]}
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
        private List<TopListDataBean> TopListData;

        public List<TopListDataBean> getTopListData() {
            return TopListData;
        }

        public void setTopListData(List<TopListDataBean> TopListData) {
            this.TopListData = TopListData;
        }

        public static class TopListDataBean {
            /**
             * id : null
             * isNewRecord : true
             * remarks : null
             * createDate : null
             * updateDate : null
             * ecTop : {"id":"8876a59eb21e483594aa065ef38d38de","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"topType":"0","topName":"34","topUrl":null,"startTime":"2018-04-17 00:00:00","endTime":"2018-04-17 00:00:00","topClicks":"45","topTetails":"","enableFlag":"0","releaseBy":"32","releaseDate":"2018-04-09 00:00:00"}
             * topTypeLabel : null
             * enableFlagLabel : 有效
             */

            private Object id;
            private boolean isNewRecord;
            private Object remarks;
            private Object createDate;
            private Object updateDate;
            private EcTopBean ecTop;
            private Object topTypeLabel;
            private String enableFlagLabel;

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

            public EcTopBean getEcTop() {
                return ecTop;
            }

            public void setEcTop(EcTopBean ecTop) {
                this.ecTop = ecTop;
            }

            public Object getTopTypeLabel() {
                return topTypeLabel;
            }

            public void setTopTypeLabel(Object topTypeLabel) {
                this.topTypeLabel = topTypeLabel;
            }

            public String getEnableFlagLabel() {
                return enableFlagLabel;
            }

            public void setEnableFlagLabel(String enableFlagLabel) {
                this.enableFlagLabel = enableFlagLabel;
            }

            public static class EcTopBean {
                /**
                 * id : 8876a59eb21e483594aa065ef38d38de
                 * isNewRecord : false
                 * remarks : null
                 * createDate : null
                 * updateDate : null
                 * topType : 0
                 * topName : 34
                 * topUrl : null
                 * startTime : 2018-04-17 00:00:00
                 * endTime : 2018-04-17 00:00:00
                 * topClicks : 45
                 * topTetails :
                 * enableFlag : 0
                 * releaseBy : 32
                 * releaseDate : 2018-04-09 00:00:00
                 */

                private String id;
                private boolean isNewRecord;
                private Object remarks;
                private Object createDate;
                private Object updateDate;
                private String topType;
                private String topName;
                private String topUrl;
                private String startTime;
                private String endTime;
                private String topClicks;
                private String topTetails;
                private String enableFlag;
                private String releaseBy;
                private String releaseDate;

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

                public String getTopType() {
                    return topType;
                }

                public void setTopType(String topType) {
                    this.topType = topType;
                }

                public String getTopName() {
                    return topName;
                }

                public void setTopName(String topName) {
                    this.topName = topName;
                }

                public String getTopUrl() {
                    return topUrl;
                }

                public void setTopUrl(String topUrl) {
                    this.topUrl = topUrl;
                }

                public String getStartTime() {
                    return startTime;
                }

                public void setStartTime(String startTime) {
                    this.startTime = startTime;
                }

                public String getEndTime() {
                    return endTime;
                }

                public void setEndTime(String endTime) {
                    this.endTime = endTime;
                }

                public String getTopClicks() {
                    return topClicks;
                }

                public void setTopClicks(String topClicks) {
                    this.topClicks = topClicks;
                }

                public String getTopTetails() {
                    return topTetails;
                }

                public void setTopTetails(String topTetails) {
                    this.topTetails = topTetails;
                }

                public String getEnableFlag() {
                    return enableFlag;
                }

                public void setEnableFlag(String enableFlag) {
                    this.enableFlag = enableFlag;
                }

                public String getReleaseBy() {
                    return releaseBy;
                }

                public void setReleaseBy(String releaseBy) {
                    this.releaseBy = releaseBy;
                }

                public String getReleaseDate() {
                    return releaseDate;
                }

                public void setReleaseDate(String releaseDate) {
                    this.releaseDate = releaseDate;
                }
            }
        }
    }
}
