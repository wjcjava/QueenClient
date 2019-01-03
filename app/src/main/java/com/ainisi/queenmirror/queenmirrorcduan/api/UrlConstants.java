package com.ainisi.queenmirror.queenmirrorcduan.api;

/**
 * 网络请求地址库
 * <p>
 * <p>
 * 作者： jc
 */

public interface UrlConstants {

//    String BASE_URL = "http://192.168.50.126:8080/a/";//孙继鹏

    //String BASE_URL = "http://192.168.50.199:8080/wg/a/";//张作西

//   String BASE_URL = "http://192.168.50.177:8080/wg/a/"; //拼团

//    String BASE_URL = "http://qm.jiyuanet.com/wg/a/";

//    String BASE_URL = "http://192.168.50.235:8080/wg/a/";//刘璇

//    String BASE_URL = "http://192.168.50.152:8080/wg/a/";//潘章宝

//    String BASE_URL = "http://58.210.102.70:7080/wg/a/";//外网

//    String BASE_URL = "http://58.210.102.70:443/wg/a/";

//    String BASE_URL = "http://192.168.30.155:7080/wg/a/";//测试服务器

    String BASE_URL = "http://192.168.50.134:8080/wg/a/";//李佳

//    String BASE_URL = "http://192.168.50.61:8080/wg/a/";//王允

