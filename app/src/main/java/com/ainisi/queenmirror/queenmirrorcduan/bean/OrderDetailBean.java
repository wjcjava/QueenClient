package com.ainisi.queenmirror.queenmirrorcduan.bean;

import java.util.List;

/**
 * Created by john on 2018/6/25.
 */

public class OrderDetailBean {


    /**
     * success : true
     * errorCode : 0
     * msg : 获取数据成功
     * body : {"apiOrderShop":{"orderId":"ab2e43ced16d4b9b9e5ad7de704a96df","orderNo":"1806200005100200","orderPlatform":"3","shopId":"d732cc97c55748de99659e82b917cc09","custId":"101d06da2e1a4f9ca61d1d3652b10f1b","custName":"13405024815","custTelNo":"13405024815","orderTime":1529892152000,"takeTime":1529892600000,"consumeQrcode":"1f442629a1908a7d8c450b123f8e32ce","qrcodeSource":null,"verifyTime":"2018-06-25 10:11:19.0","finishTime":null,"confirmTime":null,"orderAmount":0.02,"cpMethod":null,"cpAmount":0,"discountAmount":0,"usePoints":0,"afterAmount":0.02,"paymentMethod":"5","paymentKeys":null,"paymentTime":1529892276000,"orderStatus":"FN","custRemarks":null,"transId":"3180625110043650000000000","shopName":"姜超的店铺","cpScope":null,"apiDetailsOrderList":[{"goodsId":"7d76970814e34028b89613e01c7802b9","goodsName":"测试2号","unitPrice":"0.01","purchaseNumber":"1","sumAmount":"0.01","cpAmount":0,"discountAmount":0,"usePoints":0,"afterAmount":0.01,"consumeQrcode":null,"detailsRemarks":null,"detailsStatus":"FN","goodsThumb":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062312055086229019.jpg"},{"goodsId":"b1556511bd4846688e9fab2b14a9c784","goodsName":"测试1号","unitPrice":"0.01","purchaseNumber":"1","sumAmount":"0.01","cpAmount":0,"discountAmount":0,"usePoints":0,"afterAmount":0.01,"consumeQrcode":null,"detailsRemarks":null,"detailsStatus":"FN","goodsThumb":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062312061658316625.jpg"}]}}
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
         * apiOrderShop : {"orderId":"ab2e43ced16d4b9b9e5ad7de704a96df","orderNo":"1806200005100200","orderPlatform":"3","shopId":"d732cc97c55748de99659e82b917cc09","custId":"101d06da2e1a4f9ca61d1d3652b10f1b","custName":"13405024815","custTelNo":"13405024815","orderTime":1529892152000,"takeTime":1529892600000,"consumeQrcode":"1f442629a1908a7d8c450b123f8e32ce","qrcodeSource":null,"verifyTime":"2018-06-25 10:11:19.0","finishTime":null,"confirmTime":null,"orderAmount":0.02,"cpMethod":null,"cpAmount":0,"discountAmount":0,"usePoints":0,"afterAmount":0.02,"paymentMethod":"5","paymentKeys":null,"paymentTime":1529892276000,"orderStatus":"FN","custRemarks":null,"transId":"3180625110043650000000000","shopName":"姜超的店铺","cpScope":null,"apiDetailsOrderList":[{"goodsId":"7d76970814e34028b89613e01c7802b9","goodsName":"测试2号","unitPrice":"0.01","purchaseNumber":"1","sumAmount":"0.01","cpAmount":0,"discountAmount":0,"usePoints":0,"afterAmount":0.01,"consumeQrcode":null,"detailsRemarks":null,"detailsStatus":"FN","goodsThumb":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062312055086229019.jpg"},{"goodsId":"b1556511bd4846688e9fab2b14a9c784","goodsName":"测试1号","unitPrice":"0.01","purchaseNumber":"1","sumAmount":"0.01","cpAmount":0,"discountAmount":0,"usePoints":0,"afterAmount":0.01,"consumeQrcode":null,"detailsRemarks":null,"detailsStatus":"FN","goodsThumb":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062312061658316625.jpg"}]}
         */

