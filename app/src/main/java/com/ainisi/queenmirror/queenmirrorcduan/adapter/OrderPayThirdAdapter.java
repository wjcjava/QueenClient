package com.ainisi.queenmirror.queenmirrorcduan.adapter;

import android.content.Context;
import android.support.annotation.Nullable;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.bean.OrderPayBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 *
 * jl
 * Created by john on 2018/8/26.
 */

public class OrderPayThirdAdapter extends BaseQuickAdapter<OrderPayBean.BodyBean.PendingOrderListBean.ListBean.AnsSubmitGoodsRecordListBean,BaseViewHolder> {

    Context context;

    public OrderPayThirdAdapter(Context context,int layoutResId, @Nullable List<OrderPayBean.BodyBean.PendingOrderListBean.ListBean.AnsSubmitGoodsRecordListBean> data) {
        super(layoutResId, data);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, OrderPayBean.BodyBean.PendingOrderListBean.ListBean.AnsSubmitGoodsRecordListBean item) {
        helper.setText(R.id.tv_taocan,item.getGoodsName())
                .setText(R.id.textView19,"X"+item.getPurchaseNumber());
    }
}
