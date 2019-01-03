package com.ainisi.queenmirror.queenmirrorcduan.ui.home.fragment;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;

import com.ainisi.queenmirror.common.base.BaseFragment;
import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.SpecialPriceActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean.HomeIndustryBean;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SP;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpContent;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.google.zxing.WriterException;
import com.lzy.okgo.cache.CacheMode;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.Bind;

/**
 * Created by john on 2018/9/4.
 *
 * 特价专区
 *
 * jl
 */

public class SpecialFragment extends BaseFragment implements HttpCallBack{

    private List<String> tabList = new ArrayList<>();
    @Bind(R.id.tab_mine_distance)
    public TabLayout tabDistance;
    private HomeIndustryBean homeIndustryBean;
    private int position;

    private FragmentManager manager;
    private FragmentTransaction transaction;
    public  static SpecialFragment instance = null;

    @Override
    protected int getLayoutResource() {
        instance = this;
        return R.layout.fragment_distance;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected void doFitsrData() {

        initshowdiscountFragment("");

        getBannerData();
    }

    /**
     * 获取首页的行业分类
     *
     */
    private void getBannerData() {
        HashMap<String, String> params= new HashMap<>();
        params.put("tabType", "2");//type  2代表美业    4代表异业
        params.put("tabFather", "0");
        params.put("token", SP.get(getActivity(), SpContent.UserToken,"")+"");
        HttpUtils.doPost(ACTION.INDUSTRY, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);//首页的行业分类
    }

    @Override
    public void onSuccess(int action, String res) throws WriterException {
        switch (action){
            /**
             * 行业分类
             */
            case ACTION.INDUSTRY:
                homeIndustryBean = GsonUtil.toObj(res, HomeIndustryBean.class);
                if (homeIndustryBean.isSuccess()&&homeIndustryBean.getErrorCode().equals("0")) {

                    if(homeIndustryBean.getBody() == null){
                    }else {
                        tabList.add("全部");
                        for(int i=0;i<homeIndustryBean.getBody().getCategoryListData().size();i++){
                            tabList.add(homeIndustryBean.getBody().getCategoryListData().get(i).getEcCategory().getTabName());
                        }

                        for (int i = 0; i < tabList.size(); i++) {
                            tabDistance.addTab(tabDistance.newTab().setText(tabList.get(i)));
                            TabLayout.Tab tab = tabDistance.getTabAt(i);
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
                                        SpecialPriceActivity.instance.tab_special_distance.getTabAt(position).select();
                                        //这里就可以根据业务需求处理点击事件了。
                                        if(position == 0){
                                            SpecialPriceActivity.instance.initshowdiscountFragment("");
                                        }else{
                                            SpecialPriceActivity.instance.initshowdiscountFragment(homeIndustryBean.getBody().getCategoryListData().get(position-1).getEcCategory().getId());
                                        }
                                    }
                                });
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        SpecialPriceActivity.instance.setIndicator(tabDistance, 5, 5);

                    }
                } else {
                    T.show(homeIndustryBean.getMsg());
                }
                break;
        }
    }

    @Override
    public void showLoadingDialog() {

    }

    @Override
    public void showErrorMessage(String s) {

    }

    public void initshowdiscountFragment(String sumber) {

        manager = getActivity().getSupportFragmentManager();
        transaction = manager.beginTransaction();
        SpecialBottomFragment historydiscountFragment = new SpecialBottomFragment();
        Bundle bundle = new Bundle();
        bundle.putString("position", sumber);
        historydiscountFragment.setArguments(bundle);
        transaction.add(R.id.frame_discount, historydiscountFragment);
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
}
