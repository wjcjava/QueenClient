package com.ainisi.queenmirror.queenmirrorcduan.ui.master.fragment;


import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ainisi.queenmirror.common.base.BaseFragment;
import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean.DemoListModel;
import com.ainisi.queenmirror.queenmirrorcduan.ui.master.adapter.FansCommentListAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpaceItemDecoration;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * A simple {@link Fragment} subclass.
 */
public class MessageCommentFragment extends BaseFragment {

    private static final String EXTRA_CONTENT = "content";

    @Bind(R.id.recommend_item_lv)
    RecyclerView mRecommendItemLv;
    @Bind(R.id.recommend_item_refresh)
    SmartRefreshLayout mRecommendItemRefresh;


    public MessageCommentFragment() {
        // Required empty public constructor
    }

    public static MessageCommentFragment newInstance(String content) {
        Bundle arguments = new Bundle();
        arguments.putString(EXTRA_CONTENT, content);
        MessageCommentFragment tabContentFragment = new MessageCommentFragment();
        tabContentFragment.setArguments(arguments);
        return tabContentFragment;
    }


    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_message_comment;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected void doFitsrData() {
        DemoListModel.BodyEntity.MessListEntity messListEntity=new DemoListModel.BodyEntity.MessListEntity("叫我女王大人啊！");
        List<DemoListModel.BodyEntity.MessListEntity> messListEntityList=new ArrayList<>();

        for (int i = 0; i <10 ; i++) {
            messListEntityList.add(messListEntity);
        }
        mRecommendItemLv.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecommendItemLv.addItemDecoration(new SpaceItemDecoration(getActivity()).setSpace(1).setSpaceColor(0xFFF7F7F7));
        FansCommentListAdapter itemReclAdapter = new FansCommentListAdapter(getActivity(),messListEntityList);
        mRecommendItemLv.setAdapter(itemReclAdapter);
    }

}
