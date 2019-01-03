package com.ainisi.queenmirror.queenmirrorcduan.adapter;

import android.content.Context;
import android.support.annotation.Nullable;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.bean.MineBeanByTimeBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by john on 2018/7/5.
 *
 * jl
 */

public class MineBeanByTimeItemAdapter extends BaseQuickAdapter<MineBeanByTimeBean.BodyBean.PointsRecordBean,BaseViewHolder> {

    List<MineBeanByTimeBean.BodyBean.PointsRecordBean> data;
    Context context;

    public MineBeanByTimeItemAdapter(Context context,int layoutResId, @Nullable List<MineBeanByTimeBean.BodyBean.PointsRecordBean> data) {
        super(layoutResId, data);
        this.data = data;
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, MineBeanByTimeBean.BodyBean.PointsRecordBean item) {

        String inout = item.getEcPointsRecords().getInOut();
        if(inout.equals("1")){

            helper.setText(R.id.iv_modou_bean_numbre,"+"+item.getEcPointsRecords().getChargePoints())
                    .setTextColor(R.id.iv_modou_bean_numbre,context.getResources().getColor(R.color.colorPri));
        }else if(inout.equals("2")){
            helper.setText(R.id.iv_modou_bean_numbre,"-"+item.getEcPointsRecords().getChargePoints())
                    .setTextColor(R.id.iv_modou_bean_numbre,context.getResources().getColor(R.color.alpha_90_black));
        }
        helper.setText(R.id.tv_modou_bean_time,item.getEcPointsRecords().getChargeDate())
                .setText(R.id.tv_modou_bean_title_category,item.getEcPointsRecords().getPointsBusinessName());
    }

    public void Clear(){
        data.clear();
        notifyDataSetChanged();
    }

    public void setmDate(List<MineBeanByTimeBean.BodyBean.PointsRecordBean> data) {
        this.data = data;
        this.notifyDataSetChanged();
    }

}
