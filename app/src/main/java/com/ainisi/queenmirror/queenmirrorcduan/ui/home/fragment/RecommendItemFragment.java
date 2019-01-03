package com.ainisi.queenmirror.queenmirrorcduan.ui.home.fragment;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.ainisi.queenmirror.common.base.BaseFragment;
import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.ui.master.adapter.RecommendItemReclAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.MessagePicturesLayout;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpaceItemDecoration;
import com.github.ielse.imagewatcher.ImageWatcherHelper;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 作者：linxi on 2018/10/19 09:45
 * 邮箱：707078566@qq.com
 * 用途：大咖推荐子Fragment
 */
public class RecommendItemFragment extends BaseFragment implements MessagePicturesLayout.Callback {
    @Bind(R.id.recommend_item_lv)
    RecyclerView mRecommendItemLv;
    @Bind(R.id.recommend_item_refresh)
    SmartRefreshLayout mRecommendItemRefresh;
    private ImageWatcherHelper iwHelper;

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_recommenditem;
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
        RecommendItemReclAdapter itemReclAdapter = new RecommendItemReclAdapter(getActivity());
        mRecommendItemLv.setAdapter(itemReclAdapter);
        itemReclAdapter.setPictureClickCallback(this);
    }

    public  RecommendItemFragment newInstance() {
        Bundle args = new Bundle();
        RecommendItemFragment fragment = new RecommendItemFragment();
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

    @Override
    public void onThumbPictureClick(ImageView i, SparseArray<ImageView> imageGroupList, List<Uri> urlList) {
        iwHelper.show(i, imageGroupList, urlList);
    }
}
