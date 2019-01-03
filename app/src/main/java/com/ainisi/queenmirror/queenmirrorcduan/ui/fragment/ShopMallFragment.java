package com.ainisi.queenmirror.queenmirrorcduan.ui.fragment;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ainisi.queenmirror.common.base.BaseFragment;
import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.HomeListViewAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.HomepageGridViewAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.HomepageNearBean;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.ProblemAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.ShopMallAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.bean.HomepageNearByBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.Homepagebean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.ShopBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.ShopListHomeBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.ShopMallBannerBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.HomeAdvertisingActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.SearchActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.adapter.MerchantsAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean.HomeIndustryBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean.MerchantsBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean.PreferentialBean;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.LoadingDialog;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SP;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpContent;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.ainisi.queenmirror.queenmirrorcduan.utils.GlideImageLoader;
import com.ainisi.queenmirror.queenmirrorcduan.utils.NoScrollGridView;
import com.ainisi.queenmirror.queenmirrorcduan.utils.NoScrollListview;
import com.ainisi.queenmirror.queenmirrorcduan.utils.ScrollInterceptScrollView;
import com.example.john.library.PopWindowHome;
import com.lzy.okgo.cache.CacheMode;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.umeng.analytics.MobclickAgent;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by EWorld on 2018/3/6.
 * 商城
 */

public class ShopMallFragment extends BaseFragment implements HttpCallBack {
    @Bind(R.id.banner)
    Banner banner;
    @Bind(R.id.li_home_screen_bottom)
    LinearLayout li_home_screen_bottom;
    @Bind(R.id.list_view)
    NoScrollListview listView;
    @Bind(R.id.layout_stick_header_main)
    LinearLayout layout_stick_header_main;
    @Bind(R.id.re_shop_mall)
    NoScrollGridView shopRecycle;
    @Bind(R.id.iv_surface)
    ImageView imgSurface;
    @Bind(R.id.iv_uspension_surface)
    ImageView uspensionSurface;
    @Bind(R.id.shop_gridView)
    NoScrollGridView shop_gridView;
    @Bind(R.id.tv_shop_screen)
    TextView tv_shop_screen;
    @Bind(R.id.rb_screen)
    TextView bottomScreen;
    @Bind(R.id.li_home_paixu)
    LinearLayout li_home_paixu;
    ShopListHomeBean shopListHomeBean;
    private HomeIndustryBean homeIndustryBean;
    private List<ShopBean> shopList;
    @Bind(R.id.shop_mall_app_bar)
    android.support.design.widget.AppBarLayout shop_mall_app_bar;

    int hight;
    int hight1;
    public int pageNumber = 1;
    public int pageIndex = 0;
    int pageSum = 0;//标记ScrollView移动的距离
    private boolean isClick;
    private List<PreferentialBean.BodyBean.FeatureKeysListDataBean> preferentialList;
    private MerchantsAdapter merchantsAdapter;
    private List<MerchantsBean.BodyBean.ActivityKeysListDataBean> merchantsList;
    private ProblemAdapter problemAdapter;

    @Bind(R.id.shop_mall_refreshLayout)
    SmartRefreshLayout shop_mall_refreshLayout;
    @Bind(R.id.sc_shop_scroll)
    ScrollInterceptScrollView sc_shop_scroll;
    HomepageGridViewAdapter gridViewAdapter;
    HomeListViewAdapter homeListViewAdapter;

    List<ShopListHomeBean.BodyBean.ShopListDataBean> shopListBeans = new ArrayList<>();

    @Bind(R.id.li_shopmall_sales_bottom)
    LinearLayout li_shopmall_sales_bottom;
    @Bind(R.id.iv_near_sort)
    ImageView iv_near_sort;
    @Bind(R.id.tv_distance)
    TextView tv_distance;
    @Bind(R.id.tv_new_distance)
    TextView tv_new_distance;
    @Bind(R.id.li_shopmall_screen)
    LinearLayout li_shopmall_screen;
    public PopWindowHome popWindowHomes;
    ListView rv_nearlist_right;
    @Bind(R.id.li_shopmall_near_shop)
    LinearLayout li_shopmall_near_shop;
    @Bind(R.id.bt_shopmalll_up_home)
    public TextView bt_shopmalll_up_home;
    @Bind(R.id.bt_app_home)
    public TextView bt_app_home;
    @Bind(R.id.iv_distance_sort)
    ImageView iv_distance_sort;
    @Bind(R.id.home_layout)
    LinearLayout home_layout;
    @Bind(R.id.tv_shop_sales)
    TextView tv_shop_sales;
    @Bind(R.id.rb_sales)
    TextView rb_sales;
    @Bind(R.id.shop_list_null)
    RelativeLayout shop_list_null;
    @Bind(R.id.li_shop_bottom)
    LinearLayout li_shop_bottom;
    @Bind(R.id.li_shop_mall_first)
    LinearLayout li_shop_mall_first;
    @Bind(R.id.iv_shop_search)
    ImageView iv_shop_search;

    HomepageNearBean sortAdapter2;
    List<HomepageNearByBean> home_string = new ArrayList<>();
    List<Homepagebean.BodyBean.DistrictListDataBean> DistrictListData;
    ShopListHomeBean homeShopBySalesBean;
    List<String> urls;
    List<String> styles;
    List<String> titles;
    List<String> bannerId;
    List<String> images;