        private ApiOrderShopBean apiOrderShop;

        public ApiOrderShopBean getApiOrderShop() {
            return apiOrderShop;
        }

        public void setApiOrderShop(ApiOrderShopBean apiOrderShop) {
            this.apiOrderShop = apiOrderShop;
        }

        public static class ApiOrderShopBean {
            /**
             * orderId : ab2e43ced16d4b9b9e5ad7de704a96df
             * orderNo : 1806200005100200
             * orderPlatform : 3
             * shopId : d732cc97c55748de99659e82b917cc09
             * custId : 101d06da2e1a4f9ca61d1d3652b10f1b
             * custName : 13405024815
             * custTelNo : 13405024815
             * orderTime : 1529892152000
             * takeTime : 1529892600000
             * consumeQrcode : 1f442629a1908a7d8c450b123f8e32ce
             * qrcodeSource : null
             * verifyTime : 2018-06-25 10:11:19.0
             * finishTime : null
             * confirmTime : null
             * orderAmount : 0.02
             * cpMethod : null
             * cpAmount : 0.0
             * discountAmount : 0.0
             * usePoints : 0
             * afterAmount : 0.02
             * paymentMethod : 5
             * paymentKeys : null
             * paymentTime : 1529892276000
             * orderStatus : FN
             * custRemarks : null
             * transId : 3180625110043650000000000
             * shopName : 姜超的店铺
             * cpScope : null
             * apiDetailsOrderList : [{"goodsId":"7d76970814e34028b89613e01c7802b9","goodsName":"测试2号","unitPrice":"0.01","purchaseNumber":"1","sumAmount":"0.01","cpAmount":0,"discountAmount":0,"usePoints":0,"afterAmount":0.01,"consumeQrcode":null,"detailsRemarks":null,"detailsStatus":"FN","goodsThumb":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062312055086229019.jpg"},{"goodsId":"b1556511bd4846688e9fab2b14a9c784","goodsName":"测试1号","unitPrice":"0.01","purchaseNumber":"1","sumAmount":"0.01","cpAmount":0,"discountAmount":0,"usePoints":0,"afterAmount":0.01,"consumeQrcode":null,"detailsRemarks":null,"detailsStatus":"FN","goodsThumb":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062312061658316625.jpg"}]
             */

            private String orderId;
            private String orderNo;
            private String shopAddress;
            private String geoX;
            private String geoY;
            private String orderPlatform;
            private String shopId;
            private String custId;
            private String custName;
            private String custTelNo;
            private String orderTime;
            private String takeTime;
            private String consumeQrcode;
            private String qrcodeSource;
            private String verifyTime;
            private String finishTime;
            private String confirmTime;
            private String orderAmount;
            private String cpMethod;
            private String cpAmount;
            private String discountAmount;
            private String usePoints;
            private String afterAmount;
            private String paymentMethod;
            private String paymentKeys;
            private String paymentTime;
            private String orderStatus;
            private String custRemarks;
            private String transId;
            private String shopName;
            private String cpScope;
            private List<ApiDetailsOrderListBean> apiDetailsOrderList;

            public String getOrderId() {
                return orderId;
            }

            public void setOrderId(String orderId) {
                this.orderId = orderId;
            }

            public String getOrderNo() {
                return orderNo;
            }

            public void setOrderNo(String orderNo) {
                this.orderNo = orderNo;
            }

            public String getOrderPlatform() {
                return orderPlatform;
            }

            public void setOrderPlatform(String orderPlatform) {
                this.orderPlatform = orderPlatform;
            }

            public String getShopId() {
                return shopId;
            }

            public void setShopId(String shopId) {
                this.shopId = shopId;
            }

            public String getCustId() {
                return custId;
            }

            public void setCustId(String custId) {
                this.custId = custId;
            }

            public String getCustName() {
                return custName;
            }

            public void setCustName(String custName) {
                this.custName = custName;
            }

            public String getCustTelNo() {
                return custTelNo;
            }

