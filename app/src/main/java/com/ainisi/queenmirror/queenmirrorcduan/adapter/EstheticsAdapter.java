package com.ainisi.queenmirror.queenmirrorcduan.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.bean.EstheticsBean;
import com.ainisi.queenmirror.queenmirrorcduan.utils.CustomRatingBar;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

public class EstheticsAdapter extends BaseQuickAdapter<EstheticsBean.BodyBean.ShopListBean, BaseViewHolder> {

    Context context;

    public EstheticsAdapter(Context context, int layoutResId, @Nullable List<EstheticsBean.BodyBean.ShopListBean> data) {
        super(layoutResId, data);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, EstheticsBean.BodyBean.ShopListBean item) {
        RelativeLayout rl_top_rl = helper.getView(R.id.rl_top_rl);
        LinearLayout rl_top_rl2 = helper.getView(R.id.rl_top_rl2);
        if (item.getAnsShopBasic() != null) {
            rl_top_rl.setVisibility(View.VISIBLE);
            rl_top_rl2.setVisibility(View.GONE);
            String shop_logo = item.getAnsShopBasic().getShopLogo();
            String[] shopLogo = shop_logo.split(",");
            ImageView iv_homepage_shop = helper.getView(R.id.iv_homepage_shop);
            Glide.with(context).load(shopLogo[0]).placeholder(R.drawable.dismiss).into(iv_homepage_shop);
            helper.setText(R.id.tv_shopName, item.getAnsShopBasic().getShopName())
                    .setText(R.id.tv_shop_time, "营业时间" + item.getAnsShopBasic().getOpenTime() + "-" + item.getAnsShopBasic().getCloseTime());
            String comRate = "3.5";
            if (item.getComScore() == null || item.getComScore().equals("") || item.getComScore().equals("0.0")) {
                comRate = "3.5";
            } else {
                comRate = item.getComScore();
            }
            CustomRatingBar iv_xingxing = helper.getView(R.id.iv_xingxing);
            iv_xingxing.setRating(Float.parseFloat(comRate));
        } else {
            rl_top_rl.setVisibility(View.GONE);
            rl_top_rl2.setVisibility(View.VISIBLE);
        }
    }
}