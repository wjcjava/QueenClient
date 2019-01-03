package com.ainisi.queenmirror.queenmirrorcduan.ui.home.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.FullActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean.GoodsBannerBean;
import com.ainisi.queenmirror.queenmirrorcduan.utils.MD5;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.text.NumberFormat;
import java.util.List;

/**
 * Created by john on 2018/6/16.
 *
 * jl
 */

public class GoodsBannerAdapter extends BaseQuickAdapter<GoodsBannerBean.BodyBean.BannerListDataBean, BaseViewHolder> {

    Context context;
    String isPintuan="";
    public GoodsBannerAdapter(Context context,int layoutResId, @Nullable List<GoodsBannerBean.BodyBean.BannerListDataBean> data) {
        super(layoutResId, data);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, final GoodsBannerBean.BodyBean.BannerListDataBean item) {

        String shoplogo = item.getEcGoodsBasic().getGoodsThumb();
        String[] shop_logo = shoplogo.split(",");
        Glide.with(mContext).load(shop_logo[0]).placeholder(R.drawable.dismiss).into((ImageView) helper.getView(R.id.iv_weorkroom_title));


        NumberFormat nf = NumberFormat.getInstance();
        String price = nf.format(Double.parseDouble(item.getEcGoodsBasic().getSalesPrice()))+"";
        String price1 = nf.format(Double.parseDouble(item.getEcGoodsBasic().getMarketPrice()))+"";

        if(item.getEcGoodsBrowses()==null||item.getEcGoodsBrowses().getBrowseCounts() == null){
            helper.setText(R.id.tv_browse,"浏览1次");
        }else{
            helper.setText(R.id.tv_browse,"浏览"+item.getEcGoodsBrowses().getBrowseCounts()+"次");
        }

        if(item.getEcGoodsBasic()==null||item.getEcGoodsBasic().getGroupGoods()==null){
            isPintuan = "0";
        }else {
            isPintuan = item.getEcGoodsBasic().getGroupGoods();
        }
        if(isPintuan.equals("1")){
            helper.setVisible(R.id.iv_workroom_pintuan,true);
        }else{
            helper.setVisible(R.id.iv_workroom_pintuan,false);
        }


        if(item.getEcGoodsBasic() == null||item.getEcGoodsBasic().getBuyRule()==null||item.getEcGoodsBasic().getBuyRule().equals("0")){
            helper.setVisible(R.id.buy_workroom_only_one,false);
        }else{
            helper.setVisible(R.id.buy_workroom_only_one,true);
        }

        if(item.getEcGoodsBasic().getPointRule() == null||item.getEcGoodsBasic().getPointRule().equals("")){
            helper.setVisible(R.id.tv_workroom_bean_number,false);
        }else{
            helper.setText(R.id.tv_workroom_bean_number,"另需支付魔豆："+ MD5.doubleToString(item.getEcGoodsBasic().getPointRule()));
        }
        helper.setText(R.id.tv_weorkroom_title,item.getEcGoodsBasic().getGoodsName())
                .setText(R.id.tv_weorkroom_name,item.getEcGoodsBasic().getGoodsBrief())
                .setText(R.id.tv_workroom_service_time,item.getEcGoodsBasic().getServiceTime()+"分钟")
                .setText(R.id.tv_price,"¥"+price)
                .setText(R.id.tv_workroom_service_price,"¥"+price1)
                .setVisible(R.id.iv_workroom_add_cat,false)
                .setOnClickListener(R.id.rl_workroom_list, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(context, FullActivity.class);
                        intent.putExtra("goodsId",item.getEcGoodsBasic().getId());
                        intent.putExtra("shopId",item.getEcGoodsBasic().getShopId());
                        intent.putExtra("shopName",item.getAnsShopBasic().getShopName());
                        intent.putExtra("shopLogo",item.getEcGoodsBasic().getGoodsThumb());
                        intent.putExtra("number",item.getEcGoodsBrowses().getBrowseCounts());
                        context.startActivity(intent);
                    }
                });
        TextView tv_workroom_service_price = helper.getView(R.id.tv_workroom_service_price);
        tv_workroom_service_price.getPaint().setFlags(Paint. STRIKE_THRU_TEXT_FLAG);
    }
}
