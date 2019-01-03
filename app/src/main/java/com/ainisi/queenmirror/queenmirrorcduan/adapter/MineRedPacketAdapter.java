package com.ainisi.queenmirror.queenmirrorcduan.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.bean.MineRedPacketRecprdBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by john on 2018/8/22.
 *
 * jl
 */

public class MineRedPacketAdapter extends BaseQuickAdapter<MineRedPacketRecprdBean.BodyBean.RedPacketRecordsBean,BaseViewHolder> {

    private final Context context;
    private List<MineRedPacketRecprdBean.BodyBean.RedPacketRecordsBean> data;
    String position;

    public MineRedPacketAdapter(int layoutResId, @Nullable List<MineRedPacketRecprdBean.BodyBean.RedPacketRecordsBean> data, Context context,String position) {
        super(layoutResId, data);
        this.data = data;
        this.context = context;
        this.position = position;
    }

    @Override
    protected void convert(BaseViewHolder helper, final MineRedPacketRecprdBean.BodyBean.RedPacketRecordsBean item) {

        helper.setText(R.id.tv_mine_red_packet_record_title,item.getRedPacketTitle())
                .setText(R.id.tv_red_packet_record_time,"有效期至："+item.getEndDate())
                .setText(R.id.tv_red_packet_record_money,item.getMoney())
                .setText(R.id.tv_red_packet_record_need,"满"+item.getUseRequire()+"可用")
                .setText(R.id.tv_red_packet_record_bottom,item.getUseRule());

        TextView tv_red_packet_mine_4 = helper.getView(R.id.tv_red_packet_mine_4);
        TextView tv_red_packet_record_money = helper.getView(R.id.tv_red_packet_record_money);
        TextView tv_red_packet_record_time = helper.getView(R.id.tv_red_packet_record_time);
        if(position.equals("2")){
            tv_red_packet_mine_4.setTextColor(context.getResources().getColor(R.color.alpha_55_black));
            tv_red_packet_record_money.setTextColor(context.getResources().getColor(R.color.alpha_55_black));
            tv_red_packet_record_time.setTextColor(context.getResources().getColor(R.color.alpha_55_black));
        }else{
            tv_red_packet_mine_4.setTextColor(context.getResources().getColor(R.color.third_login));
            tv_red_packet_record_money.setTextColor(context.getResources().getColor(R.color.third_login));
            tv_red_packet_record_time.setTextColor(context.getResources().getColor(R.color.third_login));
        }

        LinearLayout li_red_packet_bottom = helper.getView(R.id.li_red_packet_bottom);
        final TextView tv_red_packet_record_bottom = helper.getView(R.id.tv_red_packet_record_bottom);
        final ImageView iv_near_sort = helper.getView(R.id.iv_near_sort);
        li_red_packet_bottom.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onClick(View view) {
                if(tv_red_packet_record_bottom.getVisibility() == 0){
                    tv_red_packet_record_bottom.setVisibility(View.GONE);
                    iv_near_sort.setBackground(context.getResources().getDrawable(R.drawable.arrow_dwon_blue));
                }else{
                    tv_red_packet_record_bottom.setVisibility(View.VISIBLE);
                    iv_near_sort.setBackground(context.getResources().getDrawable(R.drawable.arrow_up_black));
                }
            }
        });
    }

    public void Clear() {
        data.clear();
        notifyDataSetChanged();
    }

    public void setmDate(List<MineRedPacketRecprdBean.BodyBean.RedPacketRecordsBean> data) {
        this.data = data;
        this.notifyDataSetChanged();
    }
}
