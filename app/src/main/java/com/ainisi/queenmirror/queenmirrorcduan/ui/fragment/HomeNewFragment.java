package com.ainisi.queenmirror.queenmirrorcduan.ui.fragment;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ainisi.queenmirror.common.base.BaseFragment;
import com.ainisi.queenmirror.common.commonutils.TUtil;
import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.HomeListViewAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.HomeNewShopAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.HomepageGridViewAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.HomepageNearBean;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.bean.ChaiRedPacketBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.CheckApkBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.HomeBannerMiddleBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.HomeNewShopBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.HomepageNearByBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.Homepagebean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.NewsBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.QueenCardStatueBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.RedPacketBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.RedPacketOrderBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.ShopListHomeBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.ActiviteMainActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.DailyNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.FullActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.HomeAdvertisingActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.HomeFightaloneActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.MessageActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.QueenHeadlineActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.RankListNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.SearchActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.SecKillActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.SelectCityActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.ShoppingCartActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.SortActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.SpecialPriceActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.adapter.HomeServerAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.adapter.NewTopAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean.CommendGoodBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean.HomeIndustryBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean.MerchantsBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean.PageBannerBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean.PreferentialBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean.SuggestionBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.util.ComplexViewMF;
import com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity.ActivityByHolidayActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity.BigClassroomActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity.MineGiftActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.shop.activity.WorkRoomDetailActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.user.LoginActivity;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.L;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.LoadingDialog;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SP;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.ScrollRecyclerView;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpContent;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.ainisi.queenmirror.queenmirrorcduan.utils.DragFloatActionButton;
import com.ainisi.queenmirror.queenmirrorcduan.utils.GDLocationUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utils.GlideImageLoader;
import com.ainisi.queenmirror.queenmirrorcduan.utils.MD5;
import com.ainisi.queenmirror.queenmirrorcduan.utils.NoScrollGridView;
import com.ainisi.queenmirror.queenmirrorcduan.utils.NoScrollListview;
import com.ainisi.queenmirror.queenmirrorcduan.utils.ScrollInterceptScrollView;
import com.ainisi.queenmirror.queenmirrorcduan.utils.Utils;
import com.amap.api.location.AMapLocation;
import com.ansen.http.net.HTTPCaller;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.john.library.PopWindowHome;
import com.gongwen.marqueen.MarqueeView;
import com.gongwen.marqueen.util.OnItemClickListener;
import com.lzy.okgo.cache.CacheMode;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.umeng.analytics.MobclickAgent;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerListener;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.github.lizhangqu.coreprogress.ProgressUIListener;
import q.rorbin.badgeview.Badge;
import q.rorbin.badgeview.QBadgeView;

public class HomeNewFragment extends BaseFragment implements HttpCallBack {
    @Bind(R.id.banner)
    Banner banner;
    @Bind(R.id.banner_middle)
    Banner banner_middle;
    @Bind(R.id.mv_home_marqueeView)
    MarqueeView mv_home_marqueeView;
    @Bind(R.id.rv_home_new_every)
    ScrollRecyclerView rv_home_new_every;
    @Bind(R.id.nl_home_list_view)
    NoScrollListview nl_home_list_view;
    @Bind(R.id.gv_home_gridView)
    NoScrollGridView gv_home_gridView;
    @Bind(R.id.iv_surface)
    ImageView iv_surface;
    @Bind(R.id.line_surface)
    LinearLayout line_surface;
    @Bind(R.id.iv_uspension_surface)
    ImageView iv_uspension_surface;
    @Bind(R.id.layout_stick_header_main)
    LinearLayout layout_stick_header_main;
    @Bind(R.id.sc_home_scroll)
    ScrollInterceptScrollView sc_home_scroll;
    @Bind(R.id.tv_home_bustling)
    public TextView mLocation;
    @Bind(R.id.img_information)
    ImageView img_information;
    @Bind(R.id.li_new_top)
    LinearLayout li_new_top;
    @Bind(R.id.home_layout)
    LinearLayout home_layout;
    @Bind(R.id.li_home_paixu)
    LinearLayout li_home_paixu;
    @Bind(R.id.iv_near_sort)
    ImageView iv_near_sort;
    @Bind(R.id.li_top_select)
    LinearLayout li_top_select;
    @Bind(R.id.rb_sales)
    TextView rb_sales;
    @Bind(R.id.tv_sales)
    TextView tv_sales;
    @Bind(R.id.li_home_screen)
    LinearLayout li_home_screen;
    @Bind(R.id.rb_screen)
    TextView tvScreen;
    @Bind(R.id.iv_distance_sort)
    ImageView ivdistance;
    @Bind(R.id.iv_home_newuserprg)
    ImageView ivNewuserprg;
    @Bind(R.id.iv_home_freetrial)
    ImageView ivFreetrial;
    @Bind(R.id.iv_home_goodshop)
    ImageView ivGoodshop;
    @Bind(R.id.iv_home_specialoffer)
    ImageView ivSpecialoffer;
    @Bind(R.id.iv_good_itemShop)
    ImageView ivItemShop;
    @Bind(R.id.iv_modou_convert)
    ImageView ivConvert;
    @Bind(R.id.iv_invitation_prize)
    ImageView ivPrize;
    @Bind(R.id.iv_queen_shop)
    ImageView ivQueenShop;
    @Bind(R.id.li_home_near_shop)
    LinearLayout li_home_near_shop;
    @Bind(R.id.li_sales_bottom)
    LinearLayout li_sales_bottom;
    @Bind(R.id.bt_up_home)
    public TextView bt_up_home;
    @Bind(R.id.tv_distance)
    TextView tv_distance;
    @Bind(R.id.bt_app_home)
    public TextView bt_app_home;
    @Bind(R.id.tv_new_distance)
    public TextView tv_new_distance;
    @Bind(R.id.shop_list_null)
    RelativeLayout shop_list_null;
    @Bind(R.id.li_home_bottom)
    LinearLayout li_home_bottom;
    @Bind(R.id.iv_homepage_redpacket)
    ImageView iv_homepage_redpacket;
    @Bind(R.id.li_home_gv)
    NoScrollGridView mLiHomeGv;
    @Bind(R.id.home_server_gv)
    NoScrollGridView mHomeServerGv;

    private HomeIndustryBean homeIndustryBean;
    boolean type = false;
    ShopListHomeBean shopListHomeBean;
    ShopListHomeBean homeShopBySalesBean;
    Intent intent;
    public static HomeNewFragment instance = null;
    private List<ShopListHomeBean.BodyBean.ShopListDataBean> shoplist = new ArrayList<>();
    private List<PageBannerBean.BodyBean.BannerListDataBean> bannerList;

    private List<PageBannerBean.BodyBean.BannerListDataBean> bannerList_2 = new ArrayList<>();
    List<HomeBannerMiddleBean> bannerMiddleBeanList = new ArrayList<>();
    List<MerchantsBean.BodyBean.ActivityKeysListDataBean> merchantsList = new ArrayList<>();
    List<PreferentialBean.BodyBean.FeatureKeysListDataBean> preferentialList = new ArrayList<>();
    @Bind(R.id.home_refreshLayout)
    SmartRefreshLayout home_refreshLayout;
    public int pageNumber = 1;
    public int pageIndex = 0;
    int pageSum = 0;
    HomepageGridViewAdapter gridViewAdapter;
    HomeListViewAdapter homeListViewAdapter;
    public PopWindowHome popWindowHomes;
    ListView rv_nearlist_right;
    String city_code = "0512";
    HomepageNearBean sortAdapter2;
    List<HomepageNearByBean> home_string = new ArrayList<>();
    List<Homepagebean.BodyBean.DistrictListDataBean> DistrictListData;
    public int input_where = 0;
    int zonghe_where = 0;
    NewsBean newsBean;
    String apk_code, apk_url;
    private ProgressDialog progressDialog;
    @Bind(R.id.home_app_bar)
    LinearLayout home_app_bar;
    @Bind(R.id.tv_screen)
    TextView tv_screen;
    @Bind(R.id.home_new_fragment_shopcart)
    DragFloatActionButton home_new_fragment_shopcart;
    int hight1, hight2, hight, imageHeight;
    LoadingDialog loadingDialog;
    String cond = "";
    public String distance = "";
    public String distance_code = "1";

    String queenCard = "";
    AnimationDrawable animaition;

    @Bind(R.id.iv_homepage_activity)
    ImageView iv_homepage_activity;
    String activite_url = "https://nvxcx.oss-cn-hangzhou.aliyuncs.com/images/songxialiang/dialog_icon.png";

    RedPacketBean redPacketBean;
    String redPacketId = "";
    ChaiRedPacketBean chaiRedPacketBean;

    String text1 = "", text2 = "", money = "0", isNew = "0";
    boolean isShow = false;
    boolean isClick = false;

    Dialog dialog_red;
    private NewTopAdapter mNewTopAdapter;
    private List<CommendGoodBean.BodyBean.ApiEcGoodsBasicListBean> mApiEcGoodsBasicList;

    @Override
    protected int getLayoutResource() {
        instance = this;
        return R.layout.activity_home_new_fragment;
    }

    @Override
    public void initPresenter() {
    }

