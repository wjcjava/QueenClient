package com.ainisi.queenmirror.queenmirrorcduan.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.bean.WorkTopListBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.FullActivity;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

public class ShopBaopinAdapter extends BaseQuickAdapter<WorkTopListBean.BodyBean.TopGoodsListBean,BaseViewHolder> {


    private Context context;
    public ShopBaopinAdapter(Context context, int layoutResId, @Nullable List<WorkTopListBean.BodyBean.TopGoodsListBean> data) {
        super(layoutResId, data);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, final WorkTopListBean.BodyBean.TopGoodsListBean item) {

        helper.setText(R.id.tv_commodity_name,item.getEcGoodsBasic().getGoodsName())
                .setText(R.id.tv_present_price,"¥"+item.getEcGoodsBasic().getSalesPrice())
                .setText(R.id.tv_present_market,"¥"+item.getEcGoodsBasic().getMarketPrice());

        helper.setText(R.id.tv_praise,item.getEcGoodsBrowses().getBrowseCounts()+"人浏览");
        TextView tv_present_market = helper.getView(R.id.tv_present_market);
        tv_present_market.getPaint().setFlags(Paint. STRIKE_THRU_TEXT_FLAG);

        if(item.getEcGoodsBasic() == null ||item.getEcGoodsBasic().getGoodsThumb() == null){

        }else {
            String shop_logo = item.getEcGoodsBasic().getGoodsThumb();
            String[] shopLogo = shop_logo.split(",");
            ImageView iv_commodity_picture = helper.getView(R.id.iv_commodity_picture);
            Glide.with(context).load(shopLogo[0]).placeholder(R.drawable.dismiss).into(iv_commodity_picture);
        }

        helper.setOnClickListener(R.id.li_workroom_like_detail, new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, FullActivity.class);
                intent.putExtra("goodsId",item.getEcGoodsBasic().getId());
                intent.putExtra("shopId",item.getEcGoodsBasic().getShopId());
                if(item.getShopIdName()==null){
                    intent.putExtra("shopName", "等待店家填写");
                }else {
                    intent.putExtra("shopName", item.getShopIdName());
                }
                intent.putExtra("number",item.getEcGoodsBrowses().getBrowseCounts());

                if(item.getEcGoodsBasic() == null ||item.getEcGoodsBasic().getGoodsThumb()==null){
                    intent.putExtra("shopLogo", "");
                }else {
                    String[] split = item.getEcGoodsBasic().getGoodsThumb().split(",");
                    intent.putExtra("shopLogo", split[0]);
                }

                context.startActivity(intent);
            }
        });

    }
}
