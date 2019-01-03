package com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity;

import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.MyAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.bean.SortBean;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.ainisi.queenmirror.queenmirrorcduan.utils.customview.RefreshLoadMoreLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

public class InteractiveMessageActivity extends BaseNewActivity implements RefreshLoadMoreLayout.CallBack {
    @Bind(R.id.recycler_interactivemessage)
    RecyclerView interactRecyclerView;
    @Bind(R.id.title_title)
    TextView interactTitle;
    @Bind(R.id.rlm)
    RefreshLoadMoreLayout mRefreshLoadMoreLayout;
    private String interact;
    private Handler handler = new Handler();
    private List<SortBean> systemList = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.interactive_message;
    }

    @Override
    protected void initView() {
        super.initView();
        interact = getIntent().getStringExtra("interact");
        interactTitle.setText(interact);
        /**
         * canRefresh 是否下拉刷新
         * canLoadMore 是否上拉加载更多
         * autoLoadMore 自动加载更多（默认不自动加载更多）
         * showLastRefreshTime 是否显示上次刷新时间（默认不显示）
         * multiTask 下拉刷新上拉加载更多可同时进行（默认下拉刷新和上拉加载更多不能同时进行）
         */
        mRefreshLoadMoreLayout.init(new RefreshLoadMoreLayout.Config(this).canRefresh(true)
                .canLoadMore(true)
                .autoLoadMore()

                .showLastRefreshTime(
                        RefreshLoadMoreLayout.class,
                        "yyyy-MM-dd")
                .multiTask());
    }

    @Override
    protected void initData() {
        super.initData();
        for (int i = 0; i < 10; i++) {
            SortBean sortBean = new SortBean();
            systemList.add(sortBean);
        }
        MyAdapter adapter = new MyAdapter(R.layout.item_interactive, systemList);
        interactRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        interactRecyclerView.setAdapter(adapter);


    }

    @Override
    public void onRefresh() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                T.show("下拉成功");
                mRefreshLoadMoreLayout.stopRefresh();
            }
        }, 200);
    }

    @Override
    public void onLoadMore() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                T.show("上拉成功");
                mRefreshLoadMoreLayout.stopLoadMore();
            }
        }, 1000);
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