    public static ShopMallFragment instance = null;
    String cond="";
    public int input_where = 0;
    int zonghe_where = 0;
    LoadingDialog loadingDialog;
    int index = 0;
    public String distance = "1",distance_code = "1";

    @Override
    protected int getLayoutResource() {
        instance = this;
        return R.layout.fragment_shop_mall;
    }

    @Override
    public void onResume() {
        super.onResume();
        MobclickAgent.onResume(getActivity());
    }

    @Override
    public void onPause() {
        super.onPause();
        MobclickAgent.onPause(getActivity());
    }

    @Override
    public void initPresenter() {
    }

    @Override
    public void onStart() {
        super.onStart();

    }

    @Override
    protected void doFitsrData() {

        /**
         * 获取首页数据
         */
        pageIndex = 0;

        /**
         * 获取底部数据
         */
        if(index == 0) {
            doFirstData();
        }

        /**
         * 获取顶部Banner
         */
        initBanner();

        /**
         * 获取异业类型
         */
        getYiyeData();
        //inithttp();
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void initView() {
        loadingDialog = new LoadingDialog(getActivity());

        homeListViewAdapter = new HomeListViewAdapter(getActivity(), shopListBeans, "shop");
        listView.setAdapter(homeListViewAdapter);

        gridViewAdapter = new HomepageGridViewAdapter(getActivity(), shopListBeans, "shop");
        shop_gridView.setAdapter(gridViewAdapter);

        shop_mall_refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                pageNumber = 1;
                pageIndex = 0;
                /**
                 * 获取首页部分数据
                 */
                initBanner();

                if(input_where == 0){
                    doFirstData();
                }else if(input_where == 1){
                    if(distance_code.equals("1")){
                        getDistanPaixuData(distance);
                    }else{
                        getNearPaixuData(distance);
                    }
                }else if(input_where == 2){
                    getSalesData();
                }else if(input_where == 3){
                    if(zonghe_where == 0){
                        getZonghePaixuData();
                    }else if(zonghe_where == 1){
                        getScorePaixuData();
                    }else if(zonghe_where == 2){
                        getLookPaixuData();
                    }
                }else if(input_where == 4){
                    getSelectData();
                }

                getYiyeData();
                inithttp();

                refreshlayout.finishRefresh(2000);
            }
        });
        shop_mall_refreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {

                if(pageSum < Integer.parseInt(SpContent.pageSize)){
                    refreshlayout.finishLoadmore(2000);
                    T.show("您已加载完全部数据");
                }else{
                    pageNumber++;

                    if(input_where == 0) {
                        doFirstData();
                    }else if(input_where == 1){
                        if(distance_code.equals("1")){
                            getDistanPaixuData(distance);
                        }else{
                            getNearPaixuData(distance);
                        }
                    }else if(input_where == 2){
                        getSalesData();
                    }else if(input_where == 3){
                        if(zonghe_where == 0){
                            getZonghePaixuData();
                        }else if(zonghe_where == 1){
                            getScorePaixuData();
                        }else if(zonghe_where == 2){
                            getLookPaixuData();
                        }
                    }else if(input_where == 4){
                        getSelectData();
                    }
                    refreshlayout.finishLoadmore(2000);
                }
            }
        });


        int w = View.MeasureSpec.makeMeasureSpec(0,
                View.MeasureSpec.UNSPECIFIED);
        int h = View.MeasureSpec.makeMeasureSpec(0,
                View.MeasureSpec.UNSPECIFIED);
        li_home_paixu.measure(w,h);
        li_shop_mall_first.measure(w,h);

        hight1 = li_shop_mall_first.getMeasuredHeight()-li_home_paixu.getMeasuredHeight();

        sc_shop_scroll.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View view, int i, int i1, int i2, int i3) {
                hight = i1;
                if (i1 >= hight1) {
                    li_home_paixu.setVisibility(View.INVISIBLE);
                    layout_stick_header_main.setVisibility(View.VISIBLE);
                } else {
                    li_home_paixu.setVisibility(View.VISIBLE);
                    layout_stick_header_main.setVisibility(View.INVISIBLE);
                }
            }
        });
    }

    @OnClick({R.id.li_shopmall_near_shop,R.id.li_home_near_shop,R.id.li_shopmall_sales_bottom,R.id.li_sales_new_bottom,R.id.li_shopmall_screen,
            R.id.li_home_screen_bottom,R.id.line_surface,R.id.line_uspension_surface,R.id.tv_shop_sales,R.id.rb_sales,R.id.iv_shop_search})
    public void OnClick(View view){
        switch (view.getId()){
            case R.id.iv_shop_search:
                Intent intent = new Intent(getActivity(), SearchActivity.class);
                intent.putExtra("shopCate", "2");
                startActivity(intent);
                break;
            /**
             * 点击销量最高
             */
            case R.id.tv_shop_sales:
            case R.id.rb_sales:
                /**
                 * 设置商家文字
                 */
                //设置附近商家
                bt_shopmalll_up_home.setTextColor(this.getResources().getColor(R.color.alpha_55_black));
                TextPaint tp1 = bt_shopmalll_up_home.getPaint();
                tp1.setFakeBoldText(false);
                bt_app_home.setTextColor(this.getResources().getColor(R.color.alpha_55_black));
                TextPaint tps1 = bt_app_home.getPaint();
                tps1.setFakeBoldText(false);
                //设置销量文字
                tv_shop_sales.setTextColor(this.getResources().getColor(R.color.alpha_95_black));
                TextPaint tpsa01 = tv_shop_sales.getPaint();
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
                bottomScreen.setTextColor(this.getResources().getColor(R.color.alpha_55_black));
                TextPaint tpscre01 = bottomScreen.getPaint();
                tpscre01.setFakeBoldText(false);
                tv_shop_screen.setTextColor(this.getResources().getColor(R.color.alpha_55_black));
                TextPaint tpscre11 = tv_shop_screen.getPaint();
                tpscre11.setFakeBoldText(false);

                sc_shop_scroll.smoothScrollTo(0, hight1);
                pageIndex = 0;
                pageNumber = 1;

                input_where = 2;

                /**
                 * 获取销量数据
                 */
                getSalesData();
                break;
            /**
             * 附近商家
             */
            case R.id.li_shopmall_near_shop:
            case R.id.li_home_near_shop:
                /**
                 * 设置商家文字
                 */
                //设置附近商家
                bt_shopmalll_up_home.setTextColor(this.getResources().getColor(R.color.alpha_95_black));
                TextPaint tp = bt_shopmalll_up_home.getPaint();
                tp.setFakeBoldText(true);
                bt_app_home.setTextColor(this.getResources().getColor(R.color.alpha_95_black));
                TextPaint tps = bt_app_home.getPaint();
                tps.setFakeBoldText(true);
                //设置销量文字
                tv_shop_sales.setTextColor(this.getResources().getColor(R.color.alpha_55_black));
                TextPaint tpsa = tv_shop_sales.getPaint();
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
                bottomScreen.setTextColor(this.getResources().getColor(R.color.alpha_55_black));
                TextPaint tpscre = bottomScreen.getPaint();
                tpscre.setFakeBoldText(false);
                tv_shop_screen.setTextColor(this.getResources().getColor(R.color.alpha_55_black));
                TextPaint tpscre1 = tv_shop_screen.getPaint();
                tpscre1.setFakeBoldText(false);
                input_where = 1;
                if(hight>=hight1){
                }else {
                    sc_shop_scroll.smoothScrollTo(0, hight1);
                }
                View customViews = View.inflate(getActivity(), R.layout.homepage_near_list_bottom, null);
                popWindowHomes = new PopWindowHome.Builder(getActivity())
                        .setStyle(PopWindowHome.PopWindowStyle.PopDown)
                        .setView(customViews)
                        .setControlViewAnim(iv_near_sort, R.anim.btn_rotate_anim_1, R.anim.btn_rotate_anim_2, true)
                        .show(li_shopmall_near_shop);//show里面的内容是显示在空间下方的控件
                final TextView tv_near_list_fujin = customViews.findViewById(R.id.tv_near_list_fujin);
                final TextView tv_near_list_other = customViews.findViewById(R.id.tv_near_list_other);
                rv_nearlist_right = customViews.findViewById(R.id.rv_nearlist_right);
                List<HomepageNearByBean> list_one = new ArrayList<>();
                String[] strings = {"附近（智能距离）","1千米","3千米","5千米","10千米"};
                for(int i=0;i<4;i++){
                    HomepageNearByBean homepageNearBean = new HomepageNearByBean();
                    homepageNearBean.setId(""+i);
                    homepageNearBean.setName(strings[i]);
                    list_one.add(homepageNearBean);
                }
                sortAdapter2 = new HomepageNearBean(getActivity(), list_one,"3");
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
                        String[] strings = {"附近（智能距离）","1千米","3千米","5千米","10千米"};

                        for(int i=0;i<4;i++){
                            HomepageNearByBean homepageNearBean = new HomepageNearByBean();
                            homepageNearBean.setId(""+i);
                            homepageNearBean.setName(strings[i]);

                            list_one.add(homepageNearBean);
                        }
                        sortAdapter2.Clear();
                        sortAdapter2 = new HomepageNearBean(getActivity(), list_one,"3");
                        rv_nearlist_right.setAdapter(sortAdapter2);
                        sortAdapter2.notifyDataSetChanged();
                    }
                });
                break;
            /**
             * 综合排序
             */
            case R.id.li_shopmall_sales_bottom:
            case R.id.li_sales_new_bottom:
                /**
                 * 设置商家文字
                 */
                //设置附近商家
                bt_shopmalll_up_home.setTextColor(this.getResources().getColor(R.color.alpha_55_black));
                TextPaint tp31 = bt_shopmalll_up_home.getPaint();
                tp31.setFakeBoldText(false);
                bt_app_home.setTextColor(this.getResources().getColor(R.color.alpha_55_black));
                TextPaint tps31 = bt_app_home.getPaint();
                tps31.setFakeBoldText(false);
                //设置销量文字
                tv_shop_sales.setTextColor(this.getResources().getColor(R.color.alpha_55_black));
                TextPaint tpsa31 = tv_shop_sales.getPaint();
                tpsa31.setFakeBoldText(false);
                rb_sales.setTextColor(this.getResources().getColor(R.color.alpha_55_black));
                TextPaint tpsa311 = rb_sales.getPaint();
                tpsa311.setFakeBoldText(false);
                //设置综合排序
                tv_distance.setTextColor(this.getResources().getColor(R.color.alpha_95_black));
                TextPaint tpsd31 = tv_distance.getPaint();
                tpsd31.setFakeBoldText(true);
                tv_new_distance.setTextColor(this.getResources().getColor(R.color.alpha_95_black));
                TextPaint tpsd311 = tv_new_distance.getPaint();
                tpsd311.setFakeBoldText(true);
                //筛选
                bottomScreen.setTextColor(this.getResources().getColor(R.color.alpha_55_black));
                TextPaint tpscre31 = bottomScreen.getPaint();
                tpscre31.setFakeBoldText(false);
                tv_shop_screen.setTextColor(this.getResources().getColor(R.color.alpha_55_black));
                TextPaint tpscre311 = tv_shop_screen.getPaint();
                tpscre311.setFakeBoldText(false);
                input_where = 3;
                if(hight>=hight1){
                }else {
                    sc_shop_scroll.smoothScrollTo(0, hight1);
                }
                View customViewn = View.inflate(getActivity(), R.layout.home_bottom_zonghe, null);
                final PopWindowHome popWindowHome = new PopWindowHome.Builder(getActivity())
                        .setStyle(PopWindowHome.PopWindowStyle.PopDown)
                        .setView(customViewn)
                        .setControlViewAnim(iv_distance_sort, R.anim.btn_rotate_anim_1, R.anim.btn_rotate_anim_2, true)
                        .show(li_shopmall_sales_bottom);//show里面的内容是显示在空间下方的控件
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
            case R.id.li_shopmall_screen:
            case R.id.li_home_screen_bottom:

                /**
                 * 设置商家文字
                 */
                //设置附近商家
                bt_shopmalll_up_home.setTextColor(this.getResources().getColor(R.color.alpha_55_black));
                TextPaint tp41 = bt_shopmalll_up_home.getPaint();
                tp41.setFakeBoldText(false);
                bt_app_home.setTextColor(this.getResources().getColor(R.color.alpha_55_black));
                TextPaint tps41 = bt_app_home.getPaint();
                tps41.setFakeBoldText(false);
                //设置销量文字
                tv_shop_sales.setTextColor(this.getResources().getColor(R.color.alpha_55_black));
                TextPaint tpsa41 = tv_shop_sales.getPaint();
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
                bottomScreen.setTextColor(this.getResources().getColor(R.color.alpha_95_black));
                TextPaint tpscre41 = bottomScreen.getPaint();
                tpscre41.setFakeBoldText(true);
                tv_shop_screen.setTextColor(this.getResources().getColor(R.color.alpha_95_black));
                TextPaint tpscre411 = tv_shop_screen.getPaint();
                tpscre411.setFakeBoldText(true);
                input_where = 4;
                if(hight>=hight1){
                }else {
                    sc_shop_scroll.smoothScrollTo(0, hight1);
                }

                View customView = View.inflate(getActivity(), R.layout.pop_screening, null);
                final PopWindowHome  popWindowHomes = new PopWindowHome.Builder(getActivity())
                        .setStyle(PopWindowHome.PopWindowStyle.PopDown)
                        .setView(customView)
                        .show(li_shopmall_screen);//show里面的内容是显示在空间下方的控件


                /*TextView tv_cancel = customView.findViewById(R.id.tv_cancel);
                tv_cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        popWindowHomes.dismiss();
                    }
                });
                TextView tv_submit = customView.findViewById(R.id.tv_submit);
                tv_submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        popWindowHomes.dismiss();

                        *//**
                         * 已选择情况
                         *//*
                        input_where = 4;
                        pageIndex = 0;
                        pageNumber = 1;
                        getSelectData();
                    }
                });
                final TextView tv_home_queen = customView.findViewById(R.id.tv_home_queen);

                tv_home_queen.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        tv_home_queen.setBackground(getActivity().getDrawable(R.drawable.button_home_tese_select));
                        tv_home_queen.setTextColor(getActivity().getResources().getColor(R.color.white));
                    }
                });
                final TextView tv_home_first = customView.findViewById(R.id.tv_home_first);
                final TextView tv_home_second = customView.findViewById(R.id.tv_home_second);

                tv_home_first.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        cond = "1";
                        tv_home_first.setBackground(getActivity().getDrawable(R.drawable.button_home_tese_select));
                        tv_home_first.setTextColor(getActivity().getResources().getColor(R.color.white));
                        tv_home_second.setBackground(getActivity().getDrawable(R.drawable.button_home_tese));
                        tv_home_second.setTextColor(getActivity().getResources().getColor(R.color.alpha_65_black));
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
                    }
                });
*/
                break;
            //点击流式布局，和瀑布流布局切换
            case R.id.line_surface:
                if (isClick) {
                    isClick = false;
                    loadData(shopListBeans);
                    shop_gridView.setVisibility(View.GONE);
                    listView.setVisibility(View.VISIBLE);
                    imgSurface.setImageResource(R.drawable.icon_home_list);
                } else {
                    imgSurface.setImageResource(R.drawable.icon_home_recycler);
                    shop_gridView.setVisibility(View.VISIBLE);
                    listView.setVisibility(View.GONE);

                    loadData(shopListBeans);
                    isClick = true;
                }
                break;
            case R.id.line_uspension_surface:
                if (isClick) {
                    isClick = false;
                    loadData(shopListBeans);
                    shop_gridView.setVisibility(View.GONE);
                    listView.setVisibility(View.VISIBLE);
                    uspensionSurface.setImageResource(R.drawable.icon_home_list);
                } else {
                    uspensionSurface.setImageResource(R.drawable.icon_home_recycler);
                    shop_gridView.setVisibility(View.VISIBLE);
                    listView.setVisibility(View.GONE);

                    loadData(shopListBeans);
                    isClick = true;
                }
                break;
        }
    }

    /**
     * 顶部Banner图
     */
    private void initBanner() {
        HashMap<String, String> parames = new HashMap<>();
        parames.put("bannerCategory","1");//0是首页   1是商城
        parames.put("platformType","1");
        parames.put("token",SP.get(getActivity(),SpContent.UserToken,"")+"");
        HttpUtils.doPost(ACTION.PAGEBANNER, parames, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    /**
     * 获取销量最高数据
     */
    private void getSalesData() {
        loadingDialog.loadShow();
        HashMap<String, String> params = new HashMap<>();
        params.put("pageNumber", pageNumber+"");
        params.put("contentByTitle", "");
        params.put("shopCate","2");
        params.put("pageSize",SpContent.pageSize);
        params.put("cityCode",SP.get(getActivity(),SpContent.CityCode,"0512")+"");
        params.put("token",SP.get(getActivity(),SpContent.UserToken,"")+"");
        HttpUtils.doPost(ACTION.SHOPBYSALES, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    /**
     * 根据区域号获取区域
     */
    private void getDistanceByCode() {
        loadingDialog.loadShow();
        HashMap<String, String> parames = new HashMap<>();
        parames.put("code", SP.get(getActivity(),SpContent.CityCode,"0512")+"");
        parames.put("token",SP.get(getActivity(),SpContent.UserToken,"")+"");
        HttpUtils.doPost(ACTION.SHOPLISTBYAREACODE, parames, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }
    /**
     * 点击综合排序
     */
    private void getZonghePaixuData() {
        loadingDialog.loadShow();
        HashMap<String, String> parames = new HashMap<>();
        parames.put("pageNumber",pageNumber+"");
        parames.put("contentByTitle","");
        parames.put("shopCate","2");
        parames.put("cityCode", SP.get(getActivity(),SpContent.CityCode,"0512")+"");
        parames.put("pageSize",SpContent.pageSize);
        HttpUtils.doPost(ACTION.SHOPLISTBYZONGHE, parames, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    /**
     * 点击评分从高到低排序
     */
    private void getScorePaixuData(){
        loadingDialog.loadShow();
        HashMap<String, String> parames = new HashMap<>();
        parames.put("pageNumber",pageNumber+"");
        parames.put("contentByTitle","");
        parames.put("shopCate","2");
        parames.put("cityCode", SP.get(getActivity(),SpContent.CityCode,"0512")+"");
        parames.put("pageSize",SpContent.pageSize);
        HttpUtils.doPost(ACTION.SHOPLISTBYSOCORE, parames, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    /**
     * 点击浏览量从高到低排序
     */
    private void  getLookPaixuData(){
        loadingDialog.loadShow();
        HashMap<String, String> parames = new HashMap<>();
        parames.put("pageNumber",pageNumber+"");
        parames.put("contentByTitle","");
        parames.put("shopCate","2");
        parames.put("cityCode", SP.get(getActivity(),SpContent.CityCode,"0512")+"");
        parames.put("pageSize",SpContent.pageSize);
        HttpUtils.doPost(ACTION.SHOPLISTBYLOOK, parames, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    /**
     * 点击附近商家(根据距离)
     */
    public void getDistanPaixuData(String distance){
        loadingDialog.loadShow();
        HashMap<String, String> parames = new HashMap<>();
        parames.put("pageNumber",pageNumber+"");
        parames.put("contentByTitle","");
        parames.put("shopCate","2");
        parames.put("pageSize",SpContent.pageSize);
        parames.put("geoX",SP.get(getActivity(),SpContent.UserLat,"0")+"");
        parames.put("geoY",SP.get(getActivity(),SpContent.UserLon,"0")+"");
        parames.put("distanceScope",distance);
        parames.put("cityCode",SP.get(getActivity(),SpContent.CityCode,"0512")+"");
        HttpUtils.doPost(ACTION.SHOPLISTBYDISTANCE, parames, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    /**
     * 点击附近商家(根据区域)
     */
    public void getNearPaixuData(String districtId){
        loadingDialog.loadShow();
        HashMap<String, String> parames = new HashMap<>();
        parames.put("pageNumber",pageNumber+"");
        parames.put("contentByTitle","");
        parames.put("shopCate","2");
        parames.put("districtId",districtId);
        parames.put("pageSize",SpContent.pageSize);
        HttpUtils.doPost(ACTION.SHOPLISTBYAREANEAR, parames, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    /**
     * 获取异业分类数据
     */
    private void getYiyeData() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("tabType", "4");//type  2代表美业    4代表异业
        hashMap.put("tabFather", "0");
        HttpUtils.doPost(ACTION.INDUSTRY, hashMap, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);//首页的行业分类
    }


    /**
     * 获取数据
     */
    private void doFirstData() {
        index++;
        HashMap<String, String> params = new HashMap<>();
        params.put("pageNumber", pageNumber + "");
        params.put("contentByTitle", "");
        params.put("pageSize", SpContent.pageSize);
        params.put("shopCate", "2");
        params.put("cityCode",SP.get(getActivity(),SpContent.CityCode,"0512")+"");
        HttpUtils.doPost(ACTION.SHOPLIST, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    /**
     * 特色筛选
     */
    private void inithttp() {
        HashMap<String, String> parames = new HashMap<>();
        parames.put("", "");
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
        parames.put("token", SP.get(getActivity(),SpContent.UserToken,"")+"");
        parames.put("cityCode",SP.get(getActivity(),SpContent.CityCode,"")+"");
        parames.put("pageNumber",pageNumber+"");
        parames.put("pageSize",SpContent.pageSize);
        parames.put("contentByTitle","");
        parames.put("shopCate","2");
        parames.put("goodsCate","");
        parames.put("queenCard","");
        parames.put("condition",cond);
        parames.put("shopActivity","");
        parames.put("enableFlag","1");
        parames.put("shopFeatures","");
        //商家活动（筛选）
        HttpUtils.doPost(ACTION.GETDATABYSHAIXUAN, parames, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }
    @Override
    public void onSuccess(int action, String res) {
        switch (action) {
            /**
             * 获取筛选的值
             */
            case ACTION.GETDATABYSHAIXUAN:
                loadingDialog.cancel();
                homeShopBySalesBean = GsonUtil.toObj(res, ShopListHomeBean.class);
                if (homeShopBySalesBean.isSuccess()) {
                    if (homeShopBySalesBean.getBody().getShopListData().size() > 0) {

                        shop_list_null.setVisibility(View.GONE);
                        li_shop_bottom.setVisibility(View.VISIBLE);
                        pageSum = homeShopBySalesBean.getBody().getShopListData().size();

                        loadMoreData(homeShopBySalesBean.getBody().getShopListData());

                    } else {
                        if(pageIndex == 0){
                            shop_list_null.setVisibility(View.VISIBLE);
                            li_shop_bottom.setVisibility(View.GONE);
                        }else{
                            shop_list_null.setVisibility(View.GONE);
                            li_shop_bottom.setVisibility(View.VISIBLE);
                        }

                        DisplayMetrics dm = getResources().getDisplayMetrics();
                        int heigth = dm.heightPixels;
                        RelativeLayout.LayoutParams gallery_lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, heigth);
                        shop_list_null.setLayoutParams(gallery_lp);
                        gridViewAdapter.Clear();
                        homeListViewAdapter.Clear();
                    }
                } else {
                    T.show(shopListHomeBean.getMsg());
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

                        shop_list_null.setVisibility(View.GONE);
                        li_shop_bottom.setVisibility(View.VISIBLE);
                        pageSum = homeShopBySalesBean.getBody().getShopListData().size();

                        loadMoreData(homeShopBySalesBean.getBody().getShopListData());

                    } else {
                        if(pageIndex == 0){
                            shop_list_null.setVisibility(View.VISIBLE);
                            li_shop_bottom.setVisibility(View.GONE);
                        }else{
                            shop_list_null.setVisibility(View.GONE);
                            li_shop_bottom.setVisibility(View.VISIBLE);
                        }

                        DisplayMetrics dm = getResources().getDisplayMetrics();
                        int heigth = dm.heightPixels;
                        RelativeLayout.LayoutParams gallery_lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, heigth);
                        shop_list_null.setLayoutParams(gallery_lp);
                        gridViewAdapter.Clear();
                        homeListViewAdapter.Clear();
                    }
                } else {
                    T.show(shopListHomeBean.getMsg());
                }
                break;

            /**
             * 根据区域选择
             */
            case ACTION.SHOPLISTBYAREANEAR:
                loadingDialog.cancel();
                homeShopBySalesBean = GsonUtil.toObj(res, ShopListHomeBean.class);
                if (homeShopBySalesBean.isSuccess()) {
                    if (homeShopBySalesBean.getBody().getShopListData().size() > 0) {
                        shop_list_null.setVisibility(View.GONE);
                        li_shop_bottom.setVisibility(View.VISIBLE);
                        pageSum = homeShopBySalesBean.getBody().getShopListData().size();
                        loadMoreData(homeShopBySalesBean.getBody().getShopListData());

                    } else {
                        if(pageIndex == 0){
                            shop_list_null.setVisibility(View.VISIBLE);
                            li_shop_bottom.setVisibility(View.GONE);
                        }else{
                            shop_list_null.setVisibility(View.GONE);
                            li_shop_bottom.setVisibility(View.VISIBLE);
                        }

                        DisplayMetrics dm = getResources().getDisplayMetrics();
                        int heigth = dm.heightPixels;
                        RelativeLayout.LayoutParams gallery_lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, heigth);
                        shop_list_null.setLayoutParams(gallery_lp);
                        gridViewAdapter.Clear();
                        homeListViewAdapter.Clear();
                    }
                } else {
                    T.show(shopListHomeBean.getMsg());
                }
                break;
            /**
             * 根据区域code获取区域
             */
            case ACTION.SHOPLISTBYAREACODE:
                loadingDialog.cancel();
                Homepagebean homepagebean = GsonUtil.toObj(res,Homepagebean.class);
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
                    sortAdapter2 = new HomepageNearBean(getActivity(), home_string, "4");
                    rv_nearlist_right.setAdapter(sortAdapter2);
                    sortAdapter2.notifyDataSetChanged();

                } else {
                    T.show(homepagebean.getMsg());
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
                        shop_list_null.setVisibility(View.GONE);
                        li_shop_bottom.setVisibility(View.VISIBLE);
                        pageSum = homeShopBySalesBean.getBody().getShopListData().size();
                        loadMoreData(homeShopBySalesBean.getBody().getShopListData());

                    } else {
                        if(pageIndex == 0){
                            shop_list_null.setVisibility(View.VISIBLE);
                            li_shop_bottom.setVisibility(View.GONE);
                        }else{
                            shop_list_null.setVisibility(View.GONE);
                            li_shop_bottom.setVisibility(View.VISIBLE);
                        }

                        DisplayMetrics dm = getResources().getDisplayMetrics();
                        int heigth = dm.heightPixels;
                        RelativeLayout.LayoutParams gallery_lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, heigth);
                        shop_list_null.setLayoutParams(gallery_lp);
                        gridViewAdapter.Clear();
                        homeListViewAdapter.Clear();
                    }
                } else {
                    T.show(shopListHomeBean.getMsg());
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
                        shop_list_null.setVisibility(View.GONE);
                        li_shop_bottom.setVisibility(View.VISIBLE);
                        pageSum = homeShopBySalesBean.getBody().getShopListData().size();

                        loadMoreData(homeShopBySalesBean.getBody().getShopListData());
                    } else {
                        if(pageIndex == 0){
                            shop_list_null.setVisibility(View.VISIBLE);
                            li_shop_bottom.setVisibility(View.GONE);
                        }else{
                            shop_list_null.setVisibility(View.GONE);
                            li_shop_bottom.setVisibility(View.VISIBLE);
                        }

                        DisplayMetrics dm = getResources().getDisplayMetrics();
                        int heigth = dm.heightPixels;
                        RelativeLayout.LayoutParams gallery_lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, heigth);
                        shop_list_null.setLayoutParams(gallery_lp);
                        gridViewAdapter.Clear();
                        homeListViewAdapter.Clear();
                    }
                } else {
                    T.show(shopListHomeBean.getMsg());
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
                        shop_list_null.setVisibility(View.GONE);
                        li_shop_bottom.setVisibility(View.VISIBLE);
                        pageSum = homeShopBySalesBean.getBody().getShopListData().size();
                        loadMoreData(homeShopBySalesBean.getBody().getShopListData());
                    } else {
                        if(pageIndex == 0){
                            shop_list_null.setVisibility(View.VISIBLE);
                            li_shop_bottom.setVisibility(View.GONE);
                        }else{
                            shop_list_null.setVisibility(View.GONE);
                            li_shop_bottom.setVisibility(View.VISIBLE);
                        }

                        DisplayMetrics dm = getResources().getDisplayMetrics();
                        int heigth = dm.heightPixels;
                        RelativeLayout.LayoutParams gallery_lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, heigth);
                        shop_list_null.setLayoutParams(gallery_lp);
                        gridViewAdapter.Clear();
                        homeListViewAdapter.Clear();
                    }
                } else {
                    T.show(shopListHomeBean.getMsg());
                }
                break;
            /**
             * 底部获取综合数据
             */
            case ACTION.SHOPLIST:
                shopListHomeBean = GsonUtil.toObj(res, ShopListHomeBean.class);
                if (shopListHomeBean.isSuccess()) {
                    if (shopListHomeBean.getBody().getShopListData().size() > 0) {
                        shop_list_null.setVisibility(View.GONE);
                        li_shop_bottom.setVisibility(View.VISIBLE);
                        pageSum = shopListHomeBean.getBody().getShopListData().size();
                        loadMoreData(shopListHomeBean.getBody().getShopListData());
                    } else {
                        if(pageIndex == 0){
                            shop_list_null.setVisibility(View.VISIBLE);
                            li_shop_bottom.setVisibility(View.GONE);
                        }else{
                            shop_list_null.setVisibility(View.GONE);
                            li_shop_bottom.setVisibility(View.VISIBLE);
                        }

                        DisplayMetrics dm = getResources().getDisplayMetrics();
                        int heigth = dm.heightPixels;
                        RelativeLayout.LayoutParams gallery_lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, heigth);
                        shop_list_null.setLayoutParams(gallery_lp);
                        gridViewAdapter.Clear();
                        homeListViewAdapter.Clear();
                    }
                } else {
                    T.show(shopListHomeBean.getMsg());
                }
                break;
            /**
             * 获取首页Banner图
             */
            case ACTION.PAGEBANNER:
                ShopMallBannerBean bannerBean = GsonUtil.toObj(res,ShopMallBannerBean.class);
                if (bannerBean.isSuccess()) {
                    images = new ArrayList<>();
                    urls = new ArrayList<>();
                    styles = new ArrayList<>();
                    titles = new ArrayList<>();
                    bannerId = new ArrayList<>();
                    for (int i = 0; i < bannerBean.getBody().getBannerListData().size(); i++) {
                        images.add(bannerBean.getBody().getBannerListData().get(i).getBannerLogo());
                        urls.add(bannerBean.getBody().getBannerListData().get(i).getBannerUrl());
                        styles.add(bannerBean.getBody().getBannerListData().get(i).getBannerStyle());
                        titles.add(bannerBean.getBody().getBannerListData().get(i).getBannerName());
                        bannerId.add(bannerBean.getBody().getBannerListData().get(i).getId());
                    }
                    banner.setImageLoader(new GlideImageLoader());
                    banner.setBannerStyle(BannerConfig.NOT_INDICATOR);
                    banner.setImages(images);
                    banner.setViewPagerIsScroll(true);
                    banner.setFocusable(true);
                    banner.requestFocus();
                    banner.start();

                    initBannerOnClick(banner);

                } else {
                    T.show(bannerBean.getMsg());
                }
                break;
            /**
             * 获取异业分类数据
             */
            case ACTION.INDUSTRY:
                homeIndustryBean = GsonUtil.toObj(res, HomeIndustryBean.class);
                shopList = new ArrayList<>();
                //for (int i = 0; i < homeIndustryBean.getBody().getCategoryListData().size(); i++) {
                for (int i = 0; i < homeIndustryBean.getBody().getCategoryListData().size(); i++) {
                    ShopBean shopBean = new ShopBean();

                    if (null == homeIndustryBean.getBody().getCategoryListData().get(i).getEcCategory().getTabPic()) {
                        shopBean.setImageTitle("");
                    } else {
                        shopBean.setImageTitle(homeIndustryBean.getBody().getCategoryListData().get(i).getEcCategory().getTabPic());
                    }
                    shopBean.setCategoryId(homeIndustryBean.getBody().getCategoryListData().get(i).getEcCategory().getId());
                    shopBean.setTextName(homeIndustryBean.getBody().getCategoryListData().get(i).getEcCategory().getTabName());
                    shopList.add(shopBean);
                }
                ShopMallAdapter gridViewAdapters = new ShopMallAdapter(getActivity(), shopList);
                shopRecycle.setAdapter(gridViewAdapters);
                break;
            /**
             * 销量最高
             */
            case ACTION.SHOPBYSALES:
                loadingDialog.cancel();
                homeShopBySalesBean = GsonUtil.toObj(res, ShopListHomeBean.class);
                if (homeShopBySalesBean.isSuccess()) {
                    if (homeShopBySalesBean.getBody().getShopListData().size() > 0) {
                        shop_list_null.setVisibility(View.GONE);
                        li_shop_bottom.setVisibility(View.VISIBLE);
                        pageSum = homeShopBySalesBean.getBody().getShopListData().size();

                        loadMoreData(homeShopBySalesBean.getBody().getShopListData());
                    } else {
                        if(pageIndex == 0){
                            shop_list_null.setVisibility(View.VISIBLE);
                            li_shop_bottom.setVisibility(View.GONE);
                        }else{
                            shop_list_null.setVisibility(View.GONE);
                            li_shop_bottom.setVisibility(View.VISIBLE);
                        }

                        DisplayMetrics dm = getResources().getDisplayMetrics();
                        int heigth = dm.heightPixels;
                        RelativeLayout.LayoutParams gallery_lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, heigth);
                        shop_list_null.setLayoutParams(gallery_lp);
                        gridViewAdapter.Clear();
                        homeListViewAdapter.Clear();
                    }
                } else {
                    T.show(shopListHomeBean.getMsg());
                }
                break;
            //商家活动（筛选）
            case ACTION.MERCHANTACTIVITY:
                MerchantsBean merchantsBean = GsonUtil.toObj(res, MerchantsBean.class);
                if (merchantsBean.isSuccess()) {
                    merchantsList = merchantsBean.getBody().getActivityKeysListData();
                } else {
                    T.show(merchantsBean.getMsg());
                }
                break;
            //特色筛选
            case ACTION.MERCHANTFEATURES:
                PreferentialBean preferentialBean = GsonUtil.toObj(res, PreferentialBean.class);
                if (preferentialBean.isSuccess()) {
                    preferentialList = preferentialBean.getBody().getFeatureKeysListData();
                } else {
                    T.show(preferentialBean.getMsg());
                }
                break;
        }
    }

    private void initBannerOnClick(com.youth.banner.Banner banner) {
        banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                Intent intent = new Intent(getActivity(), HomeAdvertisingActivity.class);
                intent.putExtra("bannerId", bannerId.get(position));
                intent.putExtra("bannerStyle", styles.get(position));
                intent.putExtra("weburl", urls.get(position));
                intent.putExtra("bannerLogo", images.get(position));
                intent.putExtra("bannerTitle", titles.get(position));
                getActivity().startActivity(intent);
            }
        });
    }

    @Override
    public void showLoadingDialog() {

    }

    @Override
    public void showErrorMessage(String s) {

    }

    public void loadData(List<ShopListHomeBean.BodyBean.ShopListDataBean> apiOrderListMore){
        if(pageIndex == 0){
            gridViewAdapter.setmDate(shopListBeans);
            homeListViewAdapter.setmDate(shopListBeans);
        }else{
            gridViewAdapter.notifyDataSetChanged();
            homeListViewAdapter.notifyDataSetChanged();
        }
    }

    public void loadMoreData(List<ShopListHomeBean.BodyBean.ShopListDataBean> apiOrderListMore){

        if(shopListBeans == null){
            shopListBeans = new ArrayList<>();
        }
        if(pageIndex == 0){
            gridViewAdapter.Clear();
            homeListViewAdapter.Clear();
        }

        shopListBeans.addAll(apiOrderListMore);
        if(pageIndex == 0){
            gridViewAdapter.setmDate(shopListBeans);
            homeListViewAdapter.setmDate(shopListBeans);
        }else{
            gridViewAdapter.notifyDataSetChanged();
            homeListViewAdapter.notifyDataSetChanged();
        }
        pageIndex += Integer.parseInt(SpContent.pageSize);

    }

}
