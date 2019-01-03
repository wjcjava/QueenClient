package com.ainisi.queenmirror.queenmirrorcduan.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.bean.GoodsListBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.FullActivity;
import com.ainisi.queenmirror.queenmirrorcduan.utils.MD5;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.text.NumberFormat;
import java.util.List;

public class SearchGoodsAdapter extends BaseQuickAdapter<GoodsListBean.BodyBean.GoodsListDataBean, BaseViewHolder> {

    Context context;
    List<GoodsListBean.BodyBean.GoodsListDataBean> data;
    public SearchGoodsAdapter(Context context,int layoutResId, @Nullable List<GoodsListBean.BodyBean.GoodsListDataBean> data) {
        super(layoutResId, data);
        this.context = context;
        this.data = data;
    }

    public void Clear(){
        data.clear();
        notifyDataSetChanged();
    }

    public void setmDate(List<GoodsListBean.BodyBean.GoodsListDataBean> data) {
        this.data = data;
        this.notifyDataSetChanged();
    }

    @Override
    protected void convert(BaseViewHolder helper, final GoodsListBean.BodyBean.GoodsListDataBean item) {

        helper.setVisible(R.id.buy_workroom_only_one,true)
                .setVisible(R.id.tv_workroom_bean_number,true)
                .setVisible(R.id.tv_workroom_discount,true);

        NumberFormat nf = NumberFormat.getInstance();
        String price = nf.format(Double.parseDouble(item.getEcGoodsBasic().getSalesPrice()))+"";
        String price1 = nf.format(Double.parseDouble(item.getEcGoodsBasic().getMarketPrice()));

        helper.setText(R.id.tv_weorkroom_title,item.getEcGoodsBasic().getGoodsName())
                .setText(R.id.tv_weorkroom_name,item.getEcGoodsBasic().getGoodsBrief())
                .setText(R.id.tv_workroom_service_time,item.getEcGoodsBasic().getServiceTime())
                .setText(R.id.tv_price,"¥"+price)
                .setText(R.id.tv_workroom_service_price,"¥"+price1)
                .setVisible(R.id.iv_workroom_add_cat,false);

        if(item.getAnsShopBasic().getQueenCard() == null|| item.getAnsShopBasic().getQueenCard().equals("0")){
            helper.setGone(R.id.tv_workroom_discount,false);
        }else{
            String memberPrice = MD5.doubleToString(Double.parseDouble(item.getAnsShopBasic().getQueenShopDiscount())*Double.parseDouble(price)/10+"");
            helper.setText(R.id.tv_workroom_discount,"女王会员立减：¥"+MD5.doubleToString(Double.parseDouble(price)-Double.parseDouble(memberPrice)+""));
        }


        if(item.getEcGoodsBrowses()==null||item.getEcGoodsBrowses().getBrowseCounts()==null){
            helper. setText(R.id.tv_browse,"浏览0次");
        }else{
            helper.setText(R.id.tv_browse,"浏览"+item.getEcGoodsBrowses().getBrowseCounts()+"次");
        }

        String isPintuan = item.getEcGoodsBasic().getGroupGoods();
        if(isPintuan.equals("1")){
            helper.setVisible(R.id.iv_workroom_pintuan,true);
        }else{
            helper.setVisible(R.id.iv_workroom_pintuan,false);
        }

        if(item.getEcGoodsBasic().getBuyRule().equals("0")){
            helper.setGone(R.id.buy_workroom_only_one,false);
        }else{
            helper.setVisible(R.id.buy_workroom_only_one,true);
        }

        if(item.getEcGoodsBasic().getPointRule() == null||item.getEcGoodsBasic().getPointRule().equals("")){
            helper.setGone(R.id.tv_workroom_bean_number,false);
        }else{
            helper.setText(R.id.tv_workroom_bean_number,"另需支付魔豆："+ MD5.doubleToString(item.getEcGoodsBasic().getPointRule()));
        }


        TextView tv_workroom_service_price = helper.getView(R.id.tv_workroom_service_price);
        tv_workroom_service_price.getPaint().setFlags(Paint. STRIKE_THRU_TEXT_FLAG);

        ImageView iv_weorkroom_title = helper.getView(R.id.iv_weorkroom_title);
        if(item.getEcGoodsBasic() == null || item.getEcGoodsBasic().getGoodsThumb() == null){

        }else {
            String goods_thumb = item.getEcGoodsBasic().getGoodsThumb();
            if (goods_thumb.length() > 0) {
                String[] goodsLogo = goods_thumb.split(",");
                Glide.with(context).load(goodsLogo[0]).dontAnimate().placeholder(R.drawable.dismiss).into(iv_weorkroom_title);
            } else {

            }
        }

        helper.setOnClickListener(R.id.rl_workroom_list, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, FullActivity.class);
                intent.putExtra("goodsId",item.getEcGoodsBasic().getId());
                intent.putExtra("shopId",item.getEcGoodsBasic().getShopId());
                intent.putExtra("shopName",item.getShopIdName());
                intent.putExtra("shopLogo",item.getEcGoodsBasic().getGoodsThumb());
                if(item.getEcGoodsBrowses()==null||item.getEcGoodsBrowses().getBrowseCounts()==null){
                    intent.putExtra("number","0");
                }else{
                    intent.putExtra("number",item.getEcGoodsBrowses().getBrowseCounts());
                }
                context.startActivity(intent);
            }
        });

    }
}
