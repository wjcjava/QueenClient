package com.ainisi.queenmirror.queenmirrorcduan.bean;

import java.util.List;

/**
 * Created by john on 2018/7/6.
 */

public class ShopMallBannerBean {


    /**
     * success : true
     * errorCode : 0
     * msg : 获取数据成功
     * body : {"BannerListData":[{"id":"88bcc5b13511469cab74fb4b38cedb65","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"bannerStyle":"2","bannerCategory":"1","isPush":"1","pushContent":"测试推送222","pageLocation":"1","showSort":2,"bannerName":"测试推送2","bannerUrl":"https://github.com","bannerLogo":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/img/2018-07-02/1530523465882.jpg","startTime":"2018-07-01 00:00:00","endTime":"2018-07-31 00:00:00","bannerDetails":"","enableFlag":"0","releaseBy":null,"releaseDate":"2018-07-02 00:00:00","shopIds":null,"goodsIds":null},{"id":"998b7c4e996a4f92a4fbbdaf56b72705","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"startDate":null,"endDate":null,"bannerStyle":"5","bannerCategory":"1","isPush":"0","pushContent":null,"pageLocation":"1","showSort":4,"bannerName":"xxxaaa","bannerUrl":"","bannerLogo":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/img/2018-06-28/1530174952014.jpg","startTime":"2018-06-01 00:00:00","endTime":"2018-07-28 00:00:00","bannerDetails":"","enableFlag":"0","releaseBy":null,"releaseDate":"2018-06-28 00:00:00","shopIds":null,"goodsIds":null}]}
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
        private List<BannerListDataBean> BannerListData;

        public List<BannerListDataBean> getBannerListData() {
            return BannerListData;
        }

        public void setBannerListData(List<BannerListDataBean> BannerListData) {
            this.BannerListData = BannerListData;
        }

        public static class BannerListDataBean {
            /**
             * id : 88bcc5b13511469cab74fb4b38cedb65
             * isNewRecord : false
             * remarks : null
             * createDate : null
             * updateDate : null
             * startDate : null
             * endDate : null
             * bannerStyle : 2
             * bannerCategory : 1
             * isPush : 1
             * pushContent : 测试推送222
             * pageLocation : 1
             * showSort : 2
             * bannerName : 测试推送2
             * bannerUrl : https://github.com
             * bannerLogo : https://nwptest.oss-cn-hangzhou.aliyuncs.com/img/2018-07-02/1530523465882.jpg
             * startTime : 2018-07-01 00:00:00
             * endTime : 2018-07-31 00:00:00
             * bannerDetails :
             * enableFlag : 0
             * releaseBy : null
             * releaseDate : 2018-07-02 00:00:00
             * shopIds : null
             * goodsIds : null
             */

            private String id;
            private boolean isNewRecord;
            private Object remarks;
            private Object createDate;
            private Object updateDate;
            private Object startDate;
            private Object endDate;
            private String bannerStyle;
            private String bannerCategory;
            private String isPush;
            private String pushContent;
            private String pageLocation;
            private int showSort;
            private String bannerName;
            private String bannerUrl;
            private String bannerLogo;
            private String startTime;
            private String endTime;
            private String bannerDetails;
            private String enableFlag;
            private Object releaseBy;
            private String releaseDate;
            private Object shopIds;
            private Object goodsIds;

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

            public Object getStartDate() {
                return startDate;
            }

            public void setStartDate(Object startDate) {
                this.startDate = startDate;
            }

            public Object getEndDate() {
                return endDate;
            }

            public void setEndDate(Object endDate) {
                this.endDate = endDate;
            }

            public String getBannerStyle() {
                return bannerStyle;
            }

            public void setBannerStyle(String bannerStyle) {
                this.bannerStyle = bannerStyle;
            }

            public String getBannerCategory() {
                return bannerCategory;
            }

            public void setBannerCategory(String bannerCategory) {
                this.bannerCategory = bannerCategory;
            }

            public String getIsPush() {
                return isPush;
            }

            public void setIsPush(String isPush) {
                this.isPush = isPush;
            }

            public String getPushContent() {
                return pushContent;
            }

            public void setPushContent(String pushContent) {
                this.pushContent = pushContent;
            }

            public String getPageLocation() {
                return pageLocation;
            }

            public void setPageLocation(String pageLocation) {
                this.pageLocation = pageLocation;
            }

            public int getShowSort() {
                return showSort;
            }

            public void setShowSort(int showSort) {
                this.showSort = showSort;
            }

            public String getBannerName() {
                return bannerName;
            }

            public void setBannerName(String bannerName) {
                this.bannerName = bannerName;
            }

            public String getBannerUrl() {
                return bannerUrl;
            }

            public void setBannerUrl(String bannerUrl) {
                this.bannerUrl = bannerUrl;
            }

            public String getBannerLogo() {
                return bannerLogo;
            }

            public void setBannerLogo(String bannerLogo) {
                this.bannerLogo = bannerLogo;
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

            public String getBannerDetails() {
                return bannerDetails;
            }

            public void setBannerDetails(String bannerDetails) {
                this.bannerDetails = bannerDetails;
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

            public Object getShopIds() {
                return shopIds;
            }

            public void setShopIds(Object shopIds) {
                this.shopIds = shopIds;
            }

            public Object getGoodsIds() {
                return goodsIds;
            }

            public void setGoodsIds(Object goodsIds) {
                this.goodsIds = goodsIds;
            }
        }
    }
}
