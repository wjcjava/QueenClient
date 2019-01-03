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
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.SpecialPriceActivity;
import com.google.zxing.WriterException;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * Created by john on 2018/9/19.
 *
 * jl
 */

public class RankingListFragment extends BaseFragment implements HttpCallBack {

    public  static RankingListFragment instance = null;

    private List<String> tabList = new ArrayList<>();
    @Bind(R.id.tab_mine_distance)
    public TabLayout tabDistance;
    private int position;

    private FragmentManager manager;
    private FragmentTransaction transaction;


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

        tabList.add("关注榜");
        tabList.add("收藏榜");
        tabList.add("口碑榜");
        tabList.add("环境榜");
        tabList.add("技师榜");
        tabList.add("销售榜");

        initshowdiscountFragment("");

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
                        initshowdiscountFragment(""+position);
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        setIndicator(tabDistance, 5, 5);

    }

    @Override
    protected void doFitsrData() {

    }


    public void initshowdiscountFragment(String sumber) {

        manager = getActivity().getSupportFragmentManager();
        transaction = manager.beginTransaction();
        RankingListBottomFragment historydiscountFragment = new RankingListBottomFragment();
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

    @Override
    public void onSuccess(int action, String res) throws WriterException {

    }

    @Override
    public void showLoadingDialog() {

    }

    @Override
    public void showErrorMessage(String s) {

    }
}
