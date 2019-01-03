package com.ainisi.queenmirror.queenmirrorcduan.ui.master.activity;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean.DemoListModel;
import com.ainisi.queenmirror.queenmirrorcduan.ui.master.adapter.TopicSelectionListAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpaceItemDecoration;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 话题精选
 */
public class BigMasterTopicSelectionActivity extends BaseNewActivity {
    @Bind(R.id.recommend_item_lv)
    RecyclerView mRecommendItemLv;
    @Bind(R.id.recommend_item_refresh)
    SmartRefreshLayout mRecommendItemRefresh;
    @Bind(R.id.title_title)
    TextView postitle;
    @Bind(R.id.title_right)
    TextView postitleright;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_big_master_topic_selection;
    }

    @Override
    protected void initView() {
        super.initView();
        postitle.setText("话题精选");
        postitle.setTextSize(16);
    }

    @Override
    protected void initData() {
        super.initData();
        DemoListModel.BodyEntity.MessListEntity messListEntity = new DemoListModel.BodyEntity.MessListEntity("叫我女王大人啊！");
        List<DemoListModel.BodyEntity.MessListEntity> messListEntityList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            messListEntityList.add(messListEntity);
        }
        mRecommendItemLv.setLayoutManager(new LinearLayoutManager(BigMasterTopicSelectionActivity.this));
        mRecommendItemLv.addItemDecoration(new SpaceItemDecoration(BigMasterTopicSelectionActivity.this).setSpace(10).setSpaceColor(0xFFF7F7F7));
        TopicSelectionListAdapter itemReclAdapter = new TopicSelectionListAdapter(BigMasterTopicSelectionActivity.this, messListEntityList);
        mRecommendItemLv.setAdapter(itemReclAdapter);

        itemReclAdapter.setOnItemListener(new TopicSelectionListAdapter.OnItemClickListener() {
            @Override
            public void onClick(View v, int position, List<DemoListModel.BodyEntity.MessListEntity> entity) {
                    Intent intent = new Intent(BigMasterTopicSelectionActivity.this,BigMasterTopicSelectionDetailActivity.class);
                    startActivity(intent);
            }
        });

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
