package com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by john on 2018/6/15.
 */

public class PageBannerBean {

    /**
     * success : true
     * errorCode : 0
     * msg : 获取数据成功
     * body : {"BannerListData":[{"id":"2b478b491c7049a891c23664b2a1866f","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"bannerStyle":"2","pageLocation":"5","showSort":1,"bannerName":"但你没带走，梦里的所有","bannerUrl":"www.github.com","bannerLogo":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/img/2018-06-15/1529031105934.jpg","startTime":"2018-06-01 00:00:00","endTime":"2018-06-30 00:00:00","bannerDetails":"","enableFlag":"0","releaseBy":null,"releaseDate":"2018-06-15 00:00:00","goodsList":null,"shopList":null},{"id":"365fedec91de424999020ea538f84414","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"bannerStyle":"2","pageLocation":"4","showSort":4,"bannerName":"只想一生跟你走","bannerUrl":"www.github.com","bannerLogo":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/img/2018-06-15/1529030929732.jpg","startTime":"2018-06-01 00:00:00","endTime":"2018-06-30 00:00:00","bannerDetails":"","enableFlag":"0","releaseBy":null,"releaseDate":"2018-06-30 00:00:00","goodsList":null,"shopList":null},{"id":"5ec5108740264b0e8469364f42bc5449","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"bannerStyle":"2","pageLocation":"4","showSort":3,"bannerName":"延展铺天盖地好本领","bannerUrl":"www.github.com","bannerLogo":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/img/2018-06-15/1529030858790.jpg","startTime":"2018-06-01 00:00:00","endTime":"2018-06-30 00:00:00","bannerDetails":"","enableFlag":"0","releaseBy":null,"releaseDate":"2018-06-15 00:00:00","goodsList":null,"shopList":null},{"id":"74aa94b5b9154ab2a7b9d3bc20e1c6a7","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"bannerStyle":"2","pageLocation":"5","showSort":3,"bannerName":"劲歌金曲","bannerUrl":"www.github.com","bannerLogo":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/img/2018-06-15/1529031207425.jpg","startTime":"2018-06-01 00:00:00","endTime":"2018-06-30 00:00:00","bannerDetails":"","enableFlag":"0","releaseBy":null,"releaseDate":"2018-06-30 00:00:00","goodsList":null,"shopList":null},{"id":"75c5756e1b3043929c929785c2f407da","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"bannerStyle":"2","pageLocation":"3","showSort":4,"bannerName":"烟花易冷","bannerUrl":"www.github.com","bannerLogo":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/img/2018-06-15/1529030369473.jpeg","startTime":"2018-06-01 00:00:00","endTime":"2018-06-30 00:00:00","bannerDetails":"","enableFlag":"0","releaseBy":null,"releaseDate":"2018-06-15 00:00:00","goodsList":null,"shopList":null},{"id":"a29cc5408a4d441f824b519984ed3c3c","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"bannerStyle":"2","pageLocation":"3","showSort":1,"bannerName":"千千阙歌","bannerUrl":"www.github.com","bannerLogo":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/img/2018-06-15/1529030048561.jpg","startTime":"2018-06-01 00:00:00","endTime":"2018-06-30 00:00:00","bannerDetails":"","enableFlag":"0","releaseBy":null,"releaseDate":"2018-06-15 00:00:00","goodsList":null,"shopList":null},{"id":"a9861c9f1921448bb96ef48bd1bf6f7a","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"bannerStyle":"2","pageLocation":"4","showSort":1,"bannerName":"k歌之王-陈奕迅","bannerUrl":"www.github.com","bannerLogo":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/img/2018-06-15/1529030674043.jpg","startTime":"2018-06-01 00:00:00","endTime":"2018-06-30 00:00:00","bannerDetails":"","enableFlag":"0","releaseBy":null,"releaseDate":"2018-06-15 00:00:00","goodsList":null,"shopList":null},{"id":"afd7eaf1fe4b450d908ba172ebcb2259","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"bannerStyle":"2","pageLocation":"3","showSort":2,"bannerName":"七里香","bannerUrl":"www.github.com","bannerLogo":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/img/2018-06-15/1529030214710.jpg","startTime":"2018-06-01 00:00:00","endTime":"2018-06-30 00:00:00","bannerDetails":"","enableFlag":"0","releaseBy":null,"releaseDate":"2018-06-15 00:00:00","goodsList":null,"shopList":null},{"id":"bf950da658274508b2066a7f381624f2","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"bannerStyle":"2","pageLocation":"1","showSort":2,"bannerName":"今天只有残留的驱壳","bannerUrl":"www.github.com","bannerLogo":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/img/2018-06-15/1529029489171.jpg","startTime":"2018-06-01 00:00:00","endTime":"2018-06-30 00:00:00","bannerDetails":"","enableFlag":"0","releaseBy":null,"releaseDate":"2018-06-15 00:00:00","goodsList":null,"shopList":null},{"id":"c2ea7514f4f24f889d9c6ec4b8bde14a","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"bannerStyle":"2","pageLocation":"5","showSort":2,"bannerName":"今生不可不能没有","bannerUrl":"www.github.com","bannerLogo":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/img/2018-06-15/1529031151066.jpg","startTime":"2018-06-01 00:00:00","endTime":"2018-06-30 00:00:00","bannerDetails":"","enableFlag":"0","releaseBy":null,"releaseDate":"2018-06-15 00:00:00","goodsList":null,"shopList":null},{"id":"c6305ecc4bc94a1396f49aafc07bf474","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"bannerStyle":"1","pageLocation":"2","showSort":1,"bannerName":"今天涯，明天又天涯，狠狠一巴掌忘了吧","bannerUrl":"","bannerLogo":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/img/2018-06-15/1529029881368.png","startTime":"2018-06-01 00:00:00","endTime":"2018-06-30 00:00:00","bannerDetails":"&lt;img src=&quot;data:image/jpeg;base64,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&quot; style=&quot;width: 158px;&quot;&gt;","enableFlag":"0","releaseBy":null,"releaseDate":"2018-06-01 00:00:00","goodsList":null,"shopList":null},{"id":"c90dd60a9c8c4b15865b3e38759a39c0","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"bannerStyle":"4","pageLocation":"1","showSort":4,"bannerName":"emmm","bannerUrl":"","bannerLogo":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/img/2018-06-15/1529042336025.jpg","startTime":"2018-06-01 00:00:00","endTime":"2018-06-30 00:00:00","bannerDetails":"","enableFlag":"0","releaseBy":null,"releaseDate":"2018-06-30 00:00:00","goodsList":null,"shopList":null},{"id":"cf66b4e8a5e14306949804bce6cc02e4","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"bannerStyle":"2","pageLocation":"4","showSort":2,"bannerName":"林夕-梦","bannerUrl":"www.github.com","bannerLogo":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/img/2018-06-15/1529030744149.jpg","startTime":"2018-06-01 00:00:00","endTime":"2018-06-30 00:00:00","bannerDetails":"","enableFlag":"0","releaseBy":null,"releaseDate":"2018-06-15 00:00:00","goodsList":null,"shopList":null},{"id":"cf8e6b5072544f5e89adf15d7dc4657c","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"bannerStyle":"2","pageLocation":"1","showSort":1,"bannerName":"光辉岁月","bannerUrl":"https://act.jiyuanet.com/activity","bannerLogo":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/img/2018-06-15/1529029070648.jpg","startTime":"2018-06-01 00:00:00","endTime":"2018-06-30 00:00:00","bannerDetails":"","enableFlag":"0","releaseBy":null,"releaseDate":"2018-06-15 00:00:00","goodsList":null,"shopList":null},{"id":"d37ae11ecdd94501bb96a0acf4d6f229","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"bannerStyle":"2","pageLocation":"3","showSort":3,"bannerName":"秋刀鱼","bannerUrl":"www.github.com","bannerLogo":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/img/2018-06-15/1529030290649.jpeg","startTime":"2018-06-01 00:00:00","endTime":"2018-06-30 00:00:00","bannerDetails":"","enableFlag":"0","releaseBy":null,"releaseDate":"2018-06-30 00:00:00","goodsList":null,"shopList":null},{"id":"eb276b9142f640b5a1a3fa6f35cdc8ad","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"bannerStyle":"2","pageLocation":"1","showSort":3,"bannerName":"风雨中抱紧自由","bannerUrl":"www.baidu.com","bannerLogo":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/img/2018-06-15/1529029551179.jpg","startTime":"2018-06-01 00:00:00","endTime":"2018-06-30 00:00:00","bannerDetails":"","enableFlag":"0","releaseBy":null,"releaseDate":"2018-06-15 00:00:00","goodsList":null,"shopList":null}]}
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

        public static class BannerListDataBean implements Parcelable {
            /**
             * id : 2b478b491c7049a891c23664b2a1866f
             * isNewRecord : false
             * remarks : null
             * createDate : null
             * updateDate : null
             * bannerStyle : 2
             * pageLocation : 5
             * showSort : 1
             * bannerName : 但你没带走，梦里的所有
             * bannerUrl : www.github.com
             * bannerLogo : https://nwptest.oss-cn-hangzhou.aliyuncs.com/img/2018-06-15/1529031105934.jpg
             * startTime : 2018-06-01 00:00:00
             * endTime : 2018-06-30 00:00:00
             * bannerDetails :
             * enableFlag : 0
             * releaseBy : null
             * releaseDate : 2018-06-15 00:00:00
             * goodsList : null
             * shopList : null
             */

