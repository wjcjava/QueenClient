package com.ainisi.queenmirror.queenmirrorcduan.ui.shop.adapter;

import android.support.annotation.Nullable;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.ui.shop.bean.ShopListBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by john on 2018/6/8.
 */

public class ShopListAdapter extends BaseQuickAdapter<ShopListBean.BodyBean.ApiGoodsListBean,BaseViewHolder> {
    public ShopListAdapter(int layoutResId, @Nullable List<ShopListBean.BodyBean.ApiGoodsListBean> data) {
        super(layoutResId, data);

    }

    @Override
    protected void convert(BaseViewHolder helper, ShopListBean.BodyBean.ApiGoodsListBean item) {
        helper.setText(R.id.tv_shopName,item.getEcGoodsBasic().getGoodsName());
        helper.setText(R.id.tv_shop_introduce,item.getEcGoodsBasic().getGoodsBrief());
    }
}