    @Override
    public void onResume() {
        super.onResume();
        if (dialog_red != null) {
            dialog_red.dismiss();
        }

        MobclickAgent.onResume(getActivity());
        Glide.with(getActivity()).load(activite_url).dontAnimate().into(iv_homepage_activity);

        if (SP.get(getActivity(), SpContent.isLogin, "0").equals("1")) {

        } else {
            SP.put(getActivity(), SpContent.UserToken, "");
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                if (loadImageFromNetwork(activite_url)) {
                    isShow = true;
                    if (SP.get(getActivity(), SpContent.isFirstActivite, "0").equals("0")) {

                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                DialogByActivity(getActivity());
                            }
                        });
                    }
                } else {
                    isShow = false;
                }
            }
        }).start();

        if (isShow) {
            iv_homepage_activity.setVisibility(View.VISIBLE);
        } else {
            iv_homepage_activity.setVisibility(View.GONE);
        }
        isClick = false;
        getRedPacketData();


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            sc_home_scroll.setOnScrollChangeListener(new View.OnScrollChangeListener() {
                @Override
                public void onScrollChange(View view, int i, int i1, int i2, int i3) {
                    int hight = banner.getHeight() - home_app_bar.getHeight();
                    if (i1 <= 0) {
                        home_app_bar.setBackgroundColor(Color.argb((int) 0, 196, 113, 245));//AGB由相关工具获得，或者美工提供
                    } else if (i1 > 0 && i1 <= hight) {
                        float scale = (float) i1 / hight;
                        float alpha = (255 * scale);
                        // 只是layout背景透明(仿知乎滑动效果)
                        home_app_bar.setBackgroundColor(Color.argb((int) alpha, 196, 113, 245));
                    } else {
                        home_app_bar.setBackgroundColor(Color.argb((int) 250, 196, 113, 245));
                    }
                }
            });
        }
    }

    /**
     * 用户进入C端后调用红包弹层信息
     */
    private void getRedPacketData() {
        HashMap<String, String> parames = new HashMap<>();
        parames.put("platformType", "1");//
        parames.put("token", SP.get(getActivity(), SpContent.UserToken, "") + "");
        HttpUtils.doPost(ACTION.GOINREDPACKETHOMEPAGE, parames, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    @Override
    public void onPause() {
        super.onPause();
        MobclickAgent.onPause(getActivity());
    }

    /**
     * 首页Banner图
     */
    private void initBanner() {
        HashMap<String, String> parames = new HashMap<>();
        parames.put("bannerCategory", "0");//0是首页   1是商城
        parames.put("platformType", "1");
//        parames.put("token", SP.get(getActivity(), SpContent.UserToken, "") + "");
        HttpUtils.doPost(ACTION.PAGEBANNER, parames, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    /**
     * 获取首页的行业分类
     */
    private void getBannerData() {
        HashMap<String, String> params = new HashMap<>();
        params.put("tabType", "2");//type  2代表美业    4代表异业
        params.put("tabFather", "0");
        params.put("token", SP.get(getActivity(), SpContent.UserToken, "") + "");
        HttpUtils.doPost(ACTION.INDUSTRY, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);//首页的行业分类
    }

    /**
     * 获取首页底部商家列表
     */
    private void getShopData() {
        loadingDialog.loadShow();
        HashMap<String, String> params = new HashMap<>();
        params.put("pageNumber", pageNumber + "");
        params.put("contentByTitle", "");
        params.put("pageSize", SpContent.pageSize);
        params.put("shopCate", "1");
        params.put("cityCode", city_code);
        params.put("token", SP.get(getActivity(), SpContent.UserToken, "") + "");
        HttpUtils.doPost(ACTION.SHOPLIST, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    /**
     * 获取新消息提示
     */
    private void getNewNewsData() {
        HashMap<String, String> params = new HashMap<>();
        params.put("userId", SP.get(getActivity(), SpContent.UserId, "") + "");
        params.put("token", SP.get(getActivity(), SpContent.UserToken, "") + "");
        HttpUtils.doPost(ACTION.GETNEWNEWS, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    /**
     * 获取销量最高数据
     */
    private void getSalesData() {
        loadingDialog.loadShow();
        HashMap<String, String> params = new HashMap<>();
        params.put("pageNumber", pageNumber + "");
        params.put("contentByTitle", "");
        params.put("shopCate", "1");
        params.put("pageSize", SpContent.pageSize);
        params.put("cityCode", city_code);
        params.put("token", SP.get(getActivity(), SpContent.UserToken, "") + "");
        HttpUtils.doPost(ACTION.SHOPBYSALES, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    @Override
    protected void doFitsrData() {
        if (TextUtils.isEmpty(apk_url)) {
            CheckNewApk();
        }
        String islogin = (String) SP.get(getActivity(), SpContent.isLogin, "0");
        //获取新消息提示
        if (!TextUtils.isEmpty(islogin) && "1".equals(islogin)) {
            getNewNewsData();
        }
        // 获取首页部分数据
        initBanner();
        getBannerData();
        if (shoplist.size() == 0) {
            getShopData();
        }
        initnewShop();
        IfBeQueenVIP();
        initshophttp();
    }

    /**
     * 判断我是不是女王会员
     */
    private void IfBeQueenVIP() {
        HashMap<String, String> params = new HashMap<>();
        params.put("userId", SP.get(getActivity(), SpContent.UserId, "") + "");
        params.put("token", SP.get(getActivity(), SpContent.UserToken, "") + "");
        HttpUtils.doPost(ACTION.GETHUIYUANSTAUTE, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    /**
     * 商家推荐商品的数据
     */
    private void initshophttp() {
        HashMap<String, String> hashMap1 = new HashMap();
        hashMap1.put("saleFlag", "2");
        hashMap1.put("pageNumber", "1");
        hashMap1.put("cityCode", (String) SP.get(getActivity(), SpContent.CityCode, "0512"));//shopId  111
        hashMap1.put("pageSize", "5");
        hashMap1.put("token", SP.get(getActivity(), SpContent.UserToken, "") + "");
        HttpUtils.doPost(ACTION.COMMENDGOODS, hashMap1, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    @SuppressLint("NewApi")
    @Override
    protected void initView() {
        loadingDialog = new LoadingDialog(getActivity());
        gridViewAdapter = new HomepageGridViewAdapter(getActivity(), shoplist, "home");
        gv_home_gridView.setAdapter(gridViewAdapter);
        homeListViewAdapter = new HomeListViewAdapter(getActivity(), shoplist, "home");
        nl_home_list_view.setAdapter(homeListViewAdapter);

        /**
         * 红包相关
         */

        iv_homepage_redpacket.setBackgroundResource(R.drawable.animation_list);
        animaition = (AnimationDrawable) iv_homepage_redpacket.getBackground();
        animaition.setOneShot(false);

        iv_homepage_redpacket.post(new Runnable() {
            @Override
            public void run() {
                animaition.start();
            }
        });

        city_code = SP.get(getActivity(), SpContent.CityCode, "0512") + "";
        home_refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                pageNumber = 1;
                pageIndex = 0;
                /**
                 * 获取首页部分数据
                 */
                initBanner();
                getBannerData();
                initshophttp();
                if (input_where == 0) {
                    getShopData();
                } else if (input_where == 1) {
                    if (distance_code.equals("1")) {
                        getDistanPaixuData(distance);
                    } else {
                        getNearPaixuData(distance);
                    }
                } else if (input_where == 2) {
                    getSalesData();
                } else if (input_where == 3) {
                    if (zonghe_where == 0) {
                        getZonghePaixuData();
                    } else if (zonghe_where == 1) {
                        getScorePaixuData();
                    } else if (zonghe_where == 2) {
                        getLookPaixuData();
                    }
                } else if (input_where == 4) {
                    getSelectData();
                }
                initnewShop();
                refreshlayout.finishRefresh(2000);
            }
        });
        home_refreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                if (pageSum < Integer.parseInt(SpContent.pageSize)) {
                    refreshlayout.finishLoadmore(2000);
                    T.show("您已加载完全部数据");
                } else {
                    pageNumber++;
                    if (input_where == 0) {
                        getShopData();
                    } else if (input_where == 1) {
                        if (distance_code.equals("1")) {
                            getDistanPaixuData(distance);
                        } else {
                            getNearPaixuData(distance);
                        }
                    } else if (input_where == 2) {
                        getSalesData();
                    } else if (input_where == 3) {
                        if (zonghe_where == 0) {
                            getZonghePaixuData();
                        } else if (zonghe_where == 1) {
                            getScorePaixuData();
                        } else if (zonghe_where == 2) {
                            getLookPaixuData();
                        }
                    } else if (input_where == 4) {
                        getSelectData();
                    }
                }
                refreshlayout.finishLoadmore(2000);
            }
        });

        /**
         * 这里是设置中间三个图片的高度
         */
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) ivItemShop.getLayoutParams();
        //获取当前控件的布局对象
        params.height = TUtil.getScreenWidth(getActivity()) / 3;//设置当前控件布局的高度
        ivItemShop.setLayoutParams(params);//将设置好的布局参数应用到控件中
        LinearLayout.LayoutParams params1 = (LinearLayout.LayoutParams) ivConvert.getLayoutParams();
        //获取当前控件的布局对象
        params1.height = TUtil.getScreenWidth(getActivity()) / 3;//设置当前控件布局的高度
        ivConvert.setLayoutParams(params1);//将设置好的布局参数应用到控件中
        LinearLayout.LayoutParams params2 = (LinearLayout.LayoutParams) ivPrize.getLayoutParams();
        //获取当前控件的布局对象
        params2.height = TUtil.getScreenWidth(getActivity()) / 3;//设置当前控件布局的高度
        ivPrize.setLayoutParams(params2);//将设置好的布局参数应用到控件中


//        int w = View.MeasureSpec.makeMeasureSpec(0,
//                View.MeasureSpec.UNSPECIFIED);
//        int h = View.MeasureSpec.makeMeasureSpec(0,
//                View.MeasureSpec.UNSPECIFIED);
//        li_new_top.measure(w, h);
//        home_layout.measure(w, h);
    }

    private void initnewShop() {
        HashMap<String, String> parames = new HashMap<>();
        parames.put("shopCate", "1");
        parames.put("cityCode", city_code);
        HttpUtils.doPost(ACTION.NEWSHOPlIST, parames, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {

        if (requestCode == 1001) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                loadHomePageData();
            } else {
                T.show("Permission Denied");
            }
            return;
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    public void onStart() {
        super.onStart();
        loadHomePageData();
    }

    /**
     * 查看是否有新的版本
     */
    private void CheckNewApk() {
        HashMap<String, String> parames = new HashMap<>();
        parames.put("appFlag", "1");
        HttpUtils.doPost(ACTION.CHECKNEWAPK, parames, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    private void loadHomePageData() {
        GDLocationUtil.init(getActivity());
        GDLocationUtil.getCurrentLocation(new GDLocationUtil.MyLocationListener() {
            @Override
            public void result(AMapLocation location) {
                if (TextUtils.isEmpty(location.getCity())) {
                    mLocation.setText("苏州");
                } else {
                    mLocation.setText(location.getCity());
                    String lon = location.getLongitude() + "";
                    String lat = location.getLatitude() + "";
                    SP.put(getActivity(), SpContent.UserLon, lon);
                    SP.put(getActivity(), SpContent.UserLat, lat);
                    if (location.getCityCode().equals("")) {
                        SP.put(getActivity(), SpContent.CityCode, "0512");
                    } else {
                        SP.put(getActivity(), SpContent.CityCode, location.getCityCode());
                    }
                    loadData(shoplist);
                }
            }
        });
    }

    /**
     * 红包对话框
     */
    private void DialogByRedPacket(Context context, String isLogin, String hasReceive) {

        SP.put(getActivity(), SpContent.isRedPacket, "1");

        String types = "0";

        final AlertDialog.Builder builder = new AlertDialog.Builder(context, R.style.dialog);
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = null;
        if (isLogin.equals("0")) {
            v = inflater.inflate(R.layout.homepage_red_packet, null);//注册
            types = "0";
        } else if (isLogin.equals("1")) {

            if (hasReceive.equals("1")) {
                /**
                 * 1的情况显示未拆的红包
                 */
                v = inflater.inflate(R.layout.homepage_red_packet_notsealed, null);
                types = "1";
            } else if (hasReceive.equals("2")) {
                /**
                 * 2的情况显示拆后的金额红包
                 */
                v = inflater.inflate(R.layout.homepage_red_packet_notsealed, null);
                types = "2";
            }
        }
        dialog_red = builder.create();
        dialog_red.show();
        dialog_red.getWindow().setContentView(v);//自定义布局应该在这里添加，要在dialog.show()的后

        if (types.equals("0")) {
            ImageView iv_home_page_dissmiss = v.findViewById(R.id.iv_home_page_dissmiss);
            iv_home_page_dissmiss.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog_red.dismiss();
                }
            });

            TextView tv_red_packet_regist = v.findViewById(R.id.tv_red_packet_regist);
            tv_red_packet_regist.setText(redPacketBean.getBody().getAnsRedPacket().getTemplateButtonTitle());
            tv_red_packet_regist.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getActivity(), LoginActivity.class);
                    intent.putExtra("activite", "no");
                    startActivity(intent);
                    dialog_red.dismiss();
                }
            });

            TextView tv_red_packet_bottom_use = v.findViewById(R.id.tv_red_packet_bottom_use);
            tv_red_packet_bottom_use.setText(redPacketBean.getBody().getAnsRedPacket().getRedPacketName());
            TextView tv_red_packet_money_more = v.findViewById(R.id.tv_red_packet_money_more);
            tv_red_packet_money_more.setText(redPacketBean.getBody().getAnsRedPacket().getMaxMoney());
            TextView tv_red_packet_top = v.findViewById(R.id.tv_red_packet_top);
            tv_red_packet_top.setText(redPacketBean.getBody().getAnsRedPacket().getTemplateHeadTitle());
        } else if (types.equals("1")) {
            TextView tv_red_packet_new = v.findViewById(R.id.tv_red_packet_new);
            tv_red_packet_new.setText(redPacketBean.getBody().getAnsRedPacket().getTemplateHeadTitle());
            TextView tv_red_packet_money_top = v.findViewById(R.id.tv_red_packet_money_top);
            tv_red_packet_money_top.setText(redPacketBean.getBody().getAnsRedPacket().getMaxMoney());
            ImageView iv_home_page_dissmiss = v.findViewById(R.id.iv_home_page_dissmiss);
            LinearLayout li_red_packet_have_chaizi = v.findViewById(R.id.li_red_packet_have_chaizi);
            li_red_packet_have_chaizi.setVisibility(View.GONE);
            iv_home_page_dissmiss.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog_red.dismiss();
                }
            });
            ImageView iv_red_packet_sealed = v.findViewById(R.id.iv_red_packet_sealed);

            iv_red_packet_sealed.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    /**
                     *   拆红包
                     */
                    dialog_red.dismiss();
                    redPacketId = redPacketBean.getBody().getAnsRedPacket().getId();
                    loadingDialog.loadShow();

                    ChaiRedPacket();
                }

            });
        } else if (types.equals("2")) {
            LinearLayout li_red_packet_chaizi = v.findViewById(R.id.li_red_packet_chaizi);
            li_red_packet_chaizi.setVisibility(View.GONE);
            LinearLayout li_red_packet_have_chaizi = v.findViewById(R.id.li_red_packet_have_chaizi);
            li_red_packet_have_chaizi.setVisibility(View.VISIBLE);

            ImageView iv_home_page_dissmiss_have = v.findViewById(R.id.iv_home_page_dissmiss_have);
            iv_home_page_dissmiss_have.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog_red.dismiss();
                }
            });
            TextView tv_red_packet_top = v.findViewById(R.id.tv_red_packet_top);
            tv_red_packet_top.setText(chaiRedPacketBean.getBody().getAnsRedPacket().getOpenHeadTitle());
            TextView tv_red_packet_money_more = v.findViewById(R.id.tv_red_packet_money_more);
            tv_red_packet_money_more.setText(chaiRedPacketBean.getBody().getAnsRedPacket().getRedPacketMoney());
            TextView tv_red_packet_bottom_use = v.findViewById(R.id.tv_red_packet_bottom_use);
            tv_red_packet_bottom_use.setText(chaiRedPacketBean.getBody().getAnsRedPacket().getOpenBottomTitle());
            TextView tv_red_packet_regist = v.findViewById(R.id.tv_red_packet_regist);
            tv_red_packet_regist.setText(chaiRedPacketBean.getBody().getAnsRedPacket().getOpenButtonTitle());
            RelativeLayout rl_red_packet_order = v.findViewById(R.id.rl_red_packet_order);
            rl_red_packet_order.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog_red.dismiss();
                }
            });
        }
    }


    /**
     * 活动对话框
     */
    private void DialogByActivity(Context context) {

        SP.put(getActivity(), SpContent.isFirstActivite, "1");

        final AlertDialog.Builder builder = new AlertDialog.Builder(context, R.style.dialog);
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.home_page_activity_dialog, null);
        final Dialog dialog = builder.create();
        dialog.show();
        dialog.getWindow().setContentView(v);//自定义布局应该在这里添加，要在dialog.show()的后

        ImageView iv_home_page_dissmiss = v.findViewById(R.id.iv_home_page_dissmiss);

        iv_home_page_dissmiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        ImageView iv_activite_submit = v.findViewById(R.id.iv_activite_submit);
        iv_activite_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ActiviteMainActivity.class);
                startActivity(intent);
            }
        });
        RelativeLayout rl_red_packet_buy = v.findViewById(R.id.rl_red_packet_buy);
        rl_red_packet_buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                sc_home_scroll.smoothScrollTo(0, hight1 + hight2 - home_app_bar.getHeight());
            }
        });
    }

    @OnClick({R.id.iv_home_freetrial, R.id.line_surface, R.id.line_uspension_surface, R.id.tv_home_bustling, R.id.iv_home_search, R.id.img_information, R.id.rb_sales, R.id.li_home_screen_bottom, R.id.li_home_screen, R.id.li_sales_bottom, R.id.tv_sales,
            R.id.li_home_near_shop, R.id.li_homenew_near_shop, R.id.li_sales_new_bottom, R.id.home_new_fragment_shopcart, R.id.iv_homepage_activity,
            R.id.iv_homepage_redpacket, R.id.home_server_ll, R.id.home_new_shop})
    public void onClick(View view) {
        switch (view.getId()) {
            /**
             * 红包活动
             */
            case R.id.iv_homepage_redpacket:
                isClick = true;
                if (SP.get(getActivity(), SpContent.isLogin, "0").equals("0") && SP.get(getActivity(), SpContent.isRedPacket, "0").equals("1")) {
                    DialogByRedPacket(getActivity(), "0", "0");
                } else {
                    getRedPacketData();
                }
                break;
            /**
             * 清凉一夏活动
             */
            case R.id.iv_homepage_activity:

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        if (loadImageFromNetwork(activite_url)) {

                            getActivity().runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    DialogByActivity(getActivity());
                                }
                            });
                        } else {

                        }
                    }
                }).start();

                break;
            case R.id.home_new_fragment_shopcart:
                if (SP.get(getActivity(), SpContent.isLogin, "").toString().equals("1")) {
                    Intent intent1 = new Intent(getActivity(), ShoppingCartActivity.class);
                    startActivity(intent1);

                } else {
                    T.show("请先进行登录");
                }
                break;
            /**
             * 点击综合排序
             */
            case R.id.li_sales_new_bottom:
                setScroll();
            case R.id.li_sales_bottom:

                /**
                 * 设置商家文字
                 */
                //设置附近商家
                bt_up_home.setTextColor(this.getResources().getColor(R.color.alpha_55_black));
                TextPaint tp31 = bt_up_home.getPaint();
                tp31.setFakeBoldText(false);
                bt_app_home.setTextColor(this.getResources().getColor(R.color.alpha_55_black));
                TextPaint tps31 = bt_app_home.getPaint();
                tps31.setFakeBoldText(false);
                //设置销量文字
                tv_sales.setTextColor(this.getResources().getColor(R.color.alpha_55_black));
                TextPaint tpsa31 = tv_sales.getPaint();
                tpsa31.setFakeBoldText(false);
                rb_sales.setTextColor(this.getResources().getColor(R.color.alpha_55_black));
                TextPaint tpsa311 = tv_sales.getPaint();
                tpsa311.setFakeBoldText(false);
                //设置综合排序
                tv_distance.setTextColor(this.getResources().getColor(R.color.alpha_95_black));
                TextPaint tpsd31 = tv_sales.getPaint();
                tpsd31.setFakeBoldText(true);
                tv_new_distance.setTextColor(this.getResources().getColor(R.color.alpha_95_black));
                TextPaint tpsd311 = tv_sales.getPaint();
                tpsd311.setFakeBoldText(true);
                //筛选
                tv_screen.setTextColor(this.getResources().getColor(R.color.alpha_55_black));
                TextPaint tpscre31 = tv_sales.getPaint();
                tpscre31.setFakeBoldText(false);
                tvScreen.setTextColor(this.getResources().getColor(R.color.alpha_55_black));
                TextPaint tpscre311 = tv_sales.getPaint();
                tpscre311.setFakeBoldText(false);

                input_where = 3;

                if (hight > hight1 + hight2) {

                } else {
                    sc_home_scroll.smoothScrollTo(0, hight1 + hight2 - home_app_bar.getHeight());
                }

                View customViewn = View.inflate(getActivity(), R.layout.home_bottom_zonghe, null);
                final PopWindowHome popWindowHome = new PopWindowHome.Builder(getActivity())
                        .setStyle(PopWindowHome.PopWindowStyle.PopDown)
                        .setView(customViewn)
                        .setControlViewAnim(ivdistance, R.anim.btn_rotate_anim_1, R.anim.btn_rotate_anim_2, true)
                        .show(li_sales_bottom);//show里面的内容是显示在空间下方的控件
                /**
                 * 点击综合排序
                 */
                TextView tv_bottom_zonghe = customViewn.findViewById(R.id.tv_bottom_zonghe);
                tv_bottom_zonghe.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        tv_distance.setText("综合排序");
                        tv_new_distance.setText("综合排序");

                        pageIndex = 0;
                        pageNumber = 1;
                        zonghe_where = 0;

                        getZonghePaixuData();

                        popWindowHome.dismiss();
                    }
                });

                /**
                 * 评分从高到低
                 */
                TextView tv_bottom_pingfen = customViewn.findViewById(R.id.tv_bottom_pingfen);
                tv_bottom_pingfen.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        pageIndex = 0;
                        pageNumber = 1;
                        zonghe_where = 1;

                        tv_distance.setText("评分从高到低");
                        tv_new_distance.setText("评分从高到低");
                        getScorePaixuData();

                        popWindowHome.dismiss();
                    }
                });

                /**
                 * 浏览量从高到低
                 */
                TextView tv_bottom_look = customViewn.findViewById(R.id.tv_bottom_look);
                tv_bottom_look.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        pageIndex = 0;
                        pageNumber = 1;
                        zonghe_where = 2;

                        tv_distance.setText("浏览量从高到低");
                        tv_new_distance.setText("浏览量从高到低");
                        getLookPaixuData();

                        popWindowHome.dismiss();
                    }
                });

                break;
            /**
             * 筛选
             */
            case R.id.li_home_screen_bottom:
                setScroll();
            case R.id.li_home_screen:

                /**
                 * 设置商家文字
                 */
                //设置附近商家
                bt_up_home.setTextColor(this.getResources().getColor(R.color.alpha_55_black));
                TextPaint tp41 = bt_up_home.getPaint();
                tp41.setFakeBoldText(false);
                bt_app_home.setTextColor(this.getResources().getColor(R.color.alpha_55_black));
                TextPaint tps41 = bt_app_home.getPaint();
                tps41.setFakeBoldText(false);
                //设置销量文字
                tv_sales.setTextColor(this.getResources().getColor(R.color.alpha_55_black));
                TextPaint tpsa41 = tv_sales.getPaint();
                tpsa41.setFakeBoldText(false);
                rb_sales.setTextColor(this.getResources().getColor(R.color.alpha_55_black));
                TextPaint tpsa411 = rb_sales.getPaint();
                tpsa411.setFakeBoldText(false);
                //设置综合排序
                tv_distance.setTextColor(this.getResources().getColor(R.color.alpha_55_black));
                TextPaint tpsd41 = tv_distance.getPaint();
                tpsd41.setFakeBoldText(false);
                tv_new_distance.setTextColor(this.getResources().getColor(R.color.alpha_55_black));
                TextPaint tpsd411 = tv_new_distance.getPaint();
                tpsd411.setFakeBoldText(false);
                //筛选
                tv_screen.setTextColor(this.getResources().getColor(R.color.alpha_95_black));
                TextPaint tpscre41 = tv_screen.getPaint();
                tpscre41.setFakeBoldText(true);
                tvScreen.setTextColor(this.getResources().getColor(R.color.alpha_95_black));
                TextPaint tpscre411 = tvScreen.getPaint();
                tpscre411.setFakeBoldText(true);

                input_where = 4;

                sc_home_scroll.smoothScrollTo(0, hight1 + hight2 - home_app_bar.getHeight());

                inithttp();

                break;
            /**
             * 点击附近商家
             */
            case R.id.li_home_near_shop:
                setScroll();
            case R.id.li_homenew_near_shop:
                /**
                 * 设置商家文字
                 */
                //设置附近商家
                bt_up_home.setTextColor(this.getResources().getColor(R.color.alpha_95_black));
                TextPaint tp = bt_up_home.getPaint();
                tp.setFakeBoldText(true);
                bt_app_home.setTextColor(this.getResources().getColor(R.color.alpha_95_black));
                TextPaint tps = bt_app_home.getPaint();
                tps.setFakeBoldText(true);
                //设置销量文字
                tv_sales.setTextColor(this.getResources().getColor(R.color.alpha_55_black));
                TextPaint tpsa = tv_sales.getPaint();
                tpsa.setFakeBoldText(false);
                rb_sales.setTextColor(this.getResources().getColor(R.color.alpha_55_black));
                TextPaint tpsa1 = rb_sales.getPaint();
                tpsa1.setFakeBoldText(false);
                //设置综合排序
                tv_distance.setTextColor(this.getResources().getColor(R.color.alpha_55_black));
                TextPaint tpsd = tv_distance.getPaint();
                tpsd.setFakeBoldText(false);
                tv_new_distance.setTextColor(this.getResources().getColor(R.color.alpha_55_black));
                TextPaint tpsd1 = tv_new_distance.getPaint();
                tpsd1.setFakeBoldText(false);
                //筛选
                tv_screen.setTextColor(this.getResources().getColor(R.color.alpha_55_black));
                TextPaint tpscre = tv_screen.getPaint();
                tpscre.setFakeBoldText(false);
                tvScreen.setTextColor(this.getResources().getColor(R.color.alpha_55_black));
                TextPaint tpscre1 = tvScreen.getPaint();
                tpscre1.setFakeBoldText(false);


                if (hight > hight1 + hight2) {

                } else {
                    sc_home_scroll.smoothScrollTo(0, hight1 + hight2 - home_app_bar.getHeight());
                }

                View customViews = View.inflate(getActivity(), R.layout.homepage_near_list_bottom, null);
                popWindowHomes = new PopWindowHome.Builder(getActivity())
                        .setStyle(PopWindowHome.PopWindowStyle.PopDown)
                        .setView(customViews)
                        .setControlViewAnim(iv_near_sort, R.anim.btn_rotate_anim_1, R.anim.btn_rotate_anim_2, true)
                        .show(li_home_screen);//show里面的内容是显示在空间下方的控件
                final TextView tv_near_list_fujin = customViews.findViewById(R.id.tv_near_list_fujin);
                final TextView tv_near_list_other = customViews.findViewById(R.id.tv_near_list_other);
                rv_nearlist_right = customViews.findViewById(R.id.rv_nearlist_right);

                List<HomepageNearByBean> list_one = new ArrayList<>();
                String[] strings = {"附近（智能距离）", "1千米", "3千米", "5千米", "10千米"};

                for (int i = 0; i < 4; i++) {
                    HomepageNearByBean homepageNearBean = new HomepageNearByBean();
                    homepageNearBean.setId("" + i);
                    homepageNearBean.setName(strings[i]);

                    list_one.add(homepageNearBean);
                }
                sortAdapter2 = new HomepageNearBean(getActivity(), list_one, "1");
                rv_nearlist_right.setAdapter(sortAdapter2);

                tv_near_list_other.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        tv_near_list_fujin.setTextColor(getActivity().getResources().getColor(R.color.alpha_75_black));
                        tv_near_list_other.setTextColor(getActivity().getResources().getColor(R.color.alpha_violet));

                        getDistanceByCode();
                    }
                });
                tv_near_list_fujin.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        tv_near_list_fujin.setTextColor(getActivity().getResources().getColor(R.color.alpha_violet));
                        tv_near_list_other.setTextColor(getActivity().getResources().getColor(R.color.alpha_75_black));

                        List<HomepageNearByBean> list_one = new ArrayList<>();
                        String[] strings = {"附近（智能距离）", "1千米", "3千米", "5千米", "10千米"};

                        for (int i = 0; i < 4; i++) {
                            HomepageNearByBean homepageNearBean = new HomepageNearByBean();
                            homepageNearBean.setId("" + i);
                            homepageNearBean.setName(strings[i]);

                            list_one.add(homepageNearBean);
                        }
                        sortAdapter2.Clear();
                        sortAdapter2 = new HomepageNearBean(getActivity(), list_one, "1");
                        rv_nearlist_right.setAdapter(sortAdapter2);
                        sortAdapter2.notifyDataSetChanged();
                    }
                });

                break;
            /**
             * 底部销量最高
             */
            case R.id.tv_sales:
                /**
                 * 设置商家文字
                 */
                //设置附近商家
                bt_up_home.setTextColor(this.getResources().getColor(R.color.alpha_55_black));
                TextPaint tp1 = bt_up_home.getPaint();
                tp1.setFakeBoldText(false);
                bt_app_home.setTextColor(this.getResources().getColor(R.color.alpha_55_black));
                TextPaint tps1 = bt_app_home.getPaint();
                tps1.setFakeBoldText(false);
                //设置销量文字
                tv_sales.setTextColor(this.getResources().getColor(R.color.alpha_95_black));
                TextPaint tpsa01 = tv_sales.getPaint();
                tpsa01.setFakeBoldText(true);
                rb_sales.setTextColor(this.getResources().getColor(R.color.alpha_95_black));
                TextPaint tpsa11 = rb_sales.getPaint();
                tpsa11.setFakeBoldText(true);
                //设置综合排序
                tv_distance.setTextColor(this.getResources().getColor(R.color.alpha_55_black));
                TextPaint tpsd01 = tv_distance.getPaint();
                tpsd01.setFakeBoldText(false);
                tv_new_distance.setTextColor(this.getResources().getColor(R.color.alpha_55_black));
                TextPaint tpsd11 = tv_new_distance.getPaint();
                tpsd11.setFakeBoldText(false);
                //筛选
                tv_screen.setTextColor(this.getResources().getColor(R.color.alpha_55_black));
                TextPaint tpscre01 = tv_screen.getPaint();
                tpscre01.setFakeBoldText(false);
                tvScreen.setTextColor(this.getResources().getColor(R.color.alpha_55_black));
                TextPaint tpscre11 = tvScreen.getPaint();
                tpscre11.setFakeBoldText(false);


                sc_home_scroll.smoothScrollTo(0, hight1 + hight2 - home_app_bar.getHeight());

                pageIndex = 0;
                pageNumber = 1;
                input_where = 2;

                /**
                 * 获取销量数据
                 */
                getSalesData();
            case R.id.rb_sales:
                setScroll();
                break;

            case R.id.tv_home_bustling:
                intent = new Intent(getActivity(), SelectCityActivity.class);
                startActivity(intent);
                break;
            /**
             * 展示形式改变
             */
            case R.id.line_surface:
                setScroll();
            case R.id.line_uspension_surface:
                if (type) {
                    iv_surface.setImageResource(R.drawable.icon_home_recycler);
                    iv_uspension_surface.setImageResource(R.drawable.icon_home_recycler);
                    type = false;
                    nl_home_list_view.setVisibility(View.GONE);
                    gv_home_gridView.setVisibility(View.VISIBLE);
                    if (shopListHomeBean.getBody().getShopListData().size() > 0) {
                        loadData(shoplist);
                    }
                } else {
                    iv_surface.setImageResource(R.drawable.icon_home_list);
                    iv_uspension_surface.setImageResource(R.drawable.icon_home_list);
                    type = true;
                    nl_home_list_view.setVisibility(View.VISIBLE);
                    gv_home_gridView.setVisibility(View.GONE);
                    if (shopListHomeBean.getBody().getShopListData().size() > 0) {
                        loadData(shoplist);
                    }
                }
                break;
            //搜索
            case R.id.iv_home_search:
                Intent intent = new Intent(getActivity(), SearchActivity.class);
                intent.putExtra("shopCate", "1");
                startActivity(intent);
                break;
            //消息
            case R.id.img_information:
                if (SP.get(getActivity(), SpContent.isLogin, "").toString().equals("1")) {
                    Intent intent1 = new Intent(getActivity(), MessageActivity.class);
                    intent1.putExtra("newsBean", (Serializable) newsBean);
                    startActivity(intent1);
                } else {
                    T.show("请先进行登录");
                    Intent intents = new Intent(getActivity(), LoginActivity.class);
                    intents.putExtra("activite", "no");
                    startActivity(intents);
                }
                break;
            //精选服务
            case R.id.home_server_ll:
