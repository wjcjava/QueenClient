package com.ainisi.queenmirror.queenmirrorcduan.adapter;

import android.support.annotation.Nullable;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean.CommendGoodBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by john on 2018/5/12.
 */

public class CommendGoodsAdapter extends BaseQuickAdapter<CommendGoodBean.BodyBean.ApiEcGoodsBasicListBean,BaseViewHolder> {

    public CommendGoodsAdapter(int layoutResId, @Nullable List<CommendGoodBean.BodyBean.ApiEcGoodsBasicListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, CommendGoodBean.BodyBean.ApiEcGoodsBasicListBean item) {
        helper.setText(R.id.tv_sort_name,item.getEcGoodsBasic().getGoodsName());
        helper.setText(R.id.tv_sort_time,item.getEcGoodsBasic().getUpdateDate());

    }

}