    String ADVERTISING = "api/ec/common/advertisementList";//首页广告``
    String HEADLINES = "api/ec/common/topList";//首页的女王头条
    String INDUSTRY = "api/ec/common/categoryList ";//首页的行业分类
    String MESSAGE = "api/ec/message/messageTypeList";//首页的消息类型列表
    String MESSAGELIST = "api/ec/message/messageList";//首页的消息列表
    String REGIST = "api/ans/login/userRegister";//请求方法名(注册)
    String VERIFY = "api/ans/login/verifyCodeGet";//请求方法名(获取验证码)
    String LOGIN = "api/ans/login/userLogin";//登录
    String LIST = "api/ans/refund/refundApplyList";//测试（listce测试）
    String ALLOFMYORDER = "api/ans /order/orderListOnly";//获取我的全部订单
    String SHOPLIST = "api/ans/shop/listV";//商城中商家列表
    String SHOPTUIJIANLIST = "api/ans/shop/recommendGoodsList";//商家推荐商品列表
    String SHOPSALEPRODUCT = "api/ans/shop/shopGoodsList";//商家所卖商品列表
    String SHOPXINYONG = "api/ans/shop/shopScoreGet";//获取门店信用数据
    String SHOPDETAILDATA = "api/ans/shop/details";//获取商家具体信息
    String MINECOLLECTION = "api/ans/cust/userCollectList";//获取我的收藏列表
    String MYFOOT = "api/ans/cust/userViewList";//我的足迹
    String EVALUATION = "api/ec/goods/goodsCommentsList";//商品的评价数据
    String MERCHANTS = "api/ans/shop/shopCommentsList";//商家的评价数据
    String CLASSIFICATION = "api/ans/shop/shoplistByCategory";//商家分类列表
    String MINEINSHOP = "api/ans/cust/userFollowList";//获取我关注的店铺
    String GUANZHUSHOP = "api/ans/shop/followShop";//关注店铺
    String CANCELGUANZHUSHOP = "api/ans/shop/unFollowShop";//取消关注店铺
    String JUBAOSHOP = "api/ans/shop/complainShop";//举报商家
    String REFUND = "api/ans/refund/refundApplyList";//获取退款列表
    String COMMENDGOODS = "api/ans/shop/recommendGoodsList";//商家推荐商品的数据
    String ADDLIULAN = "api/ec/goods/shopBrowsesChange";//商家浏览次数增加
    String ADDGOODSLIULAN = "api/ec/goods/goodsBrowsesChange";//商品浏览次数增加
    String COLLECTIONPRODUCT = "api/ec/goods/collectGoods";//收藏商品
    String CANCELCOLLECTION = "api/ec/goods/unCollectGoods";//取消收藏商品
    String LABEL = "api/ec/common/tabList";//搜索标签信息
    String MERCHANTSLIST = "api/ans/shop/recommendListByCondition";//商家列表分类
    String ACTIVITYGOODS = "api/ec/common/goodsListByActivity";//商品活动列表
    String ACTIVITYSHOPS = "api/ec/common/shopListByActivity";//参与活动的商家列表
    String SHOPCARTADD = "api/ans/cart/shopCartAdd";//加入购物车
    String ADDTOCAT = "api/ans/cart/shopCartAdd";//加入购物车
    String GETCITYLIST = "api/ec/city/cityList";//获取城市列表
    String GETPRODUCTDETAIL = "api/ec/goods/details";//获取商品详情
    String GETSHOPPINDCART = "api/ans/cart/shopCartGet";//搜索购物车
    String CHANGENUMBERCART = "api/ans/cart/shopCartNumEdit";//改变购物车数量
    String DELETESHOPCART = "api/ans/cart/shopCartDelete";//删除购物车
    String MYCOMMENTS = "api/ans/cust/userCommentsList";//我的评论
    String CHANGEPASSWORD = "api/ans/login/userModifyPass";//修改密码
    String LOGINOUT = "api/ans/login/userlogout";//退出登录账号
    String CHANGENAME = "api/ans/cust/userNameModify";//用户修
    String GETNEWNEWS = "api/ec/message/messTypeList";//获取新消息提示
    String CHECKOPENID = "api/ans/login/snsUserOpenIdCheck";//第三方登录检验OpenId
    String THIRDLOGINONE = "api/ans/login/snsUserLogin";//第三方直接登录
    String SHOPDISCOUN = "api/ans/coupon/couponList";//商家优惠券
    String RECEIVEDISCOUN = "api/ans/coupon/custCouponList";//商家所领取优惠券
    String LISTFOEUSE = "api/ans/coupon/couponListForUse";//可以优惠券列表（订单）
    String QUEENDETAILS = "api/ans/queen/queenCardDetails";//女王卡详情
    String UPLOADORDER = "api/ans/order/orderSubmit";//提交订单
    String PHONECHECK = "api/ans/login/phoneCheck";//确认手机号是否已注册
    String FORGOTPASSWORD = "api/ans/login/userForgotPass";//忘记密码
    String COUPONGET = "api/ans/coupon/couponGet";//优惠券领取
    String USERBIND = "api/ans/login/snsUserBindingAccount";//客户端绑定第三方账号
    String PROBLEMLIST = "api/ec/help/questionCategoryList";//常见问题分类
    String PROBLEMDATA = "api/ec/help/questionListByCategory";//常见问题分类的数据
    String PayBefore = "api/util/alipay/orderAliPay";//支付之前调用数据
    String DOOUTDATA = "api/ans/refund/refundApplySubmit";//退款
    String GETUSEYOUHUIQUAN = "api/ans/coupon/couponListForUse";//获取可用的优惠券
    String SPELLDETAILS = "api/ans/group/groupActivityDetails";//拼单详情
    String SPELLCOLLECTION = "api/ans/group/collectGroup";//收藏拼单
    String CANCLEORDER = "api/ans/order/custOrderCancel";//取消订单
    String BEMEIYEREN = "api/ec/beauty/beautyApply";//申请成为美业人
    String AliPayAfterRefresh = "api/util/alipay/orderAliPayAfterRefresh";//订单支付宝支付后结果查询
    String MERCHANTACTIVITY = "api/ec/common/activityList";//商家活动（首页筛选）
    String MERCHANTFEATURES = "api/ec/common/featureList";//商家特色（首页筛选）
    String GETZXING = "api/ans/order/custOrderQrGet";//获取二维码内容
    String CONFIMSERVICE = "api/ans/order/custOrderConfirm";//完成服务
    String GETMINEMODOU = "api/ans/points/pointsNowGet";//获取我的魔豆余额
    String GETMINEMODOUBEAN = "api/ans/points/pointsChargeListByTime";//获取我的魔豆列表
    String GETMONTHMODOU = "api/ans/points/pointsChargeSumByMonth";//魔豆按月支出收入
    String COMMENTPRO = "api/ec/goods/goodsCommentsSubmit";//商品评价
    String PAYUSENVWANGCARD = "api/util/pay/orderQueenCardPay";//女王卡支付
    String WHETHERPASS = "api/util/pay/payPassCheck"; //判断是否有支付密码
    String MYWALLIET = "api/ans/cust/myWallet";//我的余额
    String TOUCHBALANCE = "api/ans/cust/myWalletChargeList";//余额明细
    String FORGOTPAYPASS = "api/ans/cust/forgotPayPass";//忘记支付密码
    String AMENTPAY = "api/ans/cust/modifyPayPass";//修改支付密码
    String SETPAYPASS = "api/ans/cust/setPayPass";//设置支付密码
    String QUEENCHARGE = "api/util/alipay/queenChargeAliPay";//女王卡支付宝充值
    String PAYAFTERREFRESH = "api/util/alipay/queenChargeAliPayAfterRefresh";//女王卡充值后查看结果
    String GOODLIST = "api/ec/goods/list";//商品数据的列表
    String PAYNOWINPAY = "api/ans/order/purchaseNow";//立即付款获取订单编号
    String PAYPASSWORDCHECK = "api/util/pay/payPassCheck";//支付密码判断是否存在
    String PAYINYUEDATA = "api/util/pay/orderOwnAccountPay";//余额支付订单
    String CommentReplyList = "api/ec/goods/goodsCommentReplyList";//商品评价回复数据
    String INVITEPRIZE = "api/ans/login/inviteUrlGenForC";//(我的H5)邀请有奖
    String INVITEBDUAN = "api/ans/login/inviteUrlGenForB";//邀请开店
    String REALNAME = "api/ans/cust/userNameAuth";//实名认证
    String COMMENTINPUT = "api/ec/goods/goodsCommentsReply";//评论回复
    String OSSGETTOKEN = "api/ans/oss/securityTokenApply";
    String WEBVIEWAGREEMENT = "api/ans/protocal/query";//服务协议
    String TUANDUILISTDATA = "api/ans/group/groupActivityListV";//我要拼团列表
    String GETSHAPE = "api/ans/login/imgValidateCodeGet";//获取图形验证码
    String NEWSHOPlIST = "api/ans/shop/newShopList";//获取今日新店列表
    String PAGEBANNER = "api/ec/common/topPageBannerListV1";//获取Banner信息数据

