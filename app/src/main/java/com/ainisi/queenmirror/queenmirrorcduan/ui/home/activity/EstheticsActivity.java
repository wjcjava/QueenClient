package com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ainisi.queenmirror.common.base.BaseActivity;
import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.EstheticsAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.FullShortAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.HomepageNearBean;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.bean.EstheticsBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.HomepageNearByBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.Homepagebean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.ProblemBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.ShopListHomeBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean.MerchantsBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean.PreferentialBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.shop.activity.WorkRoomDetailActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.user.LoginActivity;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.LoadingDialog;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SP;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpContent;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.john.library.PopWindowHome;
import com.lzy.okgo.cache.CacheMode;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 美学汇（美甲美手）
 */
public class EstheticsActivity extends BaseActivity implements HttpCallBack {
    @Bind(R.id.re_recommendable_projects)
    RecyclerView reProjects;
    @Bind(R.id.full_rb_screen)
    TextView hscreen;
    @Bind(R.id.newtitle_title)
    TextView newtitle_title;
    private PopupWindow pop;
    List<EstheticsBean.BodyBean.ShopListBean> apiShopList = new ArrayList<>();
    private List<ProblemBean> list = new ArrayList<>();
    String[] problem = {"销量最高", "价格最低", "距离最近", "优惠最多", "满减优惠", "新用最好", "用户最好"};
    String shop_name, categoryId;
    public int pageNumber = 1;
    public int pageIndex = 0;
    int pageSum = 0;
    private List<MerchantsBean.BodyBean.ActivityKeysListDataBean> merchantsList;
    private List<PreferentialBean.BodyBean.FeatureKeysListDataBean> preferentialList;
    @Bind(R.id.full_sore_recycler)
    RecyclerView full_sore_recycler;
    List<ShopListHomeBean.BodyBean.ShopListDataBean> sortlist = new ArrayList<>();
    @Bind(R.id.esthetrics_refreshLayout)
    SmartRefreshLayout esthetrics_refreshLayout;
    FullShortAdapter sortAdapter_mal;
    @Bind(R.id.li_esthetics_nearshop)
    LinearLayout li_esthetics_nearshop;
    ListView rv_nearlist_right;
    HomepageNearBean sortAdapter2;
    List<HomepageNearByBean> home_string = new ArrayList<>();
    List<Homepagebean.BodyBean.DistrictListDataBean> DistrictListData;
    ShopListHomeBean homeShopBySalesBean;
    public PopWindowHome popWindowHomes;
    @Bind(R.id.iv_esthetics_near_sort)
    ImageView iv_esthetics_near_sort;
    @Bind(R.id.full_esthetics_rb_sales)
    TextView full_esthetics_rb_sales;
    @Bind(R.id.li_esthetics_zonghe)
    LinearLayout li_esthetics_zonghe;
    @Bind(R.id.iv_esthetics_distance)
    ImageView iv_esthetics_distance;
    @Bind(R.id.full_esthetics_distance)
    TextView full_esthetics_distance;
    @Bind(R.id.li_esthetics_shaixuan)
    LinearLayout li_esthetics_shaixuan;
    @Bind(R.id.bt_esthetics_up_home)
    public TextView bt_esthetics_up_home;
    @Bind(R.id.rl_esthet_search)
    RelativeLayout rl_esthet_search;
    ShopListHomeBean shopListHomeBean;
    @Bind(R.id.shop_list_null)
    RelativeLayout shop_list_null;
    public static EstheticsActivity instance = null;
    LoadingDialog loadingDialog;
    String cpCate="1";
    String cond="";
    public String distance = "1",distance_code = "1";
    public int input_where = 0;
    int zonghe_where = 0;

    @Override
    public int getLayoutId() {
        instance = this;
        return R.layout.activity_esthetics;
    }

    @Override
    public void initPresenter() {
    }

