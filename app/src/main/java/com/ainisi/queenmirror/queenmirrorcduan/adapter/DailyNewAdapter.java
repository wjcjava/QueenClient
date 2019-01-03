package com.ainisi.queenmirror.queenmirrorcduan.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.view.View;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.bean.DailyNewBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.shop.activity.WorkRoomDetailActivity;
import com.ainisi.queenmirror.queenmirrorcduan.utils.NoScrollGridView;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by john on 2018/9/14.
 *
 * jl
 */

public class DailyNewAdapter extends BaseQuickAdapter<DailyNewBean.BodyBean.NewShopAndGoodsListBean,BaseViewHolder> {
    Context context;

    public DailyNewAdapter(Context context,int layoutResId, @Nullable List<DailyNewBean.BodyBean.NewShopAndGoodsListBean> data) {
        super(layoutResId, data);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, final DailyNewBean.BodyBean.NewShopAndGoodsListBean item) {

        CircleImageView iv_dailynew_head = helper.getView(R.id.iv_dailynew_head);
        Glide.with(context).load(item.getAnsShopBasic().getShopLogo()).dontAnimate().into(iv_dailynew_head);

        helper.setText(R.id.tv_daily_new_name,item.getAnsShopBasic().getShopName());

        NoScrollGridView gv_dailynew_gridView = helper.getView(R.id.gv_dailynew_gridView);

        helper.setOnClickListener(R.id.li_dailynew_shop, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, WorkRoomDetailActivity.class);
                intent.putExtra("shopName",item.getAnsShopBasic().getShopName());
                intent.putExtra("shopId",  item.getAnsShopBasic().getId());
                intent.putExtra("cpCate","1");
                context.startActivity(intent);
            }
        });

        DailyNewGridViewAdapter dailyNewGridViewAdapter = new DailyNewGridViewAdapter(context,item.getApiEcGoodsBasic(),item.getAnsShopBasic().getShopName());
        gv_dailynew_gridView.setAdapter(dailyNewGridViewAdapter);

    }
}
