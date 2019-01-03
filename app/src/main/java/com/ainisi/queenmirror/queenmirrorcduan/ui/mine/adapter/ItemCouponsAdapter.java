package com.ainisi.queenmirror.queenmirrorcduan.ui.mine.adapter;

import android.annotation.SuppressLint;
import android.support.annotation.Nullable;
import android.view.View;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.bean.PayPurchaseBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.PurchaseActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.PurchaseNowActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.PurchaseSelectActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.shop.bean.ReceiveDiscounBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by john on 2018/5/31.
 * jl
 *
 * 单品抵扣券
 *
 */

public class ItemCouponsAdapter extends BaseQuickAdapter<ReceiveDiscounBean.BodyBean.CustCouponListDataItemBean,BaseViewHolder> {

    private final int cpStatus;
    String purchaseNow,postion,isbean;

    public ItemCouponsAdapter(int layoutResId, @Nullable List<ReceiveDiscounBean.BodyBean.CustCouponListDataItemBean> data, int cpStatus,String purchaseNow,String postion,String isbean) {
        super(layoutResId, data);
        this.cpStatus=cpStatus;
        this.purchaseNow = purchaseNow;
        this.postion = postion;
        this.isbean = isbean;
    }

    @SuppressLint("ResourceAsColor")
    @Override
    protected void convert(BaseViewHolder helper, final ReceiveDiscounBean.BodyBean.CustCouponListDataItemBean item) {
        if(cpStatus==0){
        }else if(cpStatus==1){
            helper.setVisible(R.id.iv_minediscount,false);
        }else if(cpStatus==2){
            helper.setVisible(R.id.iv_minediscount,false);
            helper.setVisible(R.id.iv_overdued,true);
            helper.setBackgroundColor(R.id.relativeLayout,R.color.alpha_05_black);
        }
        helper.setText(R.id.tv_money,"¥"+item.getCpCreateInfo().getReduceAmount());
        helper.setText(R.id.tv_time,item.getCpCreateInfo().getUseFrom()+"-"+item.getCpCreateInfo().getUseTo());
        helper.setText(R.id.tv_purpose, item.getCpCreateInfo().getShopName())
                .setText(R.id.tv_discount, item.getCpCreateInfo().getCpName());

        helper.setOnClickListener(R.id.relativeLayout, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(purchaseNow.equals("list")){
                    PayPurchaseBean payPurchaseBean = new PayPurchaseBean();
                    payPurchaseBean.setCpId(item.getCpCreateInfo().getId());
                    if(isbean.equals("false")){
                        payPurchaseBean.setCpMethod("1");
                    }else{
                        payPurchaseBean.setCpMethod("1");
                    }
                    payPurchaseBean.setCpName("优惠金额¥"+item.getCpCreateInfo().getReduceAmount());
                    payPurchaseBean.setCpMoney(item.getCpCreateInfo().getReduceAmount());

                    PurchaseActivity.instance.payPurchaseBean = payPurchaseBean;
                    /**
                     * 这里的位置需要判断
                     */
                    PurchaseActivity.instance.addPurchaseData(Integer.parseInt(postion));

                    PurchaseSelectActivity.instance.finish();
                }else if(purchaseNow.equals("now")){
                    if(isbean.equals("false")){
                        PurchaseNowActivity.instance.cpMethod = "1";
                    }else{
                        PurchaseNowActivity.instance.cpMethod = "1";
                    }
                    PurchaseNowActivity.instance.cpId = item.getCpCreateInfo().getId()+"";
                    PurchaseNowActivity.instance.cp_money = item.getCpCreateInfo().getReduceAmount();
                    PurchaseNowActivity.instance.tv_pur_selectname.setText("优惠金额¥"+item.getCpCreateInfo().getReduceAmount());

                    PurchaseNowActivity.instance.ChangeMoney();
                    PurchaseSelectActivity.instance.finish();
                }
            }
        });
    }
}
