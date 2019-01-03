package com.ainisi.queenmirror.queenmirrorcduan.adapter;

import android.support.annotation.Nullable;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.bean.MineRedPacketBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by john on 2018/8/23.
 *
 * jl
 */

public class PurchaseRedPacketAdapter extends BaseQuickAdapter<MineRedPacketBean.BodyBean.RedPacketsBean,BaseViewHolder> {

    List<MineRedPacketBean.BodyBean.RedPacketsBean> data;
    public PurchaseRedPacketAdapter(int layoutResId, @Nullable List<MineRedPacketBean.BodyBean.RedPacketsBean> data) {
        super(layoutResId, data);
        this.data = data;
    }

    @Override
    protected void convert(BaseViewHolder helper, MineRedPacketBean.BodyBean.RedPacketsBean item) {

        helper.setText(R.id.tv_red_packet_money,"-¥"+item.getMoney())
                .setText(R.id.tv_red_packet_title,item.getRedPacketTitle());
    }

    public void Clear(){
        data.clear();
        notifyDataSetChanged();
    }

    public void setmDate(List<MineRedPacketBean.BodyBean.RedPacketsBean> data) {
        this.data = data;
        this.notifyDataSetChanged();
    }
}
