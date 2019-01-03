package com.ainisi.queenmirror.queenmirrorcduan.ui.shop.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ainisi.queenmirror.common.base.BaseActivity;
import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.ShopBaopinAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.WorkCreditAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.WorkRoomAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.WorkShopAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.WorkSingleAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.bean.ShopCommentBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.ShopDetailDataBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.ShopSalesProduct;
import com.ainisi.queenmirror.queenmirrorcduan.bean.ShopXinyongBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.ShoppingCartBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.SuccessBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.WorkTopListBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.FullActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.PurchaseActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.ShoppingCartActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.ShowImageViewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.mine.bean.InvitePaizeBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.shop.bean.ShopDiscounBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.user.LoginActivity;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.HoveringScrollview;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.L;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SP;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpContent;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.ainisi.queenmirror.queenmirrorcduan.utils.CustomRatingBar;
import com.ainisi.queenmirror.queenmirrorcduan.utils.DistanceGet;
import com.ainisi.queenmirror.queenmirrorcduan.utils.MD5;
import com.ainisi.queenmirror.queenmirrorcduan.utils.NoScrollListview;
import com.bumptech.glide.Glide;
import com.lzy.okgo.cache.CacheMode;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;
import com.umeng.socialize.shareboard.SnsPlatform;
import com.umeng.socialize.utils.ShareBoardlistener;

import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * 店铺详情
 */
public class WorkRoomDetailActivity extends BaseActivity implements HttpCallBack, HoveringScrollview.OnScrollListener {

    @Bind(R.id.tab_workroom)
    TabLayout tabWorkRoom;
    @Bind(R.id.li_workroom_xuan)
    LinearLayout li_workroom_xuan;
    @Bind(R.id.search01)
    LinearLayout search01;
    @Bind(R.id.search2)
    LinearLayout search2;
    @Bind(R.id.whs_workroom_scroll)
    HoveringScrollview whs_workroom_scroll;
    @Bind(R.id.re_recommendable_projects_shop)
    RecyclerView re_recommendable_projects_shop;
    @Bind(R.id.tv_work_credit)
    TextView mTvWorkCredit;
    @Bind(R.id.tv_work_order_time)
    TextView mTvWorkOrderTime;
    @Bind(R.id.score_work_evaluate)
    CustomRatingBar mScoreWorkEvaluate;
    @Bind(R.id.score_work_evaluate_two)
    CustomRatingBar mScoreWorkEvaluateTwo;
    @Bind(R.id.tv_score_attitude)
    TextView mTvScoreAttitude;
    @Bind(R.id.tv_score_environment)
    TextView tv_score_environment;
    private int searchLayoutTop;
    @Bind(R.id.listView)
    NoScrollListview listView;
    @Bind(R.id.listView_xinyong)
    NoScrollListview listView_xinyong;
    @Bind(R.id.tv_shop)
    TextView tvShop;
    @Bind(R.id.list_shop)
    NoScrollListview listShop;
    @Bind(R.id.tv_single)
    TextView tvSingle;
    @Bind(R.id.list_single)
    NoScrollListview listSingle;
    @Bind(R.id.re_workroom_coupon)
    LinearLayout reCoupu;
    @Bind(R.id.re_infor_massage)
    RelativeLayout reMassage;
    @Bind(R.id.tv_work_detail_hangye)
    TextView tv_work_detail_hangye;
    @Bind(R.id.tv_work_detail_address)
    TextView tv_work_detail_address;
    @Bind(R.id.tv_work_detail_time)
    TextView tv_work_detail_time;
    @Bind(R.id.tv_work_detail_introduce)
    TextView tv_work_detail_introduce;
    @Bind(R.id.tv_workroom_service_jubao)
    TextView tv_workroom_service_jubao;
    @Bind(R.id.tv_workdetail_topfenshu)
    TextView tv_workdetail_topfenshu;
    @Bind(R.id.tv_work_detail_guanzhu)
    TextView tv_work_detail_guanzhu;
    @Bind(R.id.text_shop)
    TextView textShop;
    @Bind(R.id.text_single)
    TextView textSingle;
    @Bind(R.id.tv_submit)
    TextView tv_submit;
    @Bind(R.id.tv_workroom_shopname_b)
    TextView tv_workroom_shopname_b;
    @Bind(R.id.workroom_recycler)
    RelativeLayout workroom_recycler;
    @Bind(R.id.iv_information_one)
    ImageView iv_information_one;
    @Bind(R.id.iv_information_two)
    ImageView iv_information_two;
    @Bind(R.id.iv_information_three)
    ImageView iv_information_three;
    @Bind(R.id.iv_information_four)
    ImageView iv_information_four;
    @Bind(R.id.iv_workroom_pic)
    CircleImageView iv_workroom_pic;
    @Bind(R.id.li_workroom_top)
    LinearLayout li_workroom_top;
    @Bind(R.id.bar_workroom_detail)
    AppBarLayout bar_workroom_detail;
    @Bind(R.id.li_workroom_link)
    LinearLayout li_workroom_link;
    List<String> tabList = new ArrayList<>();
    private WorkRoomAdapter listadapter;
    int pageNumber = 1, pageSum = 0;

