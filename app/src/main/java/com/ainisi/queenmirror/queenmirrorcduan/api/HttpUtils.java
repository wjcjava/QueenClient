package com.ainisi.queenmirror.queenmirrorcduan.api;


import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.L;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.request.BaseRequest;

import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Response;

/**
 * 作者： jl
 */

public class HttpUtils {


    public static void doGet(final int action, Map<String, String> params, CacheMode cacheMode, final boolean showLoadingDialog, final HttpCallBack httpCallBack) {
        String url = getGetUrl(action, params);
        OkGo.get(url)
                .cacheKey(getUrl(action).toString())
                .tag(getUrl(action).toString())
                .cacheMode(cacheMode)
                .execute(new StringCallback() {
                    @Override
                    public void onBefore(BaseRequest request) {
                        super.onBefore(request);
                        if (showLoadingDialog)
                            httpCallBack.showLoadingDialog();
                    }

                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        L.e("result:" + s);
                        try {
                         /*   JSONObject jsonObject = new JSONObject(s);
                            int state = jsonObject.getInt("state");
                            String res = jsonObject.getString("res");
                            //失败
                            if (state != 200) {
                                httpCallBack.showErrorMessage(res);
                                return;
                            }
*/
                            //成功
                            httpCallBack.onSuccess(action, s);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        if (response != null) {
                            int httpCode = response.code();
                            switch (httpCode) {
                                case 400:
                                    L.e("请求的语法出错");
                                    T.show("请求的语法出错");
                                    break;
                                case 401:
                                    L.e("未授权");
                                    T.show("未授权");
                                    break;
                                case 403:
                                    L.e("请求被拒绝");
                                    T.show("请求被拒绝");
                                    break;
                                case 404:
                                    L.e("请求的接口不存在");
                                    T.show("请求的接口不存在");
                                    break;
                                case 408:
                                    L.e("请求超时");
                                    T.show("请求超时");
                                    break;
                                case 500:
                                    L.e("服务器错误");
                                    T.show("服务器错误");
                                    break;
                                case 503:
                                    L.e("服务器停机或正在维护");
                                    T.show("服务器停机或正在维护");
                                    break;
                            }
                            L.e(e.getMessage());
                        }
                    }

                });
    }

    public static void doPost(final int action, HashMap<String, String> params, CacheMode cacheMode, final boolean showLoadingDialog, final HttpCallBack httpCallBack) {
        String url = getUrl(action).toString();

        JSONObject jsonObject = new JSONObject(params);

        OkGo.post(url)
                .cacheKey(String.valueOf(action))
                .tag(String.valueOf(action))
                .cacheMode(cacheMode)
                .upJson(jsonObject.toString())
                .execute(new StringCallback() {
                    @Override
                    public void onBefore(BaseRequest request) {
                        super.onBefore(request);
                        if (showLoadingDialog)
                            httpCallBack.showLoadingDialog();
                    }

                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        try {

                            httpCallBack.onSuccess(action, s);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        if (response == null)
                            return;
                        int httpCode = response.code();
                        switch (httpCode) {
                            case 400:
                                T.show("请求的语法出错");
                                break;
                            case 401:
                                T.show("未授权");
                                break;
                            case 403:
                                T.show("请求被拒绝");
                                break;
                            case 404:
                                T.show("请求的接口不存在");
                                break;
                            case 408:
                                T.show("请求超时");
                                break;
                            case 500:
                                T.show("服务器错误");
                                break;
                            case 503:
                                T.show("服务器停机或正在维护");
                                break;
                        }
                        L.e(e.getMessage());
                    }

                });
    }

