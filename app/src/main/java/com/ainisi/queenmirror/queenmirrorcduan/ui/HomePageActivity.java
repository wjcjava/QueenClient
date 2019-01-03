package com.ainisi.queenmirror.queenmirrorcduan.ui;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.LinearLayout;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseOneActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.fragment.FightgroupFragment;
import com.ainisi.queenmirror.queenmirrorcduan.ui.fragment.HomeNewFragment;
import com.ainisi.queenmirror.queenmirrorcduan.ui.fragment.MineFragment;
import com.ainisi.queenmirror.queenmirrorcduan.ui.fragment.OrderFragment;
import com.ainisi.queenmirror.queenmirrorcduan.ui.fragment.ShopMallFragment;
import com.ainisi.queenmirror.queenmirrorcduan.ui.user.LoginActivity;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SP;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpContent;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.ainisi.queenmirror.queenmirrorcduan.utils.CustomViewPager;
import com.umeng.analytics.MobclickAgent;

import java.util.ArrayList;

import butterknife.Bind;

public class HomePageActivity extends BaseOneActivity implements View.OnClickListener, ViewPager.OnPageChangeListener {

    @Bind(R.id.viewPager)
    CustomViewPager viewPager;
    @Bind(R.id.ll_home)
    LinearLayout ll_home;
    @Bind(R.id.ll_category)
    LinearLayout ll_category;
    @Bind(R.id.ll_service)
    LinearLayout ll_service;
    @Bind(R.id.ll_mine)
    LinearLayout ll_mine;
    @Bind(R.id.ll_daka)
    LinearLayout ll_daka;
    @Bind(R.id.ll_tuan)
    LinearLayout ll_tuan;

    int current;
    private ArrayList<Fragment> mFragments;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_home_page;
    }

    @Override
    protected void initData() {
        mFragments = new ArrayList<>();
        HomeNewFragment homeOneFragment = new HomeNewFragment();
        ShopMallFragment categoryOneFragment = new ShopMallFragment();
        OrderFragment serviceOneFragment = new OrderFragment();
        /*MasterFragment mineOneFragment = new MasterFragment();*/
        MineFragment mineFragment = new MineFragment();
        FightgroupFragment fightgroupFragment = new FightgroupFragment();
        mFragments.add(homeOneFragment);
        mFragments.add(fightgroupFragment);
//        mFragments.add(categoryOneFragment);
        mFragments.add(serviceOneFragment);
        //mFragments.add(mineOneFragment);
        mFragments.add(mineFragment);

    }

    @Override
    protected void onResume() {
        super.onResume();
        MobclickAgent.onPageStart(this.getClass().getName());
        current = Integer.parseInt(SP.get(HomePageActivity.this, SpContent.Current, "0") + "");
        viewPager.setScroll(false);
        viewPager.setAdapter(new MyAdapter(getSupportFragmentManager()));
        viewPager.setOffscreenPageLimit(3);
        ll_home.setSelected(true);
        if (current == 0) {
            viewPager.setCurrentItem(0);
            tabSelected(ll_home);
        } else if (current == 2) {
            if (SP.get(HomePageActivity.this, SpContent.isLogin, "").equals("1")) {
                viewPager.setCurrentItem(2);
                tabSelected(ll_service);
            } else {
                Intent intents = new Intent(HomePageActivity.this, LoginActivity.class);
                intents.putExtra("activite", "no");
                startActivity(intents);
            }
        } else if (current == 1) {
            viewPager.setCurrentItem(1);
//            tabSelected(ll_category);
            tabSelected(ll_tuan);
        } else if (current == 4) {
            viewPager.setCurrentItem(4);
            tabSelected(ll_mine);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        MobclickAgent.onPageEnd(this.getClass().getName());
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        switch (position) {
            case 0:
                tabSelected(ll_home);
                break;
            case 1:
//                tabSelected(ll_category);
                tabSelected(ll_tuan);
                break;
            case 2:
                if (SP.get(HomePageActivity.this, SpContent.isLogin, "").equals("1")) {
                    tabSelected(ll_service);
                } else {
                    Intent intent = new Intent(HomePageActivity.this, LoginActivity.class);
                    intent.putExtra("activite", "no");
                    startActivity(intent);
                }
                break;
         /*   case 3:
                tabSelected(ll_daka);
                break;*/
            case 4:
                tabSelected(ll_mine);
                break;
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    protected void setListener() {
        ll_home.setOnClickListener(this);
        ll_category.setOnClickListener(this);
        ll_service.setOnClickListener(this);
        ll_mine.setOnClickListener(this);
        ll_tuan.setOnClickListener(this);
        // ll_daka.setOnClickListener(this);
        viewPager.addOnPageChangeListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_home:
                MobclickAgent.onEvent(this, "ll_home");//参数二为当前统计的事件ID

                SP.put(HomePageActivity.this, SpContent.Current, "0");
                viewPager.setCurrentItem(0);
                tabSelected(ll_home);
                break;
            case R.id.ll_category:
                MobclickAgent.onEvent(this, "ll_category");//参数二为当前统计的事件ID
                SP.put(HomePageActivity.this, SpContent.Current, "1");
                viewPager.setCurrentItem(1);
                tabSelected(ll_category);
                break;
            case R.id.ll_service:

                MobclickAgent.onEvent(this, "ll_service");//参数二为当前统计的事件ID

                if (SP.get(HomePageActivity.this, SpContent.isLogin, "").equals("1")) {
                    SP.put(HomePageActivity.this, SpContent.Current, "2");
                    viewPager.setCurrentItem(2);
                    tabSelected(ll_service);
                } else {
                    Intent intent = new Intent(HomePageActivity.this, LoginActivity.class);
                    intent.putExtra("activite", "no");
                    startActivity(intent);
                }
                break;
          /*  case R.id.ll_daka:
                viewPager.setCurrentItem(3);
                tabSelected(ll_daka);
                break;*/
            case R.id.ll_mine:

                MobclickAgent.onEvent(this, "ll_mine");//参数二为当前统计的事件ID

                SP.put(HomePageActivity.this, SpContent.Current, "4");
                viewPager.setCurrentItem(4);
                tabSelected(ll_mine);
                break;
            //拼团
            case R.id.ll_tuan:
                MobclickAgent.onEvent(this, "ll_tuan");//参数二为当前统计的事件ID
                SP.put(HomePageActivity.this, SpContent.Current, "1");
                viewPager.setCurrentItem(1);
                tabSelected(ll_tuan);
                break;
        }
    }

    private void tabSelected(LinearLayout linearLayout) {
        ll_home.setSelected(false);
        ll_category.setSelected(false);
        ll_service.setSelected(false);
        ll_tuan.setSelected(false);
        //  ll_daka.setSelected(false);
        ll_mine.setSelected(false);
        linearLayout.setSelected(true);
    }

    private class MyAdapter extends FragmentPagerAdapter {
        MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }
    }

    private long exitTime = 0;

    @Override
    public void onBackPressed() {
        if (System.currentTimeMillis() - exitTime > 2000) {
            T.show("在点击一次退出应用");
            exitTime = System.currentTimeMillis();
            if (SP.get(this, SpContent.Remember, "").equals("0")) {
                SP.put(this, SpContent.isLogin, "0");
            }
        } else {
            finish();
            System.exit(0);
            android.os.Process.killProcess(android.os.Process.myPid());
        }
    }


}