    int pageNumber1 = 1, pageSum1 = 0;
    String shopName, shopId;
    private WorkCreditAdapter creditAdapter;
    String isLogin, userId;
    boolean isColl = false;
    List<WorkTopListBean.BodyBean.TopGoodsListBean> apiEcGoodsBasicList = new ArrayList<>();
    List<ShopSalesProduct.BodyBean.ApiGoodsListBean> apiGoodsList = new ArrayList<>();
    ShopDetailDataBean shopDetailDataBean;
    String top_detail = "";
    private WorkShopAdapter shopAdapter;
    ShoppingCartBean shoppingCartBean;
    public static WorkRoomDetailActivity instance = null;
    private WorkSingleAdapter singleAdapter;
    private List<ShopDiscounBean.BodyBean.CouponListDataItemBean> list1;
    private List<ShopDiscounBean.BodyBean.CouponListDataBean> list;
    List<ShopCommentBean.BodyBean.EcAppraiseGoodsListBean> ecAppraiseGoodsList = new ArrayList<>();

    ShopXinyongBean.BodyBean.ApiShopScoreGetBean apiShopScoreGet = new ShopXinyongBean.BodyBean.ApiShopScoreGetBean();
    @Bind(R.id.workroom_refreshLayout)
    SmartRefreshLayout workroom_refreshLayout;
    @Bind(R.id.iv_workroom_share)
    ImageView iv_workroom_share;
    int pageIndex = 0, pageIndex1 = 0;
    String mine_lon, mine_lat, shop_lon, shop_lat;
    CustomShareListener mShareListener;
    ShareAction mShareAction;
    private String urlIcon = "https://mmbiz.qlogo.cn/mmbiz_png/XDC8ot2yPvMMpEwKmIrIgD6zqnVE3ex8vmXLnMMdq31GN9kalYqIvWZnL8zTfmEliaSTibRSibc27iacE9mPyj1kZA/0?wx_fmt=png";
    int hight = 0, hight1 = 0;
    String phone_number;

    String isQueenCard = "0", queenShopDiscount = "";
    @Bind(R.id.li_roomdetail_xinyong)
    LinearLayout li_roomdetail_xinyong;
    private DecimalFormat mDecimalFormat = new DecimalFormat("0.00");

    int where = 0;
    private int looked = 10000;