    /**
     * 获取筛选的值
     */
    private void getSelectData() {
        loadingDialog.loadShow();
        HashMap<String, String> parames = new HashMap<>();
        parames.put("token", SP.get(EstheticsActivity.this,SpContent.UserToken,"")+"");
        parames.put("cityCode",SP.get(EstheticsActivity.this,SpContent.CityCode,"")+"");
        parames.put("pageNumber",pageNumber+"");
        parames.put("pageSize",SpContent.pageSize);
        parames.put("contentByTitle","");
        parames.put("shopCate",cpCate);
        parames.put("goodsCate",categoryId);
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
            case ACTION.GETDATABYSHAIXUAN:
                loadingDialog.cancel();
                homeShopBySalesBean = GsonUtil.toObj(res, ShopListHomeBean.class);
                if(homeShopBySalesBean.getErrorCode().equals("6")){
                    T.show("您的账号已过期，请重新登录");
                    Intent intent = new Intent(this, LoginActivity.class);
                    intent.putExtra("activite","no");
                    startActivity(intent);
                }else {
                    if (homeShopBySalesBean.isSuccess()) {
                        if (homeShopBySalesBean.getBody().getShopListData().size() > 0) {
                            shop_list_null.setVisibility(View.GONE);
                            pageSum = homeShopBySalesBean.getBody().getShopListData().size();
                            loadMoreData(homeShopBySalesBean.getBody().getShopListData());

                        } else {
                            T.show("暂无店铺信息");

                            if(pageIndex == 0){
                                shop_list_null.setVisibility(View.VISIBLE);
                            }else{
                                shop_list_null.setVisibility(View.GONE);
                            }

                            DisplayMetrics dm = getResources().getDisplayMetrics();
                            int heigth = dm.heightPixels;
                            RelativeLayout.LayoutParams gallery_lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, heigth);
                            shop_list_null.setLayoutParams(gallery_lp);
                            sortAdapter_mal.Clear();
                        }
                    } else {
                    }
                }
                break;
            /**
             * 销量最高列表
             */
            case ACTION.SHOPBYSALES:
                loadingDialog.cancel();
                homeShopBySalesBean = GsonUtil.toObj(res, ShopListHomeBean.class);
                if(homeShopBySalesBean.getErrorCode().equals("6")){
                    T.show("您的账号已过期，请重新登录");
                    Intent intent = new Intent(this, LoginActivity.class);
                    intent.putExtra("activite","no");
                    startActivity(intent);
                }else {
                    if (homeShopBySalesBean.isSuccess()) {
                        if (homeShopBySalesBean.getBody().getShopListData().size() > 0) {
                            shop_list_null.setVisibility(View.GONE);
                            pageSum = homeShopBySalesBean.getBody().getShopListData().size();
                            loadMoreData(homeShopBySalesBean.getBody().getShopListData());

                        } else {
                            T.show("暂无店铺信息");

                            if(pageIndex == 0){
                                shop_list_null.setVisibility(View.VISIBLE);
                            }else{
                                shop_list_null.setVisibility(View.GONE);
                            }

                            DisplayMetrics dm = getResources().getDisplayMetrics();
                            int heigth = dm.heightPixels;
                            RelativeLayout.LayoutParams gallery_lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, heigth);
                            shop_list_null.setLayoutParams(gallery_lp);
                            sortAdapter_mal.Clear();
                        }
                    } else {
                    }
                }
                break;
            /**
             * 根据区域选择
             */
            case ACTION.SHOPLISTBYAREANEAR:
                loadingDialog.cancel();
                homeShopBySalesBean = GsonUtil.toObj(res, ShopListHomeBean.class);
                if(homeShopBySalesBean.getErrorCode().equals("6")){
                    T.show("您的账号已过期，请重新登录");
                    Intent intent = new Intent(this, LoginActivity.class);
                    intent.putExtra("activite","no");
                    startActivity(intent);
                }else {
                    if (homeShopBySalesBean.isSuccess()) {
                        if (homeShopBySalesBean.getBody().getShopListData().size() > 0) {
                            shop_list_null.setVisibility(View.GONE);
                            pageSum = homeShopBySalesBean.getBody().getShopListData().size();
                            loadMoreData(homeShopBySalesBean.getBody().getShopListData());
                        } else {
                            if(pageIndex == 0){
                                shop_list_null.setVisibility(View.VISIBLE);
                            }else{
                                shop_list_null.setVisibility(View.GONE);
                            }

                            DisplayMetrics dm = getResources().getDisplayMetrics();
                            int heigth = dm.heightPixels;
                            RelativeLayout.LayoutParams gallery_lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, heigth);
                            shop_list_null.setLayoutParams(gallery_lp);
                            sortAdapter_mal.Clear();
                        }
                    } else {
                    }
                }
                break;
            /**
             * 根据距离排序
             */
            case ACTION.SHOPLISTBYDISTANCE:
                loadingDialog.cancel();
                homeShopBySalesBean = GsonUtil.toObj(res, ShopListHomeBean.class);
                if(homeShopBySalesBean.getErrorCode().equals("6")){
                    T.show("您的账号已过期，请重新登录");
                    Intent intent = new Intent(this, LoginActivity.class);
                    intent.putExtra("activite","no");
                    startActivity(intent);
                }else {
                    if (homeShopBySalesBean.isSuccess()) {
                        if (homeShopBySalesBean.getBody().getShopListData().size() > 0) {
                            shop_list_null.setVisibility(View.GONE);
                            pageSum = homeShopBySalesBean.getBody().getShopListData().size();
                            loadMoreData(homeShopBySalesBean.getBody().getShopListData());

                        } else {
                            if(pageIndex == 0){
                                shop_list_null.setVisibility(View.VISIBLE);
                            }else{
                                shop_list_null.setVisibility(View.GONE);
                            }

                            DisplayMetrics dm = getResources().getDisplayMetrics();
                            int heigth = dm.heightPixels;
                            RelativeLayout.LayoutParams gallery_lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, heigth);
                            shop_list_null.setLayoutParams(gallery_lp);
                            sortAdapter_mal.Clear();
                        }
                    } else {
                    }
                }
                break;
            /**
             * 点击评分从高到低排序
             */
            case ACTION.SHOPLISTBYSOCORE:
                loadingDialog.cancel();
                homeShopBySalesBean = GsonUtil.toObj(res, ShopListHomeBean.class);
                if(homeShopBySalesBean.getErrorCode().equals("6")){
                    T.show("您的账号已过期，请重新登录");
                    Intent intent = new Intent(this, LoginActivity.class);
                    intent.putExtra("activite","no");
                    startActivity(intent);
                }else {
                    if (homeShopBySalesBean.isSuccess()) {
                        if (homeShopBySalesBean.getBody().getShopListData().size() > 0) {
                            shop_list_null.setVisibility(View.GONE);
                            pageSum = homeShopBySalesBean.getBody().getShopListData().size();
                            loadMoreData(homeShopBySalesBean.getBody().getShopListData());
                        } else {
                            if(pageIndex == 0){
                                shop_list_null.setVisibility(View.VISIBLE);
                            }else{
                                shop_list_null.setVisibility(View.GONE);
                            }
                            DisplayMetrics dm = getResources().getDisplayMetrics();
                            int heigth = dm.heightPixels;
                            RelativeLayout.LayoutParams gallery_lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, heigth);
                            shop_list_null.setLayoutParams(gallery_lp);
                            sortAdapter_mal.Clear();
                        }
                    } else {
                    }
                }
                break;
            /**
             * 点击浏览量从高到低排序
             */
            case ACTION.SHOPLISTBYLOOK:
                loadingDialog.cancel();
                homeShopBySalesBean = GsonUtil.toObj(res, ShopListHomeBean.class);
                if(homeShopBySalesBean.getErrorCode().equals("6")){
                    T.show("您的账号已过期，请重新登录");
                    Intent intent = new Intent(this, LoginActivity.class);
                    intent.putExtra("activite","no");
                    startActivity(intent);
                }else {
                    if (homeShopBySalesBean.isSuccess()) {
                        if (homeShopBySalesBean.getBody().getShopListData().size() > 0) {
                            shop_list_null.setVisibility(View.GONE);
                            pageSum = homeShopBySalesBean.getBody().getShopListData().size();
                            loadMoreData(homeShopBySalesBean.getBody().getShopListData());

                        } else {
                            if(pageIndex == 0){
                                shop_list_null.setVisibility(View.VISIBLE);
                            }else{
                                shop_list_null.setVisibility(View.GONE);
                            }
                            DisplayMetrics dm = getResources().getDisplayMetrics();
                            int heigth = dm.heightPixels;
                            RelativeLayout.LayoutParams gallery_lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, heigth);
                            shop_list_null.setLayoutParams(gallery_lp);
                            sortAdapter_mal.Clear();
                        }
                    } else {
                    }
                }
                break;
            /**
             * 点击获取综合排序列表
             */
            case ACTION.SHOPLISTBYZONGHE:
                loadingDialog.cancel();
                homeShopBySalesBean = GsonUtil.toObj(res, ShopListHomeBean.class);
                if(homeShopBySalesBean.getErrorCode().equals("6")){
                    T.show("您的账号已过期，请重新登录");
                    Intent intent = new Intent(this, LoginActivity.class);
                    intent.putExtra("activite","no");
                    startActivity(intent);
                }else {
                    if (homeShopBySalesBean.isSuccess()) {
                        if (homeShopBySalesBean.getBody().getShopListData().size() > 0) {
                            shop_list_null.setVisibility(View.GONE);
                            pageSum = homeShopBySalesBean.getBody().getShopListData().size();
                            loadMoreData(homeShopBySalesBean.getBody().getShopListData());

                        } else {
                            if(pageIndex == 0){
                                shop_list_null.setVisibility(View.VISIBLE);
                            }else{
                                shop_list_null.setVisibility(View.GONE);
                            }
                            DisplayMetrics dm = getResources().getDisplayMetrics();
                            int heigth = dm.heightPixels;
                            RelativeLayout.LayoutParams gallery_lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, heigth);
                            shop_list_null.setLayoutParams(gallery_lp);
                            sortAdapter_mal.Clear();
                        }
                    } else {
                    }
                }
                break;
            /**
             * 根据Citycode获取区域
             */
            case ACTION.SHOPLISTBYAREACODE:
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
                        sortAdapter2 = new HomepageNearBean(EstheticsActivity.this, home_string, "6");
                        rv_nearlist_right.setAdapter(sortAdapter2);
                        sortAdapter2.notifyDataSetChanged();
                    } else {
                    }
                break;
            /**
             * 推荐好店
             */
            case ACTION.MERCHANTSLIST:
                loadingDialog.cancel();
                final EstheticsBean estheticsBean = GsonUtil.toObj(res, EstheticsBean.class);
                if(estheticsBean.getErrorCode().equals("6")){
                    T.show("您的账号已过期，请重新登录");
                    Intent intent = new Intent(this, LoginActivity.class);
                    intent.putExtra("activite","no");
                    startActivity(intent);
                }else {
                    if (estheticsBean.isSuccess()) {

                        EstheticsAdapter sortAdapter = new EstheticsAdapter(EstheticsActivity.this, R.layout.item_recycler_waterfalls, estheticsBean.getBody().getShopList());
                        reProjects.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
                        reProjects.setAdapter(sortAdapter);

                        sortAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                            @Override
                            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                                Intent intent = new Intent(EstheticsActivity.this, WorkRoomDetailActivity.class);
                                intent.putExtra("shopName", estheticsBean.getBody().getShopList().get(position).getAnsShopBasic().getShopName());
                                intent.putExtra("shopId", estheticsBean.getBody().getShopList().get(position).getAnsShopBasic().getId());
                                intent.putExtra("cpCate", cpCate);
                                startActivity(intent);
                            }
                        });
                    } else {
                    }
                }
                break;
            //商家活动（筛选）
            case ACTION.MERCHANTACTIVITY:
                loadingDialog.cancel();
                MerchantsBean merchantsBean = GsonUtil.toObj(res, MerchantsBean.class);
                if(merchantsBean.getErrorCode().equals("6")){
                    T.show("您的账号已过期，请重新登录");
                    Intent intent = new Intent(this, LoginActivity.class);
                    intent.putExtra("activite","no");
                    startActivity(intent);
                }else {
                    if (merchantsBean.isSuccess()) {
                        merchantsList = merchantsBean.getBody().getActivityKeysListData();
                    } else {
                    }
                }
                break;
            //商家特色（筛选）
            case ACTION.MERCHANTFEATURES:
                loadingDialog.cancel();
                PreferentialBean preferentialBean = GsonUtil.toObj(res, PreferentialBean.class);
                if(preferentialBean.getErrorCode().equals("6")){
                    T.show("您的账号已过期，请重新登录");
                    Intent intent = new Intent(this, LoginActivity.class);
                    intent.putExtra("activite","no");
                    startActivity(intent);
                }else {
                    if (preferentialBean.isSuccess()) {
                        preferentialList = preferentialBean.getBody().getFeatureKeysListData();
                    } else {
                    }
                }
                break;
            case ACTION.CLASSIFICATION:
                loadingDialog.cancel();
                shopListHomeBean = GsonUtil.toObj(res, ShopListHomeBean.class);
                if(shopListHomeBean.getErrorCode().equals("6")){
                    T.show("您的账号已过期，请重新登录");
                    Intent intent = new Intent(this, LoginActivity.class);
                    intent.putExtra("activite","no");
                    startActivity(intent);
                }else {
                    if (shopListHomeBean.isSuccess()) {

                        if (shopListHomeBean.getBody().getShopListData().size() > 0) {
                            shop_list_null.setVisibility(View.GONE);
                            pageSum = shopListHomeBean.getBody().getShopListData().size();
                            loadMoreData(shopListHomeBean.getBody().getShopListData());
                        } else {
                            if(pageIndex == 0){
                                shop_list_null.setVisibility(View.VISIBLE);
                            }else{
                                shop_list_null.setVisibility(View.GONE);
                            }
                            DisplayMetrics dm = getResources().getDisplayMetrics();
                            int heigth = dm.heightPixels;
                            RelativeLayout.LayoutParams gallery_lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, heigth);
                            shop_list_null.setLayoutParams(gallery_lp);
                            sortAdapter_mal.Clear();
                        }
                    } else {
                    }
                }
        }
    }

    @Override
    public void initView() {
        loadingDialog = new LoadingDialog(EstheticsActivity.this);
        Intent intent = this.getIntent();
        shop_name = intent.getStringExtra("shop_name");
        cpCate = intent.getStringExtra("cpCate");
        newtitle_title.setText(shop_name);
        categoryId = intent.getStringExtra("categoryId");

        sortAdapter_mal = new FullShortAdapter(this, R.layout.item_shortrecycler, sortlist);
        full_sore_recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        full_sore_recycler.setAdapter(sortAdapter_mal);

        esthetrics_refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                pageNumber = 1;
                pageIndex = 0;
                /**
                 * 获取首页部分数据
                 */
                getTuijianData();
                inithttp();

                if(input_where == 0){
                    inithttpshop();
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

                refreshlayout.finishRefresh(2000);
            }
        });
        esthetrics_refreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {

                if(pageSum < Integer.parseInt(SpContent.pageSize)){
                    refreshlayout.finishLoadmore(2000);
                    T.show("您已加载完全部数据");
                }else{
                    pageNumber++;

                    if(input_where == 0){
                        inithttpshop();
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


        getTuijianData();
        inithttp();
        inithttpshop();
    }

    /**
     * 获取列表数据
     */
    private void inithttpshop() {
        loadingDialog.loadShow();
        HashMap<String, String> params = new HashMap<>();
        params.put("pageNumber", pageNumber+"");
        params.put("contentByTitle", "");
        params.put("categoryId", categoryId);
        params.put("pageSize", SpContent.pageSize);
        params.put("shopCate", cpCate);
        params.put("cityCode",SP.get(EstheticsActivity.this,SpContent.CityCode,"0512")+"");
        params.put("token",SP.get(EstheticsActivity.this,SpContent.UserToken,"")+"");
        HttpUtils.doPost(ACTION.CLASSIFICATION, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    /**
     * 获取推荐好店的数据
     */
    private void getTuijianData() {
        HashMap<String, String> hashMap = new HashMap();
        hashMap.put("categoryId", categoryId);
        hashMap.put("pageNumber", pageNumber + "");
        hashMap.put("pageSize", SpContent.pageSize);
        hashMap.put("cityCode",SP.get(EstheticsActivity.this,SpContent.CityCode,"0512")+"");
        hashMap.put("shopCate", cpCate);
        hashMap.put("token",SP.get(EstheticsActivity.this,SpContent.UserToken,"")+"");
        HttpUtils.doPost(ACTION.MERCHANTSLIST, hashMap, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    private void inithttp() {
        HashMap<String, String> parames = new HashMap<>();
        parames.put("", "");
        //商家活动（筛选）
        HttpUtils.doPost(ACTION.MERCHANTACTIVITY, parames, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
        //商家特色（筛选）
        HttpUtils.doPost(ACTION.MERCHANTFEATURES, parames, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }


    @OnClick({R.id.ed_keyword, R.id.iv_back, R.id.full_rb_screen, R.id.tv_more,R.id.li_esthetics_nearshop
            ,R.id.full_esthetics_rb_sales,R.id.li_esthetics_zonghe,R.id.li_esthetics_shaixuan,R.id.rl_esthet_search})
    public void click(View view) {
        switch (view.getId()) {
            case R.id.rl_esthet_search:
                Intent intent = new Intent(EstheticsActivity.this,SearchActivity.class);
                intent.putExtra("shopCate","1");
                startActivity(intent);
                break;
            /**
             * 筛选
             */
            case R.id.li_esthetics_shaixuan:
            case R.id.full_rb_screen:
                input_where = 4;
                /**
                 * 设置商家文字
                 */
                //设置附近商家
                bt_esthetics_up_home.setTextColor(this.getResources().getColor(R.color.alpha_55_black));
                TextPaint tp41 = bt_esthetics_up_home.getPaint();
                tp41.setFakeBoldText(false);
                //设置销量文字
                full_esthetics_rb_sales.setTextColor(this.getResources().getColor(R.color.alpha_55_black));
                TextPaint tpsa41 = full_esthetics_rb_sales.getPaint();
                tpsa41.setFakeBoldText(false);
                //设置综合排序
                full_esthetics_distance.setTextColor(this.getResources().getColor(R.color.alpha_55_black));
                TextPaint tpsd41 = full_esthetics_distance.getPaint();
                tpsd41.setFakeBoldText(false);
                //筛选
                hscreen.setTextColor(this.getResources().getColor(R.color.alpha_95_black));
                TextPaint tpscre41 = hscreen.getPaint();
                tpscre41.setFakeBoldText(true);

                View customView = View.inflate(EstheticsActivity.this, R.layout.pop_screening, null);
                final PopWindowHome popWindowHomesd = new PopWindowHome.Builder(EstheticsActivity.this)
                        .setStyle(PopWindowHome.PopWindowStyle.PopDown)
                        .setView(customView)
                        .show(li_esthetics_shaixuan);//show里面的内容是显示在空间下方的控件

               /* TextView tv_cancel = customView.findViewById(R.id.tv_cancel);
                tv_cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        popWindowHomesd.dismiss();
                    }
                });
                TextView tv_submit = customView.findViewById(R.id.tv_submit);
                tv_submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        popWindowHomesd.dismiss();
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
                        tv_home_queen.setBackground(EstheticsActivity.this.getDrawable(R.drawable.button_home_tese_select));
                        tv_home_queen.setTextColor(EstheticsActivity.this.getResources().getColor(R.color.white));
                    }
                });
                final TextView tv_home_first = customView.findViewById(R.id.tv_home_first);
                final TextView tv_home_second = customView.findViewById(R.id.tv_home_second);

                tv_home_first.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        cond = "1";
                        tv_home_first.setBackground(EstheticsActivity.this.getDrawable(R.drawable.button_home_tese_select));
                        tv_home_first.setTextColor(EstheticsActivity.this.getResources().getColor(R.color.white));
                        tv_home_second.setBackground(EstheticsActivity.this.getDrawable(R.drawable.button_home_tese));
                        tv_home_second.setTextColor(EstheticsActivity.this.getResources().getColor(R.color.alpha_65_black));
                    }
                });

                tv_home_second.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        cond = "2";
                        tv_home_second.setBackground(EstheticsActivity.this.getDrawable(R.drawable.button_home_tese_select));
                        tv_home_second.setTextColor(EstheticsActivity.this.getResources().getColor(R.color.white));
                        tv_home_first.setBackground(EstheticsActivity.this.getDrawable(R.drawable.button_home_tese));
                        tv_home_first.setTextColor(EstheticsActivity.this.getResources().getColor(R.color.alpha_65_black));
                    }
                });

*/
                break;
            //搜索
            case R.id.ed_keyword:
                SearchActivity.startActivity(this);
                break;
            case R.id.iv_back:
                finish();
                break;
            //更多
            case R.id.tv_more:
                Intent intent1 = new Intent(this,RecommendedActivity.class);
                intent1.putExtra("categoryId",categoryId);
                startActivity(intent1);
                break;
            /**
             * 点击综合排序
             */
            case R.id.li_esthetics_zonghe:
                input_where = 3;
                /**
                 * 设置商家文字
                 */
                //设置附近商家
                bt_esthetics_up_home.setTextColor(this.getResources().getColor(R.color.alpha_55_black));
                TextPaint tp31 = bt_esthetics_up_home.getPaint();
                tp31.setFakeBoldText(false);
                //设置销量文字
                full_esthetics_rb_sales.setTextColor(this.getResources().getColor(R.color.alpha_55_black));
                TextPaint tpsa31 = full_esthetics_rb_sales.getPaint();
                tpsa31.setFakeBoldText(false);
                //设置综合排序
                full_esthetics_distance.setTextColor(this.getResources().getColor(R.color.alpha_95_black));
                TextPaint tpsd31 = full_esthetics_distance.getPaint();
                tpsd31.setFakeBoldText(true);
                //筛选
                hscreen.setTextColor(this.getResources().getColor(R.color.alpha_55_black));
                TextPaint tpscre31 = hscreen.getPaint();
                tpscre31.setFakeBoldText(false);


                View customViewn = View.inflate(EstheticsActivity.this, R.layout.home_bottom_zonghe, null);
                final PopWindowHome popWindowHome = new PopWindowHome.Builder(EstheticsActivity.this)
                        .setStyle(PopWindowHome.PopWindowStyle.PopDown)
                        .setView(customViewn)
                        .setControlViewAnim(iv_esthetics_distance, R.anim.btn_rotate_anim_1, R.anim.btn_rotate_anim_2, true)
                        .show(li_esthetics_zonghe);//show里面的内容是显示在空间下方的控件
                /**
                 * 点击综合排序
                 */
                TextView tv_bottom_zonghe = customViewn.findViewById(R.id.tv_bottom_zonghe);
                tv_bottom_zonghe.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        full_esthetics_distance.setText("综合排序");
                        pageIndex = 0;
                        pageNumber = 1;
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
                        full_esthetics_distance.setText("评分从高到低");
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

                        full_esthetics_distance.setText("浏览量从高到低");
                        getLookPaixuData();

                        popWindowHome.dismiss();
                    }
                });

                break;
            /**
             * 销量最高
             */
            case R.id.full_esthetics_rb_sales:


                /**
                 * 设置商家文字
                 */
                //设置附近商家
                bt_esthetics_up_home.setTextColor(this.getResources().getColor(R.color.alpha_55_black));
                TextPaint tp1 = bt_esthetics_up_home.getPaint();
                tp1.setFakeBoldText(false);
                //设置销量文字
                full_esthetics_rb_sales.setTextColor(this.getResources().getColor(R.color.alpha_95_black));
                TextPaint tpsa01 = full_esthetics_rb_sales.getPaint();
                tpsa01.setFakeBoldText(true);
                //设置综合排序
                full_esthetics_distance.setTextColor(this.getResources().getColor(R.color.alpha_55_black));
                TextPaint tpsd01 = full_esthetics_distance.getPaint();
                tpsd01.setFakeBoldText(false);
                //筛选
                hscreen.setTextColor(this.getResources().getColor(R.color.alpha_55_black));
                TextPaint tpscre01 = hscreen.getPaint();
                tpscre01.setFakeBoldText(false);


                pageIndex = 0;
                pageNumber = 1;
                input_where = 2;

                /**
                 * 获取销量数据
                 */
                getSalesData();
                break;
            /**
             * 附近店铺
             */
            case R.id.li_esthetics_nearshop:
                input_where = 1;

                /**
                 * 设置商家文字
                 */
                //设置附近商家
                bt_esthetics_up_home.setTextColor(this.getResources().getColor(R.color.alpha_95_black));
                TextPaint tp = bt_esthetics_up_home.getPaint();
                tp.setFakeBoldText(true);
                //设置销量文字
                full_esthetics_rb_sales.setTextColor(this.getResources().getColor(R.color.alpha_55_black));
                TextPaint tpsa = full_esthetics_rb_sales.getPaint();
                tpsa.setFakeBoldText(false);
                //设置综合排序
                full_esthetics_distance.setTextColor(this.getResources().getColor(R.color.alpha_55_black));
                TextPaint tpsd = full_esthetics_distance.getPaint();
                tpsd.setFakeBoldText(false);
                //筛选
                hscreen.setTextColor(this.getResources().getColor(R.color.alpha_55_black));
                TextPaint tpscre = hscreen.getPaint();
                tpscre.setFakeBoldText(false);


                View customViews = View.inflate(EstheticsActivity.this, R.layout.homepage_near_list_bottom, null);
                popWindowHomes = new PopWindowHome.Builder(EstheticsActivity.this)
                        .setStyle(PopWindowHome.PopWindowStyle.PopDown)
                        .setView(customViews)
                        .setControlViewAnim(iv_esthetics_near_sort, R.anim.btn_rotate_anim_1, R.anim.btn_rotate_anim_2, true)
                        .show(li_esthetics_nearshop);//show里面的内容是显示在空间下方的控件

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
                sortAdapter2 = new HomepageNearBean(EstheticsActivity.this, list_one,"5");
                rv_nearlist_right.setAdapter(sortAdapter2);

                tv_near_list_other.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        tv_near_list_fujin.setTextColor(EstheticsActivity.this.getResources().getColor(R.color.alpha_75_black));
                        tv_near_list_other.setTextColor(EstheticsActivity.this.getResources().getColor(R.color.alpha_violet));

                        getDistanceByCode();
                    }
                });
                tv_near_list_fujin.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        tv_near_list_fujin.setTextColor(EstheticsActivity.this.getResources().getColor(R.color.alpha_violet));
                        tv_near_list_other.setTextColor(EstheticsActivity.this.getResources().getColor(R.color.alpha_75_black));

                        List<HomepageNearByBean> list_one = new ArrayList<>();
                        String[] strings = {"附近（智能距离）","1千米","3千米","5千米","10千米"};

                        for(int i=0;i<4;i++){
                            HomepageNearByBean homepageNearBean = new HomepageNearByBean();
                            homepageNearBean.setId(""+i);
                            homepageNearBean.setName(strings[i]);

                            list_one.add(homepageNearBean);
                        }
                        sortAdapter2.Clear();
                        sortAdapter2 = new HomepageNearBean(EstheticsActivity.this, list_one,"5");
                        rv_nearlist_right.setAdapter(sortAdapter2);
                        sortAdapter2.notifyDataSetChanged();
                    }
                });
                break;

            default:
                break;
        }
    }
    @Override
    public void showLoadingDialog() {

    }
    @Override
    public void showErrorMessage(String s) {

    }
    public void loadMoreData(List<ShopListHomeBean.BodyBean.ShopListDataBean> apiOrderListMore){

        if(sortlist == null){
            sortlist = new ArrayList<>();
        }
        if(pageIndex == 0){
            sortAdapter_mal.Clear();
        }
        sortlist.addAll(apiOrderListMore);
        if(pageIndex == 0){
            sortAdapter_mal.setmDate(sortlist);
        }else{
            sortAdapter_mal.notifyDataSetChanged();
        }
        pageIndex += Integer.parseInt(SpContent.pageSize);
    }

    /**
     * 根据区域号获取区域
     */
    private void getDistanceByCode() {
        HashMap<String, String> parames = new HashMap<>();
        parames.put("code", SP.get(EstheticsActivity.this,SpContent.CityCode,"0512")+"");
        parames.put("token",SP.get(EstheticsActivity.this,SpContent.UserToken,"")+"");
        HttpUtils.doPost(ACTION.SHOPLISTBYAREACODE, parames, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    /**
     * 获取销量最高数据
     */
    private void getSalesData() {
        loadingDialog.loadShow();
        HashMap<String, String> params = new HashMap<>();
        params.put("pageNumber", pageNumber+"");
        params.put("contentByTitle", "");
        params.put("shopCate",cpCate);
        params.put("pageSize",SpContent.pageSize);
        params.put("goodsCate",categoryId);
        params.put("cityCode",SP.get(EstheticsActivity.this,SpContent.CityCode,"0512")+"");
        HttpUtils.doPost(ACTION.SHOPBYSALES, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    /**
     * 点击综合排序
     */
    private void getZonghePaixuData() {
        loadingDialog.loadShow();
        HashMap<String, String> parames = new HashMap<>();
        parames.put("pageNumber",pageNumber+"");
        parames.put("contentByTitle","");
        parames.put("shopCate",cpCate);
        parames.put("goodsCate",categoryId);
        parames.put("cityCode", SP.get(EstheticsActivity.this,SpContent.CityCode,"0512")+"");
        parames.put("pageSize",SpContent.pageSize);
        HttpUtils.doPost(ACTION.SHOPLISTBYZONGHE, parames, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    /**
     * 点击评分从高到低排序
     */
    private  void  getScorePaixuData(){
        loadingDialog.loadShow();
        HashMap<String, String> parames = new HashMap<>();
        parames.put("pageNumber",pageNumber+"");
        parames.put("contentByTitle","");
        parames.put("shopCate",cpCate);
        parames.put("goodsCate",categoryId);
        parames.put("cityCode", SP.get(EstheticsActivity.this,SpContent.CityCode,"0512")+"");
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
        parames.put("shopCate",cpCate);
        parames.put("goodsCate",categoryId);
        parames.put("cityCode", SP.get(EstheticsActivity.this,SpContent.CityCode,"0512")+"");
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
        parames.put("shopCate",cpCate);
        parames.put("goodsCate",categoryId);
        parames.put("pageSize",SpContent.pageSize);
        parames.put("geoX",SP.get(EstheticsActivity.this,SpContent.UserLat,"0")+"");
        parames.put("geoY",SP.get(EstheticsActivity.this,SpContent.UserLon,"0")+"");
        parames.put("distanceScope",distance);
        parames.put("cityCode",SP.get(EstheticsActivity.this,SpContent.CityCode,"0512")+"");
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
        parames.put("shopCate",cpCate);
        parames.put("goodsCate",categoryId);
        parames.put("districtId",districtId);
        parames.put("pageSize",SpContent.pageSize);
        HttpUtils.doPost(ACTION.SHOPLISTBYAREANEAR, parames, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }
}