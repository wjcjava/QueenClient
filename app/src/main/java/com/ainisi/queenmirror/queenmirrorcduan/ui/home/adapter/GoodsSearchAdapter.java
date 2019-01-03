package com.ainisi.queenmirror.queenmirrorcduan.ui.home.adapter;

import android.support.annotation.Nullable;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean.GoodsBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by john on 2018/6/1.
 */

public class GoodsSearchAdapter extends BaseQuickAdapter<GoodsBean.BodyBean.ActivityListDataBean, BaseViewHolder> {
    public GoodsSearchAdapter(int layoutResId, @Nullable List<GoodsBean.BodyBean.ActivityListDataBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, GoodsBean.BodyBean.ActivityListDataBean item) {
        helper.setText(R.id.tv_search_shopname, item.getEcGoodsBasic().getGoodsName());
        helper.setText(R.id.tv_search_shoptime, "服务时长-" + item.getEcGoodsBasic().getServiceTime());
    }
}
