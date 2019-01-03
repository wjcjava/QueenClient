package com.ainisi.queenmirror.queenmirrorcduan.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.bean.OrderMyAllOrderBean;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

public class ConfirmRefundAdapter extends BaseQuickAdapter<OrderMyAllOrderBean.BodyBean.ApiOrderListBean.IntfAnsOrderBean.ApiOrderDetailsListBean,BaseViewHolder> {

    Context context;

    public ConfirmRefundAdapter(Context context,int layoutResId, @Nullable List<OrderMyAllOrderBean.BodyBean.ApiOrderListBean.IntfAnsOrderBean.ApiOrderDetailsListBean> data) {
        super(layoutResId, data);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, OrderMyAllOrderBean.BodyBean.ApiOrderListBean.IntfAnsOrderBean.ApiOrderDetailsListBean item) {

        helper.setText(R.id.tv_shop_name,item.getIntfAnsOrderDetails().getGoodsName())
                .setText(R.id.tv_confirm_number,"X"+item.getIntfAnsOrderDetails().getPurchaseNumber())
                .setText(R.id.tv_confirm_price,"¥"+item.getIntfAnsOrderDetails().getUnitPrice());

        ImageView iv_shop = helper.getView(R.id.iv_shop);

        String good_logo = item.getIntfAnsOrderDetails().getGoodsThumb();
        String[] goodLogo = good_logo.split(",");
        Glide.with(context).load(goodLogo[0]).placeholder(R.drawable.dismiss).into(iv_shop);
    }
}
