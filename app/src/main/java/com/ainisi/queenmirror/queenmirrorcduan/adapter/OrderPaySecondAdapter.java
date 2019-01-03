package com.ainisi.queenmirror.queenmirrorcduan.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.bean.OrderPayBean;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by john on 2018/8/26.
 *
 * jl
 */

public class OrderPaySecondAdapter extends BaseQuickAdapter<OrderPayBean.BodyBean.PendingOrderListBean.ListBean,BaseViewHolder> {

    Context context;
    OrderPayThirdAdapter orderPayThirdAdapter;
    List<OrderPayBean.BodyBean.PendingOrderListBean.ListBean.AnsSubmitGoodsRecordListBean> list = new ArrayList<>();

    public OrderPaySecondAdapter(Context context,int layoutResId, @Nullable List<OrderPayBean.BodyBean.PendingOrderListBean.ListBean> data) {
        super(layoutResId, data);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, OrderPayBean.BodyBean.PendingOrderListBean.ListBean item) {

        helper.setText(R.id.tv_shangpin,item.getShopName());
        ImageView img_title = helper.getView(R.id.img_title);
        Glide.with(context).load(item.getShopLogo()).dontAnimate().into(img_title);
        list = item.getAnsSubmitGoodsRecordList();

        RecyclerView rv_orderpay_second_listitem = helper.getView(R.id.rv_orderpay_second_listitem);
        orderPayThirdAdapter = new OrderPayThirdAdapter(context, R.layout.order_pay_third_listitem, list);
        rv_orderpay_second_listitem.setLayoutManager(new LinearLayoutManager(context, LinearLayout.VERTICAL, false));
        rv_orderpay_second_listitem.setAdapter(orderPayThirdAdapter);

    }
}
