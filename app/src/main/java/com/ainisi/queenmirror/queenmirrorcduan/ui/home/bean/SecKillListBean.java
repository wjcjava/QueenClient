package com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean;

import java.util.List;

/**
 * 作者：linxi on 2018/10/10 13:35
 * 邮箱：707078566@qq.com
 * 用途：
 */
public class SecKillListBean {

    /**
     * success : true
     * errorCode : 0
     * msg : 成功
     * body : {"list":[{"id":"1","packageCover":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1538999647228&di=72bc074b3163ef7bea13046161627700&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimgad%2Fpic%2Fitem%2Ffaedab64034f78f0565fe4e773310a55b3191c49.jpg","packageName":"暧昧暧昧就发哦送积分DOI解决地方撒","packageGoodsName":"美发,溜溜小王子发型","packagePrice":"100","offlinePrice":"120","salesProgressRate":0},{"id":"f3175bd6119448db8804774345e1361f","packageCover":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/img/2018-10-10/1539138344925.png","packageName":"qw","packageGoodsName":"溜溜小王子发型,美发","packagePrice":"12","offlinePrice":"12","salesProgressRate":0}]}
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
        private List<ListBean> list;

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * id : 1
             * packageCover : https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1538999647228&di=72bc074b3163ef7bea13046161627700&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimgad%2Fpic%2Fitem%2Ffaedab64034f78f0565fe4e773310a55b3191c49.jpg
             * packageName : 暧昧暧昧就发哦送积分DOI解决地方撒
             * packageGoodsName : 美发,溜溜小王子发型
             * packagePrice : 100
             * offlinePrice : 120
             * salesProgressRate : 0
             */

            private String id;
            private String packageCover;
            private String packageThumb;
            private String packageName;
            private String packageGoodsName;
            private String packagePrice;
            private String offlinePrice;
            private int salesProgressRate;

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

            public String getPackageGoodsName() {
                return packageGoodsName;
            }

            public void setPackageGoodsName(String packageGoodsName) {
                this.packageGoodsName = packageGoodsName;
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

            public String getPackageThumb() {
                return packageThumb;
            }

            public void setPackageThumb(String packageThumb) {
                this.packageThumb = packageThumb;
            }
        }
    }
}
