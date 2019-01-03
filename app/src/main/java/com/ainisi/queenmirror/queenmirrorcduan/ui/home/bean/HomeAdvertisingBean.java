package com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean;

import java.util.List;

/**
 * Created by john on 2018/5/10.
 */

public class HomeAdvertisingBean {

    /**
     * success : true
     * errorCode : 0
     * msg : 获取数据成功
     * body : {"AdvertisementListData":[{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"ecAdvertisement":{"id":"7d50f4f01b8c48b2b52b57f7e1b785d6","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"adSource":"0","adType":"1","adName":"23","adUrl":"https://weibo.com/u/2880809790/home?wvr=5","startTime":"2018-04-09 00:00:00","endTime":"2018-04-25 00:00:00","adContacts":"12","adTel":"4231","adEmail":"","adClicks":"325","enableFlag":"0","releaseBy":"12","releaseDate":"2018-04-26 00:00:00.0"},"adSourceLabel":"站内","adTypeLabel":"图片","enableFlagLabel":"有效"}]}
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
        private List<AdvertisementListDataBean> AdvertisementListData;

        public List<AdvertisementListDataBean> getAdvertisementListData() {
            return AdvertisementListData;
        }

        public void setAdvertisementListData(List<AdvertisementListDataBean> AdvertisementListData) {
            this.AdvertisementListData = AdvertisementListData;
        }

        public static class AdvertisementListDataBean {
            /**
             * id : null
             * isNewRecord : true
             * remarks : null
             * createDate : null
             * updateDate : null
             * ecAdvertisement : {"id":"7d50f4f01b8c48b2b52b57f7e1b785d6","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"adSource":"0","adType":"1","adName":"23","adUrl":"https://weibo.com/u/2880809790/home?wvr=5","startTime":"2018-04-09 00:00:00","endTime":"2018-04-25 00:00:00","adContacts":"12","adTel":"4231","adEmail":"","adClicks":"325","enableFlag":"0","releaseBy":"12","releaseDate":"2018-04-26 00:00:00.0"}
             * adSourceLabel : 站内
             * adTypeLabel : 图片
             * enableFlagLabel : 有效
             */

            private Object id;
            private boolean isNewRecord;
            private Object remarks;
            private Object createDate;
            private Object updateDate;
            private EcAdvertisementBean ecAdvertisement;
            private String adSourceLabel;
            private String adTypeLabel;
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

            public EcAdvertisementBean getEcAdvertisement() {
                return ecAdvertisement;
            }

            public void setEcAdvertisement(EcAdvertisementBean ecAdvertisement) {
                this.ecAdvertisement = ecAdvertisement;
            }

            public String getAdSourceLabel() {
                return adSourceLabel;
            }

            public void setAdSourceLabel(String adSourceLabel) {
                this.adSourceLabel = adSourceLabel;
            }

            public String getAdTypeLabel() {
                return adTypeLabel;
            }

            public void setAdTypeLabel(String adTypeLabel) {
                this.adTypeLabel = adTypeLabel;
            }

            public String getEnableFlagLabel() {
                return enableFlagLabel;
            }

            public void setEnableFlagLabel(String enableFlagLabel) {
                this.enableFlagLabel = enableFlagLabel;
            }

            public static class EcAdvertisementBean {
                /**
                 * id : 7d50f4f01b8c48b2b52b57f7e1b785d6
                 * isNewRecord : false
                 * remarks : null
                 * createDate : null
                 * updateDate : null
                 * adSource : 0
                 * adType : 1
                 * adName : 23
                 * adUrl : https://weibo.com/u/2880809790/home?wvr=5
                 * startTime : 2018-04-09 00:00:00
                 * endTime : 2018-04-25 00:00:00
                 * adContacts : 12
                 * adTel : 4231
                 * adEmail :
                 * adClicks : 325
                 * enableFlag : 0
                 * releaseBy : 12
                 * releaseDate : 2018-04-26 00:00:00.0
                 */

                private String id;
                private boolean isNewRecord;
                private Object remarks;
                private Object createDate;
                private Object updateDate;
                private String adSource;
                private String adType;
                private String adName;
                private String adUrl;
                private String startTime;
                private String endTime;
                private String adContacts;
                private String adTel;
                private String adEmail;
                private String adClicks;
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

                public String getAdSource() {
                    return adSource;
                }

                public void setAdSource(String adSource) {
                    this.adSource = adSource;
                }

                public String getAdType() {
                    return adType;
                }

                public void setAdType(String adType) {
                    this.adType = adType;
                }

                public String getAdName() {
                    return adName;
                }

                public void setAdName(String adName) {
                    this.adName = adName;
                }

                public String getAdUrl() {
                    return adUrl;
                }

                public void setAdUrl(String adUrl) {
                    this.adUrl = adUrl;
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

                public String getAdContacts() {
                    return adContacts;
                }

                public void setAdContacts(String adContacts) {
                    this.adContacts = adContacts;
                }

                public String getAdTel() {
                    return adTel;
                }

                public void setAdTel(String adTel) {
                    this.adTel = adTel;
                }

                public String getAdEmail() {
                    return adEmail;
                }

                public void setAdEmail(String adEmail) {
                    this.adEmail = adEmail;
                }

                public String getAdClicks() {
                    return adClicks;
                }

                public void setAdClicks(String adClicks) {
                    this.adClicks = adClicks;
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
