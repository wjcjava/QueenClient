package com.ainisi.queenmirror.queenmirrorcduan.adapter;

import android.support.annotation.Nullable;

import com.ainisi.queenmirror.queenmirrorcduan.bean.SortBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;


/**
 * Created by 王军超 on 2018/3/22.
 */

public class MyAdapter extends BaseQuickAdapter<SortBean, BaseViewHolder> {

    public MyAdapter(int layoutResId, @Nullable List<SortBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, SortBean item) {

    }

}
