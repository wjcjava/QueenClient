package com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.adapter.PopSortAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean.HomeIndustryBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.fragment.SortFragment;
import com.ainisi.queenmirror.queenmirrorcduan.utils.NoScrollGridView;
import com.ainisi.queenmirror.queenmirrorcduan.utils.ViewPager;
import com.example.john.library.PopWindowHome;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 作者：linxi on 2018/9/17 16:07
 * 邮箱：707078566@qq.com
 * 用途：分类（热销、人气、好评）
 */
public class SortItemActivity extends BaseNewActivity {
    @Bind(R.id.title_title)
    TextView mTitleTitle;
    @Bind(R.id.sortitem_tab)
    TabLayout mSortitemTab;
    @Bind(R.id.sortitem_vp)
    android.support.v4.view.ViewPager mSortitemVp;
    @Bind(R.id.sortitem_btn)
    Button mSortitemBtn;
    @Bind(R.id.sortitem_tv)
    TextView mSortitemTv;
    @Bind(R.id.rl_sortitem_top)
    RelativeLayout rl_sortitem_top;
    private List<Fragment> tabFragments = new ArrayList<>();
    private View mInflate;
    private PopSortAdapter mPopSortAdapter;
    private List<String> lv_Lists = new ArrayList<>();
    private PopWindowHome popWindowHome;
    private List<HomeIndustryBean.BodyBean.CategoryListDataBean> lv_List;
    private String type;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_sortitem;
    }

    @Override
    protected void initView() {
        super.initView();
        mTitleTitle.setText(getIntent().getStringExtra("sortitem_title"));
    }

    @Override
    protected void initData() {
        super.initData();
        Intent intent = getIntent();
        type = intent.getStringExtra("type");
        lv_List = ((HomeIndustryBean) intent.getSerializableExtra("homeIndustryBean")).getBody().getCategoryListData();
        lv_List.remove(0);
        for (int i = 0; i < lv_List.size(); i++) {
            tabFragments.add(new SortFragment().newInstance(lv_List.get(i).getEcCategory().getId(), type));
            mSortitemTab.addTab(mSortitemTab.newTab().setText(lv_List.get(i).getEcCategory().getTabName()));
            lv_Lists.add(lv_List.get(i).getEcCategory().getTabName());
        }
        ViewPager viewPager = new ViewPager(getSupportFragmentManager(), tabFragments, lv_Lists);
        mSortitemVp.setAdapter(viewPager);
        mSortitemTab.setTabMode(TabLayout.MODE_SCROLLABLE);
        mSortitemTab.setupWithViewPager(mSortitemVp);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.title_back, R.id.sortitem_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;
            case R.id.sortitem_btn:
                setSortPop();
                break;
        }
    }

    /**
     * 设置Pop加载全部分类
     */
    private void setSortPop() {
        if (!mSortitemBtn.isSelected()) {
            mSortitemBtn.setSelected(true);
            mSortitemTab.setVisibility(View.GONE);
            mSortitemTv.setVisibility(View.VISIBLE);
            if (mInflate == null)
                mInflate = getLayoutInflater().inflate(R.layout.pop_sort_item, null);

            //show里面的内容是显示在空间下方的控件
            if (popWindowHome == null) {
                popWindowHome = new PopWindowHome.Builder(this)
                        .setStyle(PopWindowHome.PopWindowStyle.PopDown)
                        .setView(mInflate)
                        .setControlViewAnim(mSortitemBtn, R.anim.btn_rotate_anim_1, R.anim.btn_rotate_anim_2, false)
                        .show(rl_sortitem_top);
            } else {
                popWindowHome.setStyle(PopWindowHome.PopWindowStyle.PopDown);
                popWindowHome.show(rl_sortitem_top);
            }
            NoScrollGridView pop_sort_gv = mInflate.findViewById(R.id.pop_sort_gv);
            if (mPopSortAdapter == null)
                mPopSortAdapter = new PopSortAdapter(SortItemActivity.this, lv_Lists);
            pop_sort_gv.setAdapter(mPopSortAdapter);
            mPopSortAdapter.setPosition(mSortitemTab.getSelectedTabPosition());
            pop_sort_gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    mSortitemTab.getTabAt(i).select();
                    mSortitemVp.setCurrentItem(i);
                    mSortitemTab.setVisibility(View.VISIBLE);
                    mSortitemTv.setVisibility(View.GONE);
                    popWindowHome.dismiss();
                }
            });
            popWindowHome.setOnDismissListener(new PopWindowHome.OnDismissListener() {
                @Override
                public void onDismiss() {
                    mSortitemBtn.setSelected(false);
                    mSortitemTab.setVisibility(View.VISIBLE);
                    mSortitemTv.setVisibility(View.GONE);
                }
            });
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mInflate = null;
        mPopSortAdapter = null;
        if (popWindowHome != null) {
            popWindowHome.dismiss();
        }
    }
}
