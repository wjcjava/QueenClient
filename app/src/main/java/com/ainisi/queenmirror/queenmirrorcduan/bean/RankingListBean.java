package com.ainisi.queenmirror.queenmirrorcduan.bean;

import java.util.List;

/**
 * Created by john on 2018/9/19.
 *
 * jl
 */

public class RankingListBean {


    /**
     * success : true
     * errorCode : 0
     * msg : 成功
     * body : {"list":[{"shopId":"97f6494cad0f4c8e9c0dfb62d1f9f50a","shopName":"姜超的店铺","shopLogo":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018082403030531789497.jpg","comScore":"4.5","openTime":"10:00","closeTime":"20:00","queenCard":"0","discountCoupon":"5","magicBean":"7","bargainGoods":"13","groupGoods":"0","distance":"距432m","count":"15","categoryCover":null},{"shopId":"282d19687335493195cebd824fb282d2","shopName":"WZADH","shopLogo":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/201806300625002547516.jpg","comScore":"0.0","openTime":"10:00 ","closeTime":" 22:00","queenCard":"0","discountCoupon":"0","magicBean":"1","bargainGoods":"0","groupGoods":"0","distance":"距456m","count":"11","categoryCover":null},{"shopId":"8aafefe86274aefd016274b5dfaa008e","shopName":"名媛美甲","shopLogo":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/oldData/2018-07-10/1531201562819.png","comScore":"0.0","openTime":"08:00","closeTime":"21:00","queenCard":"1","discountCoupon":"0","magicBean":"0","bargainGoods":"0","groupGoods":"0","distance":"距13.47km","count":"5","categoryCover":null},{"shopId":"1cf4533fa5a54295ac8f7cb479a62dae","shopName":"会飞的企鹅","shopLogo":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018063005050384395529.jpg","comScore":"5.0","openTime":"12:00","closeTime":"23:00","queenCard":"0","discountCoupon":"6","magicBean":"2","bargainGoods":"0","groupGoods":"0","distance":"距34m","count":"4","categoryCover":null},{"shopId":"8aafefe86274aefd016275658e140787","shopName":"gd生活馆","shopLogo":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/oldData/2018-07-10/1531201690824.png","comScore":"0.0","openTime":"10:00","closeTime":"21:00","queenCard":"0","discountCoupon":"0","magicBean":"0","bargainGoods":"0","groupGoods":"0","distance":"距13.07km","count":"4","categoryCover":null},{"shopId":"2b0aa3070ea94dff863cbf32b321c801","shopName":"隔壁老王卖鸭店","shopLogo":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018070211324158635167.jpg","comScore":"5.0","openTime":"09:00","closeTime":"23:00","queenCard":"0","discountCoupon":"0","magicBean":"1","bargainGoods":"3","groupGoods":"0","distance":"距54m","count":"3","categoryCover":null},{"shopId":"8aafefe862734496016274adc3602e7b","shopName":"花涩日式美甲美睫","shopLogo":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/oldData/2018-07-10/1531201560739.png","comScore":"0.0","openTime":"09:00","closeTime":"21:00","queenCard":"0","discountCoupon":"0","magicBean":"0","bargainGoods":"0","groupGoods":"0","distance":"距6.73km","count":"3","categoryCover":null},{"shopId":"8aafefe86274aefd016274b8840100a2","shopName":"羿美堂祛斑美甲纹绣","shopLogo":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/oldData/2018-07-10/1531201563973.png","comScore":"0.0","openTime":"08:00","closeTime":"21:00","queenCard":"0","discountCoupon":"0","magicBean":"0","bargainGoods":"0","groupGoods":"0","distance":"距6.90km","count":"3","categoryCover":null},{"shopId":"a8636f2073eb4b89841195826ff68d41","shopName":"种太阳","shopLogo":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/201807131736275791415.jpg","comScore":"0.0","openTime":"06:30","closeTime":"20:00","queenCard":"0","discountCoupon":"2","magicBean":"1","bargainGoods":"0","groupGoods":"0","distance":"距556m","count":"3","categoryCover":null},{"shopId":"ae74440d352a4af3a7819c180dc8efbb","shopName":"啊啊啊美甲","shopLogo":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/201807140913463382615.jpg","comScore":"0.0","openTime":"09:00","closeTime":"21:00","queenCard":"0","discountCoupon":"0","magicBean":"0","bargainGoods":"0","groupGoods":"0","distance":"距456m","count":"3","categoryCover":null}]}
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
             * shopId : 97f6494cad0f4c8e9c0dfb62d1f9f50a
             * shopName : 姜超的店铺
             * shopLogo : https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018082403030531789497.jpg
             * comScore : 4.5
             * openTime : 10:00
             * closeTime : 20:00
             * queenCard : 0
             * discountCoupon : 5
             * magicBean : 7
             * bargainGoods : 13
             * groupGoods : 0
             * distance : 距432m
             * count : 15
             * categoryCover : null
             */

            private String shopId;
            private String shopName;
            private String shopLogo;
            private String comScore;
            private String openTime;
            private String closeTime;
            private String queenCard;
            private String discountCoupon;
            private String magicBean;
            private String bargainGoods;
            private String groupGoods;
            private String distance;
            private String count;
            private Object categoryCover;

            public String getShopId() {
                return shopId;
            }

            public void setShopId(String shopId) {
                this.shopId = shopId;
            }

            public String getShopName() {
                return shopName;
            }

            public void setShopName(String shopName) {
                this.shopName = shopName;
            }

            public String getShopLogo() {
                return shopLogo;
            }

            public void setShopLogo(String shopLogo) {
                this.shopLogo = shopLogo;
            }

            public String getComScore() {
                return comScore;
            }

            public void setComScore(String comScore) {
                this.comScore = comScore;
            }

            public String getOpenTime() {
                return openTime;
            }

            public void setOpenTime(String openTime) {
                this.openTime = openTime;
            }

            public String getCloseTime() {
                return closeTime;
            }

            public void setCloseTime(String closeTime) {
                this.closeTime = closeTime;
            }

            public String getQueenCard() {
                return queenCard;
            }

            public void setQueenCard(String queenCard) {
                this.queenCard = queenCard;
            }

            public String getDiscountCoupon() {
                return discountCoupon;
            }

            public void setDiscountCoupon(String discountCoupon) {
                this.discountCoupon = discountCoupon;
            }

            public String getMagicBean() {
                return magicBean;
            }

            public void setMagicBean(String magicBean) {
                this.magicBean = magicBean;
            }

            public String getBargainGoods() {
                return bargainGoods;
            }

            public void setBargainGoods(String bargainGoods) {
                this.bargainGoods = bargainGoods;
            }

            public String getGroupGoods() {
                return groupGoods;
            }

            public void setGroupGoods(String groupGoods) {
                this.groupGoods = groupGoods;
            }

            public String getDistance() {
                return distance;
            }

            public void setDistance(String distance) {
                this.distance = distance;
            }

            public String getCount() {
                return count;
            }

            public void setCount(String count) {
                this.count = count;
            }

            public Object getCategoryCover() {
                return categoryCover;
            }

            public void setCategoryCover(Object categoryCover) {
                this.categoryCover = categoryCover;
            }
        }
    }
}
