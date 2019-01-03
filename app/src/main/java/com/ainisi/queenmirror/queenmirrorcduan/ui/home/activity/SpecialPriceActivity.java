package com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.bean.SpecialCommentBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.adapter.SpecialPriceGvAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean.HomeIndustryBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.fragment.SpecialBottomFragment;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.fragment.SpecialFragment;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SP;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpContent;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.ainisi.queenmirror.queenmirrorcduan.utils.DensityUtils;
import com.ainisi.queenmirror.queenmirrorcduan.utils.NoScrollGridView;
import com.google.zxing.WriterException;
import com.lzy.okgo.cache.CacheMode;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 特价区商品
 */

public class SpecialPriceActivity extends BaseNewActivity implements HttpCallBack {
    @Bind(R.id.li_special_sales)
    LinearLayout li_special_sales;
    SpecialFragment specialFragment;
    @Bind(R.id.title_back)
    ImageView title_back;
    @Bind(R.id.title_title)
    TextView title_title;
    @Bind(R.id.sc_special_top)
    ScrollView sc_special_top;
    @Bind(R.id.tab_special_distance)
    public TabLayout tab_special_distance;
    SpecialCommentBean specialCommentBean;
    @Bind(R.id.sc_special_top_img)
    ImageView mScSpecialTopImg;
    @Bind(R.id.sc_special_top_img2)
    ImageView mScSpecialTopImg2;
    @Bind(R.id.sc_special_top_img3)
    ImageView mScSpecialTopImg3;
    @Bind(R.id.fr_mine_special_view)
    View fr_mine_special_view;
    @Bind(R.id.li_special_gv)
    NoScrollGridView li_special_gv;
    private HomeIndustryBean homeIndustryBean;
    private FragmentManager manager;
    private FragmentTransaction transaction;
    private List<String> tabList = new ArrayList<>();
    int position;
    public static SpecialPriceActivity instance = null;
    private int mHeights;