            public void setCustTelNo(String custTelNo) {
                this.custTelNo = custTelNo;
            }

            public String getOrderTime() {
                return orderTime;
            }

            public void setOrderTime(String orderTime) {
                this.orderTime = orderTime;
            }


            public String getConsumeQrcode() {
                return consumeQrcode;
            }

            public void setConsumeQrcode(String consumeQrcode) {
                this.consumeQrcode = consumeQrcode;
            }


            public String getVerifyTime() {
                return verifyTime;
            }

            public void setVerifyTime(String verifyTime) {
                this.verifyTime = verifyTime;
            }


            public String getPaymentMethod() {
                return paymentMethod;
            }

            public void setPaymentMethod(String paymentMethod) {
                this.paymentMethod = paymentMethod;
            }

            public String getTakeTime() {
                return takeTime;
            }

            public void setTakeTime(String takeTime) {
                this.takeTime = takeTime;
            }

            public String getQrcodeSource() {
                return qrcodeSource;
            }

            public void setQrcodeSource(String qrcodeSource) {
                this.qrcodeSource = qrcodeSource;
            }

            public String getFinishTime() {
                return finishTime;
            }

            public void setFinishTime(String finishTime) {
                this.finishTime = finishTime;
            }

            public String getConfirmTime() {
                return confirmTime;
            }

            public void setConfirmTime(String confirmTime) {
                this.confirmTime = confirmTime;
            }

            public String getOrderAmount() {
                return orderAmount;
            }

            public void setOrderAmount(String orderAmount) {
                this.orderAmount = orderAmount;
            }

            public String getCpMethod() {
                return cpMethod;
            }

            public void setCpMethod(String cpMethod) {
                this.cpMethod = cpMethod;
            }

            public String getCpAmount() {
                return cpAmount;
            }

            public void setCpAmount(String cpAmount) {
                this.cpAmount = cpAmount;
            }

            public String getDiscountAmount() {
                return discountAmount;
            }

            public void setDiscountAmount(String discountAmount) {
                this.discountAmount = discountAmount;
            }

            public String getUsePoints() {
                return usePoints;
            }

            public void setUsePoints(String usePoints) {
                this.usePoints = usePoints;
            }

            public String getAfterAmount() {
                return afterAmount;
            }

            public void setAfterAmount(String afterAmount) {
                this.afterAmount = afterAmount;
            }

            public String getPaymentKeys() {
                return paymentKeys;
            }

            public void setPaymentKeys(String paymentKeys) {
                this.paymentKeys = paymentKeys;
            }

            public String getPaymentTime() {
                return paymentTime;
            }

            public void setPaymentTime(String paymentTime) {
                this.paymentTime = paymentTime;
            }

            public String getOrderStatus() {
                return orderStatus;
            }

            public void setOrderStatus(String orderStatus) {
                this.orderStatus = orderStatus;
            }

            public String getCustRemarks() {
                return custRemarks;
            }

            public void setCustRemarks(String custRemarks) {
                this.custRemarks = custRemarks;
            }

            public String getCpScope() {
                return cpScope;
            }

            public void setCpScope(String cpScope) {
                this.cpScope = cpScope;
            }

            public String getTransId() {
                return transId;
            }

            public void setTransId(String transId) {
                this.transId = transId;
            }

            public String getShopName() {
                return shopName;
            }

            public void setShopName(String shopName) {
                this.shopName = shopName;
            }


            public List<ApiDetailsOrderListBean> getApiDetailsOrderList() {
                return apiDetailsOrderList;
            }

            public void setApiDetailsOrderList(List<ApiDetailsOrderListBean> apiDetailsOrderList) {
                this.apiDetailsOrderList = apiDetailsOrderList;
            }

            public String getShopAddress() {
                return shopAddress;
            }

            public void setShopAddress(String shopAddress) {
                this.shopAddress = shopAddress;
            }

            public String getGeoX() {
                return geoX;
            }

            public void setGeoX(String geoX) {
                this.geoX = geoX;
            }