    String GOODSBANNER = "api/ec/common/goodsListByBanner";//获取参与Banner商品数据
    String SHOPSBANNER = "api/ec/common/shopListByBanner";//获取参与Banner商家数据
    String GETPINTUANDATA = "api/ans/gporder/gporders";//获取拼团之外信息
    String ADDPINTUAN = "api/ans/gporder/save";//开启拼团
    String GETPINTUANAFTER = "api/ans/gporder/detailsBySelf";//获取拼团后的数据
    String HEADPICUPLOAD = "api/ans/cust/userHeaderUpload";//头像上传
    String SHOPPAYCHECK = "api/ans/gporder/payCheck";//待付款订单付款前的校验
    String SHOPBYSALES = "api/ans/shop/shoplistBySalesV";//首页店铺按销量
    String ORDERDETAIL = "api/ans/order/orderDetails";//获取订单详情数据
    String ORDERNVWANGPAy = "api/util/pay/gporderQueenCardPay";//拼团女王卡支付
    String ORDERZHIFUBAOPAY = "api/util/alipay/gporderAliPay";//拼团支付宝付款
    String ORDERyuepay = "api/util/pay/gporderOwnAccountPay";//拼团余额支付
    String ORDERPAYBYWECHAT = "api/util/wechatpay/orderWechatPay";//订单微信支付
    String ORDERPAYWEHCATSUCCESS = "api/util/wechatpay/orderWechatPayAfterRefresh";//订单微信支付成功后回调
    String QUEENPAYINWECHAT = "api/util/wechatpay/queenChargeWechatPay";//女王卡充值微信支付
    String SHOPLISTBYZONGHE = "api/ans/shop/shoplistByQueenV";//点击获取美业首页综合排序
    String SHOPLISTBYSOCORE = "api/ans/shop/shoplistByScoreV";//首页美业评分从高到低
    String SHOPLISTBYLOOK = "api/ans/shop/shoplistByBrowsesV";//浏览量从高到低
    String SHOPLISTBYAREACODE = "api/ec/city/districtListByCode";//根据城市code获取区域
    String SHOPLISTBYAREANEAR = "api/ans/shop/shoplistByDistrictV";//根据附近商家获取商铺信息
    String SHOPLISTBYDISTANCE = "api/ans/shop/shoplistByDistanceV";//根据距离
    String SEARCHKEY = "api/ec/common/searchKeyList";//搜索标签
    String GETSHOPSCORE = "api/ec/goods/goodsScoreGet";//获取店铺分数
    String MESSAGEDETAIL = "api/ec/message/messList";//消息详情
    String QUEENBUYRECORD = "api/ans/queen/queenCardOrderList";//
    String GETPEOPLEBYSHARE = "api/ans/points/findByInvitee";//查看邀请好友数量和获得魔豆
    String GETHELPURL = "api/ec/help/proposalUrlGet";//获取帮助反馈
    String CHECKQUEENCARD = "api/ans/cust/queenCardPayCheck";//判断是否可以进行女王卡支付
    String CHECKNEWAPK = "api/ans/androidVersion/query";//判断是否有新的版本
    String GETDATABYSHAIXUAN = "api/ans/shop/shoplistByFilterV";//筛选获取数据
    String WORKROOMDETAIL = "api/ans/shop/topGoodsList";
    String QIANDAODAY = "api/ans/cust/custSigninDaily";//每日签到

