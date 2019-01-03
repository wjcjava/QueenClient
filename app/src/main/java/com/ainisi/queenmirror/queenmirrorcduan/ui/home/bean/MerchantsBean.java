package com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean;

import java.util.List;

/**
 * Created by john on 2018/6/2.
 */

public class MerchantsBean {

    /**
     * success : true
     * errorCode : 0
     * msg : 获取数据成功
     * body : {"ActivityKeysListData":[{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"ecActivity":{"id":"3df26964995f4946934e98c5e62528e0","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"actCall":"","actStyle":"1","pageLocation":null,"showSort":null,"actName":"111","actUrl":"https://12312.com","actLogo":"sdfds","startTime":"2018-04-17 00:00:00","endTime":"2018-04-17 00:00:00","actDetails":"dsf","enableFlag":"0","releaseBy":null,"releaseDate":"2018-04-17 00:00:00"},"actStyleLabel":null,"enableFlagLabel":null},{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"ecActivity":{"id":"5d7e07025ffe4f8ebc21caf251bebd66","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"actCall":"","actStyle":"1","pageLocation":null,"showSort":null,"actName":"23","actUrl":"https://weibo.com/u/2880809790/home?wvr=5","actLogo":"3","startTime":"2018-04-18 00:00:00","endTime":"2018-04-25 00:00:00","actDetails":"","enableFlag":"0","releaseBy":null,"releaseDate":"2018-05-02 00:00:00"},"actStyleLabel":null,"enableFlagLabel":null}]}
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
        private List<ActivityKeysListDataBean> ActivityKeysListData;

        public List<ActivityKeysListDataBean> getActivityKeysListData() {
            return ActivityKeysListData;
        }

        public void setActivityKeysListData(List<ActivityKeysListDataBean> ActivityKeysListData) {
            this.ActivityKeysListData = ActivityKeysListData;
        }

        public static class ActivityKeysListDataBean {
            /**
             * id : null
             * isNewRecord : true
             * remarks : null
             * createDate : null
             * updateDate : null
             * ecActivity : {"id":"3df26964995f4946934e98c5e62528e0","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"actCall":"","actStyle":"1","pageLocation":null,"showSort":null,"actName":"111","actUrl":"https://12312.com","actLogo":"sdfds","startTime":"2018-04-17 00:00:00","endTime":"2018-04-17 00:00:00","actDetails":"dsf","enableFlag":"0","releaseBy":null,"releaseDate":"2018-04-17 00:00:00"}
             * actStyleLabel : null
             * enableFlagLabel : null
             */

            private Object id;
            private boolean isNewRecord;
            private Object remarks;
            private Object createDate;
            private Object updateDate;
            private EcActivityBean ecActivity;
            private Object actStyleLabel;
            private Object enableFlagLabel;

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

            public EcActivityBean getEcActivity() {
                return ecActivity;
            }

            public void setEcActivity(EcActivityBean ecActivity) {
                this.ecActivity = ecActivity;
            }

            public Object getActStyleLabel() {
                return actStyleLabel;
            }

            public void setActStyleLabel(Object actStyleLabel) {
                this.actStyleLabel = actStyleLabel;
            }

            public Object getEnableFlagLabel() {
                return enableFlagLabel;
            }

            public void setEnableFlagLabel(Object enableFlagLabel) {
                this.enableFlagLabel = enableFlagLabel;
            }

            public static class EcActivityBean {
                /**
                 * id : 3df26964995f4946934e98c5e62528e0
                 * isNewRecord : false
                 * remarks : null
                 * createDate : null
                 * updateDate : null
                 * actCall :
                 * actStyle : 1
                 * pageLocation : null
                 * showSort : null
                 * actName : 111
                 * actUrl : https://12312.com
                 * actLogo : sdfds
                 * startTime : 2018-04-17 00:00:00
                 * endTime : 2018-04-17 00:00:00
                 * actDetails : dsf
                 * enableFlag : 0
                 * releaseBy : null
                 * releaseDate : 2018-04-17 00:00:00
                 */

                private String id;
                private boolean isNewRecord;
                private Object remarks;
                private Object createDate;
                private Object updateDate;
                private String actCall;
                private String actStyle;
                private Object pageLocation;
                private Object showSort;
                private String actName;
                private String actUrl;
                private String actLogo;
                private String startTime;
                private String endTime;
                private String actDetails;
                private String enableFlag;
                private Object releaseBy;
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

                public String getActCall() {
                    return actCall;
                }

                public void setActCall(String actCall) {
                    this.actCall = actCall;
                }

                public String getActStyle() {
                    return actStyle;
                }

                public void setActStyle(String actStyle) {
                    this.actStyle = actStyle;
                }

                public Object getPageLocation() {
                    return pageLocation;
                }

                public void setPageLocation(Object pageLocation) {
                    this.pageLocation = pageLocation;
                }

                public Object getShowSort() {
                    return showSort;
                }

                public void setShowSort(Object showSort) {
                    this.showSort = showSort;
                }

                public String getActName() {
                    return actName;
                }

                public void setActName(String actName) {
                    this.actName = actName;
                }

                public String getActUrl() {
                    return actUrl;
                }

                public void setActUrl(String actUrl) {
                    this.actUrl = actUrl;
                }

                public String getActLogo() {
                    return actLogo;
                }

                public void setActLogo(String actLogo) {
                    this.actLogo = actLogo;
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

                public String getActDetails() {
                    return actDetails;
                }

                public void setActDetails(String actDetails) {
                    this.actDetails = actDetails;
                }

                public String getEnableFlag() {
                    return enableFlag;
                }

                public void setEnableFlag(String enableFlag) {
                    this.enableFlag = enableFlag;
                }

                public Object getReleaseBy() {
                    return releaseBy;
                }

                public void setReleaseBy(Object releaseBy) {
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
