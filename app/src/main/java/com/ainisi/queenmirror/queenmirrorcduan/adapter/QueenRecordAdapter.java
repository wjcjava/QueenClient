package com.ainisi.queenmirror.queenmirrorcduan.adapter;

import android.support.annotation.Nullable;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.bean.QueenPayRecordBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by john on 2018/7/6.
 *
 *  jl
 */

public class QueenRecordAdapter extends BaseQuickAdapter<QueenPayRecordBean.BodyBean.QueenChargeRecordsBean,BaseViewHolder> {


    public QueenRecordAdapter(int layoutResId, @Nullable List<QueenPayRecordBean.BodyBean.QueenChargeRecordsBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, QueenPayRecordBean.BodyBean.QueenChargeRecordsBean item) {

        if(item.getRechargeConsume().equals("1")){
            helper.setText(R.id.tv_queen_buy_number,(helper.getLayoutPosition()+1)+"")
                    .setText(R.id.tv_queen_buy_buyno,item.getChargeAmount()+"")
                    .setText(R.id.tv_queen_buy_getbean,item.getGiftAmount()+"")
                    .setText(R.id.tv_queen_buy_time,item.getChargeDate());
        }else{
            helper.setGone(R.id.li_queen_buy_record,false);
        }
    }
}