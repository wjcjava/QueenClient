package com.ainisi.queenmirror.queenmirrorcduan.ui.mine.adapter;

import android.content.Context;
import android.support.annotation.Nullable;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.ui.mine.bean.TouchbalanceBean;
import com.ainisi.queenmirror.queenmirrorcduan.utils.MD5;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;
/**
 * Created by john on 2018/6/5.
 *
 * jl
 */
public class TouchAdapter extends BaseQuickAdapter<TouchbalanceBean.BodyBean.AccountChargeRecordsBean,BaseViewHolder> {

    Context context;
    List<TouchbalanceBean.BodyBean.AccountChargeRecordsBean> data;

    public TouchAdapter(Context context,int layoutResId, @Nullable List<TouchbalanceBean.BodyBean.AccountChargeRecordsBean> data) {
        super(layoutResId, data);
        this.context = context;
        this.data = data;
    }
    public void Clear(){
        data.clear();
        notifyDataSetChanged();
    }
    public void setmDate(List<TouchbalanceBean.BodyBean.AccountChargeRecordsBean> data) {
        this.data = data;
        this.notifyDataSetChanged();
    }
    @Override
    protected void convert(BaseViewHolder helper, TouchbalanceBean.BodyBean.AccountChargeRecordsBean item) {

        if(item.getRechargeConsume().equals("1")){
            helper.setTextColor(R.id.tv_queen_buy_buyno,context.getResources().getColor(R.color.alpha_85_black))
                    .setText(R.id.tv_queen_buy_buyno,"分润：+"+MD5.doubleToString(item.getChargeAmount()));
        }else if(item.getRechargeConsume().equals("2")){
            helper.setTextColor(R.id.tv_queen_buy_buyno,context.getResources().getColor(R.color.alpha_violet01))
                    .setText(R.id.tv_queen_buy_buyno,"收入：+"+ MD5.doubleToString(item.getChargeAmount()));
        }else if(item.getRechargeConsume().equals("3")){
            helper.setTextColor(R.id.tv_queen_buy_buyno,context.getResources().getColor(R.color.alpha_violet01))
                    .setText(R.id.tv_queen_buy_buyno,"提现：-"+ MD5.doubleToString(item.getChargeAmount()));
        }else if(item.getRechargeConsume().equals("4")){
            helper.setTextColor(R.id.tv_queen_buy_buyno,context.getResources().getColor(R.color.alpha_violet01))
                    .setText(R.id.tv_queen_buy_buyno,"退款：+"+ MD5.doubleToString(item.getChargeAmount()));
        }
        else if(item.getRechargeConsume().equals("5")){
            helper.setTextColor(R.id.tv_queen_buy_buyno,context.getResources().getColor(R.color.alpha_violet01))
                    .setText(R.id.tv_queen_buy_buyno,"消费：-"+ MD5.doubleToString(item.getChargeAmount()));
        }
        helper.setText(R.id.tv_queen_buy_number,(helper.getLayoutPosition()+1)+"")
                .setText(R.id.tv_queen_buy_getbean,item.getChargeAmount()+"")
                .setGone(R.id.tv_queen_buy_getbean,false)
                .setText(R.id.tv_queen_buy_time,item.getChargeDate());
    }
}