    String QIANDAODAYSTATUS = "api/ans/cust/custSigninDailyStatus";//每日签到状态

    String ISGPORDER = "api/ans/gporder/isGporder";//查看订单是否为拼团订单

    String CPTUIKUAN = "api/ans/refund/refundApplySubmitGpOrder";//拼团退款

    String GPCANCELORDER = "api/ans/order/custGpOrderCancel";//取消拼团订单

    String GETQUEENCARDPAYSTYLE = "api/ans/cust/queenMemberTypeGet";//购买女王卡月份

    String QUEENROYALTY = "api/ans/ansQueenRoyalty/query";//女王特权

    String MINEQUEENCARDBUY = "api/util/wechatpay/queenMemberChargeWechatPay";//购买女王会员

    String MINEQUEENCARDALIPY = "api/util/alipay/queenMemberChargeAliPay";//购买女王卡支付宝支付

    String GETHUIYUANSTAUTE = "api/ans/cust/queenMemberStatusGet";//获取会员状态

    String HUIYUANACTIVITYSTAUTE = "api/ans/memberActivity/hasFreeMember";//会员活动状态

    String SETFREESTATUEDATA = "api/ans/memberActivity/gotFreeMember";//设置免费试用

    String QUEENROYALTYACTIVITY = "api/ans/cardSecret/activate";//激活码兑换

    String QUEENCARDBUYRECORD = "api/ans/queenMember/records";//女王卡购买记录

    String QUEENCARDREGISTLOGIN = "api/ans/memberActivity/hasCommonRegister";//女王卡完成注册登录

    String GETQUEENREGISTCARD = "api/ans/memberActivity/gotCommonRegister";//领取注册登录女王会员

    String GOINREDPACKETHOMEPAGE = "api/ans/redPacket/forNewOne";//用户进入C端后调用红包弹层信息

    String CHAIREDPACKET = "api/ans/redPacket/openRedPacket";//拆红包

    String ISFIRSTORDER = "api/ans/redPacket/firstOrder";//是否首次订单

