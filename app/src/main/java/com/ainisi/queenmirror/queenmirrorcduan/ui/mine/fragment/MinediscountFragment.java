package com.ainisi.queenmirror.queenmirrorcduan.ui.mine.fragment;

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
import com.ainisi.queenmirror.queenmirrorcduan.ui.shop.bean.ReceiveDiscounBean;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * Created by EWorld on 2018/3/6.
 * 我的优惠券
 */

public class MinediscountFragment extends BaseFragment {

    @Bind(R.id.tab_mine_distance)
    TabLayout tabDistance;

    private List<String> tabList = new ArrayList<>();
    private FragmentManager manager;
    private FragmentTransaction transaction;
    private int position;
    private ReceiveDiscounBean receiveBean;
    private int item;
    private int sumber;

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_distance;
    }

    @Override
    public void initPresenter() {
    }

    @Override
    protected void initView() {

        initDate();
        /**
         * 商品所领取优惠券
         */
    }

    @Override
    protected void doFitsrData() {

    }

    @Override
    public void onResume() {
        super.onResume();
       initshowdiscountFragment(1);
    }

    private void initDate() {
            tabList.add("已领取优惠券");
            tabList.add("已使用优惠券");
            tabList.add("已过期优惠券");

        for (int i = 0; i < 3; i++) {
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
                        //这里就可以根据业务需求处理点击事件了。
                        if (position == 0) {
                            sumber=1;
                            initshowdiscountFragment(sumber);
                        } else if (position == 1) {
                            sumber=2;
                            initshowdiscountFragment(sumber);
                        } else if (position == 2) {
                            sumber=9;
                            initshowdiscountFragment(sumber);
                        }
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        setIndicator(tabDistance, 10, 10);
    }
    private void initshowdiscountFragment(int sumber) {

        manager = getActivity().getSupportFragmentManager();
        transaction = manager.beginTransaction();
        HistorydiscountFragment historydiscountFragment = new HistorydiscountFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("position", sumber);
        bundle.putSerializable("bean", receiveBean);
        bundle.putString("cpCate","1");
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