            private String id;
            private boolean isNewRecord;
            private Object remarks;
            private Object createDate;
            private Object updateDate;
            private String bannerStyle;
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
            private Object goodsList;
            private Object shopList;

            public String getBannerLabel() {
                return bannerLabel;
            }

            public void setBannerLabel(String bannerLabel) {
                this.bannerLabel = bannerLabel;
            }

            public String getBannerPreview() {
                return bannerPreview;
            }

            public void setBannerPreview(String bannerPreview) {
                this.bannerPreview = bannerPreview;
            }

            private String bannerLabel;
            private String bannerPreview;

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

            public String getBannerStyle() {
                return bannerStyle;
            }

            public void setBannerStyle(String bannerStyle) {
                this.bannerStyle = bannerStyle;
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

            public Object getGoodsList() {
                return goodsList;
            }

            public void setGoodsList(Object goodsList) {
                this.goodsList = goodsList;
            }

            public Object getShopList() {
                return shopList;
            }

            public void setShopList(Object shopList) {
                this.shopList = shopList;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.id);
                dest.writeByte(this.isNewRecord ? (byte) 1 : (byte) 0);
                dest.writeParcelable((Parcelable) this.remarks, flags);
                dest.writeParcelable((Parcelable) this.createDate, flags);
                dest.writeParcelable((Parcelable) this.updateDate, flags);
                dest.writeString(this.bannerStyle);
                dest.writeString(this.pageLocation);
                dest.writeInt(this.showSort);
                dest.writeString(this.bannerName);
                dest.writeString(this.bannerUrl);
                dest.writeString(this.bannerLogo);
                dest.writeString(this.startTime);
                dest.writeString(this.endTime);
                dest.writeString(this.bannerDetails);
                dest.writeString(this.enableFlag);
                dest.writeParcelable((Parcelable) this.releaseBy, flags);
                dest.writeString(this.releaseDate);
                dest.writeParcelable((Parcelable) this.goodsList, flags);
                dest.writeParcelable((Parcelable) this.shopList, flags);
                dest.writeString(this.bannerLabel);
                dest.writeString(this.bannerPreview);
            }

