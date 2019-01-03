package com.ainisi.queenmirror.queenmirrorcduan.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.bean.OrderDetailBean;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

public class OrderDetailListAdapter extends BaseQuickAdapter<OrderDetailBean.BodyBean.ApiOrderShopBean.ApiDetailsOrderListBean,BaseViewHolder> {

    Context context;

    public OrderDetailListAdapter(Context context, int layoutResId, @Nullable List<OrderDetailBean.BodyBean.ApiOrderShopBean.ApiDetailsOrderListBean> data) {
        super(layoutResId, data);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, OrderDetailBean.BodyBean.ApiOrderShopBean.ApiDetailsOrderListBean item) {

        helper.setText(R.id.tv_order_detail_price,"¥"+item.getUnitPrice())
        .setText(R.id.tv_order_detail_name,item.getGoodsName())
        .setText(R.id.tv_order_detail_number,"X "+item.getPurchaseNumber());

        ImageView iv_order_detail_image = helper.getView(R.id.iv_order_detail_image);

        String logo = item.getGoodsThumb();
        Glide.with(context).load(logo).placeholder(R.drawable.dismiss).into(iv_order_detail_image);
    }
}
