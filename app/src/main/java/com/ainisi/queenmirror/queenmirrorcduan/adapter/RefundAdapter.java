package com.ainisi.queenmirror.queenmirrorcduan.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.ui.order.bean.RefundBean;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by john on 2018/5/12.
 *
 * jl
 */

public class RefundAdapter extends BaseQuickAdapter<RefundBean.BodyBean.ApiRefundListBean,BaseViewHolder> {

    Context context;

    public RefundAdapter(Context context,int layoutResId, @Nullable List<RefundBean.BodyBean.ApiRefundListBean> data) {
        super(layoutResId, data);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, final RefundBean.BodyBean.ApiRefundListBean item) {

        ImageView img_title = helper.getView(R.id.img_title);

        if(item.getShopLogo() ==null){

        }else {
            String shop_logo = item.getShopLogo();
            String[] shopLogo = shop_logo.split(",");
            Glide.with(context).load(shopLogo[0]).placeholder(R.drawable.dismiss).into(img_title);
        }

        helper.setText(R.id.tv_shangpin,item.getShopName())
                .setText(R.id.tv_head,"共"+item.getApiRefundGoodsList().size()+"个，商品实付")
                .setGone(R.id.li_sbmittrecycler_button,false);
        if(item.getAfterAmount() == null){
            helper.setText(R.id.tv_jiage,"¥0.00");
        }else{
            helper.setText(R.id.tv_jiage,"¥"+item.getAfterAmount());
        }

        if(item.getApiRefundGoodsList().size()>= 3){
            helper.setText(R.id.tv_taocan,item.getApiRefundGoodsList().get(0).getGoodsName())
                    .setText(R.id.textView19,"X"+item.getApiRefundGoodsList().get(0).getPurchaseNumber());
            helper.setText(R.id.tv_xijian,item.getApiRefundGoodsList().get(1).getGoodsName())
                    .setText(R.id.textView29,"X"+item.getApiRefundGoodsList().get(1).getPurchaseNumber())
                    .setText(R.id.tv_tangran,item.getApiRefundGoodsList().get(2).getGoodsName())
                    .setText(R.id.textView30,"X"+item.getApiRefundGoodsList().get(2).getPurchaseNumber());
        }else if(item.getApiRefundGoodsList().size() == 2){
            helper.setText(R.id.tv_taocan,item.getApiRefundGoodsList().get(0).getGoodsName())
                    .setText(R.id.textView19,"X"+item.getApiRefundGoodsList().get(0).getPurchaseNumber());
            helper.setText(R.id.tv_xijian,item.getApiRefundGoodsList().get(1).getGoodsName())
                    .setText(R.id.textView29,"X"+item.getApiRefundGoodsList().get(1).getPurchaseNumber());
            helper.setGone(R.id.tv_tangran,false)
                    .setGone(R.id.textView30,false);
        }else if(item.getApiRefundGoodsList().size() == 1){
            helper.setText(R.id.tv_taocan,item.getApiRefundGoodsList().get(0).getGoodsName())
                    .setText(R.id.textView19,"X"+item.getApiRefundGoodsList().get(0).getPurchaseNumber());
            helper.setGone(R.id.tv_tangran,false)
                    .setGone(R.id.textView30,false)
                    .setGone(R.id.tv_xijian,false)
                    .setGone(R.id.textView29,false);
        }

        helper.setGone(R.id.li_sbmittrecycler_button,false)
                .setText(R.id.tv_submit,item.getOrderStatus());

        helper.setOnClickListener(R.id.rl_orderlist_all, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              /*  Intent intent = new Intent(context, OrderDetailActivity.class);
                intent.putExtra("orderId",item.getOrderId());
                intent.putExtra("orderNo", item.get);

                if(item.getIntfAnsShopBasic() == null){
                    intent.putExtra("orderTel", "");
                }else{
                    intent.putExtra("orderTel", item.getIntfAnsShopBasic().getServiceTel());
                }
                intent.putExtra("orderTime", item.getIntfAnsOrder().getOrderTime());
                intent.putExtra("orderState",item.getIntfAnsOrder().getOrderStatus());
                if(item.getIntfAnsShopBasic() == null){
                    intent.putExtra("shopId", "");
                }else {
                    intent.putExtra("shopId", item.getIntfAnsShopBasic().getId());
                }
                if(item.getIntfAnsOrder().getCpAmount() == null||item.getIntfAnsOrder().getCpAmount().equals("")){
                    intent.putExtra("cpAmount","0.00");
                }else{
                    intent.putExtra("cpAmount",item.getIntfAnsOrder().getCpAmount());
                }
                intent.putExtra("OrderHeji", item.getIntfAnsOrder().getAfterAmount() + "");
                intent.putExtra("lstBean", (Serializable) item.getIntfAnsOrder().getApiOrderDetailsList());
                context.startActivity(intent);*/
            }
        });
    }
}