    String GETMINEREDPACKETRECORD = "api/ans/redPacket/records";//获取我的红包记录

    String GETMINEUSEREDPACKET = "api/ans/redPacket/forPayOrder";//获取我可用的红包

    String PAYNOWINPAYNew = "api/ans/order/purchaseNowV";//立即付款获取订单编号

    String ORDERPAYLISTITEM = "api/ans/order/pendingOrder";//代付款订单

    String UPLOADORDERS = "api/ans/order/orderSubmitV";//提交订单

    String SHOPDETAILCOMMENTLIST = "api/ans/shop/shopComments";//门店评论

    String SPECIALLISTITEM = "api/ec/goods/specialOfferGoods";//特价区底部列表数据

    String GPORDERWECHATPAY = "api/util/wechatpay/gporderWechatPay";//团购订单微信支付

    String COMMENTSPECIAL = "api/ec/goods/specialOfferGoodsRecommended";//特价商品推荐商品

    String GETFUWENBENDETAIL = "api/ec/common/getBannerdetails";//获取富文本详情

    String GETACTIVITYLIST = "api/ec/common/ansBannerList";//中秋活动列表

    String GETDAILYNEWDATA = "api/ans/shop/newShopAndGoodsList";//获取每日新店数据

    String GOODSRANKINGLIST = "api/ec/goods/goodsRankingList";//商品排行榜

    String GETRANKINGLISTDATA = "api/ans/shop/rankingList";//获取排行榜数据

    String GOODSSCREENING = "api/ec/goods/goodsScreening";//商品筛选列表

    String SECKILLACTIVITY = "api/ec/secKillActivity/list";//秒杀活动列表

    String PACKAGELIST = "api/ec/secKillActivity/packageList";//秒杀套餐列表

    String PACKAGEINFO = "api/ec/secKillActivity/packageInfo";//秒杀套餐详情

    String SECKILLGOODSDETAILS = "/api/ec/secKillGoods/details";//秒杀商品详情

    String GOODSBROWSESCHANGE = "/api/ec/secKillGoods/goodsBrowsesChange";//秒杀商品浏览次数增加

    String GOODSSCOREGET = "api/ec/secKillGoods/goodsScoreGet";//秒杀商品评分

    String SECKILLORDERSUBMIT = "api/ans/order/secKillOrderSubmit";//秒杀提交订单

    String USERLOGINBYVERIFYCODE = "/api/ans/login/userLoginByVerifyCode";//短信登录

    String USERINFOLIST = "/api/ans/group/userInfoList";//拼团参与者信息

    String SNSUSERLOGORREG = "/api/ans/login/snsUserLogOrReg";//三方登录绑定手机号

    String USERSETPASS = "/api/ans/login/userSetPass";//客户设置密码

    /**
     * 技能列表
     */
    String MAJOR_LIST = "api/ans/school/majorList";

    /**
     * 课程列表
     */
    String CLASS_LIST = "api/ans/school/classList";

    /**
     * 获取教程详情
     */
    String GET_CLASS_DETAILS = "api/ans/school/getClassDetails";

    /**
     * 课程推荐
     * 相关教学视频
     */
    String CLASS_RECOMMEND = "api/ans/school/classRecommend";

    /**
     * 购买记录
     */
    String VIDEO_PAY_RECORDS = "api/ans/school/videoPayRecords";

    /**
     * 播放记录
     */
    String VIDEO_PLAY_RECORDS = "api/ans/school/videoPlayRecords";

    /**
     * 获取视频播放凭证
     */
    String GET_PLAY_AUTH = "api/ans/school/getPlayAuth";

    /**
     * 我的课程
     */
    String MY_CLASS = "api/ans/school/myClass";

    /**
     * 微信购买课程
     */
    String ANS_SCHOOL_VIDEO_WECHAT_PAY = "api/util/wechatpay/ansSchoolVideoWechatPay";

    /**
     * 支付宝购买课程
     */
    String ANS_SCHOOL_VIDEO_ALIPAY = "api/util/alipay/ansSchoolVideoAliPay";
}
