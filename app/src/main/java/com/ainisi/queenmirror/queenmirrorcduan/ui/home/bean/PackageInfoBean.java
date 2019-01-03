package com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean;

import java.util.List;

/**
 * 作者：linxi on 2018/10/11 15:06
 * 邮箱：707078566@qq.com
 * 用途：
 */
public class PackageInfoBean {

    /**
     * success : true
     * errorCode : 0
     * msg : 成功
     * body : {"secKillPackageInfo":{"id":"1","packageCover":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1538999647228&di=72bc074b3163ef7bea13046161627700&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimgad%2Fpic%2Fitem%2Ffaedab64034f78f0565fe4e773310a55b3191c49.jpg","packageName":"霸王套餐，只此一家","packageExplain":"Life is like a stroy, what you can do is to write it with your heart!","packageDetailsList":["https://nwptest.oss-cn-hangzhou.aliyuncs.com/img/2018-10-10/1539138355758.jpg","https://nwptest.oss-cn-hangzhou.aliyuncs.com/img/2018-10-10/1539138356108.jpg"],"packagePrice":"100","offlinePrice":"120","salesProgressRate":0,"secKillGoodsList":[{"id":"1","goodsName":"美发","goodsCover":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/img/2018-10-08/1538977385048.png"},{"id":"67b49714b29c47928eb13577b436a22f","goodsName":"溜溜小王子发型","goodsCover":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/img/2018-10-08/1538982402493.png"}]}}
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
        /**
         * secKillPackageInfo : {"id":"1","packageCover":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1538999647228&di=72bc074b3163ef7bea13046161627700&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimgad%2Fpic%2Fitem%2Ffaedab64034f78f0565fe4e773310a55b3191c49.jpg","packageName":"霸王套餐，只此一家","packageExplain":"Life is like a stroy, what you can do is to write it with your heart!","packageDetailsList":["https://nwptest.oss-cn-hangzhou.aliyuncs.com/img/2018-10-10/1539138355758.jpg","https://nwptest.oss-cn-hangzhou.aliyuncs.com/img/2018-10-10/1539138356108.jpg"],"packagePrice":"100","offlinePrice":"120","salesProgressRate":0,"secKillGoodsList":[{"id":"1","goodsName":"美发","goodsCover":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/img/2018-10-08/1538977385048.png"},{"id":"67b49714b29c47928eb13577b436a22f","goodsName":"溜溜小王子发型","goodsCover":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/img/2018-10-08/1538982402493.png"}]}
         */

        private SecKillPackageInfoBean secKillPackageInfo;

        public SecKillPackageInfoBean getSecKillPackageInfo() {
            return secKillPackageInfo;
        }

        public void setSecKillPackageInfo(SecKillPackageInfoBean secKillPackageInfo) {
            this.secKillPackageInfo = secKillPackageInfo;
        }

        public static class SecKillPackageInfoBean {
            /**
             * id : 1
             * packageCover : https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1538999647228&di=72bc074b3163ef7bea13046161627700&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimgad%2Fpic%2Fitem%2Ffaedab64034f78f0565fe4e773310a55b3191c49.jpg
             * packageName : 霸王套餐，只此一家
             * packageExplain : Life is like a stroy, what you can do is to write it with your heart!
             * packageDetailsList : ["https://nwptest.oss-cn-hangzhou.aliyuncs.com/img/2018-10-10/1539138355758.jpg","https://nwptest.oss-cn-hangzhou.aliyuncs.com/img/2018-10-10/1539138356108.jpg"]
             * packagePrice : 100
             * offlinePrice : 120
             * salesProgressRate : 0
             * secKillGoodsList : [{"id":"1","goodsName":"美发","goodsCover":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/img/2018-10-08/1538977385048.png"},{"id":"67b49714b29c47928eb13577b436a22f","goodsName":"溜溜小王子发型","goodsCover":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/img/2018-10-08/1538982402493.png"}]
             */

            private String id;
            private String packageCover;
            private String packageName;
            private String packageExplain;
            private String packagePrice;
            private String offlinePrice;
            private boolean quotaStatus;
            private int salesProgressRate;
            private List<String> packageDetailsList;
            private List<SecKillGoodsListBean> secKillGoodsList;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getPackageCover() {
                return packageCover;
            }

            public void setPackageCover(String packageCover) {
                this.packageCover = packageCover;
            }

            public String getPackageName() {
                return packageName;
            }

            public void setPackageName(String packageName) {
                this.packageName = packageName;
            }

            public String getPackageExplain() {
                return packageExplain;
            }

            public void setPackageExplain(String packageExplain) {
                this.packageExplain = packageExplain;
            }

            public String getPackagePrice() {
                return packagePrice;
            }

            public void setPackagePrice(String packagePrice) {
                this.packagePrice = packagePrice;
            }

            public String getOfflinePrice() {
                return offlinePrice;
            }

            public void setOfflinePrice(String offlinePrice) {
                this.offlinePrice = offlinePrice;
            }

            public int getSalesProgressRate() {
                return salesProgressRate;
            }

            public void setSalesProgressRate(int salesProgressRate) {
                this.salesProgressRate = salesProgressRate;
            }

            public List<String> getPackageDetailsList() {
                return packageDetailsList;
            }

            public void setPackageDetailsList(List<String> packageDetailsList) {
                this.packageDetailsList = packageDetailsList;
            }

            public List<SecKillGoodsListBean> getSecKillGoodsList() {
                return secKillGoodsList;
            }

            public void setSecKillGoodsList(List<SecKillGoodsListBean> secKillGoodsList) {
                this.secKillGoodsList = secKillGoodsList;
            }

            public boolean isQuotaStatus() {
                return quotaStatus;
            }

            public void setQuotaStatus(boolean quotaStatus) {
                this.quotaStatus = quotaStatus;
            }

            public static class SecKillGoodsListBean {
                /**
                 * id : 1
                 * goodsName : 美发
                 * goodsCover : https://nwptest.oss-cn-hangzhou.aliyuncs.com/img/2018-10-08/1538977385048.png
                 */

                private String id;
                private String goodsName;
                private String goodsCover;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getGoodsName() {
                    return goodsName;
                }

                public void setGoodsName(String goodsName) {
                    this.goodsName = goodsName;
                }

                public String getGoodsCover() {
                    return goodsCover;
                }

                public void setGoodsCover(String goodsCover) {
                    this.goodsCover = goodsCover;
                }
            }
        }
    }
}
