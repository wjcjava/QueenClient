package com.ainisi.queenmirror.queenmirrorcduan.ui.master.fragment;


import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ainisi.queenmirror.common.base.BaseFragment;
import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean.DemoListModel;
import com.ainisi.queenmirror.queenmirrorcduan.ui.master.adapter.FansManagementListAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpaceItemDecoration;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * 粉丝管理
 */
public class FansManagementFragment extends BaseFragment {
    @Bind(R.id.recommend_item_lv)
    RecyclerView mRecommendItemLv;
    @Bind(R.id.recommend_item_refresh)
    SmartRefreshLayout mRecommendItemRefresh;




    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_fans_management;
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
        FansManagementListAdapter itemReclAdapter = new FansManagementListAdapter(getActivity(),messListEntityList);
        mRecommendItemLv.setAdapter(itemReclAdapter);
    }

}