            public BannerListDataBean() {
            }

            protected BannerListDataBean(Parcel in) {
                this.id = in.readString();
                this.isNewRecord = in.readByte() != 0;
                this.remarks = in.readParcelable(Object.class.getClassLoader());
                this.createDate = in.readParcelable(Object.class.getClassLoader());
                this.updateDate = in.readParcelable(Object.class.getClassLoader());
                this.bannerStyle = in.readString();
                this.pageLocation = in.readString();
                this.showSort = in.readInt();
                this.bannerName = in.readString();
                this.bannerUrl = in.readString();
                this.bannerLogo = in.readString();
                this.startTime = in.readString();
                this.endTime = in.readString();
                this.bannerDetails = in.readString();
                this.enableFlag = in.readString();
                this.releaseBy = in.readParcelable(Object.class.getClassLoader());
                this.releaseDate = in.readString();
                this.goodsList = in.readParcelable(Object.class.getClassLoader());
                this.shopList = in.readParcelable(Object.class.getClassLoader());
                this.bannerLabel = in.readString();
                this.bannerPreview = in.readString();
            }

            public static final Parcelable.Creator<BannerListDataBean> CREATOR = new Parcelable.Creator<BannerListDataBean>() {
                @Override
                public BannerListDataBean createFromParcel(Parcel source) {
                    return new BannerListDataBean(source);
                }

                @Override
                public BannerListDataBean[] newArray(int size) {
                    return new BannerListDataBean[size];
                }
            };
        }
    }
}
