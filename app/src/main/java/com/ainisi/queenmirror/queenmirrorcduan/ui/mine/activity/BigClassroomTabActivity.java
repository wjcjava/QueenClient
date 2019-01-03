package com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.mine.adapter.ContentPagerAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.ui.mine.fragment.CourseListFragment;
import com.google.zxing.WriterException;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 可以查看我的教程、观看记录、购买记录
 *
 * @author jiangchao
 *         created at 2018/9/10 下午2:49
 */
public class BigClassroomTabActivity extends BaseNewActivity implements HttpCallBack {


    @Bind(R.id.title_back)
    ImageView titleBack;
    @Bind(R.id.title_title)
    TextView commentTitle;
    @Bind(R.id.tl_tab)
    TabLayout mTabTl;
    @Bind(R.id.vp_content)
    ViewPager mContentVp;

    private List<String> tabIndicators;
    private List<Fragment> tabFragments;
    private ContentPagerAdapter contentAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_big_classroom_tab;
    }


    @Override
    protected void initData() {
        super.initData();
        commentTitle.setText("艾尼斯大课堂");
//        initContent();
//        initTab();

        //添加标签
        mTabTl.addTab(mTabTl.newTab().setText("我的教程"));
        mTabTl.addTab(mTabTl.newTab().setText("观看记录"));
        mTabTl.addTab(mTabTl.newTab().setText("购买记录"));

        mTabTl.setTabTextColors(ContextCompat.getColor(this, R.color.tab_text), ContextCompat.getColor(this, R.color.red_phone));
        mTabTl.setSelectedTabIndicatorColor(ContextCompat.getColor(this, R.color.red_phone));
        //设置adapter，滑动时间
//        final ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        mContentVp.setAdapter(new ContentPagerAdapter(getSupportFragmentManager(), mTabTl.getTabCount()));
        mContentVp.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabTl));

        //绑定tab点击事件
        mTabTl.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mContentVp.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
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

    private void initTab() {
        mTabTl.setTabTextColors(ContextCompat.getColor(this, R.color.tab_text), ContextCompat.getColor(this, R.color.red_phone));
        mTabTl.setSelectedTabIndicatorColor(ContextCompat.getColor(this, R.color.red_phone));
        ViewCompat.setElevation(mTabTl, 10);
        mTabTl.setupWithViewPager(mContentVp);
    }

    private void initContent() {
        tabIndicators = new ArrayList<>();
//        for (int i = 0; i < 3; i++) {
//            tabIndicators.add("Tab " + i);
//        }
        tabIndicators.add("我的教程");
        tabIndicators.add("观看记录");
        tabIndicators.add("购买记录");

        tabFragments = new ArrayList<>();
        for (String s : tabIndicators) {
            tabFragments.add(CourseListFragment.newInstance(s));
        }
        contentAdapter = new ContentPagerAdapter(getSupportFragmentManager(), 3);
        mContentVp.setAdapter(contentAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }


//    class ContentPagerAdapter extends FragmentPagerAdapter {
//
////        public ContentPagerAdapter(FragmentManager fm) {
////            super(fm);
////        }
////
////        @Override
////        public Fragment getItem(int position) {
////            return tabFragments.get(position);
////        }
////
////        @Override
////        public int getCount() {
////            return tabIndicators.size();
////        }
////
////        @Override
////        public CharSequence getPageTitle(int position) {
////            return tabIndicators.get(position);
////        }
//
//        private int num;
//        private HashMap<Integer, Fragment> mFragmentHashMap = new HashMap<>();
//
//        public ContentPagerAdapter(FragmentManager fm, int num) {
//            super(fm);
//            this.num = num;
//        }
//
//        @Override
//        public Fragment getItem(int position) {
//
//            return createFragment(position);
//        }
//
//        @Override
//        public int getCount() {
//            return num;
//        }
//
//        private Fragment createFragment(int pos) {
//            Fragment fragment = mFragmentHashMap.get(pos);
//
//            if (fragment == null) {
//                switch (pos) {
//                    case 0:
//                        fragment = new Fragment1();
//                        Log.i("fragment", "fragment1");
//                        break;
//                    case 1:
//                        fragment = new Fragment2();
//                        Log.i("fragment", "fragment2");
//                        break;
//                    case 2:
//                        fragment = new Fragment3();
//                        Log.i("fragment", "fragment3");
//                        break;
//                    default:
//                        break;
//                }
//                mFragmentHashMap.put(pos, fragment);
//            }
//            return fragment;
//        }
//
//    }

    @OnClick({R.id.title_back
    })
    public void click(View view) {
        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;
            default:
                break;
        }
    }


}
