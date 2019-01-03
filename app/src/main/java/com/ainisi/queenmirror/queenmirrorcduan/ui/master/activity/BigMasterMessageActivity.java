package com.ainisi.queenmirror.queenmirrorcduan.ui.master.activity;


import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.master.fragment.MessageCommentFragment;
import com.ainisi.queenmirror.queenmirrorcduan.ui.master.fragment.MessageFansFragment;
import com.ainisi.queenmirror.queenmirrorcduan.ui.master.fragment.MessageFocusFragment;
import com.ainisi.queenmirror.queenmirrorcduan.ui.master.fragment.MessageThumbsUpFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 大咖消息
 */
public class BigMasterMessageActivity extends BaseNewActivity {
    @Bind(R.id.title_title)
    TextView postitle;
    @Bind(R.id.title_right)
    ImageView postitleright;
    @Bind(R.id.tl_tab)
    TabLayout mTabTl;
    @Bind(R.id.vp_content)
    ViewPager mContentVp;
    private List<String> tabIndicators;
    private List<Fragment> tabFragments;
    private ContentPagerAdapter contentAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_big_master_message;
    }

    @Override
    protected void initView() {
        super.initView();
        postitle.setText("大咖消息");
        postitle.setTextSize(16);
        postitleright.setBackground(ContextCompat.getDrawable(this,R.mipmap.ic_message_personal) );
        initContent();
        initTab();
    }

    private void initTab() {
        mTabTl.setTabTextColors(ContextCompat.getColor(this, R.color.tab_text), ContextCompat.getColor(this, R.color.text_pink));
        mTabTl.setSelectedTabIndicatorColor(ContextCompat.getColor(this, R.color.text_pink));
        mTabTl.setupWithViewPager(mContentVp);
    }

    private void initContent() {
        tabIndicators = new ArrayList<>();
        tabIndicators.add("粉丝");
        tabIndicators.add("关注");
        tabIndicators.add("评论");
        tabIndicators.add("喜欢");

        tabFragments = new ArrayList<>();
        tabFragments.add(MessageFansFragment.newInstance("粉丝"));
        tabFragments.add(MessageFocusFragment.newInstance("关注"));
        tabFragments.add(MessageCommentFragment.newInstance("评论"));
        tabFragments.add(MessageThumbsUpFragment.newInstance("喜欢"));
        contentAdapter = new ContentPagerAdapter(getSupportFragmentManager());
        mContentVp.setAdapter(contentAdapter);
    }

    class ContentPagerAdapter extends FragmentPagerAdapter {

        public ContentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return tabFragments.get(position);
        }

        @Override
        public int getCount() {
            return tabIndicators.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tabIndicators.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {

        }
    }

    @OnClick({R.id.title_back, R.id.title_right
    })
    public void click(View view) {
        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;
            case R.id.title_right:
                Toast.makeText(this, "点击事件", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }

}