            public String getGeoY() {
                return geoY;
            }

            public void setGeoY(String geoY) {
                this.geoY = geoY;
            }

            public static class ApiDetailsOrderListBean {
                /**
                 * goodsId : 7d76970814e34028b89613e01c7802b9
                 * goodsName : 测试2号
                 * unitPrice : 0.01
                 * purchaseNumber : 1
                 * sumAmount : 0.01
                 * cpAmount : 0.0
                 * discountAmount : 0.0
                 * usePoints : 0
                 * afterAmount : 0.01
                 * consumeQrcode : null
                 * detailsRemarks : null
                 * detailsStatus : FN
                 * goodsThumb : https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062312055086229019.jpg
                 */

                private String goodsId;
                private String goodsName;
                private String unitPrice;
                private String purchaseNumber;
                private String sumAmount;
                private double cpAmount;
                private double discountAmount;
                private int usePoints;
                private double afterAmount;
                private Object consumeQrcode;
                private Object detailsRemarks;
                private String detailsStatus;
                private String goodsThumb;
                private double memberDiscount;//女王会员折扣
                private double redPacketDiscount;//红包
                private double couponDiscount;//优惠券

                public double getMemberDiscount() {
                    return memberDiscount;
                }

                public void setMemberDiscount(double memberDiscount) {
                    this.memberDiscount = memberDiscount;
                }

                public double getRedPacketDiscount() {
                    return redPacketDiscount;
                }

                public void setRedPacketDiscount(double redPacketDiscount) {
                    this.redPacketDiscount = redPacketDiscount;
                }

                public double getCouponDiscount() {
                    return couponDiscount;
                }

                public void setCouponDiscount(double couponDiscount) {
                    this.couponDiscount = couponDiscount;
                }

                public String getGoodsId() {
                    return goodsId;
                }

                public void setGoodsId(String goodsId) {
                    this.goodsId = goodsId;
                }

                public String getGoodsName() {
                    return goodsName;
                }

                public void setGoodsName(String goodsName) {
                    this.goodsName = goodsName;
                }

                public String getUnitPrice() {
                    return unitPrice;
                }

                public void setUnitPrice(String unitPrice) {
                    this.unitPrice = unitPrice;
                }

                public String getPurchaseNumber() {
                    return purchaseNumber;
                }

                public void setPurchaseNumber(String purchaseNumber) {
                    this.purchaseNumber = purchaseNumber;
                }

                public String getSumAmount() {
                    return sumAmount;
                }

                public void setSumAmount(String sumAmount) {
                    this.sumAmount = sumAmount;
                }

                public double getCpAmount() {
                    return cpAmount;
                }

                public void setCpAmount(double cpAmount) {
                    this.cpAmount = cpAmount;
                }

                public double getDiscountAmount() {
                    return discountAmount;
                }

                public void setDiscountAmount(double discountAmount) {
                    this.discountAmount = discountAmount;
                }

                public int getUsePoints() {
                    return usePoints;
                }

                public void setUsePoints(int usePoints) {
                    this.usePoints = usePoints;
                }

                public double getAfterAmount() {
                    return afterAmount;
                }

                public void setAfterAmount(double afterAmount) {
                    this.afterAmount = afterAmount;
                }

                public Object getConsumeQrcode() {
                    return consumeQrcode;
                }

                public void setConsumeQrcode(Object consumeQrcode) {
                    this.consumeQrcode = consumeQrcode;
                }

                public Object getDetailsRemarks() {
                    return detailsRemarks;
                }

                public void setDetailsRemarks(Object detailsRemarks) {
                    this.detailsRemarks = detailsRemarks;
                }

                public String getDetailsStatus() {
                    return detailsStatus;
                }

                public void setDetailsStatus(String detailsStatus) {
                    this.detailsStatus = detailsStatus;
                }

                public String getGoodsThumb() {
                    return goodsThumb;
                }

                public void setGoodsThumb(String goodsThumb) {
                    this.goodsThumb = goodsThumb;
                }
            }
        }
    }
}
