package com.ainisi.queenmirror.queenmirrorcduan.adapter;

import android.support.annotation.Nullable;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.bean.NewsMessageSystemBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 *
 * jl
 */

public class MySystemMessageAdapter extends BaseQuickAdapter<NewsMessageSystemBean.BodyBean.MessListBean,BaseViewHolder> {

    List<NewsMessageSystemBean.BodyBean.MessListBean> data;
    public MySystemMessageAdapter(int layoutResId, @Nullable List<NewsMessageSystemBean.BodyBean.MessListBean> data) {
        super(layoutResId, data);
        this.data = data;
    }

    @Override
    protected void convert(BaseViewHolder helper, NewsMessageSystemBean.BodyBean.MessListBean item) {
        helper.setText(R.id.tv_message_content,item.getMessDetails())
                .setText(R.id.tv_message_time,item.getSendDate());
    }

    public void Clear(){
        data.clear();
        notifyDataSetChanged();
    }

    public void setmDate(List<NewsMessageSystemBean.BodyBean.MessListBean> data) {
        this.data = data;
        this.notifyDataSetChanged();
    }
}
