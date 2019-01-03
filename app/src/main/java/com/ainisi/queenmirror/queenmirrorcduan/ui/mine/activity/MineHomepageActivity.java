package com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.MyAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.bean.SortBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 我的主页
 */
public class MineHomepageActivity extends BaseNewActivity {

    @Bind(R.id.title_title)
    TextView pageTitle;
    @Bind(R.id.re_mine_pager)
    RecyclerView rePager;
    @Bind(R.id.re_mine_pagertwo)
    RecyclerView rePagerTwo;
    private List<SortBean> list = new ArrayList<>();
    @Override
    protected int getLayoutId() {
        return R.layout.mine_pager;
    }

    @Override
    protected void initView() {
        super.initView();
        pageTitle.setText(R.string.MyHomepage);
        pageTitle.setTextSize(18);
    }

    @Override
    protected void initData() {
        super.initData();
        for (int i = 0; i <3 ; i++) {
            SortBean sortBean=new SortBean();
            list.add(sortBean);
        }
        MyAdapter myAdapter=new MyAdapter(R.layout.item_mine_homepager,list);
        rePager.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        rePager.setAdapter(myAdapter);
        rePagerTwo.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        rePagerTwo.setAdapter(myAdapter);
    }
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
