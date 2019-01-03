package com.ainisi.queenmirror.queenmirrorcduan.adapter;

import android.support.annotation.Nullable;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean.MessageListBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by jl on 2018/3/22.
 *
 * jl
 */

public class MessageListAdapter extends BaseQuickAdapter<MessageListBean,BaseViewHolder> {


    public MessageListAdapter(int layoutResId, @Nullable List<MessageListBean> data) {
        super(layoutResId, data);

    }

    @Override
    protected void convert(BaseViewHolder helper, MessageListBean item) {
           TextView order=helper.getView(R.id.tv_order);
           order.setText(item.getBody().getMessageListData().get(0).getEcSysMessage().getMessDetails());
    }
}
