package com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean.SeckillTabBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.fragment.SecKillFragment;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utils.customview.NoAnimationViewPager;
import com.google.zxing.WriterException;
import com.lzy.okgo.cache.CacheMode;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 邮箱：707078566@qq.com
 * 用途：女王秒杀
 *
 * @author linxi
 */
public class SecKillActivity extends BaseNewActivity implements TabLayout.OnTabSelectedListener, HttpCallBack, SecKillFragment.FragmentInteraction {
    @Bind(R.id.seckill_tab)
    TabLayout mSeckillTab;
    @Bind(R.id.seckill_vp)
    NoAnimationViewPager mSeckillVp;

    private List<Fragment> tabFragments = new ArrayList<>();
    private int position;
    private int positions;
    private MyViewPagerAdapter mAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_seckill;
    }

    @Override
    protected void initView() {
        super.initView();
    }

    @Override
    protected void initData() {
        super.initData();
        secKillActivity();
    }

    private void secKillActivity() {
        HashMap<String, String> hashMap1 = new HashMap();
        HttpUtils.doPost(ACTION.SECKILLACTIVITY, hashMap1, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    /**
     * @description: 设置添加Tab
     */
    private void setTabs(List<SeckillTabBean.BodyBean.ListBean> mTabBeanList) {
        //判断是否还有秒杀中，并且选中第一个
        boolean isave = false;
        //判断是否还有即将秒杀，并且选中第一个
        boolean isaves = false;
        for (int i = 0; i < mTabBeanList.size(); i++) {
            TabLayout.Tab tab = mSeckillTab.newTab();
            View view = LayoutInflater.from(this).inflate(R.layout.tab_seckill, null);
            tab.setCustomView(view);
            TextView tab_seckill_time = view.findViewById(R.id.tab_seckill_time);
            TextView tab_seckill_content = view.findViewById(R.id.tab_seckill_content);
            tab_seckill_time.setText(getdate(mTabBeanList.get(i).getBeginTime()));
            tab_seckill_content.setText(mTabBeanList.get(i).getState());
            switch (mTabBeanList.get(i).getStateType()) {
                //秒杀中
                case 2:
                    if (isave == false) {
                        isave = true;
                        position = i;
                    }
                    break;
                //即将秒杀
                case 3:
                    if (isaves == false) {
                        isaves = true;
                        positions = i;
                    }
                    break;
                default:
                    break;
            }
            mSeckillTab.addTab(tab);
            tabFragments.add(new SecKillFragment().newInstance(mTabBeanList.get(i), i));
        }
        if (mAdapter == null) {
            mAdapter = new MyViewPagerAdapter(getSupportFragmentManager());
            mSeckillVp.setAdapter(mAdapter);
        } else {
            mAdapter.notifyDataSetChanged();
        }
        if (isave) {
            mSeckillTab.getTabAt(position).select();
            mSeckillVp.setCurrentItem(position);
        } else if (isaves) {
            mSeckillTab.getTabAt(positions).select();
            mSeckillVp.setCurrentItem(positions);
        } else {
            mSeckillTab.getTabAt(0).select();
            mSeckillVp.setCurrentItem(0);
        }
        mSeckillVp.setOffscreenPageLimit(tabFragments.size() - 1);
        mSeckillTab.setTabMode(TabLayout.MODE_SCROLLABLE);
        mSeckillVp.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mSeckillTab));
        mSeckillTab.addOnTabSelectedListener(this);
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        mSeckillVp.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

    @Override
    public void onSuccess(int action, String res) throws WriterException {
        switch (action) {
            case ACTION.SECKILLACTIVITY:
                SeckillTabBean tabBean = GsonUtil.toObj(res, SeckillTabBean.class);
                if (tabBean.isSuccess()) {
                    List<SeckillTabBean.BodyBean.ListBean> list = tabBean.getBody().getList();
                    setTabs(list);
                }
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

    @Override
    public void process(int position, int type) {
        if (!TextUtils.isEmpty(String.valueOf(position))) {
            View customView = mSeckillTab.getTabAt(position).getCustomView();
            TextView tab_seckill_content = customView.findViewById(R.id.tab_seckill_content);
            switch (type) {
                case 2:
                    tab_seckill_content.setText("已秒杀");
                    break;
                case 3:
                    tab_seckill_content.setText("秒杀中");
                    break;
                default:
                    break;
            }
        }
    }

    private class MyViewPagerAdapter extends FragmentPagerAdapter {

        MyViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return tabFragments.get(position);
        }

        @Override
        public int getCount() {
            return tabFragments.size();
        }
    }

    @OnClick(R.id.seckill_back)
    public void onViewClicked() {
        finish();
    }

    private String getdate(String s) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm");
        Date date = null;
        try {
            date = sdf.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return sdf2.format(date);
    }
}
