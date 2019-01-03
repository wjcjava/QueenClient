package com.ainisi.queenmirror.queenmirrorcduan.ui.master.fragment;


import android.net.Uri;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.widget.ImageView;

import com.ainisi.queenmirror.common.base.BaseFragment;
import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.ui.master.adapter.DynamicListAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.MessagePicturesLayout;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpaceItemDecoration;
import com.github.ielse.imagewatcher.ImageWatcherHelper;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.List;

import butterknife.Bind;

/**
 * 动态管理
 */
public class DynamicManagementFragment extends BaseFragment implements MessagePicturesLayout.Callback {


    @Bind(R.id.recommend_item_lv)
    RecyclerView mRecommendItemLv;
    @Bind(R.id.recommend_item_refresh)
    SmartRefreshLayout mRecommendItemRefresh;
    private ImageWatcherHelper iwHelper;


    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_dynamic_management;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void initView() {
        if (getActivity() instanceof ImageWatcherHelper.Provider) {
            iwHelper = ((ImageWatcherHelper.Provider) getActivity()).iwHelper();
        }
    }


    @Override
    protected void doFitsrData() {
        mRecommendItemLv.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecommendItemLv.addItemDecoration(new SpaceItemDecoration(getActivity()).setSpace(10).setSpaceColor(0xFFF7F7F7));
        DynamicListAdapter itemReclAdapter = new DynamicListAdapter(getActivity());
        mRecommendItemLv.setAdapter(itemReclAdapter);
        itemReclAdapter.setPictureClickCallback(this);
    }
    @Override
    public void onThumbPictureClick(ImageView i, SparseArray<ImageView> imageGroupList, List<Uri> urlList) {
        iwHelper.show(i, imageGroupList, urlList);
    }
}
