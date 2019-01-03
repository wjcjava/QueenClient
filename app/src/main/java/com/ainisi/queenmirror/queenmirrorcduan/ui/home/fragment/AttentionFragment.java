package com.ainisi.queenmirror.queenmirrorcduan.ui.home.fragment;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.widget.ImageView;

import com.ainisi.queenmirror.common.base.BaseFragment;
import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.ui.master.adapter.RecommendItemReclAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.MessagePicturesLayout;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpaceItemDecoration;
import com.ainisi.queenmirror.queenmirrorcduan.utils.GlideSimpleLoader;
import com.github.ielse.imagewatcher.ImageWatcher;
import com.github.ielse.imagewatcher.ImageWatcherHelper;
import com.google.zxing.WriterException;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.List;

import butterknife.Bind;

/**
 * 作者：linxi on 2018/10/18 17:16
 * 邮箱：707078566@qq.com
 * 用途：大咖关注
 */
public class AttentionFragment extends BaseFragment  implements HttpCallBack, ImageWatcherHelper.Provider, MessagePicturesLayout.Callback{
    @Bind(R.id.recommend_item_lv)
    RecyclerView mRecommendItemLv;
    @Bind(R.id.recommend_item_refresh)
    SmartRefreshLayout mRecommendItemRefresh;
    private ImageWatcherHelper iwHelper;
    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_attention;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void initView() {
        setImageLoader();
    }
    private void setImageLoader() {
        iwHelper = ImageWatcherHelper.with(getActivity(), new GlideSimpleLoader())
                .setErrorImageRes(R.mipmap.error_picture)
                .setOnPictureLongPressListener(new ImageWatcher.OnPictureLongPressListener() {
                    @Override
                    public void onPictureLongPress(ImageView imageView, Uri uri, int i) {

                    }
                });// 配置error图标 如果不介意使用lib自带的图标，并不一定要调用这个API;
    }
    @Override
    public void onThumbPictureClick(ImageView i, SparseArray<ImageView> imageGroupList, List<Uri> urlList) {
        iwHelper.show(i, imageGroupList, urlList);
    }

    @Override
    protected void doFitsrData() {
        mRecommendItemLv.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecommendItemLv.addItemDecoration(new SpaceItemDecoration(getActivity()).setSpace(1).setSpaceColor(0xFFF7F7F7));
        RecommendItemReclAdapter itemReclAdapter = new RecommendItemReclAdapter(getActivity());
        mRecommendItemLv.setAdapter(itemReclAdapter);
        itemReclAdapter.setPictureClickCallback(this);
    }
    public static AttentionFragment newInstance() {
        Bundle args = new Bundle();
        AttentionFragment fragment = new AttentionFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public ImageWatcherHelper iwHelper() {
        return iwHelper;
    }

    @Override
    public void onSuccess(int action, String res) throws WriterException {

    }

    @Override
    public void showLoadingDialog() {

    }

    @Override
    public void showErrorMessage(String s) {

    }

}
