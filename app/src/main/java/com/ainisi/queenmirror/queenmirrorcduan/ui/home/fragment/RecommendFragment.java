package com.ainisi.queenmirror.queenmirrorcduan.ui.home.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ainisi.queenmirror.common.base.BaseFragment;
import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.ui.master.activity.BigMasterTopicSelectionActivity;
import com.ainisi.queenmirror.queenmirrorcduan.utils.ViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 作者：linxi on 2018/10/18 17:14
 * 邮箱：707078566@qq.com
 * 用途：大咖推荐
 */
public class RecommendFragment extends BaseFragment {
    @Bind(R.id.recommend_tab)
    TabLayout mRecommendTab;
    @Bind(R.id.recommend_vp)
    android.support.v4.view.ViewPager mRecommendVp;
    private List<String> mTablist = new ArrayList<>();
    private List<Fragment> tabFragments = new ArrayList<>();

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_recommend;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void initView() {
    }

    @Override
    protected void doFitsrData() {
        mTablist.add("女装大佬");
        mTablist.add("女装大佬");
        mTablist.add("女装大佬");
        mTablist.add("女装大佬");
        mTablist.add("女装大佬");
        mTablist.add("女装大佬");
        mTablist.add("女装大佬");
        mTablist.add("女装大佬");
        mTablist.add("女装大佬");
        mTablist.add("女装大佬");
        for (int i = 0; i < mTablist.size(); i++) {
            TabLayout.Tab tab = mRecommendTab.newTab();
            View view = LayoutInflater.from(getActivity()).inflate(R.layout.tab_recommend, null);
            TextView tab_recommend_tv = view.findViewById(R.id.tab_recommend_tv);
            tab_recommend_tv.setText(mTablist.get(i));
            tab.setCustomView(view);
            tabFragments.add(new RecommendItemFragment().newInstance());
            mRecommendTab.addTab(tab);
        }
        ViewPager viewPager = new ViewPager(getActivity().getSupportFragmentManager(), tabFragments, mTablist);
        mRecommendVp.setAdapter(viewPager);
        mRecommendTab.setTabMode(TabLayout.MODE_SCROLLABLE);
        mRecommendTab.setupWithViewPager(mRecommendVp);
    }

    @OnClick({R.id.recommend_class, R.id.recommend_say, R.id.recommend_certification})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            //艾尼斯大课堂
            case R.id.recommend_class:
                break;
            //话题精选
            case R.id.recommend_say:
                startActivity(new Intent(getActivity(), BigMasterTopicSelectionActivity.class));

                break;
            //大咖认证
            case R.id.recommend_certification:
                break;
        }
    }

    public static RecommendFragment newInstance() {
        Bundle args = new Bundle();
        RecommendFragment fragment = new RecommendFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
