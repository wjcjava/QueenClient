package com.ainisi.queenmirror.queenmirrorcduan.ui.master.activity;

import android.net.Uri;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.widget.ImageView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
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

/***
 * 话题精选详情
 */
public class BigMasterTopicSelectionDetailActivity extends BaseNewActivity implements HttpCallBack, ImageWatcherHelper.Provider, MessagePicturesLayout.Callback{

    @Bind(R.id.recommend_item_lv)
    RecyclerView mRecommendItemLv;
    @Bind(R.id.recommend_item_refresh)
    SmartRefreshLayout mRecommendItemRefresh;
    private ImageWatcherHelper iwHelper;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_big_master_topic_selection_detail;
    }


    @Override
    protected void initData() {
        super.initData();
        mRecommendItemLv.setLayoutManager(new LinearLayoutManager(BigMasterTopicSelectionDetailActivity.this));
        mRecommendItemLv.addItemDecoration(new SpaceItemDecoration(BigMasterTopicSelectionDetailActivity.this).setSpace(1).setSpaceColor(0xFFF7F7F7));
        RecommendItemReclAdapter itemReclAdapter = new RecommendItemReclAdapter(BigMasterTopicSelectionDetailActivity.this);
        mRecommendItemLv.setAdapter(itemReclAdapter);
        itemReclAdapter.setPictureClickCallback(this);
    }

    @Override
    protected void initView() {
        super.initView();

        setImageLoader();
//        if (getActivity() instanceof ImageWatcherHelper.Provider) {
//            iwHelper = ((ImageWatcherHelper.Provider) getActivity()).iwHelper();
//        }
    }

    @Override
    public void onThumbPictureClick(ImageView i, SparseArray<ImageView> imageGroupList, List<Uri> urlList) {
        iwHelper.show(i, imageGroupList, urlList);
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


    @Override
    public void onBackPressed() {
        if (!iwHelper.handleBackPressed()) {
            super.onBackPressed();
        }
    }

    private void setImageLoader() {
        iwHelper = ImageWatcherHelper.with(this, new GlideSimpleLoader())
                .setErrorImageRes(R.mipmap.error_picture)
                .setOnPictureLongPressListener(new ImageWatcher.OnPictureLongPressListener() {
                    @Override
                    public void onPictureLongPress(ImageView imageView, Uri uri, int i) {

                    }
                });// 配置error图标 如果不介意使用lib自带的图标，并不一定要调用这个API;
    }
}