//                if (homeIndustryBean != null) {
//                    Intent intent2 = new Intent(getActivity(), SortActivity.class);
//                Intent intent2 = new Intent(getActivity(), BigMasterActivity.class);
//                    intent2.putExtra("homeIndustryBean", homeIndustryBean);
//                    intent2.putExtra("mApiEcGoodsBasicList", (Serializable) mApiEcGoodsBasicList);
//                startActivity(intent2);
//                }
                break;
            //每日新店
            case R.id.home_new_shop:
                Intent intent1 = new Intent(getActivity(), DailyNewActivity.class);
                startActivity(intent1);
                break;
            default:
                break;
        }
    }

    /**
     * 查看是否首次订单
     */
    private void getFirstOrderData() {
        HashMap<String, String> parames = new HashMap<>();
        parames.put("platformType", "1");
        parames.put("token", SP.get(getActivity(), SpContent.UserToken, "") + "");
        parames.put("flag", "0");
        HttpUtils.doPost(ACTION.ISFIRSTORDER, parames, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    /**
     * 根据区域号获取区域
     */
    private void getDistanceByCode() {
        loadingDialog.loadShow();
        HashMap<String, String> parames = new HashMap<>();
        parames.put("code", city_code + "");
        parames.put("token", SP.get(getActivity(), SpContent.UserToken, "") + "");
        HttpUtils.doPost(ACTION.SHOPLISTBYAREACODE, parames, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    /**
     * 点击附近商家(根据区域)
     */
    public void getNearPaixuData(String districtId) {
        loadingDialog.loadShow();
        HashMap<String, String> parames = new HashMap<>();
        parames.put("pageNumber", pageNumber + "");
        parames.put("contentByTitle", "");
        parames.put("shopCate", "1");
        parames.put("districtId", districtId);
        parames.put("pageSize", SpContent.pageSize);
        parames.put("token", SP.get(getActivity(), SpContent.UserToken, "") + "");
        HttpUtils.doPost(ACTION.SHOPLISTBYAREANEAR, parames, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    /**
     * 点击附近商家(根据距离)
     */
    public void getDistanPaixuData(String distance) {
        loadingDialog.loadShow();
        HashMap<String, String> parames = new HashMap<>();
        parames.put("pageNumber", pageNumber + "");
        parames.put("contentByTitle", "");
        parames.put("shopCate", "1");
        parames.put("pageSize", SpContent.pageSize);
        parames.put("geoX", SP.get(getActivity(), SpContent.UserLon, "0") + "");
        parames.put("geoY", SP.get(getActivity(), SpContent.UserLat, "0") + "");
        parames.put("distanceScope", distance);
        parames.put("cityCode", city_code);
        parames.put("token", SP.get(getActivity(), SpContent.UserToken, "") + "");
        HttpUtils.doPost(ACTION.SHOPLISTBYDISTANCE, parames, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    /**
     * 点击综合排序
     */
    private void getZonghePaixuData() {
        loadingDialog.loadShow();
        HashMap<String, String> parames = new HashMap<>();
        parames.put("pageNumber", pageNumber + "");
        parames.put("contentByTitle", "");
        parames.put("shopCate", "1");
        parames.put("cityCode", city_code);
        parames.put("pageSize", SpContent.pageSize);
        parames.put("token", SP.get(getActivity(), SpContent.UserToken, "") + "");
        HttpUtils.doPost(ACTION.SHOPLISTBYZONGHE, parames, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    /**
     * 点击评分从高到低排序
     */
    private void getScorePaixuData() {
        loadingDialog.loadShow();
        HashMap<String, String> parames = new HashMap<>();
        parames.put("pageNumber", pageNumber + "");
        parames.put("contentByTitle", "");
        parames.put("shopCate", "1");
        parames.put("cityCode", city_code);
        parames.put("pageSize", SpContent.pageSize);
        parames.put("token", SP.get(getActivity(), SpContent.UserToken, "") + "");
        HttpUtils.doPost(ACTION.SHOPLISTBYSOCORE, parames, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    /**
     * 点击浏览量从高到低排序
     */
    private void getLookPaixuData() {
        loadingDialog.loadShow();
        HashMap<String, String> parames = new HashMap<>();
        parames.put("pageNumber", pageNumber + "");
        parames.put("contentByTitle", "");
        parames.put("shopCate", "1");
        parames.put("sortKey", "desc");
        parames.put("cityCode", city_code);
        parames.put("pageSize", SpContent.pageSize);
        parames.put("token", SP.get(getActivity(), SpContent.UserToken, "") + "");
        HttpUtils.doPost(ACTION.SHOPLISTBYLOOK, parames, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    /**
     * 首页筛选条件
     */
    private void inithttp() {
        HashMap<String, String> parames = new HashMap<>();
        parames.put("token", SP.get(getActivity(), SpContent.UserToken, "") + "");
        parames.put("cityCode", city_code);
        //商家活动（筛选）
        HttpUtils.doPost(ACTION.MERCHANTACTIVITY, parames, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
        //商家特色（筛选）
        HttpUtils.doPost(ACTION.MERCHANTFEATURES, parames, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    /**
     * 获取筛选的值
     */
    private void getSelectData() {
        loadingDialog.loadShow();
        HashMap<String, String> parames = new HashMap<>();
        parames.put("token", SP.get(getActivity(), SpContent.UserToken, "") + "");
        parames.put("cityCode", city_code);
        parames.put("pageNumber", pageNumber + "");
        parames.put("pageSize", SpContent.pageSize);
        parames.put("contentByTitle", "");
        parames.put("shopCate", "1");
        parames.put("goodsCate", "");
        parames.put("queenCard", queenCard);
        parames.put("condition", cond);
        parames.put("shopActivity", "");
        parames.put("enableFlag", "1");
        parames.put("shopFeatures", "");
        parames.put("ifNew", isNew);
        parames.put("token", SP.get(getActivity(), SpContent.UserToken, "") + "");
        //商家活动（筛选）
        HttpUtils.doPost(ACTION.GETDATABYSHAIXUAN, parames, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    /**
     * 拆红包
     */
    private void ChaiRedPacket() {
        HashMap<String, String> parames = new HashMap<>();
        parames.put("token", SP.get(getActivity(), SpContent.UserToken, "") + "");
        parames.put("redPacketId", redPacketId);
        HttpUtils.doPost(ACTION.CHAIREDPACKET, parames, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    public static int compareVersion(String version1, String version2) throws Exception {

        if (version1 == null || version2 == null) {
            throw new Exception("compareVersion error:illegal params.");
        }
        String[] versionArray1 = version1.split("\\.");//注意此处为正则匹配，不能用"."；
        for (int i = 0; i < versionArray1.length; i++) { //如果位数只有一位则自动补零（防止出现一个是04，一个是5 直接以长度比较）
            if (versionArray1[i].length() == 1) {
                versionArray1[i] = "0" + versionArray1[i];
            }
        }
        String[] versionArray2 = version2.split("\\.");
        for (int i = 0; i < versionArray2.length; i++) {//如果位数只有一位则自动补零
            if (versionArray2[i].length() == 1) {
                versionArray2[i] = "0" + versionArray2[i];
            }
        }
        int idx = 0;
        int minLength = Math.min(versionArray1.length, versionArray2.length);//取最小长度值
        int diff = 0;
        while (idx < minLength
                && (diff = versionArray1[idx].length() - versionArray2[idx].length()) == 0//先比较长度
                && (diff = versionArray1[idx].compareTo(versionArray2[idx])) == 0) {//再比较字符
            ++idx;
        }
        //如果已经分出大小，则直接返回，如果未分出大小，则再比较位数，有子版本的为大；
        diff = (diff != 0) ? diff : versionArray1.length - versionArray2.length;
        return diff;
    }

    /**
     * 首单红包
     */
    private void DialogByRedOrder() {

        SP.put(getActivity(), SpContent.isFirstOrder, "1");

        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.dialog);
        LayoutInflater inflater = LayoutInflater.from(getActivity());
        View v = inflater.inflate(R.layout.homepage_red_packet_order, null);//注册
        dialog_red = builder.create();
        dialog_red.show();
        dialog_red.getWindow().setContentView(v);//自定义布局应该在这里添加，要在dialog.show()的后

        ImageView iv_home_page_dissmiss = v.findViewById(R.id.iv_home_page_dissmiss);
        iv_home_page_dissmiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog_red.dismiss();
            }
        });
        TextView tv_red_packet_regist = v.findViewById(R.id.tv_red_packet_regist);
        tv_red_packet_regist.setText(text2);
        TextView tv_red_packet_bootom = v.findViewById(R.id.tv_red_packet_bootom);
        tv_red_packet_bootom.setText("最高可得" + MD5.doubleToString(money) + "元奖励");
        TextView tv_red_packet_top = v.findViewById(R.id.tv_red_packet_top);
        tv_red_packet_top.setText(MD5.doubleToString(money));
    }

    @Override
    public void onSuccess(int action, String res) {
        switch (action) {
            /**
             * 查看是否首次订单
             */
            case ACTION.ISFIRSTORDER:

                RedPacketOrderBean redPacketOrderBean = GsonUtil.toObj(res, RedPacketOrderBean.class);
                if (redPacketOrderBean.isSuccess() && redPacketOrderBean.getErrorCode().equals("0")) {

                    if (redPacketOrderBean.getBody().getStatus().equals("2")) {

                        String heaveRecive = redPacketOrderBean.getBody().getHasReceive();

                        if (heaveRecive.equals("1")) {
                            iv_homepage_redpacket.setVisibility(View.VISIBLE);

                            /**
                             * 这里要把红包详情获取到
                             */
                            money = redPacketOrderBean.getBody().getAnsRedPacket().getMaxMoney();
                            text1 = redPacketOrderBean.getBody().getAnsRedPacket().getTemplateHeadTitle();
                            text2 = redPacketOrderBean.getBody().getAnsRedPacket().getRedPacketName();

                            if (isClick) {
                                DialogByRedOrder();
                            } else {
                                String isRedPacket = SP.get(getActivity(), SpContent.isFirstOrder, "0") + "";
                                if (isRedPacket.equals("1")) {
                                    /**
                                     * 1 是已经显示过了
                                     */
                                } else {
                                    /**
                                     * 未显示首单红包
                                     */
                                    DialogByRedOrder();
                                }

                            }

                        } else {
                            iv_homepage_redpacket.setVisibility(View.GONE);
                        }

                    } else {
                        iv_homepage_redpacket.setVisibility(View.GONE);
                    }
                } else {
//                    T.show(redPacketOrderBean.getMsg());
                }
                break;

            /**
             * 拆红包
             */
            case ACTION.CHAIREDPACKET:
                loadingDialog.cancel();
                chaiRedPacketBean = GsonUtil.toObj(res, ChaiRedPacketBean.class);
                if (chaiRedPacketBean.isSuccess() && chaiRedPacketBean.getErrorCode().equals("0")) {
                    DialogByRedPacket(getActivity(), "1", "2");
                } else {
//                    T.show(chaiRedPacketBean.getMsg());
                }
                break;
            /**
             *
             * 用户进入C端后调用红包弹层信息
             */
            case ACTION.GOINREDPACKETHOMEPAGE:

                redPacketBean = GsonUtil.toObj(res, RedPacketBean.class);

                if (redPacketBean.isSuccess() && redPacketBean.getErrorCode().equals("0")) {
                    if (redPacketBean.getBody().getStatus().equals("0")) {
                        /**
                         * 当前平台新人专享红包活动不存在
                         */
                        getFirstOrderData();
                    } else if (redPacketBean.getBody().getStatus().equals("1")) {

                        iv_homepage_redpacket.setVisibility(View.VISIBLE);

                        /**
                         * 当前平台下新人专享红包活动存在且用户没有登录)
                         */
                        String isRedPacket = SP.get(getActivity(), SpContent.isRedPacket, "0") + "";
                        if (isRedPacket.equals("1")) {
                            /**
                             * 1 是已经显示过了
                             */
                        } else {
                            /**
                             * 未显示新人专用红包
                             */
                            DialogByRedPacket(getActivity(), "0", "0");
                        }
                    } else if (redPacketBean.getBody().getStatus().equals("-1")) {
                        /**
                         * 不是新用户
                         */
                        /**
                         * 调用首单接口
                         */
                        getFirstOrderData();
                    } else if (redPacketBean.getBody().getStatus().equals("2")) {

                        iv_homepage_redpacket.setVisibility(View.VISIBLE);

                        /**
                         * 当前平台下新人专享红包活动存在且用户已经登录    新用户   需要再判断是否领取
                         */

                        // hasReceive =  1 时显示拆字红包    4 时显示拆后的金额红包    3无权拆红包

                        if (redPacketBean.getBody().getHasReceive().equals("1") || redPacketBean.getBody().getHasReceive().equals("3")) {
                            DialogByRedPacket(getActivity(), "1", "1");
                        } else if (redPacketBean.getBody().getHasReceive().equals("2")) {
                            /**
                             * 调用首单接口
                             */
                            getFirstOrderData();
                        } else if (redPacketBean.getBody().getHasReceive().equals("4")) {
                            iv_homepage_redpacket.setVisibility(View.VISIBLE);
                            /**
                             * 弹出拆的金额情况
                             */
                            DialogByRedPacket(getActivity(), "1", "2");
                        }
                    }
                } else {
//                    T.show(redPacketBean.getMsg());
                }
                break;
            case ACTION.GETHUIYUANSTAUTE:
                QueenCardStatueBean queenCardStatueBean = GsonUtil.toObj(res, QueenCardStatueBean.class);
                if (queenCardStatueBean.isSuccess() && queenCardStatueBean.getErrorCode().equals("0")) {
                    if (queenCardStatueBean.getBody().getMemberStatus().equals("not")) {
                        SP.put(getActivity(), SpContent.IsQueenVip, "0");
                    } else {
                        SP.put(getActivity(), SpContent.IsQueenVip, "1");
                    }
                } else {
                    SP.put(getActivity(), SpContent.IsQueenVip, "0");
                }
                break;
            /**
             * 获取筛选的值
             */
            case ACTION.GETDATABYSHAIXUAN:
                loadingDialog.cancel();
                homeShopBySalesBean = GsonUtil.toObj(res, ShopListHomeBean.class);
                if (homeShopBySalesBean.isSuccess()) {

                    if (homeShopBySalesBean.getBody().getShopListData().size() > 0) {
                        li_home_bottom.setVisibility(View.VISIBLE);
                        shop_list_null.setVisibility(View.GONE);
                        pageSum = homeShopBySalesBean.getBody().getShopListData().size();
                        loadMoreData(homeShopBySalesBean.getBody().getShopListData());
                    } else {

                        if (pageIndex == 0) {
                            li_home_bottom.setVisibility(View.GONE);
                            shop_list_null.setVisibility(View.VISIBLE);
                        } else {
                            li_home_bottom.setVisibility(View.VISIBLE);
                            shop_list_null.setVisibility(View.GONE);
                        }

                        DisplayMetrics dm = getResources().getDisplayMetrics();
                        int heigth = dm.heightPixels;
                        RelativeLayout.LayoutParams gallery_lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, heigth);
                        shop_list_null.setLayoutParams(gallery_lp);
                        gridViewAdapter.Clear();
                        homeListViewAdapter.Clear();
                    }
                } else {
//                    T.show(homeShopBySalesBean.getMsg());
                }
                break;
            /**
             * 更新版本
             */
            case ACTION.CHECKNEWAPK:
                String versionName = "";
                CheckApkBean checkApkBean = GsonUtil.toObj(res, CheckApkBean.class);
                if (checkApkBean.isSuccess()) {

                    apk_code = checkApkBean.getBody().getAnsAndroidVersion().getVersionNo();
                    apk_url = checkApkBean.getBody().getAnsAndroidVersion().getDownloadUrl();
                    try {
                        versionName = getActivity().getPackageManager().getPackageInfo(
                                getActivity().getPackageName(), 0).versionName;
                    } catch (PackageManager.NameNotFoundException e) {
                        e.printStackTrace();
                    }
                    try {
                        if (compareVersion(apk_code, versionName) > 0) {
                            showUpdaloadDialog(apk_code, apk_url, checkApkBean.getBody().getAnsAndroidVersion().getForceUpdate());
                        } else {
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
//                    T.show(checkApkBean.getMsg());
                }
                break;
            /**
             * 根据距离排序
             */
            case ACTION.SHOPLISTBYDISTANCE:
                loadingDialog.cancel();
                homeShopBySalesBean = GsonUtil.toObj(res, ShopListHomeBean.class);
                if (homeShopBySalesBean.isSuccess()) {

                    if (homeShopBySalesBean.getBody().getShopListData().size() > 0) {
                        li_home_bottom.setVisibility(View.VISIBLE);

                        shop_list_null.setVisibility(View.GONE);
                        pageSum = homeShopBySalesBean.getBody().getShopListData().size();
                        loadMoreData(homeShopBySalesBean.getBody().getShopListData());
                    } else {
                        if (pageIndex == 0) {
                            li_home_bottom.setVisibility(View.GONE);
                            shop_list_null.setVisibility(View.VISIBLE);
                        } else {
                            li_home_bottom.setVisibility(View.VISIBLE);
                            shop_list_null.setVisibility(View.GONE);
                        }

                        DisplayMetrics dm = getResources().getDisplayMetrics();
                        int heigth = dm.heightPixels;
                        RelativeLayout.LayoutParams gallery_lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, heigth);
                        shop_list_null.setLayoutParams(gallery_lp);
                        gridViewAdapter.Clear();
                        homeListViewAdapter.Clear();
                    }
                } else {
//                    T.show(homeShopBySalesBean.getMsg());
                }
                break;
            /**
             * 根据区域选择
             *
             */
            case ACTION.SHOPLISTBYAREANEAR:
                loadingDialog.cancel();
                homeShopBySalesBean = GsonUtil.toObj(res, ShopListHomeBean.class);
                if (homeShopBySalesBean.isSuccess()) {
                    if (homeShopBySalesBean.getBody().getShopListData().size() > 0) {
                        pageSum = homeShopBySalesBean.getBody().getShopListData().size();
                        li_home_bottom.setVisibility(View.VISIBLE);
                        shop_list_null.setVisibility(View.GONE);
                        loadMoreData(homeShopBySalesBean.getBody().getShopListData());
                    } else {
                        if (pageIndex == 0) {
                            li_home_bottom.setVisibility(View.GONE);
                            shop_list_null.setVisibility(View.VISIBLE);
                        } else {
                            li_home_bottom.setVisibility(View.VISIBLE);
                            shop_list_null.setVisibility(View.GONE);
                        }

                        DisplayMetrics dm = getResources().getDisplayMetrics();
                        int heigth = dm.heightPixels;
                        RelativeLayout.LayoutParams gallery_lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, heigth);
                        shop_list_null.setLayoutParams(gallery_lp);
                        gridViewAdapter.Clear();
                        homeListViewAdapter.Clear();
                    }
                } else {
//                    T.show(homeShopBySalesBean.getMsg());
                }
                break;
            /**
             * 根据区域code获取区域
             */
            case ACTION.SHOPLISTBYAREACODE:
                loadingDialog.cancel();
                final Homepagebean homepagebean = GsonUtil.toObj(res, Homepagebean.class);
                if (homepagebean.isSuccess()) {
                    DistrictListData = new ArrayList<>();
                    DistrictListData = homepagebean.getBody().getDistrictListData();
                    home_string.clear();
                    for (int i = 0; i < DistrictListData.size(); i++) {
                        HomepageNearByBean homepageNearBean = new HomepageNearByBean();
                        homepageNearBean.setId(DistrictListData.get(i).getArea().getId());
                        homepageNearBean.setName(DistrictListData.get(i).getArea().getName());
                        home_string.add(homepageNearBean);
                    }
                    sortAdapter2.Clear();
                    sortAdapter2 = new HomepageNearBean(getActivity(), home_string, "2");
                    rv_nearlist_right.setAdapter(sortAdapter2);
                    sortAdapter2.notifyDataSetChanged();
                } else {
//                    T.show(homepagebean.getMsg());

                }
                break;
            /**
             * 点击评分从高到低排序
             */
            case ACTION.SHOPLISTBYSOCORE:
                loadingDialog.cancel();
                homeShopBySalesBean = GsonUtil.toObj(res, ShopListHomeBean.class);
                if (homeShopBySalesBean.isSuccess()) {
                    if (homeShopBySalesBean.getBody().getShopListData().size() > 0) {
                        pageSum = homeShopBySalesBean.getBody().getShopListData().size();
                        li_home_bottom.setVisibility(View.VISIBLE);
                        shop_list_null.setVisibility(View.GONE);
                        loadMoreData(homeShopBySalesBean.getBody().getShopListData());
                    } else {
                        DisplayMetrics dm = getResources().getDisplayMetrics();
                        int heigth = dm.heightPixels;
                        if (pageIndex == 0) {
                            shop_list_null.setVisibility(View.VISIBLE);
                            li_home_bottom.setVisibility(View.GONE);
                        } else {
                            shop_list_null.setVisibility(View.GONE);
                            li_home_bottom.setVisibility(View.VISIBLE);
                        }

                        RelativeLayout.LayoutParams gallery_lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, heigth);
                        shop_list_null.setLayoutParams(gallery_lp);
                        gridViewAdapter.Clear();
                        homeListViewAdapter.Clear();
                    }
                } else {
//                    T.show(homeShopBySalesBean.getMsg());
                }
                break;
            /**
             * 点击浏览量从高到低排序
             */
            case ACTION.SHOPLISTBYLOOK:
                loadingDialog.cancel();
                homeShopBySalesBean = GsonUtil.toObj(res, ShopListHomeBean.class);
                if (homeShopBySalesBean.isSuccess()) {
                    if (homeShopBySalesBean.getBody().getShopListData().size() > 0) {
                        pageSum = homeShopBySalesBean.getBody().getShopListData().size();
                        li_home_bottom.setVisibility(View.VISIBLE);
                        shop_list_null.setVisibility(View.GONE);
                        loadMoreData(homeShopBySalesBean.getBody().getShopListData());
                    } else {
                        DisplayMetrics dm = getResources().getDisplayMetrics();
                        int heigth = dm.heightPixels;
                        if (pageIndex == 0) {
                            shop_list_null.setVisibility(View.VISIBLE);
                            li_home_bottom.setVisibility(View.GONE);
                        } else {
                            shop_list_null.setVisibility(View.GONE);
                            li_home_bottom.setVisibility(View.VISIBLE);
                        }

                        RelativeLayout.LayoutParams gallery_lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, heigth);
                        shop_list_null.setLayoutParams(gallery_lp);
                        gridViewAdapter.Clear();
                        homeListViewAdapter.Clear();
                    }
                } else {
//                    T.show(homeShopBySalesBean.getMsg());
                }
                break;
            /**
             * 点击获取综合排序列表
             */
            case ACTION.SHOPLISTBYZONGHE:
                loadingDialog.cancel();
                homeShopBySalesBean = GsonUtil.toObj(res, ShopListHomeBean.class);
                if (homeShopBySalesBean.isSuccess()) {
                    if (homeShopBySalesBean.getBody().getShopListData().size() > 0) {
                        pageSum = homeShopBySalesBean.getBody().getShopListData().size();
                        li_home_bottom.setVisibility(View.VISIBLE);
                        shop_list_null.setVisibility(View.GONE);
                        loadMoreData(homeShopBySalesBean.getBody().getShopListData());
                    } else {
                        DisplayMetrics dm = getResources().getDisplayMetrics();
                        int heigth = dm.heightPixels;
                        if (pageIndex == 0) {
                            shop_list_null.setVisibility(View.VISIBLE);
                            li_home_bottom.setVisibility(View.GONE);
                        } else {
                            shop_list_null.setVisibility(View.GONE);
                            li_home_bottom.setVisibility(View.VISIBLE);
                        }

                        RelativeLayout.LayoutParams gallery_lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, heigth);
                        shop_list_null.setLayoutParams(gallery_lp);
                        gridViewAdapter.Clear();
                        homeListViewAdapter.Clear();
                    }
                } else {
//                    T.show(homeShopBySalesBean.getMsg());
                }
                break;
            /**
             * 销量最高
             */
            case ACTION.SHOPBYSALES:
                loadingDialog.cancel();
                homeShopBySalesBean = GsonUtil.toObj(res, ShopListHomeBean.class);
                if (homeShopBySalesBean.isSuccess()) {
                    if (homeShopBySalesBean.getBody().getShopListData().size() > 0) {
                        pageSum = homeShopBySalesBean.getBody().getShopListData().size();
                        li_home_bottom.setVisibility(View.VISIBLE);
                        shop_list_null.setVisibility(View.GONE);
                        loadMoreData(homeShopBySalesBean.getBody().getShopListData());
                    } else {
                        if (pageIndex == 0) {
                            li_home_bottom.setVisibility(View.GONE);
                            shop_list_null.setVisibility(View.VISIBLE);
                        } else {
                            li_home_bottom.setVisibility(View.VISIBLE);
                            shop_list_null.setVisibility(View.GONE);
                        }

                        DisplayMetrics dm = getResources().getDisplayMetrics();
                        int heigth = dm.heightPixels;
                        RelativeLayout.LayoutParams gallery_lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, heigth);
                        shop_list_null.setLayoutParams(gallery_lp);
                        gridViewAdapter.Clear();
                        homeListViewAdapter.Clear();
                    }
                } else {
//                    T.show(homeShopBySalesBean.getMsg());
                }
                break;
            /**
             * 底部获取综合数据
             */
            case ACTION.SHOPLIST:
                loadingDialog.cancel();
                shopListHomeBean = GsonUtil.toObj(res, ShopListHomeBean.class);
                if (shopListHomeBean.isSuccess()) {
                    if (shopListHomeBean.getBody().getShopListData().size() > 0) {
                        li_home_bottom.setVisibility(View.GONE);
                        pageSum = shopListHomeBean.getBody().getShopListData().size();
                        loadMoreData(shopListHomeBean.getBody().getShopListData());
                    } else {
                        if (pageIndex == 0) {
                            li_home_bottom.setVisibility(View.VISIBLE);
                        } else {
                            li_home_bottom.setVisibility(View.GONE);
                        }

                    }
                } else {
//                    T.show(shopListHomeBean.getMsg());
                }
                break;
            /**
             * 获取消息类型，并判断有无新消息
             */
            case ACTION.GETNEWNEWS:
                newsBean = GsonUtil.toObj(res, NewsBean.class);
                if (newsBean.isSuccess()) {
                    for (int i = 0; i < newsBean.getBody().getMessTypeList().size(); i++) {
                        if (newsBean.getBody().getMessTypeList().get(i).getValue().equals("1") || newsBean.getBody().getMessTypeList().get(i).getValue().equals("3") || newsBean.getBody().getMessTypeList().get(i).getValue().equals("5")) {

                            if (newsBean.getBody().getMessTypeList().get(i).getMsgContent().equals("")) {
                            } else {
                                QBadgeView badgeView = new QBadgeView(getActivity());
                                badgeView.bindTarget(img_information);
                                badgeView.setBadgeTextSize(6, false);
                                badgeView.setBadgeText("");
                                badgeView.setBadgeTextColor(this.getResources().getColor(R.color.white));
                                badgeView.setBadgeGravity(Gravity.END | Gravity.TOP);
                                badgeView.setBadgeBackgroundColor(this.getResources().getColor(R.color.colorPri));
                                badgeView.setOnDragStateChangedListener(new Badge.OnDragStateChangedListener() {
                                    @Override
                                    public void onDragStateChanged(int dragState, Badge badge, View targetView) {
                                    }
                                });
                            }
                        }
                    }
                } else {
//                    T.show(newsBean.getMsg());
                }
                break;
            //首页的行业分类
            case ACTION.INDUSTRY:
                homeIndustryBean = GsonUtil.toObj(res, HomeIndustryBean.class);
                if (homeIndustryBean.isSuccess() && homeIndustryBean.getErrorCode().equals("0")) {

                    if (homeIndustryBean.getBody() == null) {
                    } else {
                        if (mNewTopAdapter == null) {
                            mNewTopAdapter = new NewTopAdapter(getActivity(), homeIndustryBean.getBody().getCategoryListData());
                            mLiHomeGv.setAdapter(mNewTopAdapter);
                        } else {
                            mNewTopAdapter.notifyDataSetChanged();
                        }
                        mLiHomeGv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                                Intent intent = new Intent(getActivity(), EstheticsActivity.class);
//                                intent.putExtra("categoryId", homeIndustryBean.getBody().getCategoryListData().get(i).getEcCategory().getId());
//                                intent.putExtra("shop_name", homeIndustryBean.getBody().getCategoryListData().get(i).getEcCategory().getTabName());
//                                intent.putExtra("cpCate", "1");
//                                startActivity(intent);

                                Intent intent = new Intent(getActivity(), RankListNewActivity.class);
                                intent.putExtra("categoryId", homeIndustryBean.getBody().getCategoryListData().get(i).getEcCategory().getId());
                                intent.putExtra("cateName", homeIndustryBean.getBody().getCategoryListData().get(i).getEcCategory().getTabName());
                                intent.putExtra("tabPic", homeIndustryBean.getBody().getCategoryListData().get(i).getEcCategory().getCover());
                                startActivity(intent);
                            }
                        });
                    }
                } else {
//                    T.show(homeIndustryBean.getMsg());
                }
                break;
            /**
             * 获取首页Banner
             */
            case ACTION.PAGEBANNER:
                PageBannerBean bannerBean = GsonUtil.toObj(res, PageBannerBean.class);
                if (bannerBean.isSuccess()) {
                    bannerList_2.clear();
                    bannerList = bannerBean.getBody().getBannerListData();
                    List<String> images = new ArrayList<>();
                    List<String> imagesTwo = new ArrayList<>();
                    //                 List<String> bannerName = new ArrayList<>();
                    final List<String> bannerDetails = new ArrayList<>();
                    for (int i = 0; i < bannerList.size(); i++) {

                        if (bannerList.get(i).getPageLocation().equals("1")) {
                            images.add(bannerList.get(i).getBannerLogo());
                            banner.setImageLoader(new GlideImageLoader());
                            banner.setBannerStyle(BannerConfig.NOT_INDICATOR);
                            banner.setImages(images);
                            banner.setViewPagerIsScroll(true);
                            banner.setFocusable(true);
                            banner.requestFocus();
                            banner.start();
                            initBannerOnClick(banner);
                        } else if (bannerList.get(i).getPageLocation().equals("2")) {
                            //女王活动
                            bannerDetails.add(bannerList.get(i).getBannerDetails());
                            bannerDetails.add(bannerList.get(i).getId());
                            bannerList_2.add(bannerList.get(i));
                            List<SuggestionBean> suggestionBeanList = new ArrayList<>();
                            SuggestionBean bean = null;
                            for (int k = 0; k < bannerList_2.size(); k++) {
                                if (k % 2 == 0) {//偶数
                                    bean = new SuggestionBean();
                                    bean.setImg(bannerList_2.get(k).getBannerLogo());
                                    bean.setTitle(bannerList_2.get(k).getBannerName());
                                    bean.setTap1(bannerList_2.get(k).getBannerLabel());
                                } else {//奇数
//                                    if (bean == null) {
//                                        bean = new SuggestionBean();
//                                        bean.setImg(bannerList.get(k).getBannerLogo());
//                                    }
                                    bean.setTap2(bannerList_2.get(k).getBannerLabel());
                                    bean.setContent(bannerList_2.get(k).getBannerName());
                                    suggestionBeanList.add(bean);
                                }
                            }
                            //设置消息滚动
                            ComplexViewMF factory = new ComplexViewMF(getActivity());
                            factory.setData(suggestionBeanList);
                            mv_home_marqueeView.setMarqueeFactory(factory);
                            mv_home_marqueeView.startFlipping();
                            mv_home_marqueeView.setOnItemClickListener(new OnItemClickListener() {
                                @Override
                                public void onItemClickListener(View view, Object o, int i) {
                                    Intent intent = new Intent(getActivity(), QueenHeadlineActivity.class);
                                    intent.putParcelableArrayListExtra("bannerList", (ArrayList<? extends Parcelable>) bannerList_2);
                                    getActivity().startActivity(intent);
                                }
                            });
                        } else if (bannerList.get(i).getPageLocation().equals("3")) {
                            initShowSort(i, 1, ivNewuserprg);
                            initShowSort(i, 2, ivSpecialoffer);//ivSpecialoffer
                            initShowSort(i, 3, ivGoodshop);//iv_home_goodshop
                            initShowSort(i, 4, ivFreetrial);//iv_home_freetrial

                            initOnClick(i, 1, ivNewuserprg);
                            initOnClick(i, 2, ivSpecialoffer);
                            initOnClick(i, 3, ivGoodshop);
                            initOnClick(i, 4, ivFreetrial);
                        } else if (bannerList.get(i).getPageLocation().equals("4")) {


                            /**
                             * 这里是设置推荐活动的高度
                             */
                            LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) ivQueenShop.getLayoutParams();
                            //获取当前控件的布局对象
                            params.weight = TUtil.getScreenWidth(getActivity());//设置当前控件布局的高度
                            params.height = TUtil.getScreenWidth(getActivity()) / 19 * 5;//设置当前控件布局的高度
                            ivQueenShop.setLayoutParams(params);//将设置好的布局参数应用到控件中

                            initShowSort(i, 1, ivItemShop);
                            initShowSort(i, 2, ivConvert);
                            initShowSort(i, 3, ivPrize);
                            initShowSort(i, 4, ivQueenShop);
                            initOnClick(i, 1, ivItemShop);
                            initOnClick(i, 2, ivConvert);
                            initOnClick(i, 3, ivPrize);
                            initOnClick(i, 4, ivQueenShop);
                        } else if (bannerList.get(i).getPageLocation().equals("5")) {

                            /**
                             * 这里是设置Banner高度
                             */
                            LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) banner_middle.getLayoutParams();
                            //获取当前控件的布局对象
                            params.weight = TUtil.getScreenWidth(getActivity());
                            params.height = TUtil.getScreenWidth(getActivity()) / 3;//设置当前控件布局的高度
                            banner_middle.setLayoutParams(params);//将设置好的布局参数应用到控件中

                            HomeBannerMiddleBean homeBannerMiddleBean = new HomeBannerMiddleBean();
                            homeBannerMiddleBean.setBannerId(bannerList.get(i).getId());
                            homeBannerMiddleBean.setBannerStyle(bannerList.get(i).getBannerStyle());
                            homeBannerMiddleBean.setBannerTitle(bannerList.get(i).getBannerName());
                            homeBannerMiddleBean.setWeburl(bannerList.get(i).getBannerUrl());
                            bannerMiddleBeanList.add(homeBannerMiddleBean);
                            imagesTwo.add(bannerList.get(i).getBannerLogo());
                            banner_middle.setBannerStyle(BannerConfig.NOT_INDICATOR);
                            banner_middle.setImageLoader(new GlideImageLoader());
                            banner_middle.setImages(imagesTwo);
                            banner_middle.setViewPagerIsScroll(true);
                            banner_middle.setFocusable(true);
                            banner_middle.requestFocus();
                            banner_middle.start();
                            banner_middle.setOnBannerListener(new OnBannerListener() {
                                @Override
                                public void OnBannerClick(int position) {
                                    Intent intent = new Intent(getActivity(), HomeAdvertisingActivity.class);
                                    intent.putExtra("bannerId", bannerMiddleBeanList.get(position).getBannerId());
                                    intent.putExtra("bannerStyle", bannerMiddleBeanList.get(position).getBannerStyle());
                                    intent.putExtra("weburl", bannerMiddleBeanList.get(position).getWeburl());
                                    intent.putExtra("bannerTitle", bannerMiddleBeanList.get(position).getBannerTitle());
                                    getActivity().startActivity(intent);
                                }
                            });
                        }
                    }

                    initListeners();
                } else {
//                    T.show(bannerBean.getMsg());
                }
                break;
            //商家活动（筛选）
            case ACTION.MERCHANTACTIVITY:
                MerchantsBean merchantsBean = GsonUtil.toObj(res, MerchantsBean.class);
                if (merchantsBean.isSuccess()) {
                    merchantsList = merchantsBean.getBody().getActivityKeysListData();
                } else {
//                    T.show(merchantsBean.getMsg());
                }
                break;
            //商家特色（筛选）
            case ACTION.MERCHANTFEATURES:
                PreferentialBean preferentialBean = GsonUtil.toObj(res, PreferentialBean.class);
                if (preferentialBean.isSuccess()) {
                    preferentialList = preferentialBean.getBody().getFeatureKeysListData();
                } else {
//                    T.show(preferentialBean.getMsg());
                }

                queenCard = "";
                cond = "";

                View customView = View.inflate(getActivity(), R.layout.pop_screening, null);
                final PopWindowHome popWindowHome = new PopWindowHome.Builder(getActivity())
                        .setStyle(PopWindowHome.PopWindowStyle.PopDown)
                        .setView(customView)
                        .show(li_home_screen);//show里面的内容是显示在空间下方的控件
                TextView tv_cancel = customView.findViewById(R.id.tv_cancel);
                tv_cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        popWindowHome.dismiss();
                    }
                });
                TextView tv_submit = customView.findViewById(R.id.tv_submit);
                tv_submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        popWindowHome.dismiss();

                        /**
                         * 已选择情况
                         */
                        input_where = 4;
                        pageIndex = 0;
                        pageNumber = 1;
                        getSelectData();
                    }
                });
                final TextView tv_home_queen = customView.findViewById(R.id.tv_home_queen);

                final TextView tv_home_new = customView.findViewById(R.id.tv_home_new);
                tv_home_queen.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        tv_home_queen.setBackground(getActivity().getDrawable(R.drawable.button_home_tese_select));
                        tv_home_queen.setTextColor(getActivity().getResources().getColor(R.color.white));

                        tv_home_new.setBackground(getActivity().getDrawable(R.drawable.button_home_tese));
                        tv_home_new.setTextColor(getActivity().getResources().getColor(R.color.alpha_65_black));
                        queenCard = "1";
                        isNew = "0";
                    }
                });

                tv_home_new.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        tv_home_queen.setBackground(getActivity().getDrawable(R.drawable.button_home_tese));
                        tv_home_queen.setTextColor(getActivity().getResources().getColor(R.color.alpha_65_black));

                        tv_home_new.setBackground(getActivity().getDrawable(R.drawable.button_home_tese_select));
                        tv_home_new.setTextColor(getActivity().getResources().getColor(R.color.white));
                        queenCard = "0";
                        isNew = "1";
                    }
                });

                final TextView tv_home_first = customView.findViewById(R.id.tv_home_first);
                final TextView tv_home_second = customView.findViewById(R.id.tv_home_second);
                final TextView tv_home_third = customView.findViewById(R.id.tv_home_third);
                final TextView tv_home_forth = customView.findViewById(R.id.tv_home_forth);

                tv_home_first.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        cond = "1";
                        tv_home_first.setBackground(getActivity().getDrawable(R.drawable.button_home_tese_select));
                        tv_home_first.setTextColor(getActivity().getResources().getColor(R.color.white));
                        tv_home_second.setBackground(getActivity().getDrawable(R.drawable.button_home_tese));
                        tv_home_second.setTextColor(getActivity().getResources().getColor(R.color.alpha_65_black));
                        tv_home_third.setBackground(getActivity().getDrawable(R.drawable.button_home_tese));
                        tv_home_third.setTextColor(getActivity().getResources().getColor(R.color.alpha_65_black));

                        tv_home_forth.setBackground(getActivity().getDrawable(R.drawable.button_home_tese));
                        tv_home_forth.setTextColor(getActivity().getResources().getColor(R.color.alpha_65_black));
                    }
                });

                tv_home_second.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        cond = "2";
                        tv_home_second.setBackground(getActivity().getDrawable(R.drawable.button_home_tese_select));
                        tv_home_second.setTextColor(getActivity().getResources().getColor(R.color.white));

                        tv_home_first.setBackground(getActivity().getDrawable(R.drawable.button_home_tese));
                        tv_home_first.setTextColor(getActivity().getResources().getColor(R.color.alpha_65_black));

                        tv_home_third.setBackground(getActivity().getDrawable(R.drawable.button_home_tese));
                        tv_home_third.setTextColor(getActivity().getResources().getColor(R.color.alpha_65_black));

                        tv_home_forth.setBackground(getActivity().getDrawable(R.drawable.button_home_tese));
                        tv_home_forth.setTextColor(getActivity().getResources().getColor(R.color.alpha_65_black));
                    }
                });

                tv_home_third.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        tv_home_first.setBackground(getActivity().getDrawable(R.drawable.button_home_tese));
                        tv_home_first.setTextColor(getActivity().getResources().getColor(R.color.alpha_65_black));

                        tv_home_second.setBackground(getActivity().getDrawable(R.drawable.button_home_tese));
                        tv_home_second.setTextColor(getActivity().getResources().getColor(R.color.alpha_65_black));

                        tv_home_third.setBackground(getActivity().getDrawable(R.drawable.button_home_tese_select));
                        tv_home_third.setTextColor(getActivity().getResources().getColor(R.color.white));

                        tv_home_forth.setBackground(getActivity().getDrawable(R.drawable.button_home_tese));
                        tv_home_forth.setTextColor(getActivity().getResources().getColor(R.color.alpha_65_black));
                        cond = "3";

                    }
                });
                tv_home_forth.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        tv_home_first.setBackground(getActivity().getDrawable(R.drawable.button_home_tese));
                        tv_home_first.setTextColor(getActivity().getResources().getColor(R.color.alpha_65_black));

                        tv_home_second.setBackground(getActivity().getDrawable(R.drawable.button_home_tese));
                        tv_home_second.setTextColor(getActivity().getResources().getColor(R.color.alpha_65_black));

                        tv_home_third.setBackground(getActivity().getDrawable(R.drawable.button_home_tese));
                        tv_home_third.setTextColor(getActivity().getResources().getColor(R.color.alpha_65_black));

                        tv_home_forth.setBackground(getActivity().getDrawable(R.drawable.button_home_tese_select));
                        tv_home_forth.setTextColor(getActivity().getResources().getColor(R.color.white));
                        cond = "4";

                    }
                });
                break;
            //每日新店
            case ACTION.NEWSHOPlIST:
                HomeNewShopBean newShopBean = GsonUtil.toObj(res, HomeNewShopBean.class);
                if (newShopBean.isSuccess()) {
                    final List<HomeNewShopBean.BodyBean.NewShopListBean> shopList = newShopBean.getBody().getNewShopList();
                    HomeNewShopAdapter shopAdapter = new HomeNewShopAdapter(R.layout.re_home_recommend, shopList);
                    rv_home_new_every.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
                    rv_home_new_every.setAdapter(shopAdapter);
                    shopAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                        @Override
                        public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                            Intent intent = new Intent(getActivity(), WorkRoomDetailActivity.class);
                            intent.putExtra("shopName", shopList.get(position).getAnsShopBasic().getShopName());
                            intent.putExtra("shopId", shopList.get(position).getAnsShopBasic().getId());
                            intent.putExtra("cpCate", "1");
                            startActivity(intent);
                        }
                    });
                } else {
//                    T.show(newShopBean.getMsg());
                }
                break;
            //精选服务
            case ACTION.COMMENDGOODS:
                CommendGoodBean goodBean = GsonUtil.toObj(res, CommendGoodBean.class);
                if (goodBean.isSuccess()) {
                    mApiEcGoodsBasicList = goodBean.getBody().getApiEcGoodsBasicList();
                    CommendGoodBean.BodyBean.ApiEcGoodsBasicListBean bean = new CommendGoodBean.BodyBean.ApiEcGoodsBasicListBean();
                    mApiEcGoodsBasicList.add(bean);
                    //设置精选服务的适配器
                    HomeServerAdapter homeServerAdapter = new HomeServerAdapter(getActivity(), mApiEcGoodsBasicList);
                    mHomeServerGv.setAdapter(homeServerAdapter);
                    mHomeServerGv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                            if (i != mApiEcGoodsBasicList.size() - 1) {
                                Intent intent = new Intent(getActivity(), FullActivity.class);
                                intent.putExtra("goodsId", mApiEcGoodsBasicList.get(i).getEcGoodsBasic().getId());
                                intent.putExtra("shopId", mApiEcGoodsBasicList.get(i).getEcGoodsBasic().getShopId());
                                intent.putExtra("shopName", mApiEcGoodsBasicList.get(i).getEcGoodsBasic().getShopName());
                                intent.putExtra("shopLogo", mApiEcGoodsBasicList.get(i).getEcGoodsBasic().getGoodsThumb());
                                intent.putExtra("number", "");
                                startActivity(intent);
                            } else {
                                if (homeIndustryBean != null) {
                                    Intent intent2 = new Intent(getActivity(), SortActivity.class);
                                    intent2.putExtra("homeIndustryBean", homeIndustryBean);
                                    startActivity(intent2);
                                }
                            }
                        }
                    });
                } else {
//                    T.show(goodBean.getMsg());
                }
                break;
            default:
                break;
        }
    }

    /**
     * 顶部Banner点击
     *
     * @param banner
     */
    private void initBannerOnClick(Banner banner) {
        banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {


                if (bannerList.get(position).getBannerStyle().equals("1")) {
                    /**
                     * 富文本
                     */
                    Intent intent = new Intent(getActivity(), HomeAdvertisingActivity.class);
                    intent.putExtra("bannerId", bannerList.get(position).getId());
                    intent.putExtra("bannerStyle", bannerList.get(position).getBannerStyle());
                    intent.putExtra("weburl", bannerList.get(position).getBannerUrl());
                    intent.putExtra("bannerLogo", bannerList.get(position).getBannerLogo());
                    intent.putExtra("bannerTitle", bannerList.get(position).getBannerName());

                    getActivity().startActivity(intent);
                } else if (bannerList.get(position).getBannerStyle().equals("3")) {
                    /**
                     * 本地模块
                     */

                    if (bannerList.get(position).getBannerUrl().equals("inviting_users")) {
                        if (SP.get(getActivity(), SpContent.isLogin, "0").equals("1")) {
                            Intent intent = new Intent(getActivity(), MineGiftActivity.class);
                            startActivity(intent);
                        } else {
                            Intent intent = new Intent(getActivity(), LoginActivity.class);
                            intent.putExtra("activite", "no");
                            startActivity(intent);
                        }
                    } else if (bannerList.get(position).getBannerUrl().equals("collage")) {
                        startActivity(new Intent(getContext(), HomeFightaloneActivity.class));
                    } else if (bannerList.get(position).getBannerUrl().equals("specialOfferGoods")) {
                        startActivity(new Intent(getContext(), SpecialPriceActivity.class));
                    } else if (bannerList.get(position).getBannerUrl().equals("midAutumnFestival-gpActivity")) {
                        startActivity(new Intent(getContext(), ActivityByHolidayActivity.class));
                    } else if (bannerList.get(position).getBannerUrl().equals("ans_school")) {
                        startActivity(new Intent(getContext(), BigClassroomActivity.class));
                    } else if (bannerList.get(position).getBannerUrl().equals("second_kill")) {
                        startActivity(new Intent(getContext(), SecKillActivity.class));
                    }

                } else {
                    /**
                     * 2代表获取的是URL    4代表的是店铺   5代表的是推荐商品
                     */
                    Intent intent = new Intent(getActivity(), HomeAdvertisingActivity.class);
                    intent.putExtra("bannerId", bannerList.get(position).getId());
                    intent.putExtra("bannerStyle", bannerList.get(position).getBannerStyle());
                    intent.putExtra("weburl", bannerList.get(position).getBannerUrl());
                    intent.putExtra("bannerLogo", bannerList.get(position).getBannerLogo());
                    intent.putExtra("bannerTitle", bannerList.get(position).getBannerName());

                    getActivity().startActivity(intent);
                }
            }
        });
    }

    private void initOnClick(final int i, final int sort, ImageView imageView) {
        if (bannerList.get(i).getShowSort() == sort) {
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    /**
                     * 跳转到本地
                     */
                    if (bannerList.get(i).getBannerStyle().equals("3")) {

                        if (bannerList.get(i).getBannerUrl().equals("inviting_users")) {
                            if (SP.get(getActivity(), SpContent.isLogin, "0").equals("1")) {
                                Intent intent = new Intent(getActivity(), MineGiftActivity.class);
                                startActivity(intent);
                            } else {
                                Intent intent = new Intent(getActivity(), LoginActivity.class);
                                intent.putExtra("activite", "no");
                                startActivity(intent);
                            }
                        } else if (bannerList.get(i).getBannerUrl().equals("collage")) {
                            startActivity(new Intent(getContext(), HomeFightaloneActivity.class));
                        } else if (bannerList.get(i).getBannerUrl().equals("specialOfferGoods")) {
                            startActivity(new Intent(getContext(), SpecialPriceActivity.class));
                        } else if (bannerList.get(i).getBannerUrl().equals("midAutumnFestival-gpActivity")) {
                            startActivity(new Intent(getContext(), ActivityByHolidayActivity.class));
                        } else if (bannerList.get(i).getBannerUrl().equals("ans_school")) {
                            startActivity(new Intent(getContext(), BigClassroomActivity.class));
                        } else if (bannerList.get(i).getBannerUrl().equals("second_kill")) {
                            startActivity(new Intent(getContext(), SecKillActivity.class));
                        }

                    } else if (bannerList.get(i).getBannerStyle().equals("1")) {
                        /**
                         * 1代表获取的是富文本
                         */
                        Intent intent = new Intent(getActivity(), HomeAdvertisingActivity.class);
                        intent.putExtra("bannerId", bannerList.get(i).getId());
                        intent.putExtra("bannerStyle", bannerList.get(i).getBannerStyle());
                        intent.putExtra("weburl", bannerList.get(i).getBannerUrl());
                        intent.putExtra("bannerLogo", bannerList.get(i).getBannerLogo());
                        intent.putExtra("bannerTitle", bannerList.get(i).getBannerName());
                        intent.putExtra("bannerDetail", bannerList.get(i).getBannerDetails());
                        getActivity().startActivity(intent);
                    } else {
                        /**
                         * 2代表获取的是URL    4代表的是店铺   5代表的是推荐商品
                         */
                        Intent intent = new Intent(getActivity(), HomeAdvertisingActivity.class);
                        intent.putExtra("bannerId", bannerList.get(i).getId());
                        intent.putExtra("bannerStyle", bannerList.get(i).getBannerStyle());
                        intent.putExtra("weburl", bannerList.get(i).getBannerUrl());
                        intent.putExtra("bannerLogo", bannerList.get(i).getBannerLogo());
                        intent.putExtra("bannerTitle", bannerList.get(i).getBannerName());
                        intent.putExtra("bannerDetail", bannerList.get(i).getBannerDetails());
                        getActivity().startActivity(intent);
                    }
                }
            });
        }
    }


    private void initShowSort(int i, int sort, ImageView ivNewuserprg) {
        if (bannerList.get(i).getShowSort() == sort) {
            glideImage(bannerList.get(i).getBannerLogo(), ivNewuserprg);
        }
    }

    private void glideImage(String url, ImageView img) {
        Glide.with(this).load(url).dontAnimate().placeholder(R.drawable.dismiss).into(img);
    }


    @Override
    public void showLoadingDialog() {

    }

    @Override
    public void showErrorMessage(String s) {

    }

    @Override
    public void onStop() {
        super.onStop();
        mv_home_marqueeView.stopFlipping();
    }


    public void loadData(List<ShopListHomeBean.BodyBean.ShopListDataBean> apiOrderListMore) {
        if (pageIndex == 0) {
            gridViewAdapter.setmDate(shoplist);
            homeListViewAdapter.setmDate(shoplist);
        } else {
            gridViewAdapter.notifyDataSetChanged();
            homeListViewAdapter.notifyDataSetChanged();
        }
    }

    public void loadMoreData(List<ShopListHomeBean.BodyBean.ShopListDataBean> apiOrderListMore) {

        if (shoplist == null) {
            shoplist = new ArrayList<>();
        }
        if (pageIndex == 0) {
            gridViewAdapter.Clear();
            homeListViewAdapter.Clear();
        }
        shoplist.addAll(apiOrderListMore);
        if (pageIndex == 0) {
            gridViewAdapter.setmDate(shoplist);
            homeListViewAdapter.setmDate(shoplist);
        } else {
            gridViewAdapter.notifyDataSetChanged();
            homeListViewAdapter.notifyDataSetChanged();
        }
        pageIndex += Integer.parseInt(SpContent.pageSize);
    }

    /**
     * 显示更新对话框
     *
     * @param downloadUrl
     */
    private void showUpdaloadDialog(String apk_code, final String downloadUrl, String forceUpdate) {
        final Dialog dialog = new Dialog(getActivity(), R.style.dialog);
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_home_download, null);
        dialog.setContentView(view);
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
        ImageView dialog_download_cancel = view.findViewById(R.id.dialog_download_cancel);
        TextView dialog_download_title = view.findViewById(R.id.dialog_download_title);
        RelativeLayout dialog_download_dow = view.findViewById(R.id.dialog_download_dow);
        TextView dialog_download_cancel_two = view.findViewById(R.id.dialog_download_cancel_two);
        dialog_download_title.setText("发现新版本，" + apk_code + "来啦");
        switch (forceUpdate) {
            //强制
            case "1":
                dialog_download_cancel.setVisibility(View.GONE);
                dialog_download_cancel_two.setVisibility(View.GONE);
                break;
            //非强制
            case "2":
                dialog_download_cancel.setVisibility(View.VISIBLE);
                dialog_download_cancel_two.setVisibility(View.VISIBLE);
                break;
        }
        dialog_download_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog_download_cancel_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog_download_dow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                startUpload(downloadUrl);//下载最新的版本程序
            }
        });