    @Override
    protected int getLayoutId() {
        instance = this;
        return R.layout.activity_special_price;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void initView() {
        super.initView();
        title_title.setText("金秋变美计划");
        tab_special_distance.setTabMode(TabLayout.MODE_SCROLLABLE);
        WindowManager managers = this.getWindowManager();
        DisplayMetrics outMetrics = new DisplayMetrics();
        managers.getDefaultDisplay().getMetrics(outMetrics);
        ViewGroup.LayoutParams layoutParams = fr_mine_special_view.getLayoutParams();
        layoutParams.height = outMetrics.heightPixels - DensityUtils.dp2px(this, 48f) - DensityUtils.dp2px(this, 45f);
        fr_mine_special_view.setLayoutParams(layoutParams);
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        specialFragment = new SpecialFragment();
        transaction.add(R.id.fr_mine_special_price, specialFragment);
        transaction.commit();
        getCommentData();
        getBannerData();

        sc_special_top.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View view, int i, int i1, int i2, int i3) {
                mHeights = li_special_sales.getHeight() + mScSpecialTopImg.getHeight() + mScSpecialTopImg2.getHeight() + mScSpecialTopImg3.getHeight();
                if (i1 > mHeights) {
                    tab_special_distance.setVisibility(View.VISIBLE);
                } else {
                    tab_special_distance.setVisibility(View.GONE);
                }
            }
        });
        sc_special_top.smoothScrollTo(0, 0);
    }

    /**
     * 获取推荐商品
     */
    private void getCommentData() {
        HashMap<String, String> params = new HashMap<>();
        params.put("token", SP.get(this, SpContent.UserToken, "") + "");
        HttpUtils.doPost(ACTION.COMMENTSPECIAL, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    /**
     * 获取首页的行业分类
     */
    private void getBannerData() {
        HashMap<String, String> params = new HashMap<>();
        params.put("tabType", "2");//type  2代表美业    4代表异业
        params.put("tabFather", "0");
        params.put("token", SP.get(this, SpContent.UserToken, "") + "");
        HttpUtils.doPost(ACTION.INDUSTRY, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);//首页的行业分类
    }

    @Override
    public void onSuccess(int action, String res) throws WriterException {
        switch (action) {
            case ACTION.COMMENTSPECIAL:
                specialCommentBean = GsonUtil.toObj(res, SpecialCommentBean.class);
                if (specialCommentBean.isSuccess() && specialCommentBean.getErrorCode().equals("0")) {
                    final List<SpecialCommentBean.BodyBean.SpecialOfferGoodsRecommendedListBean> mList = specialCommentBean.getBody().getSpecialOfferGoodsRecommendedList();
                    SpecialPriceGvAdapter specialPriceGvAdapter = new SpecialPriceGvAdapter(SpecialPriceActivity.this, specialCommentBean.getBody().getSpecialOfferGoodsRecommendedList());
                    li_special_gv.setAdapter(specialPriceGvAdapter);
                    li_special_gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                            Intent intent = new Intent(SpecialPriceActivity.this, FullActivity.class);
                            intent.putExtra("goodsId", mList.get(i).getId());
                            intent.putExtra("shopId", mList.get(i).getShopId());
                            intent.putExtra("shopName", mList.get(i).getShopName());
                            intent.putExtra("number", "1");
                            intent.putExtra("shopLogo", mList.get(i).getGoodsThumb());
                            startActivity(intent);
                        }
                    });

                } else {
                    T.show(specialCommentBean.getMsg());
                }
                break;

            /**
             * 行业分类
             */
            case ACTION.INDUSTRY:
                homeIndustryBean = GsonUtil.toObj(res, HomeIndustryBean.class);
                if (homeIndustryBean.isSuccess() && homeIndustryBean.getErrorCode().equals("0")) {

                    if (homeIndustryBean.getBody() == null) {
                    } else {

                        tabList.add("全部");
                        for (int i = 0; i < homeIndustryBean.getBody().getCategoryListData().size(); i++) {
                            tabList.add(homeIndustryBean.getBody().getCategoryListData().get(i).getEcCategory().getTabName());
                        }

                        for (int i = 0; i < tabList.size(); i++) {
                            tab_special_distance.addTab(tab_special_distance.newTab().setText(tabList.get(i)));
                            TabLayout.Tab tab = tab_special_distance.getTabAt(i);
                            if (tab == null) return;
                            //这里使用到反射，拿到Tab对象后获取Class
                            Class c = tab.getClass();
                            try {
                                Field field = c.getDeclaredField("mView");
                                field.setAccessible(true);
                                final View view = (View) field.get(tab);
                                if (view == null) return;
                                view.setTag(i);
                                view.setOnClickListener(new View.OnClickListener() {

                                    @Override
                                    public void onClick(View v) {
                                        position = (int) view.getTag();
                                        SpecialFragment.instance.tabDistance.getTabAt(position).select();
                                        //这里就可以根据业务需求处理点击事件了。
                                        if (position == 0) {
                                            initshowdiscountFragment("");
                                        } else {
                                            initshowdiscountFragment(homeIndustryBean.getBody().getCategoryListData().get(position - 1).getEcCategory().getId());
                                        }
                                    }
                                });
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        setIndicator(tab_special_distance, 5, 5);
                        sc_special_top.smoothScrollTo(0, 0);
                    }
                } else {
                    T.show(homeIndustryBean.getMsg());
                }
                break;
        }
    }

    @OnClick({R.id.title_back})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;
        }
    }

    @Override
    public void showLoadingDialog() {

    }

    @Override
    public void showErrorMessage(String s) {

    }

    /**
     * fragment切换
     *
     * @param fragment       需要显示的Fragment
     * @param tag            Tag标签
     * @param addToBackStack 是否加入栈
     */
    public void replaceFragment(Fragment fragment, String tag, boolean addToBackStack) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fr_mine_special_price, fragment, tag);
        if (addToBackStack) {
            fragmentTransaction.addToBackStack(null);
        }
        fragmentTransaction.commit();
    }

    /**
     * 解决重影问题
     *
     * @param savedInstanceState
     */
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        //super.onRestoreInstanceState(savedInstanceState);
    }

    public void initshowdiscountFragment(String sumber) {
        manager = this.getSupportFragmentManager();
        transaction = manager.beginTransaction();
        SpecialBottomFragment historydiscountFragment = new SpecialBottomFragment();
        Bundle bundle = new Bundle();
        bundle.putString("position", sumber);
        historydiscountFragment.setArguments(bundle);
        transaction.replace(R.id.frame_discount, historydiscountFragment);
        transaction.commit();
    }


    public void setIndicator(TabLayout tabs, int leftDip, int rightDip) {
        Class<?> tabLayout = tabs.getClass();
        Field tabStrip = null;
        try {
            tabStrip = tabLayout.getDeclaredField("mTabStrip");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        tabStrip.setAccessible(true);
        LinearLayout llTab = null;
        try {
            llTab = (LinearLayout) tabStrip.get(tabs);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        int left = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, leftDip, Resources.getSystem().getDisplayMetrics());
        int right = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, rightDip, Resources.getSystem().getDisplayMetrics());
        for (int i = 0; i < llTab.getChildCount(); i++) {
            View child = llTab.getChildAt(i);
            child.setPadding(0, 0, 0, 0);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 1);
            params.leftMargin = left;
            params.rightMargin = right;
            child.setLayoutParams(params);
            child.invalidate();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
