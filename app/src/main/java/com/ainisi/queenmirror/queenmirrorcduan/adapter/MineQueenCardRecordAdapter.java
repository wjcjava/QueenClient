package com.ainisi.queenmirror.queenmirrorcduan.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.bean.MineQueenCardRecordBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by john on 2018/8/15.
 *
 * jl
 */

public class MineQueenCardRecordAdapter extends BaseQuickAdapter<MineQueenCardRecordBean.BodyBean.RecordsListBean,BaseViewHolder> {

    private final Context context;
    private List<MineQueenCardRecordBean.BodyBean.RecordsListBean> data;

    public MineQueenCardRecordAdapter(int layoutResId, @Nullable List<MineQueenCardRecordBean.BodyBean.RecordsListBean> data, Context context) {
        super(layoutResId, data);
        this.data = data;
        this.context=context;
    }

    @Override
    protected void convert(BaseViewHolder helper, final MineQueenCardRecordBean.BodyBean.RecordsListBean item) {
        helper.setText(R.id.tv_buyrecord_time,"创建时间："+item.getChargeDate());

        TextView tv_buyrecord_title = helper.getView(R.id.tv_buyrecord_title);

        if(item.getChargeTrans() == null||item.getChargeTrans().equals("")){
            tv_buyrecord_title.setText("赠送女王会员"+item.getGivenDays()+"天");
        }else{
            int purchaseDay = item.getPurchaseDays();
            int givenDays = item.getGivenDays();

            tv_buyrecord_title.setText("女王会员"+(purchaseDay+givenDays)+"天");
        }


        if(item.getChargeTrans() == null||item.getChargeTrans().equals("")){
            helper.setText(R.id.tv_buyrecord_type,item.getActivityType());
        }else{
            helper.setText(R.id.tv_buyrecord_type,item.getChargeAmount()+"");
        }
    }

    public void Clear(){
        data.clear();
        notifyDataSetChanged();
    }

    public void setmDate(List<MineQueenCardRecordBean.BodyBean.RecordsListBean> data) {
        this.data = data;
        this.notifyDataSetChanged();
    }
}
