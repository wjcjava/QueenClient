package com.ainisi.queenmirror.queenmirrorcduan.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.FullTwoActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean.CommendGoodBean;
import com.ainisi.queenmirror.queenmirrorcduan.utils.MD5;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by john on 2018/5/12.
 *
 * jl
 *
 */

public class FullGoodsAdapter extends BaseQuickAdapter<CommendGoodBean.BodyBean.ApiEcGoodsBasicListBean,BaseViewHolder> {

    Context context;

    public FullGoodsAdapter(Context context,int layoutResId, @Nullable List<CommendGoodBean.BodyBean.ApiEcGoodsBasicListBean> data) {
        super(layoutResId, data);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, final CommendGoodBean.BodyBean.ApiEcGoodsBasicListBean item) {
        helper.setText(R.id.sote_name,item.getEcGoodsBasic().getGoodsName())
                .setText(R.id.tv_full_introduction,item.getEcGoodsBasic().getShopName())
                .setText(R.id.sort_time,"¥"+MD5.doubleToString(item.getEcGoodsBasic().getSalesPrice()))
                .setText(R.id.tv_goods_market,"¥"+ MD5.doubleToString(item.getEcGoodsBasic().getMarketPrice()));

        TextView tv_goods_market = helper.getView(R.id.tv_goods_market);
        tv_goods_market.getPaint().setFlags(Paint. STRIKE_THRU_TEXT_FLAG);

        ImageView iv_shop_title = helper.getView(R.id.iv_shop_title);
        String goods_logo = item.getEcGoodsBasic().getGoodsThumb();
        String[] goodsLogo = goods_logo.split(",");
        Glide.with(context).load(goodsLogo[0]).placeholder(R.drawable.dismiss).into(iv_shop_title);
        String praiseRate;
        if(item.getPraiseRate() == null||item.getPraiseRate().equals("")){
            praiseRate = "1";
        }else {
            praiseRate = item.getPraiseRate();
        }
        double rate = Double.parseDouble(praiseRate)*100;
        helper.setText(R.id.tv_full_evaluate,"好评率："+rate+"%");

        helper.setOnClickListener(R.id.rl_full_bottom, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, FullTwoActivity.class);
                intent.putExtra("goodsId",item.getEcGoodsBasic().getId());
                intent.putExtra("shopId",item.getEcGoodsBasic().getShopId());
                if(item.getShopIdName()==null){
                    intent.putExtra("shopName", "店铺名字");
                }else {
                    intent.putExtra("shopName", item.getEcGoodsBasic().getShopName());
                }
                if(item.getEcGoodsBrowses() == null){
                    intent.putExtra("number","1");
                }else if(item.getEcGoodsBrowses().getBrowseCounts() == null){
                    intent.putExtra("number","1");
                }else{
                    intent.putExtra("number",item.getEcGoodsBrowses().getBrowseCounts());
                }
                String[] split = item.getEcGoodsBasic().getGoodsThumb().split(",");
                intent.putExtra("shopLogo",split[0]);

                context.startActivity(intent);
            }
        });
    }
}