//        // 这里的属性可以一直设置，因为每次设置后返回的是一个builder对象
//        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
//        // 设置提示框的标题
//        builder.setTitle("版本升级").
//                setIcon(R.mipmap.ic_queen). // 设置提示框的图标
//                setMessage("发现新版本！请及时更新").// 设置要显示的信息
//                setPositiveButton("确定", new DialogInterface.OnClickListener() {// 设置确定按钮
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                startUpload(downloadUrl);//下载最新的版本程序
//            }
//        }).setNegativeButton("取消", null);//设置取消按钮,null是什么都不做，并关闭对话框
//        AlertDialog alertDialog = builder.create();
//        // 显示对话框
//
//        alertDialog.show();
    }

    /**
     * 开始下载
     *
     * @param downloadUrl 下载url
     */
    private void startUpload(String downloadUrl) {
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setMessage("正在下载新版本");
        progressDialog.setCancelable(false);//不能手动取消下载进度对话框

        final String fileSavePath = Utils.getSaveFilePath(downloadUrl);

        HTTPCaller.getInstance().downloadFile(downloadUrl, fileSavePath, null, new ProgressUIListener() {

            @Override
            public void onUIProgressStart(long totalBytes) {//下载开始
                progressDialog.setMax((int) totalBytes);
                progressDialog.show();
            }

            //更新进度
            @Override
            public void onUIProgressChanged(long numBytes, long totalBytes, float percent, float speed) {
                progressDialog.setProgress((int) numBytes);
            }

            @Override
            public void onUIProgressFinish() {//下载完成
                Toast.makeText(getActivity(), "下载完成", Toast.LENGTH_LONG).show();
                progressDialog.dismiss();
                openAPK(fileSavePath);
            }
        });
    }

    /**
     * 下载完成安装apk
     *
     * @param fileSavePath
     */
    private void openAPK(String fileSavePath) {
        File file = new File(fileSavePath);
        Intent intent = new Intent(Intent.ACTION_VIEW);
        Uri data;
        data = Uri.fromFile(file);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setDataAndType(data, "application/vnd.android.package-archive");
        getActivity().startActivity(intent);
    }


    private boolean loadImageFromNetwork(String urladdr) {

        // TODO Auto-generated method stub
        Drawable drawable = null;
        try {
            //judge if has picture locate or not according to filename
            drawable = Drawable.createFromStream(new URL(urladdr).openStream(), "image.jpg");
        } catch (IOException e) {
            L.e("test", e.getMessage());
        }

        if (drawable == null) {
            return false;
        } else {
            return true;
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    private void setScroll() {
        hight1 = li_new_top.getHeight();
        hight2 = home_layout.getHeight();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            sc_home_scroll.setOnScrollChangeListener(new View.OnScrollChangeListener() {
                @Override
                public void onScrollChange(View view, int i, int i1, int i2, int i3) {
                    hight = i1;
                    if (i1 >= li_new_top.getHeight() + home_layout.getHeight() - home_app_bar.getHeight()) {
                        layout_stick_header_main.setVisibility(View.VISIBLE);
                    } else {
                        layout_stick_header_main.setVisibility(View.GONE);
                    }
                    int hights = banner.getHeight() - home_app_bar.getHeight();
                    if (i1 <= 0) {
                        home_app_bar.setBackgroundColor(Color.argb((int) 0, 196, 113, 245));//AGB由相关工具获得，或者美工提供
                    } else if (i1 > 0 && i1 <= hights) {
                        float scale = (float) i1 / hights;
                        float alpha = (255 * scale);
                        // 只是layout背景透明(仿知乎滑动效果)
                        home_app_bar.setBackgroundColor(Color.argb((int) alpha, 196, 113, 245));
                    } else {
                        home_app_bar.setBackgroundColor(Color.argb((int) 250, 196, 113, 245));
                    }
                }
            });
        }
        sc_home_scroll.smoothScrollTo(0, hight1 + hight2 - home_app_bar.getHeight());
    }

    private void initListeners() {
        // 获取顶部图片高度后，设置滚动监听
        ViewTreeObserver vto = banner.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                banner.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                imageHeight = banner.getHeight();
            }
        });
    }

}