    public static void uploadHeadOrBack(final int action, String filePath, final UploadCallBack uploadCallBack) {
        String url = getUrl(action).toString();
        ArrayList<File> files = new ArrayList<>();
        files.add(new File(filePath));
        OkGo.post(url)
                .cacheKey(String.valueOf(action))
                .isMultipart(true)
                .tag(String.valueOf(action))
                .addFileParams("file", files)
//                .params("file", new File(filePath))
                .execute(new StringCallback() {
                    @Override
                    public void onBefore(BaseRequest request) {
                        super.onBefore(request);
                        L.e("url:" + request.getUrl());
                        L.e("method:" + request.getMethod());
                        L.e("params:" + request.getParams().toString());
                    }

                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        L.e("result:" + s);
                        try {
                           /* JSONObject jsonObject = new JSONObject(s);
                            int state = jsonObject.getInt("state");
                            String res = jsonObject.getString("res");
                            //失败
                            if (state != 200) {
                                uploadCallBack.showErrorMessage(res);
                                return;
                            }*/

                            //成功
                            uploadCallBack.onSuccess(action, s);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void upProgress(long currentSize, long totalSize, float progress, long networkSpeed) {
                        super.upProgress(currentSize, totalSize, progress, networkSpeed);
                        uploadCallBack.onProgress(currentSize, totalSize, progress, networkSpeed);
                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        if (response == null)
                            return;
                        int httpCode = response.code();
                        switch (httpCode) {
                            case 400:
                                T.show("请求的语法出错");
                                break;
                            case 401:
                                T.show("未授权");
                                break;
                            case 403:
                                T.show("请求被拒绝");
                                break;
                            case 404:
                                T.show("请求的接口不存在");
                                break;
                            case 408:
                                T.show("请求超时");
                                break;
                            case 500:
                                T.show("服务器错误");
                                break;
                            case 503:
                                T.show("服务器停机或正在维护");
                                break;
                        }
                        L.e(e.getMessage());
                    }

                });
    }

    public interface UploadCallBack {
        void onSuccess(int action, String res);

        void showErrorMessage(String s);

        void onProgress(long currentSize, long totalSize, float progress, long networkSpeed);
    }


    /**
     * 拼接get请求的url地址
     *
     * @param action
     * @param params
     * @return
     */
    public static String getGetUrl(int action, Map<String, String> params) {

        StringBuilder url = getUrl(action);

        if (params == null || params.isEmpty()) {
            return url.toString();
        }

        url.append("?");

        for (String key : params.keySet()) {
            url.append(key);
            url.append("=");
            url.append(params.get(key));
            url.append("&");
        }
        return url.toString();
    }

    public static StringBuilder getUrl(int Action) {
        StringBuilder url = new StringBuilder(UrlConstants.BASE_URL);
        String actionUrl = "";
        switch (Action) {
            //注册
            case ACTION.REGIST:
                actionUrl = UrlConstants.REGIST;
                break;
            //登陆
            case ACTION.LOGIN:
                actionUrl = UrlConstants.LOGIN;
                break;
            //获取验证码
            case ACTION.VERIFY:
                actionUrl = UrlConstants.VERIFY;
                break;
            //退款原因
            case ACTION.LIST:
                actionUrl = UrlConstants.LIST;
                break;
            //获取我的全部订单
            case ACTION.ALLOFMYORDER:
                actionUrl = UrlConstants.ALLOFMYORDER;
                break;
            //首页的女王头条
            case ACTION.HEADLINES:
                actionUrl = UrlConstants.HEADLINES;
                break;
            //首页的行业分类
            case ACTION.INDUSTRY:
                actionUrl = UrlConstants.INDUSTRY;
                break;
            //首页banner广告
            case ACTION.ADVERTISING:
                actionUrl = UrlConstants.ADVERTISING;
                break;
            //商城中商家列表
            case ACTION.SHOPLIST:
                actionUrl = UrlConstants.SHOPLIST;
                break;
            //商家推荐商品列表
            case ACTION.SHOPTUIJIANLIST:
                actionUrl = UrlConstants.SHOPTUIJIANLIST;
                break;
            //商家所卖商品列表
            case ACTION.SHOPSALEPRODUCT:
                actionUrl = UrlConstants.SHOPSALEPRODUCT;
                break;
            //获取门店信用数据
            case ACTION.SHOPXINYONG:
                actionUrl = UrlConstants.SHOPXINYONG;
                break;
            //获取商家具体信息
            case ACTION.SHOPDETAILDATA:
                actionUrl = UrlConstants.SHOPDETAILDATA;
                break;
            //获取我的收藏
            case ACTION.MINECOLLECTION:
                actionUrl = UrlConstants.MINECOLLECTION;
                break;
            //首页的消息类型列表
            case ACTION.MESSAGE:
                actionUrl = UrlConstants.MESSAGE;
                break;
            //首页的消息列表
            case ACTION.MESSAGELIST:
                actionUrl = UrlConstants.MESSAGELIST;
                break;
            //我的足迹
            case ACTION.MYFOOT:
                actionUrl = UrlConstants.MYFOOT;
                break;
            //商品的评价数据
            case ACTION.EVALUATION:
                actionUrl = UrlConstants.EVALUATION;
                break;
            //商家的评价数据
            case ACTION.MERCHANTS:
                actionUrl = UrlConstants.MERCHANTS;
                break;
            //获取我关注的店铺
            case ACTION.MINEINSHOP:
                actionUrl = UrlConstants.MINEINSHOP;
                break;
            //关注店铺
            case ACTION.GUANZHUSHOP:
                actionUrl = UrlConstants.GUANZHUSHOP;
                break;
            //取消关注店铺
            case ACTION.CANCELGUANZHUSHOP:
                actionUrl = UrlConstants.CANCELGUANZHUSHOP;
                break;
            //举报商家
            case ACTION.JUBAOSHOP:
                actionUrl = UrlConstants.JUBAOSHOP;
                break;
            //获取退款列表
            case ACTION.REFUND:
                actionUrl = UrlConstants.REFUND;
                break;
            //商家推荐商品的数据
            case ACTION.COMMENDGOODS:
                actionUrl = UrlConstants.COMMENDGOODS;
                break;
            //商家浏览次数
            case ACTION.ADDLIULAN:
                actionUrl = UrlConstants.ADDLIULAN;
                break;
            //商品浏览次数增加
            case ACTION.ADDGOODSLIULAN:
                actionUrl = UrlConstants.ADDGOODSLIULAN;
                break;
            //收藏商品
            case ACTION.COLLECTIONPRODUCT:
                actionUrl = UrlConstants.COLLECTIONPRODUCT;
                break;
            //取消收藏商品
            case ACTION.CANCELCOLLECTION:
                actionUrl = UrlConstants.CANCELCOLLECTION;
                break;
            //商家分类列表
            case ACTION.CLASSIFICATION:
                actionUrl = UrlConstants.CLASSIFICATION;
                break;
            //搜索标签信息
            case ACTION.LABEL:
                actionUrl = UrlConstants.LABEL;
                break;
            //商家列表分类
            case ACTION.MERCHANTSLIST:
                actionUrl = UrlConstants.MERCHANTSLIST;
                break;
            //活动商品列表
            case ACTION.ACTIVITYGOODS:
                actionUrl = UrlConstants.ACTIVITYGOODS;
                break;
            //活动商家列表
            case ACTION.ACTIVITYSHOPS:
                actionUrl = UrlConstants.ACTIVITYSHOPS;
                break;
            //加入购物车
            case ACTION.SHOPCARTADD:
                actionUrl = UrlConstants.SHOPCARTADD;
                break;
            //加入购物车
            case ACTION.ADDTOCAT:
                actionUrl = UrlConstants.ADDTOCAT;
                break;
            //获取开通城市列表
            case ACTION.GETCITYLIST:
                actionUrl = UrlConstants.GETCITYLIST;
                break;
            //获取商品详情
            case ACTION.GETPRODUCTDETAIL:
                actionUrl = UrlConstants.GETPRODUCTDETAIL;
                break;
            //搜索购物车
            case ACTION.GETSHOPPINDCART:
                actionUrl = UrlConstants.GETSHOPPINDCART;
                break;
            //改变购物车数量
            case ACTION.CHANGENUMBERCART:
                actionUrl = UrlConstants.CHANGENUMBERCART;
                break;
            //删除购物车
            case ACTION.DELETESHOPCART:
                actionUrl = UrlConstants.DELETESHOPCART;
                break;
            //我的评论
            case ACTION.MYCOMMENTS:
                actionUrl = UrlConstants.MYCOMMENTS;
                break;
            //修改密码
            case ACTION.CHANGEPASSWORD:
                actionUrl = UrlConstants.CHANGEPASSWORD;
                break;
            //退出登录账号
            case ACTION.LOGINOUT:
                actionUrl = UrlConstants.LOGINOUT;
                break;
            //用户修改用户名
            case ACTION.CHANGENAME:
                actionUrl = UrlConstants.CHANGENAME;
                break;
            //获取新消息提示
            case ACTION.GETNEWNEWS:
                actionUrl = UrlConstants.GETNEWNEWS;
                break;
            //第三方登录检验openID
            case ACTION.CHECKOPENID:
                actionUrl = UrlConstants.CHECKOPENID;
                break;
            //第三方直接登录
            case ACTION.THIRDLOGINONE:
                actionUrl = UrlConstants.THIRDLOGINONE;
                break;
            //商家优惠券
            case ACTION.SHOPDISCOUN:
                actionUrl = UrlConstants.SHOPDISCOUN;
                break;
            //商家所领取优惠券
            case ACTION.RECEIVEDISCOUN:
                actionUrl = UrlConstants.RECEIVEDISCOUN;
                break;
            //可以优惠券列表（订单）
            case ACTION.LISTFOEUSE:
                /**
                 * 接口未调试
                 */
                actionUrl = UrlConstants.LISTFOEUSE;
                break;
            //女王卡详情
            case ACTION.QUEENDETAILS:
                actionUrl = UrlConstants.QUEENDETAILS;
                break;
            case ACTION.UPLOADORDER:
                actionUrl = UrlConstants.UPLOADORDER;
                break;
            //忘记密码
            case ACTION.FORGOTPASSWORD:
                actionUrl = UrlConstants.FORGOTPASSWORD;
                break;
            //确认手机号是否已注册
            case ACTION.PHONECHECK:
                actionUrl = UrlConstants.PHONECHECK;
                break;
            //优惠券领取
            case ACTION.COUPONGET:
                actionUrl = UrlConstants.COUPONGET;
                break;
            //客户端绑定第三方账号
            case ACTION.USERBIND:
                actionUrl = UrlConstants.USERBIND;
                break;
            //常见问题分类
            case ACTION.PROBLEMLIST:
                actionUrl = UrlConstants.PROBLEMLIST;
                break;
            //常见问题分类的数据
            case ACTION.PROBLEMDATA:
                actionUrl = UrlConstants.PROBLEMDATA;
                break;
            //支付之前调用
            case ACTION.PayBefore:
                actionUrl = UrlConstants.PayBefore;
                break;
            //退款
            case ACTION.DOOUTDATA:
                actionUrl = UrlConstants.DOOUTDATA;
                break;
            case ACTION.GETUSEYOUHUIQUAN:
                actionUrl = UrlConstants.GETUSEYOUHUIQUAN;
                break;
            //拼单详情
            case ACTION.SPELLDETAILS:
                actionUrl = UrlConstants.SPELLDETAILS;
                break;
            //收藏拼团
            case ACTION.SPELLCOLLECTION:
                actionUrl = UrlConstants.SPELLCOLLECTION;
                break;
            case ACTION.CANCLEORDER:
                actionUrl = UrlConstants.CANCLEORDER;
                break;
            case ACTION.BEMEIYEREN:
                actionUrl = UrlConstants.BEMEIYEREN;
                break;
            case ACTION.AliPayAfterRefresh:
                actionUrl = UrlConstants.AliPayAfterRefresh;
                break;
            //商家活动（首页筛选）
            case ACTION.MERCHANTACTIVITY:
                actionUrl = UrlConstants.MERCHANTACTIVITY;
                break;
            //商家特色（首页筛选）
            case ACTION.MERCHANTFEATURES:
                actionUrl = UrlConstants.MERCHANTFEATURES;
                break;
            //设置支付密码（我的余额）
            case ACTION.SETPAYPASS:
                actionUrl = UrlConstants.SETPAYPASS;
                break;
            //修改支付密码（我的余额）
            case ACTION.AMENTPAY:
                /**
                 * 接口在调试中。。。(UI界面暂时无法对应接口所传数据)
                 */
                actionUrl = UrlConstants.AMENTPAY;
                break;
            //忘记支付密码（我的余额）
            case ACTION.FORGOTPAYPASS:
                /**
                 * 接口在调试中。。。(UI界面暂时无法对应接口所传数据)
                 */
                actionUrl = UrlConstants.FORGOTPAYPASS;
                break;
            //余额明细
            case ACTION.TOUCHBALANCE:
                actionUrl = UrlConstants.TOUCHBALANCE;
                break;
            //我的余额
            case ACTION.MYWALLIET:
                actionUrl = UrlConstants.MYWALLIET;
                break;
            //判断是否有支付密码
            case ACTION.WHETHERPASS:
                actionUrl = UrlConstants.WHETHERPASS;
                break;
            case ACTION.GETZXING:
                actionUrl = UrlConstants.GETZXING;
                break;
            case ACTION.CONFIMSERVICE:
                actionUrl = UrlConstants.CONFIMSERVICE;
                break;
            //获取我的魔豆余额
            case ACTION.GETMINEMODOU:
                actionUrl = UrlConstants.GETMINEMODOU;
                break;
            case ACTION.GETMINEMODOUBEAN:
                actionUrl = UrlConstants.GETMINEMODOUBEAN;
                break;
            case ACTION.GETMONTHMODOU:
                actionUrl = UrlConstants.GETMONTHMODOU;
                break;
            case ACTION.COMMENTPRO:
                actionUrl = UrlConstants.COMMENTPRO;
                break;
            case ACTION.PAYUSENVWANGCARD:
                actionUrl = UrlConstants.PAYUSENVWANGCARD;
                break;
            case ACTION.QUEENCHARGE:
                actionUrl = UrlConstants.QUEENCHARGE;
                break;
            case ACTION.PAYAFTERREFRESH:
                actionUrl = UrlConstants.PAYAFTERREFRESH;
                break;
            //商品数据的列表
            case ACTION.GOODLIST:
                actionUrl = UrlConstants.GOODLIST;
                break;
            //(我的H5)邀请好友
            case ACTION.INVITEPRIZE:
                actionUrl = UrlConstants.INVITEPRIZE;
                break;
            //邀请开店
            case ACTION.INVITEBDUAN:
                actionUrl = UrlConstants.INVITEBDUAN;
                break;
            //实名认证
            case ACTION.REALNAME:
                actionUrl = UrlConstants.REALNAME;
                break;
            case ACTION.PAYNOWINPAY:
                actionUrl = UrlConstants.PAYNOWINPAY;
                break;
            case ACTION.PAYPASSWORDCHECK:
                actionUrl = UrlConstants.PAYPASSWORDCHECK;
                break;
            case ACTION.PAYINYUEDATA:
                actionUrl = UrlConstants.PAYINYUEDATA;
                break;
            case ACTION.CommentReplyList:
                actionUrl = UrlConstants.CommentReplyList;
                break;
            case ACTION.COMMENTINPUT:
                actionUrl = UrlConstants.COMMENTINPUT;
                break;
            case ACTION.OSSGETTOKEN:
                actionUrl = UrlConstants.OSSGETTOKEN;
                break;
            case ACTION.WEBVIEWAGREEMENT:
                actionUrl = UrlConstants.WEBVIEWAGREEMENT;
                break;
            case ACTION.TUANDUILISTDATA:
                actionUrl = UrlConstants.TUANDUILISTDATA;
                break;
            //获取图形验证码
            case ACTION.GETSHAPE:
                actionUrl = UrlConstants.GETSHAPE;
                break;
            //获取今日新店列表
            case ACTION.NEWSHOPlIST:
                actionUrl = UrlConstants.NEWSHOPlIST;
                break;
            //获取Banner信息数据
            case ACTION.PAGEBANNER:
                actionUrl = UrlConstants.PAGEBANNER;
                break;
            case ACTION.GETPINTUANDATA:
                actionUrl = UrlConstants.GETPINTUANDATA;
                break;
            case ACTION.ADDPINTUAN:
                actionUrl = UrlConstants.ADDPINTUAN;
                break;
            case ACTION.GETPINTUANAFTER:
                actionUrl = UrlConstants.GETPINTUANAFTER;
                break;
            //获取banner商品列表数据
            case ACTION.GOODSBANNER:
                actionUrl = UrlConstants.GOODSBANNER;
                break;
            //获取参与Banner商家数据
            case ACTION.SHOPSBANNER:
                actionUrl = UrlConstants.SHOPSBANNER;
                break;
            case ACTION.HEADPICUPLOAD:
                actionUrl = UrlConstants.HEADPICUPLOAD;
                break;
            //待付款订单付款前的校验
            case ACTION.SHOPPAYCHECK:
                actionUrl = UrlConstants.SHOPPAYCHECK;
                break;
            case ACTION.SHOPBYSALES:
                actionUrl = UrlConstants.SHOPBYSALES;
                break;
            case ACTION.ORDERDETAIL:
                actionUrl = UrlConstants.ORDERDETAIL;
                break;
            case ACTION.ORDERNVWANGPAy:
                actionUrl = UrlConstants.ORDERNVWANGPAy;
                break;
            case ACTION.ORDERZHIFUBAOPAY:
                actionUrl = UrlConstants.ORDERZHIFUBAOPAY;
                break;
            case ACTION.ORDERyuepay:
                actionUrl = UrlConstants.ORDERyuepay;
                break;
            case ACTION.ORDERPAYBYWECHAT:
                actionUrl = UrlConstants.ORDERPAYBYWECHAT;
                break;
            case ACTION.QUEENPAYINWECHAT:
                actionUrl = UrlConstants.QUEENPAYINWECHAT;
                break;
            case ACTION.SHOPLISTBYZONGHE:
                actionUrl = UrlConstants.SHOPLISTBYZONGHE;
                break;
            case ACTION.SHOPLISTBYSOCORE:
                actionUrl = UrlConstants.SHOPLISTBYSOCORE;
                break;
            case ACTION.SHOPLISTBYLOOK:
                actionUrl = UrlConstants.SHOPLISTBYLOOK;
                break;
            case ACTION.SHOPLISTBYAREACODE:
                actionUrl = UrlConstants.SHOPLISTBYAREACODE;
                break;
            case ACTION.SHOPLISTBYAREANEAR:
                actionUrl = UrlConstants.SHOPLISTBYAREANEAR;
                break;
            case ACTION.SHOPLISTBYDISTANCE:
                actionUrl = UrlConstants.SHOPLISTBYDISTANCE;
                break;
            case ACTION.SEARCHKEY:
                actionUrl = UrlConstants.SEARCHKEY;
                break;
            case ACTION.GETSHOPSCORE:
                actionUrl = UrlConstants.GETSHOPSCORE;
                break;
            case ACTION.MESSAGEDETAIL:
                actionUrl = UrlConstants.MESSAGEDETAIL;
                break;
            case ACTION.QUEENBUYRECORD:
                actionUrl = UrlConstants.QUEENBUYRECORD;
                break;
            case ACTION.GETPEOPLEBYSHARE:
                actionUrl = UrlConstants.GETPEOPLEBYSHARE;
                break;
            case ACTION.GETHELPURL:
                actionUrl = UrlConstants.GETHELPURL;
                break;
            case ACTION.CHECKQUEENCARD:
                actionUrl = UrlConstants.CHECKQUEENCARD;
                break;
            case ACTION.CHECKNEWAPK:
                actionUrl = UrlConstants.CHECKNEWAPK;
                break;
            case ACTION.GETDATABYSHAIXUAN:
                actionUrl = UrlConstants.GETDATABYSHAIXUAN;
                break;
            case ACTION.WORKROOMDETAIL:
                actionUrl = UrlConstants.WORKROOMDETAIL;
                break;
            case ACTION.QIANDAODAY:
                actionUrl = UrlConstants.QIANDAODAY;
                break;
            case ACTION.QIANDAODAYSTATUS:
                actionUrl = UrlConstants.QIANDAODAYSTATUS;
                break;
            case ACTION.ISGPORDER:
                actionUrl = UrlConstants.ISGPORDER;
                break;
            case ACTION.CPTUIKUAN:
                actionUrl = UrlConstants.CPTUIKUAN;
                break;
            case ACTION.GPCANCELORDER:
                actionUrl = UrlConstants.GPCANCELORDER;
                break;
            case ACTION.GETQUEENCARDPAYSTYLE:
                actionUrl = UrlConstants.GETQUEENCARDPAYSTYLE;
                break;
            case ACTION.QUEENROYALTY:
                actionUrl = UrlConstants.QUEENROYALTY;
                break;
            case ACTION.MINEQUEENCARDBUY:
                actionUrl = UrlConstants.MINEQUEENCARDBUY;
                break;
            case ACTION.MINEQUEENCARDALIPY:
                actionUrl = UrlConstants.MINEQUEENCARDALIPY;
                break;
            case ACTION.GETHUIYUANSTAUTE:
                actionUrl = UrlConstants.GETHUIYUANSTAUTE;
                break;
            case ACTION.HUIYUANACTIVITYSTAUTE:
                actionUrl = UrlConstants.HUIYUANACTIVITYSTAUTE;
                break;
            case ACTION.SETFREESTATUEDATA:
                actionUrl = UrlConstants.SETFREESTATUEDATA;
                break;
            case ACTION.QUEENROYALTYACTIVITY:
                actionUrl = UrlConstants.QUEENROYALTYACTIVITY;
                break;
            case ACTION.QUEENCARDBUYRECORD:
                actionUrl = UrlConstants.QUEENCARDBUYRECORD;
                break;
            case ACTION.QUEENCARDREGISTLOGIN:
                actionUrl = UrlConstants.QUEENCARDREGISTLOGIN;
                break;
            case ACTION.GETQUEENREGISTCARD:
                actionUrl = UrlConstants.GETQUEENREGISTCARD;
                break;
            case ACTION.GOINREDPACKETHOMEPAGE:
                actionUrl = UrlConstants.GOINREDPACKETHOMEPAGE;
                break;
            case ACTION.CHAIREDPACKET:
                actionUrl = UrlConstants.CHAIREDPACKET;
                break;
            case ACTION.ISFIRSTORDER:
                actionUrl = UrlConstants.ISFIRSTORDER;
                break;
            case ACTION.GETMINEREDPACKETRECORD:
                actionUrl = UrlConstants.GETMINEREDPACKETRECORD;
                break;
            case ACTION.GETMINEUSEREDPACKET:
                actionUrl = UrlConstants.GETMINEUSEREDPACKET;
                break;
            case ACTION.PAYNOWINPAYNew:
                actionUrl = UrlConstants.PAYNOWINPAYNew;
                break;
            case ACTION.ORDERPAYLISTITEM:
                actionUrl = UrlConstants.ORDERPAYLISTITEM;
                break;
            case ACTION.UPLOADORDERS:
                actionUrl = UrlConstants.UPLOADORDERS;
                break;
            case ACTION.SHOPDETAILCOMMENTLIST:
                actionUrl = UrlConstants.SHOPDETAILCOMMENTLIST;
                break;
            case ACTION.SPECIALLISTITEM:
                actionUrl = UrlConstants.SPECIALLISTITEM;
                break;
            case ACTION.GPORDERWECHATPAY:
                actionUrl = UrlConstants.GPORDERWECHATPAY;
                break;
            case ACTION.COMMENTSPECIAL:
                actionUrl = UrlConstants.COMMENTSPECIAL;
                break;
            case ACTION.GETFUWENBENDETAIL:
                actionUrl = UrlConstants.GETFUWENBENDETAIL;
                break;
            case ACTION.GETACTIVITYLIST:
                actionUrl = UrlConstants.GETACTIVITYLIST;
                break;
            case ACTION.GETDAILYNEWDATA:
                actionUrl = UrlConstants.GETDAILYNEWDATA;
                break;
            case ACTION.GOODSRANKINGLIST:
                actionUrl = UrlConstants.GOODSRANKINGLIST;
                break;
            case ACTION.GETRANKINGLISTDATA:
                actionUrl = UrlConstants.GETRANKINGLISTDATA;
                break;
            case ACTION.GOODSSCREENING:
                actionUrl = UrlConstants.GOODSSCREENING;
                break;
            case ACTION.MAJOR_LIST:
                actionUrl = UrlConstants.MAJOR_LIST;
                break;
            case ACTION.CLASS_LIST:
                actionUrl = UrlConstants.CLASS_LIST;
                break;
            case ACTION.GET_CLASS_DETAILS:
                actionUrl = UrlConstants.GET_CLASS_DETAILS;
                break;
            case ACTION.CLASS_RECOMMEND:
                actionUrl = UrlConstants.CLASS_RECOMMEND;
                break;
            case ACTION.VIDEO_PAY_RECORDS:
                actionUrl = UrlConstants.VIDEO_PAY_RECORDS;
                break;
            case ACTION.VIDEO_PLAY_RECORDS:
                actionUrl = UrlConstants.VIDEO_PLAY_RECORDS;
                break;

            case ACTION.GET_PLAY_AUTH:
                actionUrl = UrlConstants.GET_PLAY_AUTH;
                break;

            case ACTION.MY_CLASS:
                actionUrl = UrlConstants.MY_CLASS;
                break;

            case ACTION.ANS_SCHOOL_VIDEO_WECHAT_PAY:
                actionUrl = UrlConstants.ANS_SCHOOL_VIDEO_WECHAT_PAY;
                break;

            case ACTION.ANS_SCHOOL_VIDEO_ALIPAY:
                actionUrl = UrlConstants.ANS_SCHOOL_VIDEO_ALIPAY;
                break;
            case ACTION.SECKILLACTIVITY:
                actionUrl = UrlConstants.SECKILLACTIVITY;
                break;
            case ACTION.PACKAGELIST:
                actionUrl = UrlConstants.PACKAGELIST;
                break;
            case ACTION.PACKAGEINFO:
                actionUrl = UrlConstants.PACKAGEINFO;
                break;
            case ACTION.SECKILLGOODSDETAILS:
                actionUrl = UrlConstants.SECKILLGOODSDETAILS;
                break;
            case ACTION.GOODSBROWSESCHANGE:
                actionUrl = UrlConstants.GOODSBROWSESCHANGE;
                break;
            case ACTION.GOODSSCOREGET:
                actionUrl = UrlConstants.GOODSSCOREGET;
                break;
            case ACTION.SECKILLORDERSUBMIT:
                actionUrl = UrlConstants.SECKILLORDERSUBMIT;
                break;
            case ACTION.USERLOGINBYVERIFYCODE:
                actionUrl = UrlConstants.USERLOGINBYVERIFYCODE;
                break;
            case ACTION.USERINFOLIST:
                actionUrl = UrlConstants.USERINFOLIST;
                break;
            case ACTION.SNSUSERLOGORREG:
                actionUrl = UrlConstants.SNSUSERLOGORREG;
                break;
            case ACTION.USERSETPASS:
                actionUrl = UrlConstants.USERSETPASS;
                break;
            default:
                break;
        }
        url.append(actionUrl);
        return url;
    }

}