    @Override
    public int getLayoutId() {
        instance = this;
        return R.layout.activity_work_room_detail;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    public void initView() {

        ViewTreeObserver vto = li_workroom_top.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                li_workroom_top.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                hight = li_workroom_top.getHeight();
                li_workroom_top.getWidth();
            }
        });
        ViewTreeObserver vtos = bar_workroom_detail.getViewTreeObserver();
        vtos.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                bar_workroom_detail.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                hight1 = bar_workroom_detail.getHeight();
                bar_workroom_detail.getWidth();
            }
        });
        initTab();
        Intent intent = getIntent();
        shopName = intent.getStringExtra("shopName");
        shopId = intent.getStringExtra("shopId");
        tv_workroom_shopname_b.setText(shopName);
        whs_workroom_scroll.setOnScrollListener(this);

        isLogin = (String) SP.get(WorkRoomDetailActivity.this, SpContent.isLogin, "");
        //if(SP.get(WorkRoomDetailActivity.this,SpContent.isLogin,"0").equals("1")){
        /**
         * 获取商家具体信息
         */
        getShopDetailData();
        //}

        doAddliulanData();
        doFirstData();

        /**
         * 获取购物车信息
         */
        if (SP.get(WorkRoomDetailActivity.this, SpContent.isLogin, "0").equals("1")) {
            getShopCartData();
        }

        /**
         * 分享链接
         */
        if (SP.get(WorkRoomDetailActivity.this, SpContent.isLogin, "0").equals("1")) {
//            shareData();
        }
    }

    /**
     * 获取购物车信息
     */
    public void getShopCartData() {
        HashMap<String, String> params = new HashMap<>();
        params.put("custId", SP.get(WorkRoomDetailActivity.this, SpContent.UserId, "") + "");//用户ID
        params.put("token", SP.get(this, SpContent.UserToken, "") + "");
        HttpUtils.doPost(ACTION.GETSHOPPINDCART, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    /**
     * 获取优惠券
     */
    public void geeshopDiscoun() {
        HashMap<String, String> params = new HashMap<>();
        params.put("cpCate", shopDetailDataBean.getBody().getApiShop().getAnsShopBasic().getShopCate());
        params.put("cpScope", "1");
        params.put("shopId", shopId);//商品ID
        params.put("userId", SP.get(this, SpContent.UserId, "") + "");//用户ID
        params.put("token", SP.get(this, SpContent.UserToken, "") + "");
        HttpUtils.doPost(ACTION.SHOPDISCOUN, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    /**
     * 获取分享链接
     */
    private void shareData() {
        HashMap<String, String> parames = new HashMap<>();
        parames.put("objectType", "1");
        parames.put("objectId", SP.get(this, SpContent.UserId, "") + "");
        parames.put("token", SP.get(this, SpContent.UserToken, "") + "");
        HttpUtils.doPost(ACTION.INVITEPRIZE, parames, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    @Override
    public void onSuccess(int action, String res) {
        switch (action) {
            case ACTION.SHOPDETAILCOMMENTLIST:

                ShopCommentBean shopCommentBean = GsonUtil.toObj(res, ShopCommentBean.class);
                if (shopCommentBean.isSuccess() && shopCommentBean.getErrorCode().equals("0")) {

                    pageSum1 = shopCommentBean.getBody().getEcAppraiseGoodsList().size();
                    loadMoreCommentData(shopCommentBean.getBody().getEcAppraiseGoodsList());

                } else {
                    T.show(shopCommentBean.getMsg());
                }
                break;
            /**
             * 获取分享链接地址
             */
            case ACTION.INVITEPRIZE:
                InvitePaizeBean invitePaizeBean = GsonUtil.toObj(res, InvitePaizeBean.class);
                if (invitePaizeBean.getErrorCode().equals("6")) {
                    T.show("您的账号已过期，请重新登录");
                    Intent intent = new Intent(this, LoginActivity.class);
                    intent.putExtra("activite", "no");
                    startActivity(intent);
                } else {
                    if (invitePaizeBean.isSuccess()) {

                    }
                }
                break;
            case ACTION.GETSHOPPINDCART://购物车
                shoppingCartBean = GsonUtil.toObj(res, ShoppingCartBean.class);
                if (shoppingCartBean.getErrorCode().equals("6")) {
                    T.show("您的账号已过期，请重新登录");
                    Intent intent = new Intent(this, LoginActivity.class);
                    intent.putExtra("activite", "no");
                    startActivity(intent);
                } else {
                    if (shoppingCartBean.getBody().getShopList().size() > 0) {
                        tv_submit.setVisibility(View.VISIBLE);
                    } else {
                        tv_submit.setVisibility(View.GONE);
                    }
                }
                break;
            case ACTION.ADDLIULAN://添加浏览量
                SuccessBean successBeans = GsonUtil.toObj(res, SuccessBean.class);
                if (successBeans.getErrorCode().equals("6")) {
                    T.show("您的账号已过期，请重新登录");
                } else {
                    if (successBeans.isSuccess()) {
                        //T.show(successBeans.getMsg());//成功
                    } else {
                        T.show(successBeans.getMsg());
                    }
                }
                break;
            case ACTION.COLLECTIONPRODUCT://收藏商品
                isColl = true;
                SuccessBean successBean1 = GsonUtil.toObj(res, SuccessBean.class);
                if (successBean1.getErrorCode().equals("6")) {
                    T.show("您的账号已过期，请重新登录");
                } else {
                    if (successBean1.isSuccess()) {
                        // T.show(successBean1.getMsg());//成功
                    } else {
                        T.show(successBean1.getMsg());
                    }
                }
                break;
            case ACTION.CANCELCOLLECTION://取消收藏
                isColl = false;
                SuccessBean successBean2 = GsonUtil.toObj(res, SuccessBean.class);
                if (successBean2.getErrorCode().equals("6")) {
                    T.show("您的账号已过期，请重新登录");
                } else {
                    if (successBean2.isSuccess()) {
                        //  T.show(successBean2.getMsg());//成功
                    } else {
                        T.show(successBean2.getMsg());
                    }
                }
                break;
            case ACTION.WORKROOMDETAIL://获取商家推荐商品列表
                WorkTopListBean shopTuijianBean = GsonUtil.toObj(res, WorkTopListBean.class);
                if (shopTuijianBean.getErrorCode().equals("6")) {
                    T.show("您的账号已过期，请重新登录");
                } else {
                    apiEcGoodsBasicList = shopTuijianBean.getBody().getTopGoodsList();
                    ShopBaopinAdapter sortAdapter = new ShopBaopinAdapter(WorkRoomDetailActivity.this, R.layout.re_full_recommend, apiEcGoodsBasicList);
                    re_recommendable_projects_shop.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
                    re_recommendable_projects_shop.setAdapter(sortAdapter);
                }
                break;
            /**
             * 商家所卖商品列表
             */
            case ACTION.SHOPSALEPRODUCT:
                ShopSalesProduct shopSalesProduct = GsonUtil.toObj(res, ShopSalesProduct.class);

                if (shopSalesProduct.getErrorCode().equals("6")) {
                    T.show("您的账号已过期，请重新登录");
                } else {
                    pageSum = shopSalesProduct.getBody().getApiGoodsList().size();

                    loadMoreData(shopSalesProduct.getBody().getApiGoodsList());
                }
                break;
            case ACTION.SHOPXINYONG://获取门店信用
                ShopXinyongBean shopXinyongBean = GsonUtil.toObj(res, ShopXinyongBean.class);
                if (shopXinyongBean.getErrorCode().equals("6")) {
                    T.show("您的账号已过期，请重新登录");
                } else {
                    apiShopScoreGet = shopXinyongBean.getBody().getApiShopScoreGet();
                    top_detail = top_detail + "  评分 " + shopXinyongBean.getBody().getApiShopScoreGet().getComScore();

                    tv_workdetail_topfenshu.setText(top_detail);
                }
                break;
            //获取商家具体信息
            case ACTION.SHOPDETAILDATA:
                shopDetailDataBean = GsonUtil.toObj(res, ShopDetailDataBean.class);

                if (shopDetailDataBean.getErrorCode().equals("6")) {
                    T.show("您的账号已过期，请重新登录");
                } else {
                    if (shopDetailDataBean.isSuccess()) {

                        phone_number = shopDetailDataBean.getBody().getApiShop().getAnsShopBasic().getServiceTel();

                        /**
                         * 商家所卖商品
                         */
                        doGetSaleShop();
                        /**
                         * 获取门店信用数据
                         */
                        getXinyongData();

                        /**
                         * 获取门店评论数据
                         */
                        getShopCommentData();


                        if (shopDetailDataBean.getBody().getApiShop().getAnsShopBasic().getQueenCard() == null) {
                            isQueenCard = "0";
                        } else {
                            isQueenCard = shopDetailDataBean.getBody().getApiShop().getAnsShopBasic().getQueenCard();
                        }
                        if (isQueenCard.equals("1")) {
                            queenShopDiscount = shopDetailDataBean.getBody().getApiShop().getAnsShopBasic().getQueenShopDiscount();
                            bar_workroom_detail.setBackground(this.getResources().getDrawable(R.drawable.work_room_detail_top));
                        } else {
                            bar_workroom_detail.setBackground(this.getResources().getDrawable(R.drawable.icon_home));
                        }

                        listadapter = new WorkRoomAdapter(WorkRoomDetailActivity.this, apiGoodsList, isQueenCard, queenShopDiscount);
                        listView.setAdapter(listadapter);

                        creditAdapter = new WorkCreditAdapter(WorkRoomDetailActivity.this, ecAppraiseGoodsList);
                        listView_xinyong.setAdapter(creditAdapter);

                        workroom_refreshLayout.setOnRefreshListener(new OnRefreshListener() {
                            @Override
                            public void onRefresh(RefreshLayout refreshlayout) {


                                if (where == 0) {
                                    pageNumber = 1;
                                    pageIndex = 0;
                                    doGetSaleShop();
                                } else {
                                    pageNumber1 = 1;
                                    pageIndex1 = 0;
                                    getShopCommentData();
                                }
                                refreshlayout.finishRefresh(2000);
                            }
                        });
                        workroom_refreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
                            @Override
                            public void onLoadmore(RefreshLayout refreshlayout) {

                                if (where == 0) {
                                    if (pageSum < Integer.parseInt(SpContent.pageSize)) {
                                        refreshlayout.finishLoadmore(2000);
                                        T.show("您已加载完全部数据");
                                    } else {
                                        pageNumber++;
                                        doGetSaleShop();
                                        refreshlayout.finishLoadmore(2000);
                                    }
                                } else {
                                    if (pageSum1 < Integer.parseInt(SpContent.pageSize)) {
                                        refreshlayout.finishLoadmore(2000);
                                        T.show("您已加载完全部数据");
                                    } else {
                                        pageNumber1++;
                                    }
                                    refreshlayout.finishLoadmore(2000);
                                }
                            }
                        });
                        top_detail = top_detail + "销量" + shopDetailDataBean.getBody().getApiShop().getSalesCount();
                        double browseCounts = shopDetailDataBean.getBody().getApiShop().getAnsShopBrowses().getBrowseCounts();
                        if (browseCounts > looked) {
                            top_detail = top_detail + "  浏览量" + mDecimalFormat.format(browseCounts / looked) + "万";
                        } else {
                            top_detail = top_detail + "  浏览量" + browseCounts;
                        }
                        String shopLogo = shopDetailDataBean.getBody().getApiShop().getAnsShopBasic().getShopLogo();
                        final String[] shop_logo = shopLogo.split(",");
                        Glide.with(WorkRoomDetailActivity.this).load(shop_logo[0]).dontAnimate().placeholder(R.drawable.dismiss).into(iv_workroom_pic);

                        mine_lon = SP.get(this, SpContent.UserLon, "0") + "";
                        mine_lat = SP.get(this, SpContent.UserLat, "0") + "";
                        shop_lon = shopDetailDataBean.getBody().getApiShop().getAnsShopBasic().getGeoX() + "";
                        shop_lat = shopDetailDataBean.getBody().getApiShop().getAnsShopBasic().getGeoY() + "";

                        if (mine_lon.equals("0")) {
                            top_detail = top_detail + "暂无定位信息";
                        } else {
                            double distance = (DistanceGet.getDistance(Double.parseDouble(shop_lat), Double.parseDouble(shop_lon), Double.parseDouble(mine_lat), Double.parseDouble(mine_lon))) / 1000;
                            top_detail = top_detail + "  相距" + MD5.doubleToString(String.valueOf(distance)) + "km";
                        }
                        if (shopDetailDataBean.getBody().getIfFollow().equals("1")) {
                            /**
                             * 已关注
                             */
                            tv_work_detail_guanzhu.setText("取消关注");
                        } else {
                            /**
                             * 未关注
                             */
                            tv_work_detail_guanzhu.setText("关注");
                        }
                        mShareAction = new ShareAction(WorkRoomDetailActivity.this).setDisplayList(
                                SHARE_MEDIA.WEIXIN, SHARE_MEDIA.WEIXIN_CIRCLE,
                                SHARE_MEDIA.SINA, SHARE_MEDIA.QQ, SHARE_MEDIA.QZONE
                        ).setShareboardclickCallback(new ShareBoardlistener() {
                            @Override
                            public void onclick(SnsPlatform snsPlatform, SHARE_MEDIA share_media) {
                                UMWeb web = new UMWeb("https://t.jiyuanet.com/wg/h5/h5specificity/shop.html?shopId=" + shopId);
                                web.setTitle(shopName);
                                web.setDescription(shopDetailDataBean.getBody().getApiShop().getAnsShopBasic().getShopBrief());
                                web.setThumb(new UMImage(WorkRoomDetailActivity.this, shop_logo[0]));
                                new ShareAction(WorkRoomDetailActivity.this).withMedia(web)
                                        .setPlatform(share_media)
                                        .setCallback(mShareListener)
                                        .share();
                            }
                        });
                    } else {
                        T.show(shopDetailDataBean.getMsg());
                    }
                }
                break;
            case ACTION.GUANZHUSHOP://关注店铺
                SuccessBean successBean = GsonUtil.toObj(res, SuccessBean.class);
                if (successBean.getErrorCode().equals("6")) {
                    T.show("您的账号已过期，请重新登录");
                } else {
                    if (successBean.isSuccess()) {
                        T.show("关注成功");
                        tv_work_detail_guanzhu.setText("取消关注");
                    } else {
                        T.show(successBean.getMsg());
                    }
                }
                break;
            case ACTION.CANCELGUANZHUSHOP://取消关注店铺
                SuccessBean cancelsuccessBean = GsonUtil.toObj(res, SuccessBean.class);
                if (cancelsuccessBean.getErrorCode().equals("6")) {
                    T.show("您的账号已过期，请重新登录");
                } else {
                    if (cancelsuccessBean.isSuccess()) {
                        T.show("取消关注成功");
                        tv_work_detail_guanzhu.setText("关注");
                    } else {
                        T.show(cancelsuccessBean.getMsg());
                    }
                }
                break;
            case ACTION.JUBAOSHOP:
                /**
                 * 接口还需要修改
                 */
                break;
            /**
             * 商家优惠券
             */
            case ACTION.SHOPDISCOUN:
                ShopDiscounBean discounBean = GsonUtil.toObj(res, ShopDiscounBean.class);
                if (discounBean.getErrorCode().equals("6")) {
                    T.show("您的账号已过期，请重新登录");
                } else {
                    if (discounBean.isSuccess()) {
                        list = discounBean.getBody().getCouponListData();
                        list1 = discounBean.getBody().getCouponListDataItem();
                        shopAdapter = new WorkShopAdapter(WorkRoomDetailActivity.this, list);
                        singleAdapter = new WorkSingleAdapter(WorkRoomDetailActivity.this, list1);
                        listShop.setAdapter(shopAdapter);
                        listShop.setDividerHeight(0);
                        listSingle.setAdapter(singleAdapter);
                        listSingle.setDividerHeight(0);
                        if (list.size() > 0) {
                            textShop.setVisibility(View.GONE);
                        } else {
                            textShop.setVisibility(View.VISIBLE);
                        }

                        if (list1.size() > 0) {
                            textSingle.setVisibility(View.GONE);
                        } else {
                            textSingle.setVisibility(View.VISIBLE);
                        }
                    } else {
                        T.show(discounBean.getMsg());
                    }
                }
                break;
            default:
                break;
        }
    }

    /**
     * 获取门店评论数据
     */
    private void getShopCommentData() {
        HashMap<String, String> params = new HashMap<>();
        params.put("shopId", shopId);//商家ID
        params.put("token", SP.get(this, SpContent.UserToken, "") + "");
        params.put("pageNumber", pageNumber + "");
        params.put("pageSize", SpContent.pageSize);
        HttpUtils.doPost(ACTION.SHOPDETAILCOMMENTLIST, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    /**
     * 添加浏览次数
     */
    private void doAddliulanData() {
        HashMap<String, String> params = new HashMap<>();
        params.put("shopId", shopId);//商家ID
        params.put("token", SP.get(this, SpContent.UserToken, "") + "");
        HttpUtils.doPost(ACTION.ADDLIULAN, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    /**
     * 获取商家所卖商品的数据
     */
    private void doGetSaleShop() {
        HashMap<String, String> params = new HashMap<>();
        params.put("saleFlag", "2");//上架标记（2：上架）
        params.put("pageNumber", pageNumber + "");
        params.put("shopId", shopId);//商家ID
        params.put("contentByTitle", "");//画面检索输入框输入的内容
        params.put("token", SP.get(this, SpContent.UserToken, "") + "");
        params.put("pageSize", SpContent.pageSize);
        HttpUtils.doPost(ACTION.SHOPSALEPRODUCT, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    /**
     * 获取商家推荐商品列表
     */
    private void doFirstData() {
        HashMap<String, String> params = new HashMap<>();
        params.put("pageNumber", pageNumber + "");
        params.put("shopId", shopId);//商家ID
        params.put("pageSize", "3");
        params.put("token", SP.get(this, SpContent.UserToken, "") + "");
        HttpUtils.doPost(ACTION.WORKROOMDETAIL, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    /**
     * 获取门店信用数据
     */
    private void getXinyongData() {
        HashMap<String, String> params = new HashMap<>();
        params.put("id", shopId);//商家ID
        params.put("token", SP.get(this, SpContent.UserToken, "") + "");
        HttpUtils.doPost(ACTION.SHOPXINYONG, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    /**
     * 获取商家具体信息
     */
    private void getShopDetailData() {
        HashMap<String, String> params = new HashMap<>();
        params.put("id", shopId);//商家ID
        params.put("token", SP.get(this, SpContent.UserToken, "") + "");
        params.put("userId", SP.get(WorkRoomDetailActivity.this, SpContent.UserId, "0") + "");
        HttpUtils.doPost(ACTION.SHOPDETAILDATA, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    /**
     * 关注店铺
     */
    private void guanzhuData() {
        HashMap<String, String> params = new HashMap<>();
        params.put("shopId", shopId);//商家ID
        params.put("userId", userId);
        params.put("token", SP.get(this, SpContent.UserToken, "") + "");
        HttpUtils.doPost(ACTION.GUANZHUSHOP, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    /**
     * 取消关注
     */
    private void cancelGuanzhuData() {
        HashMap<String, String> params = new HashMap<>();
        params.put("shopId", shopId);//商家ID
        params.put("userId", userId);
        params.put("token", SP.get(this, SpContent.UserToken, "") + "");
        HttpUtils.doPost(ACTION.CANCELGUANZHUSHOP, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    /**
     * 举报商家
     */
    private void jubaoData() {
        HashMap<String, String> params = new HashMap<>();
        params.put("complainInfo", shopId);//商家ID
        params.put("token", SP.get(this, SpContent.UserToken, "") + "");
        HttpUtils.doPost(ACTION.JUBAOSHOP, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    private void initTab() {
        listView.setVisibility(View.VISIBLE);
        tabList.add("门店服务");
        tabList.add("门店信用");
        tabList.add("商家信息");
        tabList.add("优惠券");
        tabWorkRoom.addTab(tabWorkRoom.newTab().setText(tabList.get(0)));
        tabWorkRoom.addTab(tabWorkRoom.newTab().setText(tabList.get(1)));
        tabWorkRoom.addTab(tabWorkRoom.newTab().setText(tabList.get(2)));
        tabWorkRoom.addTab(tabWorkRoom.newTab().setText(tabList.get(3)));
        tabWorkRoom.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    //门店服务
                    case 0:
                        where = 0;
                        if (li_workroom_xuan.getParent() != search2) {
                            search01.removeView(li_workroom_xuan);
                            search2.addView(li_workroom_xuan);
                        }

                        whs_workroom_scroll.smoothScrollTo(0, 0);

                        listView.setVisibility(View.VISIBLE);
                        listView_xinyong.setVisibility(View.GONE);
                        li_roomdetail_xinyong.setVisibility(View.GONE);
                        reCoupu.setVisibility(View.GONE);
                        reMassage.setVisibility(View.GONE);
                        break;
                    //门店信用
                    case 1:
                        where = 1;
                        if (li_workroom_xuan.getParent() != search2) {
                            search01.removeView(li_workroom_xuan);
                            search2.addView(li_workroom_xuan);
                        }
                        whs_workroom_scroll.smoothScrollTo(0, 0);

                        listView.setVisibility(View.GONE);
                        reCoupu.setVisibility(View.GONE);
                        reMassage.setVisibility(View.GONE);
                        listView_xinyong.setVisibility(View.VISIBLE);
                        li_roomdetail_xinyong.setVisibility(View.VISIBLE);


                        mTvWorkCredit.setText(apiShopScoreGet.getComScore());
                        mTvWorkOrderTime.setText("接单时间" + apiShopScoreGet.getAvgTakeMinutes() + "分钟");
                        mTvScoreAttitude.setText(apiShopScoreGet.getAvgService());
                        tv_score_environment.setText(apiShopScoreGet.getAvgEnvironment());

                        if (apiShopScoreGet.getAvgService() == null) {

                        } else {
                            mScoreWorkEvaluate.setRating(Float.parseFloat(apiShopScoreGet.getAvgService()));
                        }
                        if (apiShopScoreGet.getAvgEnvironment() == null) {

                        } else {
                            mScoreWorkEvaluateTwo.setRating(Float.parseFloat(apiShopScoreGet.getAvgEnvironment()));
                        }

                        break;
                    //商家信息
                    case 2:

                        if (li_workroom_xuan.getParent() != search2) {
                            search01.removeView(li_workroom_xuan);
                            search2.addView(li_workroom_xuan);
                        }
                        whs_workroom_scroll.smoothScrollTo(0, 0);

                        listView.setVisibility(View.GONE);
                        listView_xinyong.setVisibility(View.GONE);
                        li_roomdetail_xinyong.setVisibility(View.GONE);
                        reCoupu.setVisibility(View.GONE);
                        reMassage.setVisibility(View.VISIBLE);
                        String envPhoto = shopDetailDataBean.getBody().getApiShop().getAnsShopBasic().getShopEnvPhoto();
                        String[] envPhotos = new String[]{};

                        if (envPhoto != null && envPhoto.length() > 0) {
                            envPhotos = envPhoto.split(",");
                        }
                        if (envPhotos.length < 1) {

                        } else if (envPhotos.length < 2) {
                            Glide.with(WorkRoomDetailActivity.this).load(envPhotos[0]).placeholder(R.drawable.dismiss).into(iv_information_one);
                            iv_information_two.setVisibility(View.INVISIBLE);
                            iv_information_three.setVisibility(View.INVISIBLE);
                            iv_information_four.setVisibility(View.INVISIBLE);
                        } else if (envPhotos.length < 3) {
                            Glide.with(WorkRoomDetailActivity.this).load(envPhotos[0]).placeholder(R.drawable.dismiss).into(iv_information_one);
                            Glide.with(WorkRoomDetailActivity.this).load(envPhotos[1]).placeholder(R.drawable.dismiss).into(iv_information_two);
                            iv_information_two.setVisibility(View.VISIBLE);
                            iv_information_three.setVisibility(View.INVISIBLE);
                            iv_information_four.setVisibility(View.INVISIBLE);
                        } else if (envPhotos.length < 4) {
                            Glide.with(WorkRoomDetailActivity.this).load(envPhotos[0]).placeholder(R.drawable.dismiss).into(iv_information_one);
                            Glide.with(WorkRoomDetailActivity.this).load(envPhotos[1]).placeholder(R.drawable.dismiss).into(iv_information_two);
                            Glide.with(WorkRoomDetailActivity.this).load(envPhotos[2]).placeholder(R.drawable.dismiss).into(iv_information_three);
                            iv_information_two.setVisibility(View.VISIBLE);
                            iv_information_three.setVisibility(View.VISIBLE);
                            iv_information_four.setVisibility(View.INVISIBLE);
                        } else {
                            iv_information_two.setVisibility(View.VISIBLE);
                            iv_information_three.setVisibility(View.VISIBLE);
                            iv_information_four.setVisibility(View.VISIBLE);

                            Glide.with(WorkRoomDetailActivity.this).load(envPhotos[0]).placeholder(R.drawable.dismiss).into(iv_information_one);
                            Glide.with(WorkRoomDetailActivity.this).load(envPhotos[1]).placeholder(R.drawable.dismiss).into(iv_information_two);
                            Glide.with(WorkRoomDetailActivity.this).load(envPhotos[2]).placeholder(R.drawable.dismiss).into(iv_information_three);
                            Glide.with(WorkRoomDetailActivity.this).load(envPhotos[3]).placeholder(R.drawable.dismiss).into(iv_information_four);
                        }

                        iv_information_one.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent intent = new Intent(WorkRoomDetailActivity.this, ShowImageViewActivity.class);
                                intent.putExtra("image_url", shopDetailDataBean.getBody().getApiShop().getAnsShopBasic().getShopEnvPhoto());
                                startActivity(intent);
                            }
                        });
                        iv_information_two.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent intent = new Intent(WorkRoomDetailActivity.this, ShowImageViewActivity.class);
                                intent.putExtra("image_url", shopDetailDataBean.getBody().getApiShop().getAnsShopBasic().getShopEnvPhoto());
                                startActivity(intent);
                            }
                        });
                        iv_information_three.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent intent = new Intent(WorkRoomDetailActivity.this, ShowImageViewActivity.class);
                                intent.putExtra("image_url", shopDetailDataBean.getBody().getApiShop().getAnsShopBasic().getShopEnvPhoto());
                                startActivity(intent);
                            }
                        });
                        iv_information_four.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent intent = new Intent(WorkRoomDetailActivity.this, ShowImageViewActivity.class);
                                intent.putExtra("image_url", shopDetailDataBean.getBody().getApiShop().getAnsShopBasic().getShopEnvPhoto());
                                startActivity(intent);
                            }
                        });


                        if (shopDetailDataBean.getBody().getApiShop().getIndustryCateLabel() == null || shopDetailDataBean.getBody().getApiShop().getIndustryCateLabel().equals("")) {
                            tv_work_detail_hangye.setText("暂无分类");
                        } else {
                            tv_work_detail_hangye.setText(shopDetailDataBean.getBody().getApiShop().getIndustryCateLabel());
                        }
                        if (shopDetailDataBean.getBody().getApiShop().getAnsShopBasic().getShopAddr() == null || shopDetailDataBean.getBody().getApiShop().getAnsShopBasic().getShopAddr().equals("")) {
                            tv_work_detail_address.setText("暂无地址");
                        } else {
                            tv_work_detail_address.setText(shopDetailDataBean.getBody().getApiShop().getAnsShopBasic().getShopAddr());
                        }

                        if (shopDetailDataBean.getBody().getApiShop().getAnsShopBasic().getShopBrief() == null || shopDetailDataBean.getBody().getApiShop().getAnsShopBasic().getShopBrief().toString().equals("")) {
                            tv_work_detail_introduce.setText("等待商家补充");
                        } else {
                            tv_work_detail_introduce.setText(shopDetailDataBean.getBody().getApiShop().getAnsShopBasic().getShopBrief());
                        }
                        tv_work_detail_time.setText(shopDetailDataBean.getBody().getApiShop().getAnsShopBasic().getOpenTime() + "-" + shopDetailDataBean.getBody().getApiShop().getAnsShopBasic().getCloseTime());

                        break;
                    //优惠券
                    case 3:

                        if (li_workroom_xuan.getParent() != search2) {
                            search01.removeView(li_workroom_xuan);
                            search2.addView(li_workroom_xuan);
                        }
                        whs_workroom_scroll.smoothScrollTo(0, 0);

                        listView.setVisibility(View.GONE);
                        reMassage.setVisibility(View.GONE);
                        reCoupu.setVisibility(View.VISIBLE);
                        listView_xinyong.setVisibility(View.GONE);
                        li_roomdetail_xinyong.setVisibility(View.GONE);

                        /**
                         * 商家优惠券
                         */
                        if (SP.get(WorkRoomDetailActivity.this, SpContent.isLogin, "0").equals("1")) {
                            geeshopDiscoun();
                        } else {
                            Intent intent = new Intent(WorkRoomDetailActivity.this, LoginActivity.class);
                            intent.putExtra("activite", "no");
                            startActivity(intent);
                        }
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }

    @OnClick({R.id.iv_back, R.id.tv_submit, R.id.tv_work_detail_guanzhu, R.id.tv_workroom_service_jubao, R.id.iv_title, R.id.iv_workroom_share,
            R.id.li_workroom_link})
    public void OnClick(View view) {
        switch (view.getId()) {
            case R.id.li_workroom_link:
                Intent intentt = new Intent(Intent.ACTION_DIAL);
                Uri data = Uri.parse("tel:" + phone_number);
                intentt.setData(data);
                startActivity(intentt);
                break;
            case R.id.iv_workroom_share:
                if (isLogin.equals("1")) {
                    mShareAction.open();
                } else {
                    T.show("请您先登录APP");
                    Intent intent = new Intent(this, LoginActivity.class);
                    intent.putExtra("activite", "no");
                    startActivity(intent);
                }
                break;
            case R.id.iv_back:
                finish();
                break;
            //提交订单
            case R.id.tv_submit:
                boolean isBuyRule = false;
                boolean isrdinary = false;
                for (ShoppingCartBean.BodyBean.ShopListBean list : shoppingCartBean.getBody().getShopList()) {
                    for (ShoppingCartBean.BodyBean.ShopListBean.ApiAnsCustCartListBean bean : list.getApiAnsCustCartList()) {
                        ShoppingCartBean.BodyBean.ShopListBean.ApiAnsCustCartListBean.EcGoodsBasicBean good = bean.getEcGoodsBasic();
                        if (good.getBuyRule().equals("1")) {
                            isBuyRule = true;
                        }
                        if (!good.getBuyRule().equals("1")) {
                            isrdinary = true;
                        }
                    }
                }
                if (isBuyRule && isrdinary) {
                    AlertDialog dialog = new AlertDialog.Builder(this).create();
                    dialog.setMessage("特价商品无法与其他商品一起结算");
                    dialog.setButton(DialogInterface.BUTTON_POSITIVE, "确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    dialog.show();
                    return;
                }
                Intent intent = new Intent(this, PurchaseActivity.class);
                intent.putExtra("cartBean", (Serializable) shoppingCartBean);
                startActivity(intent);
                break;
            //购物车
            case R.id.iv_title:
                if (isLogin.equals("1")) {
                    startActivity(new Intent(this, ShoppingCartActivity.class));
                } else {
                    T.show("请您先登录APP");
                    Intent intentc = new Intent(this, LoginActivity.class);
                    intentc.putExtra("activite", "no");
                    startActivity(intentc);
                }
                break;
            /**
             * 关注店铺
             */
            case R.id.tv_work_detail_guanzhu:
                if (isLogin.equals("1")) {
                    userId = (String) SP.get(WorkRoomDetailActivity.this, SpContent.UserId, "");
                    if (tv_work_detail_guanzhu.getText().equals("关注")) {
                        guanzhuData();//关注
                    } else {
                        cancelGuanzhuData();//取消关注
                    }
                } else {
                    T.show("请您先登录APP");
                    Intent intentc = new Intent(this, LoginActivity.class);
                    intentc.putExtra("activite", "no");
                    startActivity(intentc);
                }
                break;

            //举报
            case R.id.tv_workroom_service_jubao:
                jubaoData();
                break;
        }
    }

    @Override
    public void showLoadingDialog() {

    }

    @Override
    public void showErrorMessage(String s) {

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        // TODO Auto-generated method stub

        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            searchLayoutTop = li_workroom_top.getBottom();// 获取searchLayout的顶部位置
        }
    }

    @Override
    public void onScroll(int scrollY) {
        if (scrollY >= (hight)) {
            if (li_workroom_xuan.getParent() != search01) {
                search2.removeView(li_workroom_xuan);
                search01.addView(li_workroom_xuan);
            }
        } else {
            if (li_workroom_xuan.getParent() != search2) {
                search01.removeView(li_workroom_xuan);
                search2.addView(li_workroom_xuan);
            }
        }
    }

    public void loadMoreCommentData(List<ShopCommentBean.BodyBean.EcAppraiseGoodsListBean> apiOrderListMore) {


        if (ecAppraiseGoodsList == null) {
            ecAppraiseGoodsList = new ArrayList<>();
        }
        if (pageIndex1 == 0) {
            creditAdapter.Clear();
        }

        ecAppraiseGoodsList.addAll(apiOrderListMore);

        if (pageIndex1 == 0) {
            creditAdapter.setmDate(ecAppraiseGoodsList);
        } else {
            creditAdapter.notifyDataSetChanged();
        }
        pageIndex1 += Integer.parseInt(SpContent.pageSize);
    }

    public void loadMoreData(List<ShopSalesProduct.BodyBean.ApiGoodsListBean> apiOrderListMore) {


        if (apiGoodsList == null) {
            apiGoodsList = new ArrayList<>();
        }
        if (pageIndex == 0) {
            listadapter.Clear();
        }

        apiGoodsList.addAll(apiOrderListMore);


        if (pageIndex == 0) {
            listadapter.setmDate(apiGoodsList);
        } else {
            listadapter.notifyDataSetChanged();
        }
        pageIndex += Integer.parseInt(SpContent.pageSize);
    }

    private static class CustomShareListener implements UMShareListener {

        private WeakReference<FullActivity> mActivity;

        private CustomShareListener(FullActivity activity) {
            mActivity = new WeakReference(activity);
        }

        @Override
        public void onStart(SHARE_MEDIA platform) {

        }

        @Override
        public void onResult(SHARE_MEDIA platform) {

            if (platform.name().equals("WEIXIN_FAVORITE")) {
                Toast.makeText(mActivity.get(), platform + " 收藏成功啦", Toast.LENGTH_SHORT).show();
            } else {
                if (platform != SHARE_MEDIA.MORE && platform != SHARE_MEDIA.SMS
                        && platform != SHARE_MEDIA.EMAIL
                        && platform != SHARE_MEDIA.FLICKR
                        && platform != SHARE_MEDIA.FOURSQUARE
                        && platform != SHARE_MEDIA.TUMBLR
                        && platform != SHARE_MEDIA.POCKET
                        && platform != SHARE_MEDIA.PINTEREST
                        && platform != SHARE_MEDIA.INSTAGRAM
                        && platform != SHARE_MEDIA.GOOGLEPLUS
                        && platform != SHARE_MEDIA.YNOTE
                        && platform != SHARE_MEDIA.EVERNOTE) {
                    Toast.makeText(mActivity.get(), platform + " 分享成功啦", Toast.LENGTH_SHORT).show();
                }
            }
        }

        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            if (platform != SHARE_MEDIA.MORE && platform != SHARE_MEDIA.SMS
                    && platform != SHARE_MEDIA.EMAIL
                    && platform != SHARE_MEDIA.FLICKR
                    && platform != SHARE_MEDIA.FOURSQUARE
                    && platform != SHARE_MEDIA.TUMBLR
                    && platform != SHARE_MEDIA.POCKET
                    && platform != SHARE_MEDIA.PINTEREST
                    && platform != SHARE_MEDIA.INSTAGRAM
                    && platform != SHARE_MEDIA.GOOGLEPLUS
                    && platform != SHARE_MEDIA.YNOTE
                    && platform != SHARE_MEDIA.EVERNOTE) {
                Toast.makeText(mActivity.get(), platform + " 分享失败啦", Toast.LENGTH_SHORT).show();
            }
            if (t != null) {
                L.e("throw", "throw:" + t.getMessage());
            }
        }

        @Override
        public void onCancel(SHARE_MEDIA platform) {
            Toast.makeText(mActivity.get(), platform + " 分享取消了", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }
}
