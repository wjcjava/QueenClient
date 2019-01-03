package com.ainisi.queenmirror.queenmirrorcduan.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.bean.HomeNewShopBean;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by john on 2018/6/15.
 *
 * jl
 */

public class HomeNewShopAdapter extends BaseQuickAdapter<HomeNewShopBean.BodyBean.NewShopListBean,BaseViewHolder> {


    public HomeNewShopAdapter(int layoutResId, @Nullable List<HomeNewShopBean.BodyBean.NewShopListBean> data) {
        super(layoutResId, data);

    }

    @Override
    protected void convert(BaseViewHolder helper, HomeNewShopBean.BodyBean.NewShopListBean item) {
        helper.setText(R.id.tv_commodity_name,item.getAnsShopBasic().getShopName());

        if(item.getAnsShopBasic().getQueenCard().equals("0")) {
            helper.setVisible(R.id.iv_homepage_queen,false);
        }else{
            helper.setVisible(R.id.iv_homepage_queen,true);
        }

        helper.setText(R.id.iv_queen,"营业时间："+item.getAnsShopBasic().getOpenTime()+"-"+item.getAnsShopBasic().getCloseTime());

        String shopLogo = item.getAnsShopBasic().getShopLogo();
        String[] shop_logo = shopLogo.split(",");
        Glide.with(mContext).load(shop_logo[0]).placeholder(R.drawable.dismiss).crossFade().into((ImageView) helper.getView(R.id.iv_commodity_picture));

    }
}
