package com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.fragment.AttentionFragment;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.fragment.NearbyFragment;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.fragment.RecommendFragment;
import com.ainisi.queenmirror.queenmirrorcduan.ui.master.activity.BigMasterMessageActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.master.activity.BigMasterPersonalCenterActivity;
import com.ainisi.queenmirror.queenmirrorcduan.utils.GlideSimpleLoader;
import com.github.ielse.imagewatcher.ImageWatcher;
import com.github.ielse.imagewatcher.ImageWatcherHelper;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 作者：linxi on 2018/10/18 16:45
 * 邮箱：707078566@qq.com
 * 用途：大咖
 */
public class BigMasterActivity extends BaseNewActivity implements TabLayout.OnTabSelectedListener, ImageWatcherHelper.Provider {
    @Bind(R.id.bigmaster_tab)
    TabLayout mBigmasterTab;
    @Bind(R.id.bigmaster_vp)
    ViewPager mBigmasterVp;
    private String[] TAB_TITLES = new String[]{"关注", "推荐", "附近"};
    //Fragment
    private Fragment[] TAB_fragments = new Fragment[]{AttentionFragment.newInstance(), RecommendFragment.newInstance(),
            NearbyFragment.newInstance()};
    private MyViewPagerAdapter mAdapter;
    private ImageWatcherHelper iwHelper;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_bigmaster;
    }

    @Override
    protected void initView() {
        super.initView();
        setTabs();
        setVp();
        setImageLoader();
    }

    @OnClick({R.id.bigmaster_search, R.id.bigmaster_message, R.id.bigmaster_my})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bigmaster_search:
                break;
            case R.id.bigmaster_message:
                startActivity(new Intent(BigMasterActivity.this, BigMasterMessageActivity.class));
                break;
            case R.id.bigmaster_my:
                startActivity(new Intent(BigMasterActivity.this, BigMasterPersonalCenterActivity.class));
                break;

            default:
                break;
        }
    }

    /**
     * @description: 设置添加Tab
     */
    private void setTabs() {
        for (int i = 0; i < TAB_TITLES.length; i++) {
            TabLayout.Tab tab = mBigmasterTab.newTab();
            View view = LayoutInflater.from(this).inflate(R.layout.tab_bigmaster, null);
            tab.setCustomView(view);
            TextView tvTitle = view.findViewById(R.id.tv_tab);
            ImageView image_tab = view.findViewById(R.id.image_tab);
            tvTitle.setText(TAB_TITLES[i]);
            if (i == 1) {
                tvTitle.setTextColor(ContextCompat.getColor(BigMasterActivity.this, R.color.black));
                image_tab.setVisibility(View.VISIBLE);
            } else {
                image_tab.setVisibility(View.GONE);
                tvTitle.setTextColor(ContextCompat.getColor(BigMasterActivity.this, R.color.tab_text));
            }
            mBigmasterTab.addTab(tab);
        }
    }

    private void setVp() {
        if (mAdapter == null) {
            mAdapter = new MyViewPagerAdapter(getSupportFragmentManager());
            mBigmasterVp.setAdapter(mAdapter);
        }
        mBigmasterVp.setOffscreenPageLimit(2);
        mBigmasterTab.setTabMode(TabLayout.MODE_FIXED);
        mBigmasterVp.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mBigmasterTab));
        mBigmasterTab.addOnTabSelectedListener(this);
        mBigmasterVp.setCurrentItem(1);
    }

    private void setImageLoader() {
        iwHelper = ImageWatcherHelper.with(this, new GlideSimpleLoader())
                .setErrorImageRes(R.mipmap.error_picture)
                .setOnPictureLongPressListener(new ImageWatcher.OnPictureLongPressListener() {
                    @Override
                    public void onPictureLongPress(ImageView imageView, Uri uri, int i) {

                    }
                });// 配置error图标 如果不介意使用lib自带的图标，并不一定要调用这个API;
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        mBigmasterVp.setCurrentItem(tab.getPosition());
        tab.getCustomView().findViewById(R.id.image_tab).setVisibility(View.VISIBLE);
        TextView viewById = tab.getCustomView().findViewById(R.id.tv_tab);
        viewById.setTextColor(ContextCompat.getColor(BigMasterActivity.this, R.color.black));
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {
        tab.getCustomView().findViewById(R.id.image_tab).setVisibility(View.GONE);
        TextView viewById = tab.getCustomView().findViewById(R.id.tv_tab);
        viewById.setTextColor(ContextCompat.getColor(BigMasterActivity.this, R.color.tab_text));
    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

    @Override
    public void onBackPressed() {
        if (!iwHelper.handleBackPressed()) {
            super.onBackPressed();
        }
    }

    @Override
    public ImageWatcherHelper iwHelper() {
        return iwHelper;
    }

    /**
     * @description: ViewPager 适配器
     */
    private class MyViewPagerAdapter extends FragmentPagerAdapter {
        public MyViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return TAB_fragments[position];
        }

        @Override
        public int getCount() {
            return TAB_TITLES.length;